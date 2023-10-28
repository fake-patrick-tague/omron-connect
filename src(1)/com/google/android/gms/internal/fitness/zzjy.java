package com.google.android.gms.internal.fitness;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zzjy
{
  private static final Logger logger;
  private static final Unsafe zzaad;
  private static final boolean zzabz;
  private static final boolean zzaca;
  private static final zzc zzacb;
  private static final boolean zzacc;
  private static final long zzacd;
  private static final long zzace;
  private static final long zzacf;
  private static final long zzacg;
  private static final long zzach;
  private static final long zzaci;
  private static final long zzacj;
  private static final long zzack;
  private static final long zzacl;
  private static final long zzacm;
  private static final long zzacn;
  private static final long zzaco;
  private static final long zzacp;
  private static final long zzacq;
  private static final int zzacr;
  static final boolean zzacs;
  private static final Class<?> zzty;
  private static final boolean zzum;
  
  static
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a5 = a4\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  private zzjy() {}
  
  private static void a(Object paramObject, long paramLong, boolean paramBoolean)
  {
    write(paramObject, paramLong, (byte)paramBoolean);
  }
  
  private static boolean a(Object paramObject, long paramLong)
  {
    return convert(paramObject, paramLong) != 0;
  }
  
  private static boolean add(Object paramObject, long paramLong)
  {
    return toString(paramObject, paramLong) != 0;
  }
  
  private static void append(Object paramObject, long paramLong, byte paramByte)
  {
    long l = 0xFFFFFFFFFFFFFFFC & paramLong;
    int i = getValue(paramObject, l);
    int j = ((int)paramLong & 0x3) << 3;
    d(paramObject, l, (0xFF & paramByte) << j | i & 255 << j);
  }
  
  static void append(Object paramObject1, long paramLong, Object paramObject2)
  {
    zzacbzzact.putObject(paramObject1, paramLong, paramObject2);
  }
  
  static double charAt(Object paramObject, long paramLong)
  {
    return zzacb.getDouble(paramObject, paramLong);
  }
  
  private static byte convert(Object paramObject, long paramLong)
  {
    return (byte)(getValue(paramObject, 0xFFFFFFFFFFFFFFFC & paramLong) >>> (int)((paramLong & 0x3) << 3));
  }
  
  static void d(Object paramObject, long paramLong, int paramInt)
  {
    zzacb.writeInt(paramObject, paramLong, paramInt);
  }
  
  static void f(Object paramObject, long paramLong, boolean paramBoolean)
  {
    zzacb.f(paramObject, paramLong, paramBoolean);
  }
  
  private static Field find(Class paramClass, String paramString)
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
  
  private static void format(Object paramObject, long paramLong, boolean paramBoolean)
  {
    append(paramObject, paramLong, (byte)paramBoolean);
  }
  
  static void get(byte[] paramArrayOfByte, long paramLong, byte paramByte)
  {
    zzacb.setBytes(paramArrayOfByte, zzacd + paramLong, paramByte);
  }
  
  private static boolean get(Class paramClass)
  {
    if (!zzfv.zzat()) {
      return false;
    }
    try
    {
      Class localClass1 = zzty;
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
  
  private static int getField(Class paramClass)
  {
    if (zzum) {
      return zzacbzzact.arrayBaseOffset(paramClass);
    }
    return -1;
  }
  
  static long getId(Object paramObject, long paramLong)
  {
    return zzacb.getLong(paramObject, paramLong);
  }
  
  static Object getName(Object paramObject, long paramLong)
  {
    return zzacbzzact.getObject(paramObject, paramLong);
  }
  
  static int getValue(Object paramObject, long paramLong)
  {
    return zzacb.getInt(paramObject, paramLong);
  }
  
  static boolean next(Object paramObject, long paramLong)
  {
    return zzacb.f(paramObject, paramLong);
  }
  
  static byte parse(byte[] paramArrayOfByte, long paramLong)
  {
    return zzacb.readByte(paramArrayOfByte, zzacd + paramLong);
  }
  
  private static int read(Class paramClass)
  {
    if (zzum) {
      return zzacbzzact.arrayIndexScale(paramClass);
    }
    return -1;
  }
  
  static Object setField(Class paramClass)
  {
    Unsafe localUnsafe = zzaad;
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
  
  static float size(Object paramObject, long paramLong)
  {
    return zzacb.readFloat(paramObject, paramLong);
  }
  
  private static byte toString(Object paramObject, long paramLong)
  {
    return (byte)(getValue(paramObject, 0xFFFFFFFFFFFFFFFC & paramLong) >>> (int)((paramLong & 0x3) << 3));
  }
  
  static void visitLdcInsn(Object paramObject, long paramLong1, long paramLong2)
  {
    zzacb.writeLong(paramObject, paramLong1, paramLong2);
  }
  
  private static void write(Object paramObject, long paramLong, byte paramByte)
  {
    long l = 0xFFFFFFFFFFFFFFFC & paramLong;
    int i = getValue(paramObject, l);
    int j = ((int)paramLong & 0x3) << 3;
    d(paramObject, l, (0xFF & paramByte) << j | i & 255 << j);
  }
  
  static void write(Object paramObject, long paramLong, double paramDouble)
  {
    zzacb.writeDouble(paramObject, paramLong, paramDouble);
  }
  
  static void write(Object paramObject, long paramLong, float paramFloat)
  {
    zzacb.writeFloat(paramObject, paramLong, paramFloat);
  }
  
  static boolean zzdr()
  {
    return zzum;
  }
  
  static boolean zzds()
  {
    return zzacc;
  }
  
  static Unsafe zzdt()
  {
    try
    {
      Unsafe localUnsafe = (Unsafe)AccessController.doPrivileged(new zzjx());
      return localUnsafe;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    return null;
  }
  
  private static boolean zzdu()
  {
    Object localObject1 = zzaad;
    if (localObject1 == null) {
      return false;
    }
    try
    {
      localObject1 = localObject1.getClass();
      ((Class)localObject1).getMethod("objectFieldOffset", new Class[] { Field.class });
      ((Class)localObject1).getMethod("arrayBaseOffset", new Class[] { Class.class });
      ((Class)localObject1).getMethod("arrayIndexScale", new Class[] { Class.class });
      localObject2 = Long.TYPE;
      ((Class)localObject1).getMethod("getInt", new Class[] { Object.class, localObject2 });
      ((Class)localObject1).getMethod("putInt", new Class[] { Object.class, localObject2, Integer.TYPE });
      ((Class)localObject1).getMethod("getLong", new Class[] { Object.class, localObject2 });
      ((Class)localObject1).getMethod("putLong", new Class[] { Object.class, localObject2, localObject2 });
      ((Class)localObject1).getMethod("getObject", new Class[] { Object.class, localObject2 });
      ((Class)localObject1).getMethod("putObject", new Class[] { Object.class, localObject2, Object.class });
      boolean bool = zzfv.zzat();
      if (bool) {
        return true;
      }
      ((Class)localObject1).getMethod("getByte", new Class[] { Object.class, localObject2 });
      ((Class)localObject1).getMethod("putByte", new Class[] { Object.class, localObject2, Byte.TYPE });
      ((Class)localObject1).getMethod("getBoolean", new Class[] { Object.class, localObject2 });
      ((Class)localObject1).getMethod("putBoolean", new Class[] { Object.class, localObject2, Boolean.TYPE });
      ((Class)localObject1).getMethod("getFloat", new Class[] { Object.class, localObject2 });
      ((Class)localObject1).getMethod("putFloat", new Class[] { Object.class, localObject2, Float.TYPE });
      ((Class)localObject1).getMethod("getDouble", new Class[] { Object.class, localObject2 });
      ((Class)localObject1).getMethod("putDouble", new Class[] { Object.class, localObject2, Double.TYPE });
      return true;
    }
    catch (Throwable localThrowable)
    {
      localObject1 = logger;
      Object localObject2 = Level.WARNING;
      String str = String.valueOf(localThrowable);
      StringBuilder localStringBuilder = new StringBuilder(str.length() + 71);
      localStringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
      localStringBuilder.append(str);
      ((Logger)localObject1).logp((Level)localObject2, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", localStringBuilder.toString());
    }
    return false;
  }
  
  private static boolean zzdv()
  {
    Object localObject1 = zzaad;
    if (localObject1 == null) {
      return false;
    }
    try
    {
      localObject1 = localObject1.getClass();
      ((Class)localObject1).getMethod("objectFieldOffset", new Class[] { Field.class });
      localObject2 = Long.TYPE;
      ((Class)localObject1).getMethod("getLong", new Class[] { Object.class, localObject2 });
      Field localField = zzdw();
      if (localField == null) {
        return false;
      }
      boolean bool = zzfv.zzat();
      if (bool) {
        return true;
      }
      ((Class)localObject1).getMethod("getByte", new Class[] { localObject2 });
      ((Class)localObject1).getMethod("putByte", new Class[] { localObject2, Byte.TYPE });
      ((Class)localObject1).getMethod("getInt", new Class[] { localObject2 });
      ((Class)localObject1).getMethod("putInt", new Class[] { localObject2, Integer.TYPE });
      ((Class)localObject1).getMethod("getLong", new Class[] { localObject2 });
      ((Class)localObject1).getMethod("putLong", new Class[] { localObject2, localObject2 });
      ((Class)localObject1).getMethod("copyMemory", new Class[] { localObject2, localObject2, localObject2 });
      ((Class)localObject1).getMethod("copyMemory", new Class[] { Object.class, localObject2, Object.class, localObject2, localObject2 });
      return true;
    }
    catch (Throwable localThrowable)
    {
      localObject1 = logger;
      Object localObject2 = Level.WARNING;
      String str = String.valueOf(localThrowable);
      StringBuilder localStringBuilder = new StringBuilder(str.length() + 71);
      localStringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
      localStringBuilder.append(str);
      ((Logger)localObject1).logp((Level)localObject2, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", localStringBuilder.toString());
    }
    return false;
  }
  
  private static Field zzdw()
  {
    if (zzfv.zzat())
    {
      localField = find(Buffer.class, "effectiveDirectAddress");
      if (localField != null) {
        return localField;
      }
    }
    Field localField = find(Buffer.class, "address");
    if ((localField != null) && (localField.getType() == Long.TYPE)) {
      return localField;
    }
    return null;
  }
  
  private static final class zza
    extends zzjy.zzc
  {
    zza(Unsafe paramUnsafe)
    {
      super();
    }
    
    public final void f(Object paramObject, long paramLong, boolean paramBoolean)
    {
      if (zzjy.zzacs)
      {
        zzjy.e(paramObject, paramLong, paramBoolean);
        return;
      }
      zzjy.d(paramObject, paramLong, paramBoolean);
    }
    
    public final boolean f(Object paramObject, long paramLong)
    {
      if (zzjy.zzacs) {
        return zzjy.d(paramObject, paramLong);
      }
      return zzjy.f(paramObject, paramLong);
    }
    
    public final double getDouble(Object paramObject, long paramLong)
    {
      return Double.longBitsToDouble(getLong(paramObject, paramLong));
    }
    
    public final byte readByte(Object paramObject, long paramLong)
    {
      if (zzjy.zzacs) {
        return zzjy.read(paramObject, paramLong);
      }
      return zzjy.get(paramObject, paramLong);
    }
    
    public final float readFloat(Object paramObject, long paramLong)
    {
      return Float.intBitsToFloat(getInt(paramObject, paramLong));
    }
    
    public final void setBytes(Object paramObject, long paramLong, byte paramByte)
    {
      if (zzjy.zzacs)
      {
        zzjy.put(paramObject, paramLong, paramByte);
        return;
      }
      zzjy.add(paramObject, paramLong, paramByte);
    }
    
    public final void writeDouble(Object paramObject, long paramLong, double paramDouble)
    {
      writeLong(paramObject, paramLong, Double.doubleToLongBits(paramDouble));
    }
    
    public final void writeFloat(Object paramObject, long paramLong, float paramFloat)
    {
      writeInt(paramObject, paramLong, Float.floatToIntBits(paramFloat));
    }
  }
  
  private static final class zzb
    extends zzjy.zzc
  {
    zzb(Unsafe paramUnsafe)
    {
      super();
    }
    
    public final void f(Object paramObject, long paramLong, boolean paramBoolean)
    {
      if (zzjy.zzacs)
      {
        zzjy.e(paramObject, paramLong, paramBoolean);
        return;
      }
      zzjy.d(paramObject, paramLong, paramBoolean);
    }
    
    public final boolean f(Object paramObject, long paramLong)
    {
      if (zzjy.zzacs) {
        return zzjy.d(paramObject, paramLong);
      }
      return zzjy.f(paramObject, paramLong);
    }
    
    public final double getDouble(Object paramObject, long paramLong)
    {
      return Double.longBitsToDouble(getLong(paramObject, paramLong));
    }
    
    public final byte readByte(Object paramObject, long paramLong)
    {
      if (zzjy.zzacs) {
        return zzjy.read(paramObject, paramLong);
      }
      return zzjy.get(paramObject, paramLong);
    }
    
    public final float readFloat(Object paramObject, long paramLong)
    {
      return Float.intBitsToFloat(getInt(paramObject, paramLong));
    }
    
    public final void setBytes(Object paramObject, long paramLong, byte paramByte)
    {
      if (zzjy.zzacs)
      {
        zzjy.put(paramObject, paramLong, paramByte);
        return;
      }
      zzjy.add(paramObject, paramLong, paramByte);
    }
    
    public final void writeDouble(Object paramObject, long paramLong, double paramDouble)
    {
      writeLong(paramObject, paramLong, Double.doubleToLongBits(paramDouble));
    }
    
    public final void writeFloat(Object paramObject, long paramLong, float paramFloat)
    {
      writeInt(paramObject, paramLong, Float.floatToIntBits(paramFloat));
    }
  }
  
  private static abstract class zzc
  {
    Unsafe zzact;
    
    zzc(Unsafe paramUnsafe)
    {
      zzact = paramUnsafe;
    }
    
    public abstract void f(Object paramObject, long paramLong, boolean paramBoolean);
    
    public abstract boolean f(Object paramObject, long paramLong);
    
    public abstract double getDouble(Object paramObject, long paramLong);
    
    public final int getInt(Object paramObject, long paramLong)
    {
      return zzact.getInt(paramObject, paramLong);
    }
    
    public final long getLong(Object paramObject, long paramLong)
    {
      return zzact.getLong(paramObject, paramLong);
    }
    
    public abstract byte readByte(Object paramObject, long paramLong);
    
    public abstract float readFloat(Object paramObject, long paramLong);
    
    public abstract void setBytes(Object paramObject, long paramLong, byte paramByte);
    
    public abstract void writeDouble(Object paramObject, long paramLong, double paramDouble);
    
    public abstract void writeFloat(Object paramObject, long paramLong, float paramFloat);
    
    public final void writeInt(Object paramObject, long paramLong, int paramInt)
    {
      zzact.putInt(paramObject, paramLong, paramInt);
    }
    
    public final void writeLong(Object paramObject, long paramLong1, long paramLong2)
    {
      zzact.putLong(paramObject, paramLong1, paramLong2);
    }
  }
  
  private static final class zzd
    extends zzjy.zzc
  {
    zzd(Unsafe paramUnsafe)
    {
      super();
    }
    
    public final void f(Object paramObject, long paramLong, boolean paramBoolean)
    {
      zzact.putBoolean(paramObject, paramLong, paramBoolean);
    }
    
    public final boolean f(Object paramObject, long paramLong)
    {
      return zzact.getBoolean(paramObject, paramLong);
    }
    
    public final double getDouble(Object paramObject, long paramLong)
    {
      return zzact.getDouble(paramObject, paramLong);
    }
    
    public final byte readByte(Object paramObject, long paramLong)
    {
      return zzact.getByte(paramObject, paramLong);
    }
    
    public final float readFloat(Object paramObject, long paramLong)
    {
      return zzact.getFloat(paramObject, paramLong);
    }
    
    public final void setBytes(Object paramObject, long paramLong, byte paramByte)
    {
      zzact.putByte(paramObject, paramLong, paramByte);
    }
    
    public final void writeDouble(Object paramObject, long paramLong, double paramDouble)
    {
      zzact.putDouble(paramObject, paramLong, paramDouble);
    }
    
    public final void writeFloat(Object paramObject, long paramLong, float paramFloat)
    {
      zzact.putFloat(paramObject, paramLong, paramFloat);
    }
  }
}
