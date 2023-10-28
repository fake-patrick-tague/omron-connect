package com.google.android.gms.internal.common;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import org.jspecify.nullness.NullMarked;

@NullMarked
public abstract class zzac
  extends AbstractCollection
  implements Serializable
{
  private static final Object[] values = new Object[0];
  
  zzac() {}
  
  public final boolean add(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean addAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  abstract boolean checkEmpty();
  
  public final void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  Object[] get()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public zzag invoke()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  int read()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  int readFully()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  int remove(Object[] paramArrayOfObject, int paramInt)
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
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
    return toArray(values);
  }
  
  public final Object[] toArray(Object[] paramArrayOfObject)
  {
    Objects.requireNonNull(paramArrayOfObject);
    int i = size();
    int j = paramArrayOfObject.length;
    Object[] arrayOfObject;
    if (j < i)
    {
      arrayOfObject = get();
      if (arrayOfObject == null) {
        arrayOfObject = (Object[])Array.newInstance(paramArrayOfObject.getClass().getComponentType(), i);
      } else {
        return Arrays.copyOfRange(arrayOfObject, readFully(), read(), paramArrayOfObject.getClass());
      }
    }
    else
    {
      arrayOfObject = paramArrayOfObject;
      if (j > i)
      {
        paramArrayOfObject[i] = null;
        arrayOfObject = paramArrayOfObject;
      }
    }
    remove(arrayOfObject, 0);
    return arrayOfObject;
  }
  
  public abstract zzaj transform();
}
