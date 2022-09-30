package encryptdecrypt.strategies;

public class ShiftEncryptedMethod implements DataCipherMethod {

    private char encodeUpperCaseLetter(char ch, int key) {
        if (ch + key > LAST_UPPERCASE_UNICODE_LETTER) {
            int numberOfCharShifts = key - (LAST_UPPERCASE_UNICODE_LETTER - ch) - 1;
            return (char) (FIRST_UPPERCASE_UNICODE_LETTER + numberOfCharShifts);
        } else {
            return (char) (ch + key);
        }
    }

    private char encodeLowerCaseLetter(char ch, int key) {
        if (ch + key > LAST_LOWERCASE_UNICODE_LETTER) {
            int numberOfCharShifts = key - (LAST_LOWERCASE_UNICODE_LETTER - ch) - 1;
            return (char) (FIRST_LOWERCASE_UNICODE_LETTER + numberOfCharShifts);
        } else {
            return (char) (ch + key);
        }
    }

    @Override
    public String cipher(String src, int key) {
        char[] chars = src.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char ch: chars) {
            if (Character.isAlphabetic(ch)) {
                char currentChar = Character.isLowerCase(ch) ?
                        encodeLowerCaseLetter(ch, key) :
                        encodeUpperCaseLetter(ch, key);
                builder.append(currentChar);
            } else {
                builder.append(ch);
            }
        }

        return builder.toString();
    }
}
