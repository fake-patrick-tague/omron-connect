package com.alivecor.mapsforge.record;

import android.content.Context;
import com.alivecor.asm.k;
import commons.math3.ode.nonstiff.a;
import java.util.Collections;
import java.util.List;

public class RecordEkgConfig
{
  private static RecordEkgConfig INSTANCE;
  private final String appName;
  private final Context context;
  private final List<com.alivecor.ecg.core.model.c> enabledDevices;
  private final RecordDependencyComponent recordDependencyComponent;
  
  protected RecordEkgConfig(Context paramContext, String paramString, List paramList, k paramK)
  {
    context = paramContext.getApplicationContext();
    recordDependencyComponent = DaggerRecordDependencyComponent.builder().aiComponent(paramK).contextModule(new a(paramContext.getApplicationContext())).build();
    enabledDevices = Collections.unmodifiableList(paramList);
    appName = paramString;
  }
  
  public static RecordEkgConfig getDB()
  {
    try
    {
      RecordEkgConfig localRecordEkgConfig = INSTANCE;
      if (localRecordEkgConfig != null) {
        return localRecordEkgConfig;
      }
      throw new IllegalStateException("Must initialize RecordEkgConfig before getting its instance");
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static void init(Context paramContext, String paramString, List paramList, k paramK)
  {
    try
    {
      INSTANCE = new RecordEkgConfig(paramContext, paramString, paramList, paramK);
      return;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  Context appContext()
  {
    return context;
  }
  
  String getAppName()
  {
    return appName;
  }
  
  public com.alivecor.asm.c getClassifyRunner()
  {
    return recordDependencyComponent.classifyRunner();
  }
  
  List getEnabledDevices()
  {
    return enabledDevices;
  }
  
  RecordDependencyComponent getRecordDependencyComponent()
  {
    return recordDependencyComponent;
  }
}
