package ciphers.classical;

import java.util.Scanner;

public class VernamCipher {

    private static Scanner scanner = new Scanner(System.in);

    private String encrypt(String str, String key) {
        String result = "";
        if (str.length() == key.length()) {
            System.out.println("Plaintext" + "\t\t\t" + "Key" + "\t\t\t\t" + "XOR");
            for (int i = 0; i < str.length(); i++) {
                char a = str.charAt(i);
                char b = key.charAt(i);
                System.out.println((int) a + "\t\t\t\t" + (int) b + "\t\t\t\t" + ((int) (a + b)) % 127);
                char c = (char) (((int) (a + b)) % 127); // MOD
                result = result + c;
            }
        } else {
            System.out.println("Plaintext and key should be of the same length");
        }
        return result;
    }

    private String decrypt(String ciphertext, String key) {
        String result = "";
        if (ciphertext.length() == key.length()) {
            for (int i = 0; i < ciphertext.length(); i++) {
                char a = ciphertext.charAt(i);
                char b = key.charAt(i);
                char c;
                c = (char) (127 - (b - a));
                result = result + c;
            }
        } else {
            System.out.println("Ciphertext and key should be of the same length");
        }

        return result;
    }

    public static void vernam() {
        VernamCipher obj = new VernamCipher();

        System.out.println("Enter the Vernam plaintext : ");
        String plaintext = obj.scanner.next();
        System.out.println("Enter the Vernam key : ");
        String key_1 = obj.scanner.next();
        String cipher = obj.encrypt(plaintext, key_1);
        System.out.println("The Ciphertext is: " + cipher);

        System.out.println("\nEnter the Vernam ciphertext : ");
        String ciphertext = scanner.next();
        System.out.println("Enter the Vernam key : ");
        String key_2 = scanner.next();
        String text = obj.decrypt(ciphertext, key_2);
        System.out.println("The plaintext is: " + text);

    }
}