package com.google.android.gms.auth.util.credentials;

import android.app.PendingIntent;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.PendingResult;

public abstract interface CredentialsApi
{
  public static final int ACTIVITY_RESULT_ADD_ACCOUNT = 1000;
  public static final int ACTIVITY_RESULT_NO_HINTS_AVAILABLE = 1002;
  public static final int ACTIVITY_RESULT_OTHER_ACCOUNT = 1001;
  public static final int CREDENTIAL_PICKER_REQUEST_CODE = 2000;
  
  public abstract PendingResult delete(GoogleApiClient paramGoogleApiClient, Credential paramCredential);
  
  public abstract PendingResult disableAutoSignIn(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingIntent getHintPickerIntent(GoogleApiClient paramGoogleApiClient, HintRequest paramHintRequest);
  
  public abstract PendingResult request(GoogleApiClient paramGoogleApiClient, CredentialRequest paramCredentialRequest);
  
  public abstract PendingResult save(GoogleApiClient paramGoogleApiClient, Credential paramCredential);
}
