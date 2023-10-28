package com.google.android.gms.internal.measurement;

public final class zzoy
  implements zzox
{
  public static final zzia DEFAULT;
  public static final zzia EMPTY;
  public static final zzia FALSE;
  public static final zzia GLOBAL;
  public static final zzia LOCAL;
  public static final zzia PENDING;
  public static final zzia TRUE;
  public static final zzia UNKNOWN;
  public static final zzia filter;
  public static final zzia g;
  public static final zzia listeners;
  public static final zzia map;
  public static final zzia q;
  public static final zzia s;
  
  static
  {
    zzhx localZzhx = new zzhx(zzhp.create("com.google.android.gms.measurement")).create().get();
    listeners = localZzhx.create("measurement.redaction.app_instance_id", true);
    map = localZzhx.create("measurement.redaction.client_ephemeral_aiid_generation", true);
    EMPTY = localZzhx.create("measurement.redaction.config_redacted_fields", true);
    UNKNOWN = localZzhx.create("measurement.redaction.device_info", true);
    TRUE = localZzhx.create("measurement.redaction.e_tag", true);
    FALSE = localZzhx.create("measurement.redaction.enhanced_uid", true);
    DEFAULT = localZzhx.create("measurement.redaction.populate_ephemeral_app_instance_id", true);
    LOCAL = localZzhx.create("measurement.redaction.google_signals", true);
    GLOBAL = localZzhx.create("measurement.redaction.no_aiid_in_config_request", true);
    filter = localZzhx.create("measurement.redaction.retain_major_os_version", true);
    q = localZzhx.create("measurement.redaction.scion_payload_generator", true);
    g = localZzhx.create("measurement.redaction.upload_redacted_fields", true);
    s = localZzhx.create("measurement.redaction.upload_subdomain_override", true);
    PENDING = localZzhx.create("measurement.redaction.user_id", true);
  }
  
  public zzoy() {}
  
  public final boolean a()
  {
    return ((Boolean)g.equals()).booleanValue();
  }
  
  public final boolean add()
  {
    return ((Boolean)FALSE.equals()).booleanValue();
  }
  
  public final boolean appliesTo()
  {
    return ((Boolean)EMPTY.equals()).booleanValue();
  }
  
  public final boolean apply()
  {
    return ((Boolean)map.equals()).booleanValue();
  }
  
  public final boolean booleanValue()
  {
    return ((Boolean)TRUE.equals()).booleanValue();
  }
  
  public final boolean end()
  {
    return ((Boolean)UNKNOWN.equals()).booleanValue();
  }
  
  public final boolean execute()
  {
    return ((Boolean)q.equals()).booleanValue();
  }
  
  public final boolean fetchData()
  {
    return ((Boolean)listeners.equals()).booleanValue();
  }
  
  public final boolean getBoolean()
  {
    return ((Boolean)GLOBAL.equals()).booleanValue();
  }
  
  public final boolean getOrElse()
  {
    return ((Boolean)filter.equals()).booleanValue();
  }
  
  public final boolean isDebug()
  {
    return ((Boolean)DEFAULT.equals()).booleanValue();
  }
  
  public final boolean isDictionary()
  {
    return true;
  }
  
  public final boolean isInForeground()
  {
    return ((Boolean)LOCAL.equals()).booleanValue();
  }
  
  public final boolean isPending()
  {
    return ((Boolean)PENDING.equals()).booleanValue();
  }
  
  public final boolean next()
  {
    return ((Boolean)s.equals()).booleanValue();
  }
}
