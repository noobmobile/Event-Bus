package com.dont.eventbus.managers;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import com.dont.eventbus.models.Event;
import com.dont.eventbus.models.EventHandler;
import com.dont.eventbus.models.Invocation;
import com.dont.eventbus.models.Listener;

public class EventBus {

	private Map<Class<? extends Event>, Set<Invocation>> invocations;

	public EventBus() {
		invocations = new ConcurrentHashMap<>();
	}

	public void callEvent(Event event) {
		if (invocations.containsKey(event.getClass())) {
			invocations.get(event.getClass()).forEach(invocation -> invocation.invoke(event));
		}
	}

	public void registerEvents(Listener listener) {
		List<Method> methods = getHandlerMethods(listener.getClass());
		methods.forEach(method -> {
			Invocation invocation = new Invocation(method, listener);
			Class<? extends Event> type = (Class<? extends Event>) method.getParameterTypes()[0];
			if (invocations.containsKey(type)) invocations.get(type).add(invocation);
			else {
				Set<Invocation> temp = new HashSet<>();
				temp.add(invocation);
				invocations.put(type, temp);
			}
		});
	}

	private List<Method> getHandlerMethods(Class<? extends Listener> clazz) {
		return Arrays.asList(clazz.getDeclaredMethods()).stream()
				.filter(method -> method.isAnnotationPresent(EventHandler.class))
				.filter(method -> method.getParameterCount() == 1)
				.filter(method -> Event.class.isAssignableFrom(method.getParameterTypes()[0]))
				.collect(Collectors.toList());
	}

}
