package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.BaseBundle;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public final class zzag
  extends zzgr
{
  private Boolean a;
  private Boolean available;
  private zzaf value = zzae.UNCHANGED;
  
  zzag(zzfy paramZzfy)
  {
    super(paramZzfy);
  }
  
  private final String get(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = Class.forName("android.os.SystemProperties");
      paramString2 = paramString2.getMethod("get", new Class[] { String.class, String.class });
      paramString1 = paramString2.invoke(null, new Object[] { paramString1, "" });
      paramString1 = (String)paramString1;
      Preconditions.checkNotNull(paramString1);
      return paramString1;
    }
    catch (InvocationTargetException paramString1)
    {
      this$0.zzay().iterator().append("SystemProperties.get() threw an exception", paramString1);
      return "";
    }
    catch (IllegalAccessException paramString1)
    {
      this$0.zzay().iterator().append("Could not access SystemProperties.get()", paramString1);
      return "";
    }
    catch (NoSuchMethodException paramString1)
    {
      this$0.zzay().iterator().append("Could not find SystemProperties.get() method", paramString1);
      return "";
    }
    catch (ClassNotFoundException paramString1)
    {
      this$0.zzay().iterator().append("Could not find SystemProperties class", paramString1);
    }
    return "";
  }
  
  public static final long getSize()
  {
    return ((Long)zzeb.images.get(null)).longValue();
  }
  
  public static final long parseAndAdd()
  {
    return ((Long)zzeb.instance.get(null)).longValue();
  }
  
  public final int add(String paramString, zzea paramZzea)
  {
    if (paramString == null) {
      return ((Integer)paramZzea.get(null)).intValue();
    }
    paramString = value.get(paramString, paramZzea.position());
    if (TextUtils.isEmpty(paramString)) {
      return ((Integer)paramZzea.get(null)).intValue();
    }
    try
    {
      paramString = paramZzea.get(Integer.valueOf(Integer.parseInt(paramString)));
      paramString = (Integer)paramString;
      int i = paramString.intValue();
      return i;
    }
    catch (NumberFormatException paramString)
    {
      for (;;) {}
    }
    return ((Integer)paramZzea.get(null)).intValue();
  }
  
  final boolean add()
  {
    if (a == null)
    {
      Boolean localBoolean = getValue("app_measurement_lite");
      a = localBoolean;
      if (localBoolean == null) {
        a = Boolean.FALSE;
      }
    }
    return (a.booleanValue()) || (!this$0.getEntry());
  }
  
  public final boolean addAll()
  {
    Boolean localBoolean = getValue("google_analytics_adid_collection_enabled");
    return (localBoolean == null) || (localBoolean.booleanValue());
  }
  
  final List create(String paramString)
  {
    Preconditions.checkNotEmpty("analytics.safelisted_events");
    paramString = getMetaData();
    if (paramString == null) {
      this$0.zzay().iterator().append("Failed to load metadata: Metadata bundle is null");
    }
    while (!paramString.containsKey("analytics.safelisted_events"))
    {
      paramString = null;
      break;
    }
    paramString = Integer.valueOf(paramString.getInt("analytics.safelisted_events"));
    if (paramString != null)
    {
      zzfy localZzfy = this$0;
      try
      {
        paramString = localZzfy.zzau().getResources().getStringArray(paramString.intValue());
        if (paramString == null) {
          return null;
        }
        paramString = Arrays.asList(paramString);
        return paramString;
      }
      catch (Resources.NotFoundException paramString)
      {
        this$0.zzay().iterator().append("Failed to load string array from metadata: resource not found", paramString);
      }
    }
    return null;
  }
  
  public final boolean d()
  {
    Boolean localBoolean = getValue("google_analytics_automatic_screen_reporting_enabled");
    return (localBoolean == null) || (localBoolean.booleanValue());
  }
  
  public final boolean equals()
  {
    this$0.zzaw();
    Boolean localBoolean = getValue("firebase_analytics_collection_deactivated");
    return (localBoolean != null) && (localBoolean.booleanValue());
  }
  
  public final boolean equals(String paramString)
  {
    return "1".equals(value.get(paramString, "gaia_collection_enabled"));
  }
  
  public final String escape()
  {
    return get("debug.deferred.deeplink", "");
  }
  
  public final int execute()
  {
    zzlh localZzlh = this$0.get();
    Boolean localBoolean = this$0.getName().isRunning();
    if ((localZzlh.d() < 201500) && ((localBoolean == null) || (localBoolean.booleanValue()))) {
      return 25;
    }
    return 100;
  }
  
  public final int get(String paramString)
  {
    return put(paramString, zzeb.tracks, 25, 100);
  }
  
  public final boolean get()
  {
    if (available == null) {
      try
      {
        if (available == null)
        {
          Object localObject = this$0.zzau().getApplicationInfo();
          String str = ProcessUtils.getMyProcessName();
          if (localObject != null)
          {
            localObject = processName;
            boolean bool2 = false;
            boolean bool1 = bool2;
            if (localObject != null)
            {
              bool1 = bool2;
              if (((String)localObject).equals(str)) {
                bool1 = true;
              }
            }
            available = Boolean.valueOf(bool1);
          }
          if (available == null)
          {
            available = Boolean.TRUE;
            this$0.zzay().iterator().append("My process not in the list of running processes");
          }
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return available.booleanValue();
  }
  
  public final boolean get(String paramString, zzea paramZzea)
  {
    if (paramString == null) {
      return ((Boolean)paramZzea.get(null)).booleanValue();
    }
    paramString = value.get(paramString, paramZzea.position());
    if (TextUtils.isEmpty(paramString)) {
      return ((Boolean)paramZzea.get(null)).booleanValue();
    }
    return ((Boolean)paramZzea.get(Boolean.valueOf("1".equals(paramString)))).booleanValue();
  }
  
  final Bundle getMetaData()
  {
    Object localObject = this$0;
    try
    {
      localObject = ((zzfy)localObject).zzau().getPackageManager();
      if (localObject == null)
      {
        localObject = this$0;
        ((zzfy)localObject).zzay().iterator().append("Failed to load metadata: PackageManager is null");
        return null;
      }
      localObject = this$0;
      localObject = Wrappers.packageManager(((zzfy)localObject).zzau());
      zzfy localZzfy = this$0;
      localObject = ((PackageManagerWrapper)localObject).getApplicationInfo(localZzfy.zzau().getPackageName(), 128);
      if (localObject == null)
      {
        localObject = this$0;
        ((zzfy)localObject).zzay().iterator().append("Failed to load metadata: ApplicationInfo is null");
        return null;
      }
      return metaData;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      this$0.zzay().iterator().append("Failed to load metadata: Package name not found", localNameNotFoundException);
    }
    return null;
  }
  
  public final String getRecurrence()
  {
    return get("debug.firebase.analytics.app", "");
  }
  
  final Boolean getValue(String paramString)
  {
    Preconditions.checkNotEmpty(paramString);
    Bundle localBundle = getMetaData();
    if (localBundle == null)
    {
      this$0.zzay().iterator().append("Failed to load metadata: Metadata bundle is null");
      return null;
    }
    if (!localBundle.containsKey(paramString)) {
      return null;
    }
    return Boolean.valueOf(localBundle.getBoolean(paramString));
  }
  
  public final boolean isEmpty(String paramString)
  {
    return "1".equals(value.get(paramString, "measurement.event_sampling_enabled"));
  }
  
  public final long length()
  {
    this$0.zzaw();
    return 73000L;
  }
  
  final void normalize(zzaf paramZzaf)
  {
    value = paramZzaf;
  }
  
  public final double parse(String paramString, zzea paramZzea)
  {
    if (paramString == null) {
      return ((Double)paramZzea.get(null)).doubleValue();
    }
    paramString = value.get(paramString, paramZzea.position());
    if (TextUtils.isEmpty(paramString)) {
      return ((Double)paramZzea.get(null)).doubleValue();
    }
    try
    {
      paramString = paramZzea.get(Double.valueOf(Double.parseDouble(paramString)));
      paramString = (Double)paramString;
      double d = paramString.doubleValue();
      return d;
    }
    catch (NumberFormatException paramString)
    {
      for (;;) {}
    }
    return ((Double)paramZzea.get(null)).doubleValue();
  }
  
  public final int put(String paramString, zzea paramZzea, int paramInt1, int paramInt2)
  {
    return Math.max(Math.min(add(paramString, paramZzea), paramInt2), paramInt1);
  }
  
  public final long put(String paramString, zzea paramZzea)
  {
    if (paramString == null) {
      return ((Long)paramZzea.get(null)).longValue();
    }
    paramString = value.get(paramString, paramZzea.position());
    if (TextUtils.isEmpty(paramString)) {
      return ((Long)paramZzea.get(null)).longValue();
    }
    try
    {
      paramString = paramZzea.get(Long.valueOf(Long.parseLong(paramString)));
      paramString = (Long)paramString;
      long l = paramString.longValue();
      return l;
    }
    catch (NumberFormatException paramString)
    {
      for (;;) {}
    }
    return ((Long)paramZzea.get(null)).longValue();
  }
  
  final String substring()
  {
    this$0.zzaw();
    return "FA";
  }
  
  public final String toString(String paramString, zzea paramZzea)
  {
    if (paramString == null) {
      return (String)paramZzea.get(null);
    }
    return (String)paramZzea.get(value.get(paramString, paramZzea.position()));
  }
  
  final int write(String paramString)
  {
    return put(paramString, zzeb.track, 500, 2000);
  }
}
