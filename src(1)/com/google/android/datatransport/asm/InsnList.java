package com.google.android.datatransport.asm;

import java.util.Map;
import java.util.Objects;

final class InsnList
  extends ByteBufferList
{
  private Map<String, String> cache;
  private String first;
  private Integer last;
  private Edge next;
  private Long size;
  private Long value;
  
  InsnList() {}
  
  public ByteBufferList add(long paramLong)
  {
    size = Long.valueOf(paramLong);
    return this;
  }
  
  public ByteBufferList add(Edge paramEdge)
  {
    Objects.requireNonNull(paramEdge, "Null encodedPayload");
    next = paramEdge;
    return this;
  }
  
  public ByteBufferList add(Integer paramInteger)
  {
    last = paramInteger;
    return this;
  }
  
  public Item add()
  {
    Object localObject2 = first;
    Object localObject1 = "";
    if (localObject2 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(" transportName");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = localObject1;
    if (next == null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" encodedPayload");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    localObject1 = localObject2;
    if (size == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(" eventMillis");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = localObject1;
    if (value == null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" uptimeMillis");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    localObject1 = localObject2;
    if (cache == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(" autoMetadata");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if (((String)localObject1).isEmpty()) {
      return new Attribute(first, last, next, size.longValue(), value.longValue(), cache, null);
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Missing required properties:");
    ((StringBuilder)localObject2).append((String)localObject1);
    throw new IllegalStateException(((StringBuilder)localObject2).toString());
  }
  
  public ByteBufferList get(long paramLong)
  {
    value = Long.valueOf(paramLong);
    return this;
  }
  
  public ByteBufferList get(String paramString)
  {
    Objects.requireNonNull(paramString, "Null transportName");
    first = paramString;
    return this;
  }
  
  protected ByteBufferList get(Map paramMap)
  {
    Objects.requireNonNull(paramMap, "Null autoMetadata");
    cache = paramMap;
    return this;
  }
  
  protected Map get()
  {
    Map localMap = cache;
    if (localMap != null) {
      return localMap;
    }
    throw new IllegalStateException("Property \"autoMetadata\" has not been set");
  }
}
