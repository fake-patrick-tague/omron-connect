package com.google.android.gms.common.package_12.internal;

import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.package_12.Api.Client;
import java.util.Map;
import java.util.Set;

final class zabu
  implements BaseGmsClient.ConnectionProgressReportCallbacks, zacs
{
  private boolean hasCamera = false;
  private final Api.Client mCamera;
  private IAccountAccessor mContext = null;
  private final com.google.android.gms.common.api.internal.ApiKey<?> mHandler;
  private Set<Scope> mSettings = null;
  
  public zabu(GoogleApiManager paramGoogleApiManager, Api.Client paramClient, ApiKey paramApiKey)
  {
    mCamera = paramClient;
    mHandler = paramApiKey;
  }
  
  private final void sendSms()
  {
    if (hasCamera)
    {
      IAccountAccessor localIAccountAccessor = mContext;
      if (localIAccountAccessor != null) {
        mCamera.getRemoteService(localIAccountAccessor, mSettings);
      }
    }
  }
  
  public final void append(ConnectionResult paramConnectionResult)
  {
    zabq localZabq = (zabq)GoogleApiManager.get(this$0).get(mHandler);
    if (localZabq != null) {
      localZabq.put(paramConnectionResult);
    }
  }
  
  public final void execute(IAccountAccessor paramIAccountAccessor, Set paramSet)
  {
    if ((paramIAccountAccessor != null) && (paramSet != null))
    {
      mContext = paramIAccountAccessor;
      mSettings = paramSet;
      sendSms();
      return;
    }
    Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
    append(new ConnectionResult(4));
  }
  
  public final void onReportServiceBinding(ConnectionResult paramConnectionResult)
  {
    GoogleApiManager.getInstance(this$0).post(new zabt(this, paramConnectionResult));
  }
}
