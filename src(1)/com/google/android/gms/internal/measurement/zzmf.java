package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zzmf
  implements Iterator
{
  private int currentIndex;
  private Iterator lazyOverflowIterator;
  private boolean value;
  
  private final Iterator getOverflowIterator()
  {
    if (lazyOverflowIterator == null) {
      lazyOverflowIterator = zzmj.access$getOverflowEntries(this$0).entrySet().iterator();
    }
    return lazyOverflowIterator;
  }
  
  public final boolean hasNext()
  {
    if (currentIndex + 1 >= zzmj.access$getEntryList(this$0).size()) {
      return (!zzmj.access$getOverflowEntries(this$0).isEmpty()) && (getOverflowIterator().hasNext());
    }
    return true;
  }
  
  public final void remove()
  {
    if (value)
    {
      value = false;
      zzmj.access$getCheckMutable(this$0);
      if (currentIndex < zzmj.access$getEntryList(this$0).size())
      {
        zzmj localZzmj = this$0;
        int i = currentIndex;
        currentIndex = (i - 1);
        zzmj.get(localZzmj, i);
        return;
      }
      getOverflowIterator().remove();
      return;
    }
    throw new IllegalStateException("remove() was called before next()");
  }
}
