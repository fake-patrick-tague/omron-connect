package com.google.android.gms.auth.util.phone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.phone.SmsRetrieverApi;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.package_12.Attribute;
import com.google.android.gms.common.package_12.internal.ApiExceptionMapper;
import com.google.android.gms.internal.auth-api-phone.zzi;
import com.google.android.gms.tasks.Task;

public abstract class SmsRetrieverClient
  extends com.google.android.gms.common.api.GoogleApi<Api.ApiOptions.NoOptions>
  implements SmsRetrieverApi
{
  private static final Api.AbstractClientBuilder<zzi, Api.ApiOptions.NoOptions> CLIENT_BUILDER;
  private static final com.google.android.gms.common.api.Api.ClientKey<zzi> CLIENT_KEY;
  private static final Api<Api.ApiOptions.NoOptions> q;
  
  static
  {
    com.google.android.gms.common.package_12.Api.ClientKey localClientKey = new com.google.android.gms.common.package_12.Api.ClientKey();
    CLIENT_KEY = localClientKey;
    CallerInfo localCallerInfo = new CallerInfo();
    CLIENT_BUILDER = localCallerInfo;
    q = new Attribute("SmsRetriever.API", localCallerInfo, localClientKey);
  }
  
  public SmsRetrieverClient(Activity paramActivity)
  {
    super(paramActivity, q, null, new ApiExceptionMapper());
  }
  
  public SmsRetrieverClient(Context paramContext)
  {
    super(paramContext, q, null, new ApiExceptionMapper());
  }
  
  public abstract Task startSmsRetriever();
}
