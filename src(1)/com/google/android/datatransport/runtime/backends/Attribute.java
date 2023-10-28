package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.asm.asm.Label;
import java.util.Objects;

final class Attribute
  extends Type
{
  private final Context a;
  private final Label b;
  private final Label c;
  private final String name;
  
  Attribute(Context paramContext, Label paramLabel1, Label paramLabel2, String paramString)
  {
    Objects.requireNonNull(paramContext, "Null applicationContext");
    a = paramContext;
    Objects.requireNonNull(paramLabel1, "Null wallClock");
    b = paramLabel1;
    Objects.requireNonNull(paramLabel2, "Null monotonicClock");
    c = paramLabel2;
    Objects.requireNonNull(paramString, "Null backendName");
    name = paramString;
  }
  
  public Label a()
  {
    return b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof Type))
    {
      paramObject = (Type)paramObject;
      if ((a.equals(paramObject.getValue())) && (b.equals(paramObject.a())) && (c.equals(paramObject.getName())) && (name.equals(paramObject.getKey()))) {
        return true;
      }
    }
    return false;
  }
  
  public String getKey()
  {
    return name;
  }
  
  public Label getName()
  {
    return c;
  }
  
  public Context getValue()
  {
    return a;
  }
  
  public int hashCode()
  {
    return (((a.hashCode() ^ 0xF4243) * 1000003 ^ b.hashCode()) * 1000003 ^ c.hashCode()) * 1000003 ^ name.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CreationContext{applicationContext=");
    localStringBuilder.append(a);
    localStringBuilder.append(", wallClock=");
    localStringBuilder.append(b);
    localStringBuilder.append(", monotonicClock=");
    localStringBuilder.append(c);
    localStringBuilder.append(", backendName=");
    localStringBuilder.append(name);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}
