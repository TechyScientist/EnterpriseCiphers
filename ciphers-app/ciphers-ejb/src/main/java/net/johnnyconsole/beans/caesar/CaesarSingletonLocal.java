package net.johnnyconsole.beans.caesar;

import javax.ejb.Local;

@Local
public interface CaesarSingletonLocal {
	
	String encipher(String message, String cipherKey);
	String decipher(String message, String cipherKey);

}
