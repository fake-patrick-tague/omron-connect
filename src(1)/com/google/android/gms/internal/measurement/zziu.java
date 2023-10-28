package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

final class zziu
  extends zziw
{
  private final int cursor;
  private int index = 0;
  
  zziu(zzjd paramZzjd)
  {
    cursor = paramZzjd.size();
  }
  
  public final boolean hasNext()
  {
    return index < cursor;
  }
  
  public final byte read()
  {
    int i = index;
    if (i < cursor)
    {
      index = (i + 1);
      return buffer.get(i);
    }
    throw new NoSuchElementException();
  }
}
