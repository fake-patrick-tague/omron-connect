package com.google.android.gms.internal.fitness;

import java.util.NoSuchElementException;

final class zzfg
  extends zzfm<T>
{
  private boolean zztj;
  
  zzfg(Object paramObject) {}
  
  public final boolean hasNext()
  {
    return !zztj;
  }
  
  public final Object next()
  {
    if (!zztj)
    {
      zztj = true;
      return zztk;
    }
    throw new NoSuchElementException();
  }
}
