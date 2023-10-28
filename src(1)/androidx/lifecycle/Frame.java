package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Frame
{
  private static Map<Class<?>, List<Constructor<? extends h>>> b = new HashMap();
  private static Map<Class<?>, Integer> c = new HashMap();
  
  private static int a(Class paramClass)
  {
    if (paramClass.getCanonicalName() == null) {
      return 1;
    }
    Object localObject1 = get(paramClass);
    if (localObject1 != null)
    {
      b.put(paramClass, Collections.singletonList(localObject1));
      return 2;
    }
    if (c.d.a(paramClass)) {
      return 1;
    }
    Object localObject2 = paramClass.getSuperclass();
    localObject1 = null;
    if (isPrimitive((Class)localObject2))
    {
      if (d((Class)localObject2) == 1) {
        return 1;
      }
      localObject1 = new ArrayList((Collection)b.get(localObject2));
    }
    Class[] arrayOfClass = paramClass.getInterfaces();
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Class localClass = arrayOfClass[i];
      if (isPrimitive(localClass))
      {
        if (d(localClass) == 1) {
          return 1;
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        ((List)localObject2).addAll((Collection)b.get(localClass));
        localObject1 = localObject2;
      }
      i += 1;
    }
    if (localObject1 != null)
    {
      b.put(paramClass, localObject1);
      return 2;
    }
    return 1;
  }
  
  static LayoutManager a(Object paramObject)
  {
    boolean bool1 = paramObject instanceof LayoutManager;
    boolean bool2 = paramObject instanceof m;
    if ((bool1) && (bool2)) {
      return new FullLifecycleObserverAdapter((m)paramObject, (LayoutManager)paramObject);
    }
    if (bool2) {
      return new FullLifecycleObserverAdapter((m)paramObject, null);
    }
    if (bool1) {
      return (LayoutManager)paramObject;
    }
    Object localObject = paramObject.getClass();
    if (d((Class)localObject) == 2)
    {
      localObject = (List)b.get(localObject);
      int j = ((List)localObject).size();
      int i = 0;
      if (j == 1) {
        return new SingleGeneratedAdapterObserver(get((Constructor)((List)localObject).get(0), paramObject));
      }
      Attribute[] arrayOfAttribute = new Attribute[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        arrayOfAttribute[i] = get((Constructor)((List)localObject).get(i), paramObject);
        i += 1;
      }
      return new CompositeGeneratedAdaptersObserver(arrayOfAttribute);
    }
    return new ReflectiveGenericLifecycleObserver(paramObject);
  }
  
  private static int d(Class paramClass)
  {
    Integer localInteger = (Integer)c.get(paramClass);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    int i = a(paramClass);
    c.put(paramClass, Integer.valueOf(i));
    return i;
  }
  
  private static Attribute get(Constructor paramConstructor, Object paramObject)
  {
    try
    {
      paramConstructor = paramConstructor.newInstance(new Object[] { paramObject });
      return (Attribute)paramConstructor;
    }
    catch (InvocationTargetException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
    catch (InstantiationException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
    catch (IllegalAccessException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
  }
  
  public static String get(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.replace(".", "_"));
    localStringBuilder.append("_LifecycleAdapter");
    return localStringBuilder.toString();
  }
  
  private static Constructor get(Class paramClass)
  {
    try
    {
      Object localObject1 = paramClass.getPackage();
      String str = paramClass.getCanonicalName();
      Object localObject2 = str;
      if (localObject1 != null) {
        localObject1 = ((Package)localObject1).getName();
      } else {
        localObject1 = "";
      }
      boolean bool = ((String)localObject1).isEmpty();
      if (!bool)
      {
        int i = ((String)localObject1).length();
        localObject2 = str.substring(i + 1);
      }
      str = get((String)localObject2);
      localObject2 = str;
      bool = ((String)localObject1).isEmpty();
      if (bool)
      {
        localObject1 = localObject2;
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(".");
        ((StringBuilder)localObject2).append(str);
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = Class.forName((String)localObject1);
      paramClass = ((Class)localObject1).getDeclaredConstructor(new Class[] { paramClass });
      bool = paramClass.isAccessible();
      if (!bool)
      {
        paramClass.setAccessible(true);
        return paramClass;
      }
    }
    catch (NoSuchMethodException paramClass)
    {
      throw new RuntimeException(paramClass);
      return null;
    }
    catch (ClassNotFoundException paramClass)
    {
      for (;;) {}
    }
    return paramClass;
  }
  
  private static boolean isPrimitive(Class paramClass)
  {
    return (paramClass != null) && (l.class.isAssignableFrom(paramClass));
  }
}
