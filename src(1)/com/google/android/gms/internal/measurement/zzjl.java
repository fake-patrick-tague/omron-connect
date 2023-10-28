package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzjl
  extends zzit
{
  private static final Logger logger = Logger.getLogger(zzjl.class.getName());
  private static final boolean version = zzmx.getValue();
  zzjm y;
  
  private zzjl() {}
  
  public static int a(String paramString)
  {
    try
    {
      i = zznc.decode(paramString);
    }
    catch (zznb localZznb)
    {
      int i;
      for (;;) {}
    }
    i = paramString.getBytes(zzkm.a).length;
    return append(i) + i;
  }
  
  public static int append(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((paramInt & 0xF0000000) == 0) {
      return 4;
    }
    return 5;
  }
  
  static int b(int paramInt, zzll paramZzll, zzlw paramZzlw)
  {
    int j = append(paramInt << 3);
    paramZzll = (zzin)paramZzll;
    int i = paramZzll.zzbr();
    paramInt = i;
    if (i == -1)
    {
      i = paramZzlw.b(paramZzll);
      paramInt = i;
      paramZzll.zzbu(i);
    }
    return j + j + paramInt;
  }
  
  public static int b(zzjd paramZzjd)
  {
    int i = paramZzjd.size();
    return append(i) + i;
  }
  
  static int f(zzll paramZzll, zzlw paramZzlw)
  {
    paramZzll = (zzin)paramZzll;
    int j = paramZzll.zzbr();
    int i = j;
    if (j == -1)
    {
      j = paramZzlw.b(paramZzll);
      i = j;
      paramZzll.zzbu(j);
    }
    return append(i) + i;
  }
  
  public static int get(int paramInt)
  {
    if (paramInt >= 0) {
      return append(paramInt);
    }
    return 10;
  }
  
  public static int get(long paramLong)
  {
    if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if (paramLong < 0L) {
      return 10;
    }
    if ((0xFFFFFFF800000000 & paramLong) != 0L)
    {
      paramLong >>>= 28;
      j = 6;
    }
    else
    {
      j = 2;
    }
    int i = j;
    long l = paramLong;
    if ((0xFFFFFFFFFFE00000 & paramLong) != 0L)
    {
      i = j + 2;
      l = paramLong >>> 14;
    }
    int j = i;
    if ((l & 0xFFFFFFFFFFFFC000) != 0L) {
      j = i + 1;
    }
    return j;
  }
  
  public static int getValue(int paramInt)
  {
    return append(paramInt << 3);
  }
  
  public static int p(zzkr paramZzkr)
  {
    int i = paramZzkr.length();
    return append(i) + i;
  }
  
  public static zzjl shrink(byte[] paramArrayOfByte)
  {
    return new zzji(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public abstract void add(byte paramByte)
    throws IOException;
  
  public abstract void add(int paramInt)
    throws IOException;
  
  public abstract void add(int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void add(int paramInt, long paramLong)
    throws IOException;
  
  public abstract void append(int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void append(int paramInt, String paramString)
    throws IOException;
  
  public abstract void append(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void get(int paramInt, long paramLong)
    throws IOException;
  
  public abstract int getColor();
  
  public abstract void put(int paramInt)
    throws IOException;
  
  public abstract void read(long paramLong)
    throws IOException;
  
  public abstract void remove(int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void remove(int paramInt, zzjd paramZzjd)
    throws IOException;
  
  public abstract void set(int paramInt1, int paramInt2)
    throws IOException;
  
  public final void startDragging()
  {
    if (getColor() == 0) {
      return;
    }
    throw new IllegalStateException("Did not write as much data as expected.");
  }
  
  public abstract void toString(int paramInt)
    throws IOException;
  
  public abstract void toString(long paramLong)
    throws IOException;
  
  final void warn(String paramString, zznb paramZznb)
    throws IOException
  {
    logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", paramZznb);
    paramString = paramString.getBytes(zzkm.a);
    int i = paramString.length;
    try
    {
      toString(i);
      append(paramString, 0, i);
      return;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      throw new zzjj(paramString);
    }
  }
  
  public abstract void write(int paramInt, boolean paramBoolean)
    throws IOException;
}
