package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

public final class zzkm
{
  static final Charset DEFAULT_CHARSET = Charset.forName("US-ASCII");
  public static final ByteBuffer EMPTY_BUFFER;
  public static final zzjh ENCODER;
  static final Charset UTF8_CHARSET;
  static final Charset a = Charset.forName("UTF-8");
  public static final byte[] logger;
  
  static
  {
    UTF8_CHARSET = Charset.forName("ISO-8859-1");
    Object localObject = new byte[0];
    logger = (byte[])localObject;
    EMPTY_BUFFER = ByteBuffer.wrap((byte[])localObject);
    int i = zzjh.VIEW_LIST;
    localObject = new zzjf((byte[])localObject, 0, 0, false, null);
    try
    {
      ((zzjf)localObject).getCount(0);
      ENCODER = (zzjh)localObject;
      return;
    }
    catch (zzko localZzko)
    {
      throw new IllegalArgumentException(localZzko);
    }
  }
  
  public static boolean a(byte[] paramArrayOfByte)
  {
    return zznc.b(paramArrayOfByte);
  }
  
  public static int b(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    i = inflate(i, paramArrayOfByte, 0, i);
    if (i == 0) {
      return 1;
    }
    return i;
  }
  
  static Object get(Object paramObject)
  {
    Objects.requireNonNull(paramObject);
    return paramObject;
  }
  
  static Object get(Object paramObject, String paramString)
  {
    Objects.requireNonNull(paramObject, paramString);
    return paramObject;
  }
  
  public static String getValue(byte[] paramArrayOfByte)
  {
    return new String(paramArrayOfByte, a);
  }
  
  public static int hash(long paramLong)
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
  
  static int inflate(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    paramInt2 = 0;
    while (paramInt2 < paramInt3)
    {
      paramInt1 = paramInt1 * 31 + paramArrayOfByte[paramInt2];
      paramInt2 += 1;
    }
    return paramInt1;
  }
  
  static Object valueOf(Object paramObject1, Object paramObject2)
  {
    return ((zzll)paramObject1).zzbG().zzay((zzll)paramObject2).zzaG();
  }
}
