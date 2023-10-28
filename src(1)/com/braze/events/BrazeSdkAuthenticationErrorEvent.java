package com.braze.events;

import kotlin.x.d.i;
import protect.package_9.Filter;

public final class BrazeSdkAuthenticationErrorEvent
{
  private final Filter sdkAuthError;
  
  public BrazeSdkAuthenticationErrorEvent(Filter paramFilter)
  {
    sdkAuthError = paramFilter;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof BrazeSdkAuthenticationErrorEvent)) {
      return false;
    }
    paramObject = (BrazeSdkAuthenticationErrorEvent)paramObject;
    return i.a(sdkAuthError, sdkAuthError);
  }
  
  public int hashCode()
  {
    return sdkAuthError.hashCode();
  }
  
  public String toString()
  {
    return sdkAuthError.toString();
  }
}
