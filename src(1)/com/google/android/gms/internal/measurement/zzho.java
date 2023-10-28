package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Log;

public final class zzho
{
  private static final Object mList = new Object();
  static volatile zzif path = ;
  
  public static boolean init(Context paramContext, Uri paramUri)
  {
    paramUri = paramUri.getAuthority();
    boolean bool1 = "com.google.android.gms.phenotype".equals(paramUri);
    boolean bool2 = false;
    if (!bool1)
    {
      Log.e("PhenotypeClientHelper", String.valueOf(paramUri).concat(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported."));
      return false;
    }
    if (path.isEmpty()) {
      return ((Boolean)path.get()).booleanValue();
    }
    paramUri = mList;
    for (;;)
    {
      try
      {
        if (path.isEmpty())
        {
          bool1 = ((Boolean)path.get()).booleanValue();
          return bool1;
        }
        if (!"com.google.android.gms".equals(paramContext.getPackageName()))
        {
          Object localObject = paramContext.getPackageManager();
          if (Build.VERSION.SDK_INT >= 29) {
            break label227;
          }
          i = 0;
          localObject = ((PackageManager)localObject).resolveContentProvider("com.google.android.gms.phenotype", i);
          bool1 = bool2;
          if (localObject == null) {
            continue;
          }
          if (!"com.google.android.gms".equals(packageName))
          {
            bool1 = bool2;
            continue;
          }
        }
        paramContext = paramContext.getPackageManager();
      }
      catch (Throwable paramContext)
      {
        throw paramContext;
      }
      try
      {
        paramContext = paramContext.getApplicationInfo("com.google.android.gms", 0);
        bool1 = bool2;
        if ((flags & 0x81) != 0) {
          bool1 = true;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        bool1 = bool2;
        continue;
      }
      path = zzif.decode(Boolean.valueOf(bool1));
      return ((Boolean)path.get()).booleanValue();
      label227:
      int i = 268435456;
    }
  }
}
