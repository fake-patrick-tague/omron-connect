package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.h.j;
import java.util.Objects;

final class MethodWriter
  extends ExtensionData
{
  private byte[] s;
  private Iterable<j> t;
  
  MethodWriter() {}
  
  public ExtensionData a(Iterable paramIterable)
  {
    Objects.requireNonNull(paramIterable, "Null events");
    t = paramIterable;
    return this;
  }
  
  public d a()
  {
    Object localObject2 = t;
    Object localObject1 = "";
    if (localObject2 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(" events");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if (((String)localObject1).isEmpty()) {
      return new Handle(t, s, null);
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Missing required properties:");
    ((StringBuilder)localObject2).append((String)localObject1);
    throw new IllegalStateException(((StringBuilder)localObject2).toString());
  }
  
  public ExtensionData b(byte[] paramArrayOfByte)
  {
    s = paramArrayOfByte;
    return this;
  }
}
