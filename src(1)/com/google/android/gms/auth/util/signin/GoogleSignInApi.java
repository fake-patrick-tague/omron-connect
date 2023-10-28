package com.google.android.gms.auth.util.signin;

import android.content.Intent;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.OptionalPendingResult;
import com.google.android.gms.common.package_12.PendingResult;

public abstract interface GoogleSignInApi
{
  @RecentlyNonNull
  public static final String EXTRA_SIGN_IN_ACCOUNT = "signInAccount";
  
  public abstract Intent getSignInIntent(GoogleApiClient paramGoogleApiClient);
  
  public abstract GoogleSignInResult getSignInResultFromIntent(Intent paramIntent);
  
  public abstract PendingResult revokeAccess(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult signOut(GoogleApiClient paramGoogleApiClient);
  
  public abstract OptionalPendingResult silentSignIn(GoogleApiClient paramGoogleApiClient);
}
