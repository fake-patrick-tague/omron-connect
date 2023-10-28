package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy;
import java.lang.reflect.Method;

public class ProviderInstaller
{
  public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
  private static Method b = null;
  private static Method c = null;
  private static final Object t;
  private static final GoogleApiAvailabilityLight time = ;
  
  static
  {
    t = new Object();
  }
  
  public ProviderInstaller() {}
  
  private static Method create(Context paramContext, String paramString1, String paramString2, Class[] paramArrayOfClass)
    throws ClassNotFoundException, NoSuchMethodException
  {
    return paramContext.getClassLoader().loadClass(paramString1).getMethod(paramString2, paramArrayOfClass);
  }
  
  public static void installIfNeeded(Context paramContext)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    Preconditions.checkNotNull(paramContext, "Context must not be null");
    time.verifyGooglePlayServicesIsAvailable(paramContext, 11925000);
    Object localObject2 = t;
    try
    {
      long l1 = SystemClock.elapsedRealtime();
      Object localObject1 = DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING;
      Context localContext;
      try
      {
        localObject1 = DynamiteModule.load(paramContext, (DynamiteModule.VersionPolicy)localObject1, "com.google.android.gms.providerinstaller.dynamite").getModuleContext();
      }
      catch (DynamiteModule.LoadingException localLoadingException)
      {
        Log.w("ProviderInstaller", "Failed to load providerinstaller module: ".concat(String.valueOf(localLoadingException.getMessage())));
        localContext = null;
      }
      if (localContext == null)
      {
        long l2 = SystemClock.elapsedRealtime();
        localContext = GooglePlayServicesUtilLight.getRemoteContext(paramContext);
        if (localContext != null)
        {
          Object localObject3;
          if (c == null) {
            localObject3 = Long.TYPE;
          }
          try
          {
            localObject3 = create(localContext, "com.google.android.gms.common.security.ProviderInstallerImpl", "reportRequestStats", new Class[] { Context.class, localObject3, localObject3 });
            c = (Method)localObject3;
            localObject3 = c;
            ((Method)localObject3).invoke(null, new Object[] { paramContext, Long.valueOf(l1), Long.valueOf(l2) });
          }
          catch (Exception localException)
          {
            Log.w("ProviderInstaller", "Failed to report request stats: ".concat(String.valueOf(localException.getMessage())));
          }
        }
        if (localContext != null)
        {
          read(localContext, paramContext, "com.google.android.gms.common.security.ProviderInstallerImpl");
          return;
        }
        Log.e("ProviderInstaller", "Failed to get remote context");
        throw new GooglePlayServicesNotAvailableException(8);
      }
      read(localContext, paramContext, "com.google.android.gms.providerinstaller.ProviderInstallerImpl");
      return;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public static void installIfNeededAsync(Context paramContext, ProviderInstallListener paramProviderInstallListener)
  {
    Preconditions.checkNotNull(paramContext, "Context must not be null");
    Preconditions.checkNotNull(paramProviderInstallListener, "Listener must not be null");
    Preconditions.checkMainThread("Must be called on the UI thread");
    new Preferences.8(paramContext, paramProviderInstallListener).execute(new Void[0]);
  }
  
  private static void read(Context paramContext1, Context paramContext2, String paramString)
    throws GooglePlayServicesNotAvailableException
  {
    if (b == null) {}
    try
    {
      paramContext2 = create(paramContext1, paramString, "insertProvider", new Class[] { Context.class });
      b = paramContext2;
      paramContext2 = b;
      paramContext2.invoke(null, new Object[] { paramContext1 });
      return;
    }
    catch (Exception paramContext1)
    {
      paramContext2 = paramContext1.getCause();
      if (Log.isLoggable("ProviderInstaller", 6))
      {
        if (paramContext2 == null) {
          paramContext1 = paramContext1.getMessage();
        } else {
          paramContext1 = paramContext2.getMessage();
        }
        Log.e("ProviderInstaller", "Failed to install provider: ".concat(String.valueOf(paramContext1)));
      }
      throw new GooglePlayServicesNotAvailableException(8);
    }
  }
  
  public static abstract interface ProviderInstallListener
  {
    public abstract void onProviderInstallFailed(int paramInt, Intent paramIntent);
    
    public abstract void onProviderInstalled();
  }
}
