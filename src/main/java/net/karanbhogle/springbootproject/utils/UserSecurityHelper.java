package net.karanbhogle.springbootproject.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class UserSecurityHelper {
	private UserSecurityHelper() {
	    throw new IllegalStateException("UserSecurityHelper class");
	}
	
	public static String hashString(String input) {
        try {
            // Create MessageDigest instance for SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Add input string bytes to digest
            md.update(input.getBytes());

            // Get the hash's bytes
            byte[] byteData = md.digest();

            // Convert the byte array into a signum representation
            StringBuilder sb = new StringBuilder();
            for (byte b : byteData) {
                sb.append(String.format("%02x", b));
            }

            // Base64 encode the hash
            return Base64.getEncoder().encodeToString(sb.toString().getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
