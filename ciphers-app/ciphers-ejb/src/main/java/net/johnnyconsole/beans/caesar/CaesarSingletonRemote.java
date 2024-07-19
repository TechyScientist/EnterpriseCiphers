package net.johnnyconsole.beans.caesar;

import javax.ejb.Remote;

@Remote
public interface CaesarSingletonRemote {
	
	String encipher(String message, String cipherKey);
	String decipher(String message, String cipherKey);
}
