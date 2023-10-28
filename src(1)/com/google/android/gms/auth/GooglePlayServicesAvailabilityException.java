package com.google.android.gms.auth;

import android.content.Intent;

public class GooglePlayServicesAvailabilityException
  extends UserRecoverableAuthException
{
  private final int ElementIndex;
  
  GooglePlayServicesAvailabilityException(int paramInt, String paramString, Intent paramIntent)
  {
    super(paramString, paramIntent);
    ElementIndex = paramInt;
  }
  
  public int getConnectionStatusCode()
  {
    return ElementIndex;
  }
}
