package com.google.android.gms.common.package_12;

import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.Preconditions;

public final class Attribute<O extends Api.ApiOptions>
{
  private final String a;
  private final com.google.android.gms.common.api.Api.ClientKey<?> key;
  private final com.google.android.gms.common.api.Api.AbstractClientBuilder<?, O> state;
  
  public Attribute(String paramString, Api.AbstractClientBuilder paramAbstractClientBuilder, Api.ClientKey paramClientKey)
  {
    Preconditions.checkNotNull(paramAbstractClientBuilder, "Cannot construct an Api with a null ClientBuilder");
    Preconditions.checkNotNull(paramClientKey, "Cannot construct an Api with a null ClientKey");
    a = paramString;
    state = paramAbstractClientBuilder;
    key = paramClientKey;
  }
  
  public final String get()
  {
    return a;
  }
  
  public final Api.AnyClientKey getKey()
  {
    return key;
  }
  
  public final Api.BaseClientBuilder getState()
  {
    return state;
  }
  
  public final Api.AbstractClientBuilder getValue()
  {
    return state;
  }
}
