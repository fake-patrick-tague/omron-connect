package com.google.android.gms.internal.auth-api;

import android.app.PendingIntent;
import com.google.android.gms.auth.util.Auth;
import com.google.android.gms.auth.util.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.util.credentials.Credential;
import com.google.android.gms.auth.util.credentials.CredentialRequest;
import com.google.android.gms.auth.util.credentials.CredentialsApi;
import com.google.android.gms.auth.util.credentials.HintRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.PendingResult;

public final class HttpConnection
  implements CredentialsApi
{
  public HttpConnection() {}
  
  public final PendingResult delete(GoogleApiClient paramGoogleApiClient, Credential paramCredential)
  {
    Preconditions.checkNotNull(paramGoogleApiClient, "client must not be null");
    Preconditions.checkNotNull(paramCredential, "credential must not be null");
    return paramGoogleApiClient.execute(new ImageLoader.Task(this, paramGoogleApiClient, paramCredential));
  }
  
  public final PendingResult disableAutoSignIn(GoogleApiClient paramGoogleApiClient)
  {
    Preconditions.checkNotNull(paramGoogleApiClient, "client must not be null");
    return paramGoogleApiClient.execute(new SyncOperation(this, paramGoogleApiClient));
  }
  
  public final PendingIntent getHintPickerIntent(GoogleApiClient paramGoogleApiClient, HintRequest paramHintRequest)
  {
    Preconditions.checkNotNull(paramGoogleApiClient, "client must not be null");
    Preconditions.checkNotNull(paramHintRequest, "request must not be null");
    Auth.AuthCredentialsOptions localAuthCredentialsOptions = ((Configurable)paramGoogleApiClient.getClient(Auth.MINUS)).getDateFormat();
    return INotificationManager.notify(paramGoogleApiClient.getContext(), localAuthCredentialsOptions, paramHintRequest, localAuthCredentialsOptions.json());
  }
  
  public final PendingResult request(GoogleApiClient paramGoogleApiClient, CredentialRequest paramCredentialRequest)
  {
    Preconditions.checkNotNull(paramGoogleApiClient, "client must not be null");
    Preconditions.checkNotNull(paramCredentialRequest, "request must not be null");
    return paramGoogleApiClient.enqueue(new OkHttpCall(this, paramGoogleApiClient, paramCredentialRequest));
  }
  
  public final PendingResult save(GoogleApiClient paramGoogleApiClient, Credential paramCredential)
  {
    Preconditions.checkNotNull(paramGoogleApiClient, "client must not be null");
    Preconditions.checkNotNull(paramCredential, "credential must not be null");
    return paramGoogleApiClient.execute(new History(this, paramGoogleApiClient, paramCredential));
  }
}
