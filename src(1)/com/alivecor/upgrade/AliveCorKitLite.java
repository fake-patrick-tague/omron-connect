package com.alivecor.upgrade;

import android.content.Context;
import android.content.Intent;
import android.os.NetworkOnMainThreadException;
import com.alivecor.ecg.record.AliveCorRecordLiteActivity;
import com.alivecor.mapsforge.core.model.c;
import com.alivecor.mapsforge.record.AliveCorPdfHelper;
import com.alivecor.mapsforge.record.RecordActivityResult;
import com.alivecor.mapsforge.record.RecordEkgConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import l.a.a.b;

public class AliveCorKitLite
  extends BaseAlivecorApi
{
  private static AliveCorKitLite INSTANCE;
  private final Context appContext;
  
  private AliveCorKitLite(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramContext, paramString1, paramString2);
    if (paramBoolean) {
      l.a.a.e(new a.b());
    }
    paramString1 = paramContext.getApplicationContext();
    appContext = paramString1;
    initLibs();
    com.alivecor.asm.b.onCreate(paramContext);
    RecordEkgConfig.init(paramContext, paramString2, supportedRecordingDevices(getSupportedDevices()), com.alivecor.asm.b.a().b());
    com.alivecor.mapsforge.core.asm.b.a(paramContext);
    InternalRecordApiUtil.init(paramString1, paramString2);
  }
  
  private c deviceFromDevice(AliveCorDevice paramAliveCorDevice)
  {
    int i = 2.$SwitchMap$com$alivecor$api$AliveCorDevice[paramAliveCorDevice.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return null;
          }
          return c.J;
        }
        return c.b;
      }
      return c.deviceList;
    }
    return c.t1;
  }
  
  public static AliveCorKitLite getSocketFactory()
  {
    try
    {
      AliveCorKitLite localAliveCorKitLite = INSTANCE;
      if (localAliveCorKitLite != null) {
        return localAliveCorKitLite;
      }
      throw new IllegalStateException("You must call KardiaKitLite#initialize() before calling get()");
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static String getVersion()
  {
    return "0.7.21";
  }
  
  private void initLibs()
  {
    System.loadLibrary("universal_monitor_jni");
    System.loadLibrary("kardia_ai_jni");
    io.reactivex.a0.a.y(new ClassWriter(this));
  }
  
  public static AliveCorKitLite initialize(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      if (INSTANCE == null) {
        INSTANCE = new AliveCorKitLite(paramContext, paramString1, paramString2, paramBoolean);
      }
      paramContext = INSTANCE;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  private boolean rxShouldRethrow(Throwable paramThrowable)
  {
    return ((paramThrowable instanceof NetworkOnMainThreadException)) || (paramThrowable.getClass().getCanonicalName().contains("CalledOnWrongThreadException"));
  }
  
  private List supportedRecordingDevices(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      c localC = deviceFromDevice((AliveCorDevice)paramList.next());
      if (localC != null) {
        localArrayList.add(localC);
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public EkgAnalyzer getClassifier()
  {
    return new EkgAnalyzer(RecordEkgConfig.getDB().getClassifyRunner());
  }
  
  public File getEcgFilesDir()
  {
    return com.alivecor.mapsforge.core.asm.b.write();
  }
  
  public AliveCorPdfHelper getPdfHelper()
  {
    return new AliveCorKitLite.1(this, appContext);
  }
  
  public RecordActivityResult getRecordActivityResult(Intent paramIntent)
  {
    if (paramIntent != null) {
      return (RecordActivityResult)paramIntent.getParcelableExtra("com.alivecor.ecg.record.result");
    }
    return null;
  }
  
  public Intent getRecordIntent(AliveCorDevice paramAliveCorDevice)
  {
    Intent localIntent = new Intent(appContext, AliveCorRecordLiteActivity.class);
    localIntent.putExtra("com.alivecor.ecg.record.device", paramAliveCorDevice.name());
    return localIntent;
  }
}
