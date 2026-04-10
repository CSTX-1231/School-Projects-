import java.util.Scanner;

public class VigenereCipher {

    public static String encrypt(String plaintext, String key) {
        StringBuilder encryptedText = new StringBuilder();
        plaintext = plaintext.toUpperCase();
        key = key.toUpperCase();
        
        int keyIndex = 0;
        for (int i = 0; i < plaintext.length(); i++) {
            char pChar = plaintext.charAt(i);
            if (Character.isLetter(pChar)) {
                int pVal = pChar - 'A';
                int kVal = key.charAt(keyIndex % key.length()) - 'A';
                char encryptedChar = (char) ((pVal + kVal) % 26 + 'A');
                encryptedText.append(encryptedChar);
                keyIndex++;
            } else {
                encryptedText.append(pChar);
            }
        }
        return encryptedText.toString();
    }

    public static String decrypt(String ciphertext, String key) {
        StringBuilder decryptedText = new StringBuilder();
        ciphertext = ciphertext.toUpperCase();
        key = key.toUpperCase();
        
        int keyIndex = 0;
        for (int i = 0; i < ciphertext.length(); i++) {
            char cChar = ciphertext.charAt(i);
            if (Character.isLetter(cChar)) {
                int cVal = cChar - 'A';
                int kVal = key.charAt(keyIndex % key.length()) - 'A';
                char decryptedChar = (char) ((cVal - kVal + 26) % 26 + 'A');
                decryptedText.append(decryptedChar);
                keyIndex++;
            } else {
                decryptedText.append(cChar);
            }
        }
        return decryptedText.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Encrypt");
            System.out.println("2. Decrypt");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter plaintext: ");
                    String plaintext = scanner.nextLine();
                    System.out.print("Enter key: ");
                    String key = scanner.nextLine();
                    String encrypted = encrypt(plaintext, key);
                    System.out.println("Encrypted text: " + encrypted);
                    break;

                case 2:
                    System.out.print("Enter ciphertext: ");
                    String ciphertext = scanner.nextLine();
                    System.out.print("Enter key: ");
                    key = scanner.nextLine();
                    String decrypted = decrypt(ciphertext, key);
                    System.out.println("Decrypted text: " + decrypted);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }
}