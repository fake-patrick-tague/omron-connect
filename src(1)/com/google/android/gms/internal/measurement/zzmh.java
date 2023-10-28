package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

final class zzmh
  extends AbstractSet
{
  public final void clear()
  {
    myMap.clear();
  }
  
  public final boolean contains(Object paramObject)
  {
    Object localObject = (Map.Entry)paramObject;
    paramObject = myMap.get(((Map.Entry)localObject).getKey());
    localObject = ((Map.Entry)localObject).getValue();
    if (paramObject != localObject)
    {
      if (paramObject == null) {
        break label50;
      }
      if (!paramObject.equals(localObject)) {
        return false;
      }
    }
    return true;
    label50:
    return false;
  }
  
  public final Iterator iterator()
  {
    return new zzmf(myMap, null);
  }
  
  public final boolean remove(Object paramObject)
  {
    paramObject = (Map.Entry)paramObject;
    if (contains(paramObject))
    {
      myMap.remove(paramObject.getKey());
      return true;
    }
    return false;
  }
  
  public final int size()
  {
    return myMap.size();
  }
}
