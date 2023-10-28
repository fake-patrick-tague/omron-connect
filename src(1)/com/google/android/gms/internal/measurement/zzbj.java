package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzbj
  extends zzaw
{
  public zzbj() {}
  
  public final zzap add(String paramString, Headers paramHeaders, List paramList)
  {
    if ((paramString != null) && (!paramString.isEmpty()) && (paramHeaders.set(paramString)))
    {
      zzap localZzap = paramHeaders.get(paramString);
      if ((localZzap instanceof zzai)) {
        return ((zzai)localZzap).get(paramHeaders, paramList);
      }
      throw new IllegalArgumentException(String.format("Function %s is not defined", new Object[] { paramString }));
    }
    throw new IllegalArgumentException(String.format("Command not found: %s", new Object[] { paramString }));
  }
}
