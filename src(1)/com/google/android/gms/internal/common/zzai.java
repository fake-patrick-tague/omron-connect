package com.google.android.gms.internal.common;

import org.jspecify.nullness.NullMarked;

@NullMarked
final class zzai
  extends zzag
{
  static final zzag INSTANCE = new zzai(new Object[0], 0);
  private final transient int _size;
  final transient Object[] _values;
  
  zzai(Object[] paramArrayOfObject, int paramInt)
  {
    _values = paramArrayOfObject;
    _size = paramInt;
  }
  
  final boolean checkEmpty()
  {
    return false;
  }
  
  public final Object get(int paramInt)
  {
    Preconditions.add(paramInt, _size, "index");
    Object localObject = _values[paramInt];
    localObject.getClass();
    return localObject;
  }
  
  final Object[] get()
  {
    return _values;
  }
  
  final int read()
  {
    return _size;
  }
  
  final int readFully()
  {
    return 0;
  }
  
  final int remove(Object[] paramArrayOfObject, int paramInt)
  {
    System.arraycopy(_values, 0, paramArrayOfObject, 0, _size);
    return _size;
  }
  
  public final int size()
  {
    return _size;
  }
}
