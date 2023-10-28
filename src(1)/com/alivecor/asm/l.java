package com.alivecor.asm;

import com.alivecor.ai.v;
import g.a.a;

public final class l
{
  private final a<v> b;
  private final a<com.alivecor.ai.l> c;
  
  public l(a paramA1, a paramA2)
  {
    c = paramA1;
    b = paramA2;
  }
  
  public static aa a(c paramC, f paramF)
  {
    return new aa(paramC, paramF);
  }
  
  public static l onSubMenuSelected(a paramA1, a paramA2)
  {
    return new l(paramA1, paramA2);
  }
  
  public aa a()
  {
    return a((c)c.get(), (f)b.get());
  }
}
