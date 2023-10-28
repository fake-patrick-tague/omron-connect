package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.ListIterator;

final class zzmq
  implements ListIterator
{
  final ListIterator iter;
  
  zzmq(zzms paramZzms, int paramInt)
  {
    iter = zzms.access$getData(paramZzms).listIterator(paramInt);
  }
  
  public final boolean hasNext()
  {
    return iter.hasNext();
  }
  
  public final boolean hasPrevious()
  {
    return iter.hasPrevious();
  }
  
  public final int nextIndex()
  {
    return iter.nextIndex();
  }
  
  public final int previousIndex()
  {
    return iter.previousIndex();
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}
