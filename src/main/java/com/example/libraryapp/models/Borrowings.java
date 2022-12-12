package com.example.libraryapp.models;

import java.sql.Date;

public class Borrowings {
    private long id;
    private long copyId;
    private long studentId;
    private long adminId;
    private String borrowingDate;
    private String returnDate;


    public Borrowings(long id, long copyId, long studentId, long adminId, String borrowingDate, String returnDate) {
        this.id = id;
        this.copyId = copyId;
        this.studentId = studentId;
        this.adminId = adminId;
        this.borrowingDate = borrowingDate;
        this.returnDate = returnDate;
    }

    public long getId() {
        return id;
    }

    public long getCopyId() {
        return copyId;
    }

    public long getStudentId() {
        return studentId;
    }

    public long getAdminId() {
        return adminId;
    }

    public String getBorrowingDate() {
        return borrowingDate;
    }

    public String getReturnDate() {
        return returnDate;
    }
}
