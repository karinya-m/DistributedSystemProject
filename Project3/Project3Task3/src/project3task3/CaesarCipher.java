package project3task3;

/**
 * This class presents cryptography method
 *
 * @author Karinya
 */
public class CaesarCipher {

    /**
     * This method encrypts text by adding 3 to all letter
     *
     * @param plainText
     * @return string of cipher text
     */
    public static String encrypt(String plainText) {

        String cipherText = "";
        char c;
        for (int i = 0; i < plainText.length(); i++) {
            // if a character is letter, shift it by + 3
            if (Character.isLetter(plainText.charAt(i))) {
                c = (char) (plainText.charAt(i) + 3);
            } else {
                c = plainText.charAt(i);
            }
            cipherText += c;
        }
        return cipherText;
    }

    /**
     * This method decrypts text by subtracting 3 from all letter
     *
     * @param cipherText
     * @return string of plain text
     */
    public static String decrypt(String cipherText) {
        String plainText = "";
        char c;
        for (int i = 0; i < cipherText.length(); i++) {
            // if a decrypted character is letter, shift it by - 3
            if (Character.isLetter(cipherText.charAt(i) - 3)) {
                c = (char) (cipherText.charAt(i) - 3);
            } else {
                c = cipherText.charAt(i);
            }
            plainText += c;
        }
        return plainText;
    }
}
