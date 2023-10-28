package androidx.activity;

import c.h.p.a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import v7.v7.util.DownloadManager;

public abstract class PullToRefreshAttacher
{
  private CopyOnWriteArrayList<h> mCancellables = new CopyOnWriteArrayList();
  private boolean mEnabled;
  private a<Boolean> mEnabledConsumer;
  
  public PullToRefreshAttacher(boolean paramBoolean)
  {
    mEnabled = paramBoolean;
  }
  
  void addCancellable(Subscription paramSubscription)
  {
    mCancellables.add(paramSubscription);
  }
  
  public abstract void handleOnBackPressed();
  
  public final boolean isEnabled()
  {
    return mEnabled;
  }
  
  public final void remove()
  {
    Iterator localIterator = mCancellables.iterator();
    while (localIterator.hasNext()) {
      ((Subscription)localIterator.next()).cancel();
    }
  }
  
  void removeCancellable(Subscription paramSubscription)
  {
    mCancellables.remove(paramSubscription);
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    mEnabled = paramBoolean;
    DownloadManager localDownloadManager = mEnabledConsumer;
    if (localDownloadManager != null) {
      localDownloadManager.a(Boolean.valueOf(paramBoolean));
    }
  }
  
  void setIsEnabledConsumer(DownloadManager paramDownloadManager)
  {
    mEnabledConsumer = paramDownloadManager;
  }
}
