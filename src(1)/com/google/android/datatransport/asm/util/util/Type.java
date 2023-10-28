package com.google.android.datatransport.asm.util.util;

import com.google.android.datatransport.asm.Context;
import com.google.android.datatransport.asm.Item;

public abstract class Type
{
  public Type() {}
  
  public static Type get(long paramLong, Context paramContext, Item paramItem)
  {
    return new Label(paramLong, paramContext, paramItem);
  }
  
  public abstract Item get();
  
  public abstract long getFirst();
  
  public abstract Context getName();
}
