package com.google.android.datatransport.api.internal;

import com.google.android.datatransport.cct.internal.l;
import java.util.List;
import java.util.Objects;

final class GOST3410Parameters
  extends Item
{
  private final List<l> q;
  
  GOST3410Parameters(List paramList)
  {
    Objects.requireNonNull(paramList, "Null logRequests");
    q = paramList;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof Item))
    {
      paramObject = (Item)paramObject;
      return q.equals(paramObject.getQ());
    }
    return false;
  }
  
  public List getQ()
  {
    return q;
  }
  
  public int hashCode()
  {
    return q.hashCode() ^ 0xF4243;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BatchedLogRequest{logRequests=");
    localStringBuilder.append(q);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}
