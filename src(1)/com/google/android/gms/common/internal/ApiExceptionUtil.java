package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.package_12.ApiException;
import com.google.android.gms.common.package_12.ResolvableApiException;
import com.google.android.gms.common.package_12.Status;

@KeepForSdk
public class ApiExceptionUtil
{
  public ApiExceptionUtil() {}
  
  public static ApiException fromStatus(Status paramStatus)
  {
    if (paramStatus.hasResolution()) {
      return new ResolvableApiException(paramStatus);
    }
    return new ApiException(paramStatus);
  }
}
