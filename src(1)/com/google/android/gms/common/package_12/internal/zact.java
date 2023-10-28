package com.google.android.gms.common.package_12.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.Api.Client;
import com.google.android.gms.common.package_12.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.package_12.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.signin.Connection;
import com.google.android.gms.signin.R.id;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.NavigationMenuPresenter;
import com.google.android.gms.signin.internal.TransportInformation;
import com.google.android.gms.signin.zae;
import java.util.Set;

public final class zact
  extends NavigationMenuPresenter
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  private static final com.google.android.gms.common.api.Api.AbstractClientBuilder<? extends zae, SignInOptions> EMPTY_ARRAY = R.id.security;
  private zacs builder;
  private final ClientSettings forward;
  private final Handler h;
  private final Context i;
  private final com.google.android.gms.common.api.Api.AbstractClientBuilder<? extends zae, SignInOptions> results;
  private final Set<Scope> state;
  private Connection this$0;
  
  public zact(Context paramContext, Handler paramHandler, ClientSettings paramClientSettings)
  {
    i = paramContext;
    h = paramHandler;
    forward = ((ClientSettings)Preconditions.checkNotNull(paramClientSettings, "ClientSettings must not be null"));
    state = paramClientSettings.getRequiredScopes();
    results = localAbstractClientBuilder;
  }
  
  public final void e(TransportInformation paramTransportInformation)
  {
    h.post(new zacr(this, paramTransportInformation));
  }
  
  public final void init(zacs paramZacs)
  {
    Object localObject = this$0;
    if (localObject != null) {
      ((Api.Client)localObject).disconnect();
    }
    forward.set(Integer.valueOf(System.identityHashCode(this)));
    localObject = results;
    Context localContext = i;
    Looper localLooper = h.getLooper();
    ClientSettings localClientSettings = forward;
    this$0 = ((Connection)((com.google.android.gms.common.package_12.Api.AbstractClientBuilder)localObject).buildClient(localContext, localLooper, localClientSettings, localClientSettings.entrySet(), this, this));
    builder = paramZacs;
    paramZacs = state;
    if ((paramZacs != null) && (!paramZacs.isEmpty()))
    {
      this$0.connect();
      return;
    }
    h.post(new zacq(this));
  }
  
  public final void onConnected(Bundle paramBundle)
  {
    this$0.add(this);
  }
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    builder.append(paramConnectionResult);
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    this$0.disconnect();
  }
  
  public final void onStringAvailable()
  {
    Connection localConnection = this$0;
    if (localConnection != null) {
      localConnection.disconnect();
    }
  }
}
