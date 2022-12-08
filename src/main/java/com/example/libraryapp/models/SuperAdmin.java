package com.example.libraryapp.models;

import java.sql.Date;

public class SuperAdmin extends Admin{
    public SuperAdmin(long id, String username, String email, String password, String cin, Date timeStamp, String description, long booksNumber, String privileges, boolean isFlagged) {
        super(id, username, email, password, cin, timeStamp, description, booksNumber, privileges, isFlagged);
    }
}
