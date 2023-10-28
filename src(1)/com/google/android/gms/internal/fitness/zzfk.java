package com.google.android.gms.internal.fitness;

import java.util.Set;

public final class zzfk
{
  static boolean equalsSetHelper(Set paramSet, Object paramObject)
  {
    if (paramSet == paramObject) {
      return true;
    }
    if ((paramObject instanceof Set)) {
      paramObject = (Set)paramObject;
    }
    try
    {
      int i = paramSet.size();
      int j = paramObject.size();
      if (i != j) {
        break label60;
      }
      boolean bool = paramSet.containsAll(paramObject);
      if (!bool) {
        break label60;
      }
      return true;
    }
    catch (NullPointerException paramSet)
    {
      return false;
    }
    catch (ClassCastException paramSet) {}
    return false;
    label60:
    return false;
  }
}
