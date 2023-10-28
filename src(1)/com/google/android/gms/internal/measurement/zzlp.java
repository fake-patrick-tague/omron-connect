package com.google.android.gms.internal.measurement;

import java.io.IOException;

final class zzlp
  implements zzlw
{
  private final boolean a;
  private final zzjr b;
  private final zzll d;
  private final zzmn y;
  
  private zzlp(zzmn paramZzmn, zzjr paramZzjr, zzll paramZzll)
  {
    y = paramZzmn;
    a = paramZzjr.accepts(paramZzll);
    b = paramZzjr;
    d = paramZzll;
  }
  
  static zzlp construct(zzmn paramZzmn, zzjr paramZzjr, zzll paramZzll)
  {
    return new zzlp(paramZzmn, paramZzjr, paramZzll);
  }
  
  public final void a(Object paramObject, zznf paramZznf)
    throws IOException
  {
    b.invoke(paramObject);
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void a(Object paramObject1, Object paramObject2)
  {
    zzly.operate(y, paramObject1, paramObject2);
    if (a) {
      zzly.invoke(b, paramObject1, paramObject2);
    }
  }
  
  public final void add(Object paramObject)
  {
    y.subtract(paramObject);
    b.addLast(paramObject);
  }
  
  public final int b(Object paramObject)
  {
    zzmn localZzmn = y;
    int i = localZzmn.a(localZzmn.getValue(paramObject));
    if (!a) {
      return i;
    }
    b.invoke(paramObject);
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void b(Object paramObject, byte[] paramArrayOfByte, int paramInt1, int paramInt2, zziq paramZziq)
    throws IOException
  {
    paramArrayOfByte = (zzke)paramObject;
    if (f == zzmo.e()) {
      f = zzmo.a();
    }
    paramObject = (zzkb)paramObject;
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final boolean b(Object paramObject1, Object paramObject2)
  {
    if (!y.getValue(paramObject1).equals(y.getValue(paramObject2))) {
      return false;
    }
    if (!a) {
      return true;
    }
    b.invoke(paramObject1);
    b.invoke(paramObject2);
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final Object c()
  {
    return d.zzbF().zzaG();
  }
  
  public final int doInBackground(Object paramObject)
  {
    int i = y.getValue(paramObject).hashCode();
    if (!a) {
      return i;
    }
    b.invoke(paramObject);
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final boolean parse(Object paramObject)
  {
    b.invoke(paramObject);
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
}
