package com.google.android.gms.auth.util.signin.internal;

import android.content.Intent;
import com.google.android.gms.auth.util.Auth;
import com.google.android.gms.auth.util.signin.GoogleSignInApi;
import com.google.android.gms.auth.util.signin.GoogleSignInOptions;
import com.google.android.gms.auth.util.signin.GoogleSignInResult;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.OptionalPendingResult;
import com.google.android.gms.common.package_12.PendingResult;

public final class Function
  implements GoogleSignInApi
{
  public Function() {}
  
  private static final GoogleSignInOptions multiply(GoogleApiClient paramGoogleApiClient)
  {
    return ((Dfp)paramGoogleApiClient.getClient(Auth.MULT)).getZero();
  }
  
  public final Intent getSignInIntent(GoogleApiClient paramGoogleApiClient)
  {
    return DefaultServiceManager.init(paramGoogleApiClient.getContext(), multiply(paramGoogleApiClient));
  }
  
  public final GoogleSignInResult getSignInResultFromIntent(Intent paramIntent)
  {
    return DefaultServiceManager.infoFromShortcutIntent(paramIntent);
  }
  
  public final PendingResult revokeAccess(GoogleApiClient paramGoogleApiClient)
  {
    return DefaultServiceManager.execute(paramGoogleApiClient, paramGoogleApiClient.getContext(), false);
  }
  
  public final PendingResult signOut(GoogleApiClient paramGoogleApiClient)
  {
    return DefaultServiceManager.get(paramGoogleApiClient, paramGoogleApiClient.getContext(), false);
  }
  
  public final OptionalPendingResult silentSignIn(GoogleApiClient paramGoogleApiClient)
  {
    return DefaultServiceManager.create(paramGoogleApiClient, paramGoogleApiClient.getContext(), multiply(paramGoogleApiClient), false);
  }
}
