package androidx.work;

import android.os.Build.VERSION;

public final class i
{
  public static final i a = new e().a();
  private boolean b;
  private NetworkType c = NetworkType.c;
  private long e = -1L;
  private boolean f;
  private Type g = new Type();
  private boolean h;
  private boolean i;
  private long n = -1L;
  
  public i() {}
  
  i(e paramE)
  {
    b = a;
    int j = Build.VERSION.SDK_INT;
    boolean bool;
    if ((j >= 23) && (b)) {
      bool = true;
    } else {
      bool = false;
    }
    f = bool;
    c = c;
    i = i;
    h = h;
    if (j >= 24)
    {
      g = g;
      n = f;
      e = e;
    }
  }
  
  public i(i paramI)
  {
    b = b;
    f = f;
    c = c;
    i = i;
    h = h;
    g = g;
  }
  
  public void a(long paramLong)
  {
    n = paramLong;
  }
  
  public void a(boolean paramBoolean)
  {
    f = paramBoolean;
  }
  
  public boolean a()
  {
    return h;
  }
  
  public Type add()
  {
    return g;
  }
  
  public void add(Type paramType)
  {
    g = paramType;
  }
  
  public void b(long paramLong)
  {
    e = paramLong;
  }
  
  public void b(NetworkType paramNetworkType)
  {
    c = paramNetworkType;
  }
  
  public void b(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public boolean b()
  {
    return g.get() > 0;
  }
  
  public boolean c()
  {
    return i;
  }
  
  public long e()
  {
    return e;
  }
  
  public void e(boolean paramBoolean)
  {
    h = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (b.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (i)paramObject;
      if (b != b) {
        return false;
      }
      if (f != f) {
        return false;
      }
      if (i != i) {
        return false;
      }
      if (h != h) {
        return false;
      }
      if (n != n) {
        return false;
      }
      if (e != e) {
        return false;
      }
      if (c != c) {
        return false;
      }
      return g.equals(g);
    }
    return false;
  }
  
  public boolean f()
  {
    return f;
  }
  
  public void g(boolean paramBoolean)
  {
    i = paramBoolean;
  }
  
  public boolean g()
  {
    return b;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public NetworkType p()
  {
    return c;
  }
  
  public long size()
  {
    return n;
  }
}
