package com.google.android.gms.internal.common;

import java.util.Arrays;
import java.util.Objects;

class zzaa
  extends zzab
{
  Object[] data = new Object[4];
  boolean header;
  int modCount = 0;
  
  zzaa(int paramInt) {}
  
  private final void read(int paramInt)
  {
    Object[] arrayOfObject = data;
    int i = arrayOfObject.length;
    if (i < paramInt)
    {
      int j = i + (i >> 1) + 1;
      i = j;
      if (j < paramInt)
      {
        paramInt = Integer.highestOneBit(paramInt - 1);
        i = paramInt + paramInt;
      }
      paramInt = i;
      if (i < 0) {
        paramInt = Integer.MAX_VALUE;
      }
      data = Arrays.copyOf(arrayOfObject, paramInt);
      header = false;
      return;
    }
    if (header)
    {
      data = ((Object[])arrayOfObject.clone());
      header = false;
    }
  }
  
  public final zzaa get(Object paramObject)
  {
    Objects.requireNonNull(paramObject);
    read(modCount + 1);
    Object[] arrayOfObject = data;
    int i = modCount;
    modCount = (i + 1);
    arrayOfObject[i] = paramObject;
    return this;
  }
}
