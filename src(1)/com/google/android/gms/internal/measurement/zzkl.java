package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.RandomAccess;

public abstract interface zzkl
  extends List, RandomAccess
{
  public abstract boolean get();
  
  public abstract void inc();
  
  public abstract zzkl trim(int paramInt);
}
