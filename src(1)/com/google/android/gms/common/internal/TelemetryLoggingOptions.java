package com.google.android.gms.common.internal;

import android.os.BaseBundle;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.package_12.Api.ApiOptions.Optional;

@KeepForSdk
public class TelemetryLoggingOptions
  implements Api.ApiOptions.Optional
{
  public static final TelemetryLoggingOptions client = builder().build();
  private final String defaultValue;
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof TelemetryLoggingOptions)) {
      return false;
    }
    paramObject = (TelemetryLoggingOptions)paramObject;
    return Objects.equal(defaultValue, defaultValue);
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { defaultValue });
  }
  
  public final Bundle readMessage()
  {
    Bundle localBundle = new Bundle();
    String str = defaultValue;
    if (str != null) {
      localBundle.putString("api", str);
    }
    return localBundle;
  }
  
  @KeepForSdk
  public static class Builder
  {
    private String band;
    
    private Builder() {}
    
    public TelemetryLoggingOptions build()
    {
      return new TelemetryLoggingOptions(band, null);
    }
    
    public Builder setApi(String paramString)
    {
      band = paramString;
      return this;
    }
  }
}
