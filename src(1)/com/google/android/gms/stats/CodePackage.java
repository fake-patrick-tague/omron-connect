package com.google.android.gms.stats;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@KeepForSdk
@ShowFirstParty
public @interface CodePackage
{
  @KeepForSdk
  public static final String COMMON = "COMMON";
  @KeepForSdk
  public static final String DRIVE = "DRIVE";
  @KeepForSdk
  public static final String FITNESS = "FITNESS";
  @KeepForSdk
  public static final String ICING = "ICING";
  @KeepForSdk
  public static final String LOCATION = "LOCATION";
  @KeepForSdk
  public static final String LOCATION_SHARING = "LOCATION_SHARING";
  @KeepForSdk
  public static final String REMINDERS = "REMINDERS";
  @KeepForSdk
  public static final String SECURITY = "SECURITY";
  @KeepForSdk
  public static final String SQL_UPDATE_6_4 = "GCM";
  @KeepForSdk
  public static final String SQL_UPDATE_6_5 = "OTA";
}
