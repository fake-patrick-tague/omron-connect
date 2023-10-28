package com.google.android.gms.internal.fitness;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.AbstractMap;
import java.util.List;

final class zzjc
{
  private static final Class<?> zzabg = ;
  private static final zzjs<?, ?> zzabh = refresh(false);
  private static final zzjs<?, ?> zzabi = refresh(true);
  private static final zzjs<?, ?> zzabj = new zzju();
  
  static void add(zzjs paramZzjs, Object paramObject1, Object paramObject2)
  {
    paramZzjs.xor(paramObject1, paramZzjs.linearCombination(paramZzjs.getValue(paramObject1), paramZzjs.getValue(paramObject2)));
  }
  
  static int addBlock(int paramInt, List paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return i * zzgk.toString(paramInt, true);
  }
  
  static int addHeaders(int paramInt, List paramList, zzja paramZzja)
  {
    int k = paramList.size();
    int i = 0;
    if (k == 0) {
      return 0;
    }
    int j = 0;
    while (i < k)
    {
      j += zzgk.getTime(paramInt, (zzik)paramList.get(i), paramZzja);
      i += 1;
    }
    return j;
  }
  
  public static void b(int paramInt, List paramList, zzkm paramZzkm)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZzkm.a(paramInt, paramList);
    }
  }
  
  public static void b(int paramInt, List paramList, zzkm paramZzkm, zzja paramZzja)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZzkm.a(paramInt, paramList, paramZzja);
    }
  }
  
  public static void b(int paramInt, List paramList, zzkm paramZzkm, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZzkm.a(paramInt, paramList, paramBoolean);
    }
  }
  
  static int check(int paramInt, List paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return getSeasons(paramList) + i * zzgk.format(paramInt);
  }
  
  static void clear(zzgo paramZzgo, Object paramObject1, Object paramObject2)
  {
    paramObject2 = paramZzgo.getValue(paramObject2);
    if (!zzvb.isEmpty()) {
      paramZzgo.xor(paramObject1).getInstalledApps(paramObject2);
    }
  }
  
  static int decode(List paramList)
  {
    int m = paramList.size();
    int j = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    if ((paramList instanceof zzha))
    {
      paramList = (zzha)paramList;
      i = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        i += zzgk.valueOf(paramList.getInt(k));
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
      i += zzgk.valueOf(((Integer)paramList.get(k)).intValue());
      k += 1;
    }
    return j;
  }
  
  public static void doMerge(int paramInt, List paramList, zzkm paramZzkm, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZzkm.getPath(paramInt, paramList, paramBoolean);
    }
  }
  
  static int get(int paramInt, List paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return getString(paramList) + i * zzgk.format(paramInt);
  }
  
  static int get(List paramList)
  {
    int m = paramList.size();
    int j = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    if ((paramList instanceof zzhy))
    {
      paramList = (zzhy)paramList;
      i = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        i += zzgk.toString(paramList.getLong(k));
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
      i += zzgk.toString(((Long)paramList.get(k)).longValue());
      k += 1;
    }
    return j;
  }
  
  static int getBoolean(int paramInt, List paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return i * zzgk.read(paramInt, 0);
  }
  
  public static void getBytes(int paramInt, List paramList, zzkm paramZzkm, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZzkm.write(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void getField(Class paramClass)
  {
    if (!zzgy.class.isAssignableFrom(paramClass))
    {
      Class localClass = zzabg;
      if (localClass != null)
      {
        if (localClass.isAssignableFrom(paramClass)) {
          return;
        }
        throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
      }
    }
  }
  
  static int getGameId(int paramInt, List paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return i * zzgk.get(paramInt, 0L);
  }
  
  static int getInstance(int paramInt, List paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return size(paramList) + i * zzgk.format(paramInt);
  }
  
  static int getNumberOfColumns(List paramList)
  {
    return paramList.size();
  }
  
  public static void getPeriod(int paramInt, List paramList, zzkm paramZzkm, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZzkm.initialize(paramInt, paramList, paramBoolean);
    }
  }
  
  static int getSeasons(List paramList)
  {
    int m = paramList.size();
    int j = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    if ((paramList instanceof zzha))
    {
      paramList = (zzha)paramList;
      i = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        i += zzgk.getInt(paramList.getInt(k));
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
      i += zzgk.getInt(((Integer)paramList.get(k)).intValue());
      k += 1;
    }
    return j;
  }
  
  static int getString(List paramList)
  {
    int m = paramList.size();
    int j = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    if ((paramList instanceof zzha))
    {
      paramList = (zzha)paramList;
      i = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        i += zzgk.append(paramList.getInt(k));
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
      i += zzgk.append(((Integer)paramList.get(k)).intValue());
      k += 1;
    }
    return j;
  }
  
  static int getValue(int paramInt, List paramList)
  {
    int m = paramList.size();
    int i = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    int j = zzgk.format(paramInt) * m;
    paramInt = j;
    Object localObject;
    if ((paramList instanceof zzhr))
    {
      paramList = (zzhr)paramList;
      paramInt = j;
      i = k;
      for (;;)
      {
        j = paramInt;
        if (i >= m) {
          break;
        }
        localObject = paramList.zzaf(i);
        if ((localObject instanceof zzfx)) {
          j = zzgk.get((zzfx)localObject);
        } else {
          j = zzgk.getValue((String)localObject);
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
      if ((localObject instanceof zzfx)) {
        j = zzgk.get((zzfx)localObject);
      } else {
        j = zzgk.getValue((String)localObject);
      }
      paramInt += j;
      i += 1;
    }
    return j;
  }
  
  public static void go(int paramInt, List paramList, zzkm paramZzkm, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZzkm.apply(paramInt, paramList, paramBoolean);
    }
  }
  
  static int hashCode(int paramInt, Object paramObject, zzja paramZzja)
  {
    if ((paramObject instanceof zzhp)) {
      return zzgk.hash(paramInt, (zzhp)paramObject);
    }
    return zzgk.getIndex(paramInt, (zzik)paramObject, paramZzja);
  }
  
  static int indexOf(int paramInt, List paramList, zzja paramZzja)
  {
    int k = paramList.size();
    int j = 0;
    if (k == 0) {
      return 0;
    }
    int i = zzgk.format(paramInt) * k;
    paramInt = j;
    while (paramInt < k)
    {
      Object localObject = paramList.get(paramInt);
      if ((localObject instanceof zzhp)) {
        j = zzgk.getX((zzhp)localObject);
      } else {
        j = zzgk.getID((zzik)localObject, paramZzja);
      }
      i += j;
      paramInt += 1;
    }
    return i;
  }
  
  static int loadData(int paramInt, List paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return get(paramList) + i * zzgk.format(paramInt);
  }
  
  static int moveToString(List paramList)
  {
    return paramList.size() << 2;
  }
  
  static int next(List paramList)
  {
    int m = paramList.size();
    int j = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    if ((paramList instanceof zzha))
    {
      paramList = (zzha)paramList;
      i = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        i += zzgk.get(paramList.getInt(k));
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
      i += zzgk.get(((Integer)paramList.get(k)).intValue());
      k += 1;
    }
    return j;
  }
  
  static boolean objectsAreEqual(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  static int parse(int paramInt, List paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return decode(paramList) + i * zzgk.format(paramInt);
  }
  
  static int parseScreen(List paramList)
  {
    return paramList.size() << 3;
  }
  
  static int push(int paramInt, List paramList)
  {
    int i = paramList.size();
    int j = 0;
    if (i == 0) {
      return 0;
    }
    i *= zzgk.format(paramInt);
    paramInt = j;
    while (paramInt < paramList.size())
    {
      i += zzgk.get((zzfx)paramList.get(paramInt));
      paramInt += 1;
    }
    return i;
  }
  
  public static void read(int paramInt, List paramList, zzkm paramZzkm, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZzkm.writeTo(paramInt, paramList, paramBoolean);
    }
  }
  
  static int refresh(int paramInt, List paramList, boolean paramBoolean)
  {
    if (paramList.size() == 0) {
      return 0;
    }
    return write(paramList) + paramList.size() * zzgk.format(paramInt);
  }
  
  private static zzjs refresh(boolean paramBoolean)
  {
    try
    {
      Object localObject = zzdl();
      if (localObject == null) {
        return null;
      }
      localObject = (zzjs)((Class)localObject).getConstructor(new Class[] { Boolean.TYPE }).newInstance(new Object[] { Boolean.valueOf(paramBoolean) });
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public static void refresh(int paramInt, List paramList, zzkm paramZzkm, zzja paramZzja)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZzkm.getShares(paramInt, paramList, paramZzja);
    }
  }
  
  public static void refresh(int paramInt, List paramList, zzkm paramZzkm, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZzkm.init(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void send(int paramInt, List paramList, zzkm paramZzkm, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZzkm.remap(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void set(int paramInt, List paramList, zzkm paramZzkm, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZzkm.serialize(paramInt, paramList, paramBoolean);
    }
  }
  
  static int size(List paramList)
  {
    int m = paramList.size();
    int j = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    if ((paramList instanceof zzhy))
    {
      paramList = (zzhy)paramList;
      i = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        i += zzgk.valueOf(paramList.getLong(k));
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
      i += zzgk.valueOf(((Long)paramList.get(k)).longValue());
      k += 1;
    }
    return j;
  }
  
  public static void split(int paramInt, List paramList, zzkm paramZzkm, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZzkm.getValue(paramInt, paramList, paramBoolean);
    }
  }
  
  static int toHtml(int paramInt, List paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return next(paramList) + i * zzgk.format(paramInt);
  }
  
  public static void visitAnnotation(int paramInt, List paramList, zzkm paramZzkm, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZzkm.toString(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void visitInsn(int paramInt, List paramList, zzkm paramZzkm, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZzkm.execute(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void visitMethodInsn(int paramInt, List paramList, zzkm paramZzkm, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZzkm.add(paramInt, paramList, paramBoolean);
    }
  }
  
  static void visitMethodInsn(zzid paramZzid, Object paramObject1, Object paramObject2, long paramLong)
  {
    zzjy.append(paramObject1, paramLong, paramZzid.set(zzjy.getName(paramObject1, paramLong), zzjy.getName(paramObject2, paramLong)));
  }
  
  static int write(List paramList)
  {
    int m = paramList.size();
    int j = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    if ((paramList instanceof zzhy))
    {
      paramList = (zzhy)paramList;
      i = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        i += zzgk.get(paramList.getLong(k));
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
      i += zzgk.get(((Long)paramList.get(k)).longValue());
      k += 1;
    }
    return j;
  }
  
  public static void write(int paramInt, List paramList, zzkm paramZzkm)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZzkm.upload(paramInt, paramList);
    }
  }
  
  public static void write(int paramInt, List paramList, zzkm paramZzkm, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramZzkm.fill(paramInt, paramList, paramBoolean);
    }
  }
  
  public static zzjs zzdh()
  {
    return zzabh;
  }
  
  public static zzjs zzdi()
  {
    return zzabi;
  }
  
  public static zzjs zzdj()
  {
    return zzabj;
  }
  
  private static Class zzdk()
  {
    try
    {
      Class localClass = Class.forName("com.google.protobuf.GeneratedMessage");
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    return null;
  }
  
  private static Class zzdl()
  {
    try
    {
      Class localClass = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    return null;
  }
}
