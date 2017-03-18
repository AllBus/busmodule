package com.kos.apiprogram.bus;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on 16.02.2017.
 *
 * @author Kos
 */
public class Bus {
	public static final String DEFAULT_IDENTIFIER = "default";

	public static final int FLAG_ALL = 0xFFFFFFFF;
	public static final int FLAG_SETTING = 0x04000000;
	public static final int FLAG_DIALOG = 0x02000000;
	public static final int FLAG_ALERT = 0x01000000;

	/**
	 * Identifier used to differentiate the event bus instance.
	 */
	private final String identifier;

	/**
	 * Creates a new Bus named {@code identifier}
	 */
	public Bus(  String identifier) {
		this.identifier = identifier;
	}

	/**
	 * All registered event handlers, indexed by event type.
	 */
	final private Set<IBusEvent> handlers = new HashSet<>();
	//Collections.newSetFromMap(new util.WeakHashMap[IBusEvent, Boolean]())

	/**
	 * Creates a new Bus named "default"
	 */
	public Bus() {
		this(Bus.DEFAULT_IDENTIFIER);
	}


	@Override
	public String toString() {
		return "[Bus \"" + identifier + "\"]";
	}

	/**
	 * Register object as event handler
	 * @param object  event handler
	 */
	public void register(IBusEvent object) {
		if (object == null) {
			throw new NullPointerException("Object to register must not be null.");
		}
		enforce();
		handlers.add(object);
	}


	/**
	 * Unregister event handler
	 * @param object event handler
	 */
	public void unregister(IBusEvent object) {
		if (object == null) {
			throw new NullPointerException("Object to unregister must not be null.");
		}
		enforce();
		handlers.remove(object);
	}

	/**
	 * Posting object on all handlers with flag contains {@code event} flag
	 * @param event object for handle
	 */
	public void post(IBusSender event) {
		if (event == null) {
			return;
		}
		enforce();

		int eventFlag = event.flags();
		for (IBusEvent x : handlers) {
			if (x != null && (eventFlag & x.busFlags()) != 0) {
				x.busUpdate(event);
			}
		}
	}

	/**
	 * override this method for check thread
	 */
	public void enforce() {

	}
}
