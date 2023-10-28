package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

final class zzlg
{
  zzlg() {}
  
  public static final int remove(int paramInt, Object paramObject1, Object paramObject2)
  {
    paramObject1 = (zzlf)paramObject1;
    paramObject2 = (zzle)paramObject2;
    if (!paramObject1.isEmpty())
    {
      paramObject1 = paramObject1.entrySet().iterator();
      if (paramObject1.hasNext()) {}
    }
    else
    {
      return 0;
    }
    paramObject1 = (Map.Entry)paramObject1.next();
    paramObject1.getKey();
    paramObject1.getValue();
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public static final Object set(Object paramObject1, Object paramObject2)
  {
    zzlf localZzlf = (zzlf)paramObject1;
    paramObject2 = (zzlf)paramObject2;
    paramObject1 = localZzlf;
    if (!paramObject2.isEmpty())
    {
      paramObject1 = localZzlf;
      if (!localZzlf.a()) {
        paramObject1 = localZzlf.getValue();
      }
      paramObject1.putAll(paramObject2);
    }
    return paramObject1;
  }
}
