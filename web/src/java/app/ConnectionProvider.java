package app;


import java.sql.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author andre
 */
public class ConnectionProvider {
    public ConnectionProvider(){}
    
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
    
    public void add(String id, String n, String s) throws ClassNotFoundException {
        Connection conn;
        PreparedStatement pstmt;
        try{
            conn = getCon();
            
            pstmt = conn.prepareStatement("INSERT INTO login (id, name, surname) VALUES (?, ?, ?)");
            pstmt.setString(1, id);
            pstmt.setString(2, n);
            pstmt.setString(3, s);

            pstmt.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println("Could not add data: " + ex.getMessage());
        }
    }
    public boolean validate(String username, String password) throws ClassNotFoundException {
        Connection conn;
        PreparedStatement pstmt;
        
        try{
            conn = getCon();
            
            pstmt = conn.prepareStatement("SELECT * FROM login WHERE username = ? AND password = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()) {
                return true;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}