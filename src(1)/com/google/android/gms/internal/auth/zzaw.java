package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.util.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.util.proxy.ProxyResponse;
import com.google.android.gms.common.package_12.Status;

final class zzaw
  implements ProxyApi.ProxyResult
{
  private Status mStatus;
  private ProxyResponse zzch;
  
  public zzaw(ProxyResponse paramProxyResponse)
  {
    zzch = paramProxyResponse;
    mStatus = Status.RESULT_SUCCESS;
  }
  
  public zzaw(Status paramStatus)
  {
    mStatus = paramStatus;
  }
  
  public final ProxyResponse getResponse()
  {
    return zzch;
  }
  
  public final Status getStatus()
  {
    return mStatus;
  }
}
