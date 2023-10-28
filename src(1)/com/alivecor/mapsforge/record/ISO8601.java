package com.alivecor.mapsforge.record;

import java.util.Locale;
import java.util.TimeZone;
import k.a.a.f;
import org.joda.time.format.a;

public final class ISO8601
{
  public ISO8601() {}
  
  public static String c()
  {
    return fromDateTime(k.a.a.b.H());
  }
  
  public static String fromDateTime(k.a.a.b paramB)
  {
    paramB = a.d("yyyy-MM-dd'T'HH:mm:ss.SSSZ").p(Locale.US).g(paramB);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramB.substring(0, 26));
    localStringBuilder.append(":");
    localStringBuilder.append(paramB.substring(26));
    return localStringBuilder.toString();
  }
  
  public static k.a.a.b toDateTime(String paramString)
  {
    Object localObject2 = paramString.replace("Z", "+00:00");
    try
    {
      localObject1 = ((String)localObject2).substring(23);
      if (((String)localObject2).contains(".")) {
        paramString = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
      } else {
        paramString = "yyyy-MM-dd'T'HH:mm:ssZ";
      }
      paramString = a.d(paramString).p(Locale.US).e((String)localObject2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("GMT");
      ((StringBuilder)localObject2).append((String)localObject1);
      paramString.Q(f.m(TimeZone.getTimeZone(((StringBuilder)localObject2).toString())));
      return paramString;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      Object localObject1;
      for (;;) {}
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Failed to parse string: ");
    ((StringBuilder)localObject1).append(paramString);
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
  }
}
