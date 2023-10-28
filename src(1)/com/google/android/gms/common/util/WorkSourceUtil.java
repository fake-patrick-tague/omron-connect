package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@KeepForSdk
public class WorkSourceUtil
{
  private static final Method THROWABLE_INITCAUSE_METHOD;
  private static final Method addPreviewBufferMethod;
  private static final Method isVisible;
  private static final Method java6NormalizeMethod;
  private static final Method sRCCEditMetadataMethod;
  private static final Method sRCCSetPlayStateMethod;
  private static final Method setPreviewCallbackWithBufferMethod;
  private static final Method sunDecomposeMethod;
  private static final int width = ;
  
  static
  {
    Object localObject4 = null;
    Method localMethod = null;
    Object localObject1 = Integer.TYPE;
    try
    {
      localObject1 = WorkSource.class.getMethod("add", new Class[] { localObject1 });
    }
    catch (Exception localException3)
    {
      for (;;) {}
    }
    localObject1 = null;
    isVisible = (Method)localObject1;
    if (PlatformVersion.isAtLeastJellyBeanMR2()) {
      localObject1 = Integer.TYPE;
    }
    try
    {
      localObject1 = WorkSource.class.getMethod("add", new Class[] { localObject1, String.class });
    }
    catch (Exception localException4)
    {
      for (;;) {}
    }
    localObject1 = null;
    THROWABLE_INITCAUSE_METHOD = (Method)localObject1;
    try
    {
      localObject1 = WorkSource.class.getMethod("size", new Class[0]);
    }
    catch (Exception localException5)
    {
      for (;;) {}
    }
    localObject1 = null;
    java6NormalizeMethod = (Method)localObject1;
    localObject1 = Integer.TYPE;
    try
    {
      localObject1 = WorkSource.class.getMethod("get", new Class[] { localObject1 });
    }
    catch (Exception localException6)
    {
      for (;;) {}
    }
    localObject1 = null;
    sRCCEditMetadataMethod = (Method)localObject1;
    if (PlatformVersion.isAtLeastJellyBeanMR2()) {
      localObject1 = Integer.TYPE;
    }
    try
    {
      localObject1 = WorkSource.class.getMethod("getName", new Class[] { localObject1 });
    }
    catch (Exception localException7)
    {
      Object localObject2;
      Object localObject3;
      for (;;) {}
    }
    localObject1 = null;
    sRCCSetPlayStateMethod = (Method)localObject1;
    if (PlatformVersion.isAtLeastP()) {
      try
      {
        localObject1 = WorkSource.class.getMethod("createWorkChain", new Class[0]);
      }
      catch (Exception localException1)
      {
        Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", localException1);
      }
    } else {
      localObject2 = null;
    }
    sunDecomposeMethod = (Method)localObject2;
    if (PlatformVersion.isAtLeastP()) {
      try
      {
        localObject2 = Class.forName("android.os.WorkSource$WorkChain");
        Class localClass = Integer.TYPE;
        localObject2 = ((Class)localObject2).getMethod("addNode", new Class[] { localClass, String.class });
      }
      catch (Exception localException2)
      {
        Log.w("WorkSourceUtil", "Missing WorkChain class", localException2);
      }
    } else {
      localObject3 = null;
    }
    addPreviewBufferMethod = (Method)localObject3;
    localObject3 = localMethod;
    if (PlatformVersion.isAtLeastP()) {
      localObject3 = localObject4;
    }
    try
    {
      localMethod = WorkSource.class.getMethod("isEmpty", new Class[0]);
      localObject4 = localMethod;
      localObject3 = localObject4;
      localMethod.setAccessible(true);
      localObject3 = localObject4;
    }
    catch (Exception localException8)
    {
      for (;;) {}
    }
    setPreviewCallbackWithBufferMethod = (Method)localObject3;
  }
  
  private WorkSourceUtil() {}
  
  public static void convert(WorkSource paramWorkSource, int paramInt, String paramString)
  {
    Method localMethod = THROWABLE_INITCAUSE_METHOD;
    if (localMethod != null)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      try
      {
        localMethod.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt), str });
        return;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
        return;
      }
    }
    paramString = isVisible;
    if (paramString != null) {
      try
      {
        paramString.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
      }
    }
  }
  
  public static WorkSource fromPackage(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramContext.getPackageManager() != null) && (paramString != null))
    {
      try
      {
        paramContext = Wrappers.packageManager(paramContext).getApplicationInfo(paramString, 0);
        if (paramContext == null)
        {
          Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(paramString));
          return null;
        }
        int i = uid;
        paramContext = new WorkSource();
        convert(paramContext, i, paramString);
        return paramContext;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;) {}
      }
      Log.e("WorkSourceUtil", "Could not find package: ".concat(paramString));
      return null;
    }
    return null;
  }
  
  public static WorkSource fromPackageAndModuleExperimentalPi(Context paramContext, String paramString1, String paramString2)
  {
    int i;
    if ((paramContext != null) && (paramContext.getPackageManager() != null) && (paramString2 != null) && (paramString1 != null)) {
      i = -1;
    }
    try
    {
      paramContext = Wrappers.packageManager(paramContext).getApplicationInfo(paramString1, 0);
      if (paramContext == null) {
        Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(paramString1));
      } else {
        i = uid;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Object localObject;
      Method localMethod;
      for (;;) {}
    }
    Log.e("WorkSourceUtil", "Could not find package: ".concat(paramString1));
    if (i < 0) {
      return null;
    }
    paramContext = new WorkSource();
    localObject = sunDecomposeMethod;
    if (localObject != null)
    {
      localMethod = addPreviewBufferMethod;
      if (localMethod != null) {
        try
        {
          localObject = ((Method)localObject).invoke(paramContext, new Object[0]);
          int j = width;
          if (i != j) {
            localMethod.invoke(localObject, new Object[] { Integer.valueOf(i), paramString1 });
          }
          localMethod.invoke(localObject, new Object[] { Integer.valueOf(j), paramString2 });
          return paramContext;
        }
        catch (Exception paramString1)
        {
          Log.w("WorkSourceUtil", "Unable to assign chained blame through WorkSource", paramString1);
          return paramContext;
        }
      }
    }
    convert(paramContext, i, paramString1);
    return paramContext;
    Log.w("WorkSourceUtil", "Unexpected null arguments");
    return null;
  }
  
  public static int get(WorkSource paramWorkSource, int paramInt)
  {
    Method localMethod = sRCCEditMetadataMethod;
    if (localMethod != null) {
      try
      {
        paramWorkSource = localMethod.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt) });
        Preconditions.checkNotNull(paramWorkSource);
        paramWorkSource = (Integer)paramWorkSource;
        paramInt = paramWorkSource.intValue();
        return paramInt;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
      }
    }
    return 0;
  }
  
  public static String getName(WorkSource paramWorkSource, int paramInt)
  {
    Method localMethod = sRCCSetPlayStateMethod;
    if (localMethod != null) {
      try
      {
        paramWorkSource = localMethod.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt) });
        return (String)paramWorkSource;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
      }
    }
    return null;
  }
  
  public static List getNames(WorkSource paramWorkSource)
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int i;
    if (paramWorkSource == null) {
      i = 0;
    } else {
      i = size(paramWorkSource);
    }
    if (i != 0) {
      while (j < i)
      {
        String str = getName(paramWorkSource, j);
        if (!Strings.isEmptyOrWhitespace(str))
        {
          Preconditions.checkNotNull(str);
          localArrayList.add(str);
        }
        j += 1;
      }
    }
    return localArrayList;
  }
  
  public static boolean hasWorkSourcePermission(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    if (paramContext.getPackageManager() == null) {
      return false;
    }
    return Wrappers.packageManager(paramContext).checkPermission("android.permission.UPDATE_DEVICE_STATS", paramContext.getPackageName()) == 0;
  }
  
  public static boolean isEmpty(WorkSource paramWorkSource)
  {
    Object localObject = setPreviewCallbackWithBufferMethod;
    if (localObject != null) {
      try
      {
        localObject = ((Method)localObject).invoke(paramWorkSource, new Object[0]);
        Preconditions.checkNotNull(localObject);
        localObject = (Boolean)localObject;
        boolean bool = ((Boolean)localObject).booleanValue();
        return bool;
      }
      catch (Exception localException)
      {
        Log.e("WorkSourceUtil", "Unable to check WorkSource emptiness", localException);
      }
    }
    return size(paramWorkSource) == 0;
  }
  
  public static int size(WorkSource paramWorkSource)
  {
    Method localMethod = java6NormalizeMethod;
    if (localMethod != null) {
      try
      {
        paramWorkSource = localMethod.invoke(paramWorkSource, new Object[0]);
        Preconditions.checkNotNull(paramWorkSource);
        paramWorkSource = (Integer)paramWorkSource;
        int i = paramWorkSource.intValue();
        return i;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
      }
    }
    return 0;
  }
}
