package com.google.android.gms.internal.fitness;

import java.util.Iterator;
import java.util.List;

final class zzjv
  implements Iterator<String>
{
  private Iterator<String> zzabv;
  
  zzjv(zzjt paramZzjt)
  {
    zzabv = zzjt.getMapping(paramZzjt).iterator();
  }
  
  public final boolean hasNext()
  {
    return zzabv.hasNext();
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}
