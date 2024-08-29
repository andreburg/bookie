// Book Controller for all related operations
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Book;

public class BookController {
    private DataController dc;
    private List<Book> books;
    private Book placeholder = new Book(0, "Title", "Genre", "ISBN", true, null, null, 0);

    public BookController() {
        dc = new DataController();
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        dbQuery("book", 1, book);
    }

    public void viewAllBooks(String whereClause) {
        dc.queryExecutor("book", 4, placeholder, whereClause); // SELECT * for books
        this.books = dc.getBookTableData(); // Retrieve the data
    }

    public void updateBook(Book book) {
        dbQuery("book", 2, book, Integer.toString(book.getId()));
    }

    public void deleteBook(Book book) {
        dbQuery("book", 3, book, Integer.toString(book.getId()));
    }

    // Database methods related to book operations
    public void dbQuery(String table, int action, Book obj) {
        dbQuery(table, action, obj, "");
    }

    // Overloaded dbQuery accepts whereClause
    public void dbQuery(String table, int action, Book obj, String whereClause) {
        if (dc == null) {
            System.out.println("DataController is not initialized.");
            return;
        }
        dc.queryExecutor(table, action, obj, whereClause);
    }

    public List<Book> getBooks() {
        return books;
    }
    
    
}
