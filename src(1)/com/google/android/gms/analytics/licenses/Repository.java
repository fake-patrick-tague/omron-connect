package com.google.android.gms.analytics.licenses;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.util.Log;

public final class Repository
{
  private static Repository parent;
  private final Context context;
  private Connection id;
  
  private Repository(Context paramContext)
  {
    context = paramContext.getApplicationContext();
  }
  
  public static Repository create(Context paramContext)
  {
    if (parent == null)
    {
      paramContext = new Repository(paramContext);
      parent = paramContext;
      id = new Connection(context);
    }
    return parent;
  }
  
  public static Scope create(Context paramContext, String paramString)
  {
    try
    {
      localObject = paramContext.getPackageManager().getResourcesForApplication(paramString);
      localObject = new Scope((Resources)localObject, paramString, null);
      return localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Object localObject;
      for (;;) {}
    }
    localObject = new StringBuilder(String.valueOf(paramString).length() + 52);
    ((StringBuilder)localObject).append("Unable to get resources for ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", using local resources.");
    Log.w("OssLicenses", ((StringBuilder)localObject).toString());
    return new Scope(paramContext.getResources(), paramContext.getPackageName(), null);
  }
  
  public static int get(Scope paramScope)
  {
    return this$0.getIdentifier("license", "id", packageName);
  }
  
  public static int getId(Scope paramScope)
  {
    return this$0.getIdentifier("libraries_social_licenses_license", "layout", packageName);
  }
  
  public final Connection close()
  {
    return id;
  }
}
