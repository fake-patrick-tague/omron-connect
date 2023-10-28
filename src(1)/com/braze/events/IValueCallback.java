package com.braze.events;

public abstract interface IValueCallback<T>
{
  public abstract void onError();
  
  public abstract void onSuccess(Object paramObject);
}
