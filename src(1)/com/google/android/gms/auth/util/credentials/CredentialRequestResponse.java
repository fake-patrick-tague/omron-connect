package com.google.android.gms.auth.util.credentials;

public class CredentialRequestResponse
  extends com.google.android.gms.common.api.Response<com.google.android.gms.auth.api.credentials.CredentialRequestResult>
{
  public CredentialRequestResponse() {}
  
  public Credential getCredential()
  {
    return ((CredentialRequestResult)getResult()).getCredential();
  }
}
