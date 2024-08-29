package app.controller;


import app.util.PasswordUtils;
import java.sql.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class DataController {
    public DataController(){}
    
    String username = "avnadmin";
    String pwd = "";
    private static final String conURL = "jdbc:postgresql://pg-24fc2e18-librarybookie.f.aivencloud.com:27682/defaultdb";
    private static final String DRIVER = "org.postgresql.Driver";
    
    Connection con;
    
    public Connection getCon() throws ClassNotFoundException {
        try{
            Class.forName(DRIVER);
            this.con = DriverManager.getConnection(conURL, username, pwd);
            if(this.con != null){
                System.out.println("Connected to database");
            }
        }
        catch(SQLException ex){
            System.out.println("Could not connect: " + ex.getMessage());
        }
        return con;
    }
    
    public boolean validate(String username, String password) throws ClassNotFoundException {
        Connection conn;
        PreparedStatement pstmt;
        
        try{
            conn = getCon();
            
            //Query to search for user in the login table based on the user input
            pstmt = conn.prepareStatement("SELECT * FROM login WHERE username = ?"); 
            pstmt.setString(1, username);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()) {
                //Go through each row in the resultset and check whether the password entered by the user matches the password in the database
                String hashedPassword = rs.getString("password");
                return PasswordUtils.validatePassword(password, hashedPassword);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean register(String username, String password, String firstName, String lastName, String email, String phone) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmtRegister = null;
        PreparedStatement pstmtLogin = null;
        String hashedPassword = PasswordUtils.hashPassword(password);

        try {
            conn = getCon();
            conn.setAutoCommit(false);
            
            //Query to insert user inputs into the database. Checks if the for the foreign key constraint as well.(email and password must be unique)
            pstmtRegister = conn.prepareStatement("INSERT INTO registration (username, first_name, last_surname, password, email_address, phone_number) VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            pstmtRegister.setString(1, username);
            pstmtRegister.setString(2, firstName);
            pstmtRegister.setString(3, lastName);
            pstmtRegister.setString(4, hashedPassword);
            pstmtRegister.setString(5, email);
            pstmtRegister.setString(6, phone);
            pstmtRegister.executeUpdate();

            ResultSet generatedKeys = pstmtRegister.getGeneratedKeys();
            int registrationId = 0;
            if (generatedKeys.next()) {
                System.out.println(generatedKeys.getInt(1));
                registrationId = generatedKeys.getInt(1);
            }

            String loginSQL = "INSERT INTO login (username, password, registration_id) VALUES (?, ?, ?)";
            pstmtLogin = conn.prepareStatement(loginSQL);
            pstmtLogin.setString(1, username);
            pstmtLogin.setString(2, hashedPassword);
            pstmtLogin.setInt(3, registrationId);
            pstmtLogin.executeUpdate();

            conn.commit();

            return true;
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
            if(e.getMessage() != null && e.getMessage().contains("@")) {
                System.out.println("Email is taken");
            }
            else {
                System.out.println("Username is taken");
            }
        } finally {
            try {
                if (pstmtRegister != null) pstmtRegister.close();
                if (pstmtLogin != null) pstmtLogin.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    public boolean isEmailTaken(String email) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt = null;
    
        try {
            conn = getCon();
            //Query to check if input email already exits, will be used to show error on the clienside
            pstmt = conn.prepareStatement("SELECT * FROM registration WHERE email_address = ?");
            pstmt.setString(1, email);
        
            ResultSet rs = pstmt.executeQuery();
        
            if (rs.next()) {
                return true; 
            }
        }   catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false; 
    }
    
    public boolean isUsernameTaken(String username) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt = null;
    
        try {
            conn = getCon();
            //Query to check if input username already exits, will be used to show error on the clienside
            pstmt = conn.prepareStatement("SELECT * FROM registration WHERE username = ?");
            pstmt.setString(1, username);
        
            ResultSet rs = pstmt.executeQuery();
        
            if (rs.next()) {
                return true; 
            }
        }   catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false; 
    }
}


