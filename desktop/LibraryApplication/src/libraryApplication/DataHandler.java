/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryApplication;


import java.sql.*;

/**
 *
 * @author User
 */
public class DataHandler {
    
    private static final String DRIVER= "org.apache.derby.jdbc.EmbeddedDriver";
    
    private static final String JDBC_URL= "jdbc:derby:LibraryDB;create=true";
    Connection con;
    
    public DataHandler()
    {
        
        
    }
    public void connect() throws ClassNotFoundException
    {
        try{
            Class.forName(DRIVER);
            this.con = DriverManager.getConnection(JDBC_URL);
            if (this.con!=null) {
                System.out.println("Connected to Database");
                
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
    }
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
    public void addAuthor(String id, String name, String lastName){
        try{
            
        String query = "INSERT INTO AUTHORS VALUES('"+id+"','"+name+"','"+lastName+"')";
        this.con.createStatement().execute(query);
            System.out.println("Data has been added to the Authors table");
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("Data could not be added to the Authors table");
        }
        
    }
    
    
    
}
