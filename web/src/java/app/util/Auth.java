/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public class Auth {
    public static Session getSession(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String username = "";
        if(cookies != null){ 
            //Iterate over the cookies array to check if a cookie is obtainable that corresponds with the specified username, if so, they are still logged in
            for(Cookie cookie: cookies){ 
                if(cookie.getName().equals("username")) {
                username = cookie.getValue();
                }   
            }
        }
        return new Session(username);
    }
}
