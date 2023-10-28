package com.google.android.gms.internal.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

public abstract interface Optional
{
  public abstract ExecutorService get(int paramInt1, ThreadFactory paramThreadFactory, int paramInt2);
  
  public abstract ExecutorService toString(int paramInt1, int paramInt2);
  
  public abstract ExecutorService toString(ThreadFactory paramThreadFactory, int paramInt);
}
