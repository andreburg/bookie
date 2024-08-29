/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;

import app.util.PasswordUtils;

/**
 *
 * @author andre
 */
public class Register {
    private int id;
    private final String username;
    private final String email;
    private final String lastName;
    private final String firstName;
    private final String password;
    private final String phone;
    
    public Register(int id, String firstName, String lastName, String username, String email, String password, String phone){
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
    
    public Register(String firstName, String lastName, String username, String email, String password, String phone){
        this.lastName = lastName;
        this.firstName = firstName;
        this.username = username;
        this.email = email;
        this.password = PasswordUtils.hashPassword(password);
        this.phone = phone;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getPhone(){
        return this.phone;
    }
}
