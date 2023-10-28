package com.google.android.datatransport.asm.io;

public abstract interface Procedure4<TInput, TResult, TException extends Throwable>
{
  public abstract Object apply(Object paramObject)
    throws Throwable;
}
