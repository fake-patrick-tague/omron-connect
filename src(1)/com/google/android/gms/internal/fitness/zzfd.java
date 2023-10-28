package com.google.android.gms.internal.fitness;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public abstract class zzfd<E>
  extends AbstractCollection<E>
  implements Serializable
{
  private static final Object[] zztg = new Object[0];
  
  zzfd() {}
  
  public final boolean add(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean addAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean contains(Object paramObject);
  
  int get(Object[] paramArrayOfObject, int paramInt)
  {
    zzfm localZzfm = (zzfm)iterator();
    while (localZzfm.hasNext())
    {
      paramArrayOfObject[paramInt] = localZzfm.next();
      paramInt += 1;
    }
    return paramInt;
  }
  
  public final boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean removeAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean retainAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public final Object[] toArray()
  {
    return toArray(zztg);
  }
  
  public final Object[] toArray(Object[] paramArrayOfObject)
  {
    zzez.checkNotNull(paramArrayOfObject);
    int i = size();
    Object[] arrayOfObject;
    if (paramArrayOfObject.length < i)
    {
      arrayOfObject = zzag();
      if (arrayOfObject != null) {
        return Arrays.copyOfRange(arrayOfObject, zzah(), zzai(), paramArrayOfObject.getClass());
      }
      arrayOfObject = (Object[])Array.newInstance(paramArrayOfObject.getClass().getComponentType(), i);
    }
    else
    {
      arrayOfObject = paramArrayOfObject;
      if (paramArrayOfObject.length > i)
      {
        paramArrayOfObject[i] = null;
        arrayOfObject = paramArrayOfObject;
      }
    }
    get(arrayOfObject, 0);
    return arrayOfObject;
  }
  
  public abstract zzfm zzae();
  
  public zzfc zzaf()
  {
    if (isEmpty()) {
      return zzfc.zzad();
    }
    return zzfc.structured(toArray());
  }
  
  Object[] zzag()
  {
    return null;
  }
  
  int zzah()
  {
    throw new UnsupportedOperationException();
  }
  
  int zzai()
  {
    throw new UnsupportedOperationException();
  }
  
  abstract boolean zzaj();
}
