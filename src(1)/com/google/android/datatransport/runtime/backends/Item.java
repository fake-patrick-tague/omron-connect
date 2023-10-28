package com.google.android.datatransport.runtime.backends;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.BaseBundle;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Item
{
  private Map<String, String> c = null;
  private final Context j;
  
  Item(Context paramContext)
  {
    j = paramContext;
  }
  
  private Map a()
  {
    if (c == null) {
      c = parse(j);
    }
    return c;
  }
  
  private static Bundle load(Context paramContext)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      if (localPackageManager == null)
      {
        Log.w("BackendRegistry", "Context has no PackageManager.");
        return null;
      }
      paramContext = localPackageManager.getServiceInfo(new ComponentName(paramContext, TransportBackendDiscovery.class), 128);
      if (paramContext == null)
      {
        Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
        return null;
      }
      return metaData;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    Log.w("BackendRegistry", "Application info not found.");
    return null;
  }
  
  private Map parse(Context paramContext)
  {
    paramContext = load(paramContext);
    if (paramContext == null)
    {
      Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
      return Collections.emptyMap();
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramContext.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      Object localObject = paramContext.get(str1);
      if (((localObject instanceof String)) && (str1.startsWith("backend:")))
      {
        localObject = ((String)localObject).split(",", -1);
        int k = localObject.length;
        int i = 0;
        while (i < k)
        {
          String str2 = localObject[i].trim();
          if (!str2.isEmpty()) {
            localHashMap.put(str2, str1.substring(8));
          }
          i += 1;
        }
      }
    }
    return localHashMap;
  }
  
  c a(String paramString)
  {
    paramString = (String)a().get(paramString);
    if (paramString == null) {
      return null;
    }
    try
    {
      Object localObject = Class.forName(paramString).asSubclass(d.class);
      localObject = ((Class)localObject).getDeclaredConstructor(new Class[0]);
      localObject = ((Constructor)localObject).newInstance(new Object[0]);
      return (c)localObject;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Log.w("BackendRegistry", String.format("Could not instantiate %s", new Object[] { paramString }), localInvocationTargetException);
      return null;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Log.w("BackendRegistry", String.format("Could not instantiate %s", new Object[] { paramString }), localNoSuchMethodException);
      return null;
    }
    catch (InstantiationException localInstantiationException)
    {
      Log.w("BackendRegistry", String.format("Could not instantiate %s.", new Object[] { paramString }), localInstantiationException);
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Log.w("BackendRegistry", String.format("Could not instantiate %s.", new Object[] { paramString }), localIllegalAccessException);
      return null;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Log.w("BackendRegistry", String.format("Class %s is not found.", new Object[] { paramString }), localClassNotFoundException);
    }
    return null;
  }
}
