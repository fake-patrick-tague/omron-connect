package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

class Log
{
  static AtomicReference<m> sync = new AtomicReference();
  
  static long add(long paramLong)
  {
    Calendar localCalendar = getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return getTime(localCalendar).getTimeInMillis();
  }
  
  private static android.icu.text.DateFormat get(String paramString, Locale paramLocale)
  {
    paramString = android.icu.text.DateFormat.getInstanceForSkeleton(paramString, paramLocale);
    paramString.setTimeZone(read());
    return paramString;
  }
  
  static android.icu.text.DateFormat get(Locale paramLocale)
  {
    return get("yMMMEd", paramLocale);
  }
  
  static ProtocolVersion get()
  {
    ProtocolVersion localProtocolVersion2 = (ProtocolVersion)sync.get();
    ProtocolVersion localProtocolVersion1 = localProtocolVersion2;
    if (localProtocolVersion2 == null) {
      localProtocolVersion1 = ProtocolVersion.get();
    }
    return localProtocolVersion1;
  }
  
  static Calendar getCalendar()
  {
    Calendar localCalendar = get().add();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    localCalendar.setTimeZone(getTimeZone());
    return localCalendar;
  }
  
  private static java.text.DateFormat getFormat(int paramInt, Locale paramLocale)
  {
    paramLocale = java.text.DateFormat.getDateInstance(paramInt, paramLocale);
    paramLocale.setTimeZone(getTimeZone());
    return paramLocale;
  }
  
  static java.text.DateFormat getFormat(Locale paramLocale)
  {
    return getFormat(0, paramLocale);
  }
  
  static android.icu.text.DateFormat getInstance(Locale paramLocale)
  {
    return get("MMMEd", paramLocale);
  }
  
  static Calendar getInstance()
  {
    return read(null);
  }
  
  static Calendar getTime(Calendar paramCalendar)
  {
    paramCalendar = read(paramCalendar);
    Calendar localCalendar = getInstance();
    localCalendar.set(paramCalendar.get(1), paramCalendar.get(2), paramCalendar.get(5));
    return localCalendar;
  }
  
  private static java.util.TimeZone getTimeZone()
  {
    return java.util.TimeZone.getTimeZone("UTC");
  }
  
  private static android.icu.util.TimeZone read()
  {
    return android.icu.util.TimeZone.getTimeZone("UTC");
  }
  
  static Calendar read(Calendar paramCalendar)
  {
    Calendar localCalendar = Calendar.getInstance(getTimeZone());
    if (paramCalendar == null)
    {
      localCalendar.clear();
      return localCalendar;
    }
    localCalendar.setTimeInMillis(paramCalendar.getTimeInMillis());
    return localCalendar;
  }
}
