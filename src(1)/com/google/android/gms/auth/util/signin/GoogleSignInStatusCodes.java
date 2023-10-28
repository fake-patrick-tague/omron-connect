package com.google.android.gms.auth.util.signin;

import com.google.android.gms.common.package_12.CommonStatusCodes;

public final class GoogleSignInStatusCodes
  extends CommonStatusCodes
{
  public static final int SIGN_IN_CANCELLED = 12501;
  public static final int SIGN_IN_CURRENTLY_IN_PROGRESS = 12502;
  public static final int SIGN_IN_FAILED = 12500;
  
  private GoogleSignInStatusCodes() {}
  
  public static String getStatusCodeString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return CommonStatusCodes.getStatusCodeString(paramInt);
    case 12502: 
      return "Sign-in in progress";
    case 12501: 
      return "Sign in action cancelled";
    }
    return "A non-recoverable sign in failure occurred";
  }
}
