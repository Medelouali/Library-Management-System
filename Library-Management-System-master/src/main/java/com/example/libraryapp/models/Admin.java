package com.example.libraryapp.models;

import java.sql.Date;

public class Admin extends Student {

    public Admin(long id, String username, String email, String password, String cin, Date timeStamp, String description, long booksNumber, String privileges, boolean isFlagged) {
        super(id, username, email, password, cin, timeStamp, description, booksNumber, privileges, isFlagged);
        //we'll add some code later
    }

}
