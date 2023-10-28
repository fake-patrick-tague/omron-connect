package androidx.fragment.package_11;

import c.e.g;
import v7.util.SimpleArrayMap;

public class Loader
{
  private static final g<ClassLoader, g<String, Class<?>>> caches = new SimpleArrayMap();
  
  public Loader() {}
  
  public static Class forName(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      paramClassLoader = loadClass(paramClassLoader, paramString);
      return paramClassLoader;
    }
    catch (ClassCastException paramClassLoader)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to instantiate fragment ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(": make sure class is a valid subclass of Fragment");
      throw new Fragment.l(localStringBuilder.toString(), paramClassLoader);
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to instantiate fragment ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(": make sure class name exists");
      throw new Fragment.l(localStringBuilder.toString(), paramClassLoader);
    }
  }
  
  static boolean load(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      paramClassLoader = loadClass(paramClassLoader, paramString);
      boolean bool = androidx.fragment.app.Fragment.class.isAssignableFrom(paramClassLoader);
      return bool;
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      for (;;) {}
    }
    return false;
  }
  
  private static Class loadClass(ClassLoader paramClassLoader, String paramString)
    throws ClassNotFoundException
  {
    Object localObject3 = caches;
    Object localObject2 = (SimpleArrayMap)((SimpleArrayMap)localObject3).get(paramClassLoader);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new SimpleArrayMap();
      ((SimpleArrayMap)localObject3).put(paramClassLoader, localObject1);
    }
    localObject3 = (Class)((SimpleArrayMap)localObject1).get(paramString);
    localObject2 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = Class.forName(paramString, false, paramClassLoader);
      ((SimpleArrayMap)localObject1).put(paramString, localObject2);
    }
    return localObject2;
  }
  
  public Fragment instantiate(ClassLoader paramClassLoader, String paramString)
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
}
