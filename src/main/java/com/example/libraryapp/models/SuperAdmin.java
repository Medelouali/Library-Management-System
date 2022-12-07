package com.example.libraryapp.models;

import java.sql.Date;

public class SuperAdmin extends Admin{
    public SuperAdmin(String username, String email, String password, String cin, String description) {
        super(username, email, password, cin, description);
    }
}
