package com.google.android.gms.internal.auth-api;

import com.google.android.gms.auth.util.credentials.Credential;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.common.package_12.internal.BasePendingResult;

final class DownloadFile
  extends LongPreference
{
  DownloadFile(OkHttpCall paramOkHttpCall) {}
  
  public final void delete(Status paramStatus)
  {
    this$0.setResult(new Category(paramStatus, null));
  }
  
  public final void delete(Status paramStatus, Credential paramCredential)
  {
    this$0.setResult(new Category(paramStatus, paramCredential));
  }
}
