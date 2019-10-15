package com.dont.eventbus.tests;

import com.dont.eventbus.models.Event;
import com.dont.eventbus.models.EventHandler;
import com.dont.eventbus.models.Listener;

public class Teste implements Listener{

	@EventHandler
	public void onTeste(PlayerDeathEvent e) {
		System.out.println("a");
	}
	
	@EventHandler
	public void onTeste2(PlayerDeathEvent e) {
		System.out.println("b");
	}
	
	@EventHandler
	public void onTeste3(PlayerSpawnEvent e) {
		System.out.println("c");
	}
	
}
