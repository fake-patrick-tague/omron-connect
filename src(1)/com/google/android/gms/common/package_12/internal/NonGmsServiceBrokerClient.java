package com.google.android.gms.common.package_12.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.Api.Client;
import com.google.android.gms.internal.base.Logger;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Set;

@KeepForSdk
public final class NonGmsServiceBrokerClient
  implements Api.Client, ServiceConnection
{
  private static final String FLOAT = com.google.android.gms.common.api.internal.NonGmsServiceBrokerClient.class.getSimpleName();
  private final ComponentName componentName;
  private String connectThread = null;
  private final String itemType;
  private final Context mContext;
  private final Handler mHandler;
  private IBinder mIsConnected;
  private boolean mIsConnecting = false;
  private String mTo;
  private final String name;
  private final ConnectionCallbacks this$0;
  private final OnConnectionFailedListener url;
  
  public NonGmsServiceBrokerClient(Context paramContext, Looper paramLooper, ComponentName paramComponentName, ConnectionCallbacks paramConnectionCallbacks, OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext, paramLooper, null, null, paramComponentName, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  private NonGmsServiceBrokerClient(Context paramContext, Looper paramLooper, String paramString1, String paramString2, ComponentName paramComponentName, ConnectionCallbacks paramConnectionCallbacks, OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    mContext = paramContext;
    mHandler = new Logger(paramLooper);
    this$0 = paramConnectionCallbacks;
    url = paramOnConnectionFailedListener;
    if ((paramString1 != null) && (paramString2 != null))
    {
      if (paramComponentName != null) {
        break label86;
      }
      paramComponentName = null;
    }
    else
    {
      if (paramComponentName == null) {
        break label86;
      }
    }
    name = paramString1;
    itemType = paramString2;
    componentName = paramComponentName;
    return;
    label86:
    throw new AssertionError("Must specify either package or component, but not both");
  }
  
  public NonGmsServiceBrokerClient(Context paramContext, Looper paramLooper, String paramString1, String paramString2, ConnectionCallbacks paramConnectionCallbacks, OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext, paramLooper, paramString1, paramString2, null, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  private final void close()
  {
    if (Thread.currentThread() == mHandler.getLooper().getThread()) {
      return;
    }
    throw new IllegalStateException("This method should only run on the NonGmsServiceBrokerClient's handler thread.");
  }
  
  private final void write(String paramString)
  {
    String.valueOf(mIsConnected).length();
  }
  
  public final void connect(BaseGmsClient.ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks)
  {
    close();
    write("Connect started.");
    if (isConnected()) {}
    try
    {
      disconnect("connect() called when already connected");
      try
      {
        paramConnectionProgressReportCallbacks = new Intent();
        Object localObject = componentName;
        if (localObject != null)
        {
          paramConnectionProgressReportCallbacks.setComponent((ComponentName)localObject);
        }
        else
        {
          localObject = name;
          localObject = paramConnectionProgressReportCallbacks.setPackage((String)localObject);
          String str = itemType;
          ((Intent)localObject).setAction(str);
        }
        localObject = mContext;
        boolean bool = ((Context)localObject).bindService(paramConnectionProgressReportCallbacks, this, GmsClientSupervisor.getDefaultBindFlags());
        mIsConnecting = bool;
        if (!bool)
        {
          mIsConnected = null;
          url.onConnectionFailed(new ConnectionResult(16));
        }
        write("Finished connect.");
        return;
      }
      catch (SecurityException paramConnectionProgressReportCallbacks)
      {
        mIsConnecting = false;
        mIsConnected = null;
        throw paramConnectionProgressReportCallbacks;
      }
    }
    catch (Exception paramConnectionProgressReportCallbacks)
    {
      for (;;) {}
    }
  }
  
  public final void disconnect()
  {
    close();
    write("Disconnect called.");
    Context localContext = mContext;
    try
    {
      localContext.unbindService(this);
      mIsConnecting = false;
      mIsConnected = null;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
  }
  
  public final void disconnect(String paramString)
  {
    close();
    connectThread = paramString;
    disconnect();
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public final Feature[] getAvailableFeatures()
  {
    return new Feature[0];
  }
  
  public IBinder getBinder()
  {
    close();
    return mIsConnected;
  }
  
  public final String getEndpointPackageName()
  {
    String str = name;
    if (str != null) {
      return str;
    }
    Preconditions.checkNotNull(componentName);
    return componentName.getPackageName();
  }
  
  public final String getLastDisconnectMessage()
  {
    return connectThread;
  }
  
  public final int getMinApkVersion()
  {
    return 0;
  }
  
  public final void getRemoteService(IAccountAccessor paramIAccountAccessor, Set paramSet) {}
  
  public final Feature[] getRequiredFeatures()
  {
    return new Feature[0];
  }
  
  public final Set getScopesForConnectionlessNonSignIn()
  {
    return Collections.emptySet();
  }
  
  public final IBinder getServiceBrokerBinder()
  {
    return null;
  }
  
  public final Intent getSignInIntent()
  {
    return new Intent();
  }
  
  public final boolean isConnected()
  {
    close();
    return mIsConnected != null;
  }
  
  public final boolean isConnecting()
  {
    close();
    return mIsConnecting;
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    mHandler.post(new zacg(this, paramIBinder));
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    mHandler.post(new zacf(this));
  }
  
  public final void onUserSignOut(BaseGmsClient.SignOutCallbacks paramSignOutCallbacks) {}
  
  public final boolean providesSignIn()
  {
    return false;
  }
  
  public final boolean requiresAccount()
  {
    return false;
  }
  
  public final boolean requiresGooglePlayServices()
  {
    return false;
  }
  
  public final boolean requiresSignIn()
  {
    return false;
  }
  
  public final void setTo(String paramString)
  {
    mTo = paramString;
  }
}
