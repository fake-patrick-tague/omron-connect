package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Locale;

public abstract class zzjd
  implements Iterable, Serializable
{
  public static final zzjd a = new zzja(zzkm.logger);
  private static final zzjc circle = new zzjc(null);
  private static final Comparator clipPath = new zziv();
  private int result = 0;
  
  static
  {
    int i = zzip.type;
  }
  
  zzjd() {}
  
  public static zzjd a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    add(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return new zzja(arrayOfByte);
  }
  
  static int add(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2 - paramInt1;
    if ((paramInt1 | paramInt2 | i | paramInt3 - paramInt2) < 0)
    {
      if (paramInt1 >= 0)
      {
        if (paramInt2 < paramInt1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Beginning index larger than ending index: ");
          localStringBuilder.append(paramInt1);
          localStringBuilder.append(", ");
          localStringBuilder.append(paramInt2);
          throw new IndexOutOfBoundsException(localStringBuilder.toString());
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("End index: ");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(" >= ");
        localStringBuilder.append(paramInt3);
        throw new IndexOutOfBoundsException(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Beginning index: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" < 0");
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    return i;
  }
  
  public static zzjd encodeUTF8(String paramString)
  {
    return new zzja(paramString.getBytes(zzkm.a));
  }
  
  protected abstract int b(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract boolean b();
  
  public abstract boolean equals(Object paramObject);
  
  public final String format(Charset paramCharset)
  {
    if (size() == 0) {
      return "";
    }
    return toString(paramCharset);
  }
  
  abstract byte get(int paramInt);
  
  protected final int getResponse()
  {
    return result;
  }
  
  public abstract zzjd getValue(int paramInt1, int paramInt2);
  
  public final int hashCode()
  {
    int i = result;
    if (i == 0)
    {
      i = size();
      int j = b(i, 0, i);
      i = j;
      if (j == 0) {
        i = 1;
      }
      result = i;
      return i;
    }
    return i;
  }
  
  public abstract byte next(int paramInt);
  
  abstract void remainder(zzit paramZzit)
    throws IOException;
  
  public abstract int size();
  
  public final String toString()
  {
    Locale localLocale = Locale.ROOT;
    String str2 = Integer.toHexString(System.identityHashCode(this));
    int i = size();
    String str1;
    if (size() <= 50) {
      str1 = zzml.toString(this);
    } else {
      str1 = zzml.toString(getValue(0, 47)).concat("...");
    }
    return String.format(localLocale, "<ByteString@%s size=%d contents=\"%s\">", new Object[] { str2, Integer.valueOf(i), str1 });
  }
  
  protected abstract String toString(Charset paramCharset);
}
