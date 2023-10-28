package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

abstract class zzmw
{
  final Unsafe data;
  
  zzmw(Unsafe paramUnsafe)
  {
    data = paramUnsafe;
  }
  
  public abstract double a(Object paramObject, long paramLong);
  
  public abstract void append(Object paramObject, long paramLong, double paramDouble);
  
  public abstract void append(Object paramObject, long paramLong, float paramFloat);
  
  public final void append(Object paramObject, long paramLong, int paramInt)
  {
    data.putInt(paramObject, paramLong, paramInt);
  }
  
  public abstract boolean b(Object paramObject, long paramLong);
  
  public final int copy(Class paramClass)
  {
    return data.arrayIndexScale(paramClass);
  }
  
  public final void copy(Object paramObject1, long paramLong, Object paramObject2)
  {
    data.putObject(paramObject1, paramLong, paramObject2);
  }
  
  public abstract void e(Object paramObject, long paramLong, byte paramByte);
  
  public abstract void f(Object paramObject, long paramLong, boolean paramBoolean);
  
  public abstract float get(Object paramObject, long paramLong);
  
  public final Object invoke(Object paramObject, long paramLong)
  {
    return data.getObject(paramObject, paramLong);
  }
  
  public final long put(Field paramField)
  {
    return data.objectFieldOffset(paramField);
  }
  
  public final int read(Class paramClass)
  {
    return data.arrayBaseOffset(paramClass);
  }
  
  public final int readInt(Object paramObject, long paramLong)
  {
    return data.getInt(paramObject, paramLong);
  }
  
  public final long readLong(Object paramObject, long paramLong)
  {
    return data.getLong(paramObject, paramLong);
  }
  
  public final void set(Object paramObject, long paramLong1, long paramLong2)
  {
    data.putLong(paramObject, paramLong1, paramLong2);
  }
}
