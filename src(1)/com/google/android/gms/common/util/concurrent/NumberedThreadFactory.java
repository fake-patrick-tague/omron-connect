package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@KeepForSdk
public class NumberedThreadFactory
  implements ThreadFactory
{
  private final ThreadFactory group = Executors.defaultThreadFactory();
  private final String namePrefix;
  private final AtomicInteger threadNumber = new AtomicInteger();
  
  public NumberedThreadFactory(String paramString)
  {
    Preconditions.checkNotNull(paramString, "Name must not be null");
    namePrefix = paramString;
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = group.newThread(new PriorityThreadFactory.1(paramRunnable, 0));
    String str = namePrefix;
    int i = threadNumber.getAndIncrement();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("[");
    localStringBuilder.append(i);
    localStringBuilder.append("]");
    paramRunnable.setName(localStringBuilder.toString());
    return paramRunnable;
  }
}
