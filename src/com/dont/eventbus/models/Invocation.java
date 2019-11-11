package com.dont.eventbus.models;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;


/**
 * Wrapper class holding the method to invoke and the target object,
 * serving as invokable values to be user inside the EventBus
 *
 * @author chermehdi
 */
public final class Invocation {

  private final Method handler;
  private final Listener targetObject;
  private final EventPriority priority;
  
  public Invocation(Method handler, Listener targetObject, EventPriority priority) {
    this.handler = handler;
    this.targetObject = targetObject;
    this.priority = priority;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Invocation that = (Invocation) o;
    return Objects.equals(handler, that.handler) &&
        Objects.equals(targetObject, that.targetObject);
  }

  @Override
  public int hashCode() {
    return Objects.hash(handler, targetObject);
  }

  
  
  public void invoke(Object object) {
    try {
      handler.invoke(targetObject, object);
    } catch (IllegalAccessException | InvocationTargetException e) {
      e.printStackTrace();
    }
  }

	public Class<? extends Listener> getMethodOwner(){
	  return targetObject.getClass();
  }
	
/**
 * @return the priority
 */
public EventPriority getEventPriority() {
	return priority;
}
}
