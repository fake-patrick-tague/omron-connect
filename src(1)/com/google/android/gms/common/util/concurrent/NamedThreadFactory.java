package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@KeepForSdk
public class NamedThreadFactory
  implements ThreadFactory
{
  private final ThreadFactory baseFactory = Executors.defaultThreadFactory();
  private final String mName;
  
  public NamedThreadFactory(String paramString)
  {
    Preconditions.checkNotNull(paramString, "Name must not be null");
    mName = paramString;
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = baseFactory.newThread(new PriorityThreadFactory.1(paramRunnable, 0));
    paramRunnable.setName(mName);
    return paramRunnable;
  }
}
