package com.google.android.gms.common.wrappers;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import v7.v7.util.Position;

@KeepForSdk
public class PackageManagerWrapper
{
  protected final Context context;
  
  public PackageManagerWrapper(Context paramContext)
  {
    context = paramContext;
  }
  
  public int checkCallingOrSelfPermission(String paramString)
  {
    return context.checkCallingOrSelfPermission(paramString);
  }
  
  public int checkPermission(String paramString1, String paramString2)
  {
    return context.getPackageManager().checkPermission(paramString1, paramString2);
  }
  
  public final boolean checkPermission(int paramInt, String paramString)
  {
    if (PlatformVersion.isAtLeastKitKat()) {
      localObject = context;
    }
    try
    {
      localObject = ((Context)localObject).getSystemService("appops");
      localObject = (AppOpsManager)localObject;
      if (localObject != null)
      {
        ((AppOpsManager)localObject).checkPackage(paramInt, paramString);
        return true;
      }
      paramString = new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
      throw paramString;
    }
    catch (SecurityException paramString) {}
    Object localObject = context.getPackageManager().getPackagesForUid(paramInt);
    if (paramString != null)
    {
      if (localObject != null)
      {
        paramInt = 0;
        while (paramInt < localObject.length)
        {
          if (paramString.equals(localObject[paramInt])) {
            return true;
          }
          paramInt += 1;
        }
      }
    }
    else {
      return false;
    }
    return false;
  }
  
  public ApplicationInfo getApplicationInfo(String paramString, int paramInt)
    throws PackageManager.NameNotFoundException
  {
    return context.getPackageManager().getApplicationInfo(paramString, paramInt);
  }
  
  public CharSequence getApplicationLabel(String paramString)
    throws PackageManager.NameNotFoundException
  {
    return context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(paramString, 0));
  }
  
  public Position getApplicationLabelAndIcon(String paramString)
    throws PackageManager.NameNotFoundException
  {
    paramString = context.getPackageManager().getApplicationInfo(paramString, 0);
    return Position.fromDegrees(context.getPackageManager().getApplicationLabel(paramString), context.getPackageManager().getApplicationIcon(paramString));
  }
  
  public PackageInfo getPackageInfo(String paramString, int paramInt)
    throws PackageManager.NameNotFoundException
  {
    return context.getPackageManager().getPackageInfo(paramString, paramInt);
  }
  
  public boolean isCallerInstantApp()
  {
    if (Binder.getCallingUid() == Process.myUid()) {
      return InstantApps.isInstantApp(context);
    }
    if (PlatformVersion.isAtLeastO())
    {
      String str = context.getPackageManager().getNameForUid(Binder.getCallingUid());
      if (str != null) {
        return context.getPackageManager().isInstantApp(str);
      }
    }
    return false;
  }
}
