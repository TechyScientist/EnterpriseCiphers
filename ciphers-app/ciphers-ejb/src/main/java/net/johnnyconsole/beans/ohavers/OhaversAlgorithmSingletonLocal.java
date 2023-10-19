package net.johnnyconsole.beans.ohavers;

import javax.ejb.Local;

@Local
public interface OhaversAlgorithmSingletonLocal {
	
	public String encipher(String message);

}
