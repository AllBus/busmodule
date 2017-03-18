package com.kos.apiprogram.bus;

/**
 * Interface for all reciver objects
 * Created on 30.01.2017.
 *
 * @author Kos
 */

public interface IBusEvent {
	/**
	 * This method
	 * @param updater message object
	 */
	void busUpdate(IBusSender updater);

	/**
	 * received message types
	 * @return bit flag of received message types
	 */
	int busFlags();
}
