package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.BaseBundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

@KeepForSdk
public class ClientLibraryUtils
{
  private ClientLibraryUtils() {}
  
  public static int getClientVersion(Context paramContext, String paramString)
  {
    paramContext = getPackageInfo(paramContext, paramString);
    if (paramContext != null)
    {
      paramContext = applicationInfo;
      if (paramContext == null) {
        return -1;
      }
      paramContext = metaData;
      if (paramContext != null) {
        return paramContext.getInt("com.google.android.gms.version", -1);
      }
    }
    return -1;
  }
  
  public static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    try
    {
      paramContext = Wrappers.packageManager(paramContext).getPackageInfo(paramString, 128);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static boolean isPackageSide()
  {
    return false;
  }
}
