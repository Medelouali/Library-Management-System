package com.example.libraryapp.models;

import java.sql.Date;
import java.util.List;

public class Student {
    public final static long maxBorrowedBooks = 10;
    private long id;
    private String username;
    private String email;
    private String password;
    private String cin;
    private Date timeStamp;
    private String description;
    public long booksNumber;
    private String privileges;

    private boolean isFlagged;

    public Student(long id, String username, String email, String password, String cin, Date timeStamp, String description, long booksNumber, String privileges, boolean isFlagged) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.cin = cin;
        this.timeStamp = timeStamp;
        this.description = description;
        this.booksNumber = booksNumber;
        this.privileges = privileges;
        this.isFlagged = isFlagged;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCin() {
        return cin;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getDescription() {
        return description;
    }

    public long getBooksNumber() {
        return booksNumber;
    }

    public String getPrivileges() {
        return privileges;
    }

    public boolean isFlagged() {
        return isFlagged;
    }
}
