package ciphers;

import java.util.Scanner;

public class CaesarCipher {

    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String encrypt(String plainText, int key) {
 
        plainText = plainText.toLowerCase();   
        String encryptStr = "";   
          
        for (int i = 0; i < plainText.length(); i++)   
        {    
            int pos = ALPHABET.indexOf(plainText.charAt(i));   
            int encryptPos = (key + pos) % 26;   
            char encryptChar = ALPHABET.charAt(encryptPos);   
              
            encryptStr += encryptChar;   
        }   

        return encryptStr;   
    }

    public static String decrypt(String encryptedText, int key) {
        encryptedText = encryptedText.toLowerCase();   
        String decryptStr = "";   

        for (int i = 0; i < encryptedText.length(); i++)   
        {   

            int pos = ALPHABET.indexOf(encryptedText.charAt(i));   
  
            int decryptPos = (pos - key) % 26;   

            if (decryptPos < 0){   
                decryptPos = ALPHABET.length() + decryptPos;   
            }   
            char decryptChar = ALPHABET.charAt(decryptPos);   

            decryptStr += decryptChar;   
        }   

        return decryptStr;   
    }

    public static void caesar() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Key:");
        int key = Integer.valueOf(scanner.nextLine());

        System.out.print("Enter Plaintext:");
        String plainText = scanner.nextLine();

        String encrypted = encrypt(plainText, key);
        System.out.println("Encrypted:");
        System.out.println(encrypted);
        System.out.println("Decrypted:");
        System.out.println(decrypt(encrypted, key));
        System.out.println();
    }

}