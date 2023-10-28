package com.google.android.gms.auth;

import android.accounts.Account;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.os.BaseBundle;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.UserRecoverableException;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import java.io.IOException;
import java.util.List;

public class AccountManager
{
  private static final String[] ACCEPTABLE_ACCOUNT_TYPES = { "com.google", "com.google.work", "cn.google" };
  private static final ComponentName ACCOUNTS_URI = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
  public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
  public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
  public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
  public static final String KEY_ANDROID_PACKAGE_NAME;
  public static final String KEY_CALLER_UID = "callerUid";
  public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
  private static final Logger LOG = new Logger("Auth", new String[] { "GoogleAuthUtil" });
  public static final String WORK_ACCOUNT_TYPE = "com.google.work";
  
  static
  {
    KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
  }
  
  AccountManager() {}
  
  private static java.lang.Object call(Context paramContext, ComponentName paramComponentName, Object paramObject)
    throws IOException, GoogleAuthException
  {
    BlockingServiceConnection localBlockingServiceConnection = new BlockingServiceConnection();
    GmsClientSupervisor localGmsClientSupervisor = GmsClientSupervisor.getInstance(paramContext);
    if (localGmsClientSupervisor.bindService(paramComponentName, localBlockingServiceConnection, "GoogleAuthUtil"))
    {
      try
      {
        paramContext = paramObject.doInBackground(localBlockingServiceConnection.getService());
        localGmsClientSupervisor.unbindService(paramComponentName, localBlockingServiceConnection, "GoogleAuthUtil");
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        break label89;
      }
      catch (InterruptedException paramContext) {}catch (RemoteException paramContext) {}
      LOG.info("GoogleAuthUtil", new java.lang.Object[] { "Error on service connection.", paramContext });
      throw new IOException("Error on service connection.", paramContext);
      label89:
      localGmsClientSupervisor.unbindService(paramComponentName, localBlockingServiceConnection, "GoogleAuthUtil");
      throw paramContext;
    }
    throw new IOException("Could not bind to service.");
  }
  
  public static void clearToken(Context paramContext, String paramString)
    throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException
  {
    Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
    ensurePlayServicesAvailable(paramContext, 8400000);
    Bundle localBundle = new Bundle();
    String str1 = getApplicationInfopackageName;
    localBundle.putString("clientPackageName", str1);
    String str2 = KEY_ANDROID_PACKAGE_NAME;
    if (!localBundle.containsKey(str2)) {
      localBundle.putString(str2, str1);
    }
    paramString = new LoginActivity.8(paramString, localBundle);
    call(paramContext, ACCOUNTS_URI, paramString);
  }
  
  private static java.lang.Object create(java.lang.Object paramObject)
    throws IOException
  {
    if (paramObject != null) {
      return paramObject;
    }
    LOG.w("GoogleAuthUtil", new java.lang.Object[] { "Binder call returned null." });
    throw new IOException("Service unavailable.");
  }
  
  private static void create(Account paramAccount)
  {
    if (paramAccount != null)
    {
      if (!TextUtils.isEmpty(name))
      {
        String[] arrayOfString = ACCEPTABLE_ACCOUNT_TYPES;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equals(type)) {
            return;
          }
          i += 1;
        }
        throw new IllegalArgumentException("Account type not supported");
      }
      throw new IllegalArgumentException("Account name cannot be empty!");
    }
    throw new IllegalArgumentException("Account cannot be null");
  }
  
  private static void ensurePlayServicesAvailable(Context paramContext, int paramInt)
    throws GoogleAuthException
  {
    try
    {
      GooglePlayServicesUtilLight.ensurePlayServicesAvailable(paramContext.getApplicationContext(), paramInt);
      return;
    }
    catch (GooglePlayServicesNotAvailableException paramContext)
    {
      throw new GoogleAuthException(paramContext.getMessage());
    }
    catch (GooglePlayServicesRepairableException paramContext)
    {
      throw new GooglePlayServicesAvailabilityException(paramContext.getConnectionStatusCode(), paramContext.getMessage(), paramContext.getIntent());
    }
  }
  
  public static List getAccountChangeEvents(Context paramContext, int paramInt, String paramString)
    throws GoogleAuthException, IOException
  {
    Preconditions.checkNotEmpty(paramString, "accountName must be provided");
    Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
    ensurePlayServicesAvailable(paramContext, 8400000);
    paramString = new Preferences.8(paramString, paramInt);
    return (List)call(paramContext, ACCOUNTS_URI, paramString);
  }
  
  public static String getAccountId(Context paramContext, String paramString)
    throws GoogleAuthException, IOException
  {
    Preconditions.checkNotEmpty(paramString, "accountName must be provided");
    Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
    ensurePlayServicesAvailable(paramContext, 8400000);
    return getToken(paramContext, paramString, "^^_account_id_^^", new Bundle());
  }
  
  public static String getToken(Context paramContext, Account paramAccount, String paramString)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return getToken(paramContext, paramAccount, paramString, new Bundle());
  }
  
  public static String getToken(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    create(paramAccount);
    return onCreate(paramContext, paramAccount, paramString, paramBundle).mimeType();
  }
  
  public static String getToken(Context paramContext, String paramString1, String paramString2)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return getToken(paramContext, new Account(paramString1, "com.google"), paramString2);
  }
  
  public static String getToken(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return getToken(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle);
  }
  
  public static void invalidateToken(Context paramContext, String paramString)
  {
    android.accounts.AccountManager.get(paramContext).invalidateAuthToken("com.google", paramString);
  }
  
  public static TokenData onCreate(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
    Preconditions.checkNotEmpty(paramString, "Scope cannot be empty or null.");
    create(paramAccount);
    ensurePlayServicesAvailable(paramContext, 8400000);
    if (paramBundle == null) {
      paramBundle = new Bundle();
    } else {
      paramBundle = new Bundle(paramBundle);
    }
    String str1 = getApplicationInfopackageName;
    paramBundle.putString("clientPackageName", str1);
    String str2 = KEY_ANDROID_PACKAGE_NAME;
    if (TextUtils.isEmpty(paramBundle.getString(str2))) {
      paramBundle.putString(str2, str1);
    }
    paramBundle.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
    paramAccount = new MainActivity.10(paramAccount, paramString, paramBundle);
    return (TokenData)call(paramContext, ACCOUNTS_URI, paramAccount);
  }
  
  public static Bundle removeAccount(Context paramContext, Account paramAccount)
    throws GoogleAuthException, IOException
  {
    Preconditions.checkNotNull(paramContext);
    create(paramAccount);
    ensurePlayServicesAvailable(paramContext, 8400000);
    paramAccount = new BackgroundTask(paramAccount);
    return (Bundle)call(paramContext, ACCOUNTS_URI, paramAccount);
  }
  
  public static Boolean requestGoogleAccountsAccess(Context paramContext)
    throws GoogleAuthException, IOException
  {
    Preconditions.checkNotNull(paramContext);
    ensurePlayServicesAvailable(paramContext, 11400000);
    Launcher.6 local6 = new Launcher.6(getApplicationInfopackageName);
    return (Boolean)call(paramContext, ACCOUNTS_URI, local6);
  }
}
