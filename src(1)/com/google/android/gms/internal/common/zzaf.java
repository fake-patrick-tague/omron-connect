package com.google.android.gms.internal.common;

import java.util.List;

final class zzaf
  extends zzag
{
  final transient int cursor;
  final transient int length;
  
  zzaf(zzag paramZzag, int paramInt1, int paramInt2)
  {
    cursor = paramInt1;
    length = paramInt2;
  }
  
  final boolean checkEmpty()
  {
    return true;
  }
  
  public final zzag get(int paramInt1, int paramInt2)
  {
    Preconditions.checkPositionIndexes(paramInt1, paramInt2, length);
    zzag localZzag = buffer;
    int i = cursor;
    return localZzag.get(paramInt1 + i, paramInt2 + i);
  }
  
  public final Object get(int paramInt)
  {
    Preconditions.add(paramInt, length, "index");
    return buffer.get(paramInt + cursor);
  }
  
  final Object[] get()
  {
    return buffer.get();
  }
  
  final int read()
  {
    return buffer.readFully() + cursor + length;
  }
  
  final int readFully()
  {
    return buffer.readFully() + cursor;
  }
  
  public final int size()
  {
    return length;
  }
}
