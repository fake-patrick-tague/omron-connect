package com.google.android.gms.internal.fitness;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzhy
  extends zzfs<Long>
  implements zzhh<Long>, zzit, RandomAccess
{
  private static final zzhy zzzq;
  private int size;
  private long[] zzzr;
  
  static
  {
    zzhy localZzhy = new zzhy(new long[0], 0);
    zzzq = localZzhy;
    localZzhy.zzar();
  }
  
  zzhy()
  {
    this(new long[10], 0);
  }
  
  private zzhy(long[] paramArrayOfLong, int paramInt)
  {
    zzzr = paramArrayOfLong;
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
  
  public static zzhy zzcm()
  {
    return zzzq;
  }
  
  public final boolean addAll(Collection paramCollection)
  {
    zzas();
    zzhc.checkNotNull(paramCollection);
    if (!(paramCollection instanceof zzhy)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (zzhy)paramCollection;
    int i = size;
    if (i == 0) {
      return false;
    }
    int j = size;
    if (Integer.MAX_VALUE - j >= i)
    {
      i = j + i;
      long[] arrayOfLong = zzzr;
      if (i > arrayOfLong.length) {
        zzzr = Arrays.copyOf(arrayOfLong, i);
      }
      System.arraycopy(zzzr, 0, zzzr, size, size);
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
    if (!(paramObject instanceof zzhy)) {
      return super.equals(paramObject);
    }
    paramObject = (zzhy)paramObject;
    if (size != size) {
      return false;
    }
    paramObject = zzzr;
    int i = 0;
    while (i < size)
    {
      if (zzzr[i] != paramObject[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public final long getLong(int paramInt)
  {
    zzac(paramInt);
    return zzzr[paramInt];
  }
  
  public final int hashCode()
  {
    int j = 1;
    int i = 0;
    while (i < size)
    {
      j = j * 31 + zzhc.hashCode(zzzr[i]);
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
    int j = size();
    int i = 0;
    while (i < j)
    {
      if (zzzr[i] == l) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  protected final void removeRange(int paramInt1, int paramInt2)
  {
    zzas();
    if (paramInt2 >= paramInt1)
    {
      long[] arrayOfLong = zzzr;
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
}
