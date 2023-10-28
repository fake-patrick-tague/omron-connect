package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public final class IntArray
{
  final TreeMap map = new TreeMap();
  final TreeMap this$0 = new TreeMap();
  
  public IntArray() {}
  
  private static final int add(Headers paramHeaders, zzao paramZzao, zzap paramZzap)
  {
    paramHeaders = paramZzao.get(paramHeaders, Collections.singletonList(paramZzap));
    if ((paramHeaders instanceof zzah)) {
      return ByteVector.add(paramHeaders.get().doubleValue());
    }
    return -1;
  }
  
  public final void add(Headers paramHeaders, zzab paramZzab)
  {
    Roster.RosterPushListener localRosterPushListener = new Roster.RosterPushListener(paramZzab);
    Object localObject = this$0.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      zzaa localZzaa = paramZzab.get().get();
      int i = add(paramHeaders, (zzao)this$0.get(localInteger), localRosterPushListener);
      if ((i == 2) || (i == -1)) {
        paramZzab.append(localZzaa);
      }
    }
    paramZzab = map.keySet().iterator();
    while (paramZzab.hasNext())
    {
      localObject = (Integer)paramZzab.next();
      add(paramHeaders, (zzao)map.get(localObject), localRosterPushListener);
    }
  }
  
  public final void add(String paramString1, int paramInt, zzao paramZzao, String paramString2)
  {
    if ("create".equals(paramString2))
    {
      paramString1 = map;
    }
    else
    {
      if (!"edit".equals(paramString2)) {
        break label73;
      }
      paramString1 = this$0;
    }
    int i = paramInt;
    if (paramString1.containsKey(Integer.valueOf(paramInt))) {
      i = ((Integer)paramString1.lastKey()).intValue() + 1;
    }
    paramString1.put(Integer.valueOf(i), paramZzao);
    return;
    label73:
    throw new IllegalStateException("Unknown callback type: ".concat(String.valueOf(paramString2)));
  }
}
