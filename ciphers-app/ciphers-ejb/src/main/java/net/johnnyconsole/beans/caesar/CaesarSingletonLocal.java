package net.johnnyconsole.beans.caesar;

import javax.ejb.Local;

@Local
public interface CaesarSingletonLocal {
	
	public String encipher(String message, String cipherKey);

}
