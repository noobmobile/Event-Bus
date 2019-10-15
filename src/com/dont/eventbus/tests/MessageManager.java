package com.dont.eventbus.tests;

import com.dont.eventbus.managers.EventManager;

public class MessageManager {

	public static void postMessage(String message) {
		MessagePostEvent event = new MessagePostEvent(message);
		EventManager.callEvent(event);
		if (!event.isCancelled()) {
			System.out.println("mensagem recebida: "+event.getMessage());
		}
	}
	
}
