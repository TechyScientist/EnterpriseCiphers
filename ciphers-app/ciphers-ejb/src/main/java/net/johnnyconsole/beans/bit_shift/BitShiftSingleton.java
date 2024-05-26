package net.johnnyconsole.beans.bit_shift;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class BitShiftSingleton implements BitShiftLocal, BitShiftRemote {

	@Override
	public String encipher(String message, boolean shift, int key) {
        StringBuilder ciphertext = new StringBuilder(message);
        for(int i = 0; i < message.length(); i++) {
            if(shift) {
                ciphertext.replace(i, i+1, rol(message.charAt(i), key) + "");
            }
            else {
                ciphertext.replace(i, i+1, ror(message.charAt(i), key) + "");
            }
        }
        return ciphertext.toString();
	}

    private char ror(char c, int key) {
        return (char)(((byte)c >>> (key % 8)) | ((byte)c << ((key % 8))));
    }

    private char rol(char c, int key) {
        return (char)(((byte)c << (key % 8)) | ((byte)c >>> ((key%8))));
    }


}
