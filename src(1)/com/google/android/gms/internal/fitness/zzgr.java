package com.google.android.gms.internal.fitness;

import java.io.IOException;
import java.util.Map.Entry;

final class zzgr
  extends zzgo<zzgy.zzc>
{
  zzgr() {}
  
  final boolean accepts(zzik paramZzik)
  {
    return paramZzik instanceof zzgy.zzd;
  }
  
  final void add(zzkm paramZzkm, Map.Entry paramEntry)
    throws IOException
  {
    paramZzkm = (zzgy.zzc)paramEntry.getKey();
    throw new NoSuchMethodError();
  }
  
  final int getValue(Map.Entry paramEntry)
  {
    paramEntry = (zzgy.zzc)paramEntry.getKey();
    throw new NoSuchMethodError();
  }
  
  final zzgt getValue(Object paramObject)
  {
    return zzya;
  }
  
  final void updatePreferences(Object paramObject)
  {
    getValue(paramObject).zzar();
  }
  
  final zzgt xor(Object paramObject)
  {
    paramObject = (zzgy.zzd)paramObject;
    if (zzya.isImmutable()) {
      zzya = ((zzgt)zzya.clone());
    }
    return zzya;
  }
}
