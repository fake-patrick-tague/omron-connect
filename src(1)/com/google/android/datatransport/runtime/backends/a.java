package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

class a
  implements Label
{
  private final h b;
  private final Item g;
  private final Map<String, l> m = new HashMap();
  
  a(Context paramContext, h paramH)
  {
    this(new Item(paramContext), paramH);
  }
  
  a(Item paramItem, h paramH)
  {
    g = paramItem;
    b = paramH;
  }
  
  public e a(String paramString)
  {
    try
    {
      if (m.containsKey(paramString))
      {
        paramString = (e)m.get(paramString);
        return paramString;
      }
      Object localObject = g.a(paramString);
      if (localObject == null) {
        return null;
      }
      localObject = ((c)localObject).create(b.a(paramString));
      m.put(paramString, localObject);
      return localObject;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
}
