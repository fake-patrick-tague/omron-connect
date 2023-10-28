package com.google.android.datatransport.asm;

import android.util.Base64;
import com.google.android.datatransport.Priority;

public abstract class Context
{
  public Context() {}
  
  public static Glide getInstance()
  {
    return new DfsBlockCache.Ref().get(Priority.C);
  }
  
  public Context get(Priority paramPriority)
  {
    return getInstance().get(getName()).get(paramPriority).get(get()).get();
  }
  
  public abstract byte[] get();
  
  public abstract String getName();
  
  public abstract Priority getValue();
  
  public boolean isPrimitive()
  {
    return get() != null;
  }
  
  public final String toString()
  {
    String str2 = getName();
    Priority localPriority = getValue();
    String str1;
    if (get() == null) {
      str1 = "";
    } else {
      str1 = Base64.encodeToString(get(), 2);
    }
    return String.format("TransportContext(%s, %s, %s)", new Object[] { str2, localPriority, str1 });
  }
}
