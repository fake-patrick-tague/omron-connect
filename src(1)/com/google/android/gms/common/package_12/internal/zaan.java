package com.google.android.gms.common.package_12.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;

final class zaan
  extends zabg
{
  zaan(zaao paramZaao, zabf paramZabf, BaseGmsClient.ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks)
  {
    super(paramZabf);
  }
  
  public final void drain()
  {
    inner.onReportServiceBinding(new ConnectionResult(16, null));
  }
}
