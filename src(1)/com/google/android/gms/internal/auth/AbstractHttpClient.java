package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.common.package_12.Attribute;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.Status;

final class AbstractHttpClient
  extends com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl<com.google.android.gms.common.api.Result, zzr>
{
  AbstractHttpClient(BaseResource paramBaseResource, Attribute paramAttribute, GoogleApiClient paramGoogleApiClient, Account paramAccount)
  {
    super(paramAttribute, paramGoogleApiClient);
  }
  
  protected final com.google.android.gms.common.package_12.Result createFailedResult(Status paramStatus)
  {
    return new Contact(paramStatus);
  }
}
