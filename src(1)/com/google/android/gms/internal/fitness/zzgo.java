package com.google.android.gms.internal.fitness;

import java.io.IOException;
import java.util.Map.Entry;

abstract class zzgo<T extends zzgv<T>>
{
  zzgo() {}
  
  abstract boolean accepts(zzik paramZzik);
  
  abstract void add(zzkm paramZzkm, Map.Entry paramEntry)
    throws IOException;
  
  abstract int getValue(Map.Entry paramEntry);
  
  abstract zzgt getValue(Object paramObject);
  
  abstract void updatePreferences(Object paramObject);
  
  abstract zzgt xor(Object paramObject);
}
