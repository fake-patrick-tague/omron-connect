package com.google.android.gms.internal.measurement;

import android.net.Uri;

public final class zzhx
{
  final boolean act;
  final Uri data;
  final String id;
  final String protocol = null;
  final zzie rc;
  final String settings;
  final boolean status;
  final boolean type;
  final boolean version;
  
  public zzhx(Uri paramUri)
  {
    this(null, paramUri, "", "", false, false, false, false, null);
  }
  
  private zzhx(String paramString1, Uri paramUri, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, zzie paramZzie)
  {
    data = paramUri;
    settings = "";
    id = "";
    version = paramBoolean1;
    status = false;
    act = paramBoolean3;
    type = false;
    rc = null;
  }
  
  public final zzhx create()
  {
    if (settings.isEmpty()) {
      return new zzhx(null, data, settings, id, true, false, act, false, null);
    }
    throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
  }
  
  public final zzia create(String paramString, boolean paramBoolean)
  {
    return new zzhu(this, paramString, Boolean.valueOf(paramBoolean), true);
  }
  
  public final zzhx get()
  {
    return new zzhx(null, data, settings, id, version, false, true, false, null);
  }
  
  public final zzia get(String paramString1, String paramString2)
  {
    return new zzhw(this, paramString1, paramString2, true);
  }
  
  public final zzia setStatus(String paramString, double paramDouble)
  {
    return new zzhv(this, "measurement.test.double_flag", Double.valueOf(-3.0D), true);
  }
  
  public final zzia valueOf(String paramString, long paramLong)
  {
    return new zzht(this, paramString, Long.valueOf(paramLong), true);
  }
}
