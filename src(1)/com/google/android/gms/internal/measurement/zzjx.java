package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzjx
  extends zzio
  implements RandomAccess, zzkl, zzls
{
  private static final zzjx magenta;
  private float[] data;
  private int size;
  
  static
  {
    zzjx localZzjx = new zzjx(new float[0], 0);
    magenta = localZzjx;
    localZzjx.inc();
  }
  
  zzjx()
  {
    this(new float[10], 0);
  }
  
  private zzjx(float[] paramArrayOfFloat, int paramInt)
  {
    data = paramArrayOfFloat;
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
    if (!(paramCollection instanceof zzjx)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (zzjx)paramCollection;
    int i = size;
    if (i == 0) {
      return false;
    }
    int j = size;
    if (Integer.MAX_VALUE - j >= i)
    {
      i = j + i;
      float[] arrayOfFloat = data;
      if (i > arrayOfFloat.length) {
        data = Arrays.copyOf(arrayOfFloat, i);
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
    if (!(paramObject instanceof zzjx)) {
      return super.equals(paramObject);
    }
    paramObject = (zzjx)paramObject;
    if (size != size) {
      return false;
    }
    paramObject = data;
    int i = 0;
    while (i < size)
    {
      if (Float.floatToIntBits(data[i]) != Float.floatToIntBits(paramObject[i])) {
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
      j = j * 31 + Float.floatToIntBits(data[i]);
      i += 1;
    }
    return j;
  }
  
  public final int indexOf(Object paramObject)
  {
    if (!(paramObject instanceof Float)) {
      return -1;
    }
    float f = ((Float)paramObject).floatValue();
    int j = size;
    int i = 0;
    while (i < j)
    {
      if (data[i] == f) {
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
      float[] arrayOfFloat = data;
      System.arraycopy(arrayOfFloat, paramInt2, arrayOfFloat, paramInt1, size - paramInt2);
      size -= paramInt2 - paramInt1;
      modCount += 1;
      return;
    }
    throw new IndexOutOfBoundsException("toIndex < fromIndex");
  }
  
  public final void set(float paramFloat)
  {
    zzbP();
    int i = size;
    float[] arrayOfFloat1 = data;
    if (i == arrayOfFloat1.length)
    {
      float[] arrayOfFloat2 = new float[i * 3 / 2 + 1];
      System.arraycopy(arrayOfFloat1, 0, arrayOfFloat2, 0, i);
      data = arrayOfFloat2;
    }
    arrayOfFloat1 = data;
    i = size;
    size = (i + 1);
    arrayOfFloat1[i] = paramFloat;
  }
  
  public final int size()
  {
    return size;
  }
}
