package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

public abstract interface zzcc
  extends IInterface
{
  public abstract void beginAdUnitExposure(String paramString, long paramLong)
    throws RemoteException;
  
  public abstract void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void clearMeasurementEnabled(long paramLong)
    throws RemoteException;
  
  public abstract void endAdUnitExposure(String paramString, long paramLong)
    throws RemoteException;
  
  public abstract void generateEventId(zzcf paramZzcf)
    throws RemoteException;
  
  public abstract void getAppInstanceId(zzcf paramZzcf)
    throws RemoteException;
  
  public abstract void getCachedAppInstanceId(zzcf paramZzcf)
    throws RemoteException;
  
  public abstract void getConditionalUserProperties(String paramString1, String paramString2, zzcf paramZzcf)
    throws RemoteException;
  
  public abstract void getCurrentScreenClass(zzcf paramZzcf)
    throws RemoteException;
  
  public abstract void getCurrentScreenName(zzcf paramZzcf)
    throws RemoteException;
  
  public abstract void getGmpAppId(zzcf paramZzcf)
    throws RemoteException;
  
  public abstract void getMaxUserProperties(String paramString, zzcf paramZzcf)
    throws RemoteException;
  
  public abstract void getTestFlag(zzcf paramZzcf, int paramInt)
    throws RemoteException;
  
  public abstract void getUserProperties(String paramString1, String paramString2, boolean paramBoolean, zzcf paramZzcf)
    throws RemoteException;
  
  public abstract void initForTests(Map paramMap)
    throws RemoteException;
  
  public abstract void initialize(IObjectWrapper paramIObjectWrapper, zzcl paramZzcl, long paramLong)
    throws RemoteException;
  
  public abstract void isDataCollectionEnabled(zzcf paramZzcf)
    throws RemoteException;
  
  public abstract void logEvent(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
    throws RemoteException;
  
  public abstract void logEventAndBundle(String paramString1, String paramString2, Bundle paramBundle, zzcf paramZzcf, long paramLong)
    throws RemoteException;
  
  public abstract void logHealthData(int paramInt, String paramString, IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3)
    throws RemoteException;
  
  public abstract void onActivityCreated(IObjectWrapper paramIObjectWrapper, Bundle paramBundle, long paramLong)
    throws RemoteException;
  
  public abstract void onActivityDestroyed(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException;
  
  public abstract void onActivityPaused(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException;
  
  public abstract void onActivityResumed(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException;
  
  public abstract void onActivitySaveInstanceState(IObjectWrapper paramIObjectWrapper, zzcf paramZzcf, long paramLong)
    throws RemoteException;
  
  public abstract void onActivityStarted(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException;
  
  public abstract void onActivityStopped(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException;
  
  public abstract void performAction(Bundle paramBundle, zzcf paramZzcf, long paramLong)
    throws RemoteException;
  
  public abstract void registerOnMeasurementEventListener(zzci paramZzci)
    throws RemoteException;
  
  public abstract void resetAnalyticsData(long paramLong)
    throws RemoteException;
  
  public abstract void setConditionalUserProperty(Bundle paramBundle, long paramLong)
    throws RemoteException;
  
  public abstract void setConsent(Bundle paramBundle, long paramLong)
    throws RemoteException;
  
  public abstract void setConsentThirdParty(Bundle paramBundle, long paramLong)
    throws RemoteException;
  
  public abstract void setCurrentScreen(IObjectWrapper paramIObjectWrapper, String paramString1, String paramString2, long paramLong)
    throws RemoteException;
  
  public abstract void setDataCollectionEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setDefaultEventParameters(Bundle paramBundle)
    throws RemoteException;
  
  public abstract void setEventInterceptor(zzci paramZzci)
    throws RemoteException;
  
  public abstract void setInstanceIdProvider(zzck paramZzck)
    throws RemoteException;
  
  public abstract void setMeasurementEnabled(boolean paramBoolean, long paramLong)
    throws RemoteException;
  
  public abstract void setMinimumSessionDuration(long paramLong)
    throws RemoteException;
  
  public abstract void setSessionTimeoutDuration(long paramLong)
    throws RemoteException;
  
  public abstract void setUserId(String paramString, long paramLong)
    throws RemoteException;
  
  public abstract void setUserProperty(String paramString1, String paramString2, IObjectWrapper paramIObjectWrapper, boolean paramBoolean, long paramLong)
    throws RemoteException;
  
  public abstract void unregisterOnMeasurementEventListener(zzci paramZzci)
    throws RemoteException;
}
