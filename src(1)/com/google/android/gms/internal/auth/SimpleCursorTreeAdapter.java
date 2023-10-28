package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.auth.util.accounttransfer.News;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.package_12.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.package_12.GoogleApiClient.OnConnectionFailedListener;

public final class SimpleCursorTreeAdapter
  extends GmsClient<zzz>
{
  private final Bundle zzbv;
  
  public SimpleCursorTreeAdapter(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, News paramNews, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 128, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
    if (paramNews == null)
    {
      zzbv = new Bundle();
      return;
    }
    throw new NoSuchMethodError();
  }
  
  protected final Bundle getGetServiceRequestExtraArgs()
  {
    return zzbv;
  }
  
  public final int getMinApkVersion()
  {
    return 12451000;
  }
  
  protected final String getServiceDescriptor()
  {
    return "com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferService";
  }
  
  protected final String getStartServiceAction()
  {
    return "com.google.android.gms.auth.api.accounttransfer.service.START";
  }
}
