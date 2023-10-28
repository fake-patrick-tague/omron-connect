package com.google.android.gms.common;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.os.BaseBundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.util.BTC;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.concurrent.atomic.AtomicBoolean;

@KeepForSdk
@ShowFirstParty
public class GooglePlayServicesUtilLight
{
  @KeepForSdk
  static final int GMS_AVAILABILITY_NOTIFICATION_ID = 10436;
  @KeepForSdk
  static final int GMS_GENERAL_ERROR_NOTIFICATION_ID = 39789;
  @KeepForSdk
  public static final String GOOGLE_PLAY_GAMES_PACKAGE = "com.google.android.play.games";
  @Deprecated
  @KeepForSdk
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  @Deprecated
  @KeepForSdk
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;
  @KeepForSdk
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  @VisibleForTesting
  static boolean isPaused;
  private static boolean isSpeaking;
  @KeepForSdk
  @VisibleForTesting
  static final AtomicBoolean sCanceledAvailabilityNotification = new AtomicBoolean();
  private static final AtomicBoolean shuttingDown = new AtomicBoolean();
  
  GooglePlayServicesUtilLight() {}
  
  /* Error */
  static boolean backup(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 18
    //   3: invokevirtual 56	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: istore_2
    //   7: invokestatic 62	com/google/android/gms/common/util/PlatformVersion:isAtLeastLollipop	()Z
    //   10: ifeq +51 -> 61
    //   13: aload_0
    //   14: invokevirtual 68	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   17: invokevirtual 74	android/content/pm/PackageManager:getPackageInstaller	()Landroid/content/pm/PackageInstaller;
    //   20: invokevirtual 80	android/content/pm/PackageInstaller:getAllSessions	()Ljava/util/List;
    //   23: astore_3
    //   24: aload_3
    //   25: invokeinterface 86 1 0
    //   30: astore_3
    //   31: aload_3
    //   32: invokeinterface 91 1 0
    //   37: ifeq +24 -> 61
    //   40: aload_1
    //   41: aload_3
    //   42: invokeinterface 95 1 0
    //   47: checkcast 97	android/content/pm/PackageInstaller$SessionInfo
    //   50: invokevirtual 101	android/content/pm/PackageInstaller$SessionInfo:getAppPackageName	()Ljava/lang/String;
    //   53: invokevirtual 56	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   56: ifeq -25 -> 31
    //   59: iconst_1
    //   60: ireturn
    //   61: aload_0
    //   62: invokevirtual 68	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   65: astore_3
    //   66: aload_3
    //   67: aload_1
    //   68: sipush 8192
    //   71: invokevirtual 105	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   74: astore_1
    //   75: iload_2
    //   76: ifeq +8 -> 84
    //   79: aload_1
    //   80: getfield 110	android/content/pm/ApplicationInfo:enabled	Z
    //   83: ireturn
    //   84: aload_1
    //   85: getfield 110	android/content/pm/ApplicationInfo:enabled	Z
    //   88: ifeq +14 -> 102
    //   91: aload_0
    //   92: invokestatic 114	com/google/android/gms/common/GooglePlayServicesUtilLight:isRestrictedUserProfile	(Landroid/content/Context;)Z
    //   95: istore_2
    //   96: iload_2
    //   97: ifne +11 -> 108
    //   100: iconst_1
    //   101: ireturn
    //   102: iconst_0
    //   103: ireturn
    //   104: astore_0
    //   105: iconst_0
    //   106: ireturn
    //   107: astore_0
    //   108: iconst_0
    //   109: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	paramContext	Context
    //   0	110	1	paramString	String
    //   6	91	2	bool	boolean
    //   23	44	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	24	104	java/lang/Exception
    //   66	75	107	android/content/pm/PackageManager$NameNotFoundException
    //   91	96	107	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public static void cancelAvailabilityErrorNotifications(Context paramContext)
  {
    if (sCanceledAvailabilityNotification.getAndSet(true)) {
      return;
    }
    try
    {
      paramContext = paramContext.getSystemService("notification");
      paramContext = (NotificationManager)paramContext;
      if (paramContext != null)
      {
        paramContext.cancel(10436);
        return;
      }
    }
    catch (SecurityException paramContext) {}
  }
  
  public static void enableUsingApkIndependentContext()
  {
    shuttingDown.set(true);
  }
  
  public static void ensurePlayServicesAvailable(Context paramContext, int paramInt)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    paramInt = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(paramContext, paramInt);
    if (paramInt != 0)
    {
      paramContext = GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(paramContext, paramInt, "e");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GooglePlayServices not available due to error ");
      localStringBuilder.append(paramInt);
      Log.e("GooglePlayServicesUtil", localStringBuilder.toString());
      if (paramContext == null) {
        throw new GooglePlayServicesNotAvailableException(paramInt);
      }
      throw new GooglePlayServicesRepairableException(paramInt, "Google Play Services not available", paramContext);
    }
  }
  
  public static int getApkVersion(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.google.android.gms", 0);
      return versionCode;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
    return 0;
  }
  
  public static int getClientVersion(Context paramContext)
  {
    Preconditions.checkState(true);
    return ClientLibraryUtils.getClientVersion(paramContext, paramContext.getPackageName());
  }
  
  public static PendingIntent getErrorPendingIntent(int paramInt1, Context paramContext, int paramInt2)
  {
    return GoogleApiAvailabilityLight.getInstance().getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2);
  }
  
  public static String getErrorString(int paramInt)
  {
    return ConnectionResult.toString(paramInt);
  }
  
  public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(int paramInt)
  {
    return GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(null, paramInt, null);
  }
  
  public static Context getRemoteContext(Context paramContext)
  {
    try
    {
      paramContext = paramContext.createPackageContext("com.google.android.gms", 3);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static Resources getRemoteResource(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getResourcesForApplication("com.google.android.gms");
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static boolean honorsDebugCertificates(Context paramContext)
  {
    if (!isPaused)
    {
      try
      {
        PackageInfo localPackageInfo = Wrappers.packageManager(paramContext).getPackageInfo("com.google.android.gms", 64);
        GoogleSignatureVerifier.getInstance(paramContext);
        if (localPackageInfo != null)
        {
          boolean bool = GoogleSignatureVerifier.add(localPackageInfo, false);
          if (!bool)
          {
            bool = GoogleSignatureVerifier.add(localPackageInfo, true);
            if (bool)
            {
              isSpeaking = true;
              break label58;
            }
          }
        }
        isSpeaking = false;
        label58:
        isPaused = true;
      }
      catch (Throwable paramContext) {}catch (PackageManager.NameNotFoundException paramContext)
      {
        Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", paramContext);
        isPaused = true;
      }
      isPaused = true;
      throw paramContext;
    }
    if (!isSpeaking) {
      return !DeviceProperties.isUserBuild();
    }
    return true;
  }
  
  public static int isGooglePlayServicesAvailable(Context paramContext)
  {
    return isGooglePlayServicesAvailable(paramContext, GOOGLE_PLAY_SERVICES_VERSION_CODE);
  }
  
  public static int isGooglePlayServicesAvailable(Context paramContext, int paramInt)
  {
    try
    {
      paramContext.getResources().getString(R.string.common_google_play_services_unknown_issue);
    }
    catch (Throwable localThrowable)
    {
      int i;
      boolean bool;
      String str;
      PackageManager localPackageManager;
      for (;;) {}
    }
    Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
    if ((!"com.google.android.gms".equals(paramContext.getPackageName())) && (!shuttingDown.get()))
    {
      i = zzag.getCurrentVersion(paramContext);
      if (i != 0)
      {
        if (i != GOOGLE_PLAY_SERVICES_VERSION_CODE) {
          throw new GooglePlayServicesIncorrectManifestValueException(i);
        }
      }
      else {
        throw new GooglePlayServicesMissingManifestValueException();
      }
    }
    if ((!DeviceProperties.isWearableWithoutPlayStore(paramContext)) && (!DeviceProperties.isEnabled(paramContext))) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    str = paramContext.getPackageName();
    localPackageManager = paramContext.getPackageManager();
    if (i != 0) {}
    try
    {
      localObject = localPackageManager.getPackageInfo("com.android.vending", 8256);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Object localObject;
      for (;;) {}
    }
    Log.w("GooglePlayServicesUtil", String.valueOf(str).concat(" requires the Google Play Store, but it is missing."));
    for (;;)
    {
      return 9;
      localObject = null;
      try
      {
        PackageInfo localPackageInfo = localPackageManager.getPackageInfo("com.google.android.gms", 64);
        GoogleSignatureVerifier.getInstance(paramContext);
        if (!GoogleSignatureVerifier.add(localPackageInfo, true))
        {
          Log.w("GooglePlayServicesUtil", String.valueOf(str).concat(" requires Google Play services, but their signature is invalid."));
        }
        else
        {
          if (i != 0)
          {
            Preconditions.checkNotNull(localObject);
            if (!GoogleSignatureVerifier.add((PackageInfo)localObject, true))
            {
              Log.w("GooglePlayServicesUtil", String.valueOf(str).concat(" requires Google Play Store, but its signature is invalid."));
              continue;
            }
          }
          if ((i != 0) && (localObject != null) && (!signatures[0].equals(signatures[0])))
          {
            Log.w("GooglePlayServicesUtil", String.valueOf(str).concat(" requires Google Play Store, but its signature doesn't match that of Google Play services."));
          }
          else
          {
            if (BTC.open(versionCode) < BTC.open(paramInt))
            {
              i = versionCode;
              paramContext = new StringBuilder();
              paramContext.append("Google Play services out of date for ");
              paramContext.append(str);
              paramContext.append(".  Requires ");
              paramContext.append(paramInt);
              paramContext.append(" but found ");
              paramContext.append(i);
              Log.w("GooglePlayServicesUtil", paramContext.toString());
              return 2;
            }
            localObject = applicationInfo;
            paramContext = (Context)localObject;
            if (localObject == null) {
              try
              {
                paramContext = localPackageManager.getApplicationInfo("com.google.android.gms", 0);
              }
              catch (PackageManager.NameNotFoundException paramContext)
              {
                Log.wtf("GooglePlayServicesUtil", String.valueOf(str).concat(" requires Google Play services, but they're missing when getting application info."), paramContext);
                return 1;
              }
            }
            if (!enabled) {
              return 3;
            }
            return 0;
          }
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;) {}
      }
    }
    Log.w("GooglePlayServicesUtil", String.valueOf(str).concat(" requires Google Play services, but they are missing."));
    return 1;
  }
  
  public static boolean isGooglePlayServicesUid(Context paramContext, int paramInt)
  {
    return UidVerifier.isGooglePlayServicesUid(paramContext, paramInt);
  }
  
  public static boolean isPlayServicesPossiblyUpdating(Context paramContext, int paramInt)
  {
    if (paramInt == 18) {
      return true;
    }
    if (paramInt == 1) {
      return backup(paramContext, "com.google.android.gms");
    }
    return false;
  }
  
  public static boolean isPlayStorePossiblyUpdating(Context paramContext, int paramInt)
  {
    if (paramInt == 9) {
      return backup(paramContext, "com.android.vending");
    }
    return false;
  }
  
  public static boolean isRestrictedUserProfile(Context paramContext)
  {
    if (PlatformVersion.isAtLeastJellyBeanMR2())
    {
      Object localObject = paramContext.getSystemService("user");
      Preconditions.checkNotNull(localObject);
      paramContext = ((UserManager)localObject).getApplicationRestrictions(paramContext.getPackageName());
      if ((paramContext != null) && ("true".equals(paramContext.getString("restricted_profile")))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isSidewinderDevice(Context paramContext)
  {
    return DeviceProperties.isSidewinder(paramContext);
  }
  
  public static boolean isUserRecoverableError(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 9);
  }
  
  public static boolean uidHasPackageName(Context paramContext, int paramInt, String paramString)
  {
    return UidVerifier.uidHasPackageName(paramContext, paramInt, paramString);
  }
}
