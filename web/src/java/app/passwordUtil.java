/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author werne
 */
public class passwordUtil {
    
    public static String hashPassword(String ogPassword) {
        return BCrypt.hashpw(ogPassword, BCrypt.gensalt());
    }
    
    public static boolean validatePassword(String ogPassword, String hashedPassword) {
        return BCrypt.checkpw(ogPassword, hashedPassword);
    }
}
