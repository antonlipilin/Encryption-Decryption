package encryptdecrypt.factories;

import encryptdecrypt.strategies.DataCipherMethod;
import encryptdecrypt.strategies.ShiftEncryptedMethod;
import encryptdecrypt.strategies.UnicodeEncryptedMethod;

public class EncryptedAlgorithm extends CipherFactory {

    @Override
    public DataCipherMethod chooseCipherMethod(String type) {
        return switch (type) {
            case "unicode" -> new UnicodeEncryptedMethod();
            case "shift" -> new ShiftEncryptedMethod();
            default -> null;
        };
    }
}
