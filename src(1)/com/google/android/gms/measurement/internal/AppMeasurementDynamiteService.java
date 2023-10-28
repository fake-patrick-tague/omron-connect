package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.BaseBundle;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzcb;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzci;
import com.google.android.gms.internal.measurement.zzck;
import com.google.android.gms.internal.measurement.zzcl;
import java.util.Map;
import v7.util.ArrayMap;

@DynamiteApi
public class AppMeasurementDynamiteService
  extends zzcb
{
  @VisibleForTesting
  zzfy mFolder = null;
  private final Map mStations = new ArrayMap();
  
  public AppMeasurementDynamiteService() {}
  
  private final void b(zzcf paramZzcf, String paramString)
  {
    visitEnd();
    mFolder.get().c(paramZzcf, paramString);
  }
  
  private final void visitEnd()
  {
    if (mFolder != null) {
      return;
    }
    throw new IllegalStateException("Attempting to perform action before initialize.");
  }
  
  public void beginAdUnitExposure(String paramString, long paramLong)
    throws RemoteException
  {
    visitEnd();
    mFolder.a().c(paramString, paramLong);
  }
  
  public void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle)
    throws RemoteException
  {
    visitEnd();
    mFolder.add().set(paramString1, paramString2, paramBundle);
  }
  
  public void clearMeasurementEnabled(long paramLong)
    throws RemoteException
  {
    visitEnd();
    mFolder.add().setDefaultValue(null);
  }
  
  public void endAdUnitExposure(String paramString, long paramLong)
    throws RemoteException
  {
    visitEnd();
    mFolder.a().b(paramString, paramLong);
  }
  
  public void generateEventId(zzcf paramZzcf)
    throws RemoteException
  {
    visitEnd();
    long l = mFolder.get().next();
    visitEnd();
    mFolder.get().sendResponse(paramZzcf, l);
  }
  
  public void getAppInstanceId(zzcf paramZzcf)
    throws RemoteException
  {
    visitEnd();
    mFolder.zzaz().append(new ProgressBarICS.RefreshProgressRunnable(this, paramZzcf));
  }
  
  public void getCachedAppInstanceId(zzcf paramZzcf)
    throws RemoteException
  {
    visitEnd();
    b(paramZzcf, mFolder.add().a());
  }
  
  public void getConditionalUserProperties(String paramString1, String paramString2, zzcf paramZzcf)
    throws RemoteException
  {
    visitEnd();
    mFolder.zzaz().append(new Channel(this, paramZzcf, paramString1, paramString2));
  }
  
  public void getCurrentScreenClass(zzcf paramZzcf)
    throws RemoteException
  {
    visitEnd();
    b(paramZzcf, mFolder.add().c());
  }
  
  public void getCurrentScreenName(zzcf paramZzcf)
    throws RemoteException
  {
    visitEnd();
    b(paramZzcf, mFolder.add().b());
  }
  
  public void getGmpAppId(zzcf paramZzcf)
    throws RemoteException
  {
    visitEnd();
    zzid localZzid = mFolder.add();
    Object localObject;
    String str;
    if (this$0.getString() != null)
    {
      localObject = this$0.getString();
    }
    else
    {
      localObject = this$0;
      try
      {
        localObject = ((zzfy)localObject).zzau();
        zzfy localZzfy = this$0;
        localObject = zzij.put((Context)localObject, "google_app_id", localZzfy.getOverview());
      }
      catch (IllegalStateException localIllegalStateException)
      {
        this$0.zzay().iterator().append("getGoogleAppId failed with exception", localIllegalStateException);
        str = null;
      }
    }
    b(paramZzcf, str);
  }
  
  public void getMaxUserProperties(String paramString, zzcf paramZzcf)
    throws RemoteException
  {
    visitEnd();
    mFolder.add().multiply(paramString);
    visitEnd();
    mFolder.get().readMessage(paramZzcf, 25);
  }
  
  public void getTestFlag(zzcf paramZzcf, int paramInt)
    throws RemoteException
  {
    visitEnd();
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return;
            }
            mFolder.get().set(paramZzcf, mFolder.add().remove().booleanValue());
            return;
          }
          mFolder.get().readMessage(paramZzcf, mFolder.add().getIdentifier().intValue());
          return;
        }
        zzlh localZzlh = mFolder.get();
        double d = mFolder.add().getValue().doubleValue();
        Bundle localBundle = new Bundle();
        localBundle.putDouble("r", d);
        try
        {
          paramZzcf.append(localBundle);
          return;
        }
        catch (RemoteException paramZzcf)
        {
          this$0.zzay().hasNext().append("Error returning double value to wrapper", paramZzcf);
          return;
        }
      }
      mFolder.get().sendResponse(paramZzcf, mFolder.add().read().longValue());
      return;
    }
    mFolder.get().c(paramZzcf, mFolder.add().getString());
  }
  
  public void getUserProperties(String paramString1, String paramString2, boolean paramBoolean, zzcf paramZzcf)
    throws RemoteException
  {
    visitEnd();
    mFolder.zzaz().append(new DelayedMapListener.CallbackTask(this, paramZzcf, paramString1, paramString2, paramBoolean));
  }
  
  public void initForTests(Map paramMap)
    throws RemoteException
  {
    visitEnd();
  }
  
  public void initialize(IObjectWrapper paramIObjectWrapper, zzcl paramZzcl, long paramLong)
    throws RemoteException
  {
    zzfy localZzfy = mFolder;
    if (localZzfy == null)
    {
      mFolder = zzfy.getInstance((Context)Preconditions.checkNotNull((Context)ObjectWrapper.unwrap(paramIObjectWrapper)), paramZzcl, Long.valueOf(paramLong));
      return;
    }
    localZzfy.zzay().hasNext().append("Attempting to initialize multiple times");
  }
  
  public void isDataCollectionEnabled(zzcf paramZzcf)
    throws RemoteException
  {
    visitEnd();
    mFolder.zzaz().append(new InitiationListener.1(this, paramZzcf));
  }
  
  public void logEvent(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
    throws RemoteException
  {
    visitEnd();
    mFolder.add().add(paramString1, paramString2, paramBundle, paramBoolean1, paramBoolean2, paramLong);
  }
  
  public void logEventAndBundle(String paramString1, String paramString2, Bundle paramBundle, zzcf paramZzcf, long paramLong)
    throws RemoteException
  {
    visitEnd();
    Preconditions.checkNotEmpty(paramString2);
    Bundle localBundle;
    if (paramBundle != null) {
      localBundle = new Bundle(paramBundle);
    } else {
      localBundle = new Bundle();
    }
    localBundle.putString("_o", "app");
    paramString2 = new zzaw(paramString2, new zzau(paramBundle), "app", paramLong);
    mFolder.zzaz().append(new Alarm(this, paramZzcf, paramString2, paramString1));
  }
  
  public void logHealthData(int paramInt, String paramString, IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3)
    throws RemoteException
  {
    visitEnd();
    Object localObject = null;
    if (paramIObjectWrapper1 == null) {
      paramIObjectWrapper1 = null;
    } else {
      paramIObjectWrapper1 = ObjectWrapper.unwrap(paramIObjectWrapper1);
    }
    if (paramIObjectWrapper2 == null) {
      paramIObjectWrapper2 = null;
    } else {
      paramIObjectWrapper2 = ObjectWrapper.unwrap(paramIObjectWrapper2);
    }
    if (paramIObjectWrapper3 == null) {
      paramIObjectWrapper3 = localObject;
    } else {
      paramIObjectWrapper3 = ObjectWrapper.unwrap(paramIObjectWrapper3);
    }
    mFolder.zzay().add(paramInt, true, false, paramString, paramIObjectWrapper1, paramIObjectWrapper2, paramIObjectWrapper3);
  }
  
  public void onActivityCreated(IObjectWrapper paramIObjectWrapper, Bundle paramBundle, long paramLong)
    throws RemoteException
  {
    visitEnd();
    zzic localZzic = mFolder.add().mCallback;
    if (localZzic != null)
    {
      mFolder.add().d();
      localZzic.onActivityCreated((Activity)ObjectWrapper.unwrap(paramIObjectWrapper), paramBundle);
    }
  }
  
  public void onActivityDestroyed(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    visitEnd();
    zzic localZzic = mFolder.add().mCallback;
    if (localZzic != null)
    {
      mFolder.add().d();
      localZzic.onActivityDestroyed((Activity)ObjectWrapper.unwrap(paramIObjectWrapper));
    }
  }
  
  public void onActivityPaused(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    visitEnd();
    zzic localZzic = mFolder.add().mCallback;
    if (localZzic != null)
    {
      mFolder.add().d();
      localZzic.onActivityPaused((Activity)ObjectWrapper.unwrap(paramIObjectWrapper));
    }
  }
  
  public void onActivityResumed(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    visitEnd();
    zzic localZzic = mFolder.add().mCallback;
    if (localZzic != null)
    {
      mFolder.add().d();
      localZzic.onActivityResumed((Activity)ObjectWrapper.unwrap(paramIObjectWrapper));
    }
  }
  
  public void onActivitySaveInstanceState(IObjectWrapper paramIObjectWrapper, zzcf paramZzcf, long paramLong)
    throws RemoteException
  {
    visitEnd();
    zzic localZzic = mFolder.add().mCallback;
    Bundle localBundle = new Bundle();
    if (localZzic != null)
    {
      mFolder.add().d();
      localZzic.onActivitySaveInstanceState((Activity)ObjectWrapper.unwrap(paramIObjectWrapper), localBundle);
    }
    try
    {
      paramZzcf.append(localBundle);
      return;
    }
    catch (RemoteException paramIObjectWrapper)
    {
      mFolder.zzay().hasNext().append("Error returning bundle value to wrapper", paramIObjectWrapper);
    }
  }
  
  public void onActivityStarted(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    visitEnd();
    if (mFolder.add().mCallback != null)
    {
      mFolder.add().d();
      paramIObjectWrapper = (Activity)ObjectWrapper.unwrap(paramIObjectWrapper);
    }
  }
  
  public void onActivityStopped(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    visitEnd();
    if (mFolder.add().mCallback != null)
    {
      mFolder.add().d();
      paramIObjectWrapper = (Activity)ObjectWrapper.unwrap(paramIObjectWrapper);
    }
  }
  
  public void performAction(Bundle paramBundle, zzcf paramZzcf, long paramLong)
    throws RemoteException
  {
    visitEnd();
    paramZzcf.append(null);
  }
  
  public void registerOnMeasurementEventListener(zzci paramZzci)
    throws RemoteException
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a5 = a4\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public void resetAnalyticsData(long paramLong)
    throws RemoteException
  {
    visitEnd();
    mFolder.add().setDefaultValue(paramLong);
  }
  
  public void setConditionalUserProperty(Bundle paramBundle, long paramLong)
    throws RemoteException
  {
    visitEnd();
    if (paramBundle == null)
    {
      mFolder.zzay().iterator().append("Conditional user property must not be null");
      return;
    }
    mFolder.add().add(paramBundle, paramLong);
  }
  
  public void setConsent(Bundle paramBundle, long paramLong)
    throws RemoteException
  {
    visitEnd();
    zzid localZzid = mFolder.add();
    this$0.zzaz().synchronize(new zzhc(localZzid, paramBundle, paramLong));
  }
  
  public void setConsentThirdParty(Bundle paramBundle, long paramLong)
    throws RemoteException
  {
    visitEnd();
    mFolder.add().add(paramBundle, -20, paramLong);
  }
  
  public void setCurrentScreen(IObjectWrapper paramIObjectWrapper, String paramString1, String paramString2, long paramLong)
    throws RemoteException
  {
    visitEnd();
    mFolder.d().get((Activity)ObjectWrapper.unwrap(paramIObjectWrapper), paramString1, paramString2);
  }
  
  public void setDataCollectionEnabled(boolean paramBoolean)
    throws RemoteException
  {
    visitEnd();
    zzid localZzid = mFolder.add();
    localZzid.next();
    this$0.zzaz().append(new zzhz(localZzid, paramBoolean));
  }
  
  public void setDefaultEventParameters(Bundle paramBundle)
  {
    visitEnd();
    zzid localZzid = mFolder.add();
    if (paramBundle == null) {
      paramBundle = null;
    } else {
      paramBundle = new Bundle(paramBundle);
    }
    this$0.zzaz().append(new zzhd(localZzid, paramBundle));
  }
  
  public void setEventInterceptor(zzci paramZzci)
    throws RemoteException
  {
    visitEnd();
    paramZzci = new DatabaseHelper.1(this, paramZzci);
    if (mFolder.zzaz().put())
    {
      mFolder.add().f(paramZzci);
      return;
    }
    mFolder.zzaz().append(new DownloaderService.LVLRunnable(this, paramZzci));
  }
  
  public void setInstanceIdProvider(zzck paramZzck)
    throws RemoteException
  {
    visitEnd();
  }
  
  public void setMeasurementEnabled(boolean paramBoolean, long paramLong)
    throws RemoteException
  {
    visitEnd();
    mFolder.add().setDefaultValue(Boolean.valueOf(paramBoolean));
  }
  
  public void setMinimumSessionDuration(long paramLong)
    throws RemoteException
  {
    visitEnd();
  }
  
  public void setSessionTimeoutDuration(long paramLong)
    throws RemoteException
  {
    visitEnd();
    zzid localZzid = mFolder.add();
    this$0.zzaz().append(new zzhh(localZzid, paramLong));
  }
  
  public void setUserId(String paramString, long paramLong)
    throws RemoteException
  {
    visitEnd();
    zzid localZzid = mFolder.add();
    if ((paramString != null) && (TextUtils.isEmpty(paramString)))
    {
      this$0.zzay().hasNext().append("User ID must be non-empty or null");
      return;
    }
    this$0.zzaz().append(new zzhe(localZzid, paramString));
    localZzid.set(null, "_id", paramString, true, paramLong);
  }
  
  public void setUserProperty(String paramString1, String paramString2, IObjectWrapper paramIObjectWrapper, boolean paramBoolean, long paramLong)
    throws RemoteException
  {
    visitEnd();
    paramIObjectWrapper = ObjectWrapper.unwrap(paramIObjectWrapper);
    mFolder.add().set(paramString1, paramString2, paramIObjectWrapper, paramBoolean, paramLong);
  }
  
  public void unregisterOnMeasurementEventListener(zzci paramZzci)
    throws RemoteException
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a5 = a4\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
}
