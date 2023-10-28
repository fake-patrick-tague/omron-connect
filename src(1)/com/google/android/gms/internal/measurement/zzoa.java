package com.google.android.gms.internal.measurement;

public final class zzoa
  implements zznz
{
  public static final zzia GLOBAL;
  public static final zzia LOCAL;
  public static final zzia g;
  public static final zzia s;
  
  static
  {
    zzhx localZzhx = new zzhx(zzhp.create("com.google.android.gms.measurement")).get();
    LOCAL = localZzhx.create("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
    GLOBAL = localZzhx.create("measurement.audience.refresh_event_count_filters_timestamp", false);
    g = localZzhx.create("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
    s = localZzhx.create("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
  }
  
  public zzoa() {}
  
  public final boolean a()
  {
    return ((Boolean)s.equals()).booleanValue();
  }
  
  public final boolean cancelPotentialDownload()
  {
    return true;
  }
  
  public final boolean fetchData()
  {
    return ((Boolean)GLOBAL.equals()).booleanValue();
  }
  
  public final boolean getOrElse()
  {
    return ((Boolean)g.equals()).booleanValue();
  }
}
