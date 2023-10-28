package androidx.work.impl.asm;

import androidx.work.BackoffPolicy;
import androidx.work.Label;
import androidx.work.Log;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.WorkInfo.State;
import androidx.work.i;
import androidx.work.impl.n.p;
import androidx.work.impl.n.p.c;
import c.b.a.c.a;
import java.util.List;

public final class h
{
  public static final a<List<p.c>, List<WorkInfo>> k = new RRuleSchema.28();
  private static final String q = Log.getInstance("WorkSpec");
  public String a;
  public i b;
  public Label c;
  public BackoffPolicy d;
  public int e;
  public long f;
  public long g;
  public boolean h;
  public long i;
  public long j;
  public long l;
  public String m;
  public long n;
  public WorkInfo.State p = WorkInfo.State.a;
  public Label s;
  public long w;
  public String x;
  public OutOfQuotaPolicy y;
  
  public h(h paramH)
  {
    Label localLabel = Label.c;
    c = localLabel;
    s = localLabel;
    b = i.a;
    d = BackoffPolicy.c;
    f = 30000L;
    g = -1L;
    y = OutOfQuotaPolicy.a;
    a = a;
    x = x;
    p = p;
    m = m;
    c = new Label(c);
    s = new Label(s);
    n = n;
    j = j;
    i = i;
    b = new i(b);
    e = e;
    d = d;
    f = f;
    w = w;
    l = l;
    g = g;
    h = h;
    y = y;
  }
  
  public h(String paramString1, String paramString2)
  {
    Label localLabel = Label.c;
    c = localLabel;
    s = localLabel;
    b = i.a;
    d = BackoffPolicy.c;
    f = 30000L;
    g = -1L;
    y = OutOfQuotaPolicy.a;
    a = paramString1;
    x = paramString2;
  }
  
  public long a()
  {
    boolean bool = c();
    int i2 = 0;
    int i1 = 0;
    if (bool)
    {
      if (d == BackoffPolicy.b) {
        i1 = 1;
      }
      if (i1 != 0) {
        l1 = f * e;
      } else {
        l1 = Math.scalb((float)f, e - 1);
      }
      return w + Math.min(18000000L, l1);
    }
    bool = j();
    long l2 = 0L;
    if (bool)
    {
      l1 = System.currentTimeMillis();
      long l3 = w;
      if (l3 == 0L) {
        l1 += n;
      } else {
        l1 = l3;
      }
      long l5 = i;
      long l4 = j;
      i1 = i2;
      if (l5 != l4) {
        i1 = 1;
      }
      if (i1 != 0)
      {
        if (l3 == 0L) {
          l2 = l5 * -1L;
        }
        return l1 + l4 + l2;
      }
      if (l3 != 0L) {
        l2 = l4;
      }
      return l1 + l2;
    }
    l2 = w;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = System.currentTimeMillis();
    }
    return l1 + n;
  }
  
  public void a(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong < 900000L)
    {
      Log.get().add(q, String.format("Interval duration lesser than minimum allowed value; Changed to %s", new Object[] { Long.valueOf(900000L) }), new Throwable[0]);
      l1 = 900000L;
    }
    a(l1, l1);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    long l1 = paramLong1;
    if (paramLong1 < 900000L)
    {
      Log.get().add(q, String.format("Interval duration lesser than minimum allowed value; Changed to %s", new Object[] { Long.valueOf(900000L) }), new Throwable[0]);
      l1 = 900000L;
    }
    paramLong1 = paramLong2;
    if (paramLong2 < 300000L)
    {
      Log.get().add(q, String.format("Flex duration lesser than minimum allowed value; Changed to %s", new Object[] { Long.valueOf(300000L) }), new Throwable[0]);
      paramLong1 = 300000L;
    }
    paramLong2 = paramLong1;
    if (paramLong1 > l1)
    {
      Log.get().add(q, String.format("Flex duration greater than interval duration; Changed to %s", new Object[] { Long.valueOf(l1) }), new Throwable[0]);
      paramLong2 = l1;
    }
    j = l1;
    i = paramLong2;
  }
  
  public boolean b()
  {
    return i.a.equals(b) ^ true;
  }
  
  public boolean c()
  {
    return (p == WorkInfo.State.a) && (e > 0);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (p.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (h)paramObject;
      if (n != n) {
        return false;
      }
      if (j != j) {
        return false;
      }
      if (i != i) {
        return false;
      }
      if (e != e) {
        return false;
      }
      if (f != f) {
        return false;
      }
      if (w != w) {
        return false;
      }
      if (l != l) {
        return false;
      }
      if (g != g) {
        return false;
      }
      if (h != h) {
        return false;
      }
      if (!a.equals(a)) {
        return false;
      }
      if (p != p) {
        return false;
      }
      if (!x.equals(x)) {
        return false;
      }
      String str = m;
      if (str != null)
      {
        if (!str.equals(m)) {
          return false;
        }
      }
      else if (m != null) {
        return false;
      }
      if (!c.equals(c)) {
        return false;
      }
      if (!s.equals(s)) {
        return false;
      }
      if (!b.equals(b)) {
        return false;
      }
      if (d != d) {
        return false;
      }
      if (y == y) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public boolean j()
  {
    return j != 0L;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{WorkSpec: ");
    localStringBuilder.append(a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}
