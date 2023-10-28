package com.google.android.datatransport.asm.drm;

import android.util.SparseArray;
import com.google.android.datatransport.Priority;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class Frame
{
  private static SparseArray<Priority> a = new SparseArray();
  private static HashMap<Priority, Integer> c;
  
  static
  {
    Object localObject = new HashMap();
    c = (HashMap)localObject;
    ((HashMap)localObject).put(Priority.C, Integer.valueOf(0));
    c.put(Priority.F, Integer.valueOf(1));
    c.put(Priority.G, Integer.valueOf(2));
    localObject = c.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Priority localPriority = (Priority)((Iterator)localObject).next();
      a.append(((Integer)c.get(localPriority)).intValue(), localPriority);
    }
  }
  
  public static int get(Priority paramPriority)
  {
    Object localObject = (Integer)c.get(paramPriority);
    if (localObject != null) {
      return ((Integer)localObject).intValue();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("PriorityMapping is missing known Priority value ");
    ((StringBuilder)localObject).append(paramPriority);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public static Priority get(int paramInt)
  {
    Object localObject = (Priority)a.get(paramInt);
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unknown Priority for value ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
}
