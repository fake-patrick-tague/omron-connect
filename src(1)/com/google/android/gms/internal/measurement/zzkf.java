package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzkf
  extends zzio
  implements RandomAccess, zzkj, zzls
{
  private static final zzkf eventQueue;
  private int[] data;
  private int size;
  
  static
  {
    zzkf localZzkf = new zzkf(new int[0], 0);
    eventQueue = localZzkf;
    localZzkf.inc();
  }
  
  zzkf()
  {
    this(new int[10], 0);
  }
  
  private zzkf(int[] paramArrayOfInt, int paramInt)
  {
    data = paramArrayOfInt;
    size = paramInt;
  }
  
  public static zzkf getEventQueue()
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
  
  public final boolean addAll(Collection paramCollection)
  {
    zzbP();
    zzkm.get(paramCollection);
    if (!(paramCollection instanceof zzkf)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (zzkf)paramCollection;
    int i = size;
    if (i == 0) {
      return false;
    }
    int j = size;
    if (Integer.MAX_VALUE - j >= i)
    {
      i = j + i;
      int[] arrayOfInt = data;
      if (i > arrayOfInt.length) {
        data = Arrays.copyOf(arrayOfInt, i);
      }
      System.arraycopy(data, 0, data, size, size);
      size = i;
      modCount += 1;
      return true;
    }
    throw new OutOfMemoryError();
  }
  
  public final boolean contains(Object paramObject)
  {
    return indexOf(paramObject) != -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzkf)) {
      return super.equals(paramObject);
    }
    paramObject = (zzkf)paramObject;
    if (size != size) {
      return false;
    }
    paramObject = data;
    int i = 0;
    while (i < size)
    {
      if (data[i] != paramObject[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 1;
    int i = 0;
    while (i < size)
    {
      j = j * 31 + data[i];
      i += 1;
    }
    return j;
  }
  
  public final int indexOf(Object paramObject)
  {
    if (!(paramObject instanceof Integer)) {
      return -1;
    }
    int j = ((Integer)paramObject).intValue();
    int k = size;
    int i = 0;
    while (i < k)
    {
      if (data[i] == j) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public final int next(int paramInt)
  {
    rangeCheck(paramInt);
    return data[paramInt];
  }
  
  protected final void removeRange(int paramInt1, int paramInt2)
  {
    zzbP();
    if (paramInt2 >= paramInt1)
    {
      int[] arrayOfInt = data;
      System.arraycopy(arrayOfInt, paramInt2, arrayOfInt, paramInt1, size - paramInt2);
      size -= paramInt2 - paramInt1;
      modCount += 1;
      return;
    }
    throw new IndexOutOfBoundsException("toIndex < fromIndex");
  }
  
  public final int size()
  {
    return size;
  }
  
  public final zzkj substring(int paramInt)
  {
    if (paramInt >= size) {
      return new zzkf(Arrays.copyOf(data, paramInt), size);
    }
    throw new IllegalArgumentException();
  }
  
  public final void write(int paramInt)
  {
    zzbP();
    int i = size;
    int[] arrayOfInt1 = data;
    if (i == arrayOfInt1.length)
    {
      int[] arrayOfInt2 = new int[i * 3 / 2 + 1];
      System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, i);
      data = arrayOfInt2;
    }
    arrayOfInt1 = data;
    i = size;
    size = (i + 1);
    arrayOfInt1[i] = paramInt;
  }
}
