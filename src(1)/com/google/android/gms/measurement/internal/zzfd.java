package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drm.identifier.AdvertisingIdClient;
import com.google.android.gms.drm.identifier.AdvertisingIdClient.Info;

final class zzfd
  extends zzgs
{
  @VisibleForTesting
  static final Pair text = new Pair("", Long.valueOf(0L));
  public final zzez cache = new zzez(this, "deep_link_retrieval_attempts", 0L);
  public final zzez content = new zzez(this, "app_install_time", 0L);
  public final zzex context = new zzex(this, "deep_link_retrieval_complete", false);
  public final zzfc count = new zzfc(this, "firebase_feature_rollouts", null);
  private SharedPreferences data;
  public boolean first;
  private long id;
  public final zzez index = new zzez(this, "last_pause_time", 0L);
  public final zzez items = new zzez(this, "first_open_time", 0L);
  public zzfb last;
  public final zzez map = new zzez(this, "session_timeout", 1800000L);
  private boolean name;
  public final zzex notes = new zzex(this, "start_new_session", true);
  public final zzey out = new zzey(this, "default_event_parameters", null);
  public final zzex resource = new zzex(this, "app_backgrounded", false);
  public final zzfc resources = new zzfc(this, "deferred_attribution_cache", null);
  public final zzex services = new zzex(this, "allow_remote_dynamite", false);
  public final zzfc state = new zzfc(this, "non_personalized_ads", null);
  public final zzez this$0 = new zzez(this, "deferred_attribution_cache_timestamp", 0L);
  public final zzfc type = new zzfc(this, "app_instance_id", null);
  private String value;
  
  zzfd(zzfy paramZzfy)
  {
    super(paramZzfy);
  }
  
  protected final SharedPreferences get()
  {
    append();
    size();
    Preconditions.checkNotNull(data);
    return data;
  }
  
  final boolean get(long paramLong)
  {
    return paramLong - map.get() > index.get();
  }
  
  final Boolean isEnabled()
  {
    append();
    if (get().contains("measurement_enabled")) {
      return Boolean.valueOf(get().getBoolean("measurement_enabled", true));
    }
    return null;
  }
  
  protected final boolean parse()
  {
    return true;
  }
  
  final boolean put()
  {
    SharedPreferences localSharedPreferences = data;
    if (localSharedPreferences == null) {
      return false;
    }
    return localSharedPreferences.contains("deferred_analytics_collection");
  }
  
  final boolean put(int paramInt)
  {
    return zzai.set(paramInt, get().getInt("consent_source", 100));
  }
  
  final void putBoolean(Boolean paramBoolean)
  {
    append();
    SharedPreferences.Editor localEditor = get().edit();
    if (paramBoolean != null) {
      localEditor.putBoolean("measurement_enabled", paramBoolean.booleanValue());
    } else {
      localEditor.remove("measurement_enabled");
    }
    localEditor.apply();
  }
  
  final void putBoolean(boolean paramBoolean)
  {
    append();
    this$0.zzay().next().append("App measurement setting deferred collection", Boolean.valueOf(paramBoolean));
    SharedPreferences.Editor localEditor = get().edit();
    localEditor.putBoolean("deferred_analytics_collection", paramBoolean);
    localEditor.apply();
  }
  
  final Pair update(String paramString)
  {
    append();
    long l = this$0.zzav().elapsedRealtime();
    String str = value;
    if ((str != null) && (l < id)) {
      return new Pair(str, Boolean.valueOf(name));
    }
    id = (l + this$0.append().put(paramString, zzeb.notes));
    AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
    paramString = this$0;
    try
    {
      paramString = AdvertisingIdClient.getAdvertisingIdInfo(paramString.zzau());
      value = "";
      str = paramString.getId();
      if (str != null) {
        value = str;
      }
      boolean bool = paramString.isLimitAdTrackingEnabled();
      name = bool;
    }
    catch (Exception paramString)
    {
      this$0.zzay().e().append("Unable to get advertising id", paramString);
      value = "";
    }
    AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
    return new Pair(value, Boolean.valueOf(name));
  }
  
  final zzai url()
  {
    append();
    return zzai.parse(get().getString("consent_settings", "G1"));
  }
  
  protected final void zzaA()
  {
    Object localObject = this$0.zzau().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
    data = ((SharedPreferences)localObject);
    boolean bool = ((SharedPreferences)localObject).getBoolean("has_been_opened", false);
    first = bool;
    if (!bool)
    {
      localObject = data.edit();
      ((SharedPreferences.Editor)localObject).putBoolean("has_been_opened", true);
      ((SharedPreferences.Editor)localObject).apply();
    }
    this$0.append();
    last = new zzfb(this, "health_monitor", Math.max(0L, ((Long)zzeb.actions.get(null)).longValue()), null);
  }
}
