package com.google.android.datatransport.asm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class Item
{
  public Item() {}
  
  public static ByteBufferList get()
  {
    return new InsnList().get(new HashMap());
  }
  
  public final int a(String paramString)
  {
    paramString = (String)getKey().get(paramString);
    if (paramString == null) {
      return 0;
    }
    return Integer.valueOf(paramString).intValue();
  }
  
  public abstract long a();
  
  public ByteBufferList add()
  {
    return new InsnList().get(getId()).add(getValue()).add(getName()).add(size()).get(a()).get(new HashMap(getKey()));
  }
  
  public final Map getFields()
  {
    return Collections.unmodifiableMap(getKey());
  }
  
  public abstract String getId();
  
  protected abstract Map getKey();
  
  public abstract Edge getName();
  
  public final long getValue(String paramString)
  {
    paramString = (String)getKey().get(paramString);
    if (paramString == null) {
      return 0L;
    }
    return Long.valueOf(paramString).longValue();
  }
  
  public abstract Integer getValue();
  
  public abstract long size();
  
  public final String toString(String paramString)
  {
    paramString = (String)getKey().get(paramString);
    if (paramString == null) {
      return "";
    }
    return paramString;
  }
}
