package com.google.android.gms.measurement.internal;

abstract class Log
  extends RealmObject
{
  private boolean level;
  
  Log(zzfy paramZzfy)
  {
    super(paramZzfy);
    this$0.openDatabase();
  }
  
  final boolean i()
  {
    return level;
  }
  
  protected void init() {}
  
  protected abstract boolean isMapped();
  
  protected final void next()
  {
    if (i()) {
      return;
    }
    throw new IllegalStateException("Not initialized");
  }
  
  public final void set()
  {
    if (!level)
    {
      if (!isMapped())
      {
        this$0.update();
        level = true;
      }
    }
    else {
      throw new IllegalStateException("Can't initialize twice");
    }
  }
  
  public final void write()
  {
    if (!level)
    {
      init();
      this$0.update();
      level = true;
      return;
    }
    throw new IllegalStateException("Can't initialize twice");
  }
}
