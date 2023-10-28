package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.package_12.GoogleApi.Settings;
import com.google.android.gms.internal.auth.BaseResource;
import com.google.android.gms.tasks.Task;

public class WorkAccountClient
  extends com.google.android.gms.common.api.GoogleApi<Api.ApiOptions.NoOptions>
{
  private final WorkAccountApi zzac = new BaseResource();
  
  WorkAccountClient(Activity paramActivity)
  {
    super(paramActivity, WorkAccount.IOERR, null, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  WorkAccountClient(Context paramContext)
  {
    super(paramContext, WorkAccount.IOERR, null, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  public Task addWorkAccount(String paramString)
  {
    return PendingResultUtil.toTask(zzac.addWorkAccount(asGoogleApiClient(), paramString), new RomkanHalfKatakana(this));
  }
  
  public Task removeWorkAccount(Account paramAccount)
  {
    return PendingResultUtil.toVoidTask(zzac.removeWorkAccount(asGoogleApiClient(), paramAccount));
  }
  
  public Task setWorkAuthenticatorEnabled(boolean paramBoolean)
  {
    return PendingResultUtil.toVoidTask(zzac.setWorkAuthenticatorEnabledWithResult(asGoogleApiClient(), paramBoolean));
  }
}
