package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

class ProtocolVersion
{
  private static final ProtocolVersion DTLSv10 = new ProtocolVersion(null, null);
  private final TimeZone name;
  private final Long threshold;
  
  private ProtocolVersion(Long paramLong, TimeZone paramTimeZone)
  {
    threshold = paramLong;
    name = paramTimeZone;
  }
  
  static ProtocolVersion get()
  {
    return DTLSv10;
  }
  
  Calendar add()
  {
    return get(name);
  }
  
  Calendar get(TimeZone paramTimeZone)
  {
    if (paramTimeZone == null) {
      paramTimeZone = Calendar.getInstance();
    } else {
      paramTimeZone = Calendar.getInstance(paramTimeZone);
    }
    Long localLong = threshold;
    if (localLong != null) {
      paramTimeZone.setTimeInMillis(localLong.longValue());
    }
    return paramTimeZone;
  }
}
