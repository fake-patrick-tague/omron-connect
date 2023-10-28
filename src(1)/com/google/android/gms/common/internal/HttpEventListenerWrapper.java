package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.package_12.internal.OnConnectionFailedListener;

final class HttpEventListenerWrapper
  implements BaseGmsClient.BaseOnConnectionFailedListener
{
  HttpEventListenerWrapper(OnConnectionFailedListener paramOnConnectionFailedListener) {}
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    _listener.onConnectionFailed(paramConnectionResult);
  }
}
