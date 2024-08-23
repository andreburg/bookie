/*
 * Controls all data concerning Authors
 */
package controller;

import model.Author;
import model.LibraryDB;

public class AuthorController {
    private LibraryDB db;

    public AuthorController(LibraryDB db) {
        this.db = db;
        // Add event listeners to the view
    }

    public void addAuthor(Author author) {
        // Code to add an author to the database
    }
    
    /*
    public SomeList<Author> getAllAuthors() {
        // Code to get all authors from the database
    }
    */

    public void updateAuthor(Author author) {
        // Code to update an author in the database
    }

    public void deleteAuthor(int authorId) {
        // Code to delete an author from the database
    }

    // Other methods related to author operations
}
