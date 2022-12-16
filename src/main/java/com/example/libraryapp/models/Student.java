package com.example.libraryapp.models;

import java.sql.Date;

public class Student {
    public final static long maxBorrowedBooks = 10;
    private long id;

    private String Imgsrc;

    private String intro;

    private String username;
    private String email;
    private String password;
    private String cin;
    private Date timeStamp;
    private String description;
    public long booksNumber;

    private int privileges;

    private int isFlagged=0;

    public Student(){}
    public Student(String username, String cin, long booksNumber) {
        this.username = username;
        this.cin = cin;
        this.booksNumber = booksNumber;
    }

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

    public Student(long id, String username, String email, String password, String cin, Date timeStamp, String description, long booksNumber, int privileges, int isFlagged) {

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
    public Student(long id, String username, int privileges) {
        this.id = id;
        this.username = username;
        this.privileges = privileges;
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




    public int getIsFlagged() {
        return isFlagged;
    }
    public int getPrivileges() {
        return privileges;
    }


    public void setImgsrc(String imgsrc) {
        Imgsrc = imgsrc;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIntro() {
        return intro;
    }

    public String getImgsrc() {
        return Imgsrc;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", Imgsrc='" + Imgsrc + '\'' +
                ", intro='" + intro + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cin='" + cin + '\'' +
                ", timeStamp=" + timeStamp +
                ", description='" + description + '\'' +
                ", booksNumber=" + booksNumber +
                ", privileges=" + privileges +
                ", isFlagged=" + isFlagged +
                '}';
    }
}
