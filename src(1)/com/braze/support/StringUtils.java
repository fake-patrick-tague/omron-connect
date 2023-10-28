package com.braze.support;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Locale;
import kotlin.text.c;
import kotlin.text.g;
import kotlin.x.c.a;
import kotlin.x.c.l;
import kotlin.x.d.i;
import kotlin.x.d.j;
import kotlin.x.d.v;

public final class StringUtils
{
  private static final String PLAYING = BrazeLogger.INSTANCE.getBrazeLogTag("StringUtils");
  
  public static final long getByteSize(String paramString)
  {
    i.e(paramString, "<this>");
    paramString = paramString.getBytes(c.b);
    i.d(paramString, "this as java.lang.String).getBytes(charset)");
    return paramString.length;
  }
  
  public static final String getCacheFileSuffix(Context paramContext, String paramString)
  {
    i.e(paramContext, "context");
    return getCacheFileSuffix(paramContext, paramString, null);
  }
  
  public static final String getCacheFileSuffix(Context paramContext, String paramString1, final String paramString2)
  {
    i.e(paramContext, "context");
    String str = paramString1;
    if (paramString1 == null) {
      str = "null";
    }
    if (i.a(str, "null")) {
      return getSuffixFromUserIdHashAndApiKey("37a6259cc0c1dae299a7866489dff0bd", paramString2);
    }
    int i = 0;
    paramContext = paramContext.getSharedPreferences("com.appboy.support.stringutils.cachefilesuffix", 0);
    paramString1 = paramContext.getString("user_id_key", null);
    if ((paramString1 != null) && (i.a(paramString1, str)))
    {
      paramString1 = paramContext.getString("user_id_hash_value", null);
      if ((paramString1 == null) || (paramString1.length() == 0)) {
        i = 1;
      }
      if (i == 0) {
        return getSuffixFromUserIdHashAndApiKey(paramString1, paramString2);
      }
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, PLAYING, null, null, a.PLAYING, 6, null);
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, PLAYING, BrazeLogger.Priority.$EnumSwitchMapping$0, null, new b(str, paramString2), 4, null);
    paramString1 = getMd5Hash(str);
    paramContext.edit().putString("user_id_key", str).putString("user_id_hash_value", paramString1).apply();
    return getSuffixFromUserIdHashAndApiKey(paramString1, paramString2);
  }
  
  public static final String getMd5Hash(String paramString)
  {
    i.e(paramString, "<this>");
    Object localObject = MessageDigest.getInstance("MD5");
    paramString = paramString.getBytes(c.b);
    i.d(paramString, "this as java.lang.String).getBytes(charset)");
    paramString = new BigInteger(1, ((MessageDigest)localObject).digest(paramString));
    localObject = v.a;
    paramString = String.format(Locale.US, "%032x", Arrays.copyOf(new Object[] { paramString }, 1));
    i.d(paramString, "format(locale, format, *args)");
    return paramString;
  }
  
  private static final String getSuffixFromUserIdHashAndApiKey(String paramString1, String paramString2)
  {
    int i;
    if ((paramString2 != null) && (!g.o(paramString2))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      paramString2 = new StringBuilder();
      paramString2.append('.');
      paramString2.append(paramString1);
      return paramString2.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('.');
    localStringBuilder.append(paramString1);
    localStringBuilder.append('.');
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static final void ifNonEmpty(String paramString, l paramL)
  {
    i.e(paramL, "block");
    int i;
    if ((paramString != null) && (paramString.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0) {
      paramL.invoke(paramString);
    }
  }
  
  public static final boolean isNullOrBlank(String paramString)
  {
    return (paramString == null) || (g.o(paramString));
  }
  
  public static final boolean isNullOrEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static final String truncateToByteLength(String paramString, int paramInt)
  {
    i.e(paramString, "<this>");
    if (getByteSize(paramString) <= paramInt) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = paramString.toCharArray();
    i.d(paramString, "this as java.lang.String).toCharArray()");
    int k = paramString.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      char c = paramString[i];
      j += (int)getByteSize(String.valueOf(c));
      if (j > paramInt) {
        break;
      }
      localStringBuilder.append(c);
      i += 1;
    }
    paramString = localStringBuilder.toString();
    i.d(paramString, "truncatedStringBuilder.toString()");
    return paramString;
  }
  
  static final class a
    extends j
    implements a<String>
  {
    public static final a PLAYING = new a();
    
    a()
    {
      super();
    }
    
    public final String getText()
    {
      return "The saved user id hash was null or empty.";
    }
  }
  
  static final class b
    extends j
    implements a<String>
  {
    b(String paramString1, String paramString2)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Generating MD5 for user id: ");
      localStringBuilder.append(mOrderBy);
      localStringBuilder.append(" apiKey: ");
      localStringBuilder.append(paramString2);
      return localStringBuilder.toString();
    }
  }
}
