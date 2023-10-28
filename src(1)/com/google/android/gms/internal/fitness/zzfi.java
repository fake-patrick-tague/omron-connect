package com.google.android.gms.internal.fitness;

final class zzfi<E>
  extends zzfc<E>
{
  static final zzfc<Object> zztm = new zzfi(new Object[0], 0);
  private final transient int size;
  private final transient Object[] zztn;
  
  zzfi(Object[] paramArrayOfObject, int paramInt)
  {
    zztn = paramArrayOfObject;
    size = paramInt;
  }
  
  final int get(Object[] paramArrayOfObject, int paramInt)
  {
    System.arraycopy(zztn, 0, paramArrayOfObject, 0, size);
    return size + 0;
  }
  
  public final Object get(int paramInt)
  {
    zzez.read(paramInt, size);
    return zztn[paramInt];
  }
  
  public final int size()
  {
    return size;
  }
  
  final Object[] zzag()
  {
    return zztn;
  }
  
  final int zzah()
  {
    return 0;
  }
  
  final int zzai()
  {
    return size;
  }
  
  final boolean zzaj()
  {
    return false;
  }
}
