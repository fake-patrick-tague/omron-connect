package com.alivecor.asm;

import android.content.Context;

public class b
{
  private static b a;
  private k b = onCreate(paramPackageManagerUtil);
  
  private b(PackageManagerUtil paramPackageManagerUtil) {}
  
  public static b a()
  {
    try
    {
      b localB = a;
      return localB;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private static void a(PackageManagerUtil paramPackageManagerUtil)
  {
    try
    {
      a = new b(paramPackageManagerUtil);
      return;
    }
    catch (Throwable paramPackageManagerUtil)
    {
      throw paramPackageManagerUtil;
    }
  }
  
  public static PackageManagerUtil getInstance(Context paramContext)
  {
    return new PackageManagerUtil(paramContext);
  }
  
  private k onCreate(PackageManagerUtil paramPackageManagerUtil)
  {
    return r.a().a(PackageManagerUtil.getInstance(paramPackageManagerUtil)).a(PackageManagerUtil.isSystemApp(paramPackageManagerUtil)).a(PackageManagerUtil.a(paramPackageManagerUtil)).a(PackageManagerUtil.isIntentAvailable(paramPackageManagerUtil)).a();
  }
  
  public static void onCreate(Context paramContext)
  {
    getInstance(paramContext).initialize();
  }
  
  public k b()
  {
    return b;
  }
}
