package com.google.android.gms.internal.measurement;

public enum zzne
{
  private final Object val$arg0;
  
  static
  {
    zzne localZzne1 = new zzne("INT", 0, Integer.valueOf(0));
    mMap = localZzne1;
    zzne localZzne2 = new zzne("LONG", 1, Long.valueOf(0L));
    DELETE = localZzne2;
    zzne localZzne3 = new zzne("FLOAT", 2, Float.valueOf(0.0F));
    CHANGE = localZzne3;
    zzne localZzne4 = new zzne("DOUBLE", 3, Double.valueOf(0.0D));
    PERCENT = localZzne4;
    zzne localZzne5 = new zzne("BOOLEAN", 4, Boolean.FALSE);
    Remove = localZzne5;
    zzne localZzne6 = new zzne("STRING", 5, "");
    Replace = localZzne6;
    zzne localZzne7 = new zzne("BYTE_STRING", 6, zzjd.a);
    Move = localZzne7;
    zzne localZzne8 = new zzne("ENUM", 7, null);
    Reset = localZzne8;
    zzne localZzne9 = new zzne("MESSAGE", 8, null);
    None = localZzne9;
    $VALUES = new zzne[] { localZzne1, localZzne2, localZzne3, localZzne4, localZzne5, localZzne6, localZzne7, localZzne8, localZzne9 };
  }
  
  private zzne(Object paramObject)
  {
    val$arg0 = paramObject;
  }
}
