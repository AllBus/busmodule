package com.kos.apiprogram.busmodule;

/**
 * Interface for all sent object
 * Created on 03.02.2017.
 *
 * @author Kos
 */

public interface IBusSender {
	/**
	 * message type
	 * @return bit flag of message types
	 */
	int flags();
}
