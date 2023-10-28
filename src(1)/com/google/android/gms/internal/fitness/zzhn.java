package com.google.android.gms.internal.fitness;

import java.util.Map.Entry;

final class zzhn<K>
  implements Map.Entry<K, Object>
{
  private Map.Entry<K, zzhl> zzzd;
  
  private zzhn(Map.Entry paramEntry)
  {
    zzzd = paramEntry;
  }
  
  public final Object getKey()
  {
    return zzzd.getKey();
  }
  
  public final Object getValue()
  {
    if ((zzhl)zzzd.getValue() == null) {
      return null;
    }
    return zzhl.zzce();
  }
  
  public final Object setValue(Object paramObject)
  {
    if ((paramObject instanceof zzik)) {
      return ((zzhl)zzzd.getValue()).addValue((zzik)paramObject);
    }
    throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
  }
  
  public final zzhl zzcg()
  {
    return (zzhl)zzzd.getValue();
  }
}
