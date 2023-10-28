package com.braze.enums;

public enum DeviceKey
{
  private final String range;
  
  static
  {
    LOCALE = new DeviceKey("LOCALE", 4, "locale");
    TIMEZONE = new DeviceKey("TIMEZONE", 5, "time_zone");
    NOTIFICATIONS_ENABLED = new DeviceKey("NOTIFICATIONS_ENABLED", 6, "remote_notification_enabled");
    IS_BACKGROUND_RESTRICTED = new DeviceKey("IS_BACKGROUND_RESTRICTED", 7, "android_is_background_restricted");
    GOOGLE_ADVERTISING_ID = new DeviceKey("GOOGLE_ADVERTISING_ID", 8, "google_ad_id");
    AD_TRACKING_ENABLED = new DeviceKey("AD_TRACKING_ENABLED", 9, "ad_tracking_enabled");
  }
  
  private DeviceKey(String paramString)
  {
    range = paramString;
  }
  
  public final String getKey()
  {
    return range;
  }
}
