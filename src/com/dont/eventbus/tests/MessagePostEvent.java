package com.dont.eventbus.tests;

import com.dont.eventbus.models.Cancellable;
import com.dont.eventbus.models.Event;

public class MessagePostEvent extends Event implements Cancellable{

	private String message;
	private boolean cancelled;
	public MessagePostEvent(String message) {
		super();
		this.message = message;
		this.cancelled = false;
	}
	@Override
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}
	@Override
	public boolean isCancelled() {
		return cancelled;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
