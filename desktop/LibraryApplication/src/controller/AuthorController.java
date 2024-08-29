// Author Controller for all related operations
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Author;

public class AuthorController {
    private DataController dc;
    private List<Author> authors;
    private Author placeholder = new Author(0, "Name", "Surname");

    public AuthorController() {
        dc = new DataController();
        authors = new ArrayList<>();
    }

    public void addAuthor(Author author) {
        authors.add(author);
        dbQuery("auth", 1, author);
    }
    
    public void viewAllAuthors(String whereClause) {
        dc.queryExecutor("auth", 4, placeholder, whereClause); // SELECT * for authors
        this.authors = dc.getAuthorTableData(); // Retrieve the data
    }

    public void updateAuthor(Author author) {
        dbQuery("auth", 2, author, Integer.toString(author.getId()));
    }

    public void deleteAuthor(Author author) {
        dbQuery("auth", 3, author, Integer.toString(author.getId()));
    }

    // Database methods related to author operations
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

    public List<Author> getAuthors() {
        return authors;
    }
}
