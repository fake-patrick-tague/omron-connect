package com.google.android.gms.internal.auth;

import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.common.package_12.internal.BasePendingResult;

final class zzav
  extends zzaj
{
  zzav(zzau paramZzau) {}
  
  public final void Update(String paramString)
  {
    if (paramString != null)
    {
      zzcg.setResult(new zzax(paramString));
      return;
    }
    zzcg.setResult(zzaq.getStation(new Status(3006)));
  }
}
