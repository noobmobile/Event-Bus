package com.dont.eventbus.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public enum EventPriority{

	LOW(0), NORMAL(1), HIGH(2);
	
	private int priority;
	
	EventPriority(int priority){
		this.priority = priority;
	}
	
	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}
	
	
}
