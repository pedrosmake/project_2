package org.example.daos;

import org.example.models.Project;
import org.example.models.ProjectRequest;
import org.example.models.ProjectStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProjectDao {
    public Project getProjectByID(int id) throws SQLException {
        try(Connection connection = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM Project WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                return new Project(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("value"),
                        ProjectStatus.valueOf(resultSet.getString("status")),
                        resultSet.getInt("client_id"),
                        resultSet.getInt("techlead_id")
                );
            }
        }
        return null;
    }

    public int createProject(final ProjectRequest projectRequest) throws SQLException {
        Connection c = DatabaseConnector.getConnection();

        String insertStatement = "INSERT INTO Project (name, value, status, client_id, techlead_id) VALUES (?,?,?,?,?)";

        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        st.setString(1, projectRequest.getName());
        st.setDouble(2, projectRequest.getValue());
        st.setString(3, projectRequest.getStatus().toString());
        st.setInt(4, projectRequest.getClientId());
        st.setInt(5, projectRequest.getTechleadId());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }

    public void updateProject(int id, ProjectStatus status)
            throws SQLException {
        Connection c = DatabaseConnector.getConnection();

        String updateStatement = "UPDATE Project SET Status = ? WHERE id = ?";

        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setString(1, String.valueOf(status));
        st.setInt(2, id);

        st.executeUpdate();
    }
}
