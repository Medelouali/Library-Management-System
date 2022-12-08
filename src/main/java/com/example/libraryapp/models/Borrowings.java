package com.example.libraryapp.models;

import java.sql.Date;

public class Borrowings {
    private long id;
    private long copyId;
    private long studentId;
    private long adminId;
    private Date borrowingDate;
    private Date returnDate;


    public Borrowings(long id, long copyId, long studentId, long adminId, Date borrowingDate, Date returnDate) {
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

    public Date getBorrowingDate() {
        return borrowingDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }
}
