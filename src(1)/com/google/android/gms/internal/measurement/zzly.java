package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzly
{
  private static final zzmn RECONNECT = new zzmp();
  private static final zzmn content;
  private static final Class fragmentClass;
  private static final zzmn time;
  
  static
  {
    try
    {
      localClass = Class.forName("com.google.protobuf.GeneratedMessage");
    }
    catch (Throwable localThrowable)
    {
      Class localClass;
      for (;;) {}
    }
    localClass = null;
    fragmentClass = localClass;
    content = zzab(false);
    time = zzab(true);
  }
  
  static int a(int paramInt, Object paramObject, zzlw paramZzlw)
  {
    if ((paramObject instanceof zzkr))
    {
      paramObject = (zzkr)paramObject;
      paramInt = zzjl.append(paramInt << 3);
      int i = paramObject.length();
      return paramInt + (zzjl.append(i) + i);
    }
    paramObject = (zzll)paramObject;
    return zzjl.append(paramInt << 3) + zzjl.f(paramObject, paramZzlw);
  }
  
  static int a(int paramInt, List paramList)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0) {
      return 0;
    }
    i *= zzjl.getValue(paramInt);
    paramInt = j;
    while (paramInt < paramList.size())
    {
      i += zzjl.b((zzjd)paramList.get(paramInt));
      paramInt += 1;
    }
    return i;
  }
  
  static int a(int paramInt, List paramList, zzlw paramZzlw)
  {
    int k = paramList.size();
    int j = 0;
    if (k == 0) {
      return 0;
    }
    int i = zzjl.getValue(paramInt) * k;
    paramInt = j;
    while (paramInt < k)
    {
      Object localObject = paramList.get(paramInt);
      if ((localObject instanceof zzkr)) {
        j = zzjl.p((zzkr)localObject);
      } else {
        j = zzjl.f((zzll)localObject, paramZzlw);
      }
      i += j;
      paramInt += 1;
    }
    return i;
  }
  
  static int a(int paramInt, List paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return read(paramList) + i * zzjl.getValue(paramInt);
  }
  
  static int a(List paramList)
  {
    int m = paramList.size();
    int j = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    long l;
    if ((paramList instanceof zzla))
    {
      paramList = (zzla)paramList;
      i = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        l = paramList.getValue(k);
        i += zzjl.get(l >> 63 ^ l + l);
        k += 1;
      }
    }
    int i = 0;
    k = j;
    for (;;)
    {
      j = i;
      if (k >= m) {
        break;
      }
      l = ((Long)paramList.get(k)).longValue();
      i += zzjl.get(l >> 63 ^ l + l);
      k += 1;
    }
    return j;
  }
  
  static Object a(int paramInt1, int paramInt2, Object paramObject, zzmn paramZzmn)
  {
    Object localObject = paramObject;
    if (paramObject == null) {
      localObject = paramZzmn.b();
    }
    paramZzmn.a(localObject, paramInt1, paramInt2);
    return localObject;
  }
  
  static Object a(int paramInt, List paramList, zzki paramZzki, Object paramObject, zzmn paramZzmn)
  {
    if (paramZzki == null) {
      return paramObject;
    }
    int i;
    if ((paramList instanceof RandomAccess))
    {
      int k = paramList.size();
      i = 0;
      int j = 0;
      while (i < k)
      {
        int m = ((Integer)paramList.get(i)).intValue();
        if (paramZzki.b(m))
        {
          if (i != j) {
            paramList.set(j, Integer.valueOf(m));
          }
          j += 1;
        }
        else
        {
          paramObject = a(paramInt, m, paramObject, paramZzmn);
        }
        i += 1;
      }
      if (j == k) {
        return paramObject;
      }
      paramList.subList(j, k).clear();
      return paramObject;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      if (!paramZzki.b(i))
      {
        paramObject = a(paramInt, i, paramObject, paramZzmn);
        paramList.remove();
      }
    }
    return paramObject;
  }
  
  public static void a(int paramInt, List paramList, zznf paramZznf)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZznf.a(paramInt, paramList);
    }
  }
  
  public static void a(int paramInt, List paramList, zznf paramZznf, zzlw paramZzlw)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = 0;
      while (i < paramList.size())
      {
        Object localObject = paramList.get(i);
        ((zzjm)paramZznf).b(paramInt, localObject, paramZzlw);
        i += 1;
      }
    }
  }
  
  public static void a(int paramInt, List paramList, zznf paramZznf, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZznf.remap(paramInt, paramList, paramBoolean);
    }
  }
  
  static int add(List paramList)
  {
    int m = paramList.size();
    int j = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    if ((paramList instanceof zzkf))
    {
      paramList = (zzkf)paramList;
      i = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        i += zzjl.get(paramList.next(k));
        k += 1;
      }
    }
    int i = 0;
    k = j;
    for (;;)
    {
      j = i;
      if (k >= m) {
        break;
      }
      i += zzjl.get(((Integer)paramList.get(k)).intValue());
      k += 1;
    }
    return j;
  }
  
  public static void add(int paramInt, List paramList, zznf paramZznf, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZznf.calculate(paramInt, paramList, paramBoolean);
    }
  }
  
  static int append(int paramInt, List paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return i * (zzjl.append(paramInt << 3) + 4);
  }
  
  public static void append(int paramInt, List paramList, zznf paramZznf, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZznf.a(paramInt, paramList, paramBoolean);
    }
  }
  
  static int b(int paramInt, List paramList)
  {
    int m = paramList.size();
    int i = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    int j = zzjl.getValue(paramInt) * m;
    paramInt = j;
    Object localObject;
    if ((paramList instanceof zzkt))
    {
      paramList = (zzkt)paramList;
      paramInt = j;
      i = k;
      for (;;)
      {
        j = paramInt;
        if (i >= m) {
          break;
        }
        localObject = paramList.getKey(i);
        if ((localObject instanceof zzjd)) {
          j = zzjl.b((zzjd)localObject);
        } else {
          j = zzjl.a((String)localObject);
        }
        paramInt += j;
        i += 1;
      }
    }
    for (;;)
    {
      j = paramInt;
      if (i >= m) {
        break;
      }
      localObject = paramList.get(i);
      if ((localObject instanceof zzjd)) {
        j = zzjl.b((zzjd)localObject);
      } else {
        j = zzjl.a((String)localObject);
      }
      paramInt += j;
      i += 1;
    }
    return j;
  }
  
  static int b(int paramInt, List paramList, zzlw paramZzlw)
  {
    int k = paramList.size();
    int i = 0;
    if (k != 0)
    {
      int j = 0;
      while (i < k)
      {
        j += zzjl.b(paramInt, (zzll)paramList.get(i), paramZzlw);
        i += 1;
      }
      return j;
    }
    return 0;
  }
  
  static int b(int paramInt, List paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return a(paramList) + i * zzjl.getValue(paramInt);
  }
  
  public static void b(int paramInt, List paramList, zznf paramZznf)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZznf.replace(paramInt, paramList);
    }
  }
  
  public static void b(int paramInt, List paramList, zznf paramZznf, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZznf.replace(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void connect(int paramInt, List paramList, zznf paramZznf, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZznf.saveData(paramInt, paramList, paramBoolean);
    }
  }
  
  static int elementAt(int paramInt, List paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return get(paramList) + i * zzjl.getValue(paramInt);
  }
  
  static int encode(List paramList)
  {
    int m = paramList.size();
    int j = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    if ((paramList instanceof zzkf))
    {
      paramList = (zzkf)paramList;
      i = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        i += zzjl.append(paramList.next(k));
        k += 1;
      }
    }
    int i = 0;
    k = j;
    for (;;)
    {
      j = i;
      if (k >= m) {
        break;
      }
      i += zzjl.append(((Integer)paramList.get(k)).intValue());
      k += 1;
    }
    return j;
  }
  
  static boolean equals(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != paramObject2)
    {
      if (paramObject1 == null) {
        break label24;
      }
      if (!paramObject1.equals(paramObject2)) {
        return false;
      }
    }
    return true;
    label24:
    return false;
  }
  
  public static void finish(int paramInt, List paramList, zznf paramZznf, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZznf.next(paramInt, paramList, paramBoolean);
    }
  }
  
  public static zzmn forName()
  {
    return RECONNECT;
  }
  
  static int get(int paramInt, List paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return add(paramList) + i * zzjl.getValue(paramInt);
  }
  
  static int get(List paramList)
  {
    int m = paramList.size();
    int j = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    if ((paramList instanceof zzla))
    {
      paramList = (zzla)paramList;
      i = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        i += zzjl.get(paramList.getValue(k));
        k += 1;
      }
    }
    int i = 0;
    k = j;
    for (;;)
    {
      j = i;
      if (k >= m) {
        break;
      }
      i += zzjl.get(((Long)paramList.get(k)).longValue());
      k += 1;
    }
    return j;
  }
  
  public static zzmn get()
  {
    return content;
  }
  
  public static void get(int paramInt, List paramList, zznf paramZznf, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZznf.set(paramInt, paramList, paramBoolean);
    }
  }
  
  static int getAttributeCount(List paramList)
  {
    return paramList.size();
  }
  
  static int getStep(List paramList)
  {
    return paramList.size() * 8;
  }
  
  public static zzmn getTime()
  {
    return time;
  }
  
  static int getValue(List paramList)
  {
    int m = paramList.size();
    int j = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    if ((paramList instanceof zzla))
    {
      paramList = (zzla)paramList;
      i = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        i += zzjl.get(paramList.getValue(k));
        k += 1;
      }
    }
    int i = 0;
    k = j;
    for (;;)
    {
      j = i;
      if (k >= m) {
        break;
      }
      i += zzjl.get(((Long)paramList.get(k)).longValue());
      k += 1;
    }
    return j;
  }
  
  static int indexOf(int paramInt, List paramList, boolean paramBoolean)
  {
    if (paramList.size() == 0) {
      return 0;
    }
    return getValue(paramList) + paramList.size() * zzjl.getValue(paramInt);
  }
  
  public static void indexOf(int paramInt, List paramList, zznf paramZznf, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZznf.read(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void injectMembers(Class paramClass)
  {
    if (!zzke.class.isAssignableFrom(paramClass))
    {
      Class localClass = fragmentClass;
      if (localClass != null)
      {
        if (localClass.isAssignableFrom(paramClass)) {
          return;
        }
        throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
      }
    }
  }
  
  static void invoke(zzjr paramZzjr, Object paramObject1, Object paramObject2)
  {
    paramZzjr.invoke(paramObject2);
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  static void operate(zzmn paramZzmn, Object paramObject1, Object paramObject2)
  {
    paramZzmn.multiply(paramObject1, paramZzmn.add(paramZzmn.getValue(paramObject1), paramZzmn.getValue(paramObject2)));
  }
  
  static int put(int paramInt, List paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return replace(paramList) + i * zzjl.getValue(paramInt);
  }
  
  public static void put(int paramInt, List paramList, zznf paramZznf, zzlw paramZzlw)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = 0;
      while (i < paramList.size())
      {
        Object localObject = paramList.get(i);
        ((zzjm)paramZznf).put(paramInt, localObject, paramZzlw);
        i += 1;
      }
    }
  }
  
  public static void put(int paramInt, List paramList, zznf paramZznf, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZznf.write(paramInt, paramList, paramBoolean);
    }
  }
  
  static int read(List paramList)
  {
    int m = paramList.size();
    int k = 0;
    int j = 0;
    if (m == 0) {
      return 0;
    }
    if ((paramList instanceof zzkf))
    {
      paramList = (zzkf)paramList;
      i = 0;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        k = paramList.next(j);
        i += zzjl.append(k >> 31 ^ k + k);
        j += 1;
      }
    }
    int i = 0;
    j = k;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break;
      }
      k = ((Integer)paramList.get(j)).intValue();
      i += zzjl.append(k >> 31 ^ k + k);
      j += 1;
    }
    return k;
  }
  
  static int replace(List paramList)
  {
    int m = paramList.size();
    int j = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    if ((paramList instanceof zzkf))
    {
      paramList = (zzkf)paramList;
      i = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        i += zzjl.get(paramList.next(k));
        k += 1;
      }
    }
    int i = 0;
    k = j;
    for (;;)
    {
      j = i;
      if (k >= m) {
        break;
      }
      i += zzjl.get(((Integer)paramList.get(k)).intValue());
      k += 1;
    }
    return j;
  }
  
  static int sendChar(List paramList)
  {
    return paramList.size() * 4;
  }
  
  static int set(int paramInt, List paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return i * (zzjl.append(paramInt << 3) + 8);
  }
  
  public static void set(int paramInt, List paramList, zznf paramZznf, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZznf.serialize(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void setProgress(int paramInt, List paramList, zznf paramZznf, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZznf.sendMessage(paramInt, paramList, paramBoolean);
    }
  }
  
  static int toString(int paramInt, List paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return i * (zzjl.append(paramInt << 3) + 1);
  }
  
  public static void toString(int paramInt, List paramList, zznf paramZznf, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZznf.selectPages(paramInt, paramList, paramBoolean);
    }
  }
  
  static int valueOf(int paramInt, List paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return encode(paramList) + i * zzjl.getValue(paramInt);
  }
  
  public static void visitMethodInsn(int paramInt, List paramList, zznf paramZznf, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZznf.execute(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void write(int paramInt, List paramList, zznf paramZznf, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZznf.add(paramInt, paramList, paramBoolean);
    }
  }
  
  static void zzaa(zzlg paramZzlg, Object paramObject1, Object paramObject2, long paramLong)
  {
    zzmx.add(paramObject1, paramLong, zzlg.set(zzmx.getValue(paramObject1, paramLong), zzmx.getValue(paramObject2, paramLong)));
  }
  
  private static zzmn zzab(boolean paramBoolean)
  {
    try
    {
      localObject = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          Object localObject = (zzmn)((Class)localObject).getConstructor(new Class[] { Boolean.TYPE }).newInstance(new Object[] { Boolean.valueOf(paramBoolean) });
          return localObject;
        }
        catch (Throwable localThrowable2) {}
        localThrowable1 = localThrowable1;
      }
    }
    localObject = null;
    if (localObject == null) {
      return null;
    }
    return null;
  }
}
