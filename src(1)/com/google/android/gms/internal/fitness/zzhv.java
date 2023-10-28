package com.google.android.gms.internal.fitness;

import java.util.List;

final class zzhv
  extends zzhu
{
  private zzhv()
  {
    super(null);
  }
  
  private static zzhh getName(Object paramObject, long paramLong)
  {
    return (zzhh)zzjy.getName(paramObject, paramLong);
  }
  
  final void setObjectClass(Object paramObject, long paramLong)
  {
    getName(paramObject, paramLong).zzar();
  }
  
  final void showImage(Object paramObject1, Object paramObject2, long paramLong)
  {
    zzhh localZzhh2 = getName(paramObject1, paramLong);
    zzhh localZzhh1 = localZzhh2;
    zzhh localZzhh3 = getName(paramObject2, paramLong);
    Object localObject = localZzhh3;
    int i = localZzhh2.size();
    int j = localZzhh3.size();
    paramObject2 = localZzhh1;
    if (i > 0)
    {
      paramObject2 = localZzhh1;
      if (j > 0)
      {
        paramObject2 = localZzhh1;
        if (!localZzhh2.zzaq()) {
          paramObject2 = localZzhh2.zzae(j + i);
        }
        paramObject2.addAll(localZzhh3);
      }
    }
    if (i > 0) {
      localObject = paramObject2;
    }
    zzjy.append(paramObject1, paramLong, localObject);
  }
}
