package com.google.android.gms.auth.util.accounttransfer;

import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.internal.auth.Section;

final class Chapter
  extends Section
{
  Chapter(AccountTransferClient.zzc paramZzc) {}
  
  public final void onFailure(Status paramStatus)
  {
    zzay.onStatusChanged(paramStatus);
  }
  
  public final void setId()
  {
    zzay.setResult(null);
  }
}
