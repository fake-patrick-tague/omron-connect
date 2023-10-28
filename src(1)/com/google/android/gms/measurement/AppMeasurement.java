package com.google.android.gms.measurement;

import android.content.Context;
import android.os.BaseBundle;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.measurement.internal.zzfy;
import com.google.android.gms.measurement.internal.zzgu;
import com.google.android.gms.measurement.internal.zzgy;
import com.google.android.gms.measurement.internal.zzgz;
import com.google.android.gms.measurement.internal.zzie;
import com.google.android.gms.measurement.internal.zzij;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Deprecated
@KeepForSdk
@ShowFirstParty
public class AppMeasurement
{
  @KeepForSdk
  @ShowFirstParty
  public static final String CRASH_ORIGIN = "crash";
  @KeepForSdk
  @ShowFirstParty
  public static final String FCM_ORIGIN = "fcm";
  @KeepForSdk
  @ShowFirstParty
  public static final String FIAM_ORIGIN = "fiam";
  private static volatile AppMeasurement sensorManager;
  private final Directory o;
  
  public AppMeasurement(zzfy paramZzfy)
  {
    o = new h(paramZzfy);
  }
  
  public AppMeasurement(zzie paramZzie)
  {
    o = new m(paramZzie);
  }
  
  public static AppMeasurement getInstance(Context paramContext)
  {
    if (sensorManager == null) {}
    for (;;)
    {
      try
      {
        localObject = sensorManager;
        if (localObject != null) {}
      }
      catch (Throwable paramContext)
      {
        Object localObject;
        throw paramContext;
      }
      try
      {
        localObject = Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        continue;
      }
      try
      {
        localObject = ((Class)localObject).getDeclaredMethod("getScionFrontendApiImplementation", new Class[] { Context.class, Bundle.class });
        localObject = ((Method)localObject).invoke(null, new Object[] { paramContext, null });
        localObject = (zzie)localObject;
      }
      catch (Exception localException) {}
    }
    localObject = null;
    if (localObject != null) {
      sensorManager = new AppMeasurement((zzie)localObject);
    } else {
      sensorManager = new AppMeasurement(zzfy.getInstance(paramContext, new zzcl(0L, 0L, true, null, null, null, null, null), null));
    }
    return sensorManager;
  }
  
  public void beginAdUnitExposure(String paramString)
  {
    o.e(paramString);
  }
  
  public void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle)
  {
    o.f(paramString1, paramString2, paramBundle);
  }
  
  public void endAdUnitExposure(String paramString)
  {
    o.d(paramString);
  }
  
  public long generateEventId()
  {
    return o.f();
  }
  
  public String getAppInstanceId()
  {
    return o.c();
  }
  
  public Boolean getBoolean()
  {
    return o.e();
  }
  
  public List getConditionalUserProperties(String paramString1, String paramString2)
  {
    paramString2 = o.b(paramString1, paramString2);
    int i;
    if (paramString2 == null) {
      i = 0;
    } else {
      i = paramString2.size();
    }
    paramString1 = new ArrayList(i);
    paramString2 = paramString2.iterator();
    while (paramString2.hasNext()) {
      paramString1.add(new ConditionalUserProperty((Bundle)paramString2.next()));
    }
    return paramString1;
  }
  
  public String getCurrentScreenClass()
  {
    return o.b();
  }
  
  public String getCurrentScreenName()
  {
    return o.a();
  }
  
  public Double getDouble()
  {
    return o.getTitle();
  }
  
  public String getGmpAppId()
  {
    return o.d();
  }
  
  public Integer getInteger()
  {
    return o.getItemId();
  }
  
  public Long getLong()
  {
    return o.setIcon();
  }
  
  public int getMaxUserProperties(String paramString)
  {
    return o.b(paramString);
  }
  
  public String getString()
  {
    return o.getOrder();
  }
  
  protected Map getUserProperties(String paramString1, String paramString2, boolean paramBoolean)
  {
    return o.b(paramString1, paramString2, paramBoolean);
  }
  
  public Map getUserProperties(boolean paramBoolean)
  {
    return o.a(paramBoolean);
  }
  
  public void logEventInternal(String paramString1, String paramString2, Bundle paramBundle)
  {
    o.b(paramString1, paramString2, paramBundle);
  }
  
  public void logEventInternalNoInterceptor(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    o.f(paramString1, paramString2, paramBundle, paramLong);
  }
  
  public void registerOnMeasurementEventListener(OnEventListener paramOnEventListener)
  {
    o.f(paramOnEventListener);
  }
  
  public void setConditionalUserProperty(ConditionalUserProperty paramConditionalUserProperty)
  {
    Preconditions.checkNotNull(paramConditionalUserProperty);
    Directory localDirectory = o;
    Bundle localBundle = new Bundle();
    Object localObject = mAppId;
    if (localObject != null) {
      localBundle.putString("app_id", (String)localObject);
    }
    localObject = mOrigin;
    if (localObject != null) {
      localBundle.putString("origin", (String)localObject);
    }
    localObject = mName;
    if (localObject != null) {
      localBundle.putString("name", (String)localObject);
    }
    localObject = mValue;
    if (localObject != null) {
      zzgu.put(localBundle, localObject);
    }
    localObject = mTriggerEventName;
    if (localObject != null) {
      localBundle.putString("trigger_event_name", (String)localObject);
    }
    localBundle.putLong("trigger_timeout", mTriggerTimeout);
    localObject = mTimedOutEventName;
    if (localObject != null) {
      localBundle.putString("timed_out_event_name", (String)localObject);
    }
    localObject = mTimedOutEventParams;
    if (localObject != null) {
      localBundle.putBundle("timed_out_event_params", (Bundle)localObject);
    }
    localObject = mTriggeredEventName;
    if (localObject != null) {
      localBundle.putString("triggered_event_name", (String)localObject);
    }
    localObject = mTriggeredEventParams;
    if (localObject != null) {
      localBundle.putBundle("triggered_event_params", (Bundle)localObject);
    }
    localBundle.putLong("time_to_live", mTimeToLive);
    localObject = mExpiredEventName;
    if (localObject != null) {
      localBundle.putString("expired_event_name", (String)localObject);
    }
    localObject = mExpiredEventParams;
    if (localObject != null) {
      localBundle.putBundle("expired_event_params", (Bundle)localObject);
    }
    localBundle.putLong("creation_timestamp", mCreationTimestamp);
    localBundle.putBoolean("active", mActive);
    localBundle.putLong("triggered_timestamp", mTriggeredTimestamp);
    localDirectory.b(localBundle);
  }
  
  public void setEventInterceptor(EventInterceptor paramEventInterceptor)
  {
    o.b(paramEventInterceptor);
  }
  
  public void unregisterOnMeasurementEventListener(OnEventListener paramOnEventListener)
  {
    o.b(paramOnEventListener);
  }
  
  @KeepForSdk
  @ShowFirstParty
  public static class ConditionalUserProperty
  {
    @Keep
    @KeepForSdk
    @ShowFirstParty
    public boolean mActive;
    @Keep
    @KeepForSdk
    @ShowFirstParty
    public String mAppId;
    @Keep
    @KeepForSdk
    @ShowFirstParty
    public long mCreationTimestamp;
    @Keep
    public String mExpiredEventName;
    @Keep
    public Bundle mExpiredEventParams;
    @Keep
    @KeepForSdk
    @ShowFirstParty
    public String mName;
    @Keep
    @KeepForSdk
    @ShowFirstParty
    public String mOrigin;
    @Keep
    @KeepForSdk
    @ShowFirstParty
    public long mTimeToLive;
    @Keep
    public String mTimedOutEventName;
    @Keep
    public Bundle mTimedOutEventParams;
    @Keep
    @KeepForSdk
    @ShowFirstParty
    public String mTriggerEventName;
    @Keep
    @KeepForSdk
    @ShowFirstParty
    public long mTriggerTimeout;
    @Keep
    public String mTriggeredEventName;
    @Keep
    public Bundle mTriggeredEventParams;
    @Keep
    @KeepForSdk
    @ShowFirstParty
    public long mTriggeredTimestamp;
    @Keep
    @KeepForSdk
    @ShowFirstParty
    public Object mValue;
    
    public ConditionalUserProperty() {}
    
    ConditionalUserProperty(Bundle paramBundle)
    {
      Preconditions.checkNotNull(paramBundle);
      mAppId = ((String)zzgu.getString(paramBundle, "app_id", String.class, null));
      mOrigin = ((String)zzgu.getString(paramBundle, "origin", String.class, null));
      mName = ((String)zzgu.getString(paramBundle, "name", String.class, null));
      mValue = zzgu.getString(paramBundle, "value", Object.class, null);
      mTriggerEventName = ((String)zzgu.getString(paramBundle, "trigger_event_name", String.class, null));
      Long localLong = Long.valueOf(0L);
      mTriggerTimeout = ((Long)zzgu.getString(paramBundle, "trigger_timeout", Long.class, localLong)).longValue();
      mTimedOutEventName = ((String)zzgu.getString(paramBundle, "timed_out_event_name", String.class, null));
      mTimedOutEventParams = ((Bundle)zzgu.getString(paramBundle, "timed_out_event_params", Bundle.class, null));
      mTriggeredEventName = ((String)zzgu.getString(paramBundle, "triggered_event_name", String.class, null));
      mTriggeredEventParams = ((Bundle)zzgu.getString(paramBundle, "triggered_event_params", Bundle.class, null));
      mTimeToLive = ((Long)zzgu.getString(paramBundle, "time_to_live", Long.class, localLong)).longValue();
      mExpiredEventName = ((String)zzgu.getString(paramBundle, "expired_event_name", String.class, null));
      mExpiredEventParams = ((Bundle)zzgu.getString(paramBundle, "expired_event_params", Bundle.class, null));
      mActive = ((Boolean)zzgu.getString(paramBundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
      mCreationTimestamp = ((Long)zzgu.getString(paramBundle, "creation_timestamp", Long.class, localLong)).longValue();
      mTriggeredTimestamp = ((Long)zzgu.getString(paramBundle, "triggered_timestamp", Long.class, localLong)).longValue();
    }
    
    public ConditionalUserProperty(ConditionalUserProperty paramConditionalUserProperty)
    {
      Preconditions.checkNotNull(paramConditionalUserProperty);
      mAppId = mAppId;
      mOrigin = mOrigin;
      mCreationTimestamp = mCreationTimestamp;
      mName = mName;
      Object localObject = mValue;
      if (localObject != null)
      {
        localObject = zzij.put(localObject);
        mValue = localObject;
        if (localObject == null) {
          mValue = mValue;
        }
      }
      mActive = mActive;
      mTriggerEventName = mTriggerEventName;
      mTriggerTimeout = mTriggerTimeout;
      mTimedOutEventName = mTimedOutEventName;
      localObject = mTimedOutEventParams;
      if (localObject != null) {
        mTimedOutEventParams = new Bundle((Bundle)localObject);
      }
      mTriggeredEventName = mTriggeredEventName;
      localObject = mTriggeredEventParams;
      if (localObject != null) {
        mTriggeredEventParams = new Bundle((Bundle)localObject);
      }
      mTriggeredTimestamp = mTriggeredTimestamp;
      mTimeToLive = mTimeToLive;
      mExpiredEventName = mExpiredEventName;
      paramConditionalUserProperty = mExpiredEventParams;
      if (paramConditionalUserProperty != null) {
        mExpiredEventParams = new Bundle(paramConditionalUserProperty);
      }
    }
  }
  
  @KeepForSdk
  @ShowFirstParty
  public static abstract interface EventInterceptor
    extends zzgy
  {
    public abstract void interceptEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong);
  }
  
  @KeepForSdk
  @ShowFirstParty
  public static abstract interface OnEventListener
    extends zzgz
  {
    public abstract void onEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong);
  }
}
