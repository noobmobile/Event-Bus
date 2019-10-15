package com.dont.eventbus;

import com.dont.eventbus.managers.EventManager;
import com.dont.eventbus.tests.PlayerSpawnEvent;
import com.dont.eventbus.tests.Teste;

public class Main {

	public static void main(String[] args) {
		EventManager.registerEvents(new Teste());
		EventManager.callEvent(new PlayerSpawnEvent());
	}

}
