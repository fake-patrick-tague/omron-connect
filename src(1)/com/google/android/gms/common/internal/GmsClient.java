package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.package_12.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.package_12.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.package_12.internal.ConnectionCallbacks;
import com.google.android.gms.common.package_12.internal.OnConnectionFailedListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

@KeepForSdk
public abstract class GmsClient<T extends IInterface>
  extends BaseGmsClient<T>
  implements Api.Client, zaj
{
  private static volatile Executor DEFAULT_EXECUTOR;
  private final Account account;
  private final ClientSettings identity;
  private final Set<com.google.android.gms.common.api.Scope> scopes;
  
  protected GmsClient(Context paramContext, Handler paramHandler, int paramInt, ClientSettings paramClientSettings)
  {
    super(paramContext, paramHandler, GmsClientSupervisor.getInstance(paramContext), GoogleApiAvailability.getInstance(), paramInt, null, null);
    identity = ((ClientSettings)Preconditions.checkNotNull(paramClientSettings));
    account = paramClientSettings.getAccount();
    scopes = create(paramClientSettings.getAllRequestedScopes());
  }
  
  protected GmsClient(Context paramContext, Looper paramLooper, int paramInt, ClientSettings paramClientSettings)
  {
    this(paramContext, paramLooper, GmsClientSupervisor.getInstance(paramContext), GoogleApiAvailability.getInstance(), paramInt, paramClientSettings, null, null);
  }
  
  protected GmsClient(Context paramContext, Looper paramLooper, int paramInt, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext, paramLooper, paramInt, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  protected GmsClient(Context paramContext, Looper paramLooper, int paramInt, ClientSettings paramClientSettings, ConnectionCallbacks paramConnectionCallbacks, OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext, paramLooper, GmsClientSupervisor.getInstance(paramContext), GoogleApiAvailability.getInstance(), paramInt, paramClientSettings, (ConnectionCallbacks)Preconditions.checkNotNull(paramConnectionCallbacks), (OnConnectionFailedListener)Preconditions.checkNotNull(paramOnConnectionFailedListener));
  }
  
  protected GmsClient(Context paramContext, Looper paramLooper, GmsClientSupervisor paramGmsClientSupervisor, GoogleApiAvailability paramGoogleApiAvailability, int paramInt, ClientSettings paramClientSettings, ConnectionCallbacks paramConnectionCallbacks, OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, paramGmsClientSupervisor, paramGoogleApiAvailability, paramInt, paramConnectionCallbacks, paramOnConnectionFailedListener, paramClientSettings.getFullName());
    identity = paramClientSettings;
    account = paramClientSettings.getAccount();
    scopes = create(paramClientSettings.getAllRequestedScopes());
  }
  
  private final Set create(Set paramSet)
  {
    Set localSet = validateScopes(paramSet);
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext()) {
      if (!paramSet.contains((com.google.android.gms.common.package_12.Scope)localIterator.next())) {
        throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
      }
    }
    return localSet;
  }
  
  public final Account getAccount()
  {
    return account;
  }
  
  protected final Executor getBindServiceExecutor()
  {
    return null;
  }
  
  protected final ClientSettings getClientSettings()
  {
    return identity;
  }
  
  public Feature[] getRequiredFeatures()
  {
    return new Feature[0];
  }
  
  protected final Set getScopes()
  {
    return scopes;
  }
  
  public Set getScopesForConnectionlessNonSignIn()
  {
    if (requiresSignIn()) {
      return scopes;
    }
    return Collections.emptySet();
  }
  
  protected Set validateScopes(Set paramSet)
  {
    return paramSet;
  }
}
