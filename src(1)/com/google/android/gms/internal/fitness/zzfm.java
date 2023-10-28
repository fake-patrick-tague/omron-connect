package com.google.android.gms.internal.fitness;

import java.util.Iterator;

public abstract class zzfm<E>
  implements Iterator<E>
{
  protected zzfm() {}
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}
