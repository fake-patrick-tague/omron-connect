package com.google.android.gms.internal.fitness;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzgk
  extends zzfu
{
  private static final Logger logger = Logger.getLogger(zzgk.class.getName());
  private static final boolean zzum = zzjy.zzdr();
  zzgn zzun;
  
  private zzgk() {}
  
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
  
  public static int convert(int paramInt)
  {
    return 4;
  }
  
  private static int d(int paramInt)
  {
    return paramInt >> 31 ^ paramInt << 1;
  }
  
  public static int decode(int paramInt1, int paramInt2)
  {
    return append(paramInt1 << 3) + append(paramInt2);
  }
  
  public static int decode(int paramInt, zzfx paramZzfx)
  {
    paramInt = append(paramInt << 3);
    int i = paramZzfx.size();
    return paramInt + (append(i) + i);
  }
  
  public static int decrypt(int paramInt, zzfx paramZzfx)
  {
    return (append(8) << 1) + decode(2, paramInt) + decode(3, paramZzfx);
  }
  
  public static int evaluate(long paramLong)
  {
    return 8;
  }
  
  public static int format(int paramInt)
  {
    return append(paramInt << 3);
  }
  
  public static int get(int paramInt)
  {
    return valueOf(paramInt);
  }
  
  public static int get(int paramInt, long paramLong)
  {
    return append(paramInt << 3) + 8;
  }
  
  public static int get(int paramInt, zzhp paramZzhp)
  {
    return (append(8) << 1) + decode(2, paramInt) + hash(3, paramZzhp);
  }
  
  public static int get(long paramLong)
  {
    return toString(paramLong);
  }
  
  public static int get(zzfx paramZzfx)
  {
    int i = paramZzfx.size();
    return append(i) + i;
  }
  
  public static int get(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    return append(i) + i;
  }
  
  public static zzgk getByteArray(byte[] paramArrayOfByte)
  {
    return new zza(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int getCard(int paramInt, long paramLong)
  {
    return append(paramInt << 3) + toString(paramLong);
  }
  
  static int getID(zzik paramZzik, zzja paramZzja)
  {
    paramZzik = (zzfo)paramZzik;
    int j = paramZzik.zzan();
    int i = j;
    if (j == -1)
    {
      j = paramZzja.parse(paramZzik);
      i = j;
      paramZzik.append(j);
    }
    return append(i) + i;
  }
  
  static int getIndex(int paramInt, zzik paramZzik, zzja paramZzja)
  {
    return append(paramInt << 3) + getID(paramZzik, paramZzja);
  }
  
  public static int getInt(int paramInt)
  {
    return append(d(paramInt));
  }
  
  public static int getRawValue(zzik paramZzik)
  {
    int i = paramZzik.zzbp();
    return append(i) + i;
  }
  
  static int getTime(int paramInt, zzik paramZzik, zzja paramZzja)
  {
    int j = append(paramInt << 3);
    paramZzik = (zzfo)paramZzik;
    int i = paramZzik.zzan();
    paramInt = i;
    if (i == -1)
    {
      i = paramZzja.parse(paramZzik);
      paramInt = i;
      paramZzik.append(i);
    }
    return (j << 1) + paramInt;
  }
  
  public static int getValue(int paramInt, zzik paramZzik)
  {
    return (append(8) << 1) + decode(2, paramInt) + (append(24) + getRawValue(paramZzik));
  }
  
  public static int getValue(String paramString)
  {
    try
    {
      i = zzka.decode(paramString);
    }
    catch (zzkb localZzkb)
    {
      int i;
      for (;;) {}
    }
    i = paramString.getBytes(zzhc.UTF_8).length;
    return append(i) + i;
  }
  
  private static long getValue(long paramLong)
  {
    return paramLong >> 63 ^ paramLong << 1;
  }
  
  public static int getX(zzhp paramZzhp)
  {
    int i = paramZzhp.zzbp();
    return append(i) + i;
  }
  
  public static int hash(int paramInt, zzhp paramZzhp)
  {
    paramInt = append(paramInt << 3);
    int i = paramZzhp.zzbp();
    return paramInt + (append(i) + i);
  }
  
  public static int invoke(double paramDouble)
  {
    return 8;
  }
  
  public static int isHidden(int paramInt1, int paramInt2)
  {
    return append(paramInt1 << 3) + valueOf(paramInt2);
  }
  
  public static int next(long paramLong)
  {
    return 8;
  }
  
  public static int process_pi_val(int paramInt1, int paramInt2)
  {
    return append(paramInt1 << 3) + append(d(paramInt2));
  }
  
  public static int read(int paramInt1, int paramInt2)
  {
    return append(paramInt1 << 3) + 4;
  }
  
  public static int round(float paramFloat)
  {
    return 4;
  }
  
  public static int round(int paramInt)
  {
    return 4;
  }
  
  public static int skipChar(int paramInt, double paramDouble)
  {
    return append(paramInt << 3) + 8;
  }
  
  public static int skipChar(int paramInt, float paramFloat)
  {
    return append(paramInt << 3) + 4;
  }
  
  public static int skipChar(int paramInt1, int paramInt2)
  {
    return append(paramInt1 << 3) + 4;
  }
  
  public static int skipChar(int paramInt, long paramLong)
  {
    return append(paramInt << 3) + 8;
  }
  
  public static int subtract(zzik paramZzik)
  {
    return paramZzik.zzbp();
  }
  
  public static int toString(int paramInt, long paramLong)
  {
    return append(paramInt << 3) + toString(getValue(paramLong));
  }
  
  public static int toString(int paramInt, boolean paramBoolean)
  {
    return append(paramInt << 3) + 1;
  }
  
  public static int toString(long paramLong)
  {
    if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if (paramLong < 0L) {
      return 10;
    }
    if ((0xFFFFFFF800000000 & paramLong) != 0L)
    {
      j = 6;
      paramLong >>>= 28;
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
  
  public static int updatePlaylist(int paramInt, long paramLong)
  {
    return append(paramInt << 3) + toString(paramLong);
  }
  
  public static int value(int paramInt)
  {
    return append(paramInt);
  }
  
  public static int value(boolean paramBoolean)
  {
    return 1;
  }
  
  public static int valueOf(int paramInt)
  {
    if (paramInt >= 0) {
      return append(paramInt);
    }
    return 10;
  }
  
  public static int valueOf(long paramLong)
  {
    return toString(getValue(paramLong));
  }
  
  public static int write(int paramInt, String paramString)
  {
    return append(paramInt << 3) + getValue(paramString);
  }
  
  public static int writeVTD(int paramInt1, int paramInt2)
  {
    return append(paramInt1 << 3) + valueOf(paramInt2);
  }
  
  public final void a(double paramDouble)
    throws IOException
  {
    add(Double.doubleToRawLongBits(paramDouble));
  }
  
  public final void a(float paramFloat)
    throws IOException
  {
    write(Float.floatToRawIntBits(paramFloat));
  }
  
  public final void a(int paramInt, double paramDouble)
    throws IOException
  {
    append(paramInt, Double.doubleToRawLongBits(paramDouble));
  }
  
  public abstract void add(int paramInt)
    throws IOException;
  
  public final void add(int paramInt1, int paramInt2)
    throws IOException
  {
    get(paramInt1, d(paramInt2));
  }
  
  public final void add(int paramInt, long paramLong)
    throws IOException
  {
    put(paramInt, getValue(paramLong));
  }
  
  public abstract void add(long paramLong)
    throws IOException;
  
  public abstract void append(int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void append(int paramInt, long paramLong)
    throws IOException;
  
  public abstract void decode(int paramInt, boolean paramBoolean)
    throws IOException;
  
  public final void decode(boolean paramBoolean)
    throws IOException
  {
    readBits((byte)paramBoolean);
  }
  
  public abstract void flush(zzfx paramZzfx)
    throws IOException;
  
  public abstract void get(int paramInt1, int paramInt2)
    throws IOException;
  
  public final void getHeader(long paramLong)
    throws IOException
  {
    read(getValue(paramLong));
  }
  
  public final void getSession(int paramInt)
    throws IOException
  {
    add(d(paramInt));
  }
  
  public abstract void put(int paramInt)
    throws IOException;
  
  public abstract void put(int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void put(int paramInt, long paramLong)
    throws IOException;
  
  public abstract void read(long paramLong)
    throws IOException;
  
  public abstract void readBits(byte paramByte)
    throws IOException;
  
  public final void set(int paramInt, float paramFloat)
    throws IOException
  {
    put(paramInt, Float.floatToRawIntBits(paramFloat));
  }
  
  final void warn(String paramString, zzkb paramZzkb)
    throws IOException
  {
    logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", paramZzkb);
    paramString = paramString.getBytes(zzhc.UTF_8);
    int i = paramString.length;
    try
    {
      add(i);
      i = paramString.length;
      put(paramString, 0, i);
      return;
    }
    catch (zzb paramString)
    {
      throw paramString;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      throw new zzb(paramString);
    }
  }
  
  public abstract void write(int paramInt)
    throws IOException;
  
  public abstract void write(int paramInt, zzfx paramZzfx)
    throws IOException;
  
  public abstract void write(String paramString)
    throws IOException;
  
  public abstract void writeBytes(int paramInt, String paramString)
    throws IOException;
  
  abstract void writeElement(int paramInt, zzik paramZzik, zzja paramZzja)
    throws IOException;
  
  public abstract void writeTag(int paramInt1, int paramInt2)
    throws IOException;
  
  abstract void writeTag(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void writeText(zzik paramZzik)
    throws IOException;
  
  public abstract void writeValue(int paramInt, zzfx paramZzfx)
    throws IOException;
  
  public abstract void writeValue(int paramInt, zzik paramZzik)
    throws IOException;
  
  public abstract int zzbc();
  
  private static final class zza
    extends zzgk
  {
    private final byte[] buffer;
    private final int limit;
    private final int offset;
    private int position;
    
    zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      super();
      Objects.requireNonNull(paramArrayOfByte, "buffer");
      if ((paramInt2 | 0x0 | paramArrayOfByte.length - paramInt2) >= 0)
      {
        buffer = paramArrayOfByte;
        offset = 0;
        position = 0;
        limit = paramInt2;
        return;
      }
      throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(0), Integer.valueOf(paramInt2) }));
    }
    
    private final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      byte[] arrayOfByte = buffer;
      int i = position;
      try
      {
        System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, i, paramInt2);
        position += paramInt2;
        return;
      }
      catch (IndexOutOfBoundsException paramArrayOfByte)
      {
        throw new zzgk.zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(position), Integer.valueOf(limit), Integer.valueOf(paramInt2) }), paramArrayOfByte);
      }
    }
    
    public final void add(int paramInt)
      throws IOException
    {
      int i = paramInt;
      byte[] arrayOfByte;
      if (zzgk.zzbd())
      {
        i = paramInt;
        if (!zzfv.zzat())
        {
          i = paramInt;
          if (zzbc() >= 5)
          {
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              arrayOfByte = buffer;
              i = position;
              position = (i + 1);
              zzjy.get(arrayOfByte, i, (byte)paramInt);
              return;
            }
            arrayOfByte = buffer;
            i = position;
            position = (i + 1);
            zzjy.get(arrayOfByte, i, (byte)(paramInt | 0x80));
            paramInt >>>= 7;
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              arrayOfByte = buffer;
              i = position;
              position = (i + 1);
              zzjy.get(arrayOfByte, i, (byte)paramInt);
              return;
            }
            arrayOfByte = buffer;
            i = position;
            position = (i + 1);
            zzjy.get(arrayOfByte, i, (byte)(paramInt | 0x80));
            paramInt >>>= 7;
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              arrayOfByte = buffer;
              i = position;
              position = (i + 1);
              zzjy.get(arrayOfByte, i, (byte)paramInt);
              return;
            }
            arrayOfByte = buffer;
            i = position;
            position = (i + 1);
            zzjy.get(arrayOfByte, i, (byte)(paramInt | 0x80));
            paramInt >>>= 7;
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              arrayOfByte = buffer;
              i = position;
              position = (i + 1);
              zzjy.get(arrayOfByte, i, (byte)paramInt);
              return;
            }
            arrayOfByte = buffer;
            i = position;
            position = (i + 1);
            zzjy.get(arrayOfByte, i, (byte)(paramInt | 0x80));
            arrayOfByte = buffer;
            i = position;
            position = (i + 1);
            zzjy.get(arrayOfByte, i, (byte)(paramInt >>> 7));
            return;
          }
        }
      }
      for (;;)
      {
        if ((i & 0xFFFFFF80) == 0)
        {
          arrayOfByte = buffer;
          paramInt = position;
          position = (paramInt + 1);
          arrayOfByte[paramInt] = ((byte)i);
          return;
        }
        arrayOfByte = buffer;
        paramInt = position;
        position = (paramInt + 1);
        arrayOfByte[paramInt] = ((byte)(i & 0x7F | 0x80));
        i >>>= 7;
      }
    }
    
    public final void add(long paramLong)
      throws IOException
    {
      byte[] arrayOfByte = buffer;
      int j = position;
      int i = j + 1;
      position = i;
      arrayOfByte[j] = ((byte)(int)paramLong);
      j = i + 1;
      position = j;
      arrayOfByte[i] = ((byte)(int)(paramLong >> 8));
      i = j + 1;
      position = i;
      arrayOfByte[j] = ((byte)(int)(paramLong >> 16));
      j = i + 1;
      position = j;
      arrayOfByte[i] = ((byte)(int)(paramLong >> 24));
      i = j + 1;
      position = i;
      arrayOfByte[j] = ((byte)(int)(paramLong >> 32));
      j = i + 1;
      position = j;
      arrayOfByte[i] = ((byte)(int)(paramLong >> 40));
      i = j + 1;
      position = i;
      arrayOfByte[j] = ((byte)(int)(paramLong >> 48));
      position = (i + 1);
      arrayOfByte[i] = ((byte)(int)(paramLong >> 56));
    }
    
    public final void append(int paramInt1, int paramInt2)
      throws IOException
    {
      writeTag(paramInt1, 0);
      put(paramInt2);
    }
    
    public final void append(int paramInt, long paramLong)
      throws IOException
    {
      writeTag(paramInt, 1);
      add(paramLong);
    }
    
    public final void decode(int paramInt, boolean paramBoolean)
      throws IOException
    {
      writeTag(paramInt, 0);
      readBits((byte)paramBoolean);
    }
    
    public final void flush(zzfx paramZzfx)
      throws IOException
    {
      add(paramZzfx.size());
      paramZzfx.markAllAsRead(this);
    }
    
    public final void get(int paramInt1, int paramInt2)
      throws IOException
    {
      writeTag(paramInt1, 0);
      add(paramInt2);
    }
    
    public final void put(int paramInt)
      throws IOException
    {
      if (paramInt >= 0)
      {
        add(paramInt);
        return;
      }
      read(paramInt);
    }
    
    public final void put(int paramInt1, int paramInt2)
      throws IOException
    {
      writeTag(paramInt1, 5);
      write(paramInt2);
    }
    
    public final void put(int paramInt, long paramLong)
      throws IOException
    {
      writeTag(paramInt, 0);
      read(paramLong);
    }
    
    public final void put(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      write(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public final void read(long paramLong)
      throws IOException
    {
      long l = paramLong;
      byte[] arrayOfByte;
      int i;
      if (zzgk.zzbd())
      {
        l = paramLong;
        if (zzbc() >= 10) {
          for (;;)
          {
            if ((paramLong & 0xFFFFFFFFFFFFFF80) == 0L)
            {
              arrayOfByte = buffer;
              i = position;
              position = (i + 1);
              zzjy.get(arrayOfByte, i, (byte)(int)paramLong);
              return;
            }
            arrayOfByte = buffer;
            i = position;
            position = (i + 1);
            zzjy.get(arrayOfByte, i, (byte)((int)paramLong & 0x7F | 0x80));
            paramLong >>>= 7;
          }
        }
      }
      for (;;)
      {
        if ((l & 0xFFFFFFFFFFFFFF80) == 0L)
        {
          arrayOfByte = buffer;
          i = position;
          position = (i + 1);
          arrayOfByte[i] = ((byte)(int)l);
          return;
        }
        arrayOfByte = buffer;
        i = position;
        position = (i + 1);
        arrayOfByte[i] = ((byte)((int)l & 0x7F | 0x80));
        l >>>= 7;
      }
    }
    
    public final void readBits(byte paramByte)
      throws IOException
    {
      byte[] arrayOfByte = buffer;
      int i = position;
      position = (i + 1);
      arrayOfByte[i] = paramByte;
    }
    
    public final void write(int paramInt)
      throws IOException
    {
      byte[] arrayOfByte = buffer;
      int j = position;
      int i = j + 1;
      position = i;
      arrayOfByte[j] = ((byte)paramInt);
      j = i + 1;
      position = j;
      arrayOfByte[i] = ((byte)(paramInt >> 8));
      i = j + 1;
      position = i;
      arrayOfByte[j] = ((byte)(paramInt >> 16));
      position = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt >>> 24));
    }
    
    public final void write(int paramInt, zzfx paramZzfx)
      throws IOException
    {
      writeTag(paramInt, 2);
      flush(paramZzfx);
    }
    
    public final void write(String paramString)
      throws IOException
    {
      int i = position;
      try
      {
        int j = paramString.length();
        int k = zzgk.append(j * 3);
        j = zzgk.append(paramString.length());
        if (j == k)
        {
          k = i + j;
          position = k;
          arrayOfByte = buffer;
          k = zzka.decode(paramString, arrayOfByte, k, zzbc());
          position = i;
          add(k - i - j);
          position = k;
          return;
        }
        add(zzka.decode(paramString));
        byte[] arrayOfByte = buffer;
        j = position;
        j = zzka.decode(paramString, arrayOfByte, j, zzbc());
        position = j;
        return;
      }
      catch (IndexOutOfBoundsException paramString)
      {
        throw new zzgk.zzb(paramString);
      }
      catch (zzkb localZzkb)
      {
        position = i;
        warn(paramString, localZzkb);
      }
    }
    
    public final void writeBytes(int paramInt, String paramString)
      throws IOException
    {
      writeTag(paramInt, 2);
      write(paramString);
    }
    
    final void writeElement(int paramInt, zzik paramZzik, zzja paramZzja)
      throws IOException
    {
      writeTag(paramInt, 2);
      zzfo localZzfo = (zzfo)paramZzik;
      int i = localZzfo.zzan();
      paramInt = i;
      if (i == -1)
      {
        i = paramZzja.parse(localZzfo);
        paramInt = i;
        localZzfo.append(i);
      }
      add(paramInt);
      paramZzja.a(paramZzik, zzun);
    }
    
    public final void writeTag(int paramInt1, int paramInt2)
      throws IOException
    {
      add(paramInt1 << 3 | paramInt2);
    }
    
    public final void writeTag(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      add(paramInt2);
      write(paramArrayOfByte, 0, paramInt2);
    }
    
    public final void writeText(zzik paramZzik)
      throws IOException
    {
      add(paramZzik.zzbp());
      paramZzik.f(this);
    }
    
    public final void writeValue(int paramInt, zzfx paramZzfx)
      throws IOException
    {
      writeTag(1, 3);
      get(2, paramInt);
      write(3, paramZzfx);
      writeTag(1, 4);
    }
    
    public final void writeValue(int paramInt, zzik paramZzik)
      throws IOException
    {
      writeTag(1, 3);
      get(2, paramInt);
      writeTag(3, 2);
      writeText(paramZzik);
      writeTag(1, 4);
    }
    
    public final int zzbc()
    {
      return limit - position;
    }
  }
  
  public static final class zzb
    extends IOException
  {
    zzb()
    {
      super();
    }
    
    zzb(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
    
    zzb(Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}
