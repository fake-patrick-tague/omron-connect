package com.braze.events;

public abstract interface IEventSubscriber<T>
{
  public abstract void trigger(Object paramObject);
}
