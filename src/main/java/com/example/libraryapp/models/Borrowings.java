package com.example.libraryapp.models;

public class Borrowings {
    private long id;
    private long copyId;
    private long studentId;
    private long adminId;
    private String borrowingDate;
    private String returnDate;
<<<<<<< HEAD

    private String bookIsbn;
    private String studentCin;



=======


>>>>>>> nikrbranch
    public Borrowings(long id, long copyId, long studentId, long adminId, String borrowingDate, String returnDate) {
        this.id = id;
        this.copyId = copyId;
        this.studentId = studentId;
        this.adminId = adminId;
        this.borrowingDate = borrowingDate;
        this.returnDate = returnDate;
    }


    public Borrowings(String borrowingDate, String returnDate, String bookIsbn, String studentCin) {
        this.borrowingDate = borrowingDate;
        this.returnDate = returnDate;
        this.bookIsbn = bookIsbn;
        this.studentCin = studentCin;
    }

<<<<<<< HEAD
=======
    public long getCopyId() {
        return copyId;
    }

    public long getStudentId() {
        return studentId;
    }

    public long getAdminId() {
        return adminId;
    }

>>>>>>> nikrbranch
    public String getBorrowingDate() {
        return borrowingDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public String getStudentCin() {
        return studentCin;
    }
}
