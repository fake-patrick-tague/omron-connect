package com.google.android.gms.common.package_12.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.package_12.Attribute;

public final class ApiKey<O extends com.google.android.gms.common.api.Api.ApiOptions>
{
  private final String data;
  private final Api<O> delegate;
  private final int hashcode;
  private final O key;
  
  private ApiKey(Attribute paramAttribute, com.google.android.gms.common.package_12.Api.ApiOptions paramApiOptions, String paramString)
  {
    delegate = paramAttribute;
    key = paramApiOptions;
    data = paramString;
    hashcode = Objects.hashCode(new Object[] { paramAttribute, paramApiOptions, paramString });
  }
  
  public static ApiKey addAttribute(Attribute paramAttribute, com.google.android.gms.common.package_12.Api.ApiOptions paramApiOptions, String paramString)
  {
    return new ApiKey(paramAttribute, paramApiOptions, paramString);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof ApiKey)) {
      return false;
    }
    paramObject = (ApiKey)paramObject;
    return (Objects.equal(delegate, delegate)) && (Objects.equal(key, key)) && (Objects.equal(data, data));
  }
  
  public final String get()
  {
    return delegate.get();
  }
  
  public final int hashCode()
  {
    return hashcode;
  }
}
