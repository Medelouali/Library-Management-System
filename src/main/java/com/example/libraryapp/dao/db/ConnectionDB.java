package com.example.libraryapp.dao.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private Connection connection;

    public Connection getCon() {
        return connection;
    }

    public void setCon(Connection connection) {
        this.connection = connection;
    }

    public ConnectionDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?useSSL=false&allowPublicKeyRetrieval=true", "debian-sys-maint", "ScZ1GuNlUrQC5f36");
            System.out.println("Connection OK");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
