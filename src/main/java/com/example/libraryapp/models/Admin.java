package com.example.libraryapp.models;

import java.sql.Date;

public class Admin extends Student {

    public Admin(long id, String username, String email, String password, String cin, Date timeStamp, String description, long booksNumber, int privileges, int isFlagged) {
        super(id, username, email, password, cin, timeStamp, description, booksNumber, privileges, isFlagged);
        //we'll add some code later
    }
    public Admin(String username, String email, String password, String cin, String description) {
        super(username, email, password, cin, description);
        //we'll add some code later
    }
    public Admin(String email, String password) {
        super(email, password);
        //we'll add some code later
    }

    public Admin() {
    }

    public Admin(long id, String username, int privileges) {
        super(id, username, privileges);
    }
}
