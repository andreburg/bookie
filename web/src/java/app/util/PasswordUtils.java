/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.util;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtils {
    
    public static String hashPassword(String ogPassword) {
        return BCrypt.hashpw(ogPassword, BCrypt.gensalt());
        //Hash and salt the user password to store an encrypted password in the database
    }
    
    public static boolean validatePassword(String ogPassword, String hashedPassword) {
        return BCrypt.checkpw(ogPassword, hashedPassword);
        //Compares the password the user entered with hashed password in the database
    }
}
