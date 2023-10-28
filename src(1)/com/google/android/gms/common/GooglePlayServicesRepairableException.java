package com.google.android.gms.common;

import android.content.Intent;

public class GooglePlayServicesRepairableException
  extends UserRecoverableException
{
  private final int ElementIndex;
  
  public GooglePlayServicesRepairableException(int paramInt, String paramString, Intent paramIntent)
  {
    super(paramString, paramIntent);
    ElementIndex = paramInt;
  }
  
  public int getConnectionStatusCode()
  {
    return ElementIndex;
  }
}
