package org.example.daos;

import org.example.models.Client;
import org.example.models.ClientWithDetails;
import org.example.models.TopClient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {
    public List<Client> getAllClients() throws SQLException {
        List<Client> clients = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, name, address, phone_number, "
                            + "create_date, acquired_by FROM Client;");

            while (resultSet.next()) {
                Client client = new Client(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("phone_number"),
                        resultSet.getDate("create_date"),
                        resultSet.getInt("acquired_by")
                );

                clients.add(client);
            }
        }
        return clients;
    }

    public List<ClientWithDetails> getAllClientsWithDetails() throws SQLException {
        List<ClientWithDetails> clientsWithDetails = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT c.id, c.name, e.name AS `sales_employee`, "
                            + "GROUP_CONCAT(p.name SEPARATOR ', ') AS `projects`\n"
                            + "FROM Client c\n"
                            + "INNER JOIN Employee e ON c.acquired_by=e.id\n"
                            + "LEFT JOIN Project p ON c.id=p.client_id\n"
                            + "GROUP BY c.id;");

            while (resultSet.next()) {
                ClientWithDetails clientWithDetails = new ClientWithDetails(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("sales_employee"),
                        resultSet.getString("projects")
                );

                clientsWithDetails.add(clientWithDetails);
            }
        }
        return clientsWithDetails;
    }


    public TopClient getTopClient() throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT c.Name as `Name`, SUM(p.value) AS `Value` \n"
                            + "FROM Project p\n"
                            + "JOIN Client c ON p.client_id=c.id\n"
                            + "GROUP BY c.Name\n"
                            + "ORDER BY sum(p.value)\n"
                            + "DESC LIMIT 1;"
            );

            while (resultSet.next()) {
                return new TopClient(
                        resultSet.getString("Name"),
                        resultSet.getDouble("Value")
                );
            }
        }
        return null;


    }
}
