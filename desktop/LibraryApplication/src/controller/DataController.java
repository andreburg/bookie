/*
 * Controls Database access
 */
package controller;
import model.Author;
import model.Book;
import model.Borrower;
import java.sql.*;
import javax.swing.JOptionPane;

public class DataController {
    // Open Connection
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String JDBC_URL = "jdbc:derby:LibraryDB;create=true";
    private Connection con;

    public void connect() throws ClassNotFoundException {
        try {
            Class.forName(DRIVER);
            this.con = DriverManager.getConnection(JDBC_URL);
            if (this.con != null) {
                System.out.println("Connected to Database");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void disconnect() {
        if (this.con != null) {
            try {
                this.con.close();
                System.out.println("Disconnected from Database");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void Controller() {
        // Add event listeners to the view
    }

    public enum Table {
        AUTH("auth"),
        BOOK("book"),
        BORR("borr");

        private final String tableName;

        Table(String tableName) {
            this.tableName = tableName;
        }

        public String getTableName() {
            return tableName;
        }
    }

    public enum Action {
        ADD(1),
        UPDATE(2),
        DELETE(3),
        SELECT(4);

        private final int actionCode;

        Action(int actionCode) {
            this.actionCode = actionCode;
        }

        public int getActionCode() {
            return actionCode;
        }
    }

    // db Executor default
    public <T> void queryExecutor(String table, int action, T obj) {
        queryExecutor(table, action, obj, "");
    }

    // Overloaded db Executor accepts Where Arguments
    public <T> void queryExecutor(String table, int action, T obj, String whereClause) {
        try {
            connect();
            if (this.con == null) {
            throw new IllegalStateException("Database connection is not established.");
            }

            Table tableEnum = Table.valueOf(table.toUpperCase());
            Action actionEnum = Action.values()[action - 1];

            switch (tableEnum) {
                case AUTH:
                    if (obj instanceof Author) {
                        Author author = (Author) obj;
                        handleAuthorAction(actionEnum, author, whereClause);
                    } else {
                        throw new IllegalArgumentException("Invalid object type for table AUTH");
                    }
                    break;
                case BOOK:
                    if (obj instanceof Book) {
                        Book book = (Book) obj;
                        handleBookAction(actionEnum, book, whereClause);
                    } else {
                        throw new IllegalArgumentException("Invalid object type for table BOOK");
                    }
                    break;
                case BORR:
                    if (obj instanceof Borrower) {
                        Borrower borrower = (Borrower) obj;
                        handleBorrowerAction(actionEnum, borrower, whereClause);
                    } else {
                        throw new IllegalArgumentException("Invalid object type for table BORR");
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported table");
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }
    }

    // Methods Author Table
    private void handleAuthorAction(Action action, Author author, String whereClause) {
        switch (action) {
            case ADD:
                // Add author logic
                try {
                    String query = "INSERT INTO AUTHORS (id, first_name, last_name) VALUES (?, ?, ?)";
                    try (PreparedStatement statement = con.prepareStatement(query)) {
                        statement.setInt(1, author.getId());
                        statement.setString(2, author.getName());
                        statement.setString(3, author.getSurname());
                        statement.executeUpdate();
                    }
                    System.out.println("Data has been added to the Authors table");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Data could not be added to the Authors table for author: " + author.getName(), "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Data could not be added to the Authors table");
                }
                break;
            case UPDATE:
                // Update author logic with whereClause
                try {
                    String query = "UPDATE AUTHORS SET first_name = ?, last_name = ? WHERE id = " + whereClause;
                    try (PreparedStatement statement = con.prepareStatement(query)) {
                        statement.setString(1, author.getName());
                        statement.setString(2, author.getSurname());
                        int rowsUpdated = statement.executeUpdate();
                        if (rowsUpdated > 0) {
                            System.out.println("Data has been updated in the Authors table");
                        } else {
                            System.out.println("No data found to update in the Authors table");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Data could not be updated in the Authors table for author: " + author.getName() + " Where: " + whereClause, "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Data could not be updated in the Authors table");
                }
                break;
            case DELETE:
                // Delete author logic with whereClause
                try {
                    String query = "DELETE FROM AUTHORS WHERE id = " + whereClause;
                    try (PreparedStatement statement = con.prepareStatement(query)) {
                        int rowsDeleted = statement.executeUpdate();
                        if (rowsDeleted > 0) {
                            System.out.println("Data has been deleted from the Authors table");
                        } else {
                            System.out.println("No data found to delete from the Authors table");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Data could not be deleted from the Authors table where: " + whereClause, "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Data could not be deleted from the Authors table");
                }
                break;
            case SELECT:
                if (whereClause.isEmpty()) {
                    // Select all authors logic
                    try {
                        String query = "SELECT * FROM AUTHORS";
                        try (PreparedStatement statement = con.prepareStatement(query)) {
                            ResultSet resultSet = statement.executeQuery();
                            while (resultSet.next()) {
                                // TO DO: Process the result set
                                System.out.println("Author ID: " + resultSet.getInt("id"));
                                // Add more fields as needed
                            }
                        }
                        System.out.println("All authors have been selected from the Authors table");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "All Data could not be selected from the Authors table", "Error", JOptionPane.ERROR_MESSAGE);
                        System.out.println("Data could not be selected from the Authors table");
                    }
                } else {
                    // Select author with whereClause logic
                    try {
                        String query = "SELECT * FROM AUTHORS WHERE " + whereClause;
                        try (PreparedStatement statement = con.prepareStatement(query)) {
                            ResultSet resultSet = statement.executeQuery();
                            while (resultSet.next()) {
                                // TO DO: Process the result set
                                System.out.println("Author ID: " + resultSet.getInt("id"));
                                // Add more fields as needed
                            }
                        }
                        System.out.println("Authors have been selected from the Authors table with the specified condition");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Data could not be selected from the Authors table where: " + whereClause, "Error", JOptionPane.ERROR_MESSAGE);
                        System.out.println("Data could not be selected from the Authors table with the specified condition");
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Unsupported action for Author");
        }
    }
    
    // Methods Books Table
    private void handleBookAction(Action action, Book book, String whereClause) {
        switch (action) {
            case ADD:
                // Add book logic | Table/s: BOOKS, BOOK_AUTHORS, BORROWERS
                try {
                    String query = "INSERT INTO BOOKS (id, title, genre, isbn_code, is_available, "
                            + "last_borrowed, date_returned, borrower_id) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement statement = con.prepareStatement(query)) {
                        statement.setInt(1, book.getId());
                        statement.setString(2, book.getTitle());
                        statement.setString(3, book.getGenre());
                        statement.setString(4, book.getIsbn());
                        statement.setBoolean(5, book.isAvailable());
                        statement.setDate(6, book.getLastBorrowed() != null ? new java.sql.Date(book.getLastBorrowed().getTime()) : null);
                        statement.setDate(7, book.getDateReturned() != null ? new java.sql.Date(book.getDateReturned().getTime()) : null);
                        statement.setInt(8, book.getBorrowerID());
                        statement.executeUpdate();
                    }
                    System.out.println("Data has been added to the Books table");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Data could not be added to the Books table for book: " + book.getTitle(), "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Data could not be added to the Books table");
                }
                break;
            case UPDATE:
                // Update book logic with whereClause
                try {
                    String query = "UPDATE BOOKS SET title = ?, genre = ?, isbn_code = ?, is_available = ?, "
                            + "last_borrowed = ?, date_returned = ?, borrower_id = ? WHERE id =" + whereClause;
                    try (PreparedStatement statement = con.prepareStatement(query)) {
                        statement.setString(1, book.getTitle());
                        statement.setString(2, book.getGenre());
                        statement.setString(3, book.getIsbn());
                        statement.setBoolean(4, book.isAvailable());
                        statement.setDate(5, book.getLastBorrowed() != null ? new java.sql.Date(book.getLastBorrowed().getTime()) : null);
                        statement.setDate(6, book.getDateReturned() != null ? new java.sql.Date(book.getDateReturned().getTime()) : null);
                        statement.setInt(7, book.getBorrowerID());
                        statement.executeUpdate();
                    }
                    System.out.println("Data has been updated in the Books table");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Data could not be Updated to the Books table for book: " + book.getTitle() + " Where " + whereClause, "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Data could not be updated in the Books table");
                }
                break;
            case DELETE:
                // Delete book logic with whereClause
                try {
                    String query = "DELETE FROM BOOKS WHERE id =" + whereClause;
                    try (PreparedStatement statement = con.prepareStatement(query)) {
                        statement.executeUpdate();
                    }
                    System.out.println("Data has been deleted from the Books table");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Data could not be Deleted frome the Books table where: " + whereClause, "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Data could not be deleted from the Books table");
                }
                break;
            case SELECT:
                if (whereClause.isEmpty()) {
                    // Select all books logic
                    try {
                        String query = "SELECT * FROM BOOKS";
                        try (PreparedStatement statement = con.prepareStatement(query)) {
                            ResultSet resultSet = statement.executeQuery();
                            while (resultSet.next()) {
                                // TO DO
                                // Process the result set
                                System.out.println("Book ID: " + resultSet.getInt("id"));
                                // Add more fields as needed
                            }
                        }
                        System.out.println("All books have been selected from the Books table");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "All Data could not be Selected frome the Books table", "Error", JOptionPane.ERROR_MESSAGE);
                        System.out.println("Data could not be selected from the Books table");
                    }
                } else {
                    // Select book with whereClause logic
                    try {
                        String query = "SELECT * FROM BOOKS WHERE " + whereClause;
                        try (PreparedStatement statement = con.prepareStatement(query)) {
                            ResultSet resultSet = statement.executeQuery();
                            while (resultSet.next()) {
                                // TO DO
                                // Process the result set
                                System.out.println("Book ID: " + resultSet.getInt("id"));
                                // Add more fields as needed
                            }
                        }
                        System.out.println("Books have been selected from the Books table with the specified condition");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Data could not be Selected frome the Books table where: " + whereClause, "Error", JOptionPane.ERROR_MESSAGE);
                        System.out.println("Data could not be selected from the Books table with the specified condition");
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Unsupported action for Book");
        }
    }
    
    // Methods Borrower Table
    private void handleBorrowerAction(Action action, Borrower borrower, String whereClause) {
        switch (action) {
            case ADD:
                // Add borrower logic | Table/s: BORROWERS
                try {
                    String query = "INSERT INTO BORROWERS (id, first_name, last_name, "
                            + "phone_number, email_address, home_address) "
                            + "VALUES (?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement statement = con.prepareStatement(query)) {
                        statement.setInt(1, borrower.getId());
                        statement.setString(2, borrower.getName());
                        statement.setString(3, borrower.getSurname());
                        statement.setString(4, borrower.getPhone());
                        statement.setString(5, borrower.getEmail());
                        statement.setString(6, borrower.getAddress());
                        statement.executeUpdate();
                    }
                    System.out.println("Data has been added to the Borrowers table");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("Data could not be added to the Borrowers table");
                }
                break;
            case UPDATE:
                try {
                    String query = "UPDATE BORROWERS SET first_name = ?, last_name = ?, phone_number=?, email_address=?, home_address=? WHERE id = " + whereClause;
                    try (PreparedStatement statement = con.prepareStatement(query)) {
                        statement.setInt(1, borrower.getId());
                        statement.setString(2, borrower.getName());
                        statement.setString(3, borrower.getSurname());
                        statement.setString(4, borrower.getPhone());
                        statement.setString(5, borrower.getEmail());
                        statement.setString(6, borrower.getAddress());
                        int rowsUpdated = statement.executeUpdate();
                        if (rowsUpdated > 0) {
                            System.out.println("Data has been updated in the Borrowers table");
                        } else {
                            System.out.println("No data found to update in the Borrowers table");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Data could not be updated in the Borrowers table for borrower: " + borrower.getName() + " Where: " + whereClause, "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Data could not be updated in the Borrowers table");
                }
                break;

            case DELETE:
                try {
                        String query = "DELETE FROM BORROWERS WHERE " + whereClause;
                        try (PreparedStatement statement = con.prepareStatement(query)) {
                            ResultSet resultSet = statement.executeQuery();
                            while (resultSet.next()) {
                                // TO DO
                                // Process the result set
                                System.out.println("Borrowers ID: " + resultSet.getInt("id"));
                                // Add more fields as needed
                            }
                        }
                        System.out.println("Borrowers have been deleted from the Borrowers table with the specified condition");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Data could not be deleted from the Borrowers table where: " + whereClause, "Error", JOptionPane.ERROR_MESSAGE);
                        System.out.println("Data could not be deleted from the Borrowers  table with the specified condition");
                    }
                break;
            case SELECT:
                if (whereClause.isEmpty()) {
                    // Select all borrower logic
                    try {
                        String query = "SELECT * FROM BORROWERS";
                        try (PreparedStatement statement = con.prepareStatement(query)) {
                            ResultSet resultSet = statement.executeQuery();
                            while (resultSet.next()) {
                                // TO DO
                                // Process the result set
                                System.out.println("Borrower ID: " + resultSet.getInt("id"));
                                // Add more fields as needed
                            }
                        }
                        System.out.println("All borrowers have been selected from the Borrowers table");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "All Data could not be Selected frome the Borrowers table", "Error", JOptionPane.ERROR_MESSAGE);
                        System.out.println("Data could not be selected from the Borrowers  table");
                    }
                } else {
                    // Select borrower with whereClause logic
                    try {
                        String query = "SELECT * FROM BORROWERS WHERE " + whereClause;
                        try (PreparedStatement statement = con.prepareStatement(query)) {
                            ResultSet resultSet = statement.executeQuery();
                            while (resultSet.next()) {
                                // TO DO
                                // Process the result set
                                System.out.println("Borrowers ID: " + resultSet.getInt("id"));
                                // Add more fields as needed
                            }
                        }
                        System.out.println("Borrowers have been selected from the Borrowers table with the specified condition");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Data could not be Selected from the Borrowers table where: " + whereClause, "Error", JOptionPane.ERROR_MESSAGE);
                        System.out.println("Data could not be selected from the Borrowers  table with the specified condition");
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Unsupported action for Borrower");
        }
    }
}    
    /*
    //Creating Tables
        public void createTables(){       
            try {
                String queryAuthors = "CREATE TABLE AUTHORS (\n"
                        + "    id INT PRIMARY KEY,\n"
                        + "    first_name VARCHAR(100) NOT NULL,\n"
                        + "    last_name VARCHAR(100) NOT NULL\n"
                        + ")";
                String queryBooks = "CREATE TABLE BOOKS (\n"
                        + "    id INT PRIMARY KEY,\n"
                        + "    title VARCHAR(200) NOT NULL,\n"
                        + "    genre VARCHAR(100),\n"
                        + "    isbn_code VARCHAR(20) UNIQUE,\n"
                        + "    is_available BOOLEAN NOT NULL DEFAULT TRUE,\n"
                        + "    last_borrowed DATE,\n"
                        + "    date_returned DATE,\n"
                        + "    borrower_id INT REFERENCES borrowers(id) \n"
                        + ")";
                String queryBorrowers = "CREATE TABLE BORROWERS (\n"
                        + "    id INT PRIMARY KEY,\n"
                        + "    first_name VARCHAR(100),\n"
                        + "    last_name VARCHAR(100),\n"
                        + "    phone_number VARCHAR(10) CHECK (LENGTH(phone_number) = 10 AND phone_number NOT LIKE '%[^0-9]%'),\n"
                        + "    email_address VARCHAR(200) CHECK (email_address LIKE '%@%'),\n"
                        + "    home_address VARCHAR(200)\n"
                        + ")";
                String queryBookAuthors = "CREATE TABLE BOOK_AUTHORS (\n"
                        + "    book_id INT REFERENCES books(id) ON DELETE CASCADE,\n"
                        + "    author_id INT REFERENCES authors(id) ON DELETE CASCADE,\n"
                        + "    PRIMARY KEY (book_id, author_id) \n"
                        + ")";

                this.con.createStatement().execute(queryAuthors);
                this.con.createStatement().execute(queryBorrowers);
                this.con.createStatement().execute(queryBooks);
                this.con.createStatement().execute(queryBookAuthors);
                System.out.println("Tables have been created");                  
            } catch (SQLException ex) {
                ex.printStackTrace();           
            }
        }
    */

