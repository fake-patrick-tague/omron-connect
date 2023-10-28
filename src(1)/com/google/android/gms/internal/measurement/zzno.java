package com.google.android.gms.internal.measurement;

public final class zzno
  implements zznn
{
  public static final zzia ANY;
  public static final zzia DATE_TIME;
  public static final zzia EMPTY;
  public static final zzia MAJORITY;
  public static final zzia NULL;
  public static final zzia ONE;
  public static final zzia ROUND_BRACKET_BEG;
  public static final zzia SEMI_COLON;
  public static final zzia Status;
  public static final zzia TEN;
  public static final zzia Type;
  public static final zzia ZERO;
  public static final zzia a;
  public static final zzia b;
  public static final zzia base;
  public static final zzia buf;
  public static final zzia collection;
  public static final zzia comparator;
  public static final zzia d;
  public static final zzia defaultValue;
  public static final zzia e;
  public static final zzia g;
  public static final zzia guid;
  public static final zzia h;
  public static final zzia icon;
  public static final zzia id;
  public static final zzia items;
  public static final zzia jid;
  public static final zzia location;
  public static final zzia m;
  public static final zzia maximum;
  public static final zzia minimum;
  public static final zzia name;
  public static final zzia offset;
  public static final zzia origin;
  public static final zzia params;
  public static final zzia text;
  public static final zzia type;
  public static final zzia value;
  
  static
  {
    zzhx localZzhx = new zzhx(zzhp.create("com.google.android.gms.measurement")).get();
    m = localZzhx.valueOf("measurement.ad_id_cache_time", 10000L);
    h = localZzhx.valueOf("measurement.max_bundles_per_iteration", 100L);
    a = localZzhx.valueOf("measurement.config.cache_time", 86400000L);
    Status = localZzhx.get("measurement.log_tag", "FA");
    Type = localZzhx.get("measurement.config.url_authority", "app-measurement.com");
    params = localZzhx.get("measurement.config.url_scheme", "https");
    name = localZzhx.valueOf("measurement.upload.debug_upload_interval", 1000L);
    location = localZzhx.valueOf("measurement.lifetimevalue.max_currency_tracked", 4L);
    offset = localZzhx.valueOf("measurement.store.max_stored_events_per_app", 100000L);
    value = localZzhx.valueOf("measurement.experiment.max_ids", 50L);
    origin = localZzhx.valueOf("measurement.audience.filter_result_max_count", 200L);
    jid = localZzhx.valueOf("measurement.alarm_manager.minimum_interval", 60000L);
    defaultValue = localZzhx.valueOf("measurement.upload.minimum_delay", 500L);
    id = localZzhx.valueOf("measurement.monitoring.sample_period_millis", 86400000L);
    EMPTY = localZzhx.valueOf("measurement.upload.realtime_upload_interval", 10000L);
    ZERO = localZzhx.valueOf("measurement.upload.refresh_blacklisted_config_interval", 604800000L);
    TEN = localZzhx.valueOf("measurement.config.cache_time.service", 3600000L);
    ONE = localZzhx.valueOf("measurement.service_client.idle_disconnect_millis", 5000L);
    MAJORITY = localZzhx.get("measurement.log_tag.service", "FA-SVC");
    SEMI_COLON = localZzhx.valueOf("measurement.upload.stale_data_deletion_interval", 86400000L);
    ROUND_BRACKET_BEG = localZzhx.valueOf("measurement.sdk.attribution.cache.ttl", 604800000L);
    DATE_TIME = localZzhx.valueOf("measurement.redaction.app_instance_id.ttl", 7200000L);
    NULL = localZzhx.valueOf("measurement.upload.backoff_period", 43200000L);
    ANY = localZzhx.valueOf("measurement.upload.initial_upload_delay_time", 15000L);
    collection = localZzhx.valueOf("measurement.upload.interval", 3600000L);
    guid = localZzhx.valueOf("measurement.upload.max_bundle_size", 65536L);
    type = localZzhx.valueOf("measurement.upload.max_bundles", 100L);
    items = localZzhx.valueOf("measurement.upload.max_conversions_per_day", 500L);
    icon = localZzhx.valueOf("measurement.upload.max_error_events_per_day", 1000L);
    text = localZzhx.valueOf("measurement.upload.max_events_per_bundle", 1000L);
    buf = localZzhx.valueOf("measurement.upload.max_events_per_day", 100000L);
    d = localZzhx.valueOf("measurement.upload.max_public_events_per_day", 50000L);
    e = localZzhx.valueOf("measurement.upload.max_queue_time", 2419200000L);
    g = localZzhx.valueOf("measurement.upload.max_realtime_events_per_day", 10L);
    b = localZzhx.valueOf("measurement.upload.max_batch_size", 65536L);
    base = localZzhx.valueOf("measurement.upload.retry_count", 6L);
    maximum = localZzhx.valueOf("measurement.upload.retry_time", 1800000L);
    comparator = localZzhx.get("measurement.upload.url", "https://app-measurement.com/a");
    minimum = localZzhx.valueOf("measurement.upload.window_interval", 3600000L);
  }
  
  public zzno() {}
  
  public final long a()
  {
    return ((Long)NULL.equals()).longValue();
  }
  
  public final long apply()
  {
    return ((Long)g.equals()).longValue();
  }
  
  public final long asLong()
  {
    return ((Long)base.equals()).longValue();
  }
  
  public final String b()
  {
    return (String)comparator.equals();
  }
  
  public final long call()
  {
    return ((Long)items.equals()).longValue();
  }
  
  public final long contains()
  {
    return ((Long)type.equals()).longValue();
  }
  
  public final long distance()
  {
    return ((Long)offset.equals()).longValue();
  }
  
  public final long execute()
  {
    return ((Long)ANY.equals()).longValue();
  }
  
  public final String get()
  {
    return (String)params.equals();
  }
  
  public final long getAudioId()
  {
    return ((Long)d.equals()).longValue();
  }
  
  public final long getColumnIndex()
  {
    return ((Long)ROUND_BRACKET_BEG.equals()).longValue();
  }
  
  public final long getCount()
  {
    return ((Long)a.equals()).longValue();
  }
  
  public final long getID()
  {
    return ((Long)ONE.equals()).longValue();
  }
  
  public final long getId()
  {
    return ((Long)id.equals()).longValue();
  }
  
  public final long getLong()
  {
    return ((Long)defaultValue.equals()).longValue();
  }
  
  public final long getOrElse()
  {
    return ((Long)ZERO.equals()).longValue();
  }
  
  public final long getPlaceId()
  {
    return ((Long)location.equals()).longValue();
  }
  
  public final long getString()
  {
    return ((Long)buf.equals()).longValue();
  }
  
  public final String getType()
  {
    return (String)Type.equals();
  }
  
  public final long getValue()
  {
    return ((Long)b.equals()).longValue();
  }
  
  public final long init()
  {
    return ((Long)jid.equals()).longValue();
  }
  
  public final long intValue()
  {
    return ((Long)maximum.equals()).longValue();
  }
  
  public final long isEmpty()
  {
    return ((Long)EMPTY.equals()).longValue();
  }
  
  public final long length()
  {
    return ((Long)name.equals()).longValue();
  }
  
  public final long log()
  {
    return ((Long)DATE_TIME.equals()).longValue();
  }
  
  public final long multiply()
  {
    return ((Long)e.equals()).longValue();
  }
  
  public final long next()
  {
    return ((Long)h.equals()).longValue();
  }
  
  public final long parseAndAdd()
  {
    return ((Long)minimum.equals()).longValue();
  }
  
  public final long put()
  {
    return ((Long)m.equals()).longValue();
  }
  
  public final long putAll()
  {
    return ((Long)value.equals()).longValue();
  }
  
  public final long remove()
  {
    return ((Long)collection.equals()).longValue();
  }
  
  public final long replace()
  {
    return ((Long)guid.equals()).longValue();
  }
  
  public final long saveData()
  {
    return ((Long)text.equals()).longValue();
  }
  
  public final long set()
  {
    return ((Long)origin.equals()).longValue();
  }
  
  public final long size()
  {
    return ((Long)SEMI_COLON.equals()).longValue();
  }
  
  public final long update()
  {
    return ((Long)icon.equals()).longValue();
  }
}
