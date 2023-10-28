package com.google.android.gms.internal.fitness;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzje
  extends zzjb<FieldDescriptorType, Object>
{
  zzje(int paramInt)
  {
    super(paramInt, null);
  }
  
  public final void zzar()
  {
    if (!isImmutable())
    {
      int i = 0;
      while (i < zzdc())
      {
        localObject = zzal(i);
        if (((zzgv)((Map.Entry)localObject).getKey()).zzbn()) {
          ((Map.Entry)localObject).setValue(Collections.unmodifiableList((List)((Map.Entry)localObject).getValue()));
        }
        i += 1;
      }
      Object localObject = zzdd().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (((zzgv)localEntry.getKey()).zzbn()) {
          localEntry.setValue(Collections.unmodifiableList((List)localEntry.getValue()));
        }
      }
    }
    super.zzar();
  }
}
