package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;

public final class zzeo
  extends zzgs
{
  private final zzem bag = new zzem(this, 2, false, false);
  private char c = '\000';
  private String data;
  private final zzem empty = new zzem(this, 5, false, true);
  private final zzem i = new zzem(this, 4, false, false);
  private final zzem iterator = new zzem(this, 6, false, false);
  private final zzem j = new zzem(this, 3, false, false);
  private final zzem mAuthor = new zzem(this, 6, false, true);
  private final zzem mBody = new zzem(this, 6, true, false);
  private final zzem mContents = new zzem(this, 5, true, false);
  private final zzem more = new zzem(this, 5, false, false);
  private long value = -1L;
  
  zzeo(zzfy paramZzfy)
  {
    super(paramZzfy);
  }
  
  private static String decode(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int k = paramString.lastIndexOf('.');
    if (k == -1) {
      return paramString;
    }
    return paramString.substring(0, k);
  }
  
  static String format(boolean paramBoolean, Object paramObject)
  {
    String str1 = "";
    if (paramObject == null) {
      return "";
    }
    Object localObject = paramObject;
    if ((paramObject instanceof Integer)) {
      localObject = Long.valueOf(((Integer)paramObject).intValue());
    }
    boolean bool = localObject instanceof Long;
    int k = 0;
    Long localLong;
    if (bool)
    {
      if (!paramBoolean) {
        return localObject.toString();
      }
      localLong = (Long)localObject;
      if (Math.abs(localLong.longValue()) < 100L) {
        return localObject.toString();
      }
      paramObject = str1;
      if (localObject.toString().charAt(0) == '-') {
        paramObject = "-";
      }
      localObject = String.valueOf(Math.abs(localLong.longValue()));
      long l1 = Math.round(Math.pow(10.0D, ((String)localObject).length() - 1));
      long l2 = Math.round(Math.pow(10.0D, ((String)localObject).length()) - 1.0D);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramObject);
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("...");
      ((StringBuilder)localObject).append(paramObject);
      ((StringBuilder)localObject).append(l2);
      return ((StringBuilder)localObject).toString();
    }
    if ((localObject instanceof Boolean)) {
      return localObject.toString();
    }
    if ((localObject instanceof Throwable))
    {
      localObject = (Throwable)localObject;
      if (paramBoolean) {
        paramObject = localObject.getClass().getName();
      } else {
        paramObject = ((Throwable)localObject).toString();
      }
      paramObject = new StringBuilder(paramObject);
      str1 = decode(zzfy.class.getCanonicalName());
      localObject = ((Throwable)localObject).getStackTrace();
      int m = localObject.length;
      while (k < m)
      {
        localLong = localObject[k];
        if (!localLong.isNativeMethod())
        {
          String str2 = localLong.getClassName();
          if ((str2 != null) && (decode(str2).equals(str1)))
          {
            paramObject.append(": ");
            paramObject.append(localLong);
            break;
          }
        }
        k += 1;
      }
      return paramObject.toString();
    }
    if ((localObject instanceof zzen)) {
      return zzen.toString((zzen)localObject);
    }
    if (paramBoolean) {
      return "-";
    }
    return localObject.toString();
  }
  
  protected static Object get(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return new zzen(paramString);
  }
  
  static String get(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    String str2 = "";
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    String str3 = format(paramBoolean, paramObject1);
    String str4 = format(paramBoolean, paramObject2);
    paramObject3 = format(paramBoolean, paramObject3);
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = str2;
    if (!TextUtils.isEmpty(str1))
    {
      localStringBuilder.append(str1);
      paramString = ": ";
    }
    paramBoolean = TextUtils.isEmpty(str3);
    paramObject2 = ", ";
    paramObject1 = paramString;
    if (!paramBoolean)
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(str3);
      paramObject1 = ", ";
    }
    if (!TextUtils.isEmpty(str4))
    {
      localStringBuilder.append(paramObject1);
      localStringBuilder.append(str4);
      paramObject1 = paramObject2;
    }
    if (!TextUtils.isEmpty(paramObject3))
    {
      localStringBuilder.append(paramObject1);
      localStringBuilder.append(paramObject3);
    }
    return localStringBuilder.toString();
  }
  
  public final zzem add()
  {
    return i;
  }
  
  protected final void add(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Object localObject;
    if ((!paramBoolean1) && (Log.isLoggable(read(), paramInt)))
    {
      localObject = get(false, paramString, paramObject1, paramObject2, paramObject3);
      Log.println(paramInt, read(), (String)localObject);
    }
    if ((!paramBoolean2) && (paramInt >= 5))
    {
      Preconditions.checkNotNull(paramString);
      localObject = this$0.elementAt();
      if (localObject == null)
      {
        Log.println(6, read(), "Scheduler not set. Not logging error/warn");
        return;
      }
      if (!((zzgs)localObject).write())
      {
        Log.println(6, read(), "Scheduler not initialized. Not logging error/warn");
        return;
      }
      int k = paramInt;
      if (paramInt >= 9) {
        k = 8;
      }
      ((zzfv)localObject).append(new zzel(this, k, paramString, paramObject1, paramObject2, paramObject3));
    }
  }
  
  public final zzem e()
  {
    return j;
  }
  
  public final zzem equals()
  {
    return mAuthor;
  }
  
  public final zzem getHtml()
  {
    return mContents;
  }
  
  public final zzem getText()
  {
    return mBody;
  }
  
  public final zzem hasNext()
  {
    return more;
  }
  
  public final zzem isEmpty()
  {
    return empty;
  }
  
  public final zzem iterator()
  {
    return iterator;
  }
  
  public final zzem next()
  {
    return bag;
  }
  
  protected final boolean parse()
  {
    return false;
  }
  
  protected final String read()
  {
    try
    {
      if (data == null) {
        if (this$0.slice() != null) {
          data = this$0.slice();
        } else {
          data = this$0.append().substring();
        }
      }
      Preconditions.checkNotNull(data);
      String str = data;
      return str;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
