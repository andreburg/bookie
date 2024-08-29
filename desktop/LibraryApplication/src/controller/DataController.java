package controller;

import model.Author;
import model.Book;
import model.Borrower;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DataController {

    // Database connection constants
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String JDBC_URL = "jdbc:derby:LibraryDB;create=true";
    private Connection con;

    private List<Author> authorTableData;
    private List<Book> bookTableData;
    private List<Borrower> borrowerTableData;

    public List<Author> getAuthorTableData() {
        return authorTableData;
    }

    public List<Book> getBookTableData() {
        return bookTableData;
    }

    public List<Borrower> getBorrowerTableData() {
        return borrowerTableData;
    }

    // Establishes a connection to the database
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

    // Closes the database connection
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

    // Default database query executor
    public <T> void queryExecutor(String table, int action, T obj) {
        queryExecutor(table, action, obj, "");
    }

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
                        handleAuthorAction(actionEnum, (Author) obj, whereClause);
                    } else {
                        throw new IllegalArgumentException("Invalid object type for table AUTH");
                    }
                    break;
                case BOOK:
                    if (obj instanceof Book) {
                        handleBookAction(actionEnum, (Book) obj, whereClause);
                    } else {
                        throw new IllegalArgumentException("Invalid object type for table BOOK");
                    }
                    break;
                case BORR:
                    if (obj instanceof Borrower) {
                        handleBorrowerAction(actionEnum, (Borrower) obj, whereClause);
                    } else {
                        throw new IllegalArgumentException("Invalid object type for table BORR");
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported table");
            }
        } catch (ClassNotFoundException ex) {
            // Use a logger for better error tracking
            ex.printStackTrace();
        } finally {
            disconnect();
        }
    }

    // Methods for handling actions on the Author table
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
                }
                break;
            case UPDATE:
                // Update author logic with whereClause
                try {
                    String query = "UPDATE AUTHORS SET first_name = ?, last_name = ? WHERE id = ?";
                    try (PreparedStatement statement = con.prepareStatement(query)) {
                        statement.setString(1, author.getName());
                        statement.setString(2, author.getSurname());
                        statement.setInt(3, Integer.parseInt(whereClause));
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
                }
                break;
            case DELETE:
                // Delete author logic with whereClause
                try {
                    String query = "DELETE FROM AUTHORS WHERE id = ?";
                    try (PreparedStatement statement = con.prepareStatement(query)) {
                        statement.setInt(1, Integer.parseInt(whereClause));
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
                }
                break;
            case SELECT:
                if (whereClause.isEmpty()) {
                    // Select all authors logic
                    try {
                        String query = "SELECT * FROM AUTHORS";
                        try (PreparedStatement statement = con.prepareStatement(query)) {
                            ResultSet resultSet = statement.executeQuery();
                            List<Author> authors = new ArrayList<>();
                            while (resultSet.next()) {
                                Author a = new Author(resultSet.getInt("id"),
                                        resultSet.getString("first_name"),
                                        resultSet.getString("last_name"));
                                authors.add(a);
                            }
                            this.authorTableData = authors; // Store result in tableData
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "All Data could not be selected from the Authors table", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    // Select author with whereClause logic
                    try {
                        String query = "SELECT * FROM AUTHORS WHERE id = ?";
                        try (PreparedStatement statement = con.prepareStatement(query)) {
                            statement.setInt(1, Integer.parseInt(whereClause));
                            ResultSet resultSet = statement.executeQuery();
                            List<Author> authors = new ArrayList<>();
                            while (resultSet.next()) {
                                Author a = new Author(resultSet.getInt("id"),
                                        resultSet.getString("first_name"),
                                        resultSet.getString("last_name"));
                                authors.add(a);
                            }
                            this.authorTableData = authors; // Store result in tableData
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Data could not be selected from the Authors table where: " + whereClause, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Unsupported action for Author");
        }
    }

    // Methods for handling actions on the Book table
    private void handleBookAction(Action action, Book book, String whereClause) {
        switch (action) {
            case ADD:
                // Add book logic
                try {
                    String query = "INSERT INTO BOOKS (id, title, genre, isbn, available, last_borrowed, date_returned, borrower_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
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
                }
                break;
            case UPDATE:
                // Update book logic with whereClause
                try {
                    String query = "UPDATE BOOKS SET title = ?, genre = ?, isbn = ?, available = ?, last_borrowed = ?, date_returned = ?, borrower_id = ? WHERE id = ?";
                    try (PreparedStatement statement = con.prepareStatement(query)) {
                        statement.setString(1, book.getTitle());
                        statement.setString(2, book.getGenre());
                        statement.setString(3, book.getIsbn());
                        statement.setBoolean(4, book.isAvailable());
                        statement.setDate(5, book.getLastBorrowed() != null ? new java.sql.Date(book.getLastBorrowed().getTime()) : null);
                        statement.setDate(6, book.getDateReturned() != null ? new java.sql.Date(book.getDateReturned().getTime()) : null);
                        statement.setInt(7, book.getBorrowerID());
                        statement.setInt(8, Integer.parseInt(whereClause));
                        int rowsUpdated = statement.executeUpdate();
                        if (rowsUpdated > 0) {
                            System.out.println("Data has been updated in the Books table");
                        } else {
                            System.out.println("No data found to update in the Books table");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Data could not be updated in the Books table for book: " + book.getTitle() + " Where: " + whereClause, "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case DELETE:
                // Delete book logic with whereClause
                try {
                    String query = "DELETE FROM BOOKS WHERE id = ?";
                    try (PreparedStatement statement = con.prepareStatement(query)) {
                        statement.setInt(1, Integer.parseInt(whereClause));
                        int rowsDeleted = statement.executeUpdate();
                        if (rowsDeleted > 0) {
                            System.out.println("Data has been deleted from the Books table");
                        } else {
                            System.out.println("No data found to delete from the Books table");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Data could not be deleted from the Books table where: " + whereClause, "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case SELECT:
                if (whereClause.isEmpty()) {
                    // Select all books logic
                    try {
                        String query = "SELECT * FROM BOOKS";
                        try (PreparedStatement statement = con.prepareStatement(query)) {
                            ResultSet resultSet = statement.executeQuery();
                            List<Book> books = new ArrayList<>();
                            while (resultSet.next()) {
                                Book b = new Book(resultSet.getInt("id"),
                                        resultSet.getString("title"),
                                        resultSet.getString("genre"),
                                        resultSet.getString("isbn"),
                                        resultSet.getBoolean("available"),
                                        resultSet.getDate("last_borrowed"),
                                        resultSet.getDate("date_returned"),
                                        resultSet.getInt("borrower_id"));
                                books.add(b);
                            }
                            this.bookTableData = books; // Store result in tableData
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "All Data could not be selected from the Books table", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    // Select book with whereClause logic
                    try {
                        String query = "SELECT * FROM BOOKS WHERE id = ?";
                        try (PreparedStatement statement = con.prepareStatement(query)) {
                            statement.setInt(1, Integer.parseInt(whereClause));
                            ResultSet resultSet = statement.executeQuery();
                            List<Book> books = new ArrayList<>();
                            while (resultSet.next()) {
                                Book b = new Book(resultSet.getInt("id"),
                                        resultSet.getString("title"),
                                        resultSet.getString("genre"),
                                        resultSet.getString("isbn"),
                                        resultSet.getBoolean("available"),
                                        resultSet.getDate("last_borrowed"),
                                        resultSet.getDate("date_returned"),
                                        resultSet.getInt("borrower_id"));
                                books.add(b);
                            }
                            this.bookTableData = books; // Store result in tableData
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Data could not be selected from the Books table where: " + whereClause, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Unsupported action for Book");
        }
    }

    // Methods for handling actions on the Borrower table
    private void handleBorrowerAction(Action action, Borrower borrower, String whereClause) {
    switch (action) {
        case ADD:
            // Add borrower logic
            try {
                String query = "INSERT INTO BORROWERS (id, first_name, last_name, phone, email, address) VALUES (?, ?, ?, ?, ?, ?)";
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
                JOptionPane.showMessageDialog(null, "Data could not be added to the Borrowers table for borrower: " + borrower.getName(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            break;
        case UPDATE:
            // Update borrower logic with whereClause
            try {
                String query = "UPDATE BORROWERS SET first_name = ?, last_name = ?, phone = ?, email = ?, address = ? WHERE id = ?";
                try (PreparedStatement statement = con.prepareStatement(query)) {
                    statement.setString(1, borrower.getName());
                    statement.setString(2, borrower.getSurname());
                    statement.setString(3, borrower.getPhone());
                    statement.setString(4, borrower.getEmail());
                    statement.setString(5, borrower.getAddress());
                    statement.setInt(6, Integer.parseInt(whereClause));
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
            }
            break;
        case DELETE:
            // Delete borrower logic with whereClause
            try {
                String query = "DELETE FROM BORROWERS WHERE id = ?";
                try (PreparedStatement statement = con.prepareStatement(query)) {
                    statement.setInt(1, Integer.parseInt(whereClause));
                    int rowsDeleted = statement.executeUpdate();
                    if (rowsDeleted > 0) {
                        System.out.println("Data has been deleted from the Borrowers table");
                    } else {
                        System.out.println("No data found to delete from the Borrowers table");
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Data could not be deleted from the Borrowers table where: " + whereClause, "Error", JOptionPane.ERROR_MESSAGE);
            }
            break;
        case SELECT:
            if (whereClause.isEmpty()) {
                // Select all borrowers logic
                try {
                    String query = "SELECT * FROM BORROWERS";
                    try (PreparedStatement statement = con.prepareStatement(query)) {
                        ResultSet resultSet = statement.executeQuery();
                        List<Borrower> borrowers = new ArrayList<>();
                        while (resultSet.next()) {
                            Borrower b = new Borrower(resultSet.getInt("id"),
                                    resultSet.getString("first_name"),
                                    resultSet.getString("last_name"),
                                    resultSet.getString("phone"),
                                    resultSet.getString("email"),
                                    resultSet.getString("address"));
                            borrowers.add(b);
                        }
                        this.borrowerTableData = borrowers; // Store result in tableData
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "All Data could not be selected from the Borrowers table", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Select borrower with whereClause logic
                try {
                    String query = "SELECT * FROM BORROWERS WHERE id = ?";
                    try (PreparedStatement statement = con.prepareStatement(query)) {
                        statement.setInt(1, Integer.parseInt(whereClause));
                        ResultSet resultSet = statement.executeQuery();
                        List<Borrower> borrowers = new ArrayList<>();
                        while (resultSet.next()) {
                            Borrower b = new Borrower(resultSet.getInt("id"),
                                    resultSet.getString("first_name"),
                                    resultSet.getString("last_name"),
                                    resultSet.getString("phone"),
                                    resultSet.getString("email"),
                                    resultSet.getString("address"));
                            borrowers.add(b);
                        }
                        this.borrowerTableData = borrowers; // Store result in tableData
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Data could not be selected from the Borrowers table where: " + whereClause, "Error", JOptionPane.ERROR_MESSAGE);
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

