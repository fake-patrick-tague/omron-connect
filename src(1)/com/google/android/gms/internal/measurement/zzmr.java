package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

final class zzmr
  implements Iterator
{
  final Iterator iter;
  
  zzmr(zzms paramZzms)
  {
    iter = zzms.access$getData(paramZzms).iterator();
  }
  
  public final boolean hasNext()
  {
    return iter.hasNext();
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}
