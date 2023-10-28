package com.google.android.gms.common.package_12.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class Action
  extends LifecycleCallback
{
  private List<Runnable> mTasks = new ArrayList();
  
  private Action(LifecycleFragment paramLifecycleFragment)
  {
    super(paramLifecycleFragment);
    mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
  }
  
  private final void execute(Runnable paramRunnable)
  {
    try
    {
      mTasks.add(paramRunnable);
      return;
    }
    catch (Throwable paramRunnable)
    {
      throw paramRunnable;
    }
  }
  
  public final void onStop()
  {
    try
    {
      Object localObject = mTasks;
      mTasks = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Runnable)((Iterator)localObject).next()).run();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
