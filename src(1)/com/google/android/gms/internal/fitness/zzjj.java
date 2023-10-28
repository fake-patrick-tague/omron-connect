package com.google.android.gms.internal.fitness;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzjj
  implements Iterator<Map.Entry<K, V>>
{
  private int currentId = -1;
  private Iterator<Map.Entry<K, V>> zzabk;
  private boolean zzabo;
  
  private zzjj(zzjb paramZzjb) {}
  
  private final Iterator zzdm()
  {
    if (zzabk == null) {
      zzabk = zzjb.getPresences(zzabl).entrySet().iterator();
    }
    return zzabk;
  }
  
  public final boolean hasNext()
  {
    if (currentId + 1 >= zzjb.access$getResults(zzabl).size()) {
      return (!zzjb.getPresences(zzabl).isEmpty()) && (zzdm().hasNext());
    }
    return true;
  }
  
  public final void remove()
  {
    if (zzabo)
    {
      zzabo = false;
      zzjb.setAnswer(zzabl);
      if (currentId < zzjb.access$getResults(zzabl).size())
      {
        zzjb localZzjb = zzabl;
        int i = currentId;
        currentId = (i - 1);
        zzjb.valueOf(localZzjb, i);
        return;
      }
      zzdm().remove();
      return;
    }
    throw new IllegalStateException("remove() was called before next()");
  }
}
