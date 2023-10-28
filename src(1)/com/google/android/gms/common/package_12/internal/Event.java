package com.google.android.gms.common.package_12.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.GoogleApiClient.OnConnectionFailedListener;

final class Event
  implements GoogleApiClient.OnConnectionFailedListener
{
  public final GoogleApiClient.OnConnectionFailedListener code;
  public final int err;
  public final GoogleApiClient name;
  
  public Event(MainActivity paramMainActivity, int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    err = paramInt;
    name = paramGoogleApiClient;
    code = paramOnConnectionFailedListener;
  }
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    String str = String.valueOf(paramConnectionResult);
    str.length();
    Log.d("AutoManageHelper", "beginFailureResolution for ".concat(str));
    this$0.onError(paramConnectionResult, err);
  }
}
