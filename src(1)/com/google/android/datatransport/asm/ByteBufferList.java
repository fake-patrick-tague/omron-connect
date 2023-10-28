package com.google.android.datatransport.asm;

import java.util.Map;

public abstract class ByteBufferList
{
  public ByteBufferList() {}
  
  public abstract ByteBufferList add(long paramLong);
  
  public abstract ByteBufferList add(Edge paramEdge);
  
  public abstract ByteBufferList add(Integer paramInteger);
  
  public final ByteBufferList add(String paramString, int paramInt)
  {
    get().put(paramString, String.valueOf(paramInt));
    return this;
  }
  
  public final ByteBufferList add(String paramString, long paramLong)
  {
    get().put(paramString, String.valueOf(paramLong));
    return this;
  }
  
  public abstract Item add();
  
  public final ByteBufferList append(String paramString1, String paramString2)
  {
    get().put(paramString1, paramString2);
    return this;
  }
  
  public abstract ByteBufferList get(long paramLong);
  
  public abstract ByteBufferList get(String paramString);
  
  protected abstract ByteBufferList get(Map paramMap);
  
  protected abstract Map get();
}
