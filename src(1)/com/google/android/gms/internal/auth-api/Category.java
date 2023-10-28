package com.google.android.gms.internal.auth-api;

import com.google.android.gms.auth.util.credentials.Credential;
import com.google.android.gms.auth.util.credentials.CredentialRequestResult;
import com.google.android.gms.common.package_12.Status;

public final class Category
  implements CredentialRequestResult
{
  private final Credential parent;
  private final Status status;
  
  public Category(Status paramStatus, Credential paramCredential)
  {
    status = paramStatus;
    parent = paramCredential;
  }
  
  public final Credential getCredential()
  {
    return parent;
  }
  
  public final Status getStatus()
  {
    return status;
  }
}
