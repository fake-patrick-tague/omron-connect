package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.asm.util.util.m;
import java.util.concurrent.Executor;

public class Plot
{
  private final m a;
  private final c c;
  private final com.google.android.datatransport.asm.params.c d;
  private final Executor p;
  
  Plot(Executor paramExecutor, m paramM, c paramC, com.google.android.datatransport.asm.params.c paramC1)
  {
    p = paramExecutor;
    a = paramM;
    c = paramC;
    d = paramC1;
  }
  
  public void addListener()
  {
    p.execute(new Interpreter(this));
  }
}
