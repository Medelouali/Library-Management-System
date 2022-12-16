package com.example.libraryapp.models;

import java.sql.Date;

public class SuperAdmin extends Admin{
    public SuperAdmin(long id, String username, String email, String password, String cin, Date timeStamp, String description, long booksNumber, int privileges, int isFlagged) {
        super(id, username, email, password, cin, timeStamp, description, booksNumber, privileges, isFlagged);
    }
    public SuperAdmin(String username, String email, String password, String cin, String description) {
        super(username, email, password, cin, description);
    }

}
