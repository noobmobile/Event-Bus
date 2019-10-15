package com.dont.eventbus.models;

public interface Cancellable {

	public void setCancelled(boolean cancelled);
	public boolean isCancelled();
	
}
