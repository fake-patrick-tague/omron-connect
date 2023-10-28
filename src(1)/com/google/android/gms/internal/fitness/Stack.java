package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.List;

@ShowFirstParty
public final class Stack
{
  public static int add(Object paramObject, List paramList)
  {
    if (paramObject == null) {
      return -1;
    }
    int i = paramList.indexOf(paramObject);
    if (i >= 0) {
      return i;
    }
    paramList.add(paramObject);
    return paramList.size() - 1;
  }
}
