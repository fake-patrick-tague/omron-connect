package com.google.android.datatransport.asm;

import com.google.android.datatransport.Type;
import com.google.android.datatransport.a;
import com.google.android.datatransport.c;
import com.google.android.datatransport.d;
import com.google.android.datatransport.g;
import java.util.Objects;

final class XYPlot
  extends ByteVector
{
  private c<?> c;
  private d<?, byte[]> d;
  private String g;
  private Type i;
  private Context l;
  
  XYPlot() {}
  
  ByteVector a(a paramA)
  {
    Objects.requireNonNull(paramA, "Null event");
    c = paramA;
    return this;
  }
  
  public ByteVector a(Context paramContext)
  {
    Objects.requireNonNull(paramContext, "Null transportContext");
    l = paramContext;
    return this;
  }
  
  ByteVector a(g paramG)
  {
    Objects.requireNonNull(paramG, "Null transformer");
    d = paramG;
    return this;
  }
  
  public ByteVector a(String paramString)
  {
    Objects.requireNonNull(paramString, "Null transportName");
    g = paramString;
    return this;
  }
  
  public m a()
  {
    Object localObject2 = l;
    Object localObject1 = "";
    if (localObject2 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(" transportContext");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = localObject1;
    if (g == null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" transportName");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    localObject1 = localObject2;
    if (c == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(" event");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = localObject1;
    if (d == null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" transformer");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    localObject1 = localObject2;
    if (i == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(" encoding");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if (((String)localObject1).isEmpty()) {
      return new h(l, g, c, d, i, null);
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Missing required properties:");
    ((StringBuilder)localObject2).append((String)localObject1);
    throw new IllegalStateException(((StringBuilder)localObject2).toString());
  }
  
  ByteVector b(Type paramType)
  {
    Objects.requireNonNull(paramType, "Null encoding");
    i = paramType;
    return this;
  }
}
