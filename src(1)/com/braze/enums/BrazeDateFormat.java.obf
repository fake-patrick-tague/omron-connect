package com.braze.enums;

public enum BrazeDateFormat
{
  private final String format;
  
  static
  {
    LONG = new BrazeDateFormat("LONG", 1, "yyyy-MM-dd kk:mm:ss");
    ANDROID_LOGCAT = new BrazeDateFormat("ANDROID_LOGCAT", 2, "MM-dd kk:mm:ss.SSS");
    CLOCK_12_HOUR = new BrazeDateFormat("CLOCK_12_HOUR", 3, "h:mm a");
  }
  
  private BrazeDateFormat(String paramString)
  {
    format = paramString;
  }
  
  public final String getFormat()
  {
    return format;
  }
}
