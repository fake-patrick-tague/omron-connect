package com.google.android.gms.auth.util.credentials;

import com.google.android.gms.common.package_12.Result;

public abstract interface CredentialRequestResult
  extends Result
{
  public abstract Credential getCredential();
}
