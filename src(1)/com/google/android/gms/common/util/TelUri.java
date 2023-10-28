package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class TelUri
{
  private static final Pattern uriPattern = Pattern.compile("\\\\u[0-9a-fA-F]{4}");
  
  public static String parse(String paramString)
  {
    Object localObject1 = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      Matcher localMatcher = uriPattern.matcher(paramString);
      int i = 0;
      localObject1 = null;
      while (localMatcher.find())
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new StringBuilder();
        }
        int k = localMatcher.start();
        int j = k;
        while ((j >= 0) && (paramString.charAt(j) == '\\')) {
          j -= 1;
        }
        localObject1 = localObject2;
        if ((k - j) % 2 != 0)
        {
          j = Integer.parseInt(localMatcher.group().substring(2), 16);
          ((StringBuilder)localObject2).append(paramString, i, localMatcher.start());
          if (j == 92) {
            ((StringBuilder)localObject2).append("\\\\");
          } else {
            ((StringBuilder)localObject2).append(Character.toChars(j));
          }
          i = localMatcher.end();
          localObject1 = localObject2;
        }
      }
      if (localObject1 == null) {
        return paramString;
      }
      if (i < localMatcher.regionEnd()) {
        ((StringBuilder)localObject1).append(paramString, i, localMatcher.regionEnd());
      }
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    return localObject1;
  }
}
