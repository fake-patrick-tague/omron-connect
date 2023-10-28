package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzjq
{
  static final zzjq o = new zzjq(true);
  private static volatile zzjq session;
  private static volatile boolean showIcons;
  private final Map responseHeaders;
  
  zzjq()
  {
    responseHeaders = new HashMap();
  }
  
  zzjq(boolean paramBoolean)
  {
    responseHeaders = Collections.emptyMap();
  }
  
  public static zzjq get()
  {
    zzjq localZzjq = session;
    if (localZzjq != null) {
      return localZzjq;
    }
    try
    {
      localZzjq = session;
      if (localZzjq != null) {
        return localZzjq;
      }
      localZzjq = zzjy.newInstance(zzjq.class);
      session = localZzjq;
      return localZzjq;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final zzkc a(zzll paramZzll, int paramInt)
  {
    return (zzkc)responseHeaders.get(new zzjp(paramZzll, paramInt));
  }
}
