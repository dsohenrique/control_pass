
package br.com.controlpass.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShaEncoder {

    private static MessageDigest algorithm;

    public static String encode(String parameter) {

        String encoded = null;

        try {
            if (algorithm == null) {
                algorithm = MessageDigest.getInstance("SHA-256");
            }

            byte messageDigest[] = algorithm.digest(parameter.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }

            encoded = hexString.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(ShaEncoder.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }

        return encoded;
    }

}