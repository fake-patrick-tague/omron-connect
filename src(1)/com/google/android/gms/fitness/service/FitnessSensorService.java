package com.google.android.gms.fitness.service;

import android.app.AppOpsManager;
import android.app.Service;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.fitness.IExtensionHost.Stub;
import com.google.android.gms.internal.fitness.zzbh;
import com.google.android.gms.internal.fitness.zzcn;
import com.google.android.gms.internal.fitness.zzer;
import com.google.android.gms.internal.fitness.zzet;
import com.google.android.gms.internal.fitness.zzeu;
import java.util.List;

public abstract class FitnessSensorService
  extends Service
{
  @RecentlyNonNull
  public static final String SERVICE_INTERFACE = "com.google.android.gms.fitness.service.FitnessSensorService";
  private zza zztb;
  
  public FitnessSensorService() {}
  
  public IBinder onBind(Intent paramIntent)
  {
    if ("com.google.android.gms.fitness.service.FitnessSensorService".equals(paramIntent.getAction()))
    {
      if (Log.isLoggable("FitnessSensorService", 3))
      {
        paramIntent = String.valueOf(paramIntent);
        String str = getClass().getName();
        StringBuilder localStringBuilder = new StringBuilder(paramIntent.length() + 20 + str.length());
        localStringBuilder.append("Intent ");
        localStringBuilder.append(paramIntent);
        localStringBuilder.append(" received by ");
        localStringBuilder.append(str);
        Log.d("FitnessSensorService", localStringBuilder.toString());
      }
      return zztb.asBinder();
    }
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    zztb = new zza(this, null);
  }
  
  public abstract List onFindDataSources(List paramList);
  
  public abstract boolean onRegister(FitnessSensorServiceRequest paramFitnessSensorServiceRequest);
  
  public abstract boolean onUnregister(DataSource paramDataSource);
  
  protected final void zzac()
  {
    int i = Binder.getCallingUid();
    if (PlatformVersion.isAtLeastKitKat())
    {
      ((AppOpsManager)getSystemService("appops")).checkPackage(i, "com.google.android.gms");
      return;
    }
    String[] arrayOfString = getPackageManager().getPackagesForUid(i);
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equals("com.google.android.gms")) {
          return;
        }
        i += 1;
      }
    }
    throw new SecurityException("Unauthorized caller");
  }
  
  private static final class zza
    extends zzeu
  {
    private final FitnessSensorService zztc;
    
    private zza(FitnessSensorService paramFitnessSensorService)
    {
      zztc = paramFitnessSensorService;
    }
    
    public final void addUrls(FitnessSensorServiceRequest paramFitnessSensorServiceRequest, zzcn paramZzcn)
      throws RemoteException
    {
      zztc.zzac();
      if (zztc.onRegister(paramFitnessSensorServiceRequest))
      {
        paramZzcn.onResult(Status.RESULT_SUCCESS);
        return;
      }
      paramZzcn.onResult(new Status(13));
    }
    
    public final void addUrls(zzet paramZzet, zzcn paramZzcn)
      throws RemoteException
    {
      zztc.zzac();
      if (zztc.onUnregister(paramZzet.getDataSource()))
      {
        paramZzcn.onResult(Status.RESULT_SUCCESS);
        return;
      }
      paramZzcn.onResult(new Status(13));
    }
    
    public final void cd(zzer paramZzer, zzbh paramZzbh)
      throws RemoteException
    {
      zztc.zzac();
      paramZzbh.init(new DataSourcesResult(zztc.onFindDataSources(paramZzer.getDataTypes()), Status.RESULT_SUCCESS));
    }
  }
}
