package com.example.libraryapp.models;

import java.sql.Date;

public class BookCopy {
    private long id;
    private String state;
    private boolean isAvailable;
    private long studentId;
    private Date borrowingDate;
    private Date returnDate;

    public BookCopy(long id, String state, boolean isAvailable, long studentId, Date borrowingDate, Date returnDate) {
        this.id = id;
        this.state = state;
        this.isAvailable = isAvailable;
        this.studentId = studentId;
        this.borrowingDate = borrowingDate;
        this.returnDate = returnDate;
    }

    public long getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public long getStudentId() {
        return studentId;
    }

    public Date getBorrowingDate() {
        return borrowingDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }
}
