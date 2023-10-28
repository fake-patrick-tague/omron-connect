package com.google.android.gms.auth.util.credentials;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.auth.util.Auth;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.package_12.internal.ApiExceptionMapper;
import com.google.android.gms.internal.auth-api.INotificationManager;
import com.google.android.gms.tasks.Task;

public class CredentialsClient
  extends com.google.android.gms.common.api.GoogleApi<com.google.android.gms.auth.api.Auth.AuthCredentialsOptions>
{
  CredentialsClient(Activity paramActivity, com.google.android.gms.auth.util.Auth.AuthCredentialsOptions paramAuthCredentialsOptions)
  {
    super(paramActivity, Auth.CREDENTIALS_API, paramAuthCredentialsOptions, new ApiExceptionMapper());
  }
  
  CredentialsClient(Context paramContext, com.google.android.gms.auth.util.Auth.AuthCredentialsOptions paramAuthCredentialsOptions)
  {
    super(paramContext, Auth.CREDENTIALS_API, paramAuthCredentialsOptions, new ApiExceptionMapper());
  }
  
  public Task delete(Credential paramCredential)
  {
    return PendingResultUtil.toVoidTask(Auth.CredentialsApi.delete(asGoogleApiClient(), paramCredential));
  }
  
  public Task disableAutoSignIn()
  {
    return PendingResultUtil.toVoidTask(Auth.CredentialsApi.disableAutoSignIn(asGoogleApiClient()));
  }
  
  public PendingIntent getHintPickerIntent(HintRequest paramHintRequest)
  {
    return INotificationManager.notify(getApplicationContext(), (com.google.android.gms.auth.util.Auth.AuthCredentialsOptions)getApiOptions(), paramHintRequest, ((com.google.android.gms.auth.util.Auth.AuthCredentialsOptions)getApiOptions()).json());
  }
  
  public Task request(CredentialRequest paramCredentialRequest)
  {
    return PendingResultUtil.toResponseTask(Auth.CredentialsApi.request(asGoogleApiClient(), paramCredentialRequest), new CredentialRequestResponse());
  }
  
  public Task save(Credential paramCredential)
  {
    return PendingResultUtil.toVoidTask(Auth.CredentialsApi.save(asGoogleApiClient(), paramCredential));
  }
}
