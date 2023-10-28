package com.google.android.gms.internal.fitness;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.package_12.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.package_12.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.util.DeviceProperties;
import java.util.Set;

public abstract class UI<T extends IInterface>
  extends GmsClient<T>
{
  protected UI(Context paramContext, Looper paramLooper, zzf.zza paramZza, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, ClientSettings paramClientSettings)
  {
    super(paramContext, paramLooper, paramZza.nextString(), paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public abstract IInterface createServiceInterface(IBinder paramIBinder);
  
  public int getMinApkVersion()
  {
    return 12451000;
  }
  
  public Set getScopesForConnectionlessNonSignIn()
  {
    return getScopes();
  }
  
  public abstract String getServiceDescriptor();
  
  public abstract String getStartServiceAction();
  
  public boolean requiresAccount()
  {
    return true;
  }
  
  public boolean requiresSignIn()
  {
    return !DeviceProperties.isWearable(getContext());
  }
}
