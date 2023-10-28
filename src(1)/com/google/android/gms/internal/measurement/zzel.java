package com.google.android.gms.internal.measurement;

public final class zzel
  extends zzke
  implements zzlm
{
  private static final zzel timeStamp;
  private zzeq EMPTY_OBJECT_ARRAY;
  private zzex SFTP;
  private String key = "";
  private boolean mNotificationsEnabled;
  private int selector;
  
  static
  {
    zzel localZzel = new zzel();
    timeStamp = localZzel;
    zzke.zzbJ(zzel.class, localZzel);
  }
  
  private zzel() {}
  
  public static zzel getTime()
  {
    return timeStamp;
  }
  
  protected final Object Decode(int paramInt, Object paramObject1, Object paramObject2)
  {
    paramInt -= 1;
    if (paramInt != 0)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return null;
            }
            return timeStamp;
          }
          return new zzek(null);
        }
        return new zzel();
      }
      return zzke.zzbI(timeStamp, "\001\004\000\001\001\004\004\000\000\000\001?\000\002?\001\003?\002\004?\003", new Object[] { "zze", "zzf", "zzg", "zzh", "zzi" });
    }
    return Byte.valueOf((byte)1);
  }
  
  public final boolean add()
  {
    return (selector & 0x2) != 0;
  }
  
  public final String get()
  {
    return key;
  }
  
  public final zzex getInstance()
  {
    zzex localZzex2 = SFTP;
    zzex localZzex1 = localZzex2;
    if (localZzex2 == null) {
      localZzex1 = zzex.time();
    }
    return localZzex1;
  }
  
  public final boolean isEmpty()
  {
    return (selector & 0x1) != 0;
  }
  
  public final boolean isWritable()
  {
    return (selector & 0x8) != 0;
  }
  
  public final boolean size()
  {
    return (selector & 0x4) != 0;
  }
  
  public final zzeq toArray()
  {
    zzeq localZzeq2 = EMPTY_OBJECT_ARRAY;
    zzeq localZzeq1 = localZzeq2;
    if (localZzeq2 == null) {
      localZzeq1 = zzeq.method_7();
    }
    return localZzeq1;
  }
  
  public final boolean update()
  {
    return mNotificationsEnabled;
  }
}
