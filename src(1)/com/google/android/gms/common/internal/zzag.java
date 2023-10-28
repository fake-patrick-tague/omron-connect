package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.BaseBundle;
import android.util.Log;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

public final class zzag
{
  private static String appName;
  private static final Object context = new Object();
  private static boolean networkAvailable;
  private static int versionCode;
  
  public static String getAppName(Context paramContext)
  {
    onCreate(paramContext);
    return appName;
  }
  
  public static int getCurrentVersion(Context paramContext)
  {
    onCreate(paramContext);
    return versionCode;
  }
  
  private static void onCreate(Context paramContext)
  {
    Object localObject = context;
    try
    {
      if (networkAvailable) {
        return;
      }
      networkAvailable = true;
      String str = paramContext.getPackageName();
      paramContext = Wrappers.packageManager(paramContext);
      try
      {
        paramContext = paramContext.getApplicationInfo(str, 128);
        paramContext = metaData;
        if (paramContext == null) {
          return;
        }
        str = paramContext.getString("com.google.app.id");
        appName = str;
        int i = paramContext.getInt("com.google.android.gms.version");
        versionCode = i;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        Log.wtf("MetadataValueReader", "This should never happen.", paramContext);
      }
      return;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
}
