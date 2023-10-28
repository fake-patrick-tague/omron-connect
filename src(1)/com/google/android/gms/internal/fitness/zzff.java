package com.google.android.gms.internal.fitness;

import java.util.AbstractCollection;
import java.util.List;

final class zzff<E>
  extends zzfb<E>
{
  private final zzfc<E> zzti;
  
  zzff(zzfc paramZzfc, int paramInt)
  {
    super(paramZzfc.size(), paramInt);
    zzti = paramZzfc;
  }
  
  protected final Object get(int paramInt)
  {
    return zzti.get(paramInt);
  }
}
