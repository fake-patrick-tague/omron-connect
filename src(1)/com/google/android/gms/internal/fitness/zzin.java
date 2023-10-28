package com.google.android.gms.internal.fitness;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

final class zzin<T>
  implements zzja<T>
{
  private final boolean zzaaa;
  private final zzgo<?> zzaab;
  private final zzik zzzy;
  private final zzjs<?, ?> zzzz;
  
  private zzin(zzjs paramZzjs, zzgo paramZzgo, zzik paramZzik)
  {
    zzzz = paramZzjs;
    zzaaa = paramZzgo.accepts(paramZzik);
    zzaab = paramZzgo;
    zzzy = paramZzik;
  }
  
  static zzin removeBody(zzjs paramZzjs, zzgo paramZzgo, zzik paramZzik)
  {
    return new zzin(paramZzjs, paramZzgo, paramZzik);
  }
  
  public final void a(Object paramObject, zzkm paramZzkm)
    throws IOException
  {
    Object localObject = zzaab.getValue(paramObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      zzgv localZzgv = (zzgv)localEntry.getKey();
      if ((localZzgv.zzbm() == zzkj.zzady) && (!localZzgv.zzbn()) && (!localZzgv.zzbo()))
      {
        if ((localEntry instanceof zzhn)) {
          paramZzkm.setProperty(localZzgv.get(), ((zzhn)localEntry).zzcg().zzam());
        } else {
          paramZzkm.setProperty(localZzgv.get(), localEntry.getValue());
        }
      }
      else {
        throw new IllegalStateException("Found invalid MessageSet item.");
      }
    }
    localObject = zzzz;
    ((zzjs)localObject).remainder(((zzjs)localObject).getValue(paramObject), paramZzkm);
  }
  
  public final void a(Object paramObject1, Object paramObject2)
  {
    zzjc.add(zzzz, paramObject1, paramObject2);
    if (zzaaa) {
      zzjc.clear(zzaab, paramObject1, paramObject2);
    }
  }
  
  public final boolean a(Object paramObject)
  {
    return zzaab.getValue(paramObject).isInitialized();
  }
  
  public final boolean equals(Object paramObject1, Object paramObject2)
  {
    if (!zzzz.getValue(paramObject1).equals(zzzz.getValue(paramObject2))) {
      return false;
    }
    if (zzaaa) {
      return zzaab.getValue(paramObject1).equals(zzaab.getValue(paramObject2));
    }
    return true;
  }
  
  public final int hashCode(Object paramObject)
  {
    int j = zzzz.getValue(paramObject).hashCode();
    int i = j;
    if (zzaaa) {
      i = j * 53 + zzaab.getValue(paramObject).hashCode();
    }
    return i;
  }
  
  public final void moveArt(Object paramObject)
  {
    zzzz.renameTo(paramObject);
    zzaab.updatePreferences(paramObject);
  }
  
  public final int parse(Object paramObject)
  {
    zzjs localZzjs = zzzz;
    int j = localZzjs.findEntry(localZzjs.getValue(paramObject)) + 0;
    int i = j;
    if (zzaaa) {
      i = j + zzaab.getValue(paramObject).zzbk();
    }
    return i;
  }
}
