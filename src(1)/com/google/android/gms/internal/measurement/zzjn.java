package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzjn
  extends zzio
  implements RandomAccess, zzkl, zzls
{
  private static final zzjn magenta;
  private double[] data;
  private int size;
  
  static
  {
    zzjn localZzjn = new zzjn(new double[0], 0);
    magenta = localZzjn;
    localZzjn.inc();
  }
  
  zzjn()
  {
    this(new double[10], 0);
  }
  
  private zzjn(double[] paramArrayOfDouble, int paramInt)
  {
    data = paramArrayOfDouble;
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
  
  public final boolean addAll(Collection paramCollection)
  {
    zzbP();
    zzkm.get(paramCollection);
    if (!(paramCollection instanceof zzjn)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (zzjn)paramCollection;
    int i = size;
    if (i == 0) {
      return false;
    }
    int j = size;
    if (Integer.MAX_VALUE - j >= i)
    {
      i = j + i;
      double[] arrayOfDouble = data;
      if (i > arrayOfDouble.length) {
        data = Arrays.copyOf(arrayOfDouble, i);
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
    if (!(paramObject instanceof zzjn)) {
      return super.equals(paramObject);
    }
    paramObject = (zzjn)paramObject;
    if (size != size) {
      return false;
    }
    paramObject = data;
    int i = 0;
    while (i < size)
    {
      if (Double.doubleToLongBits(data[i]) != Double.doubleToLongBits(paramObject[i])) {
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
      j = j * 31 + zzkm.hash(Double.doubleToLongBits(data[i]));
      i += 1;
    }
    return j;
  }
  
  public final int indexOf(Object paramObject)
  {
    if (!(paramObject instanceof Double)) {
      return -1;
    }
    double d = ((Double)paramObject).doubleValue();
    int j = size;
    int i = 0;
    while (i < j)
    {
      if (data[i] == d) {
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
      double[] arrayOfDouble = data;
      System.arraycopy(arrayOfDouble, paramInt2, arrayOfDouble, paramInt1, size - paramInt2);
      size -= paramInt2 - paramInt1;
      modCount += 1;
      return;
    }
    throw new IndexOutOfBoundsException("toIndex < fromIndex");
  }
  
  public final void set(double paramDouble)
  {
    zzbP();
    int i = size;
    double[] arrayOfDouble1 = data;
    if (i == arrayOfDouble1.length)
    {
      double[] arrayOfDouble2 = new double[i * 3 / 2 + 1];
      System.arraycopy(arrayOfDouble1, 0, arrayOfDouble2, 0, i);
      data = arrayOfDouble2;
    }
    arrayOfDouble1 = data;
    i = size;
    size = (i + 1);
    arrayOfDouble1[i] = paramDouble;
  }
  
  public final int size()
  {
    return size;
  }
}
