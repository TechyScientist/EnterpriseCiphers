package main.java.net.johnnyconsole.beans.transposition.shuffle;

import javax.ejb.Remote;

@Remote
public interface ShuffleTranspositionSingletonRemote {
    String encipher(String plaintext, int key);

    String decipher(String ciphertext, int key);
}
