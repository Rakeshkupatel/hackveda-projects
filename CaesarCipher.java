import java.util.Scanner;

public class CaesarCipher {
    private int shift;

    public CaesarCipher(int shift) {
        this.shift = shift;
    }

    public String encrypt(String plaintext) {
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            if (Character.isUpperCase(c)) {
                c = (char) ('A'+(c + shift - 'A') % 26);
            } else if (Character.isLowerCase(c)) {
                c = (char) ('a'+(c + shift - 'a') % 26 );
            }
            ciphertext.append(c);
        }
        return ciphertext.toString();
    }

    public String decrypt(String ciphertext) {
        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            if (Character.isUpperCase(c)) {
                c = (char) ('A'+(c - shift - 'A' + 26) % 26 );
            } else if (Character.isLowerCase(c)) {
                c = (char) ('a'+(c - shift - 'a' + 26) % 26 );
            }
            plaintext.append(c);
        }
        return plaintext.toString();
    }

    public static void main(String[] args) {
        int shift;
        String plaintext ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a shift key :");
        shift = sc.nextInt();
        if (shift > 26) {
            System.out.println("Please Enter key less than 27");
            shift = sc.nextInt();
        }
        sc.nextLine();
        System.out.println("Enter a message :");
        plaintext = sc.nextLine();
        CaesarCipher cipher = new CaesarCipher(shift);
       
        String ciphertext = cipher.encrypt(plaintext);
        String decryptedText = cipher.decrypt(ciphertext);
      
        System.out.println("Ciphertext: " + ciphertext);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
