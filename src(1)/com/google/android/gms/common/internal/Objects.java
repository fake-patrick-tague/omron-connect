package com.google.android.gms.common.internal;

import android.os.BaseBundle;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@KeepForSdk
public final class Objects
{
  private Objects()
  {
    throw new AssertionError("Uninstantiable");
  }
  
  public static boolean checkBundlesEquality(Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramBundle1 != null) && (paramBundle2 != null))
    {
      if (paramBundle1.size() != paramBundle2.size()) {
        return false;
      }
      Object localObject = paramBundle1.keySet();
      if (!((Set)localObject).containsAll(paramBundle2.keySet())) {
        return false;
      }
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!equal(paramBundle1.get(str), paramBundle2.get(str))) {
          return false;
        }
      }
      return true;
    }
    return paramBundle1 == paramBundle2;
  }
  
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != paramObject2)
    {
      if (paramObject1 == null) {
        break label24;
      }
      if (!paramObject1.equals(paramObject2)) {
        return false;
      }
    }
    return true;
    label24:
    return false;
  }
  
  public static int hashCode(Object... paramVarArgs)
  {
    return Arrays.hashCode(paramVarArgs);
  }
  
  public static ToStringHelper toStringHelper(Object paramObject)
  {
    return new ToStringHelper(paramObject, null);
  }
  
  @KeepForSdk
  public static final class ToStringHelper
  {
    private final Object key;
    private final List values;
    
    public ToStringHelper name(String paramString, Object paramObject)
    {
      List localList = values;
      Preconditions.checkNotNull(paramString);
      paramObject = String.valueOf(paramObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("=");
      localStringBuilder.append(paramObject);
      localList.add(localStringBuilder.toString());
      return this;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append(key.getClass().getSimpleName());
      localStringBuilder.append('{');
      int j = values.size();
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append((String)values.get(i));
        if (i < j - 1) {
          localStringBuilder.append(", ");
        }
        i += 1;
      }
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
}
