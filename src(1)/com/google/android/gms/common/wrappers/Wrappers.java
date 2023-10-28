package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class Wrappers
{
  private static Wrappers TOKENS = new Wrappers();
  private PackageManagerWrapper i = null;
  
  public Wrappers() {}
  
  public static PackageManagerWrapper packageManager(Context paramContext)
  {
    return TOKENS.add(paramContext);
  }
  
  public final PackageManagerWrapper add(Context paramContext)
  {
    try
    {
      if (i == null)
      {
        Context localContext = paramContext;
        if (paramContext.getApplicationContext() != null) {
          localContext = paramContext.getApplicationContext();
        }
        i = new PackageManagerWrapper(localContext);
      }
      paramContext = i;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
}
