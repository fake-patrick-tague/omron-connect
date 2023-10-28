package com.google.android.gms.internal.auth-api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.zbl;
import com.google.android.gms.auth.util.identity.BeginSignInRequest;
import com.google.android.gms.auth.util.identity.BeginSignInRequest.Builder;
import com.google.android.gms.auth.util.identity.GetSignInIntentRequest;
import com.google.android.gms.auth.util.identity.GetSignInIntentRequest.Builder;
import com.google.android.gms.auth.util.identity.SignInCredential;
import com.google.android.gms.auth.util.identity.Topic;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.package_12.ApiException;
import com.google.android.gms.common.package_12.Attribute;
import com.google.android.gms.common.package_12.GoogleApi.Settings;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.common.package_12.internal.GoogleApiManager;
import com.google.android.gms.common.package_12.internal.TaskApiCall;
import com.google.android.gms.common.package_12.internal.TaskApiCall.Builder;
import com.google.android.gms.tasks.Task;
import java.util.Iterator;
import java.util.Set;

public final class zbau
  extends com.google.android.gms.common.api.GoogleApi<zbl>
  implements SignInClient
{
  private static final com.google.android.gms.common.api.Api.ClientKey<zbav> DSB;
  private static final Api<zbl> S;
  private static final Api.AbstractClientBuilder<zbav, zbl> SE;
  private final String site = zbax.encrypt();
  
  static
  {
    com.google.android.gms.common.package_12.Api.ClientKey localClientKey = new com.google.android.gms.common.package_12.Api.ClientKey();
    DSB = localClientKey;
    zbaq localZbaq = new zbaq();
    SE = localZbaq;
    S = new Attribute("Auth.Api.Identity.SignIn.API", localZbaq, localClientKey);
  }
  
  public zbau(Activity paramActivity, Topic paramTopic)
  {
    super(paramActivity, S, paramTopic, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  public zbau(Context paramContext, Topic paramTopic)
  {
    super(paramContext, S, paramTopic, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  public final Task beginSignIn(BeginSignInRequest paramBeginSignInRequest)
  {
    paramBeginSignInRequest = BeginSignInRequest.where(paramBeginSignInRequest);
    paramBeginSignInRequest.put(site);
    paramBeginSignInRequest = paramBeginSignInRequest.build();
    return doRead(TaskApiCall.builder().setFeatures(new Feature[] { zbaw.SATURATION }).bssid(new zbao(this, paramBeginSignInRequest)).setAutoResolveMissingFeatures(false).setMethodKey(1553).build());
  }
  
  public final SignInCredential getSignInCredentialFromIntent(Intent paramIntent)
    throws ApiException
  {
    if (paramIntent != null)
    {
      Status localStatus = (Status)SafeParcelableSerializer.deserializeFromIntentExtra(paramIntent, "status", Status.CREATOR);
      if (localStatus != null)
      {
        if (localStatus.isSuccess())
        {
          paramIntent = (SignInCredential)SafeParcelableSerializer.deserializeFromIntentExtra(paramIntent, "sign_in_credential", SignInCredential.CREATOR);
          if (paramIntent != null) {
            return paramIntent;
          }
          throw new ApiException(Status.RESULT_INTERNAL_ERROR);
        }
        throw new ApiException(localStatus);
      }
      throw new ApiException(Status.RESULT_CANCELED);
    }
    throw new ApiException(Status.RESULT_INTERNAL_ERROR);
  }
  
  public final Task getSignInIntent(GetSignInIntentRequest paramGetSignInIntentRequest)
  {
    paramGetSignInIntentRequest = GetSignInIntentRequest.where(paramGetSignInIntentRequest);
    paramGetSignInIntentRequest.put(site);
    paramGetSignInIntentRequest = paramGetSignInIntentRequest.build();
    return doRead(TaskApiCall.builder().setFeatures(new Feature[] { zbaw.OUT_OF_MEMORY }).bssid(new zbap(this, paramGetSignInIntentRequest)).setMethodKey(1555).build());
  }
  
  public final Task signOut()
  {
    getApplicationContext().getSharedPreferences("com.google.android.gms.signin", 0).edit().clear().apply();
    Iterator localIterator = GoogleApiClient.getAllClients().iterator();
    while (localIterator.hasNext()) {
      ((GoogleApiClient)localIterator.next()).maybeSignOut();
    }
    GoogleApiManager.reportSignOut();
    return doRead(TaskApiCall.builder().setFeatures(new Feature[] { zbaw.SCHEMA }).bssid(new zban(this)).setAutoResolveMissingFeatures(false).setMethodKey(1554).build());
  }
}
