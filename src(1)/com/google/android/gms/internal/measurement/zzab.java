package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class zzab
{
  private final List list;
  private zzaa map;
  private zzaa next;
  
  public zzab()
  {
    map = new zzaa("", 0L, null);
    next = new zzaa("", 0L, null);
    list = new ArrayList();
  }
  
  public zzab(zzaa paramZzaa)
  {
    map = paramZzaa;
    next = paramZzaa.get();
    list = new ArrayList();
  }
  
  public final void append(zzaa paramZzaa)
  {
    next = paramZzaa;
  }
  
  public final zzaa asMap()
  {
    return map;
  }
  
  public final void clear(zzaa paramZzaa)
  {
    map = paramZzaa;
    next = paramZzaa.get();
    list.clear();
  }
  
  public final zzaa get()
  {
    return next;
  }
  
  public final List getText()
  {
    return list;
  }
  
  public final void set(String paramString, long paramLong, Map paramMap)
  {
    list.add(new zzaa(paramString, paramLong, paramMap));
  }
}
