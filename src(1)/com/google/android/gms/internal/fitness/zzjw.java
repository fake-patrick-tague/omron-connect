package com.google.android.gms.internal.fitness;

import java.util.List;
import java.util.ListIterator;

final class zzjw
  implements ListIterator<String>
{
  private ListIterator<String> zzabx;
  
  zzjw(zzjt paramZzjt, int paramInt)
  {
    zzabx = zzjt.getMapping(paramZzjt).listIterator(paramInt);
  }
  
  public final boolean hasNext()
  {
    return zzabx.hasNext();
  }
  
  public final boolean hasPrevious()
  {
    return zzabx.hasPrevious();
  }
  
  public final int nextIndex()
  {
    return zzabx.nextIndex();
  }
  
  public final int previousIndex()
  {
    return zzabx.previousIndex();
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}
