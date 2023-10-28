package com.google.android.gms.internal.fitness;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzgn
  implements zzkm
{
  private final zzgk zzuh;
  
  private zzgn(zzgk paramZzgk)
  {
    paramZzgk = (zzgk)zzhc.get(paramZzgk, "output");
    zzuh = paramZzgk;
    zzun = this;
  }
  
  public static zzgn f(zzgk paramZzgk)
  {
    zzgn localZzgn = zzun;
    if (localZzgn != null) {
      return localZzgn;
    }
    return new zzgn(paramZzgk);
  }
  
  public final void a(int paramInt, List paramList)
    throws IOException
  {
    int i = 0;
    while (i < paramList.size())
    {
      zzuh.write(paramInt, (zzfx)paramList.get(i));
      i += 1;
    }
  }
  
  public final void a(int paramInt, List paramList, zzja paramZzja)
    throws IOException
  {
    int i = 0;
    while (i < paramList.size())
    {
      write(paramInt, paramList.get(i), paramZzja);
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
      zzuh.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzgk.invoke(((Double)paramList.get(paramInt)).doubleValue());
        paramInt += 1;
      }
      zzuh.add(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        zzuh.a(((Double)paramList.get(paramInt)).doubleValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      zzuh.a(paramInt, ((Double)paramList.get(i)).doubleValue());
      i += 1;
    }
  }
  
  public final void add(int paramInt, float paramFloat)
    throws IOException
  {
    zzuh.set(paramInt, paramFloat);
  }
  
  public final void add(int paramInt, Object paramObject, zzja paramZzja)
    throws IOException
  {
    zzgk localZzgk = zzuh;
    paramObject = (zzik)paramObject;
    localZzgk.writeTag(paramInt, 3);
    paramZzja.a(paramObject, zzun);
    localZzgk.writeTag(paramInt, 4);
  }
  
  public final void add(int paramInt, List paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      zzuh.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzgk.round(((Float)paramList.get(paramInt)).floatValue());
        paramInt += 1;
      }
      zzuh.add(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        zzuh.a(((Float)paramList.get(paramInt)).floatValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      zzuh.set(paramInt, ((Float)paramList.get(i)).floatValue());
      i += 1;
    }
  }
  
  public final void apply(int paramInt, List paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      zzuh.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzgk.convert(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      zzuh.add(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        zzuh.write(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      zzuh.put(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public final void b(int paramInt, double paramDouble)
    throws IOException
  {
    zzuh.a(paramInt, paramDouble);
  }
  
  public final void deleteServer(int paramInt, long paramLong)
    throws IOException
  {
    zzuh.append(paramInt, paramLong);
  }
  
  public final void execute(int paramInt, List paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      zzuh.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzgk.evaluate(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      zzuh.add(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        zzuh.add(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      zzuh.append(paramInt, ((Long)paramList.get(i)).longValue());
      i += 1;
    }
  }
  
  public final void f(int paramInt, boolean paramBoolean)
    throws IOException
  {
    zzuh.decode(paramInt, paramBoolean);
  }
  
  public final void fill(int paramInt, List paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      zzuh.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzgk.round(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      zzuh.add(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        zzuh.write(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      zzuh.put(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public final void get(int paramInt1, int paramInt2)
    throws IOException
  {
    zzuh.put(paramInt1, paramInt2);
  }
  
  public final void getPath(int paramInt, List paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      zzuh.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzgk.valueOf(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      zzuh.add(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        zzuh.put(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      zzuh.append(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public final void getShares(int paramInt, List paramList, zzja paramZzja)
    throws IOException
  {
    int i = 0;
    while (i < paramList.size())
    {
      add(paramInt, paramList.get(i), paramZzja);
      i += 1;
    }
  }
  
  public final void getValue(int paramInt, List paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      zzuh.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzgk.next(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      zzuh.add(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        zzuh.add(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      zzuh.append(paramInt, ((Long)paramList.get(i)).longValue());
      i += 1;
    }
  }
  
  public final void init(int paramInt, List paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      zzuh.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzgk.getInt(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      zzuh.add(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        zzuh.getSession(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      zzuh.add(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public final void initialize(int paramInt, List paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      zzuh.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzgk.valueOf(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      zzuh.add(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        zzuh.getHeader(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      zzuh.add(paramInt, ((Long)paramList.get(i)).longValue());
      i += 1;
    }
  }
  
  public final void remap(int paramInt, List paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      zzuh.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzgk.get(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      zzuh.add(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        zzuh.put(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      zzuh.append(paramInt, ((Integer)paramList.get(i)).intValue());
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
      zzuh.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzgk.get(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      zzuh.add(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        zzuh.read(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      zzuh.put(paramInt, ((Long)paramList.get(i)).longValue());
      i += 1;
    }
  }
  
  public final void setProperty(int paramInt, Object paramObject)
    throws IOException
  {
    if ((paramObject instanceof zzfx))
    {
      zzuh.writeValue(paramInt, (zzfx)paramObject);
      return;
    }
    zzuh.writeValue(paramInt, (zzik)paramObject);
  }
  
  public final void setRecurrence(int paramInt, long paramLong)
    throws IOException
  {
    zzuh.put(paramInt, paramLong);
  }
  
  public final void toString(int paramInt, List paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      zzuh.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzgk.value(((Boolean)paramList.get(paramInt)).booleanValue());
        paramInt += 1;
      }
      zzuh.add(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        zzuh.decode(((Boolean)paramList.get(paramInt)).booleanValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      zzuh.decode(paramInt, ((Boolean)paramList.get(i)).booleanValue());
      i += 1;
    }
  }
  
  public final void updateBook(int paramInt, long paramLong)
    throws IOException
  {
    zzuh.append(paramInt, paramLong);
  }
  
  public final void upload(int paramInt, List paramList)
    throws IOException
  {
    boolean bool = paramList instanceof zzhr;
    int i = 0;
    int j = 0;
    if (bool)
    {
      zzhr localZzhr = (zzhr)paramList;
      i = j;
      while (i < paramList.size())
      {
        Object localObject = localZzhr.zzaf(i);
        if ((localObject instanceof String)) {
          zzuh.writeBytes(paramInt, (String)localObject);
        } else {
          zzuh.write(paramInt, (zzfx)localObject);
        }
        i += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      zzuh.writeBytes(paramInt, (String)paramList.get(i));
      i += 1;
    }
  }
  
  public final void visitFieldInsn(int paramInt1, int paramInt2)
    throws IOException
  {
    zzuh.add(paramInt1, paramInt2);
  }
  
  public final void visitIntInsn(int paramInt1, int paramInt2)
    throws IOException
  {
    zzuh.append(paramInt1, paramInt2);
  }
  
  public final void visitLocalVariable(int paramInt, long paramLong)
    throws IOException
  {
    zzuh.add(paramInt, paramLong);
  }
  
  public final void visitLocalVariable(int paramInt, zzfx paramZzfx)
    throws IOException
  {
    zzuh.write(paramInt, paramZzfx);
  }
  
  public final void visitMethodInsn(int paramInt1, int paramInt2)
    throws IOException
  {
    zzuh.get(paramInt1, paramInt2);
  }
  
  public final void visitTableSwitchInsn(int paramInt1, int paramInt2)
    throws IOException
  {
    zzuh.put(paramInt1, paramInt2);
  }
  
  public final void visitVarInsn(int paramInt1, int paramInt2)
    throws IOException
  {
    zzuh.append(paramInt1, paramInt2);
  }
  
  public final void write(int paramInt, long paramLong)
    throws IOException
  {
    zzuh.put(paramInt, paramLong);
  }
  
  public final void write(int paramInt, zzib paramZzib, Map paramMap)
    throws IOException
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject1 = (Map.Entry)paramMap.next();
      zzuh.writeTag(paramInt, 2);
      zzgk localZzgk = zzuh;
      Object localObject2 = ((Map.Entry)localObject1).getKey();
      Object localObject3 = ((Map.Entry)localObject1).getValue();
      localZzgk.add(zzgt.write(zzzt, 1, localObject2) + zzgt.write(zzzu, 2, localObject3));
      localZzgk = zzuh;
      localObject2 = ((Map.Entry)localObject1).getKey();
      localObject1 = ((Map.Entry)localObject1).getValue();
      zzgt.write(localZzgk, zzzt, 1, localObject2);
      zzgt.write(localZzgk, zzzu, 2, localObject1);
    }
  }
  
  public final void write(int paramInt, Object paramObject, zzja paramZzja)
    throws IOException
  {
    zzuh.writeElement(paramInt, (zzik)paramObject, paramZzja);
  }
  
  public final void write(int paramInt, List paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      zzuh.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzgk.append(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      zzuh.add(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        zzuh.add(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      zzuh.get(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public final void writeChars(int paramInt, String paramString)
    throws IOException
  {
    zzuh.writeBytes(paramInt, paramString);
  }
  
  public final void writeTo(int paramInt, List paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      zzuh.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzgk.toString(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      zzuh.add(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        zzuh.read(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      zzuh.put(paramInt, ((Long)paramList.get(i)).longValue());
      i += 1;
    }
  }
  
  public final void zzaa(int paramInt)
    throws IOException
  {
    zzuh.writeTag(paramInt, 3);
  }
  
  public final void zzab(int paramInt)
    throws IOException
  {
    zzuh.writeTag(paramInt, 4);
  }
  
  public final int zzbe()
  {
    return zzkl.zzaea;
  }
}
