package com.google.android.gms.internal.measurement;

import java.io.Serializable;

public abstract class zzif
  implements Serializable
{
  zzif() {}
  
  public static zzif decode()
  {
    return zzid.NEGATE;
  }
  
  public static zzif decode(Object paramObject)
  {
    return new zzig(paramObject);
  }
  
  public abstract Object get();
  
  public abstract boolean isEmpty();
}
