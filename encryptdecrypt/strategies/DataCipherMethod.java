package encryptdecrypt.strategies;

public interface DataCipherMethod {
     int FIRST_LOWERCASE_UNICODE_LETTER = 97;
     int LAST_LOWERCASE_UNICODE_LETTER = 122;
     int FIRST_UPPERCASE_UNICODE_LETTER = 65;
     int LAST_UPPERCASE_UNICODE_LETTER = 90;
    String cipher(String src, int key);
}
