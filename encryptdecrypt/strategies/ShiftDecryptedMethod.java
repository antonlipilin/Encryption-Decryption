package encryptdecrypt.strategies;

public class ShiftDecryptedMethod implements DataCipherMethod {

    private char decodeUpperCaseLetter(char ch, int key) {
        if (ch - key < FIRST_UPPERCASE_UNICODE_LETTER) {
            int numberOfCharShifts = key - (ch - FIRST_UPPERCASE_UNICODE_LETTER) - 1;
            return (char) (LAST_UPPERCASE_UNICODE_LETTER - numberOfCharShifts);
        } else {
            return (char) (ch - key);
        }
    }

    private char decodeLowerCaseLetter(char ch, int key) {
        if (ch - key < FIRST_LOWERCASE_UNICODE_LETTER) {
            int numberOfCharShifts = key - (ch - FIRST_LOWERCASE_UNICODE_LETTER) - 1;
            return (char) (LAST_LOWERCASE_UNICODE_LETTER - numberOfCharShifts);
        } else {
            return (char) (ch - key);
        }
    }
    @Override
    public String cipher(String src, int key) {
        char[] chars = src.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char ch: chars) {
            if (Character.isAlphabetic(ch)) {
                char currentChar = Character.isLowerCase(ch) ?
                        decodeLowerCaseLetter(ch, key) :
                        decodeUpperCaseLetter(ch, key);
                builder.append(currentChar);
            } else {
                builder.append(ch);
            }
        }

        return builder.toString();
    }
}
