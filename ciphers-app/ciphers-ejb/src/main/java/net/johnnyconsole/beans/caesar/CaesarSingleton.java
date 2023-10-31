package net.johnnyconsole.beans.caesar;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class CaesarSingleton implements CaesarSingletonLocal, CaesarSingletonRemote {

	@Override
	public String encipher(String message, String cipherKey) {
        for (int i = 0; i < message.length(); i++) {
            message = message.replace(message.charAt(i), cipherKey.charAt(message.charAt(i) - 'A'));
        }
        return message;
	}


}
