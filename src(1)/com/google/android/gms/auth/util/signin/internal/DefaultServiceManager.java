package com.google.android.gms.auth.util.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import com.google.android.gms.auth.util.signin.GoogleSignInAccount;
import com.google.android.gms.auth.util.signin.GoogleSignInOptions;
import com.google.android.gms.auth.util.signin.GoogleSignInResult;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.OptionalPendingResult;
import com.google.android.gms.common.package_12.PendingResult;
import com.google.android.gms.common.package_12.PendingResults;
import com.google.android.gms.common.package_12.Result;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.common.package_12.internal.GoogleApiManager;
import com.google.android.gms.common.package_12.internal.OptionalPendingResultImpl;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class DefaultServiceManager
{
  private static final Logger log = new Logger("GoogleSignInCommon", new String[0]);
  
  public static OptionalPendingResult create(GoogleApiClient paramGoogleApiClient, Context paramContext, GoogleSignInOptions paramGoogleSignInOptions, boolean paramBoolean)
  {
    Logger localLogger = log;
    localLogger.log("silentSignIn()", new Object[0]);
    localLogger.log("getEligibleSavedSignInResult()", new Object[0]);
    Preconditions.checkNotNull(paramGoogleSignInOptions);
    Object localObject = ByteArrayPool.get(paramContext).getBytes();
    if (localObject == null) {}
    do
    {
      Account localAccount1;
      Account localAccount2;
      do
      {
        localObject = null;
        break;
        localAccount1 = ((GoogleSignInOptions)localObject).getAccount();
        localAccount2 = paramGoogleSignInOptions.getAccount();
      } while ((localAccount1 == null ? localAccount2 != null : !localAccount1.equals(localAccount2)) || (paramGoogleSignInOptions.isServerAuthCodeRequested()) || ((paramGoogleSignInOptions.isIdTokenRequested()) && ((!((GoogleSignInOptions)localObject).isIdTokenRequested()) || (!Objects.equal(paramGoogleSignInOptions.getServerClientId(), ((GoogleSignInOptions)localObject).getServerClientId())))) || (!new HashSet(((GoogleSignInOptions)localObject).getScopes()).containsAll(new HashSet(paramGoogleSignInOptions.getScopes()))));
      localObject = ByteArrayPool.get(paramContext).get();
    } while ((localObject == null) || (((GoogleSignInAccount)localObject).isExpired()));
    localObject = new GoogleSignInResult((GoogleSignInAccount)localObject, Status.RESULT_SUCCESS);
    if (localObject != null)
    {
      localLogger.log("Eligible saved sign in result found", new Object[0]);
      return PendingResults.immediatePendingResult((Result)localObject, paramGoogleApiClient);
    }
    if (paramBoolean) {
      return PendingResults.immediatePendingResult(new GoogleSignInResult(null, new Status(4)), paramGoogleApiClient);
    }
    localLogger.log("trySilentSignIn()", new Object[0]);
    return new OptionalPendingResultImpl(paramGoogleApiClient.enqueue(new InternalHttpClient(paramGoogleApiClient, paramContext, paramGoogleSignInOptions)));
  }
  
  public static Intent execute(Context paramContext, GoogleSignInOptions paramGoogleSignInOptions)
  {
    log.log("getFallbackSignInIntent()", new Object[0]);
    paramContext = init(paramContext, paramGoogleSignInOptions);
    paramContext.setAction("com.google.android.gms.auth.APPAUTH_SIGN_IN");
    return paramContext;
  }
  
  public static PendingResult execute(GoogleApiClient paramGoogleApiClient, Context paramContext, boolean paramBoolean)
  {
    log.log("Revoking access", new Object[0]);
    String str = Storage.getInstance(paramContext).getSavedRefreshToken();
    unlock(paramContext);
    if (paramBoolean) {
      return XMPPService.4.run(str);
    }
    return paramGoogleApiClient.execute(new MinimalHttpClient(paramGoogleApiClient));
  }
  
  public static PendingResult get(GoogleApiClient paramGoogleApiClient, Context paramContext, boolean paramBoolean)
  {
    log.log("Signing out", new Object[0]);
    unlock(paramContext);
    if (paramBoolean) {
      return PendingResults.immediatePendingResult(Status.RESULT_SUCCESS, paramGoogleApiClient);
    }
    return paramGoogleApiClient.execute(new AbstractHttpClient(paramGoogleApiClient));
  }
  
  public static Intent getCurrentState(Context paramContext, GoogleSignInOptions paramGoogleSignInOptions)
  {
    log.log("getNoImplementationSignInIntent()", new Object[0]);
    paramContext = init(paramContext, paramGoogleSignInOptions);
    paramContext.setAction("com.google.android.gms.auth.NO_IMPL");
    return paramContext;
  }
  
  public static GoogleSignInResult infoFromShortcutIntent(Intent paramIntent)
  {
    if (paramIntent == null) {
      return new GoogleSignInResult(null, Status.RESULT_INTERNAL_ERROR);
    }
    Status localStatus = (Status)paramIntent.getParcelableExtra("googleSignInStatus");
    paramIntent = (GoogleSignInAccount)paramIntent.getParcelableExtra("googleSignInAccount");
    if (paramIntent == null)
    {
      paramIntent = localStatus;
      if (localStatus == null) {
        paramIntent = Status.RESULT_INTERNAL_ERROR;
      }
      return new GoogleSignInResult(null, paramIntent);
    }
    return new GoogleSignInResult(paramIntent, Status.RESULT_SUCCESS);
  }
  
  public static Intent init(Context paramContext, GoogleSignInOptions paramGoogleSignInOptions)
  {
    log.log("getSignInIntent()", new Object[0]);
    paramGoogleSignInOptions = new SignInConfiguration(paramContext.getPackageName(), paramGoogleSignInOptions);
    Intent localIntent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.setClass(paramContext, SignInHubActivity.class);
    paramContext = new Bundle();
    paramContext.putParcelable("config", paramGoogleSignInOptions);
    localIntent.putExtra("config", paramContext);
    return localIntent;
  }
  
  private static void unlock(Context paramContext)
  {
    ByteArrayPool.get(paramContext).clear();
    paramContext = GoogleApiClient.getAllClients().iterator();
    while (paramContext.hasNext()) {
      ((GoogleApiClient)paramContext.next()).maybeSignOut();
    }
    GoogleApiManager.reportSignOut();
  }
}
