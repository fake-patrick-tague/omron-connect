package com.google.android.datatransport.asm;

import com.google.android.datatransport.Priority;
import java.util.Arrays;

final class MultiMap
  extends Context
{
  private final byte[] key;
  private final String username;
  private final Priority values;
  
  private MultiMap(String paramString, byte[] paramArrayOfByte, Priority paramPriority)
  {
    username = paramString;
    key = paramArrayOfByte;
    values = paramPriority;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof Context))
    {
      Context localContext = (Context)paramObject;
      if (username.equals(localContext.getName()))
      {
        byte[] arrayOfByte = key;
        if ((localContext instanceof MultiMap)) {
          paramObject = key;
        } else {
          paramObject = localContext.get();
        }
        if ((Arrays.equals(arrayOfByte, paramObject)) && (values.equals(localContext.getValue()))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public byte[] get()
  {
    return key;
  }
  
  public String getName()
  {
    return username;
  }
  
  public Priority getValue()
  {
    return values;
  }
  
  public int hashCode()
  {
    return ((username.hashCode() ^ 0xF4243) * 1000003 ^ Arrays.hashCode(key)) * 1000003 ^ values.hashCode();
  }
}
