package com.google.android.datatransport.asm.util;

import com.google.android.datatransport.asm.Context;
import com.google.android.datatransport.asm.util.util.m;
import com.google.android.datatransport.h.t;
import com.google.android.datatransport.runtime.backends.Label;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

public class i
  implements Menu
{
  private static final Logger log = Logger.getLogger(t.class.getName());
  private final m a;
  private final Label c;
  private final com.google.android.datatransport.runtime.scheduling.jobscheduling.c d;
  private final com.google.android.datatransport.asm.params.c f;
  private final Executor v;
  
  public i(Executor paramExecutor, Label paramLabel, com.google.android.datatransport.runtime.scheduling.jobscheduling.c paramC, m paramM, com.google.android.datatransport.asm.params.c paramC1)
  {
    v = paramExecutor;
    c = paramLabel;
    d = paramC;
    a = paramM;
    f = paramC1;
  }
  
  public void add(Context paramContext, com.google.android.datatransport.asm.Item paramItem, com.google.android.datatransport.Item paramItem1)
  {
    v.execute(new b(this, paramContext, paramItem1, paramItem));
  }
}
