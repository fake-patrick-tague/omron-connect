package com.google.android.gms.internal.measurement;

abstract class zzkz
{
  private static final zzkz CONTEXT = new zzkv(null);
  private static final zzkz SYSTEM = new zzkx(null);
  
  static zzkz forName()
  {
    return SYSTEM;
  }
  
  static zzkz getLocalClassName()
  {
    return CONTEXT;
  }
  
  abstract void add(Object paramObject, long paramLong);
  
  abstract void get(Object paramObject1, Object paramObject2, long paramLong);
}
