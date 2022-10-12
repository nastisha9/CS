import java.util.Scanner;
import ciphers.classical.*;
import ciphers.symmetric.*;

public class Main {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1) Caesar cipher");
        System.out.println("2) Vigenere cipher");
        System.out.println("3) Playfair cipher");
        System.out.println("4) Vernam cipher");
        System.out.println("5) RC4 cipher");
        System.out.println("6) DES cipher\n");
        System.out.println("7) exit\n");
        System.out.println("Enter Choice:");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                CaesarCipher.caesar();
                break;
            case 2:
                VigenereCipher.vigenere();
                break;
            case 3:
                PlayfairCipher.playfair();
                break;
            case 4:
                VernamCipher.vernam();
                break;
            case 5:
                RC4Cipher.rc4();
                break;
            case 6:
                DESCipher.des();
                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        run();
    }

}