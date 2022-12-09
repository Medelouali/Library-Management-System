package com.example.libraryapp.dao.db;

import com.example.libraryapp.dao.Envar;

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

    Envar env = new Envar();
    public ConnectionDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            this.connection = DriverManager.getConnection("jdbc:"+env.con+"://"+env.host+":"+env.port+"/"+env.db+"?useSSL=false&allowPublicKeyRetrieval=true", env.user, env.pwd);
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lib?useSSL=false&allowPublicKeyRetrieval=true", "debian-sys-maint", "ScZ1GuNlUrQC5f36");


            System.out.println("Connection OK");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
