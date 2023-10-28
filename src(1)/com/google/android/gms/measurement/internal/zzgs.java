package com.google.android.gms.measurement.internal;

abstract class zzgs
  extends zzgr
{
  private boolean first;
  
  zzgs(zzfy paramZzfy)
  {
    super(paramZzfy);
    this$0.openDatabase();
  }
  
  public final void clear()
  {
    if (!first)
    {
      if (!parse())
      {
        this$0.update();
        first = true;
      }
    }
    else {
      throw new IllegalStateException("Can't initialize twice");
    }
  }
  
  protected abstract boolean parse();
  
  public final void remove()
  {
    if (!first)
    {
      zzaA();
      this$0.update();
      first = true;
      return;
    }
    throw new IllegalStateException("Can't initialize twice");
  }
  
  protected final void size()
  {
    if (write()) {
      return;
    }
    throw new IllegalStateException("Not initialized");
  }
  
  final boolean write()
  {
    return first;
  }
  
  protected void zzaA() {}
}
