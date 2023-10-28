package com.google.android.gms.tasks;

final class Notifier
  extends CancellationToken
{
  private final AbstractDataSource val$file = new AbstractDataSource();
  
  Notifier() {}
  
  public final void finish()
  {
    val$file.get(null);
  }
  
  public final boolean isCancellationRequested()
  {
    return val$file.isComplete();
  }
  
  public final CancellationToken onCanceledRequested(OnTokenCanceledListener paramOnTokenCanceledListener)
  {
    AbstractDataSource localAbstractDataSource = val$file;
    paramOnTokenCanceledListener = new NowPlayingFragment.10(this, paramOnTokenCanceledListener);
    localAbstractDataSource.addOnSuccessListener(TaskExecutors.MAIN_THREAD, paramOnTokenCanceledListener);
    return this;
  }
}
