package com.google.android.gms.internal.measurement;

import java.util.List;

final class zzkx
  extends zzkz
{
  private zzkx()
  {
    super(null);
  }
  
  final void add(Object paramObject, long paramLong)
  {
    ((zzkl)zzmx.getValue(paramObject, paramLong)).inc();
  }
  
  final void get(Object paramObject1, Object paramObject2, long paramLong)
  {
    zzkl localZzkl1 = (zzkl)zzmx.getValue(paramObject1, paramLong);
    zzkl localZzkl2 = (zzkl)zzmx.getValue(paramObject2, paramLong);
    int i = localZzkl1.size();
    int j = localZzkl2.size();
    paramObject2 = localZzkl1;
    if (i > 0)
    {
      paramObject2 = localZzkl1;
      if (j > 0)
      {
        paramObject2 = localZzkl1;
        if (!localZzkl1.get()) {
          paramObject2 = localZzkl1.trim(j + i);
        }
        paramObject2.addAll(localZzkl2);
      }
    }
    if (i <= 0) {
      paramObject2 = localZzkl2;
    }
    zzmx.add(paramObject1, paramLong, paramObject2);
  }
}
