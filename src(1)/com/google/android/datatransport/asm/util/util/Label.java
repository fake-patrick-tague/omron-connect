package com.google.android.datatransport.asm.util.util;

import com.google.android.datatransport.asm.Context;
import com.google.android.datatransport.asm.Item;
import java.util.Objects;

final class Label
  extends Type
{
  private final long a;
  private final Context c;
  private final Item name;
  
  Label(long paramLong, Context paramContext, Item paramItem)
  {
    a = paramLong;
    Objects.requireNonNull(paramContext, "Null transportContext");
    c = paramContext;
    Objects.requireNonNull(paramItem, "Null event");
    name = paramItem;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof Type))
    {
      paramObject = (Type)paramObject;
      if ((a == paramObject.getFirst()) && (c.equals(paramObject.getName())) && (name.equals(paramObject.get()))) {
        return true;
      }
    }
    return false;
  }
  
  public Item get()
  {
    return name;
  }
  
  public long getFirst()
  {
    return a;
  }
  
  public Context getName()
  {
    return c;
  }
  
  public int hashCode()
  {
    long l = a;
    return (((int)(l ^ l >>> 32) ^ 0xF4243) * 1000003 ^ c.hashCode()) * 1000003 ^ name.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PersistedEvent{id=");
    localStringBuilder.append(a);
    localStringBuilder.append(", transportContext=");
    localStringBuilder.append(c);
    localStringBuilder.append(", event=");
    localStringBuilder.append(name);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}
