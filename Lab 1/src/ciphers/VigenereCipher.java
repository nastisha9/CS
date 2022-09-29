package ciphers;

import java.util.Scanner;

public class VigenereCipher {

    public static String encrypt(String plainText, String key) {

        String result = "";
        plainText = plainText.toLowerCase();
        for (int i = 0, j = 0; i < plainText.length(); i++) {
            char letter = plainText.charAt(i);
            result += (char) (((letter - 65) + (key.charAt(j) - 65)) % 26 + 65);
            j = ++j % key.length();
        }
        return result;
    }

    public static String decrypt(String encryptedText, String key) {

        String result = "";
        encryptedText = encryptedText.toLowerCase();
        for (int i = 0, j = 0; i < encryptedText.length(); i++) {
            char letter = encryptedText.charAt(i);
            result += (char) ((letter - key.charAt(j) + 26) % 26 + 65);
            j = ++j % key.length();
        }
        return result;
    }

    public static void vigenere() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Key:");
        String key = scanner.nextLine();

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