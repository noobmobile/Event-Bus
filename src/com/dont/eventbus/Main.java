package com.dont.eventbus;

import com.dont.eventbus.managers.EventManager;
import com.dont.eventbus.tests.MessageManager;
import com.dont.eventbus.tests.Teste;

public class Main {

	public static void main(String[] args) {
		EventManager.registerEvents(new Teste());
		MessageManager.postMessage("ola como vai");
		MessageManager.postMessage("teste1");
		MessageManager.postMessage("teste2");
		MessageManager.postMessage("tudo bem?");
		EventManager.unregisterEvents(Teste.class);
		MessageManager.postMessage("teste2");
	}

}
