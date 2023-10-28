package com.google.android.gms.common.package_12;

import android.app.Activity;
import android.content.IntentSender.SendIntentException;
import android.util.Log;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.internal.Preconditions;

public abstract class ResolvingResultCallbacks<R extends com.google.android.gms.common.api.Result>
  extends ResultCallbacks<R>
{
  private final Activity val$activity;
  private final int val$id;
  
  protected ResolvingResultCallbacks(Activity paramActivity, int paramInt)
  {
    Preconditions.checkNotNull(paramActivity, "Activity must not be null");
    val$activity = paramActivity;
    val$id = paramInt;
  }
  
  public final void onFailure(Status paramStatus)
  {
    if (paramStatus.hasResolution())
    {
      Activity localActivity = val$activity;
      int i = val$id;
      try
      {
        paramStatus.startResolutionForResult(localActivity, i);
        return;
      }
      catch (IntentSender.SendIntentException paramStatus)
      {
        Log.e("ResolvingResultCallback", "Failed to start resolution", paramStatus);
        onUnresolvableFailure(new Status(8));
        return;
      }
    }
    onUnresolvableFailure(paramStatus);
  }
  
  public abstract void onSuccess(Result paramResult);
  
  public abstract void onUnresolvableFailure(Status paramStatus);
}
