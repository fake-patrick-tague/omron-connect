package com.google.android.gms.fitness.request;

import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.internal.ListenerHolder;
import com.google.android.gms.common.package_12.internal.ListenerHolders;
import java.util.HashMap;
import java.util.Map;

public final class Status
{
  private static final Status zzqm = new Status();
  private final Map<com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey<BleScanCallback>, zza> zzqn = new HashMap();
  
  private Status() {}
  
  public static Status parse()
  {
    return zzqm;
  }
  
  private static ListenerHolder valueOf(BleScanCallback paramBleScanCallback, Looper paramLooper)
  {
    return ListenerHolders.createListenerHolder(paramBleScanCallback, paramLooper, BleScanCallback.class.getSimpleName());
  }
  
  public final Document get(ListenerHolder paramListenerHolder)
  {
    Map localMap = zzqn;
    try
    {
      paramListenerHolder = paramListenerHolder.getListenerKey();
      if (paramListenerHolder == null) {
        return null;
      }
      paramListenerHolder = (Document)zzqn.get(paramListenerHolder);
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
  
  public final Document get(BleScanCallback paramBleScanCallback, Looper paramLooper)
  {
    return parse(valueOf(paramBleScanCallback, paramLooper));
  }
  
  public final Document parse(ListenerHolder paramListenerHolder)
  {
    Map localMap = zzqn;
    try
    {
      com.google.android.gms.common.package_12.internal.ListenerHolder.ListenerKey localListenerKey = (com.google.android.gms.common.package_12.internal.ListenerHolder.ListenerKey)Preconditions.checkNotNull(paramListenerHolder.getListenerKey(), "Key must not be null");
      Document localDocument2 = (Document)zzqn.get(localListenerKey);
      Document localDocument1 = localDocument2;
      if (localDocument2 == null)
      {
        localDocument1 = new Document(paramListenerHolder, null);
        zzqn.put(localListenerKey, localDocument1);
      }
      return localDocument1;
    }
    catch (Throwable paramListenerHolder)
    {
      throw paramListenerHolder;
    }
  }
  
  public final Document read(BleScanCallback paramBleScanCallback, Looper paramLooper)
  {
    return get(valueOf(paramBleScanCallback, paramLooper));
  }
}
