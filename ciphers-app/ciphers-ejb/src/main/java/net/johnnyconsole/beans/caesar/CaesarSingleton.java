package net.johnnyconsole.beans.caesar;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class CaesarSingleton implements CaesarSingletonLocal, CaesarSingletonRemote {

	@Override
	public String encipher(String message, String cipherKey) {
        StringBuilder ciphertext = new StringBuilder(message);
        for (int i = 0; i < message.length(); i++) {
            if(message.charAt(i) == ' ') continue;
            ciphertext.replace(i, i + 1, cipherKey.charAt(message.charAt(i) - 'A') + "");
        }
        return ciphertext.toString();
	}

    @Override
    public String decipher(String message, String cipherKey) {
        StringBuilder plaintext = new StringBuilder(message);
        for (int i = 0; i < message.length(); i++) {
            if(message.charAt(i) == ' ') continue;
            plaintext.replace(i, i + 1, 'A' + (cipherKey.indexOf(message.charAt(i))) + "");
        }
        return plaintext.toString();
    }


}
