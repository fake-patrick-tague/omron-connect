package com.google.android.gms.measurement.drm;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.measurement.zzee;
import com.google.android.gms.measurement.internal.zzgy;
import com.google.android.gms.measurement.internal.zzgz;
import java.util.List;
import java.util.Map;

@KeepForSdk
@ShowFirstParty
public class AppMeasurementSdk
{
  private final zzee o;
  
  public AppMeasurementSdk(zzee paramZzee)
  {
    o = paramZzee;
  }
  
  public static AppMeasurementSdk getInstance(Context paramContext)
  {
    return zzee.toString(paramContext, null, null, null, null).get();
  }
  
  public static AppMeasurementSdk getInstance(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    return zzee.toString(paramContext, paramString1, paramString2, paramString3, paramBundle).get();
  }
  
  public final void a(boolean paramBoolean)
  {
    o.b(paramBoolean);
  }
  
  public void beginAdUnitExposure(String paramString)
  {
    o.c(paramString);
  }
  
  public void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle)
  {
    o.c(paramString1, paramString2, paramBundle);
  }
  
  public void endAdUnitExposure(String paramString)
  {
    o.b(paramString);
  }
  
  public long generateEventId()
  {
    return o.put();
  }
  
  public String getAppIdOrigin()
  {
    return o.getThread();
  }
  
  public String getAppInstanceId()
  {
    return o.a();
  }
  
  public List getConditionalUserProperties(String paramString1, String paramString2)
  {
    return o.get(paramString1, paramString2);
  }
  
  public String getCurrentScreenClass()
  {
    return o.c();
  }
  
  public String getCurrentScreenName()
  {
    return o.b();
  }
  
  public String getGmpAppId()
  {
    return o.d();
  }
  
  public int getMaxUserProperties(String paramString)
  {
    return o.a(paramString);
  }
  
  public Map getUserProperties(String paramString1, String paramString2, boolean paramBoolean)
  {
    return o.a(paramString1, paramString2, paramBoolean);
  }
  
  public void logEvent(String paramString1, String paramString2, Bundle paramBundle)
  {
    o.b(paramString1, paramString2, paramBundle);
  }
  
  public void logEventNoInterceptor(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    o.a(paramString1, paramString2, paramBundle, paramLong);
  }
  
  public void performAction(Bundle paramBundle)
  {
    o.get(paramBundle, false);
  }
  
  public Bundle performActionWithResponse(Bundle paramBundle)
  {
    return o.get(paramBundle, true);
  }
  
  public void registerOnMeasurementEventListener(OnEventListener paramOnEventListener)
  {
    o.remove(paramOnEventListener);
  }
  
  public void setConditionalUserProperty(Bundle paramBundle)
  {
    o.c(paramBundle);
  }
  
  public void setConsent(Bundle paramBundle)
  {
    o.b(paramBundle);
  }
  
  public void setCurrentScreen(Activity paramActivity, String paramString1, String paramString2)
  {
    o.b(paramActivity, paramString1, paramString2);
  }
  
  public void setEventInterceptor(EventInterceptor paramEventInterceptor)
  {
    o.b(paramEventInterceptor);
  }
  
  public void setMeasurementEnabled(Boolean paramBoolean)
  {
    o.b(paramBoolean);
  }
  
  public void setMeasurementEnabled(boolean paramBoolean)
  {
    o.b(Boolean.valueOf(paramBoolean));
  }
  
  public void setUserProperty(String paramString1, String paramString2, Object paramObject)
  {
    o.put(paramString1, paramString2, paramObject, true);
  }
  
  public void unregisterOnMeasurementEventListener(OnEventListener paramOnEventListener)
  {
    o.clear(paramOnEventListener);
  }
  
  @KeepForSdk
  public final class ConditionalUserProperty
  {
    @KeepForSdk
    public static final String ACTIVE = "active";
    @KeepForSdk
    public static final String CREATION_TIMESTAMP = "creation_timestamp";
    @KeepForSdk
    public static final String EXPIRED_EVENT_NAME = "expired_event_name";
    @KeepForSdk
    public static final String EXPIRED_EVENT_PARAMS = "expired_event_params";
    @KeepForSdk
    public static final String NAME = "name";
    @KeepForSdk
    public static final String ORIGIN = "origin";
    @KeepForSdk
    public static final String TIMED_OUT_EVENT_NAME = "timed_out_event_name";
    @KeepForSdk
    public static final String TIMED_OUT_EVENT_PARAMS = "timed_out_event_params";
    @KeepForSdk
    public static final String TIME_TO_LIVE = "time_to_live";
    @KeepForSdk
    public static final String TRIGGERED_EVENT_NAME = "triggered_event_name";
    @KeepForSdk
    public static final String TRIGGERED_EVENT_PARAMS = "triggered_event_params";
    @KeepForSdk
    public static final String TRIGGERED_TIMESTAMP = "triggered_timestamp";
    @KeepForSdk
    public static final String TRIGGER_EVENT_NAME = "trigger_event_name";
    @KeepForSdk
    public static final String TRIGGER_TIMEOUT = "trigger_timeout";
    @KeepForSdk
    public static final String VALUE = "value";
    
    private ConditionalUserProperty() {}
  }
  
  @KeepForSdk
  @ShowFirstParty
  public abstract interface EventInterceptor
    extends zzgy
  {
    public abstract void interceptEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong);
  }
  
  @KeepForSdk
  @ShowFirstParty
  public abstract interface OnEventListener
    extends zzgz
  {
    public abstract void onEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong);
  }
}
