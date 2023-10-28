package com.google.android.datatransport.asm;

import java.util.Map;

final class Attribute
  extends Item
{
  private final long a;
  private final Integer b;
  private final Edge c;
  private final Map<String, String> data;
  private final String g;
  private final long index;
  
  private Attribute(String paramString, Integer paramInteger, Edge paramEdge, long paramLong1, long paramLong2, Map paramMap)
  {
    g = paramString;
    b = paramInteger;
    c = paramEdge;
    index = paramLong1;
    a = paramLong2;
    data = paramMap;
  }
  
  public long a()
  {
    return a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof Item))
    {
      paramObject = (Item)paramObject;
      if (g.equals(paramObject.getId()))
      {
        Integer localInteger = b;
        if ((localInteger == null ? paramObject.getValue() == null : localInteger.equals(paramObject.getValue())) && (c.equals(paramObject.getName())) && (index == paramObject.size()) && (a == paramObject.a()) && (data.equals(paramObject.getKey()))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public String getId()
  {
    return g;
  }
  
  protected Map getKey()
  {
    return data;
  }
  
  public Edge getName()
  {
    return c;
  }
  
  public Integer getValue()
  {
    return b;
  }
  
  public int hashCode()
  {
    int j = g.hashCode();
    Integer localInteger = b;
    int i;
    if (localInteger == null) {
      i = 0;
    } else {
      i = localInteger.hashCode();
    }
    int k = c.hashCode();
    long l = index;
    int m = (int)(l ^ l >>> 32);
    l = a;
    return (((((j ^ 0xF4243) * 1000003 ^ i) * 1000003 ^ k) * 1000003 ^ m) * 1000003 ^ (int)(l ^ l >>> 32)) * 1000003 ^ data.hashCode();
  }
  
  public long size()
  {
    return index;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EventInternal{transportName=");
    localStringBuilder.append(g);
    localStringBuilder.append(", code=");
    localStringBuilder.append(b);
    localStringBuilder.append(", encodedPayload=");
    localStringBuilder.append(c);
    localStringBuilder.append(", eventMillis=");
    localStringBuilder.append(index);
    localStringBuilder.append(", uptimeMillis=");
    localStringBuilder.append(a);
    localStringBuilder.append(", autoMetadata=");
    localStringBuilder.append(data);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}
