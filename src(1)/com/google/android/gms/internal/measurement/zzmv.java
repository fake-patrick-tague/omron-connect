package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

final class zzmv
  extends zzmw
{
  zzmv(Unsafe paramUnsafe)
  {
    super(paramUnsafe);
  }
  
  public final double a(Object paramObject, long paramLong)
  {
    return Double.longBitsToDouble(readLong(paramObject, paramLong));
  }
  
  public final void append(Object paramObject, long paramLong, double paramDouble)
  {
    set(paramObject, paramLong, Double.doubleToLongBits(paramDouble));
  }
  
  public final void append(Object paramObject, long paramLong, float paramFloat)
  {
    append(paramObject, paramLong, Float.floatToIntBits(paramFloat));
  }
  
  public final boolean b(Object paramObject, long paramLong)
  {
    if (zzmx.h) {
      return zzmx.a(paramObject, paramLong);
    }
    return zzmx.b(paramObject, paramLong);
  }
  
  public final void e(Object paramObject, long paramLong, byte paramByte)
  {
    if (zzmx.h)
    {
      zzmx.round(paramObject, paramLong, paramByte);
      return;
    }
    zzmx.addEntry(paramObject, paramLong, paramByte);
  }
  
  public final void f(Object paramObject, long paramLong, boolean paramBoolean)
  {
    if (zzmx.h)
    {
      zzmx.add(paramObject, paramLong, paramBoolean);
      return;
    }
    zzmx.put(paramObject, paramLong, paramBoolean);
  }
  
  public final float get(Object paramObject, long paramLong)
  {
    return Float.intBitsToFloat(readInt(paramObject, paramLong));
  }
}
