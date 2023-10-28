package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

@KeepForSdk
public final class UidVerifier
{
  private UidVerifier() {}
  
  public static boolean isGooglePlayServicesUid(Context paramContext, int paramInt)
  {
    if (!uidHasPackageName(paramContext, paramInt, "com.google.android.gms")) {
      return false;
    }
    Object localObject = paramContext.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo("com.google.android.gms", 64);
      return GoogleSignatureVerifier.getInstance(paramContext).isGooglePublicSignedPackage((PackageInfo)localObject);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    if (Log.isLoggable("UidVerifier", 3))
    {
      Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
      return false;
    }
    return false;
  }
  
  public static boolean uidHasPackageName(Context paramContext, int paramInt, String paramString)
  {
    return Wrappers.packageManager(paramContext).checkPermission(paramInt, paramString);
  }
}
