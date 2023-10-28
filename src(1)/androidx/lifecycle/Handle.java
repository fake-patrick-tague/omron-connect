package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Deprecated
final class Handle
{
  final int c;
  final Method d;
  
  Handle(int paramInt, Method paramMethod)
  {
    c = paramInt;
    d = paramMethod;
    paramMethod.setAccessible(true);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Handle)) {
      return false;
    }
    paramObject = (Handle)paramObject;
    return (c == c) && (d.getName().equals(d.getName()));
  }
  
  public int hashCode()
  {
    return c * 31 + d.getName().hashCode();
  }
  
  void toString(d paramD, Lifecycle.Event paramEvent, Object paramObject)
  {
    int i = c;
    Method localMethod;
    if (i != 0) {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        localMethod = d;
      }
    }
    try
    {
      localMethod.invoke(paramObject, new Object[] { paramD, paramEvent });
      return;
    }
    catch (IllegalAccessException paramD)
    {
      throw new RuntimeException(paramD);
    }
    catch (InvocationTargetException paramD)
    {
      throw new RuntimeException("Failed to call observer method", paramD.getCause());
    }
    paramEvent = d;
    paramEvent.invoke(paramObject, new Object[] { paramD });
    return;
    paramD = d;
    paramD.invoke(paramObject, new Object[0]);
  }
}
