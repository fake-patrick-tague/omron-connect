package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

final class zzlu
  extends zzio
  implements RandomAccess
{
  private static final zzlu eventQueue;
  private Object[] buffer;
  private int size;
  
  static
  {
    zzlu localZzlu = new zzlu(new Object[0], 0);
    eventQueue = localZzlu;
    localZzlu.inc();
  }
  
  zzlu()
  {
    this(new Object[10], 0);
  }
  
  private zzlu(Object[] paramArrayOfObject, int paramInt)
  {
    buffer = paramArrayOfObject;
    size = paramInt;
  }
  
  public static zzlu getEventQueue()
  {
    return eventQueue;
  }
  
  private final void rangeCheck(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < size)) {
      return;
    }
    throw new IndexOutOfBoundsException(toString(paramInt));
  }
  
  private final String toString(int paramInt)
  {
    int i = size;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Index:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", Size:");
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
  
  public final void add(int paramInt, Object paramObject)
  {
    zzbP();
    if (paramInt >= 0)
    {
      int i = size;
      if (paramInt <= i)
      {
        Object[] arrayOfObject1 = buffer;
        if (i < arrayOfObject1.length)
        {
          System.arraycopy(arrayOfObject1, paramInt, arrayOfObject1, paramInt + 1, i - paramInt);
        }
        else
        {
          Object[] arrayOfObject2 = new Object[i * 3 / 2 + 1];
          System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, paramInt);
          System.arraycopy(buffer, paramInt, arrayOfObject2, paramInt + 1, size - paramInt);
          buffer = arrayOfObject2;
        }
        buffer[paramInt] = paramObject;
        size += 1;
        modCount += 1;
        return;
      }
    }
    throw new IndexOutOfBoundsException(toString(paramInt));
  }
  
  public final boolean add(Object paramObject)
  {
    zzbP();
    int i = size;
    Object[] arrayOfObject = buffer;
    if (i == arrayOfObject.length) {
      buffer = Arrays.copyOf(arrayOfObject, i * 3 / 2 + 1);
    }
    arrayOfObject = buffer;
    i = size;
    size = (i + 1);
    arrayOfObject[i] = paramObject;
    modCount += 1;
    return true;
  }
  
  public final Object get(int paramInt)
  {
    rangeCheck(paramInt);
    return buffer[paramInt];
  }
  
  public final Object remove(int paramInt)
  {
    zzbP();
    rangeCheck(paramInt);
    Object[] arrayOfObject = buffer;
    Object localObject = arrayOfObject[paramInt];
    int i = size;
    if (paramInt < i - 1) {
      System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, i - paramInt - 1);
    }
    size -= 1;
    modCount += 1;
    return localObject;
  }
  
  public final Object set(int paramInt, Object paramObject)
  {
    zzbP();
    rangeCheck(paramInt);
    Object[] arrayOfObject = buffer;
    Object localObject = arrayOfObject[paramInt];
    arrayOfObject[paramInt] = paramObject;
    modCount += 1;
    return localObject;
  }
  
  public final int size()
  {
    return size;
  }
}
