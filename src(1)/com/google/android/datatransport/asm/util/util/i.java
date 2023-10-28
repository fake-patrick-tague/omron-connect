package com.google.android.datatransport.asm.util.util;

final class i
  extends f
{
  private final int a;
  private final long b;
  private final int d;
  private final long f;
  private final int h;
  
  private i(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3)
  {
    f = paramLong1;
    h = paramInt1;
    a = paramInt2;
    b = paramLong2;
    d = paramInt3;
  }
  
  int a()
  {
    return d;
  }
  
  int c()
  {
    return h;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof f))
    {
      paramObject = (f)paramObject;
      if ((f == paramObject.f()) && (h == paramObject.c()) && (a == paramObject.n()) && (b == paramObject.size()) && (d == paramObject.a())) {
        return true;
      }
    }
    return false;
  }
  
  long f()
  {
    return f;
  }
  
  public int hashCode()
  {
    long l = f;
    int i = (int)(l ^ l >>> 32);
    int j = h;
    int k = a;
    l = b;
    return ((((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ k) * 1000003 ^ (int)(l >>> 32 ^ l)) * 1000003 ^ d;
  }
  
  int n()
  {
    return a;
  }
  
  long size()
  {
    return b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EventStoreConfig{maxStorageSizeInBytes=");
    localStringBuilder.append(f);
    localStringBuilder.append(", loadBatchSize=");
    localStringBuilder.append(h);
    localStringBuilder.append(", criticalSectionEnterTimeoutMs=");
    localStringBuilder.append(a);
    localStringBuilder.append(", eventCleanUpAge=");
    localStringBuilder.append(b);
    localStringBuilder.append(", maxBlobByteSizePerRow=");
    localStringBuilder.append(d);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}
