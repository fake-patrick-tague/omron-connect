package com.google.android.gms.common.package_12.internal;

import com.google.android.gms.common.util.concurrent.NumberedThreadFactory;
import com.google.android.gms.internal.base.Optional;
import com.google.android.gms.internal.base.Target;
import java.util.concurrent.ExecutorService;

public final class zabj
{
  private static final ExecutorService executor = Target.getPriority().get(2, new NumberedThreadFactory("GAC_Executor"), 2);
  
  public static ExecutorService getExecutor()
  {
    return executor;
  }
}
