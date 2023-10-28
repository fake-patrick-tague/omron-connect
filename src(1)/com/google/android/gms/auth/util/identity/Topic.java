package com.google.android.gms.auth.util.identity;

import com.google.android.gms.auth.api.identity.zbl;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.package_12.Api.ApiOptions.Optional;

public final class Topic
  implements Api.ApiOptions.Optional
{
  public Topic() {}
  
  public final boolean equals(Object paramObject)
  {
    return paramObject instanceof Topic;
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { zbl.class });
  }
}
