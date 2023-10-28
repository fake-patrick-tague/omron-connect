package com.google.android.gms.internal.auth-api;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.identity.CredentialSavingClient;
import com.google.android.gms.auth.api.identity.zbc;
import com.google.android.gms.auth.util.identity.DBObject;
import com.google.android.gms.auth.util.identity.SaveAccountLinkingTokenRequest;
import com.google.android.gms.auth.util.identity.SaveAccountLinkingTokenRequest.Builder;
import com.google.android.gms.auth.util.identity.SavePasswordRequest;
import com.google.android.gms.auth.util.identity.SavePasswordRequest.Builder;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.package_12.Attribute;
import com.google.android.gms.common.package_12.GoogleApi.Settings;
import com.google.android.gms.common.package_12.internal.TaskApiCall;
import com.google.android.gms.common.package_12.internal.TaskApiCall.Builder;
import com.google.android.gms.tasks.Task;

public final class zbam
  extends com.google.android.gms.common.api.GoogleApi<zbc>
  implements CredentialSavingClient
{
  private static final com.google.android.gms.common.api.Api.ClientKey<zbw> DSB;
  private static final Api<zbc> S;
  private static final Api.AbstractClientBuilder<zbw, zbc> SE;
  private final String property = zbax.encrypt();
  
  static
  {
    com.google.android.gms.common.package_12.Api.ClientKey localClientKey = new com.google.android.gms.common.package_12.Api.ClientKey();
    DSB = localClientKey;
    zbaj localZbaj = new zbaj();
    SE = localZbaj;
    S = new Attribute("Auth.Api.Identity.CredentialSaving.API", localZbaj, localClientKey);
  }
  
  public zbam(Activity paramActivity, DBObject paramDBObject)
  {
    super(paramActivity, S, paramDBObject, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  public zbam(Context paramContext, DBObject paramDBObject)
  {
    super(paramContext, S, paramDBObject, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  public final Task saveAccountLinkingToken(SaveAccountLinkingTokenRequest paramSaveAccountLinkingTokenRequest)
  {
    paramSaveAccountLinkingTokenRequest = SaveAccountLinkingTokenRequest.where(paramSaveAccountLinkingTokenRequest);
    paramSaveAccountLinkingTokenRequest.add(property);
    paramSaveAccountLinkingTokenRequest = paramSaveAccountLinkingTokenRequest.build();
    return doRead(TaskApiCall.builder().setFeatures(new Feature[] { zbaw.macro }).bssid(new zbah(this, paramSaveAccountLinkingTokenRequest)).setAutoResolveMissingFeatures(false).setMethodKey(1535).build());
  }
  
  public final Task savePassword(SavePasswordRequest paramSavePasswordRequest)
  {
    paramSavePasswordRequest = SavePasswordRequest.put(paramSavePasswordRequest);
    paramSavePasswordRequest.put(property);
    paramSavePasswordRequest = paramSavePasswordRequest.build();
    return doRead(TaskApiCall.builder().setFeatures(new Feature[] { zbaw.MISMATCH }).bssid(new zbai(this, paramSavePasswordRequest)).setAutoResolveMissingFeatures(false).setMethodKey(1536).build());
  }
}
