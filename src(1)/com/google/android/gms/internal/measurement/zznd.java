package com.google.android.gms.internal.measurement;

public enum zznd
{
  private final zzne SUCCESS;
  
  static
  {
    zznd localZznd1 = new zznd("DOUBLE", 0, zzne.PERCENT, 1);
    mMap = localZznd1;
    zznd localZznd2 = new zznd("FLOAT", 1, zzne.CHANGE, 5);
    AddByUrl = localZznd2;
    Object localObject1 = zzne.DELETE;
    zznd localZznd3 = new zznd("INT64", 2, (zzne)localObject1, 0);
    AddByMagnetUrl = localZznd3;
    zznd localZznd4 = new zznd("UINT64", 3, (zzne)localObject1, 0);
    AddByFile = localZznd4;
    Object localObject3 = zzne.mMap;
    zznd localZznd5 = new zznd("INT32", 4, (zzne)localObject3, 0);
    Remove = localZznd5;
    zznd localZznd6 = new zznd("FIXED64", 5, (zzne)localObject1, 1);
    Replace = localZznd6;
    zznd localZznd7 = new zznd("FIXED32", 6, (zzne)localObject3, 5);
    Move = localZznd7;
    zznd localZznd8 = new zznd("BOOL", 7, zzne.Remove, 0);
    Grow = localZznd8;
    zznd localZznd9 = new zznd("STRING", 8, zzne.Replace, 2);
    $VALUES = localZznd9;
    Object localObject2 = zzne.None;
    zznd localZznd10 = new zznd("GROUP", 9, (zzne)localObject2, 3);
    Companion = localZznd10;
    localObject2 = new zznd("MESSAGE", 10, (zzne)localObject2, 2);
    TAG = (zznd)localObject2;
    zznd localZznd11 = new zznd("BYTES", 11, zzne.Move, 2);
    LOG_LEVEL = localZznd11;
    zznd localZznd12 = new zznd("UINT32", 12, (zzne)localObject3, 0);
    logger = localZznd12;
    zznd localZznd13 = new zznd("ENUM", 13, zzne.Reset, 0);
    EMPTY_BUFFER = localZznd13;
    zznd localZznd14 = new zznd("SFIXED32", 14, (zzne)localObject3, 5);
    ENCODER = localZznd14;
    zznd localZznd15 = new zznd("SFIXED64", 15, (zzne)localObject1, 1);
    DSB = localZznd15;
    localObject3 = new zznd("SINT32", 16, (zzne)localObject3, 0);
    SE = (zznd)localObject3;
    localObject1 = new zznd("SINT64", 17, (zzne)localObject1, 0);
    o = (zznd)localObject1;
    d = new zznd[] { localZznd1, localZznd2, localZznd3, localZznd4, localZznd5, localZznd6, localZznd7, localZznd8, localZznd9, localZznd10, localObject2, localZznd11, localZznd12, localZznd13, localZznd14, localZznd15, localObject3, localObject1 };
  }
  
  private zznd(zzne paramZzne, int paramInt)
  {
    SUCCESS = paramZzne;
  }
  
  public final zzne handle()
  {
    return SUCCESS;
  }
}
