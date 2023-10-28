package com.google.android.gms.common.package_12.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

@KeepForSdk
public class LifecycleCallback
{
  @KeepForSdk
  protected final LifecycleFragment mLifecycleFragment;
  
  protected LifecycleCallback(LifecycleFragment paramLifecycleFragment)
  {
    mLifecycleFragment = paramLifecycleFragment;
  }
  
  private static LifecycleFragment getChimeraLifecycleFragmentImpl(LifecycleActivity paramLifecycleActivity)
  {
    throw new IllegalStateException("Method not available in SDK.");
  }
  
  public static LifecycleFragment getFragment(Activity paramActivity)
  {
    return getFragment(new LifecycleActivity(paramActivity));
  }
  
  public static LifecycleFragment getFragment(ContextWrapper paramContextWrapper)
  {
    throw new UnsupportedOperationException();
  }
  
  protected static LifecycleFragment getFragment(LifecycleActivity paramLifecycleActivity)
  {
    if (paramLifecycleActivity.get()) {
      return BrowserActivity.onPostExecute(paramLifecycleActivity.getActivity());
    }
    if (paramLifecycleActivity.join()) {
      return Main.run(paramLifecycleActivity.getCurrentActivity());
    }
    throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public Activity getActivity()
  {
    Activity localActivity = mLifecycleFragment.getLifecycleActivity();
    Preconditions.checkNotNull(localActivity);
    return localActivity;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onDestroy() {}
  
  public void onResume() {}
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart() {}
  
  public void onStop() {}
}
