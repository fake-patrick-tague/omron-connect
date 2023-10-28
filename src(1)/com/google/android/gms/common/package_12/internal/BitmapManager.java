package com.google.android.gms.common.package_12.internal;

import com.google.android.gms.common.api.internal.zaa;
import java.lang.ref.WeakReference;

public final class BitmapManager
  extends ActivityLifecycleObserver
{
  private final WeakReference<zaa> imageViewReference;
  
  BitmapManager(Action paramAction)
  {
    imageViewReference = new WeakReference(paramAction);
  }
  
  public final ActivityLifecycleObserver onStopCallOnce(Runnable paramRunnable)
  {
    Action localAction = (Action)imageViewReference.get();
    if (localAction != null)
    {
      Action.execute(localAction, paramRunnable);
      return this;
    }
    throw new IllegalStateException("The target activity has already been GC'd");
  }
}
