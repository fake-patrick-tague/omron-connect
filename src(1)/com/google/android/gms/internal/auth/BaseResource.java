package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.auth.account.WorkAccount;
import com.google.android.gms.auth.account.WorkAccountApi;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.PendingResult;
import com.google.android.gms.common.package_12.Status;

public final class BaseResource
  implements WorkAccountApi
{
  private static final Status zzad = new Status(13);
  
  public BaseResource() {}
  
  public final PendingResult addWorkAccount(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.execute(new InternalHttpClient(this, WorkAccount.IOERR, paramGoogleApiClient, paramString));
  }
  
  public final PendingResult removeWorkAccount(GoogleApiClient paramGoogleApiClient, Account paramAccount)
  {
    return paramGoogleApiClient.execute(new AbstractHttpClient(this, WorkAccount.IOERR, paramGoogleApiClient, paramAccount));
  }
  
  public final void setWorkAuthenticatorEnabled(GoogleApiClient paramGoogleApiClient, boolean paramBoolean)
  {
    setWorkAuthenticatorEnabledWithResult(paramGoogleApiClient, paramBoolean);
  }
  
  public final PendingResult setWorkAuthenticatorEnabledWithResult(GoogleApiClient paramGoogleApiClient, boolean paramBoolean)
  {
    return paramGoogleApiClient.execute(new MinimalHttpClient(this, WorkAccount.IOERR, paramGoogleApiClient, paramBoolean));
  }
}
