package com.google.android.gms.internal.fitness;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzig
  implements zzid
{
  zzig() {}
  
  public final zzib getMethod(Object paramObject)
  {
    paramObject = (zzic)paramObject;
    throw new NoSuchMethodError();
  }
  
  public final Object getName(Object paramObject)
  {
    ((zzie)paramObject).zzar();
    return paramObject;
  }
  
  public final Map getProperties(Object paramObject)
  {
    return (zzie)paramObject;
  }
  
  public final int register(int paramInt, Object paramObject1, Object paramObject2)
  {
    paramObject1 = (zzie)paramObject1;
    paramObject2 = (zzic)paramObject2;
    if (paramObject1.isEmpty()) {
      return 0;
    }
    paramObject1 = paramObject1.entrySet().iterator();
    if (!paramObject1.hasNext()) {
      return 0;
    }
    paramObject1 = (Map.Entry)paramObject1.next();
    paramObject1.getKey();
    paramObject1.getValue();
    throw new NoSuchMethodError();
  }
  
  public final Object set(Object paramObject1, Object paramObject2)
  {
    zzie localZzie = (zzie)paramObject1;
    paramObject2 = (zzie)paramObject2;
    paramObject1 = localZzie;
    if (!paramObject2.isEmpty())
    {
      paramObject1 = localZzie;
      if (!localZzie.isMutable()) {
        paramObject1 = localZzie.zzcn();
      }
      paramObject1.setProperties(paramObject2);
    }
    return paramObject1;
  }
}
