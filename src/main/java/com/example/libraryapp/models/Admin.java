package com.example.libraryapp.models;

public class Admin extends Student {

    public Admin(String username, String email, String password, String cin, String description) {
        super(username, email, password, cin, description);
        //we'll add some code later
    }

    public Admin(String email, String password) {
        super(email, password);
        //we'll add some code later
    }


}
