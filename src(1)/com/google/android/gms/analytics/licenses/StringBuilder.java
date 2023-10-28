package com.google.android.gms.analytics.licenses;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.package_12.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.package_12.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.oss_licenses.Server;
import com.google.android.gms.oss.licenses.zza;
import java.util.List;

public final class StringBuilder
  extends GmsClient<zza>
{
  public StringBuilder(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 185, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  private final Entry get()
  {
    try
    {
      IInterface localIInterface = super.getService();
      return (Entry)localIInterface;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      for (;;) {}
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;) {}
    }
    return null;
  }
  
  public final List call(List paramList)
    throws RemoteException
  {
    try
    {
      Entry localEntry = get();
      if (localEntry != null)
      {
        paramList = localEntry.getValue(paramList);
        return paramList;
      }
      throw new RemoteException("no service for getLicenseList call");
    }
    catch (Throwable paramList)
    {
      throw paramList;
    }
  }
  
  public final String compareTo(Server paramServer)
    throws RemoteException
  {
    try
    {
      Entry localEntry = get();
      if (localEntry != null)
      {
        paramServer = localEntry.getContact(paramServer.toString());
        return paramServer;
      }
      throw new RemoteException("no service for getLicenseDetail call");
    }
    catch (Throwable paramServer)
    {
      throw paramServer;
    }
  }
  
  protected final boolean enableLocalFallback()
  {
    return true;
  }
  
  public final String getMessage(String paramString)
    throws RemoteException
  {
    try
    {
      Entry localEntry = get();
      if (localEntry != null)
      {
        paramString = localEntry.getValue(paramString);
        return paramString;
      }
      throw new RemoteException("no service for getListLayoutPackage call");
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public final int getMinApkVersion()
  {
    return 12600000;
  }
  
  protected final String getServiceDescriptor()
  {
    return "com.google.android.gms.oss.licenses.IOSSLicenseService";
  }
  
  protected final String getStartServiceAction()
  {
    return "com.google.android.gms.oss.licenses.service.START";
  }
  
  public final String toString(String paramString)
    throws RemoteException
  {
    try
    {
      Entry localEntry = get();
      if (localEntry != null)
      {
        paramString = localEntry.getName(paramString);
        return paramString;
      }
      throw new RemoteException("no service for getLicenseLayoutPackage call");
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
}
