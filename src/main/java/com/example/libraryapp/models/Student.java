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
    private int privileges;

    private int isFlagged=0;

    public Student(String username, String email, String password, String cin, String description) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.cin = cin;
        this.description = description;
    }
    public Student(String email, String password)
    {
        this.email=email;
        this.password= password;
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

    public int getPrivileges() {
        return privileges;
    }

    public int getIsFlagged() {
        return isFlagged;
    }
}
