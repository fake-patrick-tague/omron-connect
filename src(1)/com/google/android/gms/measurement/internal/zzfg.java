package com.google.android.gms.measurement.internal;

import android.content.pm.PackageInfo;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

public final class zzfg
{
  final zzfy this$0;
  
  zzfg(zzkz paramZzkz)
  {
    this$0 = paramZzkz.context();
  }
  
  final boolean checkVersion()
  {
    Object localObject = this$0;
    try
    {
      localObject = Wrappers.packageManager(((zzfy)localObject).zzau());
      if (localObject == null)
      {
        localObject = this$0;
        ((zzfy)localObject).zzay().next().append("Failed to get PackageManager for Install Referrer Play Store compatibility check");
        return false;
      }
      localObject = ((PackageManagerWrapper)localObject).getPackageInfo("com.android.vending", 128);
      if (versionCode >= 80837300) {
        return true;
      }
    }
    catch (Exception localException)
    {
      this$0.zzay().next().append("Failed to retrieve Play Store version for Install Referrer", localException);
    }
    return false;
  }
}
