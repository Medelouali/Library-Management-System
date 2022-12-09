package com.example.libraryapp.dao;

import io.github.cdimascio.dotenv.Dotenv;
public class Envar {
    Dotenv dotenv = Dotenv.configure().load();
    public String con = dotenv.get("DB_CONNECTION");
    public String host= dotenv.get("DB_HOST");
    public String port= dotenv.get("DB_PORT");
    public String db= dotenv.get("DB_DATABASE");
    public String user= dotenv.get("DB_USERNAME");
    public String pwd= dotenv.get("DB_PASSWORD");
}
