package com.google.android.gms.auth.util.signin;

import com.google.android.gms.common.package_12.Result;
import com.google.android.gms.common.package_12.Status;

public class GoogleSignInResult
  implements Result
{
  private GoogleSignInAccount percent;
  private Status status;
  
  public GoogleSignInResult(GoogleSignInAccount paramGoogleSignInAccount, Status paramStatus)
  {
    percent = paramGoogleSignInAccount;
    status = paramStatus;
  }
  
  public GoogleSignInAccount getSignInAccount()
  {
    return percent;
  }
  
  public Status getStatus()
  {
    return status;
  }
  
  public boolean isSuccess()
  {
    return status.isSuccess();
  }
}
