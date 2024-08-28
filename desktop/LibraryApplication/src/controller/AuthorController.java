/*
 * Controls all data concerning Authors
 */
package controller;

import java.util.List;
import java.util.ArrayList;
import model.Author;

public class AuthorController {
    private DataController dc;
    private List<Author> authors;

    public AuthorController() {
        dc = new DataController();
        authors = new ArrayList<>();
    }

    public void addAuthor(Author author) {
        authors.add(author);
        dbQuery("auth", 1, author);
    }
    
    /*
    public SomeList<Author> getAllAuthors() {
        // Code to get all Author objects
    }
    */

    public void updateAuthor(Author author) {
        dbQuery("auth", 2, author, Integer.toString(author.getId()));
    }

    public void deleteAuthor(Author author) {
        dbQuery("auth", 3, author, Integer.toString(author.getId()));
    }

    // Database methods related to author operations
    
    /* Actions:
            "1": Add
            "2": Update
            "3": Delete
            "4": Select //IF whereClause is empty its SELECT *
    */
    
    public void dbQuery(String table, int action, Author obj) {
        dbQuery(table, action, obj, "");
    }
    // Overloaded dbQuery accepts whereClause
    public void dbQuery(String table, int action, Author obj, String whereClause) {
        if (dc == null) {
            System.out.println("DataController is not initialized.");
            return;
        }
        dc.queryExecutor(table, action, obj, whereClause);
    }
}
