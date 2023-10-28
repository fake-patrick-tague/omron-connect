package com.google.android.gms.common.package_12.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;

final class zabs
{
  private final Feature name;
  private final ApiKey<?> scope;
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof zabs)))
    {
      paramObject = (zabs)paramObject;
      if ((Objects.equal(scope, scope)) && (Objects.equal(name, name))) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { scope, name });
  }
  
  public final String toString()
  {
    return Objects.toStringHelper(this).name("key", scope).name("feature", name).toString();
  }
}
