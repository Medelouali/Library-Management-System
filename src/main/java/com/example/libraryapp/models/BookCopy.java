package com.example.libraryapp.models;

import java.sql.Date;

public class BookCopy {
    private long id;
    private long book_id;
    private String state;
    private boolean availability;

    public BookCopy(long id, long book_id, String state, boolean availability) {
        this.id = id;
        this.book_id = book_id;
        this.state = state;
        this.availability = availability;
    }


    public long getId() {
        return id;
    }

    public long getBook_id() {
        return book_id;
    }

    public String getState() {
        return state;
    }

    public boolean isAvailability() {
        return availability;
    }
}
