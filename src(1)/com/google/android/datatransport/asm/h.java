package com.google.android.datatransport.asm;

import com.google.android.datatransport.Type;
import com.google.android.datatransport.a;
import com.google.android.datatransport.c;
import com.google.android.datatransport.d;
import com.google.android.datatransport.g;

final class h
  extends m
{
  private final d<?, byte[]> a;
  private final Type b;
  private final c<?> c;
  private final Context m;
  private final String s;
  
  private h(Context paramContext, String paramString, a paramA, g paramG, Type paramType)
  {
    m = paramContext;
    s = paramString;
    c = paramA;
    a = paramG;
    b = paramType;
  }
  
  public String d()
  {
    return s;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof m))
    {
      paramObject = (m)paramObject;
      if ((m.equals(paramObject.f())) && (s.equals(paramObject.d())) && (c.equals(paramObject.get())) && (a.equals(paramObject.getTitle())) && (b.equals(paramObject.getGroupId()))) {
        return true;
      }
    }
    return false;
  }
  
  public Context f()
  {
    return m;
  }
  
  a get()
  {
    return c;
  }
  
  public Type getGroupId()
  {
    return b;
  }
  
  g getTitle()
  {
    return a;
  }
  
  public int hashCode()
  {
    return ((((m.hashCode() ^ 0xF4243) * 1000003 ^ s.hashCode()) * 1000003 ^ c.hashCode()) * 1000003 ^ a.hashCode()) * 1000003 ^ b.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SendRequest{transportContext=");
    localStringBuilder.append(m);
    localStringBuilder.append(", transportName=");
    localStringBuilder.append(s);
    localStringBuilder.append(", event=");
    localStringBuilder.append(c);
    localStringBuilder.append(", transformer=");
    localStringBuilder.append(a);
    localStringBuilder.append(", encoding=");
    localStringBuilder.append(b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}
