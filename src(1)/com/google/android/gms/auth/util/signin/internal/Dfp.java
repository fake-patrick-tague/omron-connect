package com.google.android.gms.auth.util.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.internal.zbs;
import com.google.android.gms.auth.util.signin.GoogleSignInOptions;
import com.google.android.gms.auth.util.signin.GoogleSignInOptions.Builder;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.package_12.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.package_12.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.package_12.Scope;
import com.google.android.gms.internal.auth-api.zbax;
import java.util.Iterator;
import java.util.Set;

public final class Dfp
  extends GmsClient<zbs>
{
  private final GoogleSignInOptions zero;
  
  public Dfp(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, GoogleSignInOptions paramGoogleSignInOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 91, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
    if (paramGoogleSignInOptions != null) {
      paramContext = new GoogleSignInOptions.Builder(paramGoogleSignInOptions);
    } else {
      paramContext = new GoogleSignInOptions.Builder();
    }
    paramContext.setLogSessionId(zbax.encrypt());
    if (!paramClientSettings.getAllRequestedScopes().isEmpty())
    {
      paramLooper = paramClientSettings.getAllRequestedScopes().iterator();
      while (paramLooper.hasNext()) {
        paramContext.requestScopes((Scope)paramLooper.next(), new Scope[0]);
      }
    }
    zero = paramContext.build();
  }
  
  public final int getMinApkVersion()
  {
    return 12451000;
  }
  
  protected final String getServiceDescriptor()
  {
    return "com.google.android.gms.auth.api.signin.internal.ISignInService";
  }
  
  public final Intent getSignInIntent()
  {
    return DefaultServiceManager.init(getContext(), zero);
  }
  
  protected final String getStartServiceAction()
  {
    return "com.google.android.gms.auth.api.signin.service.START";
  }
  
  public final GoogleSignInOptions getZero()
  {
    return zero;
  }
  
  public final boolean providesSignIn()
  {
    return true;
  }
}
