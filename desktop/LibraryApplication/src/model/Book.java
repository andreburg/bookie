/*
 * This Class will be the model for Books 
 */
package model;

import java.util.Date;

public class Book {
    private int id;
    private String title;
    private String genre;
    private String isbn;    
    private boolean isAvailable;
    private Date lastBorrowed; // Null or Date 
    private Date dateReturned; // Null or Date 
    private int borrowerID; // 0 or Int

    // Constructor
    public Book(int id, String title, String genre, String isbn, boolean isAvailable, Date lastBorrowed, Date dateReturned, int borrowerID) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.isbn = isbn;    
        this.isAvailable = isAvailable;
        this.lastBorrowed = lastBorrowed;
        this.dateReturned = dateReturned;
        this.borrowerID = borrowerID;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getBorrowerID() {
        return borrowerID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Date getLastBorrowed() {
        return lastBorrowed;
    }

    public Date getDateReturned() {
        return dateReturned;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setBorrowerID(int borrowerID) {
        this.borrowerID = borrowerID;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setLastBorrowed(Date lastBorrowed) {
        this.lastBorrowed = lastBorrowed;
    }

    public void setDateReturned(Date dateReturned) {
        this.dateReturned = dateReturned;
    }
    
    // Other methods
}
