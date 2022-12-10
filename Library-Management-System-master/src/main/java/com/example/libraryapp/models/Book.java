package com.example.libraryapp.models;

public class Book {
    private long id;

    String ImgSrc;

    String datePub;

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

//    public Book(long id, String title, String authorName, String genre, String edition, String isbn, long stars, String language, boolean isDeleted, long copiesNumber, long pagesNumber) {
//        this.id = id;
//        this.title = title;
//        this.authorName = authorName;
//        this.genre = genre;
//        this.edition = edition;
//        this.isbn = isbn;
//        this.stars = stars;
//        this.language = language;
//        this.isDeleted = isDeleted;
//        this.copiesNumber = copiesNumber;
//        this.pagesNumber=pagesNumber;
//    }


    public String getImgSrc() {
        return ImgSrc;
    }

    public String getDatePub() {
        return datePub;
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

    public void setImgSrc(String imgSrc) {
        ImgSrc = imgSrc;
    }

    public void setDatePub(String datePub) {
        this.datePub = datePub;
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
}
