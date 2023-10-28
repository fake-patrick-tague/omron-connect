package com.google.android.gms.common.package_12.internal;

import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.package_12.ApiException;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;

public final class zacc
  extends FragmentActivity
{
  private TaskCompletionSource<Void> this$0 = new TaskCompletionSource();
  
  private zacc(LifecycleFragment paramLifecycleFragment)
  {
    super(paramLifecycleFragment, GoogleApiAvailability.getInstance());
    mLifecycleFragment.addCallback("GmsAvailabilityHelper", this);
  }
  
  public static zacc then(Activity paramActivity)
  {
    paramActivity = LifecycleCallback.getFragment(paramActivity);
    zacc localZacc = (zacc)paramActivity.getCallbackOrNull("GmsAvailabilityHelper", com.google.android.gms.common.api.internal.zacc.class);
    if (localZacc != null)
    {
      paramActivity = localZacc;
      if (this$0.getTask().isComplete())
      {
        this$0 = new TaskCompletionSource();
        return localZacc;
      }
    }
    else
    {
      paramActivity = new zacc(paramActivity);
    }
    return paramActivity;
  }
  
  protected final void onCreate(ConnectionResult paramConnectionResult, int paramInt)
  {
    String str2 = paramConnectionResult.getErrorMessage();
    String str1 = str2;
    if (str2 == null) {
      str1 = "Error connecting to Google Play services";
    }
    this$0.setException(new ApiException(new Status(paramConnectionResult, str1, paramConnectionResult.getErrorCode())));
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    this$0.trySetException(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
  }
  
  protected final void onPostExecute()
  {
    Activity localActivity = mLifecycleFragment.getLifecycleActivity();
    if (localActivity == null)
    {
      this$0.trySetException(new ApiException(new Status(8)));
      return;
    }
    int i = index.isGooglePlayServicesAvailable(localActivity);
    if (i == 0)
    {
      this$0.trySetResult(null);
      return;
    }
    if (!this$0.getTask().isComplete()) {
      onError(new ConnectionResult(i, null), 0);
    }
  }
  
  public final Task then()
  {
    return this$0.getTask();
  }
}
