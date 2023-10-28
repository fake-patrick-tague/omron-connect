package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.util.proxy.ProxyApi.SpatulaHeaderResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.Status;

public final class zzax
  implements ProxyApi.SpatulaHeaderResult
{
  private Status mStatus;
  private String zzci;
  
  public zzax(Status paramStatus)
  {
    mStatus = ((Status)Preconditions.checkNotNull(paramStatus));
  }
  
  public zzax(String paramString)
  {
    zzci = ((String)Preconditions.checkNotNull(paramString));
    mStatus = Status.RESULT_SUCCESS;
  }
  
  public final String getSpatulaHeader()
  {
    return zzci;
  }
  
  public final Status getStatus()
  {
    return mStatus;
  }
}
