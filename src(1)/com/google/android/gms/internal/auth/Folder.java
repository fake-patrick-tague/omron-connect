package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.auth.account.WorkAccountApi.AddAccountResult;
import com.google.android.gms.common.package_12.Status;

final class Folder
  implements WorkAccountApi.AddAccountResult
{
  private final Account mAccount;
  private final Status mStatus;
  
  public Folder(Status paramStatus, Account paramAccount)
  {
    mStatus = paramStatus;
    mAccount = paramAccount;
  }
  
  public final Account getAccount()
  {
    return mAccount;
  }
  
  public final Status getStatus()
  {
    return mStatus;
  }
}
