package net.johnnyconsole.beans.bit_shift;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class BitShiftSingleton implements BitShiftLocal, BitShiftRemote {


    // TODO: FIX THIS!!
	@Override
	public String encipher(String message, boolean shift, int key) {
        StringBuilder ciphertext = new StringBuilder();
        for(int i = 0; i < message.length(); i++) {
            if(shift) {
                ciphertext.append(rol(message.charAt(i), key));
            }
            else {
                ciphertext.append(ror(message.charAt(i), key));
            }
        }
        return ciphertext.toString();
	}

    private char ror(char c, int key) {
        return (char)((((byte)c & 0xff) >>> key) | (((byte)c & 0xff) << (Integer.SIZE - key)));
    }

    private char rol(char c, int key) {
        return (char)((((byte)c & 0xff) << key) | (((byte)c & 0xff) >>> (Integer.SIZE - key)));
    }


}
