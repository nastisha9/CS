# Laboratory work №1. Intro to Cryptography. Classical ciphers. 

### Course: Cryptography & Security
### Author: Iatco Anastasia, FAF-202

## Objectives:

1. Get familiar with the basics of cryptography and classical ciphers.

2. Implement 4 types of the classical ciphers:
    - Caesar cipher with one key used for substitution,
    - Vigenere cipher,
    - Playfair cipher,
    - Vernam cipher,


3. Structure the project in methods/classes/packages as neeeded.


## Implementation description

Each cipher was inplemented in a dedicated class, which contains ```encrypt``` and ```decrypt``` functions.


#### Caesar cipher
This is the simplest cipher to implement.  In this technique, each letter of the given text is replaced by a letter of some fixed number of positions down the alphabet.
It contains 2 basic functions: ```encrypted```  and ```decrypted``` , which take as an argument just a plain text and a key for permutation. It traverses input string one character at a time. Depending on the encryption and decryption, we transform each character as per the rule.
```
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
```

#### Vigene cipher
Uses a simple form of polyalphabetic substitution. Here we also are using ```encrypted```  and ```decrypted``` functions. The logic here is that the encryption of the original text is done using the Vigenère square or Vigenère table. The table consists of the alphabets written out 26 times in different rows, each alphabet shifted cyclically to the left compared to the previous alphabet, corresponding to the 26 possible Caesar Ciphers. At different points in the encryption process, the cipher uses a different alphabet from one of the rows. The alphabet used at each point depends on a repeating keyword.
```
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
```
#### Playfair cipher
The Playfair cipher was the first practical digraph substitution cipher. Here the algorithm consists of 2 steps: 
- generate the key Square(5×5): 
The key square is a 5×5 grid of alphabets that acts as the key for encrypting the plaintext. Each of the 25 alphabets must be unique and one letter of the alphabet (usually J) is omitted from the table (as the table can hold only 25 alphabets). If the plaintext contains J, then it is replaced by I. 
```
    private static void createCiperTable(String key, boolean changeJtoI) {
        String concatKeyWithMessage = prepareText(key + "ABCDEFGHIJKLMNOPQRSTUVWXYZ", changeJtoI);
        charTable = new char[5][5];
        positions = new int[5][5];

        int length = concatKeyWithMessage.length();
        for (int i = 0, count = 0; i < length; i++) {
            char letter = concatKeyWithMessage.charAt(i);
            int firstOccurance = concatKeyWithMessage.indexOf(letter);

            if (firstOccurance == i) {
                charTable[count / 5][count % 5] = letter;
                positions[count / 5][count % 5] = letter;
                count++;
            }
        }

        System.out.println();

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                System.out.print(charTable[row][col] + "  ");
            }
            System.out.println();
        }
    }
```
- Algorithm to encrypt the plain text: 
The plaintext is split into pairs of two letters (digraphs). If there is an odd number of letters, a Z is added to the last letter. 

#### Vernam cipher
In the Vernam cipher algorithm, we take a key to encrypt the plain text whose length should be equal to the length of the plain text. The algorithm for the cipher is pretty straightforward: we assign a number to each character of the plain-text and the key according to alphabetical order, bitwise XOR both the number and subtract the number from 26 if the resulting number is greater than or equal to 26, if it isn’t then leave it.
```
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
```

## Conclusions
While working on this laboratory work, I got familiar with the classical ciphers (Caesar, Vigenere, Playfair and Vernam) and how are they implemeted and used. Nowadays, the only reason to use a classical cipher is for entertainment, because there exist a lot of modern ways to encrypt and secure the information. Althought, I believe that we need to know the history of ciphers and have an understanding of how they are working.
