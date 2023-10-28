package com.google.android.gms.auth.util.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.util.Auth;
import com.google.android.gms.auth.util.signin.internal.DefaultServiceManager;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.internal.ApiExceptionMapper;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;

public class GoogleSignInClient
  extends com.google.android.gms.common.api.GoogleApi<com.google.android.gms.auth.api.signin.GoogleSignInOptions>
{
  @VisibleForTesting
  static int ID = 1;
  private static final Macro VIDEOID = new Macro(null);
  
  GoogleSignInClient(Activity paramActivity, GoogleSignInOptions paramGoogleSignInOptions)
  {
    super(paramActivity, Auth.GOOGLE_SIGN_IN_API, paramGoogleSignInOptions, new ApiExceptionMapper());
  }
  
  GoogleSignInClient(Context paramContext, GoogleSignInOptions paramGoogleSignInOptions)
  {
    super(paramContext, Auth.GOOGLE_SIGN_IN_API, paramGoogleSignInOptions, new ApiExceptionMapper());
  }
  
  private final int updatePlaylist()
  {
    try
    {
      if (ID == 1)
      {
        Context localContext = getApplicationContext();
        GoogleApiAvailability localGoogleApiAvailability = GoogleApiAvailability.getInstance();
        i = localGoogleApiAvailability.isGooglePlayServicesAvailable(localContext, 12451000);
        if (i == 0) {
          ID = 4;
        } else if ((localGoogleApiAvailability.getErrorResolutionIntent(localContext, i, null) == null) && (DynamiteModule.getLocalVersion(localContext, "com.google.android.gms.auth.api.fallback") != 0)) {
          ID = 3;
        } else {
          ID = 2;
        }
      }
      int i = ID;
      return i;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public Intent getSignInIntent()
  {
    Context localContext = getApplicationContext();
    int i = updatePlaylist();
    int j = i - 1;
    if (i != 0)
    {
      if (j != 2)
      {
        if (j != 3) {
          return DefaultServiceManager.getCurrentState(localContext, (GoogleSignInOptions)getApiOptions());
        }
        return DefaultServiceManager.init(localContext, (GoogleSignInOptions)getApiOptions());
      }
      return DefaultServiceManager.execute(localContext, (GoogleSignInOptions)getApiOptions());
    }
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public Task revokeAccess()
  {
    GoogleApiClient localGoogleApiClient = asGoogleApiClient();
    Context localContext = getApplicationContext();
    boolean bool;
    if (updatePlaylist() == 3) {
      bool = true;
    } else {
      bool = false;
    }
    return PendingResultUtil.toVoidTask(DefaultServiceManager.execute(localGoogleApiClient, localContext, bool));
  }
  
  public Task signOut()
  {
    GoogleApiClient localGoogleApiClient = asGoogleApiClient();
    Context localContext = getApplicationContext();
    boolean bool;
    if (updatePlaylist() == 3) {
      bool = true;
    } else {
      bool = false;
    }
    return PendingResultUtil.toVoidTask(DefaultServiceManager.get(localGoogleApiClient, localContext, bool));
  }
  
  public Task silentSignIn()
  {
    GoogleApiClient localGoogleApiClient = asGoogleApiClient();
    Context localContext = getApplicationContext();
    GoogleSignInOptions localGoogleSignInOptions = (GoogleSignInOptions)getApiOptions();
    boolean bool;
    if (updatePlaylist() == 3) {
      bool = true;
    } else {
      bool = false;
    }
    return PendingResultUtil.toTask(DefaultServiceManager.create(localGoogleApiClient, localContext, localGoogleSignInOptions, bool), VIDEOID);
  }
}
