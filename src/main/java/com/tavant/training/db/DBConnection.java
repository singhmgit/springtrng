package com.tavant.training.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created on 21-08-2015.
 */
public class DBConnection {

    private String host = "localhost";

    public DBConnection(String host) {
        this.host = host;
    }

    public String getName(Integer id) {
        try (Connection conn =
                     DriverManager.getConnection("jdbc:mysql://" + host + "/training?" +
                             "user=root&password=welcome")) {
            String query = "select * from user where id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getString(2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void updateRecord(Integer id, String name) {
        try (Connection conn =
                     DriverManager.getConnection("jdbc:mysql://" + host + "/training?" +
                             "user=root&password=welcome")) {
            String query = "update user set name=? where id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
