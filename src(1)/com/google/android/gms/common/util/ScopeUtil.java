package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.Scope;
import java.util.Set;

@KeepForSdk
public final class ScopeUtil
{
  private ScopeUtil() {}
  
  public static String[] toScopeString(Set paramSet)
  {
    Preconditions.checkNotNull(paramSet, "scopes can't be null.");
    paramSet = (Scope[])paramSet.toArray(new Scope[paramSet.size()]);
    Preconditions.checkNotNull(paramSet, "scopes can't be null.");
    String[] arrayOfString = new String[paramSet.length];
    int i = 0;
    while (i < paramSet.length)
    {
      arrayOfString[i] = paramSet[i].getScopeUri();
      i += 1;
    }
    return arrayOfString;
  }
}
