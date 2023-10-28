package com.google.android.gms.auth.util.identity;

import com.google.android.gms.auth.api.identity.zbc;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.package_12.Api.ApiOptions.Optional;

public final class DBObject
  implements Api.ApiOptions.Optional
{
  public DBObject() {}
  
  public final boolean equals(Object paramObject)
  {
    return paramObject instanceof DBObject;
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { zbc.class });
  }
}
