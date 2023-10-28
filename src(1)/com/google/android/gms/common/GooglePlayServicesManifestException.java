package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepName;

@KeepName
public class GooglePlayServicesManifestException
  extends IllegalStateException
{
  private final int ElementIndex;
  
  public GooglePlayServicesManifestException(int paramInt, String paramString)
  {
    super(paramString);
    ElementIndex = paramInt;
  }
  
  public int getActualVersion()
  {
    return ElementIndex;
  }
  
  public int getExpectedVersion()
  {
    return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  }
}
