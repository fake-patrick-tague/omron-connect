package com.google.android.gms.fitness.request;

import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.internal.ListenerHolder;
import com.google.android.gms.common.package_12.internal.ListenerHolders;
import java.util.HashMap;
import java.util.Map;

public final class zzan
{
  private static final zzan zzrr = new zzan();
  private final Map<com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey<OnDataPointListener>, zzam> zzrs = new HashMap();
  
  private zzan() {}
  
  public static zzan get()
  {
    return zzrr;
  }
  
  private static ListenerHolder valueOf(OnDataPointListener paramOnDataPointListener, Looper paramLooper)
  {
    return ListenerHolders.createListenerHolder(paramOnDataPointListener, paramLooper, OnDataPointListener.class.getSimpleName());
  }
  
  public final zzam call(OnDataPointListener paramOnDataPointListener, Looper paramLooper)
  {
    return map(valueOf(paramOnDataPointListener, paramLooper));
  }
  
  public final zzam get(ListenerHolder paramListenerHolder)
  {
    Map localMap = zzrs;
    try
    {
      paramListenerHolder = paramListenerHolder.getListenerKey();
      if (paramListenerHolder == null) {
        return null;
      }
      paramListenerHolder = (zzam)zzrs.remove(paramListenerHolder);
      if (paramListenerHolder != null) {
        paramListenerHolder.release();
      }
      return paramListenerHolder;
    }
    catch (Throwable paramListenerHolder)
    {
      throw paramListenerHolder;
    }
  }
  
  public final zzam getString(OnDataPointListener paramOnDataPointListener, Looper paramLooper)
  {
    return get(valueOf(paramOnDataPointListener, paramLooper));
  }
  
  public final zzam map(ListenerHolder paramListenerHolder)
  {
    Map localMap = zzrs;
    try
    {
      com.google.android.gms.common.package_12.internal.ListenerHolder.ListenerKey localListenerKey = (com.google.android.gms.common.package_12.internal.ListenerHolder.ListenerKey)Preconditions.checkNotNull(paramListenerHolder.getListenerKey(), "Key must not be null");
      zzam localZzam2 = (zzam)zzrs.get(localListenerKey);
      zzam localZzam1 = localZzam2;
      if (localZzam2 == null)
      {
        localZzam1 = new zzam(paramListenerHolder, null);
        zzrs.put(localListenerKey, localZzam1);
      }
      return localZzam1;
    }
    catch (Throwable paramListenerHolder)
    {
      throw paramListenerHolder;
    }
  }
}
