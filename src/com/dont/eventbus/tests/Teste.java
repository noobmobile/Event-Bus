package com.dont.eventbus.tests;

import com.dont.eventbus.models.Event;
import com.dont.eventbus.models.EventHandler;
import com.dont.eventbus.models.EventPriority;
import com.dont.eventbus.models.Listener;

public class Teste implements Listener{

	@EventHandler
	public void onTeste3(MessagePostEvent e) {
		if (e.getMessage().equalsIgnoreCase("teste1")) {
			e.setMessage(e.getMessage()+" modificado");
		} else if (e.getMessage().equalsIgnoreCase("teste2")) {
			e.setCancelled(true);
			System.out.println("--- mensagem cancelada ---");
		}
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onTeste4(MessagePostEvent e) {
		if (e.getMessage().equalsIgnoreCase("teste1")) {
			e.setMessage(e.getMessage()+" desmodificado");
		}
	}
	
}
