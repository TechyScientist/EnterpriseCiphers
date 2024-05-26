package net.johnnyconsole.beans.bit_shift;

import javax.ejb.Local;

@Local
public interface BitShiftLocal {

	public String encipher(String message, boolean shift, int key);

}
