package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class Headers
{
  final zzax m_data;
  final Map map = new HashMap();
  final Map notes = new HashMap();
  public final Headers this$0;
  
  public Headers(Headers paramHeaders, zzax paramZzax)
  {
    this$0 = paramHeaders;
    m_data = paramZzax;
  }
  
  public final void add(String paramString, zzap paramZzap)
  {
    if (map.containsKey(paramString)) {
      return;
    }
    if (paramZzap == null)
    {
      notes.remove(paramString);
      return;
    }
    notes.put(paramString, paramZzap);
  }
  
  public final Headers get()
  {
    return new Headers(this, m_data);
  }
  
  public final zzap get(zzae paramZzae)
  {
    Object localObject = zzap.this$0;
    Iterator localIterator = paramZzae.getValues();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      zzap localZzap = m_data.add(this, paramZzae.get(i));
      localObject = localZzap;
      if ((localZzap instanceof zzag)) {
        return localZzap;
      }
    }
    return localObject;
  }
  
  public final zzap get(zzap paramZzap)
  {
    return m_data.add(this, paramZzap);
  }
  
  public final zzap get(String paramString)
  {
    if (notes.containsKey(paramString)) {
      return (zzap)notes.get(paramString);
    }
    Headers localHeaders = this$0;
    if (localHeaders != null) {
      return localHeaders.get(paramString);
    }
    throw new IllegalArgumentException(String.format("%s is not defined", new Object[] { paramString }));
  }
  
  public final void put(String paramString, zzap paramZzap)
  {
    add(paramString, paramZzap);
    map.put(paramString, Boolean.TRUE);
  }
  
  public final void set(String paramString, zzap paramZzap)
  {
    if (!notes.containsKey(paramString))
    {
      Headers localHeaders = this$0;
      if ((localHeaders != null) && (localHeaders.set(paramString)))
      {
        this$0.set(paramString, paramZzap);
        return;
      }
    }
    if (map.containsKey(paramString)) {
      return;
    }
    if (paramZzap == null)
    {
      notes.remove(paramString);
      return;
    }
    notes.put(paramString, paramZzap);
  }
  
  public final boolean set(String paramString)
  {
    if (notes.containsKey(paramString)) {
      return true;
    }
    Headers localHeaders = this$0;
    if (localHeaders != null) {
      return localHeaders.set(paramString);
    }
    return false;
  }
}
