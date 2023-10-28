package com.google.android.gms.auth.util.accounttransfer;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface AuthenticatorTransferCompletionStatus
{
  public static final int COMPLETED_FAILURE = 2;
  public static final int COMPLETED_SUCCESS = 1;
}
