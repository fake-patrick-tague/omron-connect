package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.format.DateUtils;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

class Segment
{
  static String format(long paramLong, Locale paramLocale)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return Log.getInstance(paramLocale).format(new Date(paramLong));
    }
    return Log.getFormat(paramLocale).format(new Date(paramLong));
  }
  
  static String get(long paramLong, Locale paramLocale)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return Log.get(paramLocale).format(new Date(paramLong));
    }
    return Log.getFormat(paramLocale).format(new Date(paramLong));
  }
  
  static String getTitle(long paramLong)
  {
    return get(paramLong, Locale.getDefault());
  }
  
  static String getValue(long paramLong)
  {
    return format(paramLong, Locale.getDefault());
  }
  
  static String toString(Context paramContext, long paramLong)
  {
    return DateUtils.formatDateTime(paramContext, paramLong - TimeZone.getDefault().getOffset(paramLong), 36);
  }
}
