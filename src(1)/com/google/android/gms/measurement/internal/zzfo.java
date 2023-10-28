package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.ResultSet;
import java.util.Map;

final class zzfo
  implements ResultSet
{
  zzfo(zzfp paramZzfp, String paramString) {}
  
  public final String get(String paramString)
  {
    Map localMap = (Map)zzfp.access$getOrder(this$0).get(key);
    if ((localMap != null) && (localMap.containsKey(paramString))) {
      return (String)localMap.get(paramString);
    }
    return null;
  }
}
