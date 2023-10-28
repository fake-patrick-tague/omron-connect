package com.google.android.gms.fitness.data;

import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@ShowFirstParty
public final class zzah
{
  private static final double zzoi;
  private static final double zzoj;
  private static final double zzok;
  private static final double zzol;
  public static final Set<String> zzom = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "altitude", "duration", "food_item", "meal_type", "repetitions", "resistance", "resistance_type" })));
  private static final zzah zzop = new zzah();
  private final Map<String, Map<String, zzaj>> zzon;
  private final Map<String, zzaj> zzoo;
  
  static
  {
    TimeUnit localTimeUnit = TimeUnit.SECONDS;
    zzoi = 10.0D / localTimeUnit.toNanos(1L);
    zzoj = 1000.0D / localTimeUnit.toNanos(1L);
    zzok = 2000.0D / TimeUnit.HOURS.toNanos(1L);
    zzol = 100.0D / localTimeUnit.toNanos(1L);
  }
  
  private zzah()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("latitude", new zzaj(-90.0D, 90.0D, null));
    localHashMap.put("longitude", new zzaj(-180.0D, 180.0D, null));
    localHashMap.put("accuracy", new zzaj(0.0D, 10000.0D, null));
    localHashMap.put("bpm", new zzaj(0.0D, 1000.0D, null));
    localHashMap.put("altitude", new zzaj(-100000.0D, 100000.0D, null));
    localHashMap.put("percentage", new zzaj(0.0D, 100.0D, null));
    localHashMap.put("confidence", new zzaj(0.0D, 100.0D, null));
    localHashMap.put("duration", new zzaj(0.0D, 9.223372036854776E18D, null));
    localHashMap.put("height", new zzaj(0.0D, 3.0D, null));
    localHashMap.put("weight", new zzaj(0.0D, 1000.0D, null));
    localHashMap.put("speed", new zzaj(0.0D, 11000.0D, null));
    zzoo = Collections.unmodifiableMap(localHashMap);
    localHashMap = new HashMap();
    localHashMap.put("com.google.step_count.delta", add("steps", new zzaj(0.0D, zzoi, null)));
    localHashMap.put("com.google.calories.consumed", add("calories", new zzaj(0.0D, zzoj, null)));
    localHashMap.put("com.google.calories.expended", add("calories", new zzaj(0.0D, zzok, null)));
    localHashMap.put("com.google.distance.delta", add("distance", new zzaj(0.0D, zzol, null)));
    zzon = Collections.unmodifiableMap(localHashMap);
  }
  
  private static Map add(Object paramObject1, Object paramObject2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramObject1, paramObject2);
    return localHashMap;
  }
  
  public static zzah getSecond()
  {
    return zzop;
  }
  
  public final zzaj format(String paramString1, String paramString2)
  {
    paramString1 = (Map)zzon.get(paramString1);
    if (paramString1 != null) {
      return (zzaj)paramString1.get(paramString2);
    }
    return null;
  }
  
  public final zzaj getClass(String paramString)
  {
    return (zzaj)zzoo.get(paramString);
  }
}
