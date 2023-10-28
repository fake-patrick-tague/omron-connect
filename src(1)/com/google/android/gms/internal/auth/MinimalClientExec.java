package com.google.android.gms.internal.auth;

import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.common.package_12.internal.BasePendingResult;

final class MinimalClientExec
  extends BackgroundExecutor.Task
{
  MinimalClientExec(AbstractHttpClient paramAbstractHttpClient) {}
  
  public final void execute(boolean paramBoolean)
  {
    AbstractHttpClient localAbstractHttpClient = zzag;
    Status localStatus;
    if (paramBoolean) {
      localStatus = Status.RESULT_SUCCESS;
    } else {
      localStatus = BaseResource.get();
    }
    localAbstractHttpClient.setResult(new Contact(localStatus));
  }
}
