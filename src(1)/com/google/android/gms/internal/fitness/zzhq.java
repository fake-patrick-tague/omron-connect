package com.google.android.gms.internal.fitness;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzhq<K>
  implements Iterator<Map.Entry<K, Object>>
{
  private Iterator<Map.Entry<K, Object>> zzzh;
  
  public zzhq(Iterator paramIterator)
  {
    zzzh = paramIterator;
  }
  
  public final boolean hasNext()
  {
    return zzzh.hasNext();
  }
  
  public final void remove()
  {
    zzzh.remove();
  }
}
