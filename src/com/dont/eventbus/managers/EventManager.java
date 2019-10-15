package com.dont.eventbus.managers;

import com.dont.eventbus.models.Event;
import com.dont.eventbus.models.Listener;

public class EventManager {

	private static final EventBus EVENT_BUS = new EventBus();
	public EventManager() {
		
	}
	
	public static void callEvent(Event event) {
		EVENT_BUS.callEvent(event);
	}
	
	public static void registerEvents(Listener listener) {
		EVENT_BUS.registerEvents(listener);
	}
	
	
}
