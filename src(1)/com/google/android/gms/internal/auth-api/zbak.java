package com.google.android.gms.internal.auth-api;

import android.os.RemoteException;
import com.google.android.gms.auth.util.identity.SaveAccountLinkingTokenResult;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zbak
  extends zbac
{
  zbak(zbam paramZbam, TaskCompletionSource paramTaskCompletionSource) {}
  
  public final void handleException(Status paramStatus, SaveAccountLinkingTokenResult paramSaveAccountLinkingTokenResult)
    throws RemoteException
  {
    if (paramStatus.isSuccess())
    {
      this$0.setResult(paramSaveAccountLinkingTokenResult);
      return;
    }
    this$0.setException(ApiExceptionUtil.fromStatus(paramStatus));
  }
}
