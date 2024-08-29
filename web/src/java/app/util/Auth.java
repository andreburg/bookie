/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author andre
 */
public class Auth {
    public static Session getSession(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String username = "";
        if(cookies != null){
            for(Cookie cookie: cookies){
                if(cookie.getName().equals("username")) {
                username = cookie.getValue();
                }   
            }
        }
        return new Session(username);
    }
}
