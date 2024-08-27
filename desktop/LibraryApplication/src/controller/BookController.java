/*
 * Controls all data concerning Books
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Book;
import view.BooksManager;

public class BookController {
    private BooksManager view;
    private DataController db;
    private List<Book> books;
    
    public BookController(BooksManager view, DataController db) {
        this.view = view;
        this.db = db;
        // At Main start connect to DB, read all books into List<Book>
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        dbQuery("book", 1, book);
    }

    /*
    public SomeList<Book> getAllBooks() {
        // Code to get all Book objects
    }
    */

    public void updateBook(Book book) {
        dbQuery("book", 2, book, Integer.toString(book.getId()));
    }

    public void deleteBook(Book book) {
        dbQuery("book", 3, book, Integer.toString(book.getId()));
    }

    // Database methods related to author operations
    
    /* Actions:
            "1": Add
            "2": Update
            "3": Delete
            "4": Select //IF whereClause is empty its SELECT *
    */
    
    public void dbQuery(String table, int action, Book obj) {
        dbQuery(table, action, obj, "");
    }
    // Overloaded dbQuery accepts whereClause
    public void dbQuery(String table, int action, Book obj, String whereClause) {
        db.queryExecutor(table, action, obj, whereClause);
    }
}
