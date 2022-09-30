package encryptdecrypt.factories;

import encryptdecrypt.strategies.DataCipherMethod;
import encryptdecrypt.strategies.ShiftDecryptedMethod;
import encryptdecrypt.strategies.UnicodeDecryptedMethod;

public class DecryptedAlgorithm extends  CipherFactory {

    @Override
    public DataCipherMethod chooseCipherMethod(String type) {
        return switch (type) {
            case "unicode" -> new UnicodeDecryptedMethod();
            case "shift" -> new ShiftDecryptedMethod();
            default -> null;
        };
    }
}
