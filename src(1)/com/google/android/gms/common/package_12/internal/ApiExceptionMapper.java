package com.google.android.gms.common.package_12.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.package_12.Status;

@KeepForSdk
public class ApiExceptionMapper
  implements StatusExceptionMapper
{
  public ApiExceptionMapper() {}
  
  public final Exception getException(Status paramStatus)
  {
    return ApiExceptionUtil.fromStatus(paramStatus);
  }
}
