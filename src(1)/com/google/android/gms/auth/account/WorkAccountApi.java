package com.google.android.gms.auth.account;

import android.accounts.Account;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.PendingResult;
import com.google.android.gms.common.package_12.Result;

@Deprecated
public abstract interface WorkAccountApi
{
  public abstract PendingResult addWorkAccount(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult removeWorkAccount(GoogleApiClient paramGoogleApiClient, Account paramAccount);
  
  public abstract void setWorkAuthenticatorEnabled(GoogleApiClient paramGoogleApiClient, boolean paramBoolean);
  
  public abstract PendingResult setWorkAuthenticatorEnabledWithResult(GoogleApiClient paramGoogleApiClient, boolean paramBoolean);
  
  @Deprecated
  public static abstract interface AddAccountResult
    extends Result
  {
    public abstract Account getAccount();
  }
}
