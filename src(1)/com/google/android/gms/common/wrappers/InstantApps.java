package com.google.android.gms.common.wrappers;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;

@KeepForSdk
public class InstantApps
{
  private static Context parent;
  private static Boolean value;
  
  public InstantApps() {}
  
  public static boolean isInstantApp(Context paramContext)
  {
    for (;;)
    {
      try
      {
        localContext1 = paramContext.getApplicationContext();
        Context localContext2 = parent;
        if (localContext2 != null)
        {
          Boolean localBoolean = value;
          if ((localBoolean != null) && (localContext2 == localContext1))
          {
            bool = localBoolean.booleanValue();
            return bool;
          }
        }
        value = null;
        if (PlatformVersion.isAtLeastO()) {
          value = Boolean.valueOf(localContext1.getPackageManager().isInstantApp());
        }
      }
      catch (Throwable paramContext)
      {
        Context localContext1;
        boolean bool;
        throw paramContext;
      }
      try
      {
        paramContext.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
        value = Boolean.TRUE;
      }
      catch (ClassNotFoundException paramContext) {}
    }
    value = Boolean.FALSE;
    parent = localContext1;
    bool = value.booleanValue();
    return bool;
  }
}
