package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.BaseBundle;
import android.os.Bundle;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import v7.graphics.g;

public final class f
{
  private static final Object b = new Object();
  private static volatile f o;
  final Map<Class<?>, Object> a;
  final Context c;
  final Set<Class<? extends b<?>>> f;
  
  f(Context paramContext)
  {
    c = paramContext.getApplicationContext();
    f = new HashSet();
    a = new HashMap();
  }
  
  public static f a(Context paramContext)
  {
    if (o == null)
    {
      Object localObject = b;
      try
      {
        if (o == null) {
          o = new f(paramContext);
        }
      }
      catch (Throwable paramContext)
      {
        throw paramContext;
      }
    }
    return o;
  }
  
  private Object a(Class paramClass, Set paramSet)
  {
    if (g.c()) {}
    try
    {
      g.a(paramClass.getSimpleName());
      boolean bool = paramSet.contains(paramClass);
      if (!bool)
      {
        bool = a.containsKey(paramClass);
        if (!bool)
        {
          paramSet.add(paramClass);
          try
          {
            Object localObject1 = (c)paramClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            Object localObject2 = ((c)localObject1).getCandidates();
            bool = ((List)localObject2).isEmpty();
            if (!bool)
            {
              localObject2 = ((List)localObject2).iterator();
              for (;;)
              {
                bool = ((Iterator)localObject2).hasNext();
                if (!bool) {
                  break;
                }
                Class localClass = (Class)((Iterator)localObject2).next();
                bool = a.containsKey(localClass);
                if (!bool) {
                  a(localClass, paramSet);
                }
              }
            }
            localObject2 = ((c)localObject1).b(c);
            localObject1 = localObject2;
            paramSet.remove(paramClass);
            a.put(paramClass, localObject2);
            paramClass = (Class)localObject1;
          }
          catch (Throwable paramClass)
          {
            throw new CollapsingToolbarLayout(paramClass);
          }
        }
        paramClass = a.get(paramClass);
        g.onSaveInstanceState();
        return paramClass;
      }
      throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", new Object[] { paramClass.getName() }));
    }
    catch (Throwable paramClass)
    {
      g.onSaveInstanceState();
      throw paramClass;
    }
  }
  
  Object a(Class paramClass)
  {
    Object localObject3 = b;
    try
    {
      Object localObject2 = a.get(paramClass);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = a(paramClass, new HashSet());
      }
      return localObject1;
    }
    catch (Throwable paramClass)
    {
      throw paramClass;
    }
  }
  
  void a()
  {
    try
    {
      g.a("Startup");
      Object localObject = c;
      localObject = ((Context)localObject).getPackageName();
      localObject = new ComponentName((String)localObject, InitializationProvider.class.getName());
      Context localContext = c;
      localObject = localContext.getPackageManager().getProviderInfo((ComponentName)localObject, 128);
      localObject = metaData;
      a((Bundle)localObject);
      g.onSaveInstanceState();
      return;
    }
    catch (Throwable localThrowable) {}catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      throw new CollapsingToolbarLayout(localNameNotFoundException);
    }
    g.onSaveInstanceState();
    throw localNameNotFoundException;
  }
  
  void a(Bundle paramBundle)
  {
    Object localObject1 = c.getString(ClassReader.d);
    if (paramBundle != null) {
      try
      {
        HashSet localHashSet = new HashSet();
        Iterator localIterator = paramBundle.keySet().iterator();
        boolean bool;
        for (;;)
        {
          bool = localIterator.hasNext();
          if (!bool) {
            break;
          }
          Object localObject2 = localIterator.next();
          localObject2 = (String)localObject2;
          bool = ((String)localObject1).equals(paramBundle.getString((String)localObject2, null));
          if (bool)
          {
            localObject2 = Class.forName((String)localObject2);
            bool = b.class.isAssignableFrom((Class)localObject2);
            if (bool)
            {
              Set localSet = f;
              localSet.add(localObject2);
            }
          }
        }
        paramBundle = f;
        paramBundle = paramBundle.iterator();
        for (;;)
        {
          bool = paramBundle.hasNext();
          if (!bool) {
            break;
          }
          localObject1 = paramBundle.next();
          localObject1 = (Class)localObject1;
          a((Class)localObject1, localHashSet);
        }
        return;
      }
      catch (ClassNotFoundException paramBundle)
      {
        throw new CollapsingToolbarLayout(paramBundle);
      }
    }
  }
  
  public boolean add(Class paramClass)
  {
    return f.contains(paramClass);
  }
  
  public Object b(Class paramClass)
  {
    return a(paramClass);
  }
}
