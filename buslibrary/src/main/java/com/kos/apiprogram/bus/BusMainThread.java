package com.kos.apiprogram.bus;

import android.os.Looper;

/**
 * Created on 03.03.2017.
 * Bus working only in main thread
 * @author Kos
 */
public class BusMainThread extends Bus {

	public BusMainThread(String identifier) {
		super(identifier);
	}

	public BusMainThread() {
		super();
	}

	/**
	 * throw exception if non-main thread
	 */
	@Override
	public void enforce() {
		if (Looper.myLooper() != Looper.getMainLooper()) {
			throw new IllegalStateException("Event bus " + this + " accessed from non-main thread " + Looper.myLooper());
		}
	}
}
