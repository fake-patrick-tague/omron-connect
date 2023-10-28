package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

public final class zzca
  extends zzbm
  implements zzcc
{
  zzca(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
  }
  
  public final void beginAdUnitExposure(String paramString, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = next();
    localParcel.writeString(paramString);
    localParcel.writeLong(paramLong);
    add(23, localParcel);
  }
  
  public final void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = next();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzbo.get(localParcel, paramBundle);
    add(9, localParcel);
  }
  
  public final void clearMeasurementEnabled(long paramLong)
    throws RemoteException
  {
    Parcel localParcel = next();
    localParcel.writeLong(paramLong);
    add(43, localParcel);
  }
  
  public final void endAdUnitExposure(String paramString, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = next();
    localParcel.writeString(paramString);
    localParcel.writeLong(paramLong);
    add(24, localParcel);
  }
  
  public final void generateEventId(zzcf paramZzcf)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.newSession(localParcel, paramZzcf);
    add(22, localParcel);
  }
  
  public final void getAppInstanceId(zzcf paramZzcf)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.newSession(localParcel, paramZzcf);
    add(20, localParcel);
  }
  
  public final void getCachedAppInstanceId(zzcf paramZzcf)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.newSession(localParcel, paramZzcf);
    add(19, localParcel);
  }
  
  public final void getConditionalUserProperties(String paramString1, String paramString2, zzcf paramZzcf)
    throws RemoteException
  {
    Parcel localParcel = next();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzbo.newSession(localParcel, paramZzcf);
    add(10, localParcel);
  }
  
  public final void getCurrentScreenClass(zzcf paramZzcf)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.newSession(localParcel, paramZzcf);
    add(17, localParcel);
  }
  
  public final void getCurrentScreenName(zzcf paramZzcf)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.newSession(localParcel, paramZzcf);
    add(16, localParcel);
  }
  
  public final void getGmpAppId(zzcf paramZzcf)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.newSession(localParcel, paramZzcf);
    add(21, localParcel);
  }
  
  public final void getMaxUserProperties(String paramString, zzcf paramZzcf)
    throws RemoteException
  {
    Parcel localParcel = next();
    localParcel.writeString(paramString);
    zzbo.newSession(localParcel, paramZzcf);
    add(6, localParcel);
  }
  
  public final void getTestFlag(zzcf paramZzcf, int paramInt)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.newSession(localParcel, paramZzcf);
    localParcel.writeInt(paramInt);
    add(38, localParcel);
  }
  
  public final void getUserProperties(String paramString1, String paramString2, boolean paramBoolean, zzcf paramZzcf)
    throws RemoteException
  {
    Parcel localParcel = next();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzbo.append(localParcel, paramBoolean);
    zzbo.newSession(localParcel, paramZzcf);
    add(5, localParcel);
  }
  
  public final void initForTests(Map paramMap)
    throws RemoteException
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void initialize(IObjectWrapper paramIObjectWrapper, zzcl paramZzcl, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.newSession(localParcel, paramIObjectWrapper);
    zzbo.get(localParcel, paramZzcl);
    localParcel.writeLong(paramLong);
    add(1, localParcel);
  }
  
  public final void isDataCollectionEnabled(zzcf paramZzcf)
    throws RemoteException
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void logEvent(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = next();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzbo.get(localParcel, paramBundle);
    zzbo.append(localParcel, paramBoolean1);
    zzbo.append(localParcel, paramBoolean2);
    localParcel.writeLong(paramLong);
    add(2, localParcel);
  }
  
  public final void logEventAndBundle(String paramString1, String paramString2, Bundle paramBundle, zzcf paramZzcf, long paramLong)
    throws RemoteException
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void logHealthData(int paramInt, String paramString, IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3)
    throws RemoteException
  {
    Parcel localParcel = next();
    localParcel.writeInt(5);
    localParcel.writeString(paramString);
    zzbo.newSession(localParcel, paramIObjectWrapper1);
    zzbo.newSession(localParcel, paramIObjectWrapper2);
    zzbo.newSession(localParcel, paramIObjectWrapper3);
    add(33, localParcel);
  }
  
  public final void onActivityCreated(IObjectWrapper paramIObjectWrapper, Bundle paramBundle, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.newSession(localParcel, paramIObjectWrapper);
    zzbo.get(localParcel, paramBundle);
    localParcel.writeLong(paramLong);
    add(27, localParcel);
  }
  
  public final void onActivityDestroyed(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.newSession(localParcel, paramIObjectWrapper);
    localParcel.writeLong(paramLong);
    add(28, localParcel);
  }
  
  public final void onActivityPaused(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.newSession(localParcel, paramIObjectWrapper);
    localParcel.writeLong(paramLong);
    add(29, localParcel);
  }
  
  public final void onActivityResumed(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.newSession(localParcel, paramIObjectWrapper);
    localParcel.writeLong(paramLong);
    add(30, localParcel);
  }
  
  public final void onActivitySaveInstanceState(IObjectWrapper paramIObjectWrapper, zzcf paramZzcf, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.newSession(localParcel, paramIObjectWrapper);
    zzbo.newSession(localParcel, paramZzcf);
    localParcel.writeLong(paramLong);
    add(31, localParcel);
  }
  
  public final void onActivityStarted(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.newSession(localParcel, paramIObjectWrapper);
    localParcel.writeLong(paramLong);
    add(25, localParcel);
  }
  
  public final void onActivityStopped(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.newSession(localParcel, paramIObjectWrapper);
    localParcel.writeLong(paramLong);
    add(26, localParcel);
  }
  
  public final void performAction(Bundle paramBundle, zzcf paramZzcf, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.get(localParcel, paramBundle);
    zzbo.newSession(localParcel, paramZzcf);
    localParcel.writeLong(paramLong);
    add(32, localParcel);
  }
  
  public final void registerOnMeasurementEventListener(zzci paramZzci)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.newSession(localParcel, paramZzci);
    add(35, localParcel);
  }
  
  public final void resetAnalyticsData(long paramLong)
    throws RemoteException
  {
    Parcel localParcel = next();
    localParcel.writeLong(paramLong);
    add(12, localParcel);
  }
  
  public final void setConditionalUserProperty(Bundle paramBundle, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.get(localParcel, paramBundle);
    localParcel.writeLong(paramLong);
    add(8, localParcel);
  }
  
  public final void setConsent(Bundle paramBundle, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.get(localParcel, paramBundle);
    localParcel.writeLong(paramLong);
    add(44, localParcel);
  }
  
  public final void setConsentThirdParty(Bundle paramBundle, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.get(localParcel, paramBundle);
    localParcel.writeLong(paramLong);
    add(45, localParcel);
  }
  
  public final void setCurrentScreen(IObjectWrapper paramIObjectWrapper, String paramString1, String paramString2, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.newSession(localParcel, paramIObjectWrapper);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    localParcel.writeLong(paramLong);
    add(15, localParcel);
  }
  
  public final void setDataCollectionEnabled(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.append(localParcel, paramBoolean);
    add(39, localParcel);
  }
  
  public final void setDefaultEventParameters(Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.get(localParcel, paramBundle);
    add(42, localParcel);
  }
  
  public final void setEventInterceptor(zzci paramZzci)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.newSession(localParcel, paramZzci);
    add(34, localParcel);
  }
  
  public final void setInstanceIdProvider(zzck paramZzck)
    throws RemoteException
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void setMeasurementEnabled(boolean paramBoolean, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.append(localParcel, paramBoolean);
    localParcel.writeLong(paramLong);
    add(11, localParcel);
  }
  
  public final void setMinimumSessionDuration(long paramLong)
    throws RemoteException
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void setSessionTimeoutDuration(long paramLong)
    throws RemoteException
  {
    Parcel localParcel = next();
    localParcel.writeLong(paramLong);
    add(14, localParcel);
  }
  
  public final void setUserId(String paramString, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = next();
    localParcel.writeString(paramString);
    localParcel.writeLong(paramLong);
    add(7, localParcel);
  }
  
  public final void setUserProperty(String paramString1, String paramString2, IObjectWrapper paramIObjectWrapper, boolean paramBoolean, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = next();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzbo.newSession(localParcel, paramIObjectWrapper);
    zzbo.append(localParcel, paramBoolean);
    localParcel.writeLong(paramLong);
    add(4, localParcel);
  }
  
  public final void unregisterOnMeasurementEventListener(zzci paramZzci)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.newSession(localParcel, paramZzci);
    add(36, localParcel);
  }
}
