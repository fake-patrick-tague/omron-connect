package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class ByteVector
{
  public static int add(double paramDouble)
  {
    if ((!Double.isNaN(paramDouble)) && (!Double.isInfinite(paramDouble)))
    {
      boolean bool = paramDouble < 0.0D;
      if (bool)
      {
        int i;
        if (bool) {
          bool = true;
        } else {
          i = -1;
        }
        return (int)(i * Math.floor(Math.abs(paramDouble)) % 4.294967296E9D);
      }
    }
    return 0;
  }
  
  public static int add(Headers paramHeaders)
  {
    int i = add(paramHeaders.get("runtime.counter").get().doubleValue() + 1.0D);
    if (i <= 1000000)
    {
      paramHeaders.set("runtime.counter", new zzah(Double.valueOf(i)));
      return i;
    }
    throw new IllegalStateException("Instructions allowed exceeded");
  }
  
  public static void add(String paramString, int paramInt, List paramList)
  {
    if (paramList.size() >= paramInt) {
      return;
    }
    throw new IllegalArgumentException(String.format("%s operation requires at least %s parameters found %s", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(paramList.size()) }));
  }
  
  public static boolean add(zzap paramZzap)
  {
    if (paramZzap == null) {
      return false;
    }
    paramZzap = paramZzap.get();
    return (!paramZzap.isNaN()) && (paramZzap.doubleValue() >= 0.0D) && (paramZzap.equals(Double.valueOf(Math.floor(paramZzap.doubleValue()))));
  }
  
  public static boolean add(zzap paramZzap1, zzap paramZzap2)
  {
    if (!paramZzap1.getClass().equals(paramZzap2.getClass())) {
      return false;
    }
    if (!(paramZzap1 instanceof zzau))
    {
      if ((paramZzap1 instanceof zzan)) {
        return true;
      }
      if ((paramZzap1 instanceof zzah))
      {
        if (!Double.isNaN(paramZzap1.get().doubleValue()))
        {
          if (Double.isNaN(paramZzap2.get().doubleValue())) {
            return false;
          }
          return paramZzap1.get().equals(paramZzap2.get());
        }
        return false;
      }
      if ((paramZzap1 instanceof zzat)) {
        return paramZzap1.getValue().equals(paramZzap2.getValue());
      }
      if ((paramZzap1 instanceof zzaf)) {
        return paramZzap1.value().equals(paramZzap2.value());
      }
      return paramZzap1 == paramZzap2;
    }
    return true;
  }
  
  public static zzbl get(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (!paramString.isEmpty()) {
        localObject1 = zzbl.join(Integer.parseInt(paramString));
      }
    }
    if (localObject1 != null) {
      return localObject1;
    }
    throw new IllegalArgumentException(String.format("Unsupported commandId %s", new Object[] { paramString }));
  }
  
  public static Object get(zzap paramZzap)
  {
    if (zzap.items.equals(paramZzap)) {
      return null;
    }
    if (zzap.this$0.equals(paramZzap)) {
      return "";
    }
    if ((paramZzap instanceof zzam)) {
      return read((zzam)paramZzap);
    }
    if ((paramZzap instanceof zzae))
    {
      ArrayList localArrayList = new ArrayList();
      paramZzap = ((zzae)paramZzap).iterator();
      while (paramZzap.hasNext())
      {
        Object localObject = get((zzap)paramZzap.next());
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
      return localArrayList;
    }
    if (!paramZzap.get().isNaN()) {
      return paramZzap.get();
    }
    return paramZzap.getValue();
  }
  
  public static double pow(double paramDouble)
  {
    if (Double.isNaN(paramDouble)) {
      return 0.0D;
    }
    double d = paramDouble;
    if (!Double.isInfinite(paramDouble))
    {
      boolean bool = paramDouble < 0.0D;
      d = paramDouble;
      if (bool)
      {
        if (!bool) {
          return paramDouble;
        }
        int i;
        if (bool) {
          bool = true;
        } else {
          i = -1;
        }
        d = i * Math.floor(Math.abs(paramDouble));
      }
    }
    return d;
  }
  
  public static void put(String paramString, int paramInt, List paramList)
  {
    if (paramList.size() <= paramInt) {
      return;
    }
    throw new IllegalArgumentException(String.format("%s operation requires at most %s parameters found %s", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(paramList.size()) }));
  }
  
  public static Map read(zzam paramZzam)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramZzam.getHeaderValues().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = get(paramZzam.get(str));
      if (localObject != null) {
        localHashMap.put(str, localObject);
      }
    }
    return localHashMap;
  }
  
  public static void set(String paramString, int paramInt, List paramList)
  {
    if (paramList.size() == paramInt) {
      return;
    }
    throw new IllegalArgumentException(String.format("%s operation requires %s parameters found %s", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(paramList.size()) }));
  }
  
  public static long write(double paramDouble)
  {
    return add(paramDouble) & 0xFFFFFFFF;
  }
}
