package com.example.libraryapp.models;

public class Transaction {
    private String adminName;
    private String bookTitle;
    private String timeStamp;
    private String studentName;
    private String studentCin;
    private String bookCoverPath;

    public Transaction(String adminName, String bookName, String timeStamp, String studentName, String getStudentCin, String bookCoverPath) {
        this.adminName = adminName;
        this.bookTitle = bookName;
        this.timeStamp = timeStamp;
        this.studentName = studentName;
        this.studentCin = getStudentCin;
        this.bookCoverPath = bookCoverPath;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentCin() {
        return studentCin;
    }

    public String getBookCoverPath() {
        return bookCoverPath;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentCin(String studentCin) {
        this.studentCin = studentCin;
    }

    public void setBookCoverPath(String bookCoverPath) {
        this.bookCoverPath = bookCoverPath;
    }
}
