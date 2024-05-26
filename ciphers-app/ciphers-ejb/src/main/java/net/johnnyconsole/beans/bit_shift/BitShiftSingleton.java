package net.johnnyconsole.beans.bit_shift;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class BitShiftSingleton implements BitShiftLocal, BitShiftRemote {


    // TODO: FIX THIS!!
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
        String s = Integer.toBinaryString((byte)c);
        for(int i = 0; i < key; i++) {
            s = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
        }
        return (char)(Integer.parseInt(s, 2));
    }

    private char rol(char c, int key) {
        String s = Integer.toBinaryString((byte)c);
        for(int i = 0; i < key; i++) {
            s = s.substring(1) + s.charAt(0);
        }
        return (char)(Integer.parseInt(s, 2));
    }


}
