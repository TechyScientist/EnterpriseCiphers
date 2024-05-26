package net.johnnyconsole.beans.caesar;

import javax.ejb.Remote;

@Remote
public interface CaesarSingletonRemote {
	
	public String encipher(String message, String cipherKey);
	public String decipher(String message, String cipherKey);
}
