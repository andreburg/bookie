
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author andre
 */
public class CookieWrapper {
    
    private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = "sadfasdfdsafsa".getBytes();
    
    public static String encrypt(String data) throws Exception {
    SecretKeySpec key = new SecretKeySpec(keyValue, ALGORITHM);
    Cipher cipher = Cipher.getInstance(ALGORITHM);
    cipher.init(Cipher.ENCRYPT_MODE, key);
    byte[] encryptedValue = cipher.doFinal(data.getBytes());
    return Base64.getEncoder().encodeToString(encryptedValue);
    }
    
    public static String decrypt(String encryptedData) throws Exception{
        SecretKeySpec key = new SecretKeySpec(keyValue, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedValue = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedValue = cipher.doFinal(decodedValue);
        return new String(decryptedValue);
    }
}
