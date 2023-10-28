package com.google.android.datatransport.asm.util.util;

import com.google.android.datatransport.asm.Context;
import com.google.android.datatransport.asm.Item;
import java.io.Closeable;

public abstract interface m
  extends Closeable
{
  public abstract Type a(Context paramContext, Item paramItem);
  
  public abstract boolean a(Context paramContext);
  
  public abstract void add(Iterable paramIterable);
  
  public abstract int e();
  
  public abstract Iterable e(Context paramContext);
  
  public abstract void e(Context paramContext, long paramLong);
  
  public abstract void e(Iterable paramIterable);
  
  public abstract Iterable f();
  
  public abstract long getValue(Context paramContext);
}
