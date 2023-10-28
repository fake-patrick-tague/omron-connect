package com.google.android.gms.internal.fitness;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

final class zziy<E>
  extends zzfs<E>
  implements RandomAccess
{
  private static final zziy<Object> zzaaz;
  private int size;
  private E[] zztn;
  
  static
  {
    zziy localZziy = new zziy(new Object[0], 0);
    zzaaz = localZziy;
    localZziy.zzar();
  }
  
  zziy()
  {
    this(new Object[10], 0);
  }
  
  private zziy(Object[] paramArrayOfObject, int paramInt)
  {
    zztn = paramArrayOfObject;
    size = paramInt;
  }
  
  private final void zzac(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < size)) {
      return;
    }
    throw new IndexOutOfBoundsException(zzad(paramInt));
  }
  
  private final String zzad(int paramInt)
  {
    int i = size;
    StringBuilder localStringBuilder = new StringBuilder(35);
    localStringBuilder.append("Index:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", Size:");
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
  
  public static zziy zzdb()
  {
    return zzaaz;
  }
  
  public final void add(int paramInt, Object paramObject)
  {
    zzas();
    if (paramInt >= 0)
    {
      int i = size;
      if (paramInt <= i)
      {
        Object[] arrayOfObject1 = zztn;
        if (i < arrayOfObject1.length)
        {
          System.arraycopy(arrayOfObject1, paramInt, arrayOfObject1, paramInt + 1, i - paramInt);
        }
        else
        {
          Object[] arrayOfObject2 = new Object[i * 3 / 2 + 1];
          System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, paramInt);
          System.arraycopy(zztn, paramInt, arrayOfObject2, paramInt + 1, size - paramInt);
          zztn = arrayOfObject2;
        }
        zztn[paramInt] = paramObject;
        size += 1;
        modCount += 1;
        return;
      }
    }
    throw new IndexOutOfBoundsException(zzad(paramInt));
  }
  
  public final boolean add(Object paramObject)
  {
    zzas();
    int i = size;
    Object[] arrayOfObject = zztn;
    if (i == arrayOfObject.length) {
      zztn = Arrays.copyOf(arrayOfObject, i * 3 / 2 + 1);
    }
    arrayOfObject = zztn;
    i = size;
    size = (i + 1);
    arrayOfObject[i] = paramObject;
    modCount += 1;
    return true;
  }
  
  public final Object get(int paramInt)
  {
    zzac(paramInt);
    return zztn[paramInt];
  }
  
  public final Object remove(int paramInt)
  {
    zzas();
    zzac(paramInt);
    Object[] arrayOfObject = zztn;
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
    zzas();
    zzac(paramInt);
    Object[] arrayOfObject = zztn;
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
