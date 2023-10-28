package com.google.android.gms.internal.fitness;

import java.lang.reflect.Type;

public enum zzgu
{
  private static final zzgu[] zzxi;
  private static final Type[] zzxj;
  private final int eventType;
  private final zzhm zzxe;
  private final zzgw zzxf;
  private final Class<?> zzxg;
  private final boolean zzxh;
  
  static
  {
    zzgw localZzgw = zzgw.zzxl;
    zzhm localZzhm1 = zzhm.zzyt;
    zzvf = new zzgu("DOUBLE", 0, 0, localZzgw, localZzhm1);
    zzhm localZzhm2 = zzhm.zzys;
    zzvg = new zzgu("FLOAT", 1, 1, localZzgw, localZzhm2);
    zzhm localZzhm3 = zzhm.zzyr;
    zzvh = new zzgu("INT64", 2, 2, localZzgw, localZzhm3);
    zzvi = new zzgu("UINT64", 3, 3, localZzgw, localZzhm3);
    zzhm localZzhm4 = zzhm.zzyq;
    zzvj = new zzgu("INT32", 4, 4, localZzgw, localZzhm4);
    zzvk = new zzgu("FIXED64", 5, 5, localZzgw, localZzhm3);
    zzvl = new zzgu("FIXED32", 6, 6, localZzgw, localZzhm4);
    zzhm localZzhm5 = zzhm.zzyu;
    zzvm = new zzgu("BOOL", 7, 7, localZzgw, localZzhm5);
    Object localObject2 = zzhm.zzyv;
    zzvn = new zzgu("STRING", 8, 8, localZzgw, (zzhm)localObject2);
    Object localObject1 = zzhm.zzyy;
    zzvo = new zzgu("MESSAGE", 9, 9, localZzgw, (zzhm)localObject1);
    zzhm localZzhm7 = zzhm.zzyw;
    zzvp = new zzgu("BYTES", 10, 10, localZzgw, localZzhm7);
    zzvq = new zzgu("UINT32", 11, 11, localZzgw, localZzhm4);
    zzhm localZzhm6 = zzhm.zzyx;
    zzvr = new zzgu("ENUM", 12, 12, localZzgw, localZzhm6);
    zzvs = new zzgu("SFIXED32", 13, 13, localZzgw, localZzhm4);
    zzvt = new zzgu("SFIXED64", 14, 14, localZzgw, localZzhm3);
    zzvu = new zzgu("SINT32", 15, 15, localZzgw, localZzhm4);
    zzvv = new zzgu("SINT64", 16, 16, localZzgw, localZzhm3);
    zzvw = new zzgu("GROUP", 17, 17, localZzgw, (zzhm)localObject1);
    localZzgw = zzgw.zzxm;
    zzvx = new zzgu("DOUBLE_LIST", 18, 18, localZzgw, localZzhm1);
    zzvy = new zzgu("FLOAT_LIST", 19, 19, localZzgw, localZzhm2);
    zzvz = new zzgu("INT64_LIST", 20, 20, localZzgw, localZzhm3);
    zzwa = new zzgu("UINT64_LIST", 21, 21, localZzgw, localZzhm3);
    zzwb = new zzgu("INT32_LIST", 22, 22, localZzgw, localZzhm4);
    zzwc = new zzgu("FIXED64_LIST", 23, 23, localZzgw, localZzhm3);
    zzwd = new zzgu("FIXED32_LIST", 24, 24, localZzgw, localZzhm4);
    zzwe = new zzgu("BOOL_LIST", 25, 25, localZzgw, localZzhm5);
    zzwf = new zzgu("STRING_LIST", 26, 26, localZzgw, (zzhm)localObject2);
    zzwg = new zzgu("MESSAGE_LIST", 27, 27, localZzgw, (zzhm)localObject1);
    zzwh = new zzgu("BYTES_LIST", 28, 28, localZzgw, localZzhm7);
    zzwi = new zzgu("UINT32_LIST", 29, 29, localZzgw, localZzhm4);
    zzwj = new zzgu("ENUM_LIST", 30, 30, localZzgw, localZzhm6);
    zzwk = new zzgu("SFIXED32_LIST", 31, 31, localZzgw, localZzhm4);
    zzwl = new zzgu("SFIXED64_LIST", 32, 32, localZzgw, localZzhm3);
    zzwm = new zzgu("SINT32_LIST", 33, 33, localZzgw, localZzhm4);
    zzwn = new zzgu("SINT64_LIST", 34, 34, localZzgw, localZzhm3);
    localObject2 = zzgw.zzxn;
    zzwo = new zzgu("DOUBLE_LIST_PACKED", 35, 35, (zzgw)localObject2, localZzhm1);
    zzwp = new zzgu("FLOAT_LIST_PACKED", 36, 36, (zzgw)localObject2, localZzhm2);
    zzwq = new zzgu("INT64_LIST_PACKED", 37, 37, (zzgw)localObject2, localZzhm3);
    zzwr = new zzgu("UINT64_LIST_PACKED", 38, 38, (zzgw)localObject2, localZzhm3);
    zzws = new zzgu("INT32_LIST_PACKED", 39, 39, (zzgw)localObject2, localZzhm4);
    zzwt = new zzgu("FIXED64_LIST_PACKED", 40, 40, (zzgw)localObject2, localZzhm3);
    zzwu = new zzgu("FIXED32_LIST_PACKED", 41, 41, (zzgw)localObject2, localZzhm4);
    zzwv = new zzgu("BOOL_LIST_PACKED", 42, 42, (zzgw)localObject2, localZzhm5);
    zzww = new zzgu("UINT32_LIST_PACKED", 43, 43, (zzgw)localObject2, localZzhm4);
    zzwx = new zzgu("ENUM_LIST_PACKED", 44, 44, (zzgw)localObject2, localZzhm6);
    zzwy = new zzgu("SFIXED32_LIST_PACKED", 45, 45, (zzgw)localObject2, localZzhm4);
    localZzhm1 = zzhm.zzyr;
    zzwz = new zzgu("SFIXED64_LIST_PACKED", 46, 46, (zzgw)localObject2, localZzhm1);
    zzxa = new zzgu("SINT32_LIST_PACKED", 47, 47, (zzgw)localObject2, zzhm.zzyq);
    zzxb = new zzgu("SINT64_LIST_PACKED", 48, 48, (zzgw)localObject2, localZzhm1);
    zzxc = new zzgu("GROUP_LIST", 49, 49, localZzgw, (zzhm)localObject1);
    zzxd = new zzgu("MAP", 50, 50, zzgw.zzxo, zzhm.zzyp);
    localObject1 = zzvf;
    int i = 0;
    zzxk = new zzgu[] { localObject1, zzvg, zzvh, zzvi, zzvj, zzvk, zzvl, zzvm, zzvn, zzvo, zzvp, zzvq, zzvr, zzvs, zzvt, zzvu, zzvv, zzvw, zzvx, zzvy, zzvz, zzwa, zzwb, zzwc, zzwd, zzwe, zzwf, zzwg, zzwh, zzwi, zzwj, zzwk, zzwl, zzwm, zzwn, zzwo, zzwp, zzwq, zzwr, zzws, zzwt, zzwu, zzwv, zzww, zzwx, zzwy, zzwz, zzxa, zzxb, zzxc, zzxd };
    zzxj = new Type[0];
    localObject1 = values();
    zzxi = new zzgu[localObject1.length];
    int j = localObject1.length;
    while (i < j)
    {
      localZzhm1 = localObject1[i];
      zzxi[eventType] = localZzhm1;
      i += 1;
    }
  }
  
  private zzgu(int paramInt, zzgw paramZzgw, zzhm paramZzhm)
  {
    eventType = paramInt;
    zzxf = paramZzgw;
    zzxe = paramZzhm;
    ??? = zzgx.zzxr[paramZzgw.ordinal()];
    boolean bool = true;
    if (??? != 1)
    {
      if (??? != 2) {
        zzxg = null;
      } else {
        zzxg = paramZzhm.zzcf();
      }
    }
    else {
      zzxg = paramZzhm.zzcf();
    }
    if (paramZzgw == zzgw.zzxl)
    {
      ??? = zzgx.zzxs[paramZzhm.ordinal()];
      if ((??? != 1) && (??? != 2) && (??? != 3)) {}
    }
    else
    {
      bool = false;
    }
    zzxh = bool;
  }
  
  public final int getEventType()
  {
    return eventType;
  }
}
