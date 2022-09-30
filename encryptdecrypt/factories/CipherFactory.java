package encryptdecrypt.factories;

import encryptdecrypt.strategies.DataCipherMethod;

public abstract class CipherFactory {
    public abstract DataCipherMethod chooseCipherMethod(String type);
}
