package com.google.android.gms.internal.fitness;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import sun.misc.Unsafe;

final class zzio<T>
  implements zzja<T>
{
  private static final int[] zzaac = new int[0];
  private static final Unsafe zzaad = zzjy.zzdt();
  private final boolean zzaaa;
  private final zzgo<?> zzaab;
  private final int[] zzaae;
  private final Object[] zzaaf;
  private final int zzaag;
  private final int zzaah;
  private final boolean zzaai;
  private final boolean zzaaj;
  private final boolean zzaak;
  private final int[] zzaal;
  private final int zzaam;
  private final int zzaan;
  private final zzip zzaao;
  private final zzhu zzaap;
  private final zzid zzaaq;
  private final zzik zzzy;
  private final zzjs<?, ?> zzzz;
  
  private zzio(int[] paramArrayOfInt1, Object[] paramArrayOfObject, int paramInt1, int paramInt2, zzik paramZzik, boolean paramBoolean1, boolean paramBoolean2, int[] paramArrayOfInt2, int paramInt3, int paramInt4, zzip paramZzip, zzhu paramZzhu, zzjs paramZzjs, zzgo paramZzgo, zzid paramZzid)
  {
    zzaae = paramArrayOfInt1;
    zzaaf = paramArrayOfObject;
    zzaag = paramInt1;
    zzaah = paramInt2;
    zzaai = (paramZzik instanceof zzgy);
    zzaaj = paramBoolean1;
    if ((paramZzgo != null) && (paramZzgo.accepts(paramZzik))) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    zzaaa = paramBoolean1;
    zzaak = false;
    zzaal = paramArrayOfInt2;
    zzaam = paramInt3;
    zzaan = paramInt4;
    zzaao = paramZzip;
    zzaap = paramZzhu;
    zzzz = paramZzjs;
    zzaab = paramZzgo;
    zzzy = paramZzik;
    zzaaq = paramZzid;
  }
  
  private final void a(zzkm paramZzkm, int paramInt1, Object paramObject, int paramInt2)
    throws IOException
  {
    if (paramObject != null) {
      paramZzkm.write(paramInt1, zzaaq.getMethod(zzah(paramInt2)), zzaaq.getProperties(paramObject));
    }
  }
  
  private final void a(Object paramObject, int paramInt)
  {
    paramInt = zzaj(paramInt);
    long l = 0xFFFFF & paramInt;
    if (l == 1048575L) {
      return;
    }
    zzjy.d(paramObject, l, 1 << (paramInt >>> 20) | zzjy.getValue(paramObject, l));
  }
  
  private final void a(Object paramObject1, Object paramObject2, int paramInt)
  {
    int i = zzai(paramInt);
    int j = zzaae[paramInt];
    long l = i & 0xFFFFF;
    if (!a(paramObject2, j, paramInt)) {
      return;
    }
    Object localObject = null;
    if (a(paramObject1, j, paramInt)) {
      localObject = zzjy.getName(paramObject1, l);
    }
    paramObject2 = zzjy.getName(paramObject2, l);
    if ((localObject != null) && (paramObject2 != null))
    {
      zzjy.append(paramObject1, l, zzhc.f(localObject, paramObject2));
      visitMaxs(paramObject1, j, paramInt);
      return;
    }
    if (paramObject2 != null)
    {
      zzjy.append(paramObject1, l, paramObject2);
      visitMaxs(paramObject1, j, paramInt);
    }
  }
  
  private final boolean a(Object paramObject, int paramInt1, int paramInt2)
  {
    return zzjy.getValue(paramObject, zzaj(paramInt2) & 0xFFFFF) == paramInt1;
  }
  
  private final boolean a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 == 1048575) {
      return get(paramObject, paramInt1);
    }
    return (paramInt3 & paramInt4) != 0;
  }
  
  private static boolean a(Object paramObject, int paramInt, zzja paramZzja)
  {
    return paramZzja.a(zzjy.getName(paramObject, paramInt & 0xFFFFF));
  }
  
  static zzio decode(Class paramClass, zzii paramZzii, zzip paramZzip, zzhu paramZzhu, zzjs paramZzjs, zzgo paramZzgo, zzid paramZzid)
  {
    if ((paramZzii instanceof zzix))
    {
      zzix localZzix = (zzix)paramZzii;
      i = localZzix.zzcs();
      int j = zziw.zzaax;
      int i3 = 0;
      boolean bool;
      if (i == j) {
        bool = true;
      } else {
        bool = false;
      }
      String str = localZzix.zzcz();
      int i7 = str.length();
      if (str.charAt(0) >= 55296) {
        for (i = 1;; i = k)
        {
          k = i + 1;
          j = k;
          if (str.charAt(i) < 55296) {
            break;
          }
        }
      }
      j = 1;
      i = j + 1;
      int m = str.charAt(j);
      j = m;
      int k = i;
      if (m >= 55296)
      {
        k = m & 0x1FFF;
        j = 13;
        for (m = i;; m = i)
        {
          i = m + 1;
          m = str.charAt(m);
          if (m < 55296) {
            break;
          }
          k |= (m & 0x1FFF) << j;
          j += 13;
        }
        j = k | m << j;
        k = i;
      }
      int i4;
      int i5;
      int i1;
      int i2;
      if (j == 0)
      {
        i4 = 0;
        i5 = 0;
        n = 0;
        i1 = 0;
        j = 0;
        paramClass = zzaac;
        i2 = 0;
      }
      else
      {
        j = k + 1;
        m = str.charAt(k);
        i = m;
        k = j;
        if (m >= 55296)
        {
          k = m & 0x1FFF;
          i = 13;
          for (m = j;; m = j)
          {
            j = m + 1;
            m = str.charAt(m);
            if (m < 55296) {
              break;
            }
            k |= (m & 0x1FFF) << i;
            i += 13;
          }
          i = k | m << i;
          k = j;
        }
        j = k + 1;
        m = str.charAt(k);
        i3 = m;
        k = j;
        if (m >= 55296)
        {
          m &= 0x1FFF;
          k = 13;
          for (n = j;; n = j)
          {
            j = n + 1;
            n = str.charAt(n);
            if (n < 55296) {
              break;
            }
            m |= (n & 0x1FFF) << k;
            k += 13;
          }
          i3 = m | n << k;
          k = j;
        }
        j = k + 1;
        n = str.charAt(k);
        k = n;
        m = j;
        if (n >= 55296)
        {
          m = n & 0x1FFF;
          k = 13;
          for (n = j;; n = j)
          {
            j = n + 1;
            n = str.charAt(n);
            if (n < 55296) {
              break;
            }
            m |= (n & 0x1FFF) << k;
            k += 13;
          }
          k = m | n << k;
          m = j;
        }
        j = m + 1;
        i1 = str.charAt(m);
        m = i1;
        n = j;
        if (i1 >= 55296)
        {
          n = i1 & 0x1FFF;
          m = 13;
          for (i1 = j;; i1 = j)
          {
            j = i1 + 1;
            i1 = str.charAt(i1);
            if (i1 < 55296) {
              break;
            }
            n |= (i1 & 0x1FFF) << m;
            m += 13;
          }
          m = n | i1 << m;
          n = j;
        }
        j = n + 1;
        i2 = str.charAt(n);
        n = i2;
        i1 = j;
        if (i2 >= 55296)
        {
          i1 = i2 & 0x1FFF;
          n = 13;
          for (i2 = j;; i2 = j)
          {
            j = i2 + 1;
            i2 = str.charAt(i2);
            if (i2 < 55296) {
              break;
            }
            i1 |= (i2 & 0x1FFF) << n;
            n += 13;
          }
          n = i1 | i2 << n;
          i1 = j;
        }
        j = i1 + 1;
        i4 = str.charAt(i1);
        i1 = i4;
        i2 = j;
        if (i4 >= 55296)
        {
          i2 = i4 & 0x1FFF;
          i1 = 13;
          for (i4 = j;; i4 = j)
          {
            j = i4 + 1;
            i4 = str.charAt(i4);
            if (i4 < 55296) {
              break;
            }
            i2 |= (i4 & 0x1FFF) << i1;
            i1 += 13;
          }
          i1 = i2 | i4 << i1;
          i2 = j;
        }
        j = i2 + 1;
        i5 = str.charAt(i2);
        i4 = i5;
        i2 = j;
        if (i5 >= 55296)
        {
          i4 = i5 & 0x1FFF;
          i2 = 13;
          for (i5 = j;; i5 = j)
          {
            j = i5 + 1;
            i5 = str.charAt(i5);
            if (i5 < 55296) {
              break;
            }
            i4 |= (i5 & 0x1FFF) << i2;
            i2 += 13;
          }
          i4 |= i5 << i2;
          i2 = j;
        }
        i5 = i2 + 1;
        i6 = str.charAt(i2);
        j = i6;
        i2 = i5;
        if (i6 >= 55296)
        {
          i2 = i6 & 0x1FFF;
          j = 13;
          i6 = i5;
          i5 = i2;
          for (;;)
          {
            i2 = i6 + 1;
            i6 = str.charAt(i6);
            if (i6 < 55296) {
              break;
            }
            i5 |= (i6 & 0x1FFF) << j;
            j += 13;
            i6 = i2;
          }
          j = i5 | i6 << j;
        }
        paramClass = new int[j + i1 + i4];
        i4 = (i << 1) + i3;
        i3 = i2;
        i2 = i4;
        i5 = m;
        i4 = k;
        k = i3;
        i3 = i;
      }
      Unsafe localUnsafe = zzaad;
      Object[] arrayOfObject1 = localZzix.zzda();
      Class localClass = localZzix.zzcu().getClass();
      int[] arrayOfInt = new int[n * 3];
      Object[] arrayOfObject2 = new Object[n << 1];
      int i18 = j + i1;
      i = j;
      m = k;
      int i9 = i18;
      int n = 0;
      int i8 = 0;
      k = i2;
      int i6 = j;
      j = n;
      while (m < i7)
      {
        n = m + 1;
        m = str.charAt(m);
        int i10 = m;
        if (m >= 55296)
        {
          i1 = m & 0x1FFF;
          m = 13;
          for (i2 = n;; i2 = n)
          {
            n = i2 + 1;
            i2 = str.charAt(i2);
            if (i2 < 55296) {
              break;
            }
            i1 |= (i2 & 0x1FFF) << m;
            m += 13;
          }
          i10 = i1 | i2 << m;
        }
        m = n + 1;
        n = str.charAt(n);
        int i12 = n;
        if (n >= 55296)
        {
          i1 = n & 0x1FFF;
          i2 = m;
          m = 13;
          for (;;)
          {
            n = i2 + 1;
            i2 = str.charAt(i2);
            if (i2 < 55296) {
              break;
            }
            i1 |= (i2 & 0x1FFF) << m;
            m += 13;
            i2 = n;
          }
          i12 = i1 | i2 << m;
          m = n;
        }
        int i20 = i12 & 0xFF;
        int i11 = j;
        if ((i12 & 0x400) != 0)
        {
          paramClass[j] = i8;
          i11 = j + 1;
        }
        Field localField;
        int i15;
        int i16;
        int i17;
        int i14;
        int i13;
        if (i20 >= 51)
        {
          i1 = m + 1;
          m = str.charAt(m);
          n = m;
          j = i1;
          if (m >= 55296)
          {
            n = m & 0x1FFF;
            j = 13;
            for (;;)
            {
              m = i1 + 1;
              i1 = str.charAt(i1);
              if (i1 < 55296) {
                break;
              }
              n |= (i1 & 0x1FFF) << j;
              j += 13;
              i1 = m;
            }
            n |= i1 << j;
            j = m;
          }
          i1 = i20 - 51;
          m = j;
          if ((i1 != 9) && (i1 != 17))
          {
            j = k;
            if (i1 == 12)
            {
              j = k;
              if (!bool)
              {
                arrayOfObject2[((i8 / 3 << 1) + 1)] = arrayOfObject1[k];
                j = k + 1;
              }
            }
            k = j;
          }
          else
          {
            arrayOfObject2[((i8 / 3 << 1) + 1)] = arrayOfObject1[k];
            k += 1;
          }
          j = n << 1;
          paramZzii = arrayOfObject1[j];
          if ((paramZzii instanceof Field))
          {
            paramZzii = (Field)paramZzii;
          }
          else
          {
            localField = get(localClass, (String)paramZzii);
            paramZzii = localField;
            arrayOfObject1[j] = localField;
          }
          i15 = (int)localUnsafe.objectFieldOffset(paramZzii);
          j += 1;
          paramZzii = arrayOfObject1[j];
          if ((paramZzii instanceof Field))
          {
            paramZzii = (Field)paramZzii;
          }
          else
          {
            localField = get(localClass, (String)paramZzii);
            paramZzii = localField;
            arrayOfObject1[j] = localField;
          }
          i16 = (int)localUnsafe.objectFieldOffset(paramZzii);
          i17 = 0;
          i14 = i9;
          i13 = i;
        }
        else
        {
          n = k + 1;
          paramZzii = get(localClass, (String)arrayOfObject1[k]);
          if ((i20 != 9) && (i20 != 17))
          {
            if ((i20 != 27) && (i20 != 49))
            {
              if ((i20 != 12) && (i20 != 30) && (i20 != 44))
              {
                k = i;
                j = n;
                if (i20 != 50) {
                  break label2113;
                }
                j = i + 1;
                paramClass[i] = i8;
                i1 = i8 / 3 << 1;
                k = n + 1;
                arrayOfObject2[i1] = arrayOfObject1[n];
                if ((i12 & 0x800) != 0)
                {
                  i = k + 1;
                  arrayOfObject2[(i1 + 1)] = arrayOfObject1[k];
                  k = j;
                  j = i;
                  break label2113;
                }
                i = j;
                j = k;
              }
              else if (!bool)
              {
                k = i8 / 3;
                j = n + 1;
                arrayOfObject2[((k << 1) + 1)] = arrayOfObject1[n];
              }
              else
              {
                k = i;
                j = n;
                break label2113;
              }
            }
            else
            {
              k = i8 / 3;
              j = n + 1;
              arrayOfObject2[((k << 1) + 1)] = arrayOfObject1[n];
            }
            break label2117;
          }
          else
          {
            arrayOfObject2[((i8 / 3 << 1) + 1)] = paramZzii.getType();
            j = n;
            k = i;
          }
          label2113:
          i = k;
          label2117:
          int i19 = (int)localUnsafe.objectFieldOffset(paramZzii);
          if (((i12 & 0x1000) == 4096) && (i20 <= 17))
          {
            n = m + 1;
            i1 = str.charAt(m);
            m = i1;
            k = n;
            if (i1 >= 55296)
            {
              i1 &= 0x1FFF;
              k = 13;
              for (;;)
              {
                m = n + 1;
                n = str.charAt(n);
                if (n < 55296) {
                  break;
                }
                i1 |= (n & 0x1FFF) << k;
                k += 13;
                n = m;
              }
              n = i1 | n << k;
              k = m;
              m = n;
            }
            n = (i3 << 1) + m / 32;
            paramZzii = arrayOfObject1[n];
            if ((paramZzii instanceof Field))
            {
              paramZzii = (Field)paramZzii;
            }
            else
            {
              localField = get(localClass, (String)paramZzii);
              paramZzii = localField;
              arrayOfObject1[n] = localField;
            }
            i1 = (int)localUnsafe.objectFieldOffset(paramZzii);
            i2 = m % 32;
            n = k;
          }
          else
          {
            i1 = 1048575;
            i2 = 0;
            n = m;
          }
          i14 = i9;
          i13 = i;
          k = j;
          i15 = i19;
          m = n;
          i16 = i1;
          i17 = i2;
          if (i20 >= 18)
          {
            i14 = i9;
            i13 = i;
            k = j;
            i15 = i19;
            m = n;
            i16 = i1;
            i17 = i2;
            if (i20 <= 49)
            {
              paramClass[i9] = i19;
              i14 = i9 + 1;
              i17 = i2;
              i16 = i1;
              m = n;
              i15 = i19;
              k = j;
              i13 = i;
            }
          }
        }
        n = i8 + 1;
        arrayOfInt[i8] = i10;
        i1 = n + 1;
        if ((i12 & 0x200) != 0) {
          i = 536870912;
        } else {
          i = 0;
        }
        if ((i12 & 0x100) != 0) {
          j = 268435456;
        } else {
          j = 0;
        }
        arrayOfInt[n] = (j | i | i20 << 20 | i15);
        arrayOfInt[i1] = (i17 << 20 | i16);
        i8 = i1 + 1;
        i9 = i14;
        j = i11;
        i = i13;
      }
      return new zzio(arrayOfInt, arrayOfObject2, i4, i5, localZzix.zzcu(), bool, false, paramClass, i6, i18, paramZzip, paramZzhu, paramZzjs, paramZzgo, paramZzid);
    }
    ((zzjl)paramZzii).zzcs();
    int i = zziw.zzaax;
    throw new NoSuchMethodError();
  }
  
  private final boolean eq(Object paramObject1, Object paramObject2, int paramInt)
  {
    return get(paramObject1, paramInt) == get(paramObject2, paramInt);
  }
  
  private final void f(Object paramObject1, Object paramObject2, int paramInt)
  {
    long l = zzai(paramInt) & 0xFFFFF;
    if (!get(paramObject2, paramInt)) {
      return;
    }
    Object localObject = zzjy.getName(paramObject1, l);
    paramObject2 = zzjy.getName(paramObject2, l);
    if ((localObject != null) && (paramObject2 != null))
    {
      zzjy.append(paramObject1, l, zzhc.f(localObject, paramObject2));
      a(paramObject1, paramInt);
      return;
    }
    if (paramObject2 != null)
    {
      zzjy.append(paramObject1, l, paramObject2);
      a(paramObject1, paramInt);
    }
  }
  
  private static Field get(Class paramClass, String paramString)
  {
    try
    {
      localObject1 = paramClass.getDeclaredField(paramString);
      return localObject1;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Object localObject1;
      int j;
      int i;
      Object localObject2;
      for (;;) {}
    }
    localObject1 = paramClass.getDeclaredFields();
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      localObject2 = localObject1[i];
      if (paramString.equals(((Field)localObject2).getName())) {
        return localObject2;
      }
      i += 1;
    }
    paramClass = paramClass.getName();
    localObject1 = Arrays.toString((Object[])localObject1);
    localObject2 = new StringBuilder(String.valueOf(paramString).length() + 40 + paramClass.length() + String.valueOf(localObject1).length());
    ((StringBuilder)localObject2).append("Field ");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(" for ");
    ((StringBuilder)localObject2).append(paramClass);
    ((StringBuilder)localObject2).append(" not found. Known fields are ");
    ((StringBuilder)localObject2).append((String)localObject1);
    throw new RuntimeException(((StringBuilder)localObject2).toString());
  }
  
  private static List get(Object paramObject, long paramLong)
  {
    return (List)zzjy.getName(paramObject, paramLong);
  }
  
  private final boolean get(Object paramObject, int paramInt)
  {
    int i = zzaj(paramInt);
    long l = i & 0xFFFFF;
    if (l == 1048575L)
    {
      paramInt = zzai(paramInt);
      l = paramInt & 0xFFFFF;
      switch ((paramInt & 0xFF00000) >>> 20)
      {
      default: 
        throw new IllegalArgumentException();
      case 17: 
        return zzjy.getName(paramObject, l) != null;
      case 16: 
        return zzjy.getId(paramObject, l) != 0L;
      case 15: 
        return zzjy.getValue(paramObject, l) != 0;
      case 14: 
        return zzjy.getId(paramObject, l) != 0L;
      case 13: 
        return zzjy.getValue(paramObject, l) != 0;
      case 12: 
        return zzjy.getValue(paramObject, l) != 0;
      case 11: 
        return zzjy.getValue(paramObject, l) != 0;
      case 10: 
        return !zzfx.zzub.equals(zzjy.getName(paramObject, l));
      case 9: 
        return zzjy.getName(paramObject, l) != null;
      case 8: 
        paramObject = zzjy.getName(paramObject, l);
        if ((paramObject instanceof String)) {
          return !((String)paramObject).isEmpty();
        }
        if ((paramObject instanceof zzfx)) {
          return !zzfx.zzub.equals(paramObject);
        }
        throw new IllegalArgumentException();
      case 7: 
        return zzjy.next(paramObject, l);
      case 6: 
        return zzjy.getValue(paramObject, l) != 0;
      case 5: 
        return zzjy.getId(paramObject, l) != 0L;
      case 4: 
        return zzjy.getValue(paramObject, l) != 0;
      case 3: 
        return zzjy.getId(paramObject, l) != 0L;
      case 2: 
        return zzjy.getId(paramObject, l) != 0L;
      case 1: 
        return zzjy.size(paramObject, l) != 0.0F;
      }
      return zzjy.charAt(paramObject, l) != 0.0D;
    }
    return (zzjy.getValue(paramObject, l) & 1 << (i >>> 20)) != 0;
  }
  
  private static long getId(Object paramObject, long paramLong)
  {
    return ((Long)zzjy.getName(paramObject, paramLong)).longValue();
  }
  
  private static int getName(Object paramObject, long paramLong)
  {
    return ((Integer)zzjy.getName(paramObject, paramLong)).intValue();
  }
  
  private static double getValue(Object paramObject, long paramLong)
  {
    return ((Double)zzjy.getName(paramObject, paramLong)).doubleValue();
  }
  
  private static float invoke(Object paramObject, long paramLong)
  {
    return ((Float)zzjy.getName(paramObject, paramLong)).floatValue();
  }
  
  private static int next(zzjs paramZzjs, Object paramObject)
  {
    return paramZzjs.f(paramZzjs.getValue(paramObject));
  }
  
  private static boolean next(Object paramObject, long paramLong)
  {
    return ((Boolean)zzjy.getName(paramObject, paramLong)).booleanValue();
  }
  
  private static void read(zzjs paramZzjs, Object paramObject, zzkm paramZzkm)
    throws IOException
  {
    paramZzjs.readAttribute(paramZzjs.getValue(paramObject), paramZzkm);
  }
  
  private final void run(Object paramObject, zzkm paramZzkm)
    throws IOException
  {
    if (zzaaa)
    {
      localObject1 = zzaab.getValue(paramObject);
      if (!zzvb.isEmpty())
      {
        localObject1 = ((zzgt)localObject1).iterator();
        localObject3 = localObject1;
        localObject1 = (Map.Entry)((Iterator)localObject1).next();
        break label60;
      }
    }
    Object localObject3 = null;
    Object localObject1 = null;
    label60:
    int i1 = zzaae.length;
    Unsafe localUnsafe = zzaad;
    int m = 0;
    int i = 1048575;
    int j = 0;
    Object localObject2;
    for (;;)
    {
      localObject2 = localObject1;
      if (m >= i1) {
        break;
      }
      int i2 = zzai(m);
      localObject2 = zzaae;
      int i3 = localObject2[m];
      int i4 = (i2 & 0xFF00000) >>> 20;
      int k;
      if (i4 <= 17)
      {
        int i5 = localObject2[(m + 2)];
        int n = i5 & 0xFFFFF;
        k = i;
        if (n != i)
        {
          j = localUnsafe.getInt(paramObject, n);
          k = n;
        }
        n = 1 << (i5 >>> 20);
        i = k;
        k = n;
      }
      else
      {
        k = 0;
      }
      while ((localObject1 != null) && (zzaab.getValue((Map.Entry)localObject1) <= i3))
      {
        zzaab.add(paramZzkm, (Map.Entry)localObject1);
        if (localObject3.hasNext()) {
          localObject1 = (Map.Entry)localObject3.next();
        } else {
          localObject1 = null;
        }
      }
      long l = i2 & 0xFFFFF;
      switch (i4)
      {
      default: 
        break;
      }
      for (;;)
      {
        break;
        if (a(paramObject, i3, m))
        {
          paramZzkm.add(i3, localUnsafe.getObject(paramObject, l), zzag(m));
          continue;
          if (a(paramObject, i3, m))
          {
            paramZzkm.visitLocalVariable(i3, getId(paramObject, l));
            continue;
            if (a(paramObject, i3, m))
            {
              paramZzkm.visitFieldInsn(i3, getName(paramObject, l));
              continue;
              if (a(paramObject, i3, m))
              {
                paramZzkm.deleteServer(i3, getId(paramObject, l));
                continue;
                if (a(paramObject, i3, m))
                {
                  paramZzkm.visitTableSwitchInsn(i3, getName(paramObject, l));
                  continue;
                  if (a(paramObject, i3, m))
                  {
                    paramZzkm.visitVarInsn(i3, getName(paramObject, l));
                    continue;
                    if (a(paramObject, i3, m))
                    {
                      paramZzkm.visitMethodInsn(i3, getName(paramObject, l));
                      continue;
                      if (a(paramObject, i3, m))
                      {
                        paramZzkm.visitLocalVariable(i3, (zzfx)localUnsafe.getObject(paramObject, l));
                        continue;
                        if (a(paramObject, i3, m))
                        {
                          paramZzkm.write(i3, localUnsafe.getObject(paramObject, l), zzag(m));
                          continue;
                          if (a(paramObject, i3, m))
                          {
                            write(i3, localUnsafe.getObject(paramObject, l), paramZzkm);
                            continue;
                            if (a(paramObject, i3, m))
                            {
                              paramZzkm.f(i3, next(paramObject, l));
                              continue;
                              if (a(paramObject, i3, m))
                              {
                                paramZzkm.get(i3, getName(paramObject, l));
                                continue;
                                if (a(paramObject, i3, m))
                                {
                                  paramZzkm.updateBook(i3, getId(paramObject, l));
                                  continue;
                                  if (a(paramObject, i3, m))
                                  {
                                    paramZzkm.visitIntInsn(i3, getName(paramObject, l));
                                    continue;
                                    if (a(paramObject, i3, m))
                                    {
                                      paramZzkm.setRecurrence(i3, getId(paramObject, l));
                                      continue;
                                      if (a(paramObject, i3, m))
                                      {
                                        paramZzkm.write(i3, getId(paramObject, l));
                                        continue;
                                        if (a(paramObject, i3, m))
                                        {
                                          paramZzkm.add(i3, invoke(paramObject, l));
                                          continue;
                                          if (a(paramObject, i3, m))
                                          {
                                            paramZzkm.b(i3, getValue(paramObject, l));
                                            continue;
                                            a(paramZzkm, i3, localUnsafe.getObject(paramObject, l), m);
                                            continue;
                                            zzjc.refresh(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, zzag(m));
                                            continue;
                                            zzjc.getPeriod(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, true);
                                            continue;
                                            zzjc.refresh(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, true);
                                            continue;
                                            zzjc.split(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, true);
                                            continue;
                                            zzjc.go(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, true);
                                            continue;
                                            zzjc.send(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, true);
                                            continue;
                                            zzjc.getBytes(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, true);
                                            continue;
                                            zzjc.visitAnnotation(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, true);
                                            continue;
                                            zzjc.write(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, true);
                                            continue;
                                            zzjc.visitInsn(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, true);
                                            continue;
                                            zzjc.doMerge(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, true);
                                            continue;
                                            zzjc.read(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, true);
                                            continue;
                                            zzjc.set(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, true);
                                            continue;
                                            zzjc.visitMethodInsn(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, true);
                                            continue;
                                            zzjc.b(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, true);
                                            continue;
                                            zzjc.getPeriod(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, false);
                                            break label2230;
                                            zzjc.refresh(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, false);
                                            break label2230;
                                            zzjc.split(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, false);
                                            break label2230;
                                            zzjc.go(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, false);
                                            break label2230;
                                            zzjc.send(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, false);
                                            break label2230;
                                            zzjc.getBytes(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, false);
                                            break label2230;
                                            zzjc.b(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm);
                                            continue;
                                            zzjc.b(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, zzag(m));
                                            continue;
                                            zzjc.write(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm);
                                            continue;
                                            zzjc.visitAnnotation(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, false);
                                            break label2230;
                                            zzjc.write(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, false);
                                            break label2230;
                                            zzjc.visitInsn(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, false);
                                            break label2230;
                                            zzjc.doMerge(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, false);
                                            break label2230;
                                            zzjc.read(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, false);
                                            break label2230;
                                            zzjc.set(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, false);
                                            break label2230;
                                            zzjc.visitMethodInsn(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, false);
                                            break label2230;
                                            zzjc.b(zzaae[m], (List)localUnsafe.getObject(paramObject, l), paramZzkm, false);
                                            label2230:
                                            break;
                                            if ((k & j) != 0)
                                            {
                                              paramZzkm.add(i3, localUnsafe.getObject(paramObject, l), zzag(m));
                                              break;
                                              if ((k & j) != 0)
                                              {
                                                paramZzkm.visitLocalVariable(i3, localUnsafe.getLong(paramObject, l));
                                                break;
                                                if ((k & j) != 0)
                                                {
                                                  paramZzkm.visitFieldInsn(i3, localUnsafe.getInt(paramObject, l));
                                                  break;
                                                  if ((k & j) != 0)
                                                  {
                                                    paramZzkm.deleteServer(i3, localUnsafe.getLong(paramObject, l));
                                                    break;
                                                    if ((k & j) != 0)
                                                    {
                                                      paramZzkm.visitTableSwitchInsn(i3, localUnsafe.getInt(paramObject, l));
                                                      break;
                                                      if ((k & j) != 0)
                                                      {
                                                        paramZzkm.visitVarInsn(i3, localUnsafe.getInt(paramObject, l));
                                                        break;
                                                        if ((k & j) != 0)
                                                        {
                                                          paramZzkm.visitMethodInsn(i3, localUnsafe.getInt(paramObject, l));
                                                          break;
                                                          if ((k & j) != 0)
                                                          {
                                                            paramZzkm.visitLocalVariable(i3, (zzfx)localUnsafe.getObject(paramObject, l));
                                                            break;
                                                            if ((k & j) != 0)
                                                            {
                                                              paramZzkm.write(i3, localUnsafe.getObject(paramObject, l), zzag(m));
                                                              break;
                                                              if ((k & j) != 0)
                                                              {
                                                                write(i3, localUnsafe.getObject(paramObject, l), paramZzkm);
                                                                break;
                                                                if ((k & j) != 0)
                                                                {
                                                                  paramZzkm.f(i3, zzjy.next(paramObject, l));
                                                                  break;
                                                                  if ((k & j) != 0)
                                                                  {
                                                                    paramZzkm.get(i3, localUnsafe.getInt(paramObject, l));
                                                                    break;
                                                                    if ((k & j) != 0)
                                                                    {
                                                                      paramZzkm.updateBook(i3, localUnsafe.getLong(paramObject, l));
                                                                      break;
                                                                      if ((k & j) != 0)
                                                                      {
                                                                        paramZzkm.visitIntInsn(i3, localUnsafe.getInt(paramObject, l));
                                                                        break;
                                                                        if ((k & j) != 0)
                                                                        {
                                                                          paramZzkm.setRecurrence(i3, localUnsafe.getLong(paramObject, l));
                                                                          break;
                                                                          if ((k & j) != 0)
                                                                          {
                                                                            paramZzkm.write(i3, localUnsafe.getLong(paramObject, l));
                                                                            break;
                                                                            if ((k & j) != 0)
                                                                            {
                                                                              paramZzkm.add(i3, zzjy.size(paramObject, l));
                                                                              break;
                                                                              if ((k & j) != 0) {
                                                                                paramZzkm.b(i3, zzjy.charAt(paramObject, l));
                                                                              }
                                                                            }
                                                                          }
                                                                        }
                                                                      }
                                                                    }
                                                                  }
                                                                }
                                                              }
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      m += 3;
    }
    while (localObject2 != null)
    {
      zzaab.add(paramZzkm, (Map.Entry)localObject2);
      if (localObject3.hasNext()) {
        localObject2 = (Map.Entry)localObject3.next();
      } else {
        localObject2 = null;
      }
    }
    read(zzzz, paramObject, paramZzkm);
  }
  
  private final void visitMaxs(Object paramObject, int paramInt1, int paramInt2)
  {
    zzjy.d(paramObject, zzaj(paramInt2) & 0xFFFFF, paramInt1);
  }
  
  private static void write(int paramInt, Object paramObject, zzkm paramZzkm)
    throws IOException
  {
    if ((paramObject instanceof String))
    {
      paramZzkm.writeChars(paramInt, (String)paramObject);
      return;
    }
    paramZzkm.visitLocalVariable(paramInt, (zzfx)paramObject);
  }
  
  private final zzja zzag(int paramInt)
  {
    paramInt = paramInt / 3 << 1;
    zzja localZzja = (zzja)zzaaf[paramInt];
    if (localZzja != null) {
      return localZzja;
    }
    localZzja = zziv.zzcy().a((Class)zzaaf[(paramInt + 1)]);
    zzaaf[paramInt] = localZzja;
    return localZzja;
  }
  
  private final Object zzah(int paramInt)
  {
    return zzaaf[(paramInt / 3 << 1)];
  }
  
  private final int zzai(int paramInt)
  {
    return zzaae[(paramInt + 1)];
  }
  
  private final int zzaj(int paramInt)
  {
    return zzaae[(paramInt + 2)];
  }
  
  public final void a(Object paramObject, zzkm paramZzkm)
    throws IOException
  {
    Object localObject1;
    Object localObject3;
    label81:
    int i;
    Object localObject2;
    int j;
    int k;
    if (paramZzkm.zzbe() == zzkl.zzaeb)
    {
      read(zzzz, paramObject, paramZzkm);
      if (zzaaa)
      {
        localObject1 = zzaab.getValue(paramObject);
        if (!zzvb.isEmpty())
        {
          localObject1 = ((zzgt)localObject1).descendingIterator();
          localObject3 = localObject1;
          localObject1 = (Map.Entry)((Iterator)localObject1).next();
          break label81;
        }
      }
      localObject3 = null;
      localObject1 = null;
      i = zzaae.length - 3;
      for (;;)
      {
        localObject2 = localObject1;
        if (i < 0) {
          break;
        }
        j = zzai(i);
        k = zzaae[i];
        while ((localObject1 != null) && (zzaab.getValue((Map.Entry)localObject1) > k))
        {
          zzaab.add(paramZzkm, (Map.Entry)localObject1);
          if (localObject3.hasNext()) {
            localObject1 = (Map.Entry)localObject3.next();
          } else {
            localObject1 = null;
          }
        }
        switch ((j & 0xFF00000) >>> 20)
        {
        default: 
          break;
        case 68: 
          if (a(paramObject, k, i)) {
            paramZzkm.add(k, zzjy.getName(paramObject, j & 0xFFFFF), zzag(i));
          }
          break;
        case 67: 
          if (a(paramObject, k, i)) {
            paramZzkm.visitLocalVariable(k, getId(paramObject, j & 0xFFFFF));
          }
          break;
        case 66: 
          if (a(paramObject, k, i)) {
            paramZzkm.visitFieldInsn(k, getName(paramObject, j & 0xFFFFF));
          }
          break;
        case 65: 
          if (a(paramObject, k, i)) {
            paramZzkm.deleteServer(k, getId(paramObject, j & 0xFFFFF));
          }
          break;
        case 64: 
          if (a(paramObject, k, i)) {
            paramZzkm.visitTableSwitchInsn(k, getName(paramObject, j & 0xFFFFF));
          }
          break;
        case 63: 
          if (a(paramObject, k, i)) {
            paramZzkm.visitVarInsn(k, getName(paramObject, j & 0xFFFFF));
          }
          break;
        case 62: 
          if (a(paramObject, k, i)) {
            paramZzkm.visitMethodInsn(k, getName(paramObject, j & 0xFFFFF));
          }
          break;
        case 61: 
          if (a(paramObject, k, i)) {
            paramZzkm.visitLocalVariable(k, (zzfx)zzjy.getName(paramObject, j & 0xFFFFF));
          }
          break;
        case 60: 
          if (a(paramObject, k, i)) {
            paramZzkm.write(k, zzjy.getName(paramObject, j & 0xFFFFF), zzag(i));
          }
          break;
        case 59: 
          if (a(paramObject, k, i)) {
            write(k, zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm);
          }
          break;
        case 58: 
          if (a(paramObject, k, i)) {
            paramZzkm.f(k, next(paramObject, j & 0xFFFFF));
          }
          break;
        case 57: 
          if (a(paramObject, k, i)) {
            paramZzkm.get(k, getName(paramObject, j & 0xFFFFF));
          }
          break;
        case 56: 
          if (a(paramObject, k, i)) {
            paramZzkm.updateBook(k, getId(paramObject, j & 0xFFFFF));
          }
          break;
        case 55: 
          if (a(paramObject, k, i)) {
            paramZzkm.visitIntInsn(k, getName(paramObject, j & 0xFFFFF));
          }
          break;
        case 54: 
          if (a(paramObject, k, i)) {
            paramZzkm.setRecurrence(k, getId(paramObject, j & 0xFFFFF));
          }
          break;
        case 53: 
          if (a(paramObject, k, i)) {
            paramZzkm.write(k, getId(paramObject, j & 0xFFFFF));
          }
          break;
        case 52: 
          if (a(paramObject, k, i)) {
            paramZzkm.add(k, invoke(paramObject, j & 0xFFFFF));
          }
          break;
        case 51: 
          if (a(paramObject, k, i)) {
            paramZzkm.b(k, getValue(paramObject, j & 0xFFFFF));
          }
          break;
        case 50: 
          a(paramZzkm, k, zzjy.getName(paramObject, j & 0xFFFFF), i);
          break;
        case 49: 
          zzjc.refresh(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, zzag(i));
          break;
        case 48: 
          zzjc.getPeriod(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, true);
          break;
        case 47: 
          zzjc.refresh(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, true);
          break;
        case 46: 
          zzjc.split(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, true);
          break;
        case 45: 
          zzjc.go(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, true);
          break;
        case 44: 
          zzjc.send(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, true);
          break;
        case 43: 
          zzjc.getBytes(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, true);
          break;
        case 42: 
          zzjc.visitAnnotation(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, true);
          break;
        case 41: 
          zzjc.write(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, true);
          break;
        case 40: 
          zzjc.visitInsn(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, true);
          break;
        case 39: 
          zzjc.doMerge(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, true);
          break;
        case 38: 
          zzjc.read(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, true);
          break;
        case 37: 
          zzjc.set(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, true);
          break;
        case 36: 
          zzjc.visitMethodInsn(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, true);
          break;
        case 35: 
          zzjc.b(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, true);
          break;
        case 34: 
          zzjc.getPeriod(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, false);
          break;
        case 33: 
          zzjc.refresh(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, false);
          break;
        case 32: 
          zzjc.split(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, false);
          break;
        case 31: 
          zzjc.go(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, false);
          break;
        case 30: 
          zzjc.send(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, false);
          break;
        case 29: 
          zzjc.getBytes(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, false);
          break;
        case 28: 
          zzjc.b(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm);
          break;
        case 27: 
          zzjc.b(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, zzag(i));
          break;
        case 26: 
          zzjc.write(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm);
          break;
        case 25: 
          zzjc.visitAnnotation(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, false);
          break;
        case 24: 
          zzjc.write(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, false);
          break;
        case 23: 
          zzjc.visitInsn(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, false);
          break;
        case 22: 
          zzjc.doMerge(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, false);
          break;
        case 21: 
          zzjc.read(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, false);
          break;
        case 20: 
          zzjc.set(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, false);
          break;
        case 19: 
          zzjc.visitMethodInsn(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, false);
          break;
        case 18: 
          zzjc.b(zzaae[i], (List)zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm, false);
          break;
        case 17: 
          if (get(paramObject, i)) {
            paramZzkm.add(k, zzjy.getName(paramObject, j & 0xFFFFF), zzag(i));
          }
          break;
        case 16: 
          if (get(paramObject, i)) {
            paramZzkm.visitLocalVariable(k, zzjy.getId(paramObject, j & 0xFFFFF));
          }
          break;
        case 15: 
          if (get(paramObject, i)) {
            paramZzkm.visitFieldInsn(k, zzjy.getValue(paramObject, j & 0xFFFFF));
          }
          break;
        case 14: 
          if (get(paramObject, i)) {
            paramZzkm.deleteServer(k, zzjy.getId(paramObject, j & 0xFFFFF));
          }
          break;
        case 13: 
          if (get(paramObject, i)) {
            paramZzkm.visitTableSwitchInsn(k, zzjy.getValue(paramObject, j & 0xFFFFF));
          }
          break;
        case 12: 
          if (get(paramObject, i)) {
            paramZzkm.visitVarInsn(k, zzjy.getValue(paramObject, j & 0xFFFFF));
          }
          break;
        case 11: 
          if (get(paramObject, i)) {
            paramZzkm.visitMethodInsn(k, zzjy.getValue(paramObject, j & 0xFFFFF));
          }
          break;
        case 10: 
          if (get(paramObject, i)) {
            paramZzkm.visitLocalVariable(k, (zzfx)zzjy.getName(paramObject, j & 0xFFFFF));
          }
          break;
        case 9: 
          if (get(paramObject, i)) {
            paramZzkm.write(k, zzjy.getName(paramObject, j & 0xFFFFF), zzag(i));
          }
          break;
        case 8: 
          if (get(paramObject, i)) {
            write(k, zzjy.getName(paramObject, j & 0xFFFFF), paramZzkm);
          }
          break;
        case 7: 
          if (get(paramObject, i)) {
            paramZzkm.f(k, zzjy.next(paramObject, j & 0xFFFFF));
          }
          break;
        case 6: 
          if (get(paramObject, i)) {
            paramZzkm.get(k, zzjy.getValue(paramObject, j & 0xFFFFF));
          }
          break;
        case 5: 
          if (get(paramObject, i)) {
            paramZzkm.updateBook(k, zzjy.getId(paramObject, j & 0xFFFFF));
          }
          break;
        case 4: 
          if (get(paramObject, i)) {
            paramZzkm.visitIntInsn(k, zzjy.getValue(paramObject, j & 0xFFFFF));
          }
          break;
        case 3: 
          if (get(paramObject, i)) {
            paramZzkm.setRecurrence(k, zzjy.getId(paramObject, j & 0xFFFFF));
          }
          break;
        case 2: 
          if (get(paramObject, i)) {
            paramZzkm.write(k, zzjy.getId(paramObject, j & 0xFFFFF));
          }
          break;
        case 1: 
          if (get(paramObject, i)) {
            paramZzkm.add(k, zzjy.size(paramObject, j & 0xFFFFF));
          }
          break;
        case 0: 
          if (get(paramObject, i)) {
            paramZzkm.b(k, zzjy.charAt(paramObject, j & 0xFFFFF));
          }
          break;
        }
        i -= 3;
      }
      while (localObject2 != null)
      {
        zzaab.add(paramZzkm, (Map.Entry)localObject2);
        if (localObject3.hasNext()) {
          localObject2 = (Map.Entry)localObject3.next();
        } else {
          localObject2 = null;
        }
      }
      return;
    }
    if (zzaaj)
    {
      if (zzaaa)
      {
        localObject1 = zzaab.getValue(paramObject);
        if (!zzvb.isEmpty())
        {
          localObject1 = ((zzgt)localObject1).iterator();
          localObject3 = localObject1;
          localObject1 = (Map.Entry)((Iterator)localObject1).next();
          break label2897;
        }
      }
      localObject3 = null;
      localObject1 = null;
      label2897:
      j = zzaae.length;
      i = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= j) {
          break;
        }
        k = zzai(i);
        int m = zzaae[i];
        while ((localObject1 != null) && (zzaab.getValue((Map.Entry)localObject1) <= m))
        {
          zzaab.add(paramZzkm, (Map.Entry)localObject1);
          if (localObject3.hasNext()) {
            localObject1 = (Map.Entry)localObject3.next();
          } else {
            localObject1 = null;
          }
        }
        switch ((k & 0xFF00000) >>> 20)
        {
        default: 
          break;
        case 68: 
          if (a(paramObject, m, i)) {
            paramZzkm.add(m, zzjy.getName(paramObject, k & 0xFFFFF), zzag(i));
          }
          break;
        case 67: 
          if (a(paramObject, m, i)) {
            paramZzkm.visitLocalVariable(m, getId(paramObject, k & 0xFFFFF));
          }
          break;
        case 66: 
          if (a(paramObject, m, i)) {
            paramZzkm.visitFieldInsn(m, getName(paramObject, k & 0xFFFFF));
          }
          break;
        case 65: 
          if (a(paramObject, m, i)) {
            paramZzkm.deleteServer(m, getId(paramObject, k & 0xFFFFF));
          }
          break;
        case 64: 
          if (a(paramObject, m, i)) {
            paramZzkm.visitTableSwitchInsn(m, getName(paramObject, k & 0xFFFFF));
          }
          break;
        case 63: 
          if (a(paramObject, m, i)) {
            paramZzkm.visitVarInsn(m, getName(paramObject, k & 0xFFFFF));
          }
          break;
        case 62: 
          if (a(paramObject, m, i)) {
            paramZzkm.visitMethodInsn(m, getName(paramObject, k & 0xFFFFF));
          }
          break;
        case 61: 
          if (a(paramObject, m, i)) {
            paramZzkm.visitLocalVariable(m, (zzfx)zzjy.getName(paramObject, k & 0xFFFFF));
          }
          break;
        case 60: 
          if (a(paramObject, m, i)) {
            paramZzkm.write(m, zzjy.getName(paramObject, k & 0xFFFFF), zzag(i));
          }
          break;
        case 59: 
          if (a(paramObject, m, i)) {
            write(m, zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm);
          }
          break;
        case 58: 
          if (a(paramObject, m, i)) {
            paramZzkm.f(m, next(paramObject, k & 0xFFFFF));
          }
          break;
        case 57: 
          if (a(paramObject, m, i)) {
            paramZzkm.get(m, getName(paramObject, k & 0xFFFFF));
          }
          break;
        case 56: 
          if (a(paramObject, m, i)) {
            paramZzkm.updateBook(m, getId(paramObject, k & 0xFFFFF));
          }
          break;
        case 55: 
          if (a(paramObject, m, i)) {
            paramZzkm.visitIntInsn(m, getName(paramObject, k & 0xFFFFF));
          }
          break;
        case 54: 
          if (a(paramObject, m, i)) {
            paramZzkm.setRecurrence(m, getId(paramObject, k & 0xFFFFF));
          }
          break;
        case 53: 
          if (a(paramObject, m, i)) {
            paramZzkm.write(m, getId(paramObject, k & 0xFFFFF));
          }
          break;
        case 52: 
          if (a(paramObject, m, i)) {
            paramZzkm.add(m, invoke(paramObject, k & 0xFFFFF));
          }
          break;
        case 51: 
          if (a(paramObject, m, i)) {
            paramZzkm.b(m, getValue(paramObject, k & 0xFFFFF));
          }
          break;
        case 50: 
          a(paramZzkm, m, zzjy.getName(paramObject, k & 0xFFFFF), i);
          break;
        case 49: 
          zzjc.refresh(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, zzag(i));
          break;
        case 48: 
          zzjc.getPeriod(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, true);
          break;
        case 47: 
          zzjc.refresh(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, true);
          break;
        case 46: 
          zzjc.split(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, true);
          break;
        case 45: 
          zzjc.go(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, true);
          break;
        case 44: 
          zzjc.send(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, true);
          break;
        case 43: 
          zzjc.getBytes(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, true);
          break;
        case 42: 
          zzjc.visitAnnotation(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, true);
          break;
        case 41: 
          zzjc.write(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, true);
          break;
        case 40: 
          zzjc.visitInsn(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, true);
          break;
        case 39: 
          zzjc.doMerge(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, true);
          break;
        case 38: 
          zzjc.read(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, true);
          break;
        case 37: 
          zzjc.set(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, true);
          break;
        case 36: 
          zzjc.visitMethodInsn(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, true);
          break;
        case 35: 
          zzjc.b(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, true);
          break;
        case 34: 
          zzjc.getPeriod(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, false);
          break;
        case 33: 
          zzjc.refresh(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, false);
          break;
        case 32: 
          zzjc.split(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, false);
          break;
        case 31: 
          zzjc.go(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, false);
          break;
        case 30: 
          zzjc.send(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, false);
          break;
        case 29: 
          zzjc.getBytes(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, false);
          break;
        case 28: 
          zzjc.b(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm);
          break;
        case 27: 
          zzjc.b(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, zzag(i));
          break;
        case 26: 
          zzjc.write(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm);
          break;
        case 25: 
          zzjc.visitAnnotation(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, false);
          break;
        case 24: 
          zzjc.write(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, false);
          break;
        case 23: 
          zzjc.visitInsn(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, false);
          break;
        case 22: 
          zzjc.doMerge(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, false);
          break;
        case 21: 
          zzjc.read(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, false);
          break;
        case 20: 
          zzjc.set(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, false);
          break;
        case 19: 
          zzjc.visitMethodInsn(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, false);
          break;
        case 18: 
          zzjc.b(zzaae[i], (List)zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm, false);
          break;
        case 17: 
          if (get(paramObject, i)) {
            paramZzkm.add(m, zzjy.getName(paramObject, k & 0xFFFFF), zzag(i));
          }
          break;
        case 16: 
          if (get(paramObject, i)) {
            paramZzkm.visitLocalVariable(m, zzjy.getId(paramObject, k & 0xFFFFF));
          }
          break;
        case 15: 
          if (get(paramObject, i)) {
            paramZzkm.visitFieldInsn(m, zzjy.getValue(paramObject, k & 0xFFFFF));
          }
          break;
        case 14: 
          if (get(paramObject, i)) {
            paramZzkm.deleteServer(m, zzjy.getId(paramObject, k & 0xFFFFF));
          }
          break;
        case 13: 
          if (get(paramObject, i)) {
            paramZzkm.visitTableSwitchInsn(m, zzjy.getValue(paramObject, k & 0xFFFFF));
          }
          break;
        case 12: 
          if (get(paramObject, i)) {
            paramZzkm.visitVarInsn(m, zzjy.getValue(paramObject, k & 0xFFFFF));
          }
          break;
        case 11: 
          if (get(paramObject, i)) {
            paramZzkm.visitMethodInsn(m, zzjy.getValue(paramObject, k & 0xFFFFF));
          }
          break;
        case 10: 
          if (get(paramObject, i)) {
            paramZzkm.visitLocalVariable(m, (zzfx)zzjy.getName(paramObject, k & 0xFFFFF));
          }
          break;
        case 9: 
          if (get(paramObject, i)) {
            paramZzkm.write(m, zzjy.getName(paramObject, k & 0xFFFFF), zzag(i));
          }
          break;
        case 8: 
          if (get(paramObject, i)) {
            write(m, zzjy.getName(paramObject, k & 0xFFFFF), paramZzkm);
          }
          break;
        case 7: 
          if (get(paramObject, i)) {
            paramZzkm.f(m, zzjy.next(paramObject, k & 0xFFFFF));
          }
          break;
        case 6: 
          if (get(paramObject, i)) {
            paramZzkm.get(m, zzjy.getValue(paramObject, k & 0xFFFFF));
          }
          break;
        case 5: 
          if (get(paramObject, i)) {
            paramZzkm.updateBook(m, zzjy.getId(paramObject, k & 0xFFFFF));
          }
          break;
        case 4: 
          if (get(paramObject, i)) {
            paramZzkm.visitIntInsn(m, zzjy.getValue(paramObject, k & 0xFFFFF));
          }
          break;
        case 3: 
          if (get(paramObject, i)) {
            paramZzkm.setRecurrence(m, zzjy.getId(paramObject, k & 0xFFFFF));
          }
          break;
        case 2: 
          if (get(paramObject, i)) {
            paramZzkm.write(m, zzjy.getId(paramObject, k & 0xFFFFF));
          }
          break;
        case 1: 
          if (get(paramObject, i)) {
            paramZzkm.add(m, zzjy.size(paramObject, k & 0xFFFFF));
          }
          break;
        case 0: 
          if (get(paramObject, i)) {
            paramZzkm.b(m, zzjy.charAt(paramObject, k & 0xFFFFF));
          }
          break;
        }
        i += 3;
      }
      while (localObject2 != null)
      {
        zzaab.add(paramZzkm, (Map.Entry)localObject2);
        if (localObject3.hasNext()) {
          localObject2 = (Map.Entry)localObject3.next();
        } else {
          localObject2 = null;
        }
      }
      read(zzzz, paramObject, paramZzkm);
      return;
    }
    run(paramObject, paramZzkm);
  }
  
  public final void a(Object paramObject1, Object paramObject2)
  {
    Objects.requireNonNull(paramObject2);
    int i = 0;
    while (i < zzaae.length)
    {
      int j = zzai(i);
      long l = 0xFFFFF & j;
      int k = zzaae[i];
      switch ((j & 0xFF00000) >>> 20)
      {
      default: 
        break;
      case 68: 
        a(paramObject1, paramObject2, i);
        break;
      case 61: 
      case 62: 
      case 63: 
      case 64: 
      case 65: 
      case 66: 
      case 67: 
        if (a(paramObject2, k, i))
        {
          zzjy.append(paramObject1, l, zzjy.getName(paramObject2, l));
          visitMaxs(paramObject1, k, i);
        }
        break;
      case 60: 
        a(paramObject1, paramObject2, i);
        break;
      case 51: 
      case 52: 
      case 53: 
      case 54: 
      case 55: 
      case 56: 
      case 57: 
      case 58: 
      case 59: 
        if (a(paramObject2, k, i))
        {
          zzjy.append(paramObject1, l, zzjy.getName(paramObject2, l));
          visitMaxs(paramObject1, k, i);
        }
        break;
      case 50: 
        zzjc.visitMethodInsn(zzaaq, paramObject1, paramObject2, l);
        break;
      case 18: 
      case 19: 
      case 20: 
      case 21: 
      case 22: 
      case 23: 
      case 24: 
      case 25: 
      case 26: 
      case 27: 
      case 28: 
      case 29: 
      case 30: 
      case 31: 
      case 32: 
      case 33: 
      case 34: 
      case 35: 
      case 36: 
      case 37: 
      case 38: 
      case 39: 
      case 40: 
      case 41: 
      case 42: 
      case 43: 
      case 44: 
      case 45: 
      case 46: 
      case 47: 
      case 48: 
      case 49: 
        zzaap.showImage(paramObject1, paramObject2, l);
        break;
      case 17: 
        f(paramObject1, paramObject2, i);
        break;
      case 16: 
        if (get(paramObject2, i))
        {
          zzjy.visitLdcInsn(paramObject1, l, zzjy.getId(paramObject2, l));
          a(paramObject1, i);
        }
        break;
      case 15: 
        if (get(paramObject2, i))
        {
          zzjy.d(paramObject1, l, zzjy.getValue(paramObject2, l));
          a(paramObject1, i);
        }
        break;
      case 14: 
        if (get(paramObject2, i))
        {
          zzjy.visitLdcInsn(paramObject1, l, zzjy.getId(paramObject2, l));
          a(paramObject1, i);
        }
        break;
      case 13: 
        if (get(paramObject2, i))
        {
          zzjy.d(paramObject1, l, zzjy.getValue(paramObject2, l));
          a(paramObject1, i);
        }
        break;
      case 12: 
        if (get(paramObject2, i))
        {
          zzjy.d(paramObject1, l, zzjy.getValue(paramObject2, l));
          a(paramObject1, i);
        }
        break;
      case 11: 
        if (get(paramObject2, i))
        {
          zzjy.d(paramObject1, l, zzjy.getValue(paramObject2, l));
          a(paramObject1, i);
        }
        break;
      case 10: 
        if (get(paramObject2, i))
        {
          zzjy.append(paramObject1, l, zzjy.getName(paramObject2, l));
          a(paramObject1, i);
        }
        break;
      case 9: 
        f(paramObject1, paramObject2, i);
        break;
      case 8: 
        if (get(paramObject2, i))
        {
          zzjy.append(paramObject1, l, zzjy.getName(paramObject2, l));
          a(paramObject1, i);
        }
        break;
      case 7: 
        if (get(paramObject2, i))
        {
          zzjy.f(paramObject1, l, zzjy.next(paramObject2, l));
          a(paramObject1, i);
        }
        break;
      case 6: 
        if (get(paramObject2, i))
        {
          zzjy.d(paramObject1, l, zzjy.getValue(paramObject2, l));
          a(paramObject1, i);
        }
        break;
      case 5: 
        if (get(paramObject2, i))
        {
          zzjy.visitLdcInsn(paramObject1, l, zzjy.getId(paramObject2, l));
          a(paramObject1, i);
        }
        break;
      case 4: 
        if (get(paramObject2, i))
        {
          zzjy.d(paramObject1, l, zzjy.getValue(paramObject2, l));
          a(paramObject1, i);
        }
        break;
      case 3: 
        if (get(paramObject2, i))
        {
          zzjy.visitLdcInsn(paramObject1, l, zzjy.getId(paramObject2, l));
          a(paramObject1, i);
        }
        break;
      case 2: 
        if (get(paramObject2, i))
        {
          zzjy.visitLdcInsn(paramObject1, l, zzjy.getId(paramObject2, l));
          a(paramObject1, i);
        }
        break;
      case 1: 
        if (get(paramObject2, i))
        {
          zzjy.write(paramObject1, l, zzjy.size(paramObject2, l));
          a(paramObject1, i);
        }
        break;
      case 0: 
        if (get(paramObject2, i))
        {
          zzjy.write(paramObject1, l, zzjy.charAt(paramObject2, l));
          a(paramObject1, i);
        }
        break;
      }
      i += 3;
    }
    zzjc.add(zzzz, paramObject1, paramObject2);
    if (zzaaa) {
      zzjc.clear(zzaab, paramObject1, paramObject2);
    }
  }
  
  public final boolean a(Object paramObject)
  {
    int n = 1048575;
    int i = 0;
    int j = 0;
    for (;;)
    {
      int k = zzaam;
      int i1 = 1;
      int i2 = 1;
      if (j >= k) {
        break;
      }
      int i4 = zzaal[j];
      int i5 = zzaae[i4];
      int i6 = zzai(i4);
      k = zzaae[(i4 + 2)];
      int i3 = k & 0xFFFFF;
      int i7 = 1 << (k >>> 20);
      k = n;
      int m = i;
      if (i3 != n)
      {
        if (i3 != 1048575) {
          i = zzaad.getInt(paramObject, i3);
        }
        k = i3;
        m = i;
      }
      if ((0x10000000 & i6) != 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && (!a(paramObject, i4, k, m, i7))) {
        return false;
      }
      i = (0xFF00000 & i6) >>> 20;
      if ((i != 9) && (i != 17))
      {
        Object localObject2;
        if (i != 27) {
          if ((i != 60) && (i != 68))
          {
            if (i != 49)
            {
              if (i != 50) {
                break label520;
              }
              localObject2 = zzaaq.getProperties(zzjy.getName(paramObject, i6 & 0xFFFFF));
              i = i2;
              if (!((Map)localObject2).isEmpty())
              {
                localObject1 = zzah(i4);
                i = i2;
                if (zzaaq.getMethod(localObject1).zzzu.zzdx() == zzkj.zzady)
                {
                  localObject1 = null;
                  Iterator localIterator = ((Map)localObject2).values().iterator();
                  Object localObject3;
                  do
                  {
                    i = i2;
                    if (!localIterator.hasNext()) {
                      break;
                    }
                    localObject3 = localIterator.next();
                    localObject2 = localObject1;
                    if (localObject1 == null) {
                      localObject2 = zziv.zzcy().a(localObject3.getClass());
                    }
                    localObject1 = localObject2;
                  } while (((zzja)localObject2).a(localObject3));
                  i = 0;
                }
              }
              if (i != 0) {
                break label520;
              }
              return false;
            }
          }
          else
          {
            if ((!a(paramObject, i5, i4)) || (a(paramObject, i6, zzag(i4)))) {
              break label520;
            }
            return false;
          }
        }
        Object localObject1 = (List)zzjy.getName(paramObject, i6 & 0xFFFFF);
        i = i1;
        if (!((List)localObject1).isEmpty())
        {
          localObject2 = zzag(i4);
          n = 0;
          for (;;)
          {
            i = i1;
            if (n >= ((List)localObject1).size()) {
              break;
            }
            if (!((zzja)localObject2).a(((List)localObject1).get(n)))
            {
              i = 0;
              break;
            }
            n += 1;
          }
        }
        if (i == 0) {
          return false;
        }
      }
      else if ((a(paramObject, i4, k, m, i7)) && (!a(paramObject, i6, zzag(i4))))
      {
        return false;
      }
      label520:
      j += 1;
      n = k;
      i = m;
    }
    return (!zzaaa) || (zzaab.getValue(paramObject).isInitialized());
  }
  
  /* Error */
  public final boolean equals(Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 58	com/google/android/gms/internal/fitness/zzio:zzaae	[I
    //   4: arraylength
    //   5: istore 4
    //   7: iconst_0
    //   8: istore_3
    //   9: iconst_1
    //   10: istore 6
    //   12: iload_3
    //   13: iload 4
    //   15: if_icmpge +1230 -> 1245
    //   18: aload_0
    //   19: iload_3
    //   20: invokespecial 143	com/google/android/gms/internal/fitness/zzio:zzai	(I)I
    //   23: istore 5
    //   25: iload 5
    //   27: ldc -127
    //   29: iand
    //   30: i2l
    //   31: lstore 7
    //   33: iload 5
    //   35: ldc_w 293
    //   38: iand
    //   39: bipush 20
    //   41: iushr
    //   42: lookupswitch	default:+562->604, 0:+1154->1196, 1:+1120->1162, 2:+1091->1133, 3:+1062->1104, 4:+1034->1076, 5:+1005->1047, 6:+977->1019, 7:+949->991, 8:+918->960, 9:+887->929, 10:+856->898, 11:+828->870, 12:+800->842, 13:+772->814, 14:+743->785, 15:+715->757, 16:+686->728, 17:+655->697, 18:+635->677, 19:+635->677, 20:+635->677, 21:+635->677, 22:+635->677, 23:+635->677, 24:+635->677, 25:+635->677, 26:+635->677, 27:+635->677, 28:+635->677, 29:+635->677, 30:+635->677, 31:+635->677, 32:+635->677, 33:+635->677, 34:+635->677, 35:+635->677, 36:+635->677, 37:+635->677, 38:+635->677, 39:+635->677, 40:+635->677, 41:+635->677, 42:+635->677, 43:+635->677, 44:+635->677, 45:+635->677, 46:+635->677, 47:+635->677, 48:+635->677, 49:+635->677, 50:+615->657, 51:+568->610, 52:+568->610, 53:+568->610, 54:+568->610, 55:+568->610, 56:+568->610, 57:+568->610, 58:+568->610, 59:+568->610, 60:+568->610, 61:+568->610, 62:+568->610, 63:+568->610, 64:+568->610, 65:+568->610, 66:+568->610, 67:+568->610, 68:+568->610
    //   604: goto +3 -> 607
    //   607: goto +624 -> 1231
    //   610: aload_0
    //   611: iload_3
    //   612: invokespecial 128	com/google/android/gms/internal/fitness/zzio:zzaj	(I)I
    //   615: ldc -127
    //   617: iand
    //   618: i2l
    //   619: lstore 9
    //   621: aload_1
    //   622: lload 9
    //   624: invokestatic 135	com/google/android/gms/internal/fitness/zzjy:getValue	(Ljava/lang/Object;J)I
    //   627: aload_2
    //   628: lload 9
    //   630: invokestatic 135	com/google/android/gms/internal/fitness/zzjy:getValue	(Ljava/lang/Object;J)I
    //   633: if_icmpne +595 -> 1228
    //   636: aload_1
    //   637: lload 7
    //   639: invokestatic 150	com/google/android/gms/internal/fitness/zzjy:getName	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   642: aload_2
    //   643: lload 7
    //   645: invokestatic 150	com/google/android/gms/internal/fitness/zzjy:getName	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   648: invokestatic 639	com/google/android/gms/internal/fitness/zzjc:objectsAreEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   651: ifne +580 -> 1231
    //   654: goto +574 -> 1228
    //   657: aload_1
    //   658: lload 7
    //   660: invokestatic 150	com/google/android/gms/internal/fitness/zzjy:getName	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   663: aload_2
    //   664: lload 7
    //   666: invokestatic 150	com/google/android/gms/internal/fitness/zzjy:getName	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   669: invokestatic 639	com/google/android/gms/internal/fitness/zzjc:objectsAreEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   672: istore 6
    //   674: goto +557 -> 1231
    //   677: aload_1
    //   678: lload 7
    //   680: invokestatic 150	com/google/android/gms/internal/fitness/zzjy:getName	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   683: aload_2
    //   684: lload 7
    //   686: invokestatic 150	com/google/android/gms/internal/fitness/zzjy:getName	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   689: invokestatic 639	com/google/android/gms/internal/fitness/zzjc:objectsAreEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   692: istore 6
    //   694: goto +537 -> 1231
    //   697: aload_0
    //   698: aload_1
    //   699: aload_2
    //   700: iload_3
    //   701: invokespecial 641	com/google/android/gms/internal/fitness/zzio:eq	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   704: ifeq +524 -> 1228
    //   707: aload_1
    //   708: lload 7
    //   710: invokestatic 150	com/google/android/gms/internal/fitness/zzjy:getName	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   713: aload_2
    //   714: lload 7
    //   716: invokestatic 150	com/google/android/gms/internal/fitness/zzjy:getName	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   719: invokestatic 639	com/google/android/gms/internal/fitness/zzjc:objectsAreEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   722: ifne +509 -> 1231
    //   725: goto +503 -> 1228
    //   728: aload_0
    //   729: aload_1
    //   730: aload_2
    //   731: iload_3
    //   732: invokespecial 641	com/google/android/gms/internal/fitness/zzio:eq	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   735: ifeq +493 -> 1228
    //   738: aload_1
    //   739: lload 7
    //   741: invokestatic 300	com/google/android/gms/internal/fitness/zzjy:getId	(Ljava/lang/Object;J)J
    //   744: aload_2
    //   745: lload 7
    //   747: invokestatic 300	com/google/android/gms/internal/fitness/zzjy:getId	(Ljava/lang/Object;J)J
    //   750: lcmp
    //   751: ifeq +480 -> 1231
    //   754: goto +474 -> 1228
    //   757: aload_0
    //   758: aload_1
    //   759: aload_2
    //   760: iload_3
    //   761: invokespecial 641	com/google/android/gms/internal/fitness/zzio:eq	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   764: ifeq +464 -> 1228
    //   767: aload_1
    //   768: lload 7
    //   770: invokestatic 135	com/google/android/gms/internal/fitness/zzjy:getValue	(Ljava/lang/Object;J)I
    //   773: aload_2
    //   774: lload 7
    //   776: invokestatic 135	com/google/android/gms/internal/fitness/zzjy:getValue	(Ljava/lang/Object;J)I
    //   779: if_icmpeq +452 -> 1231
    //   782: goto +446 -> 1228
    //   785: aload_0
    //   786: aload_1
    //   787: aload_2
    //   788: iload_3
    //   789: invokespecial 641	com/google/android/gms/internal/fitness/zzio:eq	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   792: ifeq +436 -> 1228
    //   795: aload_1
    //   796: lload 7
    //   798: invokestatic 300	com/google/android/gms/internal/fitness/zzjy:getId	(Ljava/lang/Object;J)J
    //   801: aload_2
    //   802: lload 7
    //   804: invokestatic 300	com/google/android/gms/internal/fitness/zzjy:getId	(Ljava/lang/Object;J)J
    //   807: lcmp
    //   808: ifeq +423 -> 1231
    //   811: goto +417 -> 1228
    //   814: aload_0
    //   815: aload_1
    //   816: aload_2
    //   817: iload_3
    //   818: invokespecial 641	com/google/android/gms/internal/fitness/zzio:eq	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   821: ifeq +407 -> 1228
    //   824: aload_1
    //   825: lload 7
    //   827: invokestatic 135	com/google/android/gms/internal/fitness/zzjy:getValue	(Ljava/lang/Object;J)I
    //   830: aload_2
    //   831: lload 7
    //   833: invokestatic 135	com/google/android/gms/internal/fitness/zzjy:getValue	(Ljava/lang/Object;J)I
    //   836: if_icmpeq +395 -> 1231
    //   839: goto +389 -> 1228
    //   842: aload_0
    //   843: aload_1
    //   844: aload_2
    //   845: iload_3
    //   846: invokespecial 641	com/google/android/gms/internal/fitness/zzio:eq	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   849: ifeq +379 -> 1228
    //   852: aload_1
    //   853: lload 7
    //   855: invokestatic 135	com/google/android/gms/internal/fitness/zzjy:getValue	(Ljava/lang/Object;J)I
    //   858: aload_2
    //   859: lload 7
    //   861: invokestatic 135	com/google/android/gms/internal/fitness/zzjy:getValue	(Ljava/lang/Object;J)I
    //   864: if_icmpeq +367 -> 1231
    //   867: goto +361 -> 1228
    //   870: aload_0
    //   871: aload_1
    //   872: aload_2
    //   873: iload_3
    //   874: invokespecial 641	com/google/android/gms/internal/fitness/zzio:eq	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   877: ifeq +351 -> 1228
    //   880: aload_1
    //   881: lload 7
    //   883: invokestatic 135	com/google/android/gms/internal/fitness/zzjy:getValue	(Ljava/lang/Object;J)I
    //   886: aload_2
    //   887: lload 7
    //   889: invokestatic 135	com/google/android/gms/internal/fitness/zzjy:getValue	(Ljava/lang/Object;J)I
    //   892: if_icmpeq +339 -> 1231
    //   895: goto +333 -> 1228
    //   898: aload_0
    //   899: aload_1
    //   900: aload_2
    //   901: iload_3
    //   902: invokespecial 641	com/google/android/gms/internal/fitness/zzio:eq	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   905: ifeq +323 -> 1228
    //   908: aload_1
    //   909: lload 7
    //   911: invokestatic 150	com/google/android/gms/internal/fitness/zzjy:getName	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   914: aload_2
    //   915: lload 7
    //   917: invokestatic 150	com/google/android/gms/internal/fitness/zzjy:getName	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   920: invokestatic 639	com/google/android/gms/internal/fitness/zzjc:objectsAreEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   923: ifne +308 -> 1231
    //   926: goto +302 -> 1228
    //   929: aload_0
    //   930: aload_1
    //   931: aload_2
    //   932: iload_3
    //   933: invokespecial 641	com/google/android/gms/internal/fitness/zzio:eq	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   936: ifeq +292 -> 1228
    //   939: aload_1
    //   940: lload 7
    //   942: invokestatic 150	com/google/android/gms/internal/fitness/zzjy:getName	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   945: aload_2
    //   946: lload 7
    //   948: invokestatic 150	com/google/android/gms/internal/fitness/zzjy:getName	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   951: invokestatic 639	com/google/android/gms/internal/fitness/zzjc:objectsAreEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   954: ifne +277 -> 1231
    //   957: goto +271 -> 1228
    //   960: aload_0
    //   961: aload_1
    //   962: aload_2
    //   963: iload_3
    //   964: invokespecial 641	com/google/android/gms/internal/fitness/zzio:eq	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   967: ifeq +261 -> 1228
    //   970: aload_1
    //   971: lload 7
    //   973: invokestatic 150	com/google/android/gms/internal/fitness/zzjy:getName	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   976: aload_2
    //   977: lload 7
    //   979: invokestatic 150	com/google/android/gms/internal/fitness/zzjy:getName	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   982: invokestatic 639	com/google/android/gms/internal/fitness/zzjc:objectsAreEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   985: ifne +246 -> 1231
    //   988: goto +240 -> 1228
    //   991: aload_0
    //   992: aload_1
    //   993: aload_2
    //   994: iload_3
    //   995: invokespecial 641	com/google/android/gms/internal/fitness/zzio:eq	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   998: ifeq +230 -> 1228
    //   1001: aload_1
    //   1002: lload 7
    //   1004: invokestatic 315	com/google/android/gms/internal/fitness/zzjy:next	(Ljava/lang/Object;J)Z
    //   1007: aload_2
    //   1008: lload 7
    //   1010: invokestatic 315	com/google/android/gms/internal/fitness/zzjy:next	(Ljava/lang/Object;J)Z
    //   1013: if_icmpeq +218 -> 1231
    //   1016: goto +212 -> 1228
    //   1019: aload_0
    //   1020: aload_1
    //   1021: aload_2
    //   1022: iload_3
    //   1023: invokespecial 641	com/google/android/gms/internal/fitness/zzio:eq	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   1026: ifeq +202 -> 1228
    //   1029: aload_1
    //   1030: lload 7
    //   1032: invokestatic 135	com/google/android/gms/internal/fitness/zzjy:getValue	(Ljava/lang/Object;J)I
    //   1035: aload_2
    //   1036: lload 7
    //   1038: invokestatic 135	com/google/android/gms/internal/fitness/zzjy:getValue	(Ljava/lang/Object;J)I
    //   1041: if_icmpeq +190 -> 1231
    //   1044: goto +184 -> 1228
    //   1047: aload_0
    //   1048: aload_1
    //   1049: aload_2
    //   1050: iload_3
    //   1051: invokespecial 641	com/google/android/gms/internal/fitness/zzio:eq	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   1054: ifeq +174 -> 1228
    //   1057: aload_1
    //   1058: lload 7
    //   1060: invokestatic 300	com/google/android/gms/internal/fitness/zzjy:getId	(Ljava/lang/Object;J)J
    //   1063: aload_2
    //   1064: lload 7
    //   1066: invokestatic 300	com/google/android/gms/internal/fitness/zzjy:getId	(Ljava/lang/Object;J)J
    //   1069: lcmp
    //   1070: ifeq +161 -> 1231
    //   1073: goto +155 -> 1228
    //   1076: aload_0
    //   1077: aload_1
    //   1078: aload_2
    //   1079: iload_3
    //   1080: invokespecial 641	com/google/android/gms/internal/fitness/zzio:eq	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   1083: ifeq +145 -> 1228
    //   1086: aload_1
    //   1087: lload 7
    //   1089: invokestatic 135	com/google/android/gms/internal/fitness/zzjy:getValue	(Ljava/lang/Object;J)I
    //   1092: aload_2
    //   1093: lload 7
    //   1095: invokestatic 135	com/google/android/gms/internal/fitness/zzjy:getValue	(Ljava/lang/Object;J)I
    //   1098: if_icmpeq +133 -> 1231
    //   1101: goto +127 -> 1228
    //   1104: aload_0
    //   1105: aload_1
    //   1106: aload_2
    //   1107: iload_3
    //   1108: invokespecial 641	com/google/android/gms/internal/fitness/zzio:eq	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   1111: ifeq +117 -> 1228
    //   1114: aload_1
    //   1115: lload 7
    //   1117: invokestatic 300	com/google/android/gms/internal/fitness/zzjy:getId	(Ljava/lang/Object;J)J
    //   1120: aload_2
    //   1121: lload 7
    //   1123: invokestatic 300	com/google/android/gms/internal/fitness/zzjy:getId	(Ljava/lang/Object;J)J
    //   1126: lcmp
    //   1127: ifeq +104 -> 1231
    //   1130: goto +98 -> 1228
    //   1133: aload_0
    //   1134: aload_1
    //   1135: aload_2
    //   1136: iload_3
    //   1137: invokespecial 641	com/google/android/gms/internal/fitness/zzio:eq	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   1140: ifeq +88 -> 1228
    //   1143: aload_1
    //   1144: lload 7
    //   1146: invokestatic 300	com/google/android/gms/internal/fitness/zzjy:getId	(Ljava/lang/Object;J)J
    //   1149: aload_2
    //   1150: lload 7
    //   1152: invokestatic 300	com/google/android/gms/internal/fitness/zzjy:getId	(Ljava/lang/Object;J)J
    //   1155: lcmp
    //   1156: ifeq +75 -> 1231
    //   1159: goto +69 -> 1228
    //   1162: aload_0
    //   1163: aload_1
    //   1164: aload_2
    //   1165: iload_3
    //   1166: invokespecial 641	com/google/android/gms/internal/fitness/zzio:eq	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   1169: ifeq +59 -> 1228
    //   1172: aload_1
    //   1173: lload 7
    //   1175: invokestatic 319	com/google/android/gms/internal/fitness/zzjy:size	(Ljava/lang/Object;J)F
    //   1178: invokestatic 645	java/lang/Float:floatToIntBits	(F)I
    //   1181: aload_2
    //   1182: lload 7
    //   1184: invokestatic 319	com/google/android/gms/internal/fitness/zzjy:size	(Ljava/lang/Object;J)F
    //   1187: invokestatic 645	java/lang/Float:floatToIntBits	(F)I
    //   1190: if_icmpeq +41 -> 1231
    //   1193: goto +35 -> 1228
    //   1196: aload_0
    //   1197: aload_1
    //   1198: aload_2
    //   1199: iload_3
    //   1200: invokespecial 641	com/google/android/gms/internal/fitness/zzio:eq	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   1203: ifeq +25 -> 1228
    //   1206: aload_1
    //   1207: lload 7
    //   1209: invokestatic 322	com/google/android/gms/internal/fitness/zzjy:charAt	(Ljava/lang/Object;J)D
    //   1212: invokestatic 649	java/lang/Double:doubleToLongBits	(D)J
    //   1215: aload_2
    //   1216: lload 7
    //   1218: invokestatic 322	com/google/android/gms/internal/fitness/zzjy:charAt	(Ljava/lang/Object;J)D
    //   1221: invokestatic 649	java/lang/Double:doubleToLongBits	(D)J
    //   1224: lcmp
    //   1225: ifeq +6 -> 1231
    //   1228: iconst_0
    //   1229: istore 6
    //   1231: iload 6
    //   1233: ifne +5 -> 1238
    //   1236: iconst_0
    //   1237: ireturn
    //   1238: iload_3
    //   1239: iconst_3
    //   1240: iadd
    //   1241: istore_3
    //   1242: goto -1233 -> 9
    //   1245: aload_0
    //   1246: getfield 92	com/google/android/gms/internal/fitness/zzio:zzzz	Lcom/google/android/gms/internal/fitness/zzjs;
    //   1249: aload_1
    //   1250: invokevirtual 352	com/google/android/gms/internal/fitness/zzjs:getValue	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1253: aload_0
    //   1254: getfield 92	com/google/android/gms/internal/fitness/zzio:zzzz	Lcom/google/android/gms/internal/fitness/zzjs;
    //   1257: aload_2
    //   1258: invokevirtual 352	com/google/android/gms/internal/fitness/zzjs:getValue	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1261: invokevirtual 650	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   1264: ifne +5 -> 1269
    //   1267: iconst_0
    //   1268: ireturn
    //   1269: aload_0
    //   1270: getfield 78	com/google/android/gms/internal/fitness/zzio:zzaaa	Z
    //   1273: ifeq +23 -> 1296
    //   1276: aload_0
    //   1277: getfield 94	com/google/android/gms/internal/fitness/zzio:zzaab	Lcom/google/android/gms/internal/fitness/zzgo;
    //   1280: aload_1
    //   1281: invokevirtual 370	com/google/android/gms/internal/fitness/zzgo:getValue	(Ljava/lang/Object;)Lcom/google/android/gms/internal/fitness/zzgt;
    //   1284: aload_0
    //   1285: getfield 94	com/google/android/gms/internal/fitness/zzio:zzaab	Lcom/google/android/gms/internal/fitness/zzgo;
    //   1288: aload_2
    //   1289: invokevirtual 370	com/google/android/gms/internal/fitness/zzgo:getValue	(Ljava/lang/Object;)Lcom/google/android/gms/internal/fitness/zzgt;
    //   1292: invokevirtual 651	com/google/android/gms/internal/fitness/zzgt:equals	(Ljava/lang/Object;)Z
    //   1295: ireturn
    //   1296: iconst_1
    //   1297: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1298	0	this	zzio
    //   0	1298	1	paramObject1	Object
    //   0	1298	2	paramObject2	Object
    //   8	1234	3	i	int
    //   5	11	4	j	int
    //   23	16	5	k	int
    //   10	1222	6	bool	boolean
    //   31	1186	7	l1	long
    //   619	10	9	l2	long
  }
  
  public final int hashCode(Object paramObject)
  {
    int m = zzaae.length;
    int k = 0;
    for (int j = 0; k < m; j = i)
    {
      int i1 = zzai(k);
      int n = zzaae[k];
      long l = 0xFFFFF & i1;
      i = 37;
      Object localObject;
      switch ((i1 & 0xFF00000) >>> 20)
      {
      default: 
        i = j;
        break;
      case 68: 
        i = j;
        if (!a(paramObject, n, k)) {
          break label1564;
        }
        localObject = zzjy.getName(paramObject, l);
        i = j * 53;
        j = localObject.hashCode();
        break;
      case 67: 
        i = j;
        if (!a(paramObject, n, k)) {
          break label1564;
        }
        i = j * 53;
        j = zzhc.hashCode(getId(paramObject, l));
        break;
      case 66: 
        i = j;
        if (!a(paramObject, n, k)) {
          break label1564;
        }
        i = j * 53;
        j = getName(paramObject, l);
        break;
      case 65: 
        i = j;
        if (!a(paramObject, n, k)) {
          break label1564;
        }
        i = j * 53;
        j = zzhc.hashCode(getId(paramObject, l));
        break;
      case 64: 
        i = j;
        if (!a(paramObject, n, k)) {
          break label1564;
        }
        i = j * 53;
        j = getName(paramObject, l);
        break;
      case 63: 
        i = j;
        if (!a(paramObject, n, k)) {
          break label1564;
        }
        i = j * 53;
        j = getName(paramObject, l);
        break;
      case 62: 
        i = j;
        if (!a(paramObject, n, k)) {
          break label1564;
        }
        i = j * 53;
        j = getName(paramObject, l);
        break;
      case 61: 
        i = j;
        if (!a(paramObject, n, k)) {
          break label1564;
        }
        i = j * 53;
        j = zzjy.getName(paramObject, l).hashCode();
        break;
      case 60: 
        i = j;
        if (!a(paramObject, n, k)) {
          break label1564;
        }
        localObject = zzjy.getName(paramObject, l);
        i = j * 53;
        j = localObject.hashCode();
        break;
      case 59: 
        i = j;
        if (!a(paramObject, n, k)) {
          break label1564;
        }
        i = j * 53;
        j = ((String)zzjy.getName(paramObject, l)).hashCode();
        break;
      case 58: 
        i = j;
        if (!a(paramObject, n, k)) {
          break label1564;
        }
        i = j * 53;
        j = zzhc.hashCode(next(paramObject, l));
        break;
      case 57: 
        i = j;
        if (!a(paramObject, n, k)) {
          break label1564;
        }
        i = j * 53;
        j = getName(paramObject, l);
        break;
      case 56: 
        i = j;
        if (!a(paramObject, n, k)) {
          break label1564;
        }
        i = j * 53;
        j = zzhc.hashCode(getId(paramObject, l));
        break;
      case 55: 
        i = j;
        if (!a(paramObject, n, k)) {
          break label1564;
        }
        i = j * 53;
        j = getName(paramObject, l);
        break;
      case 54: 
        i = j;
        if (!a(paramObject, n, k)) {
          break label1564;
        }
        i = j * 53;
        j = zzhc.hashCode(getId(paramObject, l));
        break;
      case 53: 
        i = j;
        if (!a(paramObject, n, k)) {
          break label1564;
        }
        i = j * 53;
        j = zzhc.hashCode(getId(paramObject, l));
        break;
      case 52: 
        i = j;
        if (!a(paramObject, n, k)) {
          break label1564;
        }
        i = j * 53;
        j = Float.floatToIntBits(invoke(paramObject, l));
        break;
      case 51: 
        i = j;
        if (!a(paramObject, n, k)) {
          break label1564;
        }
        i = j * 53;
        j = zzhc.hashCode(Double.doubleToLongBits(getValue(paramObject, l)));
        break;
      case 50: 
        i = j * 53;
        j = zzjy.getName(paramObject, l).hashCode();
        break;
      case 18: 
      case 19: 
      case 20: 
      case 21: 
      case 22: 
      case 23: 
      case 24: 
      case 25: 
      case 26: 
      case 27: 
      case 28: 
      case 29: 
      case 30: 
      case 31: 
      case 32: 
      case 33: 
      case 34: 
      case 35: 
      case 36: 
      case 37: 
      case 38: 
      case 39: 
      case 40: 
      case 41: 
      case 42: 
      case 43: 
      case 44: 
      case 45: 
      case 46: 
      case 47: 
      case 48: 
      case 49: 
        i = j * 53;
        j = zzjy.getName(paramObject, l).hashCode();
        break;
      case 17: 
        localObject = zzjy.getName(paramObject, l);
        if (localObject != null) {
          i = localObject.hashCode();
        }
        break;
      case 16: 
        i = j * 53;
        j = zzhc.hashCode(zzjy.getId(paramObject, l));
        break;
      case 15: 
        i = j * 53;
        j = zzjy.getValue(paramObject, l);
        break;
      case 14: 
        i = j * 53;
        j = zzhc.hashCode(zzjy.getId(paramObject, l));
        break;
      case 13: 
        i = j * 53;
        j = zzjy.getValue(paramObject, l);
        break;
      case 12: 
        i = j * 53;
        j = zzjy.getValue(paramObject, l);
        break;
      case 11: 
        i = j * 53;
        j = zzjy.getValue(paramObject, l);
        break;
      case 10: 
        i = j * 53;
        j = zzjy.getName(paramObject, l).hashCode();
        break;
      case 9: 
        localObject = zzjy.getName(paramObject, l);
        if (localObject != null) {
          i = localObject.hashCode();
        }
        i = j * 53 + i;
        break;
      case 8: 
        i = j * 53;
        j = ((String)zzjy.getName(paramObject, l)).hashCode();
        break;
      case 7: 
        i = j * 53;
        j = zzhc.hashCode(zzjy.next(paramObject, l));
        break;
      case 6: 
        i = j * 53;
        j = zzjy.getValue(paramObject, l);
        break;
      case 5: 
        i = j * 53;
        j = zzhc.hashCode(zzjy.getId(paramObject, l));
        break;
      case 4: 
        i = j * 53;
        j = zzjy.getValue(paramObject, l);
        break;
      case 3: 
        i = j * 53;
        j = zzhc.hashCode(zzjy.getId(paramObject, l));
        break;
      case 2: 
        i = j * 53;
        j = zzhc.hashCode(zzjy.getId(paramObject, l));
        break;
      case 1: 
        i = j * 53;
        j = Float.floatToIntBits(zzjy.size(paramObject, l));
        break;
      }
      i = j * 53;
      j = zzhc.hashCode(Double.doubleToLongBits(zzjy.charAt(paramObject, l)));
      i += j;
      label1564:
      k += 3;
    }
    j = j * 53 + zzzz.getValue(paramObject).hashCode();
    int i = j;
    if (zzaaa) {
      i = j * 53 + zzaab.getValue(paramObject).hashCode();
    }
    return i;
  }
  
  public final void moveArt(Object paramObject)
  {
    int i = zzaam;
    int j;
    for (;;)
    {
      j = zzaan;
      if (i >= j) {
        break;
      }
      long l = zzai(zzaal[i]) & 0xFFFFF;
      Object localObject = zzjy.getName(paramObject, l);
      if (localObject != null) {
        zzjy.append(paramObject, l, zzaaq.getName(localObject));
      }
      i += 1;
    }
    int k = zzaal.length;
    i = j;
    while (i < k)
    {
      zzaap.setObjectClass(paramObject, zzaal[i]);
      i += 1;
    }
    zzzz.renameTo(paramObject);
    if (zzaaa) {
      zzaab.updatePreferences(paramObject);
    }
  }
  
  public final int parse(Object paramObject)
  {
    int j;
    long l;
    Object localObject2;
    int i1;
    if (zzaaj)
    {
      localObject1 = zzaad;
      m = 0;
      for (n = 0; m < zzaae.length; n = i)
      {
        j = zzai(m);
        i = (j & 0xFF00000) >>> 20;
        k = zzaae[m];
        l = j & 0xFFFFF;
        if ((i >= zzgu.zzwo.getEventType()) && (i <= zzgu.zzxb.getEventType())) {
          j = zzaae[(m + 2)];
        }
        switch (i)
        {
        default: 
          i = n;
          break;
        case 68: 
          i = n;
          if (!a(paramObject, k, m)) {
            break label2744;
          }
          i = zzgk.getTime(k, (zzik)zzjy.getName(paramObject, l), zzag(m));
          break;
        case 67: 
          i = n;
          if (!a(paramObject, k, m)) {
            break label2744;
          }
          i = zzgk.toString(k, getId(paramObject, l));
          break;
        case 66: 
          i = n;
          if (!a(paramObject, k, m)) {
            break label2744;
          }
          i = zzgk.process_pi_val(k, getName(paramObject, l));
          break;
        case 65: 
          i = n;
          if (!a(paramObject, k, m)) {
            break label2744;
          }
          i = zzgk.skipChar(k, 0L);
          break;
        case 64: 
          i = n;
          if (!a(paramObject, k, m)) {
            break label2744;
          }
          i = zzgk.skipChar(k, 0);
          break;
        case 63: 
          i = n;
          if (!a(paramObject, k, m)) {
            break label2744;
          }
          i = zzgk.isHidden(k, getName(paramObject, l));
          break;
        case 62: 
          i = n;
          if (!a(paramObject, k, m)) {
            break label2744;
          }
          i = zzgk.decode(k, getName(paramObject, l));
          break;
        case 61: 
          i = n;
          if (!a(paramObject, k, m)) {
            break label2744;
          }
          i = zzgk.decode(k, (zzfx)zzjy.getName(paramObject, l));
          break;
        case 60: 
          i = n;
          if (!a(paramObject, k, m)) {
            break label2744;
          }
          i = zzjc.hashCode(k, zzjy.getName(paramObject, l), zzag(m));
          break;
        case 59: 
          i = n;
          if (!a(paramObject, k, m)) {
            break label2744;
          }
          localObject2 = zzjy.getName(paramObject, l);
          if ((localObject2 instanceof zzfx)) {
            i = zzgk.decode(k, (zzfx)localObject2);
          } else {
            i = zzgk.write(k, (String)localObject2);
          }
          break;
        case 58: 
          i = n;
          if (!a(paramObject, k, m)) {
            break label2744;
          }
          i = zzgk.toString(k, true);
          break;
        case 57: 
          i = n;
          if (!a(paramObject, k, m)) {
            break label2744;
          }
          i = zzgk.read(k, 0);
          break;
        case 56: 
          i = n;
          if (!a(paramObject, k, m)) {
            break label2744;
          }
          i = zzgk.get(k, 0L);
          break;
        case 55: 
          i = n;
          if (!a(paramObject, k, m)) {
            break label2744;
          }
          i = zzgk.writeVTD(k, getName(paramObject, l));
          break;
        case 54: 
          i = n;
          if (!a(paramObject, k, m)) {
            break label2744;
          }
          i = zzgk.getCard(k, getId(paramObject, l));
          break;
        case 53: 
          i = n;
          if (!a(paramObject, k, m)) {
            break label2744;
          }
          i = zzgk.updatePlaylist(k, getId(paramObject, l));
          break;
        case 52: 
          i = n;
          if (!a(paramObject, k, m)) {
            break label2744;
          }
          i = zzgk.skipChar(k, 0.0F);
          break;
        case 51: 
          i = n;
          if (!a(paramObject, k, m)) {
            break label2744;
          }
          i = zzgk.skipChar(k, 0.0D);
          break;
        case 50: 
          i = zzaaq.register(k, zzjy.getName(paramObject, l), zzah(m));
          break;
        case 49: 
          i = zzjc.addHeaders(k, get(paramObject, l), zzag(m));
          break;
        case 48: 
          i1 = zzjc.size((List)((Unsafe)localObject1).getObject(paramObject, l));
          j = i1;
          i = n;
          if (i1 <= 0) {
            break label2744;
          }
          k = zzgk.format(k);
          i1 = zzgk.append(i1);
          i = j;
          j = i1;
          break;
        case 47: 
          i1 = zzjc.getSeasons((List)((Unsafe)localObject1).getObject(paramObject, l));
          j = i1;
          i = n;
          if (i1 <= 0) {
            break label2744;
          }
          k = zzgk.format(k);
          i1 = zzgk.append(i1);
          i = j;
          j = i1;
          break;
        case 46: 
          i1 = zzjc.parseScreen((List)((Unsafe)localObject1).getObject(paramObject, l));
          j = i1;
          i = n;
          if (i1 <= 0) {
            break label2744;
          }
          k = zzgk.format(k);
          i1 = zzgk.append(i1);
          i = j;
          j = i1;
          break;
        case 45: 
          i1 = zzjc.moveToString((List)((Unsafe)localObject1).getObject(paramObject, l));
          j = i1;
          i = n;
          if (i1 <= 0) {
            break label2744;
          }
          k = zzgk.format(k);
          i1 = zzgk.append(i1);
          i = j;
          j = i1;
          break;
        case 44: 
          i1 = zzjc.next((List)((Unsafe)localObject1).getObject(paramObject, l));
          j = i1;
          i = n;
          if (i1 <= 0) {
            break label2744;
          }
          k = zzgk.format(k);
          i1 = zzgk.append(i1);
          i = j;
          j = i1;
          break;
        case 43: 
          i1 = zzjc.getString((List)((Unsafe)localObject1).getObject(paramObject, l));
          j = i1;
          i = n;
          if (i1 <= 0) {
            break label2744;
          }
          k = zzgk.format(k);
          i1 = zzgk.append(i1);
          i = j;
          j = i1;
          break;
        case 42: 
          i1 = zzjc.getNumberOfColumns((List)((Unsafe)localObject1).getObject(paramObject, l));
          j = i1;
          i = n;
          if (i1 <= 0) {
            break label2744;
          }
          k = zzgk.format(k);
          i1 = zzgk.append(i1);
          i = j;
          j = i1;
          break;
        case 41: 
          i1 = zzjc.moveToString((List)((Unsafe)localObject1).getObject(paramObject, l));
          j = i1;
          i = n;
          if (i1 <= 0) {
            break label2744;
          }
          k = zzgk.format(k);
          i1 = zzgk.append(i1);
          i = j;
          j = i1;
          break;
        case 40: 
          i1 = zzjc.parseScreen((List)((Unsafe)localObject1).getObject(paramObject, l));
          j = i1;
          i = n;
          if (i1 <= 0) {
            break label2744;
          }
          k = zzgk.format(k);
          i1 = zzgk.append(i1);
          i = j;
          j = i1;
          break;
        case 39: 
          i1 = zzjc.decode((List)((Unsafe)localObject1).getObject(paramObject, l));
          j = i1;
          i = n;
          if (i1 <= 0) {
            break label2744;
          }
          k = zzgk.format(k);
          i1 = zzgk.append(i1);
          i = j;
          j = i1;
          break;
        case 38: 
          i1 = zzjc.get((List)((Unsafe)localObject1).getObject(paramObject, l));
          j = i1;
          i = n;
          if (i1 <= 0) {
            break label2744;
          }
          k = zzgk.format(k);
          i1 = zzgk.append(i1);
          i = j;
          j = i1;
          break;
        case 37: 
          i1 = zzjc.write((List)((Unsafe)localObject1).getObject(paramObject, l));
          j = i1;
          i = n;
          if (i1 <= 0) {
            break label2744;
          }
          k = zzgk.format(k);
          i1 = zzgk.append(i1);
          i = j;
          j = i1;
          break;
        case 36: 
          i1 = zzjc.moveToString((List)((Unsafe)localObject1).getObject(paramObject, l));
          j = i1;
          i = n;
          if (i1 <= 0) {
            break label2744;
          }
          k = zzgk.format(k);
          i1 = zzgk.append(i1);
          i = j;
          j = i1;
          break;
        case 35: 
          j = zzjc.parseScreen((List)((Unsafe)localObject1).getObject(paramObject, l));
          i1 = j;
          i = n;
          if (j <= 0) {
            break label2744;
          }
          k = zzgk.format(k);
          j = zzgk.append(j);
          i = i1;
          i = k + j + i;
          break;
        case 34: 
          i = zzjc.getInstance(k, get(paramObject, l), false);
          break;
        case 33: 
          i = zzjc.check(k, get(paramObject, l), false);
          break;
        case 32: 
          i = zzjc.getGameId(k, get(paramObject, l), false);
          break;
        case 31: 
          i = zzjc.getBoolean(k, get(paramObject, l), false);
          break;
        case 30: 
          i = zzjc.toHtml(k, get(paramObject, l), false);
          break;
        case 29: 
          i = zzjc.get(k, get(paramObject, l), false);
          break;
        case 28: 
          i = zzjc.push(k, get(paramObject, l));
          break;
        case 27: 
          i = zzjc.indexOf(k, get(paramObject, l), zzag(m));
          break;
        case 26: 
          i = zzjc.getValue(k, get(paramObject, l));
          break;
        case 25: 
          i = zzjc.addBlock(k, get(paramObject, l), false);
          break;
        case 24: 
          i = zzjc.getBoolean(k, get(paramObject, l), false);
          break;
        case 23: 
          i = zzjc.getGameId(k, get(paramObject, l), false);
          break;
        case 22: 
          i = zzjc.parse(k, get(paramObject, l), false);
          break;
        case 21: 
          i = zzjc.loadData(k, get(paramObject, l), false);
          break;
        case 20: 
          i = zzjc.refresh(k, get(paramObject, l), false);
          break;
        case 19: 
          i = zzjc.getBoolean(k, get(paramObject, l), false);
          break;
        case 18: 
          i = zzjc.getGameId(k, get(paramObject, l), false);
        }
        for (;;)
        {
          i = n + i;
          break;
          i = n;
          if (!get(paramObject, m)) {
            break;
          }
          i = zzgk.getTime(k, (zzik)zzjy.getName(paramObject, l), zzag(m));
          continue;
          i = n;
          if (!get(paramObject, m)) {
            break;
          }
          i = zzgk.toString(k, zzjy.getId(paramObject, l));
          continue;
          i = n;
          if (!get(paramObject, m)) {
            break;
          }
          i = zzgk.process_pi_val(k, zzjy.getValue(paramObject, l));
          continue;
          i = n;
          if (!get(paramObject, m)) {
            break;
          }
          i = zzgk.skipChar(k, 0L);
          continue;
          i = n;
          if (!get(paramObject, m)) {
            break;
          }
          i = zzgk.skipChar(k, 0);
          continue;
          i = n;
          if (!get(paramObject, m)) {
            break;
          }
          i = zzgk.isHidden(k, zzjy.getValue(paramObject, l));
          continue;
          i = n;
          if (!get(paramObject, m)) {
            break;
          }
          i = zzgk.decode(k, zzjy.getValue(paramObject, l));
          continue;
          i = n;
          if (!get(paramObject, m)) {
            break;
          }
          i = zzgk.decode(k, (zzfx)zzjy.getName(paramObject, l));
          continue;
          i = n;
          if (!get(paramObject, m)) {
            break;
          }
          i = zzjc.hashCode(k, zzjy.getName(paramObject, l), zzag(m));
          continue;
          i = n;
          if (!get(paramObject, m)) {
            break;
          }
          localObject2 = zzjy.getName(paramObject, l);
          if ((localObject2 instanceof zzfx))
          {
            i = zzgk.decode(k, (zzfx)localObject2);
          }
          else
          {
            i = zzgk.write(k, (String)localObject2);
            continue;
            i = n;
            if (!get(paramObject, m)) {
              break;
            }
            i = zzgk.toString(k, true);
            continue;
            i = n;
            if (!get(paramObject, m)) {
              break;
            }
            i = zzgk.read(k, 0);
            continue;
            i = n;
            if (!get(paramObject, m)) {
              break;
            }
            i = zzgk.get(k, 0L);
            continue;
            i = n;
            if (!get(paramObject, m)) {
              break;
            }
            i = zzgk.writeVTD(k, zzjy.getValue(paramObject, l));
            continue;
            i = n;
            if (!get(paramObject, m)) {
              break;
            }
            i = zzgk.getCard(k, zzjy.getId(paramObject, l));
            continue;
            i = n;
            if (!get(paramObject, m)) {
              break;
            }
            i = zzgk.updatePlaylist(k, zzjy.getId(paramObject, l));
            continue;
            i = n;
            if (!get(paramObject, m)) {
              break;
            }
            i = zzgk.skipChar(k, 0.0F);
            continue;
            i = n;
            if (!get(paramObject, m)) {
              break;
            }
            i = zzgk.skipChar(k, 0.0D);
          }
        }
        label2744:
        m += 3;
      }
      return n + next(zzzz, paramObject);
    }
    Object localObject1 = zzaad;
    int i = 1048575;
    int n = 0;
    int m = 0;
    int i2 = 0;
    while (n < zzaae.length)
    {
      int i5 = zzai(n);
      localObject2 = zzaae;
      int i4 = localObject2[n];
      int i6 = (i5 & 0xFF00000) >>> 20;
      if (i6 <= 17)
      {
        j = localObject2[(n + 2)];
        k = j & 0xFFFFF;
        int i3 = 1 << (j >>> 20);
        i1 = i;
        j = i3;
        if (k != i)
        {
          i2 = ((Unsafe)localObject1).getInt(paramObject, k);
          i1 = k;
          j = i3;
        }
      }
      else
      {
        j = 0;
        i1 = i;
      }
      l = i5 & 0xFFFFF;
      switch (i6)
      {
      default: 
        i = m;
        break;
      case 68: 
        i = m;
        if (a(paramObject, i4, n)) {
          i = zzgk.getTime(i4, (zzik)((Unsafe)localObject1).getObject(paramObject, l), zzag(n));
        }
        break;
      case 67: 
        i = m;
        if (a(paramObject, i4, n)) {
          i = zzgk.toString(i4, getId(paramObject, l));
        }
        break;
      case 66: 
        i = m;
        if (a(paramObject, i4, n)) {
          i = zzgk.process_pi_val(i4, getName(paramObject, l));
        }
        break;
      case 65: 
        i = m;
        if (a(paramObject, i4, n)) {
          i = zzgk.skipChar(i4, 0L);
        }
        break;
      case 64: 
        i = m;
        if (a(paramObject, i4, n)) {
          i = zzgk.skipChar(i4, 0);
        }
        break;
      case 63: 
        i = m;
        if (a(paramObject, i4, n)) {
          i = zzgk.isHidden(i4, getName(paramObject, l));
        }
        break;
      case 62: 
        i = m;
        if (a(paramObject, i4, n)) {
          i = zzgk.decode(i4, getName(paramObject, l));
        }
        break;
      case 61: 
        i = m;
        if (a(paramObject, i4, n)) {
          i = zzgk.decode(i4, (zzfx)((Unsafe)localObject1).getObject(paramObject, l));
        }
        break;
      case 60: 
        i = m;
        if (a(paramObject, i4, n)) {
          i = zzjc.hashCode(i4, ((Unsafe)localObject1).getObject(paramObject, l), zzag(n));
        }
        break;
      case 59: 
        i = m;
        if (a(paramObject, i4, n))
        {
          localObject2 = ((Unsafe)localObject1).getObject(paramObject, l);
          if ((localObject2 instanceof zzfx)) {
            i = zzgk.decode(i4, (zzfx)localObject2);
          } else {
            i = zzgk.write(i4, (String)localObject2);
          }
        }
        break;
      case 58: 
        i = m;
        if (a(paramObject, i4, n)) {
          i = zzgk.toString(i4, true);
        }
        break;
      case 57: 
        i = m;
        if (a(paramObject, i4, n)) {
          i = zzgk.read(i4, 0);
        }
        break;
      case 56: 
        i = m;
        if (a(paramObject, i4, n)) {
          i = zzgk.get(i4, 0L);
        }
        break;
      case 55: 
        i = m;
        if (a(paramObject, i4, n)) {
          i = zzgk.writeVTD(i4, getName(paramObject, l));
        }
        break;
      case 54: 
        i = m;
        if (a(paramObject, i4, n)) {
          i = zzgk.getCard(i4, getId(paramObject, l));
        }
        break;
      case 53: 
        i = m;
        if (a(paramObject, i4, n)) {
          i = zzgk.updatePlaylist(i4, getId(paramObject, l));
        }
        break;
      case 52: 
        i = m;
        if (a(paramObject, i4, n)) {
          i = zzgk.skipChar(i4, 0.0F);
        }
        break;
      case 51: 
        i = m;
        if (a(paramObject, i4, n)) {
          i = zzgk.skipChar(i4, 0.0D);
        }
        break;
      case 50: 
        i = zzaaq.register(i4, ((Unsafe)localObject1).getObject(paramObject, l), zzah(n));
        break;
      case 49: 
        i = zzjc.addHeaders(i4, (List)((Unsafe)localObject1).getObject(paramObject, l), zzag(n));
        break;
      case 48: 
        k = zzjc.size((List)((Unsafe)localObject1).getObject(paramObject, l));
        j = k;
        i = m;
        if (k > 0)
        {
          i = zzgk.format(i4);
          k = zzgk.append(k);
        }
        break;
      case 47: 
        k = zzjc.getSeasons((List)((Unsafe)localObject1).getObject(paramObject, l));
        j = k;
        i = m;
        if (k > 0)
        {
          i = zzgk.format(i4);
          k = zzgk.append(k);
        }
        break;
      case 46: 
        k = zzjc.parseScreen((List)((Unsafe)localObject1).getObject(paramObject, l));
        j = k;
        i = m;
        if (k > 0)
        {
          i = zzgk.format(i4);
          k = zzgk.append(k);
        }
        break;
      case 45: 
        k = zzjc.moveToString((List)((Unsafe)localObject1).getObject(paramObject, l));
        j = k;
        i = m;
        if (k > 0)
        {
          i = zzgk.format(i4);
          k = zzgk.append(k);
        }
        break;
      case 44: 
        k = zzjc.next((List)((Unsafe)localObject1).getObject(paramObject, l));
        j = k;
        i = m;
        if (k > 0)
        {
          i = zzgk.format(i4);
          k = zzgk.append(k);
        }
        break;
      case 43: 
        k = zzjc.getString((List)((Unsafe)localObject1).getObject(paramObject, l));
        j = k;
        i = m;
        if (k > 0)
        {
          i = zzgk.format(i4);
          k = zzgk.append(k);
        }
        break;
      case 42: 
        k = zzjc.getNumberOfColumns((List)((Unsafe)localObject1).getObject(paramObject, l));
        j = k;
        i = m;
        if (k > 0)
        {
          i = zzgk.format(i4);
          k = zzgk.append(k);
        }
        break;
      case 41: 
        k = zzjc.moveToString((List)((Unsafe)localObject1).getObject(paramObject, l));
        j = k;
        i = m;
        if (k > 0)
        {
          i = zzgk.format(i4);
          k = zzgk.append(k);
        }
        break;
      case 40: 
        k = zzjc.parseScreen((List)((Unsafe)localObject1).getObject(paramObject, l));
        j = k;
        i = m;
        if (k > 0)
        {
          i = zzgk.format(i4);
          k = zzgk.append(k);
        }
        break;
      case 39: 
        k = zzjc.decode((List)((Unsafe)localObject1).getObject(paramObject, l));
        j = k;
        i = m;
        if (k > 0)
        {
          i = zzgk.format(i4);
          k = zzgk.append(k);
        }
        break;
      case 38: 
        k = zzjc.get((List)((Unsafe)localObject1).getObject(paramObject, l));
        j = k;
        i = m;
        if (k > 0)
        {
          i = zzgk.format(i4);
          k = zzgk.append(k);
        }
        break;
      case 37: 
        k = zzjc.write((List)((Unsafe)localObject1).getObject(paramObject, l));
        j = k;
        i = m;
        if (k > 0)
        {
          i = zzgk.format(i4);
          k = zzgk.append(k);
        }
        break;
      case 36: 
        k = zzjc.moveToString((List)((Unsafe)localObject1).getObject(paramObject, l));
        j = k;
        i = m;
        if (k > 0)
        {
          i = zzgk.format(i4);
          k = zzgk.append(k);
        }
        break;
      case 35: 
        k = zzjc.parseScreen((List)((Unsafe)localObject1).getObject(paramObject, l));
        j = k;
        i = m;
        if (k > 0)
        {
          i = zzgk.format(i4);
          k = zzgk.append(k);
          i = i + k + j;
        }
        break;
      case 34: 
        i = zzjc.getInstance(i4, (List)((Unsafe)localObject1).getObject(paramObject, l), false);
        break;
      case 33: 
        i = zzjc.check(i4, (List)((Unsafe)localObject1).getObject(paramObject, l), false);
        break;
      case 32: 
        i = zzjc.getGameId(i4, (List)((Unsafe)localObject1).getObject(paramObject, l), false);
        break;
      case 31: 
        i = zzjc.getBoolean(i4, (List)((Unsafe)localObject1).getObject(paramObject, l), false);
        break;
      case 30: 
        i = zzjc.toHtml(i4, (List)((Unsafe)localObject1).getObject(paramObject, l), false);
        break;
      case 29: 
        i = zzjc.get(i4, (List)((Unsafe)localObject1).getObject(paramObject, l), false);
        break;
      case 28: 
        i = zzjc.push(i4, (List)((Unsafe)localObject1).getObject(paramObject, l));
        break;
      case 27: 
        i = zzjc.indexOf(i4, (List)((Unsafe)localObject1).getObject(paramObject, l), zzag(n));
        break;
      case 26: 
        i = zzjc.getValue(i4, (List)((Unsafe)localObject1).getObject(paramObject, l));
        break;
      case 25: 
        i = zzjc.addBlock(i4, (List)((Unsafe)localObject1).getObject(paramObject, l), false);
        break;
      case 24: 
        i = zzjc.getBoolean(i4, (List)((Unsafe)localObject1).getObject(paramObject, l), false);
        break;
      case 23: 
        i = zzjc.getGameId(i4, (List)((Unsafe)localObject1).getObject(paramObject, l), false);
        break;
      case 22: 
        i = zzjc.parse(i4, (List)((Unsafe)localObject1).getObject(paramObject, l), false);
        break;
      case 21: 
        i = zzjc.loadData(i4, (List)((Unsafe)localObject1).getObject(paramObject, l), false);
        break;
      case 20: 
        i = zzjc.refresh(i4, (List)((Unsafe)localObject1).getObject(paramObject, l), false);
        break;
      case 19: 
        i = zzjc.getBoolean(i4, (List)((Unsafe)localObject1).getObject(paramObject, l), false);
        i = m + i;
      case 18: 
      case 17: 
      case 16: 
      case 15: 
      case 14: 
      case 13: 
      case 12: 
      case 11: 
      case 10: 
      case 9: 
      case 8: 
      case 7: 
      case 6: 
        for (;;)
        {
          break label5068;
          i = zzjc.getGameId(i4, (List)((Unsafe)localObject1).getObject(paramObject, l), false);
          i = m + i;
          for (;;)
          {
            break label5574;
            i = m;
            if ((i2 & j) != 0)
            {
              i = zzgk.getTime(i4, (zzik)((Unsafe)localObject1).getObject(paramObject, l), zzag(n));
              break;
              i = m;
              if ((i2 & j) != 0)
              {
                i = zzgk.toString(i4, ((Unsafe)localObject1).getLong(paramObject, l));
                break;
                i = m;
                if ((i2 & j) != 0)
                {
                  i = zzgk.process_pi_val(i4, ((Unsafe)localObject1).getInt(paramObject, l));
                  break;
                  i = m;
                  if ((i2 & j) != 0)
                  {
                    i = zzgk.skipChar(i4, 0L);
                    break;
                    i = m;
                    if ((i2 & j) != 0)
                    {
                      i = zzgk.skipChar(i4, 0);
                      i = m + i;
                      continue;
                      i = m;
                      if ((i2 & j) != 0)
                      {
                        i = zzgk.isHidden(i4, ((Unsafe)localObject1).getInt(paramObject, l));
                        break;
                        i = m;
                        if ((i2 & j) != 0)
                        {
                          i = zzgk.decode(i4, ((Unsafe)localObject1).getInt(paramObject, l));
                          break;
                          i = m;
                          if ((i2 & j) != 0)
                          {
                            i = zzgk.decode(i4, (zzfx)((Unsafe)localObject1).getObject(paramObject, l));
                            break;
                            i = m;
                            if ((i2 & j) != 0)
                            {
                              i = zzjc.hashCode(i4, ((Unsafe)localObject1).getObject(paramObject, l), zzag(n));
                              break;
                              i = m;
                              if ((i2 & j) != 0)
                              {
                                localObject2 = ((Unsafe)localObject1).getObject(paramObject, l);
                                if ((localObject2 instanceof zzfx))
                                {
                                  i = zzgk.decode(i4, (zzfx)localObject2);
                                  break;
                                }
                                i = zzgk.write(i4, (String)localObject2);
                                break;
                                i = m;
                                if ((i2 & j) != 0) {
                                  i = m + zzgk.toString(i4, true);
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          i = m;
          if ((i2 & j) != 0) {
            i = m + zzgk.read(i4, 0);
          }
        }
      case 5: 
        i = m;
        if ((i2 & j) != 0) {
          i = zzgk.get(i4, 0L);
        }
        break;
      case 4: 
        i = m;
        if ((j & i2) != 0) {
          i = zzgk.writeVTD(i4, ((Unsafe)localObject1).getInt(paramObject, l));
        }
        break;
      case 3: 
        i = m;
        if ((j & i2) != 0) {
          i = zzgk.getCard(i4, ((Unsafe)localObject1).getLong(paramObject, l));
        }
        break;
      case 2: 
        i = m;
        if ((j & i2) != 0)
        {
          i = zzgk.updatePlaylist(i4, ((Unsafe)localObject1).getLong(paramObject, l));
          i = m + i;
        }
        break;
      case 1: 
        label5068:
        i = m;
        if ((i2 & j) != 0) {
          i = m + zzgk.skipChar(i4, 0.0F);
        }
        break;
      }
      for (;;)
      {
        break;
        i = m;
        if ((i2 & j) != 0) {
          i = m + zzgk.skipChar(i4, 0.0D);
        }
      }
      label5574:
      n += 3;
      m = i;
      i = i1;
    }
    n = 0;
    int k = m + next(zzzz, paramObject);
    i = k;
    if (zzaaa)
    {
      paramObject = zzaab.getValue(paramObject);
      j = 0;
      i = n;
      while (j < zzvb.zzdc())
      {
        localObject1 = zzvb.zzal(j);
        i += zzgt.write((zzgv)((Map.Entry)localObject1).getKey(), ((Map.Entry)localObject1).getValue());
        j += 1;
      }
      paramObject = zzvb.zzdd().iterator();
      while (paramObject.hasNext())
      {
        localObject1 = (Map.Entry)paramObject.next();
        i += zzgt.write((zzgv)((Map.Entry)localObject1).getKey(), ((Map.Entry)localObject1).getValue());
      }
      i = k + i;
    }
    return i;
  }
}
