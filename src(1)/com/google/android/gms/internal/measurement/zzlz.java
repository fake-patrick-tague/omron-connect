package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzlz
  extends zzmj
{
  zzlz(int paramInt)
  {
    super(paramInt, null);
  }
  
  public final void makeImmutable()
  {
    if (!isImmutable())
    {
      int i = 0;
      while (i < getValue())
      {
        localObject = get(i);
        if (((zzju)((Map.Entry)localObject).getKey()).isRepeated()) {
          ((Map.Entry)localObject).setValue(Collections.unmodifiableList((List)((Map.Entry)localObject).getValue()));
        }
        i += 1;
      }
      Object localObject = getOverflowEntries().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (((zzju)localEntry.getKey()).isRepeated()) {
          localEntry.setValue(Collections.unmodifiableList((List)localEntry.getValue()));
        }
      }
    }
    super.makeImmutable();
  }
}
