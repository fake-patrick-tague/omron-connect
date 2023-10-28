package com.google.android.gms.auth.util.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.auth.api.signin.internal.zbl;
import com.google.android.gms.auth.util.signin.GoogleSignInOptions;
import com.google.android.gms.common.package_12.GoogleApiClient;

final class InternalHttpClient
  extends zbl<GoogleSignInResult>
{
  InternalHttpClient(GoogleApiClient paramGoogleApiClient, Context paramContext, GoogleSignInOptions paramGoogleSignInOptions)
  {
    super(paramGoogleApiClient);
  }
}
