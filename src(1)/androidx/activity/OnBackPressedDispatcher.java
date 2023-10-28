package androidx.activity;

import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.LayoutManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.d;
import c.h.p.a;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import v7.v7.menu.Context;

public final class OnBackPressedDispatcher
{
  private boolean d = false;
  private final Runnable r;
  final ArrayDeque<j> this$0 = new ArrayDeque();
  private a<Boolean> u;
  private OnBackInvokedCallback x;
  private OnBackInvokedDispatcher y;
  
  public OnBackPressedDispatcher(Runnable paramRunnable)
  {
    r = paramRunnable;
    if (Context.get())
    {
      u = new h(this);
      x = a.create(new EventInfoFragment.1(this));
    }
  }
  
  public void b(OnBackInvokedDispatcher paramOnBackInvokedDispatcher)
  {
    y = paramOnBackInvokedDispatcher;
    d();
  }
  
  Subscription c(PullToRefreshAttacher paramPullToRefreshAttacher)
  {
    this$0.add(paramPullToRefreshAttacher);
    b localB = new b(paramPullToRefreshAttacher);
    paramPullToRefreshAttacher.addCancellable(localB);
    if (Context.get())
    {
      d();
      paramPullToRefreshAttacher.setIsEnabledConsumer(u);
    }
    return localB;
  }
  
  void d()
  {
    boolean bool = get();
    OnBackInvokedDispatcher localOnBackInvokedDispatcher = y;
    if (localOnBackInvokedDispatcher != null)
    {
      if ((bool) && (!d))
      {
        a.putInt(localOnBackInvokedDispatcher, 0, x);
        d = true;
        return;
      }
      if ((!bool) && (d))
      {
        a.linearCombination(localOnBackInvokedDispatcher, x);
        d = false;
      }
    }
  }
  
  public void f(d paramD, PullToRefreshAttacher paramPullToRefreshAttacher)
  {
    paramD = paramD.getLifecycle();
    if (paramD.c() == Lifecycle.State.c) {
      return;
    }
    paramPullToRefreshAttacher.addCancellable(new LifecycleOnBackPressedCancellable(paramD, paramPullToRefreshAttacher));
    if (Context.get())
    {
      d();
      paramPullToRefreshAttacher.setIsEnabledConsumer(u);
    }
  }
  
  public boolean get()
  {
    Iterator localIterator = this$0.descendingIterator();
    while (localIterator.hasNext()) {
      if (((PullToRefreshAttacher)localIterator.next()).isEnabled()) {
        return true;
      }
    }
    return false;
  }
  
  public void update()
  {
    Object localObject = this$0.descendingIterator();
    while (((Iterator)localObject).hasNext())
    {
      PullToRefreshAttacher localPullToRefreshAttacher = (PullToRefreshAttacher)((Iterator)localObject).next();
      if (localPullToRefreshAttacher.isEnabled())
      {
        localPullToRefreshAttacher.handleOnBackPressed();
        return;
      }
    }
    localObject = r;
    if (localObject != null) {
      ((Runnable)localObject).run();
    }
  }
  
  private class LifecycleOnBackPressedCancellable
    implements LayoutManager, Subscription
  {
    private Subscription c;
    private final PullToRefreshAttacher d;
    private final Lifecycle this$0;
    
    LifecycleOnBackPressedCancellable(Lifecycle paramLifecycle, PullToRefreshAttacher paramPullToRefreshAttacher)
    {
      this$0 = paramLifecycle;
      d = paramPullToRefreshAttacher;
      paramLifecycle.a(this);
    }
    
    public void b(d paramD, Lifecycle.Event paramEvent)
    {
      if (paramEvent == Lifecycle.Event.ON_START)
      {
        c = c(d);
        return;
      }
      if (paramEvent == Lifecycle.Event.ON_STOP)
      {
        paramD = c;
        if (paramD != null) {
          paramD.cancel();
        }
      }
      else if (paramEvent == Lifecycle.Event.ON_DESTROY)
      {
        cancel();
      }
    }
    
    public void cancel()
    {
      this$0.clear(this);
      d.removeCancellable(this);
      Subscription localSubscription = c;
      if (localSubscription != null)
      {
        localSubscription.cancel();
        c = null;
      }
    }
  }
  
  static class a
  {
    static OnBackInvokedCallback create(Runnable paramRunnable)
    {
      Objects.requireNonNull(paramRunnable);
      return new FileTransferManager.1(paramRunnable);
    }
    
    static void linearCombination(Object paramObject1, Object paramObject2)
    {
      ((OnBackInvokedDispatcher)paramObject1).unregisterOnBackInvokedCallback((OnBackInvokedCallback)paramObject2);
    }
    
    static void putInt(Object paramObject1, int paramInt, Object paramObject2)
    {
      ((OnBackInvokedDispatcher)paramObject1).registerOnBackInvokedCallback(paramInt, (OnBackInvokedCallback)paramObject2);
    }
  }
  
  private class b
    implements Subscription
  {
    private final PullToRefreshAttacher id;
    
    b(PullToRefreshAttacher paramPullToRefreshAttacher)
    {
      id = paramPullToRefreshAttacher;
    }
    
    public void cancel()
    {
      this$0.remove(id);
      id.removeCancellable(this);
      if (Context.get())
      {
        id.setIsEnabledConsumer(null);
        d();
      }
    }
  }
}
