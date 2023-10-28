package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import sun.misc.Unsafe;

final class zzmx
{
  private static final Unsafe ECDSA;
  private static final boolean a;
  private static final zzmw b;
  private static final boolean c;
  static final long d;
  static final boolean h;
  private static final boolean l;
  private static final Class type;
  
  static
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a6 = a5\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  private zzmx() {}
  
  static void a(Object paramObject, long paramLong, double paramDouble)
  {
    b.append(paramObject, paramLong, paramDouble);
  }
  
  static void a(Object paramObject, long paramLong, float paramFloat)
  {
    b.append(paramObject, paramLong, paramFloat);
  }
  
  static void a(Object paramObject, long paramLong, int paramInt)
  {
    b.append(paramObject, paramLong, paramInt);
  }
  
  static void a(Object paramObject, long paramLong1, long paramLong2)
  {
    b.set(paramObject, paramLong1, paramLong2);
  }
  
  static void a(Object paramObject, long paramLong, boolean paramBoolean)
  {
    b.f(paramObject, paramLong, paramBoolean);
  }
  
  private static int add(Class paramClass)
  {
    if (a) {
      return b.copy(paramClass);
    }
    return -1;
  }
  
  private static void add(Object paramObject, long paramLong, byte paramByte)
  {
    long l1 = 0xFFFFFFFFFFFFFFFC & paramLong;
    zzmw localZzmw = b;
    int i = localZzmw.readInt(paramObject, l1);
    int j = ((int)paramLong & 0x3) << 3;
    localZzmw.append(paramObject, l1, (0xFF & paramByte) << j | i & 255 << j);
  }
  
  static void add(Object paramObject1, long paramLong, Object paramObject2)
  {
    b.copy(paramObject1, paramLong, paramObject2);
  }
  
  static void add(byte[] paramArrayOfByte, long paramLong, byte paramByte)
  {
    b.e(paramArrayOfByte, d + paramLong, paramByte);
  }
  
  static boolean c(Object paramObject, long paramLong)
  {
    return b.b(paramObject, paramLong);
  }
  
  private static Field create()
  {
    int i = zzip.type;
    Field localField = get(Buffer.class, "effectiveDirectAddress");
    if (localField == null)
    {
      localField = get(Buffer.class, "address");
      if ((localField != null) && (localField.getType() == Long.TYPE)) {
        return localField;
      }
      return null;
    }
    return localField;
  }
  
  static double d(Object paramObject, long paramLong)
  {
    return b.a(paramObject, paramLong);
  }
  
  static float e(Object paramObject, long paramLong)
  {
    return b.get(paramObject, paramLong);
  }
  
  private static Field get(Class paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      for (;;) {}
    }
    return null;
  }
  
  static boolean get(Class paramClass)
  {
    int i = zzip.type;
    try
    {
      Class localClass1 = type;
      Class localClass2 = Boolean.TYPE;
      localClass1.getMethod("peekLong", new Class[] { paramClass, localClass2 });
      localClass1.getMethod("pokeLong", new Class[] { paramClass, Long.TYPE, localClass2 });
      Class localClass3 = Integer.TYPE;
      localClass1.getMethod("pokeInt", new Class[] { paramClass, localClass3, localClass2 });
      localClass1.getMethod("peekInt", new Class[] { paramClass, localClass2 });
      localClass1.getMethod("pokeByte", new Class[] { paramClass, Byte.TYPE });
      localClass1.getMethod("peekByte", new Class[] { paramClass });
      localClass1.getMethod("pokeByteArray", new Class[] { paramClass, [B.class, localClass3, localClass3 });
      localClass1.getMethod("peekByteArray", new Class[] { paramClass, [B.class, localClass3, localClass3 });
      return true;
    }
    catch (Throwable paramClass) {}
    return false;
  }
  
  static Object getField(Class paramClass)
  {
    Unsafe localUnsafe = ECDSA;
    try
    {
      paramClass = localUnsafe.allocateInstance(paramClass);
      return paramClass;
    }
    catch (InstantiationException paramClass)
    {
      throw new IllegalStateException(paramClass);
    }
  }
  
  static Unsafe getResourceAsStream()
  {
    try
    {
      Unsafe localUnsafe = (Unsafe)AccessController.doPrivileged(new zzmt());
      return localUnsafe;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    return null;
  }
  
  static Object getValue(Object paramObject, long paramLong)
  {
    return b.invoke(paramObject, paramLong);
  }
  
  static boolean getValue()
  {
    return a;
  }
  
  static boolean i()
  {
    return l;
  }
  
  private static void insert(Object paramObject, long paramLong, byte paramByte)
  {
    long l1 = 0xFFFFFFFFFFFFFFFC & paramLong;
    zzmw localZzmw = b;
    int i = localZzmw.readInt(paramObject, l1);
    int j = ((int)paramLong & 0x3) << 3;
    localZzmw.append(paramObject, l1, (0xFF & paramByte) << j | i & 255 << j);
  }
  
  private static int read(Class paramClass)
  {
    if (a) {
      return b.read(paramClass);
    }
    return -1;
  }
  
  static int readInt(Object paramObject, long paramLong)
  {
    return b.readInt(paramObject, paramLong);
  }
  
  static long toString(Object paramObject, long paramLong)
  {
    return b.readLong(paramObject, paramLong);
  }
}
