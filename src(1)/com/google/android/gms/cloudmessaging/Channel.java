package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.List;

public final class Channel
{
  private final Context context;
  private int currentVersionCode;
  private int status = 0;
  
  public Channel(Context paramContext)
  {
    context = paramContext;
  }
  
  public final int init()
  {
    try
    {
      if (currentVersionCode == 0)
      {
        Object localObject = context;
        String str;
        try
        {
          localObject = Wrappers.packageManager((Context)localObject).getPackageInfo("com.google.android.gms", 0);
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          str = String.valueOf(localNameNotFoundException);
          StringBuilder localStringBuilder = new StringBuilder(str.length() + 23);
          localStringBuilder.append("Failed to find package ");
          localStringBuilder.append(str);
          Log.w("Metadata", localStringBuilder.toString());
          str = null;
        }
        if (str != null) {
          currentVersionCode = versionCode;
        }
      }
      int i = currentVersionCode;
      return i;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final int start()
  {
    try
    {
      int i = status;
      if (i != 0) {
        return i;
      }
      Object localObject1 = context.getPackageManager();
      if (Wrappers.packageManager(context).checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1)
      {
        Log.e("Metadata", "Google Play services missing or without correct permission.");
        return 0;
      }
      boolean bool = PlatformVersion.isAtLeastO();
      i = 1;
      if (!bool)
      {
        localObject2 = new Intent("com.google.android.c2dm.intent.REGISTER");
        ((Intent)localObject2).setPackage("com.google.android.gms");
        localObject2 = ((PackageManager)localObject1).queryIntentServices((Intent)localObject2, 0);
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          status = 1;
          return 1;
        }
      }
      Object localObject2 = new Intent("com.google.iid.TOKEN_REQUEST");
      ((Intent)localObject2).setPackage("com.google.android.gms");
      localObject1 = ((PackageManager)localObject1).queryBroadcastReceivers((Intent)localObject2, 0);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        status = 2;
        return 2;
      }
      Log.w("Metadata", "Failed to resolve IID implementation package, falling back");
      if (PlatformVersion.isAtLeastO())
      {
        status = 2;
        i = 2;
      }
      else
      {
        status = 1;
      }
      return i;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
