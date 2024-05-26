package net.johnnyconsole.beans.bit_shift;

import javax.ejb.Remote;

@Remote
public interface BitShiftRemote {
	
	public String encipher(String message, boolean shift, int key);
}
