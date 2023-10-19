package net.johnnyconsole.beans.ohavers;

import javax.ejb.Remote;

@Remote
public interface OhaversAlgorithmSingletonRemote {
	
	public String encipher(String message);
}
