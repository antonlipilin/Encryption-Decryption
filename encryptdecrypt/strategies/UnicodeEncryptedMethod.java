package encryptdecrypt.strategies;

public class UnicodeEncryptedMethod implements DataCipherMethod {

    @Override
    public String cipher(String src, int key) {
        char[] chars = src.toCharArray();
        StringBuilder encryptedMessage = new StringBuilder();

        for (char ch: chars) {
            encryptedMessage.append((char) (ch + key));
        }

        return encryptedMessage.toString();
    }
}
