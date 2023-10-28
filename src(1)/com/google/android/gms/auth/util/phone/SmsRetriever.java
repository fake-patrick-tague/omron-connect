package com.google.android.gms.auth.util.phone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.internal.auth-api-phone.Application;

public final class SmsRetriever
{
  public static final String EXTRA_SMS_MESSAGE = "com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE";
  public static final String EXTRA_STATUS = "com.google.android.gms.auth.api.phone.EXTRA_STATUS";
  public static final String SMS_RETRIEVED_ACTION = "com.google.android.gms.auth.api.phone.SMS_RETRIEVED";
  
  private SmsRetriever() {}
  
  public static SmsRetrieverClient getClient(Activity paramActivity)
  {
    return new Application(paramActivity);
  }
  
  public static SmsRetrieverClient getClient(Context paramContext)
  {
    return new Application(paramContext);
  }
}
