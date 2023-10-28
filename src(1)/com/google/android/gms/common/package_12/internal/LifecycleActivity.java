package com.google.android.gms.common.package_12.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import androidx.fragment.package_11.FragmentActivity;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public class LifecycleActivity
{
  private final Object activity;
  
  public LifecycleActivity(Activity paramActivity)
  {
    Preconditions.checkNotNull(paramActivity, "Activity must not be null");
    activity = paramActivity;
  }
  
  public LifecycleActivity(ContextWrapper paramContextWrapper)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean get()
  {
    return activity instanceof FragmentActivity;
  }
  
  public final FragmentActivity getActivity()
  {
    return (FragmentActivity)activity;
  }
  
  public final Activity getCurrentActivity()
  {
    return (Activity)activity;
  }
  
  public final boolean join()
  {
    return activity instanceof Activity;
  }
}
