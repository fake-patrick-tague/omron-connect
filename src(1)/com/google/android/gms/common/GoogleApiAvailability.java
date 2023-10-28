package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageItemInfo;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Handler;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import androidx.core.package_10.ClassWriter;
import androidx.core.package_10.Frame;
import androidx.fragment.package_11.Fragment;
import com.google.android.gms.base.R.drawable;
import com.google.android.gms.base.R.string;
import com.google.android.gms.common.internal.Label;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.Preference;
import com.google.android.gms.common.package_12.GoogleApi;
import com.google.android.gms.common.package_12.GoogleApiActivity;
import com.google.android.gms.common.package_12.HasApiKey;
import com.google.android.gms.common.package_12.internal.GoogleApiManager;
import com.google.android.gms.common.package_12.internal.LifecycleFragment;
import com.google.android.gms.common.package_12.internal.zabw;
import com.google.android.gms.common.package_12.internal.zabx;
import com.google.android.gms.common.package_12.internal.zacc;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.internal.base.f;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class GoogleApiAvailability
  extends GoogleApiAvailabilityLight
{
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  private static final GoogleApiAvailability _theInstance;
  private static final Object o = new Object();
  private String B;
  
  static
  {
    _theInstance = new GoogleApiAvailability();
  }
  
  public GoogleApiAvailability() {}
  
  public static GoogleApiAvailability getInstance()
  {
    return _theInstance;
  }
  
  public static final Task to(HasApiKey paramHasApiKey, HasApiKey... paramVarArgs)
  {
    Preconditions.checkNotNull(paramHasApiKey, "Requested API must not be null.");
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Preconditions.checkNotNull(paramVarArgs[i], "Requested API must not be null.");
      i += 1;
    }
    ArrayList localArrayList = new ArrayList(paramVarArgs.length + 1);
    localArrayList.add(paramHasApiKey);
    localArrayList.addAll(Arrays.asList(paramVarArgs));
    return GoogleApiManager.get().call(localArrayList);
  }
  
  final void a(Context paramContext, int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", new Object[] { Integer.valueOf(paramInt), null }), new IllegalArgumentException());
    if (paramInt == 18)
    {
      init(paramContext);
      return;
    }
    if (paramPendingIntent == null)
    {
      if (paramInt == 6) {
        Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
      }
    }
    else
    {
      Object localObject1 = Label.b(paramContext, paramInt);
      paramString = Label.getTitle(paramContext, paramInt);
      Object localObject2 = paramContext.getResources();
      NotificationManager localNotificationManager = (NotificationManager)Preconditions.checkNotNull(paramContext.getSystemService("notification"));
      localObject1 = new ClassWriter(paramContext).b(true).a(true).b((CharSequence)localObject1).a(new Frame().a(paramString));
      if (DeviceProperties.isWearable(paramContext))
      {
        Preconditions.checkState(PlatformVersion.isAtLeastKitKatWatch());
        ((ClassWriter)localObject1).get(getApplicationInfoicon).put(2);
        if (DeviceProperties.isWearableWithoutPlayStore(paramContext)) {
          ((ClassWriter)localObject1).a(R.drawable.common_full_open_on_phone, ((Resources)localObject2).getString(R.string.common_open_on_phone), paramPendingIntent);
        } else {
          ((ClassWriter)localObject1).b(paramPendingIntent);
        }
      }
      else
      {
        ((ClassWriter)localObject1).get(17301642).get(((Resources)localObject2).getString(R.string.common_google_play_services_notification_ticker)).get(System.currentTimeMillis()).b(paramPendingIntent).a(paramString);
      }
      if (PlatformVersion.isAtLeastO())
      {
        Preconditions.checkState(PlatformVersion.isAtLeastO());
        paramString = o;
      }
      try
      {
        paramPendingIntent = B;
        paramString = paramPendingIntent;
        if (paramPendingIntent == null)
        {
          paramPendingIntent = "com.google.android.gms.availability";
          localObject2 = localNotificationManager.getNotificationChannel("com.google.android.gms.availability");
          paramContext = Label.getText(paramContext);
          if (localObject2 == null)
          {
            localNotificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", paramContext, 4));
            paramString = paramPendingIntent;
          }
          else
          {
            paramString = paramPendingIntent;
            if (!paramContext.contentEquals(((NotificationChannel)localObject2).getName()))
            {
              ((NotificationChannel)localObject2).setName(paramContext);
              localNotificationManager.createNotificationChannel((NotificationChannel)localObject2);
              paramString = paramPendingIntent;
            }
          }
        }
        ((ClassWriter)localObject1).a(paramString);
        paramContext = ((ClassWriter)localObject1).get();
        if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3))
        {
          paramInt = 39789;
        }
        else
        {
          GooglePlayServicesUtilLight.sCanceledAvailabilityNotification.set(false);
          paramInt = 10436;
        }
        localNotificationManager.notify(paramInt, paramContext);
        return;
      }
      catch (Throwable paramContext)
      {
        throw paramContext;
      }
    }
  }
  
  public final boolean add(Context paramContext, ConnectionResult paramConnectionResult, int paramInt)
  {
    if (InstantApps.isInstantApp(paramContext)) {
      return false;
    }
    PendingIntent localPendingIntent = getErrorResolutionPendingIntent(paramContext, paramConnectionResult);
    if (localPendingIntent != null)
    {
      a(paramContext, paramConnectionResult.getErrorCode(), null, f.a(paramContext, 0, GoogleApiActivity.start(paramContext, localPendingIntent, paramInt, true), f.c | 0x8000000));
      return true;
    }
    return false;
  }
  
  public Task checkApiAvailability(GoogleApi paramGoogleApi, GoogleApi... paramVarArgs)
  {
    return to(paramGoogleApi, paramVarArgs).onSuccessTask(Token.GREATER_THAN);
  }
  
  public Task checkApiAvailability(HasApiKey paramHasApiKey, HasApiKey... paramVarArgs)
  {
    return to(paramHasApiKey, paramVarArgs).onSuccessTask(Compression.METADATA);
  }
  
  final Dialog create(Context paramContext, int paramInt, Preference paramPreference, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AlertDialog.Builder localBuilder = null;
    if (paramInt == 0) {
      return null;
    }
    Object localObject = new TypedValue();
    paramContext.getTheme().resolveAttribute(16843529, (TypedValue)localObject, true);
    if ("Theme.Dialog.Alert".equals(paramContext.getResources().getResourceEntryName(resourceId))) {
      localBuilder = new AlertDialog.Builder(paramContext, 5);
    }
    localObject = localBuilder;
    if (localBuilder == null) {
      localObject = new AlertDialog.Builder(paramContext);
    }
    ((AlertDialog.Builder)localObject).setMessage(Label.getText(paramContext, paramInt));
    if (paramOnCancelListener != null) {
      ((AlertDialog.Builder)localObject).setOnCancelListener(paramOnCancelListener);
    }
    paramOnCancelListener = Label.getValue(paramContext, paramInt);
    if (paramOnCancelListener != null) {
      ((AlertDialog.Builder)localObject).setPositiveButton(paramOnCancelListener, paramPreference);
    }
    paramContext = Label.a(paramContext, paramInt);
    if (paramContext != null) {
      ((AlertDialog.Builder)localObject).setTitle(paramContext);
    }
    Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", new Object[] { Integer.valueOf(paramInt) }), new IllegalArgumentException());
    return ((AlertDialog.Builder)localObject).create();
  }
  
  public final boolean create(Activity paramActivity, LifecycleFragment paramLifecycleFragment, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    paramLifecycleFragment = create(paramActivity, paramInt1, Preference.onResult(paramLifecycleFragment, getErrorResolutionIntent(paramActivity, paramInt1, "d"), 2), paramOnCancelListener);
    if (paramLifecycleFragment == null) {
      return false;
    }
    show(paramActivity, paramLifecycleFragment, "GooglePlayServicesErrorDialog", paramOnCancelListener);
    return true;
  }
  
  public int getClientVersion(Context paramContext)
  {
    return super.getClientVersion(paramContext);
  }
  
  public Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2)
  {
    return getErrorDialog(paramActivity, paramInt1, paramInt2, null);
  }
  
  public Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return create(paramActivity, paramInt1, Preference.inflate(paramActivity, getErrorResolutionIntent(paramActivity, paramInt1, "d"), paramInt2), paramOnCancelListener);
  }
  
  public Dialog getErrorDialog(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    return getErrorDialog(paramFragment, paramInt1, paramInt2, null);
  }
  
  public Dialog getErrorDialog(Fragment paramFragment, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Intent localIntent = getErrorResolutionIntent(paramFragment.requireContext(), paramInt1, "d");
    return create(paramFragment.requireContext(), paramInt1, Preference.inflate(paramFragment, localIntent, paramInt2), paramOnCancelListener);
  }
  
  public Intent getErrorResolutionIntent(Context paramContext, int paramInt, String paramString)
  {
    return super.getErrorResolutionIntent(paramContext, paramInt, paramString);
  }
  
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2)
  {
    return super.getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2);
  }
  
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult.hasResolution()) {
      return paramConnectionResult.getResolution();
    }
    return getErrorResolutionPendingIntent(paramContext, paramConnectionResult.getErrorCode(), 0);
  }
  
  public final String getErrorString(int paramInt)
  {
    return super.getErrorString(paramInt);
  }
  
  final void init(Context paramContext)
  {
    new PlaylistAdapter(this, paramContext).sendEmptyMessageDelayed(1, 120000L);
  }
  
  public int isGooglePlayServicesAvailable(Context paramContext)
  {
    return super.isGooglePlayServicesAvailable(paramContext);
  }
  
  public int isGooglePlayServicesAvailable(Context paramContext, int paramInt)
  {
    return super.isGooglePlayServicesAvailable(paramContext, paramInt);
  }
  
  public final boolean isUserResolvableError(int paramInt)
  {
    return super.isUserResolvableError(paramInt);
  }
  
  public Task makeGooglePlayServicesAvailable(Activity paramActivity)
  {
    int i = GOOGLE_PLAY_SERVICES_VERSION_CODE;
    Preconditions.checkMainThread("makeGooglePlayServicesAvailable must be called from the main thread");
    i = isGooglePlayServicesAvailable(paramActivity, i);
    if (i == 0) {
      return Tasks.forResult(null);
    }
    paramActivity = zacc.then(paramActivity);
    paramActivity.onError(new ConnectionResult(i, null), 0);
    return paramActivity.then();
  }
  
  public void setDefaultNotificationChannelId(Context paramContext, String paramString)
  {
    if (PlatformVersion.isAtLeastO()) {
      Preconditions.checkNotNull(((NotificationManager)Preconditions.checkNotNull(paramContext.getSystemService("notification"))).getNotificationChannel(paramString));
    }
    paramContext = o;
    try
    {
      B = paramString;
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public final Dialog show(Activity paramActivity, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Object localObject = new ProgressBar(paramActivity, null, 16842874);
    ((ProgressBar)localObject).setIndeterminate(true);
    ((ProgressBar)localObject).setVisibility(0);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity);
    localBuilder.setView((View)localObject);
    localBuilder.setMessage(Label.getText(paramActivity, 18));
    localBuilder.setPositiveButton("", null);
    localObject = localBuilder.create();
    show(paramActivity, (Dialog)localObject, "GooglePlayServicesUpdatingDialog", paramOnCancelListener);
    return localObject;
  }
  
  final void show(Activity paramActivity, Dialog paramDialog, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    try
    {
      boolean bool = paramActivity instanceof androidx.fragment.package_11.FragmentActivity;
      if (bool)
      {
        paramActivity = ((androidx.fragment.package_11.FragmentActivity)paramActivity).getSupportFragmentManager();
        SupportErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(paramActivity, paramString);
        return;
      }
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      for (;;) {}
    }
    paramActivity = paramActivity.getFragmentManager();
    ErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(paramActivity, paramString);
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2)
  {
    return showErrorDialogFragment(paramActivity, paramInt1, paramInt2, null);
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Dialog localDialog = getErrorDialog(paramActivity, paramInt1, paramInt2, paramOnCancelListener);
    if (localDialog == null) {
      return false;
    }
    show(paramActivity, localDialog, "GooglePlayServicesErrorDialog", paramOnCancelListener);
    return true;
  }
  
  public void showErrorNotification(Context paramContext, int paramInt)
  {
    a(paramContext, paramInt, null, getErrorResolutionPendingIntent(paramContext, paramInt, 0, "n"));
  }
  
  public void showErrorNotification(Context paramContext, ConnectionResult paramConnectionResult)
  {
    PendingIntent localPendingIntent = getErrorResolutionPendingIntent(paramContext, paramConnectionResult);
    a(paramContext, paramConnectionResult.getErrorCode(), null, localPendingIntent);
  }
  
  public final zabx start(Context paramContext, zabw paramZabw)
  {
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addDataScheme("package");
    zabx localZabx = new zabx(paramZabw);
    paramContext.registerReceiver(localZabx, localIntentFilter);
    localZabx.init(paramContext);
    if (!isUninstalledAppPossiblyUpdating(paramContext, "com.google.android.gms"))
    {
      paramZabw.run();
      localZabx.close();
      return null;
    }
    return localZabx;
  }
}
