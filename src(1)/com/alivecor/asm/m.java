package com.alivecor.asm;

import android.content.Context;

public final class m
{
  private final g.a.a<Context> c;
  
  public m(g.a.a paramA)
  {
    c = paramA;
  }
  
  public static m a(g.a.a paramA)
  {
    return new m(paramA);
  }
  
  public static a i(Context paramContext)
  {
    return new a(paramContext);
  }
  
  public a i()
  {
    return i((Context)c.get());
  }
}
