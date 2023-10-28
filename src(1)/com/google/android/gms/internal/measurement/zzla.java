package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzla
  extends zzio
  implements RandomAccess, zzkk, zzls
{
  private static final zzla eventQueue;
  private long[] data;
  private int size;
  
  static
  {
    zzla localZzla = new zzla(new long[0], 0);
    eventQueue = localZzla;
    localZzla.inc();
  }
  
  zzla()
  {
    this(new long[10], 0);
  }
  
  private zzla(long[] paramArrayOfLong, int paramInt)
  {
    data = paramArrayOfLong;
    size = paramInt;
  }
  
  public static zzla getEventQueue()
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
  
  public final void add(long paramLong)
  {
    zzbP();
    int i = size;
    long[] arrayOfLong1 = data;
    if (i == arrayOfLong1.length)
    {
      long[] arrayOfLong2 = new long[i * 3 / 2 + 1];
      System.arraycopy(arrayOfLong1, 0, arrayOfLong2, 0, i);
      data = arrayOfLong2;
    }
    arrayOfLong1 = data;
    i = size;
    size = (i + 1);
    arrayOfLong1[i] = paramLong;
  }
  
  public final boolean addAll(Collection paramCollection)
  {
    zzbP();
    zzkm.get(paramCollection);
    if (!(paramCollection instanceof zzla)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (zzla)paramCollection;
    int i = size;
    if (i == 0) {
      return false;
    }
    int j = size;
    if (Integer.MAX_VALUE - j >= i)
    {
      i = j + i;
      long[] arrayOfLong = data;
      if (i > arrayOfLong.length) {
        data = Arrays.copyOf(arrayOfLong, i);
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
    if (!(paramObject instanceof zzla)) {
      return super.equals(paramObject);
    }
    paramObject = (zzla)paramObject;
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
  
  public final long getValue(int paramInt)
  {
    rangeCheck(paramInt);
    return data[paramInt];
  }
  
  public final int hashCode()
  {
    int j = 1;
    int i = 0;
    while (i < size)
    {
      j = j * 31 + zzkm.hash(data[i]);
      i += 1;
    }
    return j;
  }
  
  public final int indexOf(Object paramObject)
  {
    if (!(paramObject instanceof Long)) {
      return -1;
    }
    long l = ((Long)paramObject).longValue();
    int j = size;
    int i = 0;
    while (i < j)
    {
      if (data[i] == l) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  protected final void removeRange(int paramInt1, int paramInt2)
  {
    zzbP();
    if (paramInt2 >= paramInt1)
    {
      long[] arrayOfLong = data;
      System.arraycopy(arrayOfLong, paramInt2, arrayOfLong, paramInt1, size - paramInt2);
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
  
  public final zzkk substring(int paramInt)
  {
    if (paramInt >= size) {
      return new zzla(Arrays.copyOf(data, paramInt), size);
    }
    throw new IllegalArgumentException();
  }
}
