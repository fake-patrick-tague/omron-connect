package com.google.android.gms.internal.measurement;

public enum zzkp
{
  private final Class count;
  private final Class expected;
  private final Object monitor;
  
  static
  {
    zzkp localZzkp1 = new zzkp("VOID", 0, Void.class, Void.class, null);
    BOTH = localZzkp1;
    Object localObject = Integer.TYPE;
    zzkp localZzkp2 = new zzkp("INT", 1, (Class)localObject, Integer.class, Integer.valueOf(0));
    MIDDLE = localZzkp2;
    zzkp localZzkp3 = new zzkp("LONG", 2, Long.TYPE, Long.class, Long.valueOf(0L));
    LAST = localZzkp3;
    zzkp localZzkp4 = new zzkp("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0F));
    FUTURE = localZzkp4;
    zzkp localZzkp5 = new zzkp("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0D));
    NONE = localZzkp5;
    zzkp localZzkp6 = new zzkp("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
    ERROR = localZzkp6;
    zzkp localZzkp7 = new zzkp("STRING", 6, String.class, String.class, "");
    INVALID_REQUEST = localZzkp7;
    zzkp localZzkp8 = new zzkp("BYTE_STRING", 7, zzjd.class, zzjd.class, zzjd.a);
    OK = localZzkp8;
    localObject = new zzkp("ENUM", 8, (Class)localObject, Integer.class, null);
    INVALID_ID = (zzkp)localObject;
    zzkp localZzkp9 = new zzkp("MESSAGE", 9, Object.class, Object.class, null);
    INVALID_RESPONSE = localZzkp9;
    $VALUES = new zzkp[] { localZzkp1, localZzkp2, localZzkp3, localZzkp4, localZzkp5, localZzkp6, localZzkp7, localZzkp8, localObject, localZzkp9 };
  }
  
  private zzkp(Class paramClass1, Class paramClass2, Object paramObject)
  {
    expected = paramClass1;
    count = paramClass2;
    monitor = paramObject;
  }
  
  public final Class read()
  {
    return count;
  }
}
