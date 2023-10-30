package net.johnnyconsole.beans.transposition.shuffle;

import javax.ejb.Local;
@Local
public interface ShuffleTranspositionSingletonLocal {
    String encipher(String plaintext, int key);

    String decipher(String ciphertext, int key);
}
