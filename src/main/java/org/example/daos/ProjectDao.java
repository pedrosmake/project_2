package org.example.daos;

import org.example.models.ProjectRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProjectDao {
    public int createProject(final ProjectRequest projectRequest) throws SQLException {
        Connection c = DatabaseConnector.getConnection();

        String insertStatement = "INSERT INTO Project (Name, Value, Status, Client_id, Techlead_id) VALUES (?,?,?,?,?)";

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
}
