package com.google.android.gms.common.package_12.internal;

import com.google.android.gms.common.util.concurrent.NumberedThreadFactory;
import com.google.android.gms.internal.base.Optional;
import com.google.android.gms.internal.base.Target;
import java.util.concurrent.ExecutorService;

public final class zaco
{
  private static final ExecutorService mExecutor = Target.getPriority().toString(new NumberedThreadFactory("GAC_Transform"), 1);
  
  public static ExecutorService access$getMExecutor()
  {
    return mExecutor;
  }
}
