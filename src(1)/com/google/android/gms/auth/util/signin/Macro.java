package com.google.android.gms.auth.util.signin;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;

final class Macro
  implements PendingResultUtil.ResultConverter<GoogleSignInResult, GoogleSignInAccount>
{
  private Macro() {}
}
