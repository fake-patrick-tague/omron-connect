package com.google.android.gms.auth.account;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.package_12.Attribute;
import com.google.android.gms.internal.auth.BaseResource;
import com.google.android.gms.internal.auth.zzr;

public class WorkAccount
{
  private static final Api.AbstractClientBuilder<zzr, Api.ApiOptions.NoOptions> CLIENT_BUILDER;
  private static final com.google.android.gms.common.api.Api.ClientKey<zzr> CLIENT_KEY;
  public static final Api<Api.ApiOptions.NoOptions> IOERR;
  @Deprecated
  public static final WorkAccountApi WorkAccountApi = new BaseResource();
  
  static
  {
    com.google.android.gms.common.package_12.Api.ClientKey localClientKey = new com.google.android.gms.common.package_12.Api.ClientKey();
    CLIENT_KEY = localClientKey;
    AccountTable localAccountTable = new AccountTable();
    CLIENT_BUILDER = localAccountTable;
    IOERR = new Attribute("WorkAccount.API", localAccountTable, localClientKey);
  }
  
  private WorkAccount() {}
  
  public static WorkAccountClient getClient(Activity paramActivity)
  {
    return new WorkAccountClient(paramActivity);
  }
  
  public static WorkAccountClient getClient(Context paramContext)
  {
    return new WorkAccountClient(paramContext);
  }
}
