package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.BaseBundle;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.util.signin.GoogleSignInAccount;
import com.google.android.gms.auth.util.signin.internal.Storage;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BaseGmsClient.LegacyClientCallbackAdapter;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Message;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.package_12.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.signin.zae;

@KeepForSdk
public class SignInClientImpl
  extends GmsClient<zaf>
  implements zae
{
  private final ClientSettings data;
  private final Integer key;
  private final boolean persistent = true;
  private final Bundle storage;
  
  public SignInClientImpl(Context paramContext, Looper paramLooper, boolean paramBoolean, ClientSettings paramClientSettings, Bundle paramBundle, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 44, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
    data = paramClientSettings;
    storage = paramBundle;
    key = paramClientSettings.val();
  }
  
  public static Bundle createBundleFromClientSettings(ClientSettings paramClientSettings)
  {
    paramClientSettings.entrySet();
    Integer localInteger = paramClientSettings.val();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", paramClientSettings.getAccount());
    if (localInteger != null) {
      localBundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", localInteger.intValue());
    }
    localBundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
    localBundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
    localBundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
    localBundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
    localBundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
    localBundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
    localBundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
    localBundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
    return localBundle;
  }
  
  public final void add()
  {
    try
    {
      Object localObject1 = getService();
      localObject1 = (BitSet)localObject1;
      Object localObject2 = key;
      localObject2 = Preconditions.checkNotNull(localObject2);
      localObject2 = (Integer)localObject2;
      ((BitSet)localObject1).remove(((Integer)localObject2).intValue());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
    Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
  }
  
  public final void add(IAccountAccessor paramIAccountAccessor, boolean paramBoolean)
  {
    try
    {
      Object localObject1 = getService();
      localObject1 = (BitSet)localObject1;
      Object localObject2 = key;
      localObject2 = Preconditions.checkNotNull(localObject2);
      localObject2 = (Integer)localObject2;
      ((BitSet)localObject1).remove(paramIAccountAccessor, ((Integer)localObject2).intValue(), paramBoolean);
      return;
    }
    catch (RemoteException paramIAccountAccessor)
    {
      for (;;) {}
    }
    Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
  }
  
  public final void add(Logger paramLogger)
  {
    Preconditions.checkNotNull(paramLogger, "Expecting a valid ISignInCallbacks");
    Object localObject1 = data;
    try
    {
      Object localObject2 = ((ClientSettings)localObject1).getAccountOrDefault();
      localObject1 = name;
      boolean bool = "<<default account>>".equals(localObject1);
      if (bool) {
        localObject1 = Storage.getInstance(getContext()).getSavedDefaultGoogleSignInAccount();
      } else {
        localObject1 = null;
      }
      Object localObject3 = key;
      localObject3 = Preconditions.checkNotNull(localObject3);
      localObject3 = (Integer)localObject3;
      localObject1 = new Message((Account)localObject2, ((Integer)localObject3).intValue(), (GoogleSignInAccount)localObject1);
      localObject2 = getService();
      localObject2 = (BitSet)localObject2;
      ((BitSet)localObject2).add(new Entry(1, (Message)localObject1), paramLogger);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
    }
    try
    {
      paramLogger.e(new TransportInformation(1, new ConnectionResult(8, null), null));
      return;
    }
    catch (RemoteException paramLogger)
    {
      for (;;) {}
    }
    Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", localRemoteException);
  }
  
  public final void connect()
  {
    connect(new BaseGmsClient.LegacyClientCallbackAdapter(this));
  }
  
  protected final Bundle getGetServiceRequestExtraArgs()
  {
    String str = data.getRealClientPackageName();
    if (!getContext().getPackageName().equals(str)) {
      storage.putString("com.google.android.gms.signin.internal.realClientPackageName", data.getRealClientPackageName());
    }
    return storage;
  }
  
  public final int getMinApkVersion()
  {
    return 12451000;
  }
  
  protected final String getServiceDescriptor()
  {
    return "com.google.android.gms.signin.internal.ISignInService";
  }
  
  protected final String getStartServiceAction()
  {
    return "com.google.android.gms.signin.service.START";
  }
  
  public final boolean requiresSignIn()
  {
    return persistent;
  }
}
