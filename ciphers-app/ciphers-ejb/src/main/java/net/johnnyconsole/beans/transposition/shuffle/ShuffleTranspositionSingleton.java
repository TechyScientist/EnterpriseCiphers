package net.johnnyconsole.beans.transposition.shuffle;

import javax.ejb.Singleton;
import javax.ejb.LocalBean;

@Singleton
public class ShuffleTranspositionSingleton implements ShuffleTranspositionSingletonLocal, ShuffleTranspositionSingletonRemote {
    public String encipher(String plaintext, int key) {
        char[] ciphertext = new char[plaintext.length()];
        int start = 0, index = 0;
        for (char c : plaintext.toCharArray()) {
            ciphertext[index] = c;
            index += key;
            if(plaintext.length() <= index) {
                start++;
                if(key <= start) break;
                index = start;
            }
        }
        return new String(ciphertext);
    }

    public String decipher(String ciphertext, int key) {
        if(key >= ciphertext.length()) return ciphertext;
        StringBuilder plaintext = new StringBuilder();
        int index = 0;

        for (int i = 0; plaintext.length() != ciphertext.length() && i < ciphertext.length(); i++) {
            while(index < ciphertext.length()) {
                plaintext.append(ciphertext.charAt(index));
                index += key;
            }
            index = i + 1;
        }
        return plaintext.toString();
    }
}
