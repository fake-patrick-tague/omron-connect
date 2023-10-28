package com.google.android.gms.measurement.internal;

abstract class zzkn
  extends zzkm
{
  private boolean value;
  
  zzkn(zzkz paramZzkz)
  {
    super(paramZzkz);
    this$0.generate();
  }
  
  public final void inc()
  {
    if (!value)
    {
      registerAlarm();
      this$0.assemble();
      value = true;
      return;
    }
    throw new IllegalStateException("Can't initialize twice");
  }
  
  final boolean isReference()
  {
    return value;
  }
  
  protected abstract boolean registerAlarm();
  
  protected final void size()
  {
    if (isReference()) {
      return;
    }
    throw new IllegalStateException("Not initialized");
  }
}
