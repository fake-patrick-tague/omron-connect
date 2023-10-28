package com.google.android.gms.internal.fitness;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class zzjm
  extends AbstractSet<Map.Entry<K, V>>
{
  private zzjm(zzjb paramZzjb) {}
  
  public void clear()
  {
    zzabl.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    Object localObject = (Map.Entry)paramObject;
    paramObject = zzabl.get(((Map.Entry)localObject).getKey());
    localObject = ((Map.Entry)localObject).getValue();
    return (paramObject == localObject) || ((paramObject != null) && (paramObject.equals(localObject)));
  }
  
  public Iterator iterator()
  {
    return new zzjj(zzabl, null);
  }
  
  public boolean remove(Object paramObject)
  {
    paramObject = (Map.Entry)paramObject;
    if (contains(paramObject))
    {
      zzabl.remove(paramObject.getKey());
      return true;
    }
    return false;
  }
  
  public int size()
  {
    return zzabl.size();
  }
}
