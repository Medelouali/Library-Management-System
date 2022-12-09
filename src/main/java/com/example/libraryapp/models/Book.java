package com.example.libraryapp.models;

public class Book {
    private String imgSrc;
    private long id;
    private String title;

    private String authorName;
    private String genre;
    private String edition;
    private String isbn;
    private long stars;
    private String language;
    private boolean isDeleted;
    private long copiesNumber;
    private long pagesNumber;
    private String datePub;

    public String getDatePub() {
        return datePub;
    }

    public String getImgSrc(){
        return this.imgSrc;
    }
    public Book(){
        //default
    }
    public Book(long id, String title, String authorName, String genre, String edition, String isbn, long stars, String language, boolean isDeleted, long copiesNumber, long pagesNumber) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.genre = genre;
        this.edition = edition;
        this.isbn = isbn;
        this.stars = stars;
        this.language = language;
        this.isDeleted = isDeleted;
        this.copiesNumber = copiesNumber;
        this.pagesNumber=pagesNumber;
    }

    public Book(long id, String title, long copiesNumber) {
        this.id = id;
        this.title = title;
        this.copiesNumber = copiesNumber;

    }


    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getGenre() {
        return genre;
    }

    public String getEdition() {
        return edition;
    }

    public String getIsbn() {
        return isbn;
    }

    public long getStars() {
        return stars;
    }

    public String getLanguage() {
        return language;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public long getCopiesNumber() {
        return copiesNumber;
    }

    public long getPagesNumber() {
        return pagesNumber;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setStars(long stars) {
        this.stars = stars;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public void setCopiesNumber(long copiesNumber) {
        this.copiesNumber = copiesNumber;
    }

    public void setPagesNumber(long pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public void setDatePub(String datePub) {
        this.datePub = datePub;
    }
}
