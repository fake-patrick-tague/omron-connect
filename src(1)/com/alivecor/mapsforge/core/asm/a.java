package com.alivecor.mapsforge.core.asm;

import android.text.format.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import k.a.a.f;

public class a
{
  public static final String DEFAULT_DATE_FORMAT = "dd-MMM-yyyy";
  public static final String EAST = "E";
  public static final String KEY_FRAGMENT_DURATION = "d";
  public static final String M12 = "h:mm";
  public static final String MMM = "MMM";
  public static final String TIME_FORMAT_12_HOUR = "h:mm a";
  public static final String a = "MMM d";
  public static final String b = "MMM dd yyyy, h:mm:ss a";
  public static final String c = "MM/dd/yyyy";
  public static final String d = "d";
  public static final String e = "MMM yyyy";
  public static final String f = "EEEE MMMM d, yyyy";
  public static final String g = "MMM d, yyyy";
  public static final String h = "MMMM d, yyyy";
  public static final String i = "H:mm";
  public static final String l = "h a";
  public static final String m = "h:mm a";
  public static final String n = "EEEE, MMM dd yyyy, h:mm:ss a";
  public static final String p = "EEEE MMMM d";
  public static final String s = "EEE";
  public static final String t = "MMM dd yyyy, h:mm a";
  private SimpleDateFormat df;
  
  private a(String paramString, Locale paramLocale)
  {
    df = new SimpleDateFormat(DateFormat.getBestDateTimePattern(paramLocale, paramString), paramLocale);
  }
  
  public static a getValue(String paramString)
  {
    return new a(paramString, Locale.getDefault());
  }
  
  public static a set(String paramString, Locale paramLocale)
  {
    return new a(paramString, paramLocale);
  }
  
  public String a(k.a.a.b paramB)
  {
    df.setTimeZone(paramB.c().N());
    return df.format(paramB.i());
  }
}
