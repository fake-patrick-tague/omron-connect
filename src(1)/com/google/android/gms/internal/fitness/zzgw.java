package com.google.android.gms.internal.fitness;

 enum zzgw
{
  private final boolean zzxp;
  
  static
  {
    zzgw localZzgw1 = new zzgw("SCALAR", 0, false);
    zzxl = localZzgw1;
    zzgw localZzgw2 = new zzgw("VECTOR", 1, true);
    zzxm = localZzgw2;
    zzgw localZzgw3 = new zzgw("PACKED_VECTOR", 2, true);
    zzxn = localZzgw3;
    zzgw localZzgw4 = new zzgw("MAP", 3, false);
    zzxo = localZzgw4;
    zzxq = new zzgw[] { localZzgw1, localZzgw2, localZzgw3, localZzgw4 };
  }
  
  private zzgw(boolean paramBoolean)
  {
    zzxp = paramBoolean;
  }
}
