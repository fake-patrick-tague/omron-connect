package com.google.android.gms.internal.fitness;

import java.util.List;

final class zzfe
  extends zzfc<E>
{
  private final transient int length;
  private final transient int offset;
  
  zzfe(zzfc paramZzfc, int paramInt1, int paramInt2)
  {
    offset = paramInt1;
    length = paramInt2;
  }
  
  public final Object get(int paramInt)
  {
    zzez.read(paramInt, length);
    return zzth.get(paramInt + offset);
  }
  
  public final int size()
  {
    return length;
  }
  
  public final zzfc slice(int paramInt1, int paramInt2)
  {
    zzez.checkPositionIndexes(paramInt1, paramInt2, length);
    zzfc localZzfc = zzth;
    int i = offset;
    return (zzfc)localZzfc.subList(paramInt1 + i, paramInt2 + i);
  }
  
  final Object[] zzag()
  {
    return zzth.zzag();
  }
  
  final int zzah()
  {
    return zzth.zzah() + offset;
  }
  
  final int zzai()
  {
    return zzth.zzah() + offset + length;
  }
  
  final boolean zzaj()
  {
    return true;
  }
}
