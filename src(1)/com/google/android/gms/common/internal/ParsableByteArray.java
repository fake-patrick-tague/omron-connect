package com.google.android.gms.common.internal;

public final class ParsableByteArray
{
  private final boolean capacity;
  private final int data;
  private final String limit;
  private final String position;
  
  public ParsableByteArray(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    limit = paramString1;
    position = paramString2;
    data = paramInt;
    capacity = paramBoolean2;
  }
  
  final boolean capacity()
  {
    return capacity;
  }
  
  final String getPosition()
  {
    return position;
  }
  
  final String limit()
  {
    return limit;
  }
  
  final int readInt()
  {
    return data;
  }
}
