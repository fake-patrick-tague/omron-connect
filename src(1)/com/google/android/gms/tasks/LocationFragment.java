package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.package_12.internal.LifecycleCallback;
import com.google.android.gms.common.package_12.internal.LifecycleFragment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class LocationFragment
  extends LifecycleCallback
{
  private final List bookmarks = new ArrayList();
  
  private LocationFragment(LifecycleFragment paramLifecycleFragment)
  {
    super(paramLifecycleFragment);
    mLifecycleFragment.addCallback("TaskOnStopCallback", this);
  }
  
  public static LocationFragment onCreate(Activity paramActivity)
  {
    LifecycleFragment localLifecycleFragment = LifecycleCallback.getFragment(paramActivity);
    LocationFragment localLocationFragment = (LocationFragment)localLifecycleFragment.getCallbackOrNull("TaskOnStopCallback", zzv.class);
    paramActivity = localLocationFragment;
    if (localLocationFragment == null) {
      paramActivity = new LocationFragment(localLifecycleFragment);
    }
    return paramActivity;
  }
  
  public final void onStop()
  {
    List localList = bookmarks;
    try
    {
      Iterator localIterator = bookmarks.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Object)((WeakReference)localIterator.next()).get();
        if (localObject != null) {
          localObject.clear();
        }
      }
      bookmarks.clear();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void onStop(Object paramObject)
  {
    List localList = bookmarks;
    try
    {
      bookmarks.add(new WeakReference(paramObject));
      return;
    }
    catch (Throwable paramObject)
    {
      throw paramObject;
    }
  }
}
