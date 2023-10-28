package com.google.android.gms.common.package_12.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.R.string;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.package_12.Status;

@Deprecated
@KeepForSdk
public final class GoogleServices
{
  private static final Object TAG = new Object();
  private static GoogleServices mContext;
  private final Status authenticated;
  private final String challenge;
  private final boolean compression;
  private final boolean unsynchronization;
  
  GoogleServices(Context paramContext)
  {
    Object localObject = paramContext.getResources();
    int i = ((Resources)localObject).getIdentifier("google_app_measurement_enable", "integer", ((Resources)localObject).getResourcePackageName(R.string.common_google_play_services_unknown_issue));
    boolean bool2 = true;
    boolean bool1 = true;
    if (i != 0)
    {
      i = ((Resources)localObject).getInteger(i);
      if (i != 0) {
        bool2 = false;
      } else {
        bool2 = true;
      }
      if (i == 0) {
        bool1 = false;
      }
      unsynchronization = bool2;
    }
    else
    {
      unsynchronization = false;
      bool1 = bool2;
    }
    compression = bool1;
    String str = zzag.getAppName(paramContext);
    localObject = str;
    if (str == null) {
      localObject = new StringResourceValueReader(paramContext).getString("google_app_id");
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      authenticated = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
      challenge = null;
      return;
    }
    challenge = ((String)localObject);
    authenticated = Status.RESULT_SUCCESS;
  }
  
  GoogleServices(String paramString, boolean paramBoolean)
  {
    challenge = paramString;
    authenticated = Status.RESULT_SUCCESS;
    compression = paramBoolean;
    unsynchronization = (paramBoolean ^ true);
  }
  
  private static GoogleServices checkInitialized(String paramString)
  {
    Object localObject1 = TAG;
    try
    {
      Object localObject2 = mContext;
      if (localObject2 != null) {
        return localObject2;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Initialize must be called before ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(".");
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  static void clearInstanceForTest()
  {
    Object localObject = TAG;
    try
    {
      mContext = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static String getGoogleAppId()
  {
    return checkInitialized"getGoogleAppId"challenge;
  }
  
  public static Status initialize(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext, "Context must not be null.");
    Object localObject = TAG;
    try
    {
      if (mContext == null) {
        mContext = new GoogleServices(paramContext);
      }
      paramContext = mContextauthenticated;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public static Status initialize(Context paramContext, String paramString, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramContext, "Context must not be null.");
    Preconditions.checkNotEmpty(paramString, "App ID must be nonempty.");
    paramContext = TAG;
    try
    {
      GoogleServices localGoogleServices = mContext;
      if (localGoogleServices != null)
      {
        paramString = localGoogleServices.checkGoogleAppId(paramString);
        return paramString;
      }
      paramString = new GoogleServices(paramString, paramBoolean);
      mContext = paramString;
      paramString = authenticated;
      return paramString;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public static boolean isMeasurementEnabled()
  {
    GoogleServices localGoogleServices = checkInitialized("isMeasurementEnabled");
    return (authenticated.isSuccess()) && (compression);
  }
  
  public static boolean isMeasurementExplicitlyDisabled()
  {
    return checkInitialized"isMeasurementExplicitlyDisabled"unsynchronization;
  }
  
  Status checkGoogleAppId(String paramString)
  {
    Object localObject = challenge;
    if ((localObject != null) && (!((String)localObject).equals(paramString)))
    {
      paramString = challenge;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("'.");
      return new Status(10, ((StringBuilder)localObject).toString());
    }
    return Status.RESULT_SUCCESS;
  }
}
