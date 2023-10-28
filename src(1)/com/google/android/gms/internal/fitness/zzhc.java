package com.google.android.gms.internal.fitness;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

public final class zzhc
{
  private static final Charset ISO_8859_1;
  static final Charset UTF_8 = Charset.forName("UTF-8");
  public static final byte[] zzyl;
  private static final ByteBuffer zzym;
  private static final zzgj zzyn;
  
  static
  {
    ISO_8859_1 = Charset.forName("ISO-8859-1");
    byte[] arrayOfByte = new byte[0];
    zzyl = arrayOfByte;
    zzym = ByteBuffer.wrap(arrayOfByte);
    zzyn = zzgj.write(arrayOfByte, 0, arrayOfByte.length, false);
  }
  
  static Object checkNotNull(Object paramObject)
  {
    Objects.requireNonNull(paramObject);
    return paramObject;
  }
  
  public static String create(byte[] paramArrayOfByte)
  {
    return new String(paramArrayOfByte, UTF_8);
  }
  
  static Object f(Object paramObject1, Object paramObject2)
  {
    return ((zzik)paramObject1).zzbt().getChange((zzik)paramObject2).zzbz();
  }
  
  static Object get(Object paramObject, String paramString)
  {
    Objects.requireNonNull(paramObject, paramString);
    return paramObject;
  }
  
  static int hashCode(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    while (i < paramInt2 + paramInt3)
    {
      paramInt1 = paramInt1 * 31 + paramArrayOfByte[i];
      i += 1;
    }
    return paramInt1;
  }
  
  public static int hashCode(long paramLong)
  {
    return (int)(paramLong ^ paramLong >>> 32);
  }
  
  public static int hashCode(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1231;
    }
    return 1237;
  }
  
  public static int hashCode(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    i = hashCode(i, paramArrayOfByte, 0, i);
    if (i == 0) {
      return 1;
    }
    return i;
  }
  
  public static boolean processBytes(byte[] paramArrayOfByte)
  {
    return zzka.processBytes(paramArrayOfByte);
  }
  
  static boolean writeValue(zzik paramZzik)
  {
    if ((paramZzik instanceof zzfq)) {
      paramZzik = (zzfq)paramZzik;
    }
    return false;
  }
}
