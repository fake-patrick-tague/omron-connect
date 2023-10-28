package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class TFloatList
{
  public static zzap get(zzgx paramZzgx)
  {
    if (paramZzgx == null) {
      return zzap.this$0;
    }
    int i = paramZzgx.testConnection() - 1;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4)
          {
            Object localObject = paramZzgx.get();
            ArrayList localArrayList = new ArrayList();
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext()) {
              localArrayList.add(get((zzgx)((Iterator)localObject).next()));
            }
            return new zzaq(paramZzgx.getFileSize(), localArrayList);
          }
          throw new IllegalArgumentException("Unknown type found. Cannot convert entity");
        }
        if (paramZzgx.call()) {
          return new zzaf(Boolean.valueOf(paramZzgx.getOriginId()));
        }
        return new zzaf(null);
      }
      if (paramZzgx.next()) {
        return new zzah(Double.valueOf(paramZzgx.getSize()));
      }
      return new zzah(null);
    }
    if (paramZzgx.writeValue()) {
      return new zzat(paramZzgx.getCertainty());
    }
    return zzap.list;
  }
  
  public static zzap set(Object paramObject)
  {
    if (paramObject == null) {
      return zzap.items;
    }
    if ((paramObject instanceof String)) {
      return new zzat((String)paramObject);
    }
    if ((paramObject instanceof Double)) {
      return new zzah((Double)paramObject);
    }
    if ((paramObject instanceof Long)) {
      return new zzah(Double.valueOf(((Long)paramObject).doubleValue()));
    }
    if ((paramObject instanceof Integer)) {
      return new zzah(Double.valueOf(((Integer)paramObject).doubleValue()));
    }
    if ((paramObject instanceof Boolean)) {
      return new zzaf((Boolean)paramObject);
    }
    Object localObject2;
    Object localObject1;
    if ((paramObject instanceof Map))
    {
      localObject2 = new zzam();
      Map localMap = (Map)paramObject;
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = localIterator.next();
        paramObject = localObject1;
        zzap localZzap = set(localMap.get(localObject1));
        if (localObject1 != null)
        {
          if (!(localObject1 instanceof String)) {
            paramObject = localObject1.toString();
          }
          ((zzam)localObject2).add((String)paramObject, localZzap);
        }
      }
      return localObject2;
    }
    if ((paramObject instanceof List))
    {
      localObject1 = new zzae();
      paramObject = ((List)paramObject).iterator();
      while (paramObject.hasNext())
      {
        localObject2 = set(paramObject.next());
        ((zzae)localObject1).add(((zzae)localObject1).next(), (zzap)localObject2);
      }
      return localObject1;
    }
    throw new IllegalArgumentException("Invalid value type");
  }
}
