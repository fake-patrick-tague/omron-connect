package androidx.lifecycle;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Deprecated
final class c
{
  static c d = new c();
  private final Map<Class<?>, Boolean> a = new HashMap();
  private final Map<Class<?>, c.a> c = new HashMap();
  
  c() {}
  
  private ByteVector a(Class paramClass, Method[] paramArrayOfMethod)
  {
    Object localObject1 = paramClass.getSuperclass();
    HashMap localHashMap = new HashMap();
    if (localObject1 != null)
    {
      localObject1 = b((Class)localObject1);
      if (localObject1 != null) {
        localHashMap.putAll(a);
      }
    }
    localObject1 = paramClass.getInterfaces();
    int j = localObject1.length;
    int i = 0;
    Object localObject2;
    Object localObject3;
    while (i < j)
    {
      localObject2 = ba.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        a(localHashMap, (Handle)((Map.Entry)localObject3).getKey(), (Lifecycle.Event)((Map.Entry)localObject3).getValue(), paramClass);
      }
      i += 1;
    }
    if (paramArrayOfMethod == null) {
      paramArrayOfMethod = getMethod(paramClass);
    }
    int k = paramArrayOfMethod.length;
    j = 0;
    boolean bool = false;
    while (j < k)
    {
      localObject1 = paramArrayOfMethod[j];
      localObject3 = (Type)((Method)localObject1).getAnnotation(u.class);
      if (localObject3 != null)
      {
        localObject2 = ((Method)localObject1).getParameterTypes();
        if (localObject2.length > 0)
        {
          if (localObject2[0].isAssignableFrom(m.class)) {
            i = 1;
          } else {
            throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
          }
        }
        else {
          i = 0;
        }
        localObject3 = ((Type)localObject3).value();
        if (localObject2.length > 1) {
          if (localObject2[1].isAssignableFrom(Lifecycle.Event.class))
          {
            if (localObject3 == Lifecycle.Event.ON_ANY) {
              i = 2;
            } else {
              throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
            }
          }
          else {
            throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
          }
        }
        if (localObject2.length <= 2)
        {
          a(localHashMap, new Handle(i, (Method)localObject1), (Lifecycle.Event)localObject3, paramClass);
          bool = true;
        }
      }
      else
      {
        j += 1;
        continue;
      }
      throw new IllegalArgumentException("cannot have more than 2 params");
    }
    paramArrayOfMethod = new ByteVector(localHashMap);
    c.put(paramClass, paramArrayOfMethod);
    a.put(paramClass, Boolean.valueOf(bool));
    return paramArrayOfMethod;
  }
  
  private void a(Map paramMap, Handle paramHandle, Lifecycle.Event paramEvent, Class paramClass)
  {
    Lifecycle.Event localEvent = (Lifecycle.Event)paramMap.get(paramHandle);
    if ((localEvent != null) && (paramEvent != localEvent))
    {
      paramMap = d;
      paramHandle = new StringBuilder();
      paramHandle.append("Method ");
      paramHandle.append(paramMap.getName());
      paramHandle.append(" in ");
      paramHandle.append(paramClass.getName());
      paramHandle.append(" already declared with different @OnLifecycleEvent value: previous value ");
      paramHandle.append(localEvent);
      paramHandle.append(", new value ");
      paramHandle.append(paramEvent);
      throw new IllegalArgumentException(paramHandle.toString());
    }
    if (localEvent == null) {
      paramMap.put(paramHandle, paramEvent);
    }
  }
  
  private Method[] getMethod(Class paramClass)
  {
    try
    {
      paramClass = paramClass.getDeclaredMethods();
      return paramClass;
    }
    catch (NoClassDefFoundError paramClass)
    {
      throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", paramClass);
    }
  }
  
  boolean a(Class paramClass)
  {
    Object localObject = (Boolean)a.get(paramClass);
    if (localObject != null) {
      return ((Boolean)localObject).booleanValue();
    }
    localObject = getMethod(paramClass);
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if ((Type)localObject[i].getAnnotation(u.class) != null)
      {
        a(paramClass, (Method[])localObject);
        return true;
      }
      i += 1;
    }
    a.put(paramClass, Boolean.FALSE);
    return false;
  }
  
  ByteVector b(Class paramClass)
  {
    ByteVector localByteVector = (ByteVector)c.get(paramClass);
    if (localByteVector != null) {
      return localByteVector;
    }
    return a(paramClass, null);
  }
}
