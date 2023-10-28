package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

final class zzjm
  implements zznf
{
  private final zzjl next;
  
  private zzjm(zzjl paramZzjl)
  {
    zzkm.get(paramZzjl, "output");
    next = paramZzjl;
    y = this;
  }
  
  public static zzjm a(zzjl paramZzjl)
  {
    zzjm localZzjm = y;
    if (localZzjm != null) {
      return localZzjm;
    }
    return new zzjm(paramZzjl);
  }
  
  public final void a(int paramInt, double paramDouble)
    throws IOException
  {
    next.add(paramInt, Double.doubleToRawLongBits(paramDouble));
  }
  
  public final void a(int paramInt, float paramFloat)
    throws IOException
  {
    next.append(paramInt, Float.floatToRawIntBits(paramFloat));
  }
  
  public final void a(int paramInt1, int paramInt2)
    throws IOException
  {
    next.remove(paramInt1, paramInt2 >> 31 ^ paramInt2 + paramInt2);
  }
  
  public final void a(int paramInt, long paramLong)
    throws IOException
  {
    next.get(paramInt, paramLong >> 63 ^ paramLong + paramLong);
  }
  
  public final void a(int paramInt, List paramList)
    throws IOException
  {
    int i = 0;
    while (i < paramList.size())
    {
      next.remove(paramInt, (zzjd)paramList.get(i));
      i += 1;
    }
  }
  
  public final void a(int paramInt, List paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      next.add(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        ((Double)paramList.get(paramInt)).doubleValue();
        i += 8;
        paramInt += 1;
      }
      next.toString(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        next.toString(Double.doubleToRawLongBits(((Double)paramList.get(paramInt)).doubleValue()));
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      next.add(paramInt, Double.doubleToRawLongBits(((Double)paramList.get(i)).doubleValue()));
      i += 1;
    }
  }
  
  public final void add(int paramInt, List paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      next.add(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        ((Integer)paramList.get(paramInt)).intValue();
        i += 4;
        paramInt += 1;
      }
      next.toString(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        next.add(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      next.append(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public final void append(int paramInt1, int paramInt2)
    throws IOException
  {
    next.set(paramInt1, paramInt2);
  }
  
  public final void append(int paramInt, long paramLong)
    throws IOException
  {
    next.add(paramInt, paramLong);
  }
  
  public final void b(int paramInt1, int paramInt2)
    throws IOException
  {
    next.append(paramInt1, paramInt2);
  }
  
  public final void b(int paramInt, long paramLong)
    throws IOException
  {
    next.get(paramInt, paramLong);
  }
  
  public final void b(int paramInt, Object paramObject, zzlw paramZzlw)
    throws IOException
  {
    Object localObject = next;
    paramObject = (zzll)paramObject;
    localObject = (zzji)localObject;
    ((zzji)localObject).toString(paramInt << 3 | 0x2);
    zzin localZzin = (zzin)paramObject;
    int i = localZzin.zzbr();
    paramInt = i;
    if (i == -1)
    {
      i = paramZzlw.b(localZzin);
      paramInt = i;
      localZzin.zzbu(i);
    }
    ((zzji)localObject).toString(paramInt);
    paramZzlw.a(paramObject, y);
  }
  
  public final void b(int paramInt, boolean paramBoolean)
    throws IOException
  {
    next.write(paramInt, paramBoolean);
  }
  
  public final void calculate(int paramInt, List paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    zzjl localZzjl;
    if (paramBoolean)
    {
      next.add(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        int k = ((Integer)paramList.get(paramInt)).intValue();
        i += zzjl.append(k >> 31 ^ k + k);
        paramInt += 1;
      }
      next.toString(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        localZzjl = next;
        i = ((Integer)paramList.get(paramInt)).intValue();
        localZzjl.toString(i >> 31 ^ i + i);
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      localZzjl = next;
      j = ((Integer)paramList.get(i)).intValue();
      localZzjl.remove(paramInt, j >> 31 ^ j + j);
      i += 1;
    }
  }
  
  public final void ensureCapacity(int paramInt, String paramString)
    throws IOException
  {
    next.append(paramInt, paramString);
  }
  
  public final void execute(int paramInt, List paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    long l;
    zzjl localZzjl;
    if (paramBoolean)
    {
      next.add(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        l = ((Long)paramList.get(paramInt)).longValue();
        i += zzjl.get(l >> 63 ^ l + l);
        paramInt += 1;
      }
      next.toString(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        localZzjl = next;
        l = ((Long)paramList.get(paramInt)).longValue();
        localZzjl.read(l >> 63 ^ l + l);
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      localZzjl = next;
      l = ((Long)paramList.get(i)).longValue();
      localZzjl.get(paramInt, l >> 63 ^ l + l);
      i += 1;
    }
  }
  
  public final void get(int paramInt1, int paramInt2)
    throws IOException
  {
    next.set(paramInt1, paramInt2);
  }
  
  public final void get(int paramInt, long paramLong)
    throws IOException
  {
    next.get(paramInt, paramLong);
  }
  
  public final void getInfo(int paramInt)
    throws IOException
  {
    next.add(paramInt, 3);
  }
  
  public final void next(int paramInt, List paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      next.add(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzjl.append(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      next.toString(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        next.toString(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      next.remove(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public final void put(int paramInt1, int paramInt2)
    throws IOException
  {
    next.append(paramInt1, paramInt2);
  }
  
  public final void put(int paramInt, long paramLong)
    throws IOException
  {
    next.add(paramInt, paramLong);
  }
  
  public final void put(int paramInt, zzjd paramZzjd)
    throws IOException
  {
    next.remove(paramInt, paramZzjd);
  }
  
  public final void put(int paramInt, Object paramObject, zzlw paramZzlw)
    throws IOException
  {
    zzjl localZzjl = next;
    paramObject = (zzll)paramObject;
    localZzjl.add(paramInt, 3);
    paramZzlw.a(paramObject, y);
    localZzjl.add(paramInt, 4);
  }
  
  public final void read(int paramInt, List paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      next.add(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        ((Boolean)paramList.get(paramInt)).booleanValue();
        i += 1;
        paramInt += 1;
      }
      next.toString(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        next.add((byte)((Boolean)paramList.get(paramInt)).booleanValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      next.write(paramInt, ((Boolean)paramList.get(i)).booleanValue());
      i += 1;
    }
  }
  
  public final void recurse(int paramInt)
    throws IOException
  {
    next.add(paramInt, 4);
  }
  
  public final void remap(int paramInt, List paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      next.add(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        ((Integer)paramList.get(paramInt)).intValue();
        i += 4;
        paramInt += 1;
      }
      next.toString(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        next.add(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      next.append(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public final void replace(int paramInt, List paramList)
    throws IOException
  {
    boolean bool = paramList instanceof zzkt;
    int i = 0;
    int j = 0;
    if (bool)
    {
      zzkt localZzkt = (zzkt)paramList;
      i = j;
      while (i < paramList.size())
      {
        Object localObject = localZzkt.getKey(i);
        if ((localObject instanceof String)) {
          next.append(paramInt, (String)localObject);
        } else {
          next.remove(paramInt, (zzjd)localObject);
        }
        i += 1;
      }
    }
    while (i < paramList.size())
    {
      next.append(paramInt, (String)paramList.get(i));
      i += 1;
    }
  }
  
  public final void replace(int paramInt, List paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      next.add(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzjl.get(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      next.toString(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        next.read(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      next.get(paramInt, ((Long)paramList.get(i)).longValue());
      i += 1;
    }
  }
  
  public final void saveData(int paramInt, List paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      next.add(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzjl.get(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      next.toString(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        next.read(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      next.get(paramInt, ((Long)paramList.get(i)).longValue());
      i += 1;
    }
  }
  
  public final void selectPages(int paramInt, List paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      next.add(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzjl.get(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      next.toString(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        next.put(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      next.set(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public final void sendMessage(int paramInt, List paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      next.add(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        ((Long)paramList.get(paramInt)).longValue();
        i += 8;
        paramInt += 1;
      }
      next.toString(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        next.toString(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      next.add(paramInt, ((Long)paramList.get(i)).longValue());
      i += 1;
    }
  }
  
  public final void serialize(int paramInt, List paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      next.add(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        ((Float)paramList.get(paramInt)).floatValue();
        i += 4;
        paramInt += 1;
      }
      next.toString(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        next.add(Float.floatToRawIntBits(((Float)paramList.get(paramInt)).floatValue()));
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      next.append(paramInt, Float.floatToRawIntBits(((Float)paramList.get(i)).floatValue()));
      i += 1;
    }
  }
  
  public final void set(int paramInt, List paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      next.add(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzjl.get(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      next.toString(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        next.put(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      next.set(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public final void setProgress(int paramInt1, int paramInt2)
    throws IOException
  {
    next.remove(paramInt1, paramInt2);
  }
  
  public final void write(int paramInt, List paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      next.add(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        ((Long)paramList.get(paramInt)).longValue();
        i += 8;
        paramInt += 1;
      }
      next.toString(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        next.toString(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      next.add(paramInt, ((Long)paramList.get(i)).longValue());
      i += 1;
    }
  }
}
