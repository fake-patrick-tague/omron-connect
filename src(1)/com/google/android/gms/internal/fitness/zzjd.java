package com.google.android.gms.internal.fitness;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzjd
  implements Iterator<Map.Entry<K, V>>
{
  private int nextIndex;
  private Iterator<Map.Entry<K, V>> zzabk;
  
  private zzjd(zzjb paramZzjb)
  {
    nextIndex = zzjb.access$getResults(paramZzjb).size();
  }
  
  private final Iterator zzdm()
  {
    if (zzabk == null) {
      zzabk = zzjb.getAreas(zzabl).entrySet().iterator();
    }
    return zzabk;
  }
  
  public final boolean hasNext()
  {
    int i = nextIndex;
    return ((i > 0) && (i <= zzjb.access$getResults(zzabl).size())) || (zzdm().hasNext());
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}
