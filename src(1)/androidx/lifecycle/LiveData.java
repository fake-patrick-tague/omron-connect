package androidx.lifecycle;

import c.b.a.b.b;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class LiveData<T>
{
  static final java.lang.Object NOT_SET = new java.lang.Object();
  static final int START_VERSION = -1;
  int mActiveCount = 0;
  private boolean mChangingActiveState;
  private volatile java.lang.Object mData;
  final java.lang.Object mDataLock = new java.lang.Object();
  private boolean mDispatchInvalidated;
  private boolean mDispatchingValue;
  private b<t<? super T>, LiveData<T>.c> mObservers = new v7.support.v7.asm.f();
  volatile java.lang.Object mPendingData;
  private final Runnable mPostValueRunnable;
  private int mVersion;
  
  public LiveData()
  {
    java.lang.Object localObject = NOT_SET;
    mPendingData = localObject;
    mPostValueRunnable = new a();
    mData = localObject;
    mVersion = -1;
  }
  
  public LiveData(java.lang.Object paramObject)
  {
    mPendingData = NOT_SET;
    mPostValueRunnable = new a();
    mData = paramObject;
    mVersion = 0;
  }
  
  static void assertMainThread(String paramString)
  {
    if (v7.support.v7.util.f.a().close()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot invoke ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" on a background thread");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private void considerNotify(c paramC)
  {
    if (!d) {
      return;
    }
    if (!paramC.c())
    {
      paramC.b(false);
      return;
    }
    int i = l;
    int j = mVersion;
    if (i >= j) {
      return;
    }
    l = j;
    y.onChanged(mData);
  }
  
  void changeActiveCounter(int paramInt)
  {
    int i = mActiveCount;
    mActiveCount = (paramInt + i);
    if (mChangingActiveState) {
      return;
    }
    mChangingActiveState = true;
    try
    {
      for (;;)
      {
        int j = mActiveCount;
        if (i == j) {
          break;
        }
        if ((i == 0) && (j > 0)) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        if ((i > 0) && (j == 0)) {
          i = 1;
        } else {
          i = 0;
        }
        if (paramInt != 0) {
          onActive();
        } else if (i != 0) {
          onInactive();
        }
        i = j;
      }
      mChangingActiveState = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      mChangingActiveState = false;
      throw localThrowable;
    }
  }
  
  void dispatchingValue(c paramC)
  {
    if (mDispatchingValue)
    {
      mDispatchInvalidated = true;
      return;
    }
    mDispatchingValue = true;
    do
    {
      mDispatchInvalidated = false;
      c localC;
      if (paramC != null)
      {
        considerNotify(paramC);
        localC = null;
      }
      else
      {
        v7.support.v7.asm.d localD = mObservers.a();
        do
        {
          localC = paramC;
          if (!localD.hasNext()) {
            break;
          }
          considerNotify((c)((Map.Entry)localD.next()).getValue());
        } while (!mDispatchInvalidated);
        localC = paramC;
      }
      paramC = localC;
    } while (mDispatchInvalidated);
    mDispatchingValue = false;
  }
  
  public java.lang.Object getValue()
  {
    java.lang.Object localObject = mData;
    if (localObject != NOT_SET) {
      return localObject;
    }
    return null;
  }
  
  int getVersion()
  {
    return mVersion;
  }
  
  public boolean hasActiveObservers()
  {
    return mActiveCount > 0;
  }
  
  public boolean hasObservers()
  {
    return mObservers.size() > 0;
  }
  
  public void observe(d paramD, Object paramObject)
  {
    assertMainThread("observe");
    if (paramD.getLifecycle().c() == Lifecycle.State.c) {
      return;
    }
    LifecycleBoundObserver localLifecycleBoundObserver = new LifecycleBoundObserver(paramD, paramObject);
    paramObject = (c)mObservers.b(paramObject, localLifecycleBoundObserver);
    if ((paramObject != null) && (!paramObject.c(paramD))) {
      throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }
    if (paramObject != null) {
      return;
    }
    paramD.getLifecycle().a(localLifecycleBoundObserver);
  }
  
  public void observeForever(Object paramObject)
  {
    assertMainThread("observeForever");
    b localB = new b(paramObject);
    paramObject = (c)mObservers.b(paramObject, localB);
    if (!(paramObject instanceof LifecycleBoundObserver))
    {
      if (paramObject != null) {
        return;
      }
      localB.b(true);
      return;
    }
    throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
  }
  
  protected void onActive() {}
  
  protected void onInactive() {}
  
  protected void postValue(java.lang.Object paramObject)
  {
    java.lang.Object localObject = mDataLock;
    for (;;)
    {
      try
      {
        if (mPendingData == NOT_SET)
        {
          i = 1;
          mPendingData = paramObject;
          if (i == 0) {
            return;
          }
          v7.support.v7.util.f.a().a(mPostValueRunnable);
          return;
        }
      }
      catch (Throwable paramObject)
      {
        throw paramObject;
      }
      int i = 0;
    }
  }
  
  public void removeObserver(Object paramObject)
  {
    assertMainThread("removeObserver");
    paramObject = (c)mObservers.a(paramObject);
    if (paramObject == null) {
      return;
    }
    paramObject.b();
    paramObject.b(false);
  }
  
  public void removeObservers(d paramD)
  {
    assertMainThread("removeObservers");
    Iterator localIterator = mObservers.iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((c)localEntry.getValue()).c(paramD)) {
        removeObserver((Object)localEntry.getKey());
      }
    }
  }
  
  protected void setValue(java.lang.Object paramObject)
  {
    assertMainThread("setValue");
    mVersion += 1;
    mData = paramObject;
    dispatchingValue(null);
  }
  
  class LifecycleBoundObserver
    extends LiveData<T>.c
    implements k
  {
    final d a;
    
    LifecycleBoundObserver(d paramD, Object paramObject)
    {
      super(paramObject);
      a = paramD;
    }
    
    void b()
    {
      a.getLifecycle().clear(this);
    }
    
    public void b(d paramD, Lifecycle.Event paramEvent)
    {
      paramEvent = a.getLifecycle().c();
      paramD = paramEvent;
      if (paramEvent == Lifecycle.State.c)
      {
        removeObserver(y);
        return;
      }
      paramEvent = null;
      while (paramEvent != paramD)
      {
        b(c());
        paramEvent = a.getLifecycle();
        Lifecycle.State localState = paramEvent.c();
        paramEvent = paramD;
        paramD = localState;
      }
    }
    
    boolean c()
    {
      return a.getLifecycle().c().a(Lifecycle.State.g);
    }
    
    boolean c(d paramD)
    {
      return a == paramD;
    }
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      java.lang.Object localObject1 = mDataLock;
      try
      {
        java.lang.Object localObject2 = mPendingData;
        mPendingData = LiveData.NOT_SET;
        setValue(localObject2);
        return;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
  }
  
  private class b
    extends LiveData<T>.c
  {
    b(Object paramObject)
    {
      super(paramObject);
    }
    
    boolean c()
    {
      return true;
    }
  }
  
  private abstract class c
  {
    boolean d;
    int l = -1;
    final t<? super T> y;
    
    c(Object paramObject)
    {
      y = paramObject;
    }
    
    void b() {}
    
    void b(boolean paramBoolean)
    {
      if (paramBoolean == d) {
        return;
      }
      d = paramBoolean;
      LiveData localLiveData = LiveData.this;
      int i;
      if (paramBoolean) {
        i = 1;
      } else {
        i = -1;
      }
      localLiveData.changeActiveCounter(i);
      if (d) {
        dispatchingValue(this);
      }
    }
    
    abstract boolean c();
    
    boolean c(d paramD)
    {
      return false;
    }
  }
}
