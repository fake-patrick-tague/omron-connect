package com.google.android.gms.internal.measurement;

public enum zzjw
{
  private static final zzjw[] mVertices;
  private final zzkp zzab;
  private final int zzac;
  private final Class zzad;
  
  static
  {
    zzkp localZzkp2 = zzkp.NONE;
    NORMAL = new zzjw("DOUBLE", 0, 0, 1, localZzkp2);
    zzkp localZzkp3 = zzkp.FUTURE;
    COUNT = new zzjw("FLOAT", 1, 1, 1, localZzkp3);
    zzkp localZzkp4 = zzkp.LAST;
    SUM = new zzjw("INT64", 2, 2, 1, localZzkp4);
    AVG = new zzjw("UINT64", 3, 3, 1, localZzkp4);
    Object localObject = zzkp.MIDDLE;
    MIN = new zzjw("INT32", 4, 4, 1, (zzkp)localObject);
    METRIC = new zzjw("FIXED64", 5, 5, 1, localZzkp4);
    NAME = new zzjw("FIXED32", 6, 6, 1, (zzkp)localObject);
    zzkp localZzkp5 = zzkp.ERROR;
    USER = new zzjw("BOOL", 7, 7, 1, localZzkp5);
    zzkp localZzkp6 = zzkp.INVALID_REQUEST;
    EMPTY = new zzjw("STRING", 8, 8, 1, localZzkp6);
    zzkp localZzkp1 = zzkp.INVALID_RESPONSE;
    SCHEMA = new zzjw("MESSAGE", 9, 9, 1, localZzkp1);
    zzkp localZzkp7 = zzkp.OK;
    TOOBIG = new zzjw("BYTES", 10, 10, 1, localZzkp7);
    CONSTRAINT = new zzjw("UINT32", 11, 11, 1, (zzkp)localObject);
    zzkp localZzkp8 = zzkp.INVALID_ID;
    MISMATCH = new zzjw("ENUM", 12, 12, 1, localZzkp8);
    RAIN_EXTREME = new zzjw("SFIXED32", 13, 13, 1, (zzkp)localObject);
    RAIN_FREEZING = new zzjw("SFIXED64", 14, 14, 1, localZzkp4);
    A = new zzjw("SINT32", 15, 15, 1, (zzkp)localObject);
    NS = new zzjw("SINT64", 16, 16, 1, localZzkp4);
    DSB = new zzjw("GROUP", 17, 17, 1, localZzkp1);
    SE = new zzjw("DOUBLE_LIST", 18, 18, 2, localZzkp2);
    BEST = new zzjw("FLOAT_LIST", 19, 19, 2, localZzkp3);
    HOT = new zzjw("INT64_LIST", 20, 20, 2, localZzkp4);
    NEW = new zzjw("UINT64_LIST", 21, 21, 2, localZzkp4);
    RISING = new zzjw("INT32_LIST", 22, 22, 2, (zzkp)localObject);
    DRIZZLE = new zzjw("FIXED64_LIST", 23, 23, 2, localZzkp4);
    DRIZZLE_HEAVY = new zzjw("FIXED32_LIST", 24, 24, 2, (zzkp)localObject);
    S = new zzjw("BOOL_LIST", 25, 25, 2, localZzkp5);
    M = new zzjw("STRING_LIST", 26, 26, 2, localZzkp6);
    N = new zzjw("MESSAGE_LIST", 27, 27, 2, localZzkp1);
    NNE = new zzjw("BYTES_LIST", 28, 28, 2, localZzkp7);
    NE = new zzjw("UINT32_LIST", 29, 29, 2, (zzkp)localObject);
    ENE = new zzjw("ENUM_LIST", 30, 30, 2, localZzkp8);
    E = new zzjw("SFIXED32_LIST", 31, 31, 2, (zzkp)localObject);
    WTF = new zzjw("SFIXED64_LIST", 32, 32, 2, localZzkp4);
    scheme = new zzjw("SINT32_LIST", 33, 33, 2, (zzkp)localObject);
    port = new zzjw("SINT64_LIST", 34, 34, 2, localZzkp4);
    type = new zzjw("DOUBLE_LIST_PACKED", 35, 35, 3, localZzkp2);
    title = new zzjw("FLOAT_LIST_PACKED", 36, 36, 3, localZzkp3);
    sections = new zzjw("INT64_LIST_PACKED", 37, 37, 3, localZzkp4);
    positions = new zzjw("UINT64_LIST_PACKED", 38, 38, 3, localZzkp4);
    values = new zzjw("INT32_LIST_PACKED", 39, 39, 3, (zzkp)localObject);
    Offline = new zzjw("FIXED64_LIST_PACKED", 40, 40, 3, localZzkp4);
    Online = new zzjw("FIXED32_LIST_PACKED", 41, 41, 3, (zzkp)localObject);
    Appointment = new zzjw("BOOL_LIST_PACKED", 42, 42, 3, localZzkp5);
    Away = new zzjw("UINT32_LIST_PACKED", 43, 43, 3, (zzkp)localObject);
    Breakfast = new zzjw("ENUM_LIST_PACKED", 44, 44, 3, localZzkp8);
    admin = new zzjw("SFIXED32_LIST_PACKED", 45, 45, 3, (zzkp)localObject);
    localZzkp2 = zzkp.LAST;
    member = new zzjw("SFIXED64_LIST_PACKED", 46, 46, 3, localZzkp2);
    outcast = new zzjw("SINT32_LIST_PACKED", 47, 47, 3, (zzkp)localObject);
    b = new zzjw("SINT64_LIST_PACKED", 48, 48, 3, localZzkp2);
    d = new zzjw("GROUP_LIST", 49, 49, 2, localZzkp1);
    g = new zzjw("MAP", 50, 50, 4, zzkp.BOTH);
    localObject = NORMAL;
    int i = 0;
    zzaa = new zzjw[] { localObject, COUNT, SUM, AVG, MIN, METRIC, NAME, USER, EMPTY, SCHEMA, TOOBIG, CONSTRAINT, MISMATCH, RAIN_EXTREME, RAIN_FREEZING, A, NS, DSB, SE, BEST, HOT, NEW, RISING, DRIZZLE, DRIZZLE_HEAVY, S, M, N, NNE, NE, ENE, E, WTF, scheme, port, type, title, sections, positions, values, Offline, Online, Appointment, Away, Breakfast, admin, member, outcast, b, d, g };
    localObject = values();
    int j = localObject.length;
    mVertices = new zzjw[j];
    while (i < j)
    {
      localZzkp1 = localObject[i];
      mVertices[zzac] = localZzkp1;
      i += 1;
    }
  }
  
  private zzjw(int paramInt1, int paramInt2, zzkp paramZzkp)
  {
    zzac = paramInt1;
    zzab = paramZzkp;
    ??? = zzkp.BOTH;
    ??? = paramInt2 - 1;
    if (??? != 1)
    {
      if (??? != 3) {
        zzad = null;
      } else {
        zzad = paramZzkp.read();
      }
    }
    else {
      zzad = paramZzkp.read();
    }
    if (paramInt2 == 1) {
      paramZzkp.ordinal();
    }
  }
  
  public final int length()
  {
    return zzac;
  }
}
