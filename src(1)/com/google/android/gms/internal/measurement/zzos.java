package com.google.android.gms.internal.measurement;

public final class zzos
  implements zzor
{
  public static final zzia GLOBAL;
  public static final zzia b;
  public static final zzia d;
  public static final zzia forward;
  public static final zzia h;
  
  static
  {
    zzhx localZzhx = new zzhx(zzhp.create("com.google.android.gms.measurement")).get();
    GLOBAL = localZzhx.create("measurement.test.boolean_flag", false);
    forward = localZzhx.setStatus("measurement.test.double_flag", -3.0D);
    h = localZzhx.valueOf("measurement.test.int_flag", -2L);
    b = localZzhx.valueOf("measurement.test.long_flag", -1L);
    d = localZzhx.get("measurement.test.string_flag", "---");
  }
  
  public zzos() {}
  
  public final String b()
  {
    return (String)d.equals();
  }
  
  public final double getDoubleValue()
  {
    return ((Double)forward.equals()).doubleValue();
  }
  
  public final boolean getOrElse()
  {
    return ((Boolean)GLOBAL.equals()).booleanValue();
  }
  
  public final long parseAndAdd()
  {
    return ((Long)h.equals()).longValue();
  }
  
  public final long put()
  {
    return ((Long)b.equals()).longValue();
  }
}
