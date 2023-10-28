package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzis
  extends zzio
  implements RandomAccess, zzkl, zzls
{
  private static final zzis magenta;
  private boolean[] data;
  private int size;
  
  static
  {
    zzis localZzis = new zzis(new boolean[0], 0);
    magenta = localZzis;
    localZzis.inc();
  }
  
  zzis()
  {
    this(new boolean[10], 0);
  }
  
  private zzis(boolean[] paramArrayOfBoolean, int paramInt)
  {
    data = paramArrayOfBoolean;
    size = paramInt;
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
  
  public final void add(boolean paramBoolean)
  {
    zzbP();
    int i = size;
    boolean[] arrayOfBoolean1 = data;
    if (i == arrayOfBoolean1.length)
    {
      boolean[] arrayOfBoolean2 = new boolean[i * 3 / 2 + 1];
      System.arraycopy(arrayOfBoolean1, 0, arrayOfBoolean2, 0, i);
      data = arrayOfBoolean2;
    }
    arrayOfBoolean1 = data;
    i = size;
    size = (i + 1);
    arrayOfBoolean1[i] = paramBoolean;
  }
  
  public final boolean addAll(Collection paramCollection)
  {
    zzbP();
    zzkm.get(paramCollection);
    if (!(paramCollection instanceof zzis)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (zzis)paramCollection;
    int i = size;
    if (i == 0) {
      return false;
    }
    int j = size;
    if (Integer.MAX_VALUE - j >= i)
    {
      i = j + i;
      boolean[] arrayOfBoolean = data;
      if (i > arrayOfBoolean.length) {
        data = Arrays.copyOf(arrayOfBoolean, i);
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
    if (!(paramObject instanceof zzis)) {
      return super.equals(paramObject);
    }
    paramObject = (zzis)paramObject;
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
      j = j * 31 + zzkm.hashCode(data[i]);
      i += 1;
    }
    return j;
  }
  
  public final int indexOf(Object paramObject)
  {
    if (!(paramObject instanceof Boolean)) {
      return -1;
    }
    int k = ((Boolean)paramObject).booleanValue();
    int j = size;
    int i = 0;
    while (i < j)
    {
      if (data[i] == k) {
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
      boolean[] arrayOfBoolean = data;
      System.arraycopy(arrayOfBoolean, paramInt2, arrayOfBoolean, paramInt1, size - paramInt2);
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
