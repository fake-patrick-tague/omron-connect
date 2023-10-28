package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.misc.Unsafe;

final class zzlo<T>
  implements zzlw<T>
{
  private static final Unsafe r = zzmx.getResourceAsStream();
  private static final int[] v = new int[0];
  private final Object[] a;
  private final zzjr b;
  private final boolean c;
  private final boolean d;
  private final int[] i;
  private final int k;
  private final zzll l;
  private final zzlg n;
  private final int o;
  private final int[] p;
  private final int size;
  private final int type;
  private final zzlq visible;
  private final zzmn x;
  private final zzkz y;
  
  private zzlo(int[] paramArrayOfInt1, Object[] paramArrayOfObject, int paramInt1, int paramInt2, zzll paramZzll, boolean paramBoolean1, boolean paramBoolean2, int[] paramArrayOfInt2, int paramInt3, int paramInt4, zzlq paramZzlq, zzkz paramZzkz, zzmn paramZzmn, zzjr paramZzjr, zzlg paramZzlg, byte[] paramArrayOfByte)
  {
    i = paramArrayOfInt1;
    a = paramArrayOfObject;
    k = paramInt1;
    o = paramInt2;
    d = paramBoolean1;
    paramBoolean2 = false;
    paramBoolean1 = paramBoolean2;
    if (paramZzjr != null)
    {
      paramBoolean1 = paramBoolean2;
      if (paramZzjr.accepts(paramZzll)) {
        paramBoolean1 = true;
      }
    }
    c = paramBoolean1;
    p = paramArrayOfInt2;
    size = paramInt3;
    type = paramInt4;
    visible = paramZzlq;
    y = paramZzkz;
    x = paramZzmn;
    b = paramZzjr;
    l = paramZzll;
    n = paramZzlg;
  }
  
  private static float a(Object paramObject, long paramLong)
  {
    return ((Float)zzmx.getValue(paramObject, paramLong)).floatValue();
  }
  
  private final int a(int paramInt1, int paramInt2)
  {
    int j = i.length / 3 - 1;
    while (paramInt2 <= j)
    {
      int m = j + paramInt2 >>> 1;
      int i1 = m * 3;
      int i2 = i[i1];
      if (paramInt1 == i2) {
        return i1;
      }
      if (paramInt1 < i2) {
        j = m - 1;
      } else {
        paramInt2 = m + 1;
      }
    }
    return -1;
  }
  
  private final int a(Object paramObject)
  {
    Object localObject1 = r;
    int i2 = 0;
    int j;
    for (int i3 = 0; i2 < i.length; i3 = j)
    {
      int m = charAt(i2);
      j = b(m);
      int i1 = i[i2];
      long l1 = m & 0xFFFFF;
      if ((j >= zzjw.type.length()) && (j <= zzjw.b.length())) {
        m = i[(i2 + 2)];
      }
      Object localObject2;
      int i4;
      switch (j)
      {
      default: 
        j = i3;
        break;
      case 68: 
        j = i3;
        if (!get(paramObject, i1, i2)) {
          break label3083;
        }
        j = zzjl.b(i1, (zzll)zzmx.getValue(paramObject, l1), toString(i2));
        break;
      case 67: 
        j = i3;
        if (!get(paramObject, i1, i2)) {
          break label3083;
        }
        l1 = get(paramObject, l1);
        m = zzjl.append(i1 << 3);
        j = zzjl.get(l1 >> 63 ^ l1 + l1);
        break;
      case 66: 
        j = i3;
        if (!get(paramObject, i1, i2)) {
          break label3083;
        }
        j = getValue(paramObject, l1);
        m = zzjl.append(i1 << 3);
        j = zzjl.append(j >> 31 ^ j + j);
        break;
      case 65: 
        j = i3;
        if (!get(paramObject, i1, i2)) {
          break label3083;
        }
        j = zzjl.append(i1 << 3);
        break;
      case 64: 
        j = i3;
        if (!get(paramObject, i1, i2)) {
          break label3083;
        }
        j = zzjl.append(i1 << 3);
        break;
      case 63: 
        j = i3;
        if (!get(paramObject, i1, i2)) {
          break label3083;
        }
        j = getValue(paramObject, l1);
        m = zzjl.append(i1 << 3);
        j = zzjl.get(j);
        break;
      case 62: 
        j = i3;
        if (!get(paramObject, i1, i2)) {
          break label3083;
        }
        j = getValue(paramObject, l1);
        m = zzjl.append(i1 << 3);
        j = zzjl.append(j);
        break;
      case 61: 
        j = i3;
        if (!get(paramObject, i1, i2)) {
          break label3083;
        }
        localObject2 = (zzjd)zzmx.getValue(paramObject, l1);
        j = zzjl.append(i1 << 3);
        m = ((zzjd)localObject2).size();
        i1 = m;
        m = zzjl.append(m);
        break;
      case 60: 
        j = i3;
        if (!get(paramObject, i1, i2)) {
          break label3083;
        }
        j = zzly.a(i1, zzmx.getValue(paramObject, l1), toString(i2));
        break;
      case 59: 
        j = i3;
        if (!get(paramObject, i1, i2)) {
          break label3083;
        }
        localObject2 = zzmx.getValue(paramObject, l1);
        if ((localObject2 instanceof zzjd))
        {
          localObject2 = (zzjd)localObject2;
          j = zzjl.append(i1 << 3);
          m = ((zzjd)localObject2).size();
          i1 = m;
          m = zzjl.append(m);
        }
        else
        {
          localObject2 = (String)localObject2;
          m = zzjl.append(i1 << 3);
          j = zzjl.a((String)localObject2);
        }
        break;
      case 58: 
        j = i3;
        if (!get(paramObject, i1, i2)) {
          break label3083;
        }
        j = zzjl.append(i1 << 3);
        break;
      case 57: 
        j = i3;
        if (!get(paramObject, i1, i2)) {
          break label3083;
        }
        j = zzjl.append(i1 << 3);
        break;
      case 56: 
        j = i3;
        if (!get(paramObject, i1, i2)) {
          break label3083;
        }
        j = zzjl.append(i1 << 3);
        break;
      case 55: 
        j = i3;
        if (!get(paramObject, i1, i2)) {
          break label3083;
        }
        j = getValue(paramObject, l1);
        m = zzjl.append(i1 << 3);
        j = zzjl.get(j);
        break;
      case 54: 
        j = i3;
        if (!get(paramObject, i1, i2)) {
          break label3083;
        }
        l1 = get(paramObject, l1);
        j = zzjl.append(i1 << 3);
        m = zzjl.get(l1);
        break;
      case 53: 
        j = i3;
        if (!get(paramObject, i1, i2)) {
          break label3083;
        }
        l1 = get(paramObject, l1);
        j = zzjl.append(i1 << 3);
        m = zzjl.get(l1);
        break;
      case 52: 
        j = i3;
        if (!get(paramObject, i1, i2)) {
          break label3083;
        }
        j = zzjl.append(i1 << 3);
        break;
      case 51: 
        j = i3;
        if (!get(paramObject, i1, i2)) {
          break label3083;
        }
        j = zzjl.append(i1 << 3);
        break;
      case 50: 
        zzlg.remove(i1, zzmx.getValue(paramObject, l1), get(i2));
        j = i3;
        break;
      case 49: 
        j = zzly.b(i1, (List)zzmx.getValue(paramObject, l1), toString(i2));
        break;
      case 48: 
        i4 = zzly.a((List)((Unsafe)localObject1).getObject(paramObject, l1));
        m = i4;
        j = i3;
        if (i4 <= 0) {
          break label3083;
        }
        i1 = zzjl.getValue(i1);
        i4 = zzjl.append(i4);
        j = m;
        m = i4;
        break;
      case 47: 
        i4 = zzly.read((List)((Unsafe)localObject1).getObject(paramObject, l1));
        m = i4;
        j = i3;
        if (i4 <= 0) {
          break label3083;
        }
        i1 = zzjl.getValue(i1);
        i4 = zzjl.append(i4);
        j = m;
        m = i4;
        break;
      case 46: 
        i4 = zzly.getStep((List)((Unsafe)localObject1).getObject(paramObject, l1));
        m = i4;
        j = i3;
        if (i4 <= 0) {
          break label3083;
        }
        i1 = zzjl.getValue(i1);
        i4 = zzjl.append(i4);
        j = m;
        m = i4;
        break;
      case 45: 
        i4 = zzly.sendChar((List)((Unsafe)localObject1).getObject(paramObject, l1));
        m = i4;
        j = i3;
        if (i4 <= 0) {
          break label3083;
        }
        i1 = zzjl.getValue(i1);
        i4 = zzjl.append(i4);
        j = m;
        m = i4;
        break;
      case 44: 
        i4 = zzly.replace((List)((Unsafe)localObject1).getObject(paramObject, l1));
        m = i4;
        j = i3;
        if (i4 <= 0) {
          break label3083;
        }
        i1 = zzjl.getValue(i1);
        i4 = zzjl.append(i4);
        j = m;
        m = i4;
        break;
      case 43: 
        i4 = zzly.encode((List)((Unsafe)localObject1).getObject(paramObject, l1));
        m = i4;
        j = i3;
        if (i4 <= 0) {
          break label3083;
        }
        i1 = zzjl.getValue(i1);
        i4 = zzjl.append(i4);
        j = m;
        m = i4;
        break;
      case 42: 
        i4 = zzly.getAttributeCount((List)((Unsafe)localObject1).getObject(paramObject, l1));
        m = i4;
        j = i3;
        if (i4 <= 0) {
          break label3083;
        }
        i1 = zzjl.getValue(i1);
        i4 = zzjl.append(i4);
        j = m;
        m = i4;
        break;
      case 41: 
        i4 = zzly.sendChar((List)((Unsafe)localObject1).getObject(paramObject, l1));
        m = i4;
        j = i3;
        if (i4 <= 0) {
          break label3083;
        }
        i1 = zzjl.getValue(i1);
        i4 = zzjl.append(i4);
        j = m;
        m = i4;
        break;
      case 40: 
        i4 = zzly.getStep((List)((Unsafe)localObject1).getObject(paramObject, l1));
        m = i4;
        j = i3;
        if (i4 <= 0) {
          break label3083;
        }
        i1 = zzjl.getValue(i1);
        i4 = zzjl.append(i4);
        j = m;
        m = i4;
        break;
      case 39: 
        i4 = zzly.add((List)((Unsafe)localObject1).getObject(paramObject, l1));
        m = i4;
        j = i3;
        if (i4 <= 0) {
          break label3083;
        }
        i1 = zzjl.getValue(i1);
        i4 = zzjl.append(i4);
        j = m;
        m = i4;
        break;
      case 38: 
        i4 = zzly.get((List)((Unsafe)localObject1).getObject(paramObject, l1));
        m = i4;
        j = i3;
        if (i4 <= 0) {
          break label3083;
        }
        i1 = zzjl.getValue(i1);
        i4 = zzjl.append(i4);
        j = m;
        m = i4;
        break;
      case 37: 
        i4 = zzly.getValue((List)((Unsafe)localObject1).getObject(paramObject, l1));
        m = i4;
        j = i3;
        if (i4 <= 0) {
          break label3083;
        }
        i1 = zzjl.getValue(i1);
        i4 = zzjl.append(i4);
        j = m;
        m = i4;
        break;
      case 36: 
        i4 = zzly.sendChar((List)((Unsafe)localObject1).getObject(paramObject, l1));
        m = i4;
        j = i3;
        if (i4 <= 0) {
          break label3083;
        }
        i1 = zzjl.getValue(i1);
        i4 = zzjl.append(i4);
        j = m;
        m = i4;
        break;
      case 35: 
        m = zzly.getStep((List)((Unsafe)localObject1).getObject(paramObject, l1));
        i4 = m;
        j = i3;
        if (m <= 0) {
          break label3083;
        }
        i1 = zzjl.getValue(i1);
        m = zzjl.append(m);
        j = i4;
        m = i1 + m;
        break;
      case 34: 
        j = zzly.b(i1, (List)zzmx.getValue(paramObject, l1), false);
        break;
      case 33: 
        j = zzly.a(i1, (List)zzmx.getValue(paramObject, l1), false);
        break;
      case 32: 
        j = zzly.set(i1, (List)zzmx.getValue(paramObject, l1), false);
        break;
      case 31: 
        j = zzly.append(i1, (List)zzmx.getValue(paramObject, l1), false);
        break;
      case 30: 
        j = zzly.put(i1, (List)zzmx.getValue(paramObject, l1), false);
        break;
      case 29: 
        j = zzly.valueOf(i1, (List)zzmx.getValue(paramObject, l1), false);
        break;
      case 28: 
        j = zzly.a(i1, (List)zzmx.getValue(paramObject, l1));
        break;
      case 27: 
        j = zzly.a(i1, (List)zzmx.getValue(paramObject, l1), toString(i2));
        break;
      case 26: 
        j = zzly.b(i1, (List)zzmx.getValue(paramObject, l1));
        break;
      case 25: 
        j = zzly.toString(i1, (List)zzmx.getValue(paramObject, l1), false);
        break;
      case 24: 
        j = zzly.append(i1, (List)zzmx.getValue(paramObject, l1), false);
        break;
      case 23: 
        j = zzly.set(i1, (List)zzmx.getValue(paramObject, l1), false);
        break;
      case 22: 
        j = zzly.get(i1, (List)zzmx.getValue(paramObject, l1), false);
        break;
      case 21: 
        j = zzly.elementAt(i1, (List)zzmx.getValue(paramObject, l1), false);
        break;
      case 20: 
        j = zzly.indexOf(i1, (List)zzmx.getValue(paramObject, l1), false);
        break;
      case 19: 
        j = zzly.append(i1, (List)zzmx.getValue(paramObject, l1), false);
        break;
      case 18: 
        j = zzly.set(i1, (List)zzmx.getValue(paramObject, l1), false);
      }
      for (;;)
      {
        j = i3 + j;
        break;
        j = i3;
        if (!a(paramObject, i2)) {
          break;
        }
        j = zzjl.b(i1, (zzll)zzmx.getValue(paramObject, l1), toString(i2));
        continue;
        j = i3;
        if (!a(paramObject, i2)) {
          break;
        }
        l1 = zzmx.toString(paramObject, l1);
        m = zzjl.append(i1 << 3);
        j = zzjl.get(l1 >> 63 ^ l1 + l1);
        break label2931;
        j = i3;
        if (!a(paramObject, i2)) {
          break;
        }
        j = zzmx.readInt(paramObject, l1);
        m = zzjl.append(i1 << 3);
        j = zzjl.append(j >> 31 ^ j + j);
        break label2931;
        j = i3;
        if (!a(paramObject, i2)) {
          break;
        }
        j = zzjl.append(i1 << 3);
        break label3075;
        j = i3;
        if (!a(paramObject, i2)) {
          break;
        }
        j = zzjl.append(i1 << 3);
        break label3047;
        j = i3;
        if (!a(paramObject, i2)) {
          break;
        }
        j = zzmx.readInt(paramObject, l1);
        m = zzjl.append(i1 << 3);
        j = zzjl.get(j);
        break label2931;
        j = i3;
        if (!a(paramObject, i2)) {
          break;
        }
        j = zzmx.readInt(paramObject, l1);
        m = zzjl.append(i1 << 3);
        j = zzjl.append(j);
        break label2931;
        j = i3;
        if (!a(paramObject, i2)) {
          break;
        }
        localObject2 = (zzjd)zzmx.getValue(paramObject, l1);
        j = zzjl.append(i1 << 3);
        m = ((zzjd)localObject2).size();
        i1 = m;
        for (m = zzjl.append(m);; m = zzjl.append(m))
        {
          j += m + i1;
          break label2935;
          j = i3;
          if (!a(paramObject, i2)) {
            break label3083;
          }
          j = zzly.a(i1, zzmx.getValue(paramObject, l1), toString(i2));
          break;
          j = i3;
          if (!a(paramObject, i2)) {
            break label3083;
          }
          localObject2 = zzmx.getValue(paramObject, l1);
          if (!(localObject2 instanceof zzjd)) {
            break label2798;
          }
          localObject2 = (zzjd)localObject2;
          j = zzjl.append(i1 << 3);
          m = ((zzjd)localObject2).size();
          i1 = m;
        }
        label2798:
        localObject2 = (String)localObject2;
        m = zzjl.append(i1 << 3);
        j = zzjl.a((String)localObject2);
        break label2931;
        j = i3;
        if (!a(paramObject, i2)) {
          break;
        }
        j = zzjl.append(i1 << 3);
        j += 1;
        continue;
        j = i3;
        if (!a(paramObject, i2)) {
          break;
        }
        j = zzjl.append(i1 << 3);
        break label3047;
        j = i3;
        if (!a(paramObject, i2)) {
          break;
        }
        j = zzjl.append(i1 << 3);
        break label3075;
        j = i3;
        if (!a(paramObject, i2)) {
          break;
        }
        j = zzmx.readInt(paramObject, l1);
        m = zzjl.append(i1 << 3);
        j = zzjl.get(j);
        label2931:
        j = m + j;
        label2935:
        j = i3 + j;
        break;
        j = i3;
        if (!a(paramObject, i2)) {
          break;
        }
        l1 = zzmx.toString(paramObject, l1);
        j = zzjl.append(i1 << 3);
        m = zzjl.get(l1);
        break label3016;
        j = i3;
        if (!a(paramObject, i2)) {
          break;
        }
        l1 = zzmx.toString(paramObject, l1);
        j = zzjl.append(i1 << 3);
        m = zzjl.get(l1);
        label3016:
        j = i3 + (j + m);
        break;
        j = i3;
        if (!a(paramObject, i2)) {
          break;
        }
        j = zzjl.append(i1 << 3);
        label3047:
        j += 4;
        continue;
        j = i3;
        if (!a(paramObject, i2)) {
          break;
        }
        j = zzjl.append(i1 << 3);
        label3075:
        j += 8;
      }
      label3083:
      i2 += 3;
    }
    localObject1 = x;
    return i3 + ((zzmn)localObject1).get(((zzmn)localObject1).getValue(paramObject));
  }
  
  private final int a(Object paramObject, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong, int paramInt8, zziq paramZziq)
    throws IOException
  {
    Unsafe localUnsafe = r;
    long l1 = i[(paramInt8 + 2)] & 0xFFFFF;
    switch (paramInt7)
    {
    default: 
      return paramInt1;
    case 68: 
      paramInt7 = paramInt1;
      if (paramInt5 == 3)
      {
        paramInt1 = zzir.a(toString(paramInt8), paramArrayOfByte, paramInt1, paramInt2, paramInt3 & 0xFFFFFFF8 | 0x4, paramZziq);
        if (localUnsafe.getInt(paramObject, l1) == paramInt4) {
          paramArrayOfByte = localUnsafe.getObject(paramObject, paramLong);
        } else {
          paramArrayOfByte = null;
        }
        if (paramArrayOfByte == null) {
          localUnsafe.putObject(paramObject, paramLong, c);
        } else {
          localUnsafe.putObject(paramObject, paramLong, zzkm.valueOf(paramArrayOfByte, c));
        }
        localUnsafe.putInt(paramObject, l1, paramInt4);
        return paramInt1;
      }
      break;
    case 67: 
      if (paramInt5 != 0) {
        return paramInt1;
      }
      paramInt1 = zzir.read(paramArrayOfByte, paramInt1, paramZziq);
      localUnsafe.putObject(paramObject, paramLong, Long.valueOf(zzjh.readLong(d)));
      localUnsafe.putInt(paramObject, l1, paramInt4);
      return paramInt1;
    case 66: 
      if (paramInt5 != 0) {
        return paramInt1;
      }
      paramInt1 = zzir.a(paramArrayOfByte, paramInt1, paramZziq);
      localUnsafe.putObject(paramObject, paramLong, Integer.valueOf(zzjh.a(a)));
      localUnsafe.putInt(paramObject, l1, paramInt4);
      return paramInt1;
    case 63: 
      paramInt7 = paramInt1;
      if (paramInt5 == 0)
      {
        paramInt1 = zzir.a(paramArrayOfByte, paramInt1, paramZziq);
        paramInt2 = a;
        paramArrayOfByte = a(paramInt8);
        if ((paramArrayOfByte != null) && (!paramArrayOfByte.b(paramInt2)))
        {
          f(paramObject).add(paramInt3, Long.valueOf(paramInt2));
          return paramInt1;
        }
        localUnsafe.putObject(paramObject, paramLong, Integer.valueOf(paramInt2));
        localUnsafe.putInt(paramObject, l1, paramInt4);
        return paramInt1;
      }
      break;
    case 61: 
      if (paramInt5 != 2) {
        return paramInt1;
      }
      paramInt1 = zzir.b(paramArrayOfByte, paramInt1, paramZziq);
      localUnsafe.putObject(paramObject, paramLong, c);
      localUnsafe.putInt(paramObject, l1, paramInt4);
      return paramInt1;
    case 60: 
      paramInt7 = paramInt1;
      if (paramInt5 == 2)
      {
        paramInt1 = zzir.a(toString(paramInt8), paramArrayOfByte, paramInt1, paramInt2, paramZziq);
        if (localUnsafe.getInt(paramObject, l1) == paramInt4) {
          paramArrayOfByte = localUnsafe.getObject(paramObject, paramLong);
        } else {
          paramArrayOfByte = null;
        }
        if (paramArrayOfByte == null) {
          localUnsafe.putObject(paramObject, paramLong, c);
        } else {
          localUnsafe.putObject(paramObject, paramLong, zzkm.valueOf(paramArrayOfByte, c));
        }
        localUnsafe.putInt(paramObject, l1, paramInt4);
        return paramInt1;
      }
      break;
    case 59: 
      paramInt7 = paramInt1;
      if (paramInt5 == 2)
      {
        paramInt2 = zzir.a(paramArrayOfByte, paramInt1, paramZziq);
        paramInt1 = paramInt2;
        paramInt3 = a;
        if (paramInt3 == 0)
        {
          localUnsafe.putObject(paramObject, paramLong, "");
        }
        else
        {
          if (((paramInt6 & 0x20000000) != 0) && (!zznc.b(paramArrayOfByte, paramInt2, paramInt2 + paramInt3))) {
            throw zzko.write();
          }
          localUnsafe.putObject(paramObject, paramLong, new String(paramArrayOfByte, paramInt2, paramInt3, zzkm.a));
          paramInt1 = paramInt2 + paramInt3;
        }
        localUnsafe.putInt(paramObject, l1, paramInt4);
        return paramInt1;
      }
      break;
    case 58: 
      paramInt7 = paramInt1;
      if (paramInt5 == 0)
      {
        paramInt1 = zzir.read(paramArrayOfByte, paramInt1, paramZziq);
        boolean bool;
        if (d != 0L) {
          bool = true;
        } else {
          bool = false;
        }
        localUnsafe.putObject(paramObject, paramLong, Boolean.valueOf(bool));
        localUnsafe.putInt(paramObject, l1, paramInt4);
        return paramInt1;
      }
      break;
    case 57: 
    case 64: 
      if (paramInt5 != 5) {
        return paramInt1;
      }
      localUnsafe.putObject(paramObject, paramLong, Integer.valueOf(zzir.readInt(paramArrayOfByte, paramInt1)));
      localUnsafe.putInt(paramObject, l1, paramInt4);
      return paramInt1 + 4;
    case 56: 
    case 65: 
      if (paramInt5 != 1) {
        return paramInt1;
      }
      localUnsafe.putObject(paramObject, paramLong, Long.valueOf(zzir.readLong(paramArrayOfByte, paramInt1)));
      localUnsafe.putInt(paramObject, l1, paramInt4);
      return paramInt1 + 8;
    case 55: 
    case 62: 
      if (paramInt5 != 0) {
        return paramInt1;
      }
      paramInt1 = zzir.a(paramArrayOfByte, paramInt1, paramZziq);
      localUnsafe.putObject(paramObject, paramLong, Integer.valueOf(a));
      localUnsafe.putInt(paramObject, l1, paramInt4);
      return paramInt1;
    case 53: 
    case 54: 
      if (paramInt5 != 0) {
        return paramInt1;
      }
      paramInt1 = zzir.read(paramArrayOfByte, paramInt1, paramZziq);
      localUnsafe.putObject(paramObject, paramLong, Long.valueOf(d));
      localUnsafe.putInt(paramObject, l1, paramInt4);
      return paramInt1;
    case 52: 
      if (paramInt5 != 5) {
        return paramInt1;
      }
      localUnsafe.putObject(paramObject, paramLong, Float.valueOf(Float.intBitsToFloat(zzir.readInt(paramArrayOfByte, paramInt1))));
      localUnsafe.putInt(paramObject, l1, paramInt4);
      return paramInt1 + 4;
    case 51: 
      if (paramInt5 != 1) {
        return paramInt1;
      }
      localUnsafe.putObject(paramObject, paramLong, Double.valueOf(Double.longBitsToDouble(zzir.readLong(paramArrayOfByte, paramInt1))));
      localUnsafe.putInt(paramObject, l1, paramInt4);
      paramInt7 = paramInt1 + 8;
    }
    return paramInt7;
  }
  
  private final int a(Object paramObject, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, int paramInt7, long paramLong2, zziq paramZziq)
    throws IOException
  {
    int j = paramInt1;
    Unsafe localUnsafe = r;
    zzkl localZzkl2 = (zzkl)localUnsafe.getObject(paramObject, paramLong2);
    zzkl localZzkl1 = localZzkl2;
    if (!localZzkl2.get())
    {
      int m = localZzkl2.size();
      if (m == 0) {
        m = 10;
      } else {
        m += m;
      }
      localZzkl2 = localZzkl2.trim(m);
      localZzkl1 = localZzkl2;
      localUnsafe.putObject(paramObject, paramLong2, localZzkl2);
    }
    switch (paramInt7)
    {
    default: 
      paramInt7 = paramInt1;
      if (paramInt5 != 3) {
        break label2551;
      }
      paramObject = toString(paramInt6);
      paramInt4 = paramInt3 & 0xFFFFFFF8 | 0x4;
      paramInt1 = zzir.a(paramObject, paramArrayOfByte, paramInt1, paramInt2, paramInt4, paramZziq);
      localZzkl1.add(c);
      break;
    case 34: 
    case 48: 
      if (paramInt5 == 2)
      {
        paramObject = (zzla)localZzkl1;
        paramInt2 = zzir.a(paramArrayOfByte, paramInt1, paramZziq);
        paramInt1 = paramInt2;
        paramInt2 = a + paramInt2;
        while (paramInt1 < paramInt2)
        {
          paramInt1 = zzir.read(paramArrayOfByte, paramInt1, paramZziq);
          paramObject.add(zzjh.readLong(d));
        }
        if (paramInt1 == paramInt2) {
          return paramInt1;
        }
        throw zzko.visitParameterAnnotation();
      }
      paramInt7 = paramInt1;
      if (paramInt5 != 0) {
        break label2551;
      }
      paramObject = (zzla)localZzkl1;
      paramInt1 = zzir.read(paramArrayOfByte, paramInt1, paramZziq);
      paramObject.add(zzjh.readLong(d));
      while (paramInt1 < paramInt2)
      {
        paramInt4 = zzir.a(paramArrayOfByte, paramInt1, paramZziq);
        if (paramInt3 != a) {
          return paramInt1;
        }
        paramInt1 = zzir.read(paramArrayOfByte, paramInt4, paramZziq);
        paramObject.add(zzjh.readLong(d));
      }
      return paramInt1;
    case 33: 
    case 47: 
      if (paramInt5 == 2)
      {
        paramObject = (zzkf)localZzkl1;
        paramInt2 = zzir.a(paramArrayOfByte, paramInt1, paramZziq);
        paramInt1 = paramInt2;
        paramInt2 = a + paramInt2;
        while (paramInt1 < paramInt2)
        {
          paramInt1 = zzir.a(paramArrayOfByte, paramInt1, paramZziq);
          paramObject.write(zzjh.a(a));
        }
        if (paramInt1 == paramInt2) {
          return paramInt1;
        }
        throw zzko.visitParameterAnnotation();
      }
      paramInt7 = paramInt1;
      if (paramInt5 != 0) {
        break label2551;
      }
      paramObject = (zzkf)localZzkl1;
      paramInt1 = zzir.a(paramArrayOfByte, paramInt1, paramZziq);
      paramObject.write(zzjh.a(a));
      while (paramInt1 < paramInt2)
      {
        paramInt4 = zzir.a(paramArrayOfByte, paramInt1, paramZziq);
        if (paramInt3 != a) {
          return paramInt1;
        }
        paramInt1 = zzir.a(paramArrayOfByte, paramInt4, paramZziq);
        paramObject.write(zzjh.a(a));
      }
      return paramInt1;
    case 30: 
    case 44: 
      if (paramInt5 == 2)
      {
        paramInt1 = zzir.b(paramArrayOfByte, paramInt1, localZzkl1, paramZziq);
      }
      else
      {
        paramInt7 = paramInt1;
        if (paramInt5 != 0) {
          break label2551;
        }
        paramInt1 = zzir.b(paramInt3, paramArrayOfByte, paramInt1, paramInt2, localZzkl1, paramZziq);
      }
      paramZziq = (zzke)paramObject;
      paramArrayOfByte = f;
      paramObject = paramArrayOfByte;
      if (paramArrayOfByte == zzmo.e()) {
        paramObject = null;
      }
      paramObject = zzly.a(paramInt4, localZzkl1, a(paramInt6), paramObject, x);
      if (paramObject == null) {
        return paramInt1;
      }
      f = ((zzmo)paramObject);
      return paramInt1;
    case 28: 
      paramInt7 = paramInt1;
      if (paramInt5 != 2) {
        break label2551;
      }
      paramInt4 = zzir.a(paramArrayOfByte, paramInt1, paramZziq);
      paramInt1 = paramInt4;
      paramInt5 = a;
      if (paramInt5 >= 0)
      {
        if (paramInt5 <= paramArrayOfByte.length - paramInt4)
        {
          if (paramInt5 == 0)
          {
            localZzkl1.add(zzjd.a);
          }
          else
          {
            localZzkl1.add(zzjd.a(paramArrayOfByte, paramInt4, paramInt5));
            paramInt4 = paramInt5;
          }
          for (;;)
          {
            paramInt1 += paramInt4;
            for (;;)
            {
              paramInt7 = paramInt1;
              if (paramInt1 >= paramInt2) {
                break label2551;
              }
              paramInt4 = zzir.a(paramArrayOfByte, paramInt1, paramZziq);
              if (paramInt3 != a) {
                return paramInt1;
              }
              paramInt5 = zzir.a(paramArrayOfByte, paramInt4, paramZziq);
              paramInt1 = paramInt5;
              paramInt4 = a;
              if (paramInt4 < 0) {
                break label1023;
              }
              if (paramInt4 > paramArrayOfByte.length - paramInt5) {
                break label1019;
              }
              if (paramInt4 != 0) {
                break;
              }
              localZzkl1.add(zzjd.a);
            }
            localZzkl1.add(zzjd.a(paramArrayOfByte, paramInt5, paramInt4));
          }
          throw zzko.visitParameterAnnotation();
          throw zzko.g();
        }
        throw zzko.visitParameterAnnotation();
      }
      throw zzko.g();
    case 27: 
      if (paramInt5 != 2) {
        return paramInt1;
      }
      return zzir.a(toString(paramInt6), paramInt3, paramArrayOfByte, paramInt1, paramInt2, localZzkl1, paramZziq);
    case 26: 
      paramInt7 = paramInt1;
      if (paramInt5 != 2) {
        break label2551;
      }
      if ((paramLong1 & 0x20000000) == 0L)
      {
        paramInt4 = zzir.a(paramArrayOfByte, paramInt1, paramZziq);
        paramInt1 = paramInt4;
        paramInt5 = a;
        if (paramInt5 >= 0)
        {
          if (paramInt5 == 0)
          {
            localZzkl1.add("");
          }
          else
          {
            localZzkl1.add(new String(paramArrayOfByte, paramInt4, paramInt5, zzkm.a));
            paramInt4 = paramInt5;
          }
          for (;;)
          {
            paramInt1 += paramInt4;
            for (;;)
            {
              paramInt7 = paramInt1;
              if (paramInt1 >= paramInt2) {
                break label2551;
              }
              paramInt4 = zzir.a(paramArrayOfByte, paramInt1, paramZziq);
              paramInt7 = paramInt1;
              if (paramInt3 != a) {
                break label2551;
              }
              paramInt5 = zzir.a(paramArrayOfByte, paramInt4, paramZziq);
              paramInt1 = paramInt5;
              paramInt4 = a;
              if (paramInt4 < 0) {
                break label1259;
              }
              if (paramInt4 != 0) {
                break;
              }
              localZzkl1.add("");
            }
            localZzkl1.add(new String(paramArrayOfByte, paramInt5, paramInt4, zzkm.a));
          }
          throw zzko.g();
        }
        throw zzko.g();
      }
      paramInt4 = zzir.a(paramArrayOfByte, paramInt1, paramZziq);
      paramInt1 = paramInt4;
      paramInt5 = a;
      if (paramInt5 >= 0)
      {
        if (paramInt5 == 0)
        {
          localZzkl1.add("");
        }
        else
        {
          paramInt1 = paramInt4 + paramInt5;
          if (!zznc.b(paramArrayOfByte, paramInt4, paramInt1)) {
            break label1474;
          }
          localZzkl1.add(new String(paramArrayOfByte, paramInt4, paramInt5, zzkm.a));
        }
        for (;;)
        {
          paramInt7 = paramInt1;
          if (paramInt1 >= paramInt2) {
            break label2551;
          }
          paramInt4 = zzir.a(paramArrayOfByte, paramInt1, paramZziq);
          paramInt7 = paramInt1;
          if (paramInt3 != a) {
            break label2551;
          }
          paramInt4 = zzir.a(paramArrayOfByte, paramInt4, paramZziq);
          paramInt1 = paramInt4;
          paramInt5 = a;
          if (paramInt5 < 0) {
            break label1470;
          }
          if (paramInt5 == 0)
          {
            localZzkl1.add("");
          }
          else
          {
            paramInt1 = paramInt4 + paramInt5;
            if (!zznc.b(paramArrayOfByte, paramInt4, paramInt1)) {
              break;
            }
            localZzkl1.add(new String(paramArrayOfByte, paramInt4, paramInt5, zzkm.a));
          }
        }
        throw zzko.write();
        throw zzko.g();
        throw zzko.write();
      }
      throw zzko.g();
    case 25: 
    case 42: 
      boolean bool;
      if (paramInt5 == 2)
      {
        paramObject = (zzis)localZzkl1;
        paramInt2 = zzir.a(paramArrayOfByte, paramInt1, paramZziq);
        paramInt1 = paramInt2;
        paramInt2 = a + paramInt2;
        while (paramInt1 < paramInt2)
        {
          paramInt1 = zzir.read(paramArrayOfByte, paramInt1, paramZziq);
          if (d != 0L) {
            bool = true;
          } else {
            bool = false;
          }
          paramObject.add(bool);
        }
        if (paramInt1 == paramInt2) {
          return paramInt1;
        }
        throw zzko.visitParameterAnnotation();
      }
      paramInt7 = paramInt1;
      if (paramInt5 != 0) {
        break label2551;
      }
      paramObject = (zzis)localZzkl1;
      paramInt1 = zzir.read(paramArrayOfByte, paramInt1, paramZziq);
      if (d != 0L) {
        bool = true;
      } else {
        bool = false;
      }
      paramObject.add(bool);
      while (paramInt1 < paramInt2)
      {
        paramInt4 = zzir.a(paramArrayOfByte, paramInt1, paramZziq);
        if (paramInt3 != a) {
          return paramInt1;
        }
        paramInt1 = zzir.read(paramArrayOfByte, paramInt4, paramZziq);
        if (d != 0L) {
          bool = true;
        } else {
          bool = false;
        }
        paramObject.add(bool);
      }
      return paramInt1;
    case 24: 
    case 31: 
    case 41: 
    case 45: 
      if (paramInt5 == 2)
      {
        paramObject = (zzkf)localZzkl1;
        paramInt2 = zzir.a(paramArrayOfByte, paramInt1, paramZziq);
        paramInt1 = paramInt2;
        paramInt2 = a + paramInt2;
        while (paramInt1 < paramInt2)
        {
          paramObject.write(zzir.readInt(paramArrayOfByte, paramInt1));
          paramInt1 += 4;
        }
        if (paramInt1 == paramInt2) {
          return paramInt1;
        }
        throw zzko.visitParameterAnnotation();
      }
      paramInt7 = paramInt1;
      if (paramInt5 != 5) {
        break label2551;
      }
      paramObject = (zzkf)localZzkl1;
      paramObject.write(zzir.readInt(paramArrayOfByte, paramInt1));
      paramInt1 = j;
      for (;;)
      {
        paramInt5 = paramInt1 + 4;
        if (paramInt5 >= paramInt2) {
          break;
        }
        paramInt4 = zzir.a(paramArrayOfByte, paramInt5, paramZziq);
        paramInt1 = paramInt4;
        if (paramInt3 != a) {
          return paramInt5;
        }
        paramObject.write(zzir.readInt(paramArrayOfByte, paramInt4));
      }
      return paramInt5;
    case 23: 
    case 32: 
    case 40: 
    case 46: 
      if (paramInt5 == 2)
      {
        paramObject = (zzla)localZzkl1;
        paramInt2 = zzir.a(paramArrayOfByte, paramInt1, paramZziq);
        paramInt1 = paramInt2;
        paramInt2 = a + paramInt2;
        while (paramInt1 < paramInt2)
        {
          paramObject.add(zzir.readLong(paramArrayOfByte, paramInt1));
          paramInt1 += 8;
        }
        if (paramInt1 == paramInt2) {
          return paramInt1;
        }
        throw zzko.visitParameterAnnotation();
      }
      paramInt7 = paramInt1;
      if (paramInt5 != 1) {
        break label2551;
      }
      paramObject = (zzla)localZzkl1;
      paramObject.add(zzir.readLong(paramArrayOfByte, paramInt1));
      paramInt1 = j;
      for (;;)
      {
        paramInt5 = paramInt1 + 8;
        if (paramInt5 >= paramInt2) {
          break;
        }
        paramInt4 = zzir.a(paramArrayOfByte, paramInt5, paramZziq);
        paramInt1 = paramInt4;
        if (paramInt3 != a) {
          return paramInt5;
        }
        paramObject.add(zzir.readLong(paramArrayOfByte, paramInt4));
      }
      return paramInt5;
    case 22: 
    case 29: 
    case 39: 
    case 43: 
      if (paramInt5 == 2) {
        return zzir.b(paramArrayOfByte, paramInt1, localZzkl1, paramZziq);
      }
      if (paramInt5 != 0) {
        return paramInt1;
      }
      return zzir.b(paramInt3, paramArrayOfByte, paramInt1, paramInt2, localZzkl1, paramZziq);
    case 20: 
    case 21: 
    case 37: 
    case 38: 
      if (paramInt5 == 2)
      {
        paramObject = (zzla)localZzkl1;
        paramInt2 = zzir.a(paramArrayOfByte, paramInt1, paramZziq);
        paramInt1 = paramInt2;
        paramInt2 = a + paramInt2;
        while (paramInt1 < paramInt2)
        {
          paramInt1 = zzir.read(paramArrayOfByte, paramInt1, paramZziq);
          paramObject.add(d);
        }
        if (paramInt1 == paramInt2) {
          return paramInt1;
        }
        throw zzko.visitParameterAnnotation();
      }
      paramInt7 = paramInt1;
      if (paramInt5 != 0) {
        break label2551;
      }
      paramObject = (zzla)localZzkl1;
      paramInt1 = zzir.read(paramArrayOfByte, paramInt1, paramZziq);
      paramObject.add(d);
      while (paramInt1 < paramInt2)
      {
        paramInt4 = zzir.a(paramArrayOfByte, paramInt1, paramZziq);
        if (paramInt3 != a) {
          return paramInt1;
        }
        paramInt1 = zzir.read(paramArrayOfByte, paramInt4, paramZziq);
        paramObject.add(d);
      }
      return paramInt1;
    case 19: 
    case 36: 
      if (paramInt5 == 2)
      {
        paramObject = (zzjx)localZzkl1;
        paramInt2 = zzir.a(paramArrayOfByte, paramInt1, paramZziq);
        paramInt1 = paramInt2;
        paramInt2 = a + paramInt2;
        while (paramInt1 < paramInt2)
        {
          paramObject.set(Float.intBitsToFloat(zzir.readInt(paramArrayOfByte, paramInt1)));
          paramInt1 += 4;
        }
        if (paramInt1 == paramInt2) {
          return paramInt1;
        }
        throw zzko.visitParameterAnnotation();
      }
      paramInt7 = paramInt1;
      if (paramInt5 != 5) {
        break label2551;
      }
      paramObject = (zzjx)localZzkl1;
      paramObject.set(Float.intBitsToFloat(zzir.readInt(paramArrayOfByte, paramInt1)));
      paramInt1 = j;
      for (;;)
      {
        paramInt5 = paramInt1 + 4;
        if (paramInt5 >= paramInt2) {
          break;
        }
        paramInt4 = zzir.a(paramArrayOfByte, paramInt5, paramZziq);
        paramInt1 = paramInt4;
        if (paramInt3 != a) {
          return paramInt5;
        }
        paramObject.set(Float.intBitsToFloat(zzir.readInt(paramArrayOfByte, paramInt4)));
      }
      return paramInt5;
    case 18: 
    case 35: 
      label1019:
      label1023:
      label1259:
      label1470:
      label1474:
      if (paramInt5 == 2)
      {
        paramObject = (zzjn)localZzkl1;
        paramInt2 = zzir.a(paramArrayOfByte, paramInt1, paramZziq);
        paramInt1 = paramInt2;
        paramInt2 = a + paramInt2;
        while (paramInt1 < paramInt2)
        {
          paramObject.set(Double.longBitsToDouble(zzir.readLong(paramArrayOfByte, paramInt1)));
          paramInt1 += 8;
        }
        if (paramInt1 == paramInt2) {
          return paramInt1;
        }
        throw zzko.visitParameterAnnotation();
      }
      paramInt7 = paramInt1;
      if (paramInt5 != 1) {
        break label2551;
      }
      paramObject = (zzjn)localZzkl1;
      paramObject.set(Double.longBitsToDouble(zzir.readLong(paramArrayOfByte, paramInt1)));
      paramInt1 = j;
      for (;;)
      {
        paramInt5 = paramInt1 + 8;
        if (paramInt5 >= paramInt2) {
          break;
        }
        paramInt4 = zzir.a(paramArrayOfByte, paramInt5, paramZziq);
        paramInt1 = paramInt4;
        if (paramInt3 != a) {
          return paramInt5;
        }
        paramObject.set(Double.longBitsToDouble(zzir.readLong(paramArrayOfByte, paramInt4)));
      }
      return paramInt5;
    }
    for (;;)
    {
      paramInt7 = paramInt1;
      if (paramInt1 >= paramInt2) {
        break;
      }
      paramInt5 = zzir.a(paramArrayOfByte, paramInt1, paramZziq);
      if (paramInt3 != a) {
        return paramInt1;
      }
      paramInt1 = zzir.a(paramObject, paramArrayOfByte, paramInt5, paramInt2, paramInt4, paramZziq);
      localZzkl1.add(c);
    }
    label2551:
    return paramInt7;
  }
  
  private final int a(Object paramObject, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong, zziq paramZziq)
    throws IOException
  {
    paramArrayOfByte = r;
    paramZziq = get(paramInt3);
    Object localObject = paramArrayOfByte.getObject(paramObject, paramLong);
    if (!((zzlf)localObject).a())
    {
      zzlf localZzlf = zzlf.isExact().getValue();
      zzlg.set(localZzlf, localObject);
      paramArrayOfByte.putObject(paramObject, paramLong, localZzlf);
    }
    paramObject = (zzle)paramZziq;
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  private final int a(Object paramObject, byte[] paramArrayOfByte, int paramInt1, int paramInt2, zziq paramZziq)
    throws IOException
  {
    Object localObject1 = r;
    int i3 = -1;
    int i1 = paramInt1;
    int m = 1048575;
    int j = -1;
    int i4 = 0;
    paramInt1 = 0;
    for (;;)
    {
      Object localObject4 = paramZziq;
      int i6 = paramInt2;
      byte[] arrayOfByte = paramArrayOfByte;
      Object localObject3 = paramObject;
      zzlo localZzlo = this;
      if (i1 >= i6) {
        break;
      }
      int i2 = i1 + 1;
      int i5 = arrayOfByte[i1];
      if (i5 < 0)
      {
        i1 = zzir.a(i5, arrayOfByte, i2, (zziq)localObject4);
        i5 = a;
      }
      else
      {
        i1 = i2;
      }
      i2 = i5 >>> 3;
      int i9 = i5 & 0x7;
      if (i2 > j) {
        j = localZzlo.b(i2, i4 / 3);
      } else {
        j = localZzlo.d(i2);
      }
      if (j == i3)
      {
        i4 = 0;
        j = i3;
        i3 = m;
        m = i4;
      }
      else
      {
        Object localObject2 = i;
        int i10 = localObject2[(j + 1)];
        int i11 = b(i10);
        long l1 = i10 & 0xFFFFF;
        int i7;
        if (i11 <= 17)
        {
          i3 = localObject2[(j + 2)];
          int i8 = 1 << (i3 >>> 20);
          i7 = i3 & 0xFFFFF;
          localObject2 = localObject1;
          i3 = m;
          i4 = paramInt1;
          if (i7 != m)
          {
            if (m != 1048575) {
              ((Unsafe)localObject1).putInt(localObject3, m, paramInt1);
            }
            if (i7 != 1048575) {
              paramInt1 = ((Unsafe)localObject1).getInt(localObject3, i7);
            }
            i3 = i7;
            localObject2 = localObject1;
            i4 = paramInt1;
          }
          switch (i11)
          {
          default: 
            break;
          }
          for (;;)
          {
            break;
            if (i9 == 0)
            {
              paramInt1 = zzir.read(arrayOfByte, i1, (zziq)localObject4);
              ((Unsafe)localObject2).putLong(paramObject, l1, zzjh.readLong(d));
              m = i4 | i8;
            }
            else
            {
              break;
              if (i9 != 0) {
                continue;
              }
              paramInt1 = zzir.a(arrayOfByte, i1, (zziq)localObject4);
              ((Unsafe)localObject2).putInt(localObject3, l1, zzjh.a(a));
              break label965;
              if (i9 != 0) {
                continue;
              }
              paramInt1 = zzir.a(arrayOfByte, i1, (zziq)localObject4);
              ((Unsafe)localObject2).putInt(localObject3, l1, a);
              break label965;
              if (i9 != 2) {
                continue;
              }
              paramInt1 = zzir.b(arrayOfByte, i1, (zziq)localObject4);
              ((Unsafe)localObject2).putObject(localObject3, l1, c);
              break label965;
              if (i9 != 2) {
                continue;
              }
              paramInt1 = zzir.a(localZzlo.toString(j), arrayOfByte, i1, i6, (zziq)localObject4);
              localObject1 = ((Unsafe)localObject2).getObject(localObject3, l1);
              if (localObject1 == null)
              {
                ((Unsafe)localObject2).putObject(localObject3, l1, c);
              }
              else
              {
                ((Unsafe)localObject2).putObject(localObject3, l1, zzkm.valueOf(localObject1, c));
                break label965;
                if (i9 != 2) {
                  continue;
                }
                if ((i10 & 0x20000000) == 0) {
                  paramInt1 = zzir.d(arrayOfByte, i1, (zziq)localObject4);
                } else {
                  paramInt1 = zzir.c(arrayOfByte, i1, (zziq)localObject4);
                }
                ((Unsafe)localObject2).putObject(localObject3, l1, c);
                break label965;
                if (i9 != 0) {
                  continue;
                }
                paramInt1 = zzir.read(arrayOfByte, i1, (zziq)localObject4);
                boolean bool;
                if (d != 0L) {
                  bool = true;
                } else {
                  bool = false;
                }
                zzmx.a(localObject3, l1, bool);
                break label965;
                if (i9 != 5) {
                  continue;
                }
                ((Unsafe)localObject2).putInt(localObject3, l1, zzir.readInt(arrayOfByte, i1));
                paramInt1 = i1 + 4;
                break label965;
                if (i9 != 1) {
                  continue;
                }
                ((Unsafe)localObject2).putLong(paramObject, l1, zzir.readLong(arrayOfByte, i1));
                paramInt1 = i1 + 8;
                break label965;
                if (i9 != 0) {
                  break;
                }
                paramInt1 = zzir.a(arrayOfByte, i1, (zziq)localObject4);
                ((Unsafe)localObject2).putInt(localObject3, l1, a);
                break label965;
                if (i9 != 0) {
                  break;
                }
                paramInt1 = zzir.read(arrayOfByte, i1, (zziq)localObject4);
                ((Unsafe)localObject2).putLong(paramObject, l1, d);
                m = i4 | i8;
                break label972;
                if (i9 != 5) {
                  break;
                }
                zzmx.a(localObject3, l1, Float.intBitsToFloat(zzir.readInt(arrayOfByte, i1)));
                paramInt1 = i1 + 4;
                break label965;
                if (i9 != 1) {
                  break;
                }
                zzmx.a(localObject3, l1, Double.longBitsToDouble(zzir.readLong(arrayOfByte, i1)));
                paramInt1 = i1 + 8;
              }
              label965:
              m = i4 | i8;
            }
            label972:
            i4 = i2;
            localObject1 = localObject2;
            i1 = paramInt1;
            i2 = i3;
            paramInt1 = i4;
            i4 = j;
            i5 = m;
            break label1150;
          }
          localObject1 = localObject2;
          m = j;
          j = -1;
          paramInt1 = i4;
        }
        else
        {
          i4 = j;
          if (i11 == 27)
          {
            if (i9 == 2)
            {
              localObject4 = (zzkl)((Unsafe)localObject1).getObject(localObject3, l1);
              localObject2 = localObject4;
              if (!((zzkl)localObject4).get())
              {
                j = ((List)localObject4).size();
                if (j == 0) {
                  j = 10;
                } else {
                  j += j;
                }
                localObject4 = ((zzkl)localObject4).trim(j);
                localObject2 = localObject4;
                ((Unsafe)localObject1).putObject(localObject3, l1, localObject4);
              }
              i1 = zzir.a(localZzlo.toString(i4), i5, paramArrayOfByte, i1, paramInt2, (zzkl)localObject2, paramZziq);
              i5 = paramInt1;
              paramInt1 = i2;
              i2 = m;
              label1150:
              i3 = -1;
              m = i2;
              j = paramInt1;
              paramInt1 = i5;
              continue;
            }
            i3 = i1;
          }
          else
          {
            i6 = j;
            if (i11 <= 49)
            {
              i7 = a(paramObject, paramArrayOfByte, i1, paramInt2, i5, i2, i9, j, i10, i11, l1, paramZziq);
              i4 = i7;
              i3 = i4;
              if (i7 != i1) {
                j = i4;
              }
            }
          }
          for (;;)
          {
            i3 = -1;
            i1 = j;
            i4 = i6;
            break label1408;
            label1306:
            label1328:
            do
            {
              for (;;)
              {
                break label1306;
                i3 = i1;
                if (i11 != 50) {
                  break label1328;
                }
                if (i9 == 2)
                {
                  i7 = a(paramObject, paramArrayOfByte, i1, paramInt2, j, l1, paramZziq);
                  i4 = i7;
                  i3 = i4;
                  if (i7 != i1)
                  {
                    j = i4;
                    break;
                  }
                }
              }
              i4 = j;
              j = -1;
              i1 = i3;
              i3 = m;
              m = i4;
              break label1378;
              i7 = a(paramObject, paramArrayOfByte, i1, paramInt2, i5, i2, i9, i10, i11, l1, j, paramZziq);
              i4 = i7;
              i3 = i4;
            } while (i7 == i1);
            j = i4;
          }
        }
      }
      label1378:
      i1 = zzir.a(i5, paramArrayOfByte, i1, paramInt2, f(paramObject), paramZziq);
      i4 = m;
      m = i3;
      i3 = j;
      label1408:
      j = i2;
    }
    if (m != 1048575) {
      ((Unsafe)localObject1).putInt(paramObject, m, paramInt1);
    }
    if (i1 == paramInt2) {
      return i1;
    }
    throw zzko.getSort();
  }
  
  private final zzki a(int paramInt)
  {
    paramInt /= 3;
    return (zzki)a[(paramInt + paramInt + 1)];
  }
  
  private final void a(Object paramObject, int paramInt1, int paramInt2)
  {
    zzmx.a(paramObject, c(paramInt2) & 0xFFFFF, paramInt1);
  }
  
  private final void a(Object paramObject1, Object paramObject2, int paramInt)
  {
    int j = charAt(paramInt);
    int m = i[paramInt];
    long l1 = j & 0xFFFFF;
    if (!get(paramObject2, m, paramInt)) {
      return;
    }
    Object localObject;
    if (get(paramObject1, m, paramInt)) {
      localObject = zzmx.getValue(paramObject1, l1);
    } else {
      localObject = null;
    }
    paramObject2 = zzmx.getValue(paramObject2, l1);
    if ((localObject != null) && (paramObject2 != null))
    {
      zzmx.add(paramObject1, l1, zzkm.valueOf(localObject, paramObject2));
      a(paramObject1, m, paramInt);
      return;
    }
    if (paramObject2 != null)
    {
      zzmx.add(paramObject1, l1, paramObject2);
      a(paramObject1, m, paramInt);
    }
  }
  
  private final boolean a(Object paramObject, int paramInt)
  {
    int j = c(paramInt);
    long l1 = j & 0xFFFFF;
    if (l1 == 1048575L)
    {
      paramInt = charAt(paramInt);
      l1 = paramInt & 0xFFFFF;
      switch (b(paramInt))
      {
      default: 
        throw new IllegalArgumentException();
      case 17: 
        return zzmx.getValue(paramObject, l1) != null;
      case 16: 
        return zzmx.toString(paramObject, l1) != 0L;
      case 15: 
        return zzmx.readInt(paramObject, l1) != 0;
      case 14: 
        return zzmx.toString(paramObject, l1) != 0L;
      case 13: 
        return zzmx.readInt(paramObject, l1) != 0;
      case 12: 
        return zzmx.readInt(paramObject, l1) != 0;
      case 11: 
        return zzmx.readInt(paramObject, l1) != 0;
      case 10: 
        return !zzjd.a.equals(zzmx.getValue(paramObject, l1));
      case 9: 
        return zzmx.getValue(paramObject, l1) != null;
      case 8: 
        paramObject = zzmx.getValue(paramObject, l1);
        if ((paramObject instanceof String)) {
          return !((String)paramObject).isEmpty();
        }
        if ((paramObject instanceof zzjd)) {
          return !zzjd.a.equals(paramObject);
        }
        throw new IllegalArgumentException();
      case 7: 
        return zzmx.c(paramObject, l1);
      case 6: 
        return zzmx.readInt(paramObject, l1) != 0;
      case 5: 
        return zzmx.toString(paramObject, l1) != 0L;
      case 4: 
        return zzmx.readInt(paramObject, l1) != 0;
      case 3: 
        return zzmx.toString(paramObject, l1) != 0L;
      case 2: 
        return zzmx.toString(paramObject, l1) != 0L;
      case 1: 
        return Float.floatToRawIntBits(zzmx.e(paramObject, l1)) != 0;
      }
      return Double.doubleToRawLongBits(zzmx.d(paramObject, l1)) != 0L;
    }
    return (zzmx.readInt(paramObject, l1) & 1 << (j >>> 20)) != 0;
  }
  
  private final boolean add(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 == 1048575) {
      return a(paramObject, paramInt1);
    }
    return (paramInt3 & paramInt4) != 0;
  }
  
  private static int b(int paramInt)
  {
    return paramInt >>> 20 & 0xFF;
  }
  
  private final int b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= k) && (paramInt1 <= o)) {
      return a(paramInt1, paramInt2);
    }
    return -1;
  }
  
  private final void b(Object paramObject, int paramInt)
  {
    paramInt = c(paramInt);
    long l1 = 0xFFFFF & paramInt;
    if (l1 == 1048575L) {
      return;
    }
    zzmx.a(paramObject, l1, 1 << (paramInt >>> 20) | zzmx.readInt(paramObject, l1));
  }
  
  private final int c(int paramInt)
  {
    return i[(paramInt + 2)];
  }
  
  private final int charAt(int paramInt)
  {
    return i[(paramInt + 1)];
  }
  
  private final int d(int paramInt)
  {
    if ((paramInt >= k) && (paramInt <= o)) {
      return a(paramInt, 0);
    }
    return -1;
  }
  
  static zzmo f(Object paramObject)
  {
    zzke localZzke = (zzke)paramObject;
    zzmo localZzmo = f;
    paramObject = localZzmo;
    if (localZzmo == zzmo.e())
    {
      paramObject = zzmo.a();
      f = paramObject;
    }
    return paramObject;
  }
  
  private final boolean f(Object paramObject1, Object paramObject2, int paramInt)
  {
    return a(paramObject1, paramInt) == a(paramObject2, paramInt);
  }
  
  private static long get(Object paramObject, long paramLong)
  {
    return ((Long)zzmx.getValue(paramObject, paramLong)).longValue();
  }
  
  private final Object get(int paramInt)
  {
    paramInt /= 3;
    return a[(paramInt + paramInt)];
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
      int m;
      int j;
      Object localObject2;
      for (;;) {}
    }
    localObject1 = paramClass.getDeclaredFields();
    m = localObject1.length;
    j = 0;
    while (j < m)
    {
      localObject2 = localObject1[j];
      if (paramString.equals(((Field)localObject2).getName())) {
        return localObject2;
      }
      j += 1;
    }
    paramClass = paramClass.getName();
    localObject1 = Arrays.toString((Object[])localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Field ");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(" for ");
    ((StringBuilder)localObject2).append(paramClass);
    ((StringBuilder)localObject2).append(" not found. Known fields are ");
    ((StringBuilder)localObject2).append((String)localObject1);
    throw new RuntimeException(((StringBuilder)localObject2).toString());
  }
  
  private final boolean get(Object paramObject, int paramInt1, int paramInt2)
  {
    return zzmx.readInt(paramObject, c(paramInt2) & 0xFFFFF) == paramInt1;
  }
  
  private static int getValue(Object paramObject, long paramLong)
  {
    return ((Integer)zzmx.getValue(paramObject, paramLong)).intValue();
  }
  
  static zzlo invoke(Class paramClass, zzli paramZzli, zzlq paramZzlq, zzkz paramZzkz, zzmn paramZzmn, zzjr paramZzjr, zzlg paramZzlg)
  {
    if ((paramZzli instanceof zzlv)) {
      return load((zzlv)paramZzli, paramZzlq, paramZzkz, paramZzmn, paramZzjr, paramZzlg);
    }
    paramClass = (zzmk)paramZzli;
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  static zzlo load(zzlv paramZzlv, zzlq paramZzlq, zzkz paramZzkz, zzmn paramZzmn, zzjr paramZzjr, zzlg paramZzlg)
  {
    boolean bool;
    if (paramZzlv.get() == 2) {
      bool = true;
    } else {
      bool = false;
    }
    String str = paramZzlv.append();
    int i10 = str.length();
    if (str.charAt(0) >= 55296) {
      for (j = 1;; j = i1)
      {
        i1 = j + 1;
        m = i1;
        if (str.charAt(j) < 55296) {
          break;
        }
      }
    }
    int m = 1;
    int j = m + 1;
    int i1 = str.charAt(m);
    m = i1;
    int i2 = j;
    if (i1 >= 55296)
    {
      i1 &= 0x1FFF;
      m = 13;
      for (i2 = j;; i2 = j)
      {
        j = i2 + 1;
        i2 = str.charAt(i2);
        if (i2 < 55296) {
          break;
        }
        i1 |= (i2 & 0x1FFF) << m;
        m += 13;
      }
      m = i1 | i2 << m;
      i2 = j;
    }
    int i7;
    int i3;
    int i4;
    int[] arrayOfInt1;
    int i6;
    if (m == 0)
    {
      i7 = 0;
      i1 = 0;
      i5 = 0;
      i3 = 0;
      m = 0;
      i4 = 0;
      arrayOfInt1 = v;
      i6 = 0;
    }
    else
    {
      m = i2 + 1;
      i2 = str.charAt(i2);
      j = i2;
      i1 = m;
      if (i2 >= 55296)
      {
        i1 = i2 & 0x1FFF;
        j = 13;
        for (i2 = m;; i2 = m)
        {
          m = i2 + 1;
          i2 = str.charAt(i2);
          if (i2 < 55296) {
            break;
          }
          i1 |= (i2 & 0x1FFF) << j;
          j += 13;
        }
        j = i1 | i2 << j;
        i1 = m;
      }
      m = i1 + 1;
      i2 = str.charAt(i1);
      i6 = i2;
      i1 = m;
      if (i2 >= 55296)
      {
        i2 &= 0x1FFF;
        i1 = 13;
        for (i3 = m;; i3 = m)
        {
          m = i3 + 1;
          i3 = str.charAt(i3);
          if (i3 < 55296) {
            break;
          }
          i2 |= (i3 & 0x1FFF) << i1;
          i1 += 13;
        }
        i6 = i2 | i3 << i1;
        i1 = m;
      }
      m = i1 + 1;
      i2 = str.charAt(i1);
      i1 = i2;
      i3 = m;
      if (i2 >= 55296)
      {
        i2 &= 0x1FFF;
        i1 = 13;
        for (i3 = m;; i3 = m)
        {
          m = i3 + 1;
          i3 = str.charAt(i3);
          if (i3 < 55296) {
            break;
          }
          i2 |= (i3 & 0x1FFF) << i1;
          i1 += 13;
        }
        i1 = i2 | i3 << i1;
        i3 = m;
      }
      i2 = i3 + 1;
      i3 = str.charAt(i3);
      m = i3;
      i4 = i2;
      if (i3 >= 55296)
      {
        i3 &= 0x1FFF;
        m = 13;
        for (i4 = i2;; i4 = i2)
        {
          i2 = i4 + 1;
          i4 = str.charAt(i4);
          if (i4 < 55296) {
            break;
          }
          i3 |= (i4 & 0x1FFF) << m;
          m += 13;
        }
        m = i3 | i4 << m;
        i4 = i2;
      }
      i3 = i4 + 1;
      i4 = str.charAt(i4);
      i2 = i4;
      i5 = i3;
      if (i4 >= 55296)
      {
        i4 &= 0x1FFF;
        i2 = 13;
        for (i5 = i3;; i5 = i3)
        {
          i3 = i5 + 1;
          i5 = str.charAt(i5);
          if (i5 < 55296) {
            break;
          }
          i4 |= (i5 & 0x1FFF) << i2;
          i2 += 13;
        }
        i2 = i4 | i5 << i2;
        i5 = i3;
      }
      i4 = i5 + 1;
      i7 = str.charAt(i5);
      i3 = i7;
      i5 = i4;
      if (i7 >= 55296)
      {
        i5 = i7 & 0x1FFF;
        i3 = 13;
        i7 = i4;
        i4 = i3;
        for (;;)
        {
          i3 = i7 + 1;
          i7 = str.charAt(i7);
          if (i7 < 55296) {
            break;
          }
          i5 |= (i7 & 0x1FFF) << i4;
          i4 += 13;
          i7 = i3;
        }
        i4 = i5 | i7 << i4;
        i5 = i3;
        i3 = i4;
      }
      i4 = i5 + 1;
      i8 = str.charAt(i5);
      i7 = i8;
      i5 = i4;
      if (i8 >= 55296)
      {
        i7 = i8 & 0x1FFF;
        i5 = 13;
        for (i8 = i4;; i8 = i4)
        {
          i4 = i8 + 1;
          i8 = str.charAt(i8);
          if (i8 < 55296) {
            break;
          }
          i7 |= (i8 & 0x1FFF) << i5;
          i5 += 13;
        }
        i7 |= i8 << i5;
        i5 = i4;
      }
      i8 = i5 + 1;
      i9 = str.charAt(i5);
      i5 = i9;
      i4 = i8;
      if (i9 >= 55296)
      {
        i9 &= 0x1FFF;
        i5 = 13;
        for (;;)
        {
          i4 = i8 + 1;
          i8 = str.charAt(i8);
          if (i8 < 55296) {
            break;
          }
          i9 |= (i8 & 0x1FFF) << i5;
          i5 += 13;
          i8 = i4;
        }
        i5 = i9 | i8 << i5;
      }
      arrayOfInt1 = new int[i5 + i3 + i7];
      i9 = j + j + i6;
      i6 = i4;
      i7 = m;
      i8 = i3;
      i4 = i9;
      m = i5;
      i3 = i7;
      i7 = i1;
      i5 = i2;
      i2 = i6;
      i1 = i8;
      i6 = j;
    }
    Unsafe localUnsafe = r;
    Object[] arrayOfObject1 = paramZzlv.remove();
    Class localClass = paramZzlv.getSimpleName().getClass();
    int[] arrayOfInt2 = new int[i5 * 3];
    Object[] arrayOfObject2 = new Object[i5 + i5];
    int i21 = m + i1;
    j = m;
    int i12 = i21;
    int i11 = 0;
    int i5 = 0;
    i1 = i4;
    int i9 = m;
    int i8 = i3;
    m = i5;
    while (i2 < i10)
    {
      i3 = i2 + 1;
      i2 = str.charAt(i2);
      int i13 = i2;
      if (i2 >= 55296)
      {
        i4 = i2 & 0x1FFF;
        i2 = 13;
        i5 = i3;
        i3 = i2;
        for (;;)
        {
          i2 = i5 + 1;
          i5 = str.charAt(i5);
          if (i5 < 55296) {
            break;
          }
          i4 |= (i5 & 0x1FFF) << i3;
          i3 += 13;
          i5 = i2;
        }
        i13 = i4 | i5 << i3;
        i3 = i2;
      }
      i2 = i3 + 1;
      i3 = str.charAt(i3);
      int i15 = i3;
      if (i3 >= 55296)
      {
        i4 = i3 & 0x1FFF;
        i5 = i2;
        i2 = 13;
        for (;;)
        {
          i3 = i5 + 1;
          i5 = str.charAt(i5);
          if (i5 < 55296) {
            break;
          }
          i4 |= (i5 & 0x1FFF) << i2;
          i2 += 13;
          i5 = i3;
        }
        i15 = i4 | i5 << i2;
        i2 = i3;
      }
      int i23 = i15 & 0xFF;
      int i14 = m;
      if ((i15 & 0x400) != 0)
      {
        arrayOfInt1[m] = i11;
        i14 = m + 1;
      }
      Object localObject;
      Field localField;
      int i18;
      int i20;
      int i19;
      int i16;
      int i17;
      if (i23 >= 51)
      {
        m = i2 + 1;
        i2 = str.charAt(i2);
        i3 = i2;
        if (i2 >= 55296)
        {
          i3 = i2 & 0x1FFF;
          i4 = m;
          m = 13;
          for (;;)
          {
            i2 = i4 + 1;
            i4 = str.charAt(i4);
            if (i4 < 55296) {
              break;
            }
            i3 |= (i4 & 0x1FFF) << m;
            m += 13;
            i4 = i2;
          }
          i3 |= i4 << m;
        }
        else
        {
          i2 = m;
        }
        i4 = i23 - 51;
        if ((i4 != 9) && (i4 != 17))
        {
          m = i1;
          if (i4 == 12)
          {
            m = i1;
            if (!bool)
            {
              i4 = i11 / 3;
              m = i1 + 1;
              arrayOfObject2[(i4 + i4 + 1)] = arrayOfObject1[i1];
            }
          }
        }
        else
        {
          i4 = i11 / 3;
          m = i1 + 1;
          arrayOfObject2[(i4 + i4 + 1)] = arrayOfObject1[i1];
        }
        i1 = i3 + i3;
        localObject = arrayOfObject1[i1];
        if ((localObject instanceof Field))
        {
          localObject = (Field)localObject;
        }
        else
        {
          localField = get(localClass, (String)localObject);
          localObject = localField;
          arrayOfObject1[i1] = localField;
        }
        i18 = (int)localUnsafe.objectFieldOffset((Field)localObject);
        i1 += 1;
        localObject = arrayOfObject1[i1];
        if ((localObject instanceof Field))
        {
          localObject = (Field)localObject;
        }
        else
        {
          localField = get(localClass, (String)localObject);
          localObject = localField;
          arrayOfObject1[i1] = localField;
        }
        i20 = (int)localUnsafe.objectFieldOffset((Field)localObject);
        i19 = 0;
        i16 = i12;
        i1 = m;
        i17 = j;
      }
      else
      {
        i3 = i1 + 1;
        localObject = get(localClass, (String)arrayOfObject1[i1]);
        if ((i23 != 9) && (i23 != 17))
        {
          if ((i23 != 27) && (i23 != 49))
          {
            if ((i23 != 12) && (i23 != 30) && (i23 != 44))
            {
              i1 = i3;
              m = j;
              if (i23 == 50)
              {
                m = j + 1;
                arrayOfInt1[j] = i11;
                j = i11 / 3;
                i4 = j + j;
                i1 = i3 + 1;
                arrayOfObject2[i4] = arrayOfObject1[i3];
                if ((i15 & 0x800) == 0) {
                  break label2068;
                }
                j = i1 + 1;
                arrayOfObject2[(i4 + 1)] = arrayOfObject1[i1];
                i1 = j;
              }
            }
            label2068:
            do
            {
              j = m;
              break;
              j = m;
              m = i1;
              break label2181;
              i1 = i3;
              m = j;
            } while (bool);
            i1 = i11 / 3;
            m = i3 + 1;
            arrayOfObject2[(i1 + i1 + 1)] = arrayOfObject1[i3];
          }
          else
          {
            i1 = i11 / 3;
            m = i3 + 1;
            arrayOfObject2[(i1 + i1 + 1)] = arrayOfObject1[i3];
          }
        }
        else
        {
          m = i11 / 3;
          arrayOfObject2[(m + m + 1)] = ((Field)localObject).getType();
          i1 = i3;
          m = i1;
        }
        label2181:
        int i22 = (int)localUnsafe.objectFieldOffset((Field)localObject);
        if (((i15 & 0x1000) == 4096) && (i23 <= 17))
        {
          i3 = i2 + 1;
          i2 = str.charAt(i2);
          i1 = i2;
          if (i2 >= 55296)
          {
            i2 &= 0x1FFF;
            i1 = 13;
            for (i4 = i3;; i4 = i3)
            {
              i3 = i4 + 1;
              i4 = str.charAt(i4);
              if (i4 < 55296) {
                break;
              }
              i2 |= (i4 & 0x1FFF) << i1;
              i1 += 13;
            }
            i1 = i2 | i4 << i1;
          }
          i2 = i6 + i6 + i1 / 32;
          localObject = arrayOfObject1[i2];
          if ((localObject instanceof Field))
          {
            localObject = (Field)localObject;
          }
          else
          {
            localField = get(localClass, (String)localObject);
            localObject = localField;
            arrayOfObject1[i2] = localField;
          }
          i5 = (int)localUnsafe.objectFieldOffset((Field)localObject);
          i4 = i1 % 32;
        }
        else
        {
          i5 = 1048575;
          i4 = 0;
          i3 = i2;
        }
        i16 = i12;
        i2 = i3;
        i18 = i22;
        i1 = m;
        i17 = j;
        i19 = i4;
        i20 = i5;
        if (i23 >= 18)
        {
          i16 = i12;
          i2 = i3;
          i18 = i22;
          i1 = m;
          i17 = j;
          i19 = i4;
          i20 = i5;
          if (i23 <= 49)
          {
            arrayOfInt1[i12] = i22;
            i16 = i12 + 1;
            i20 = i5;
            i19 = i4;
            i17 = j;
            i1 = m;
            i18 = i22;
            i2 = i3;
          }
        }
      }
      i3 = i11 + 1;
      arrayOfInt2[i11] = i13;
      i4 = i3 + 1;
      if ((i15 & 0x200) != 0) {
        j = 536870912;
      } else {
        j = 0;
      }
      if ((i15 & 0x100) != 0) {
        m = 268435456;
      } else {
        m = 0;
      }
      arrayOfInt2[i3] = (m | j | i23 << 20 | i18);
      i11 = i4 + 1;
      arrayOfInt2[i4] = (i20 | i19 << 20);
      i12 = i16;
      m = i14;
      j = i17;
    }
    return new zzlo(arrayOfInt2, arrayOfObject2, i7, i8, paramZzlv.getSimpleName(), bool, false, arrayOfInt1, i9, i21, paramZzlq, paramZzkz, paramZzmn, paramZzjr, paramZzlg, null);
  }
  
  private static boolean parse(Object paramObject, int paramInt, zzlw paramZzlw)
  {
    return paramZzlw.parse(zzmx.getValue(paramObject, paramInt & 0xFFFFF));
  }
  
  private static final void put(int paramInt, Object paramObject, zznf paramZznf)
    throws IOException
  {
    if ((paramObject instanceof String))
    {
      paramZznf.ensureCapacity(paramInt, (String)paramObject);
      return;
    }
    paramZznf.put(paramInt, (zzjd)paramObject);
  }
  
  private final void put(zznf paramZznf, int paramInt1, Object paramObject, int paramInt2)
    throws IOException
  {
    if (paramObject == null) {
      return;
    }
    paramZznf = (zzle)get(paramInt2);
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  private static double read(Object paramObject, long paramLong)
  {
    return ((Double)zzmx.getValue(paramObject, paramLong)).doubleValue();
  }
  
  private final void run(Object paramObject, zznf paramZznf)
    throws IOException
  {
    if (!c)
    {
      int i4 = i.length;
      Object localObject = r;
      int j = 1048575;
      int i2 = 0;
      int m = 0;
      while (i2 < i4)
      {
        int i5 = charAt(i2);
        int[] arrayOfInt = i;
        int i6 = arrayOfInt[i2];
        int i7 = b(i5);
        int i1;
        if (i7 <= 17)
        {
          int i8 = arrayOfInt[(i2 + 2)];
          int i3 = i8 & 0xFFFFF;
          i1 = j;
          if (i3 != j)
          {
            m = ((Unsafe)localObject).getInt(paramObject, i3);
            i1 = i3;
          }
          i3 = 1 << (i8 >>> 20);
          j = i1;
          i1 = i3;
        }
        else
        {
          i1 = 0;
        }
        long l1 = i5 & 0xFFFFF;
        switch (i7)
        {
        default: 
          break;
        }
        for (;;)
        {
          break;
          if (get(paramObject, i6, i2))
          {
            paramZznf.put(i6, ((Unsafe)localObject).getObject(paramObject, l1), toString(i2));
            continue;
            if (get(paramObject, i6, i2))
            {
              paramZznf.a(i6, get(paramObject, l1));
              continue;
              if (get(paramObject, i6, i2))
              {
                paramZznf.a(i6, getValue(paramObject, l1));
                continue;
                if (get(paramObject, i6, i2))
                {
                  paramZznf.append(i6, get(paramObject, l1));
                  continue;
                  if (get(paramObject, i6, i2))
                  {
                    paramZznf.b(i6, getValue(paramObject, l1));
                    continue;
                    if (get(paramObject, i6, i2))
                    {
                      paramZznf.get(i6, getValue(paramObject, l1));
                      continue;
                      if (get(paramObject, i6, i2))
                      {
                        paramZznf.setProgress(i6, getValue(paramObject, l1));
                        continue;
                        if (get(paramObject, i6, i2))
                        {
                          paramZznf.put(i6, (zzjd)((Unsafe)localObject).getObject(paramObject, l1));
                          continue;
                          if (get(paramObject, i6, i2))
                          {
                            paramZznf.b(i6, ((Unsafe)localObject).getObject(paramObject, l1), toString(i2));
                            continue;
                            if (get(paramObject, i6, i2))
                            {
                              put(i6, ((Unsafe)localObject).getObject(paramObject, l1), paramZznf);
                              continue;
                              if (get(paramObject, i6, i2))
                              {
                                paramZznf.b(i6, toString(paramObject, l1));
                                continue;
                                if (get(paramObject, i6, i2))
                                {
                                  paramZznf.put(i6, getValue(paramObject, l1));
                                  continue;
                                  if (get(paramObject, i6, i2))
                                  {
                                    paramZznf.put(i6, get(paramObject, l1));
                                    continue;
                                    if (get(paramObject, i6, i2))
                                    {
                                      paramZznf.append(i6, getValue(paramObject, l1));
                                      continue;
                                      if (get(paramObject, i6, i2))
                                      {
                                        paramZznf.b(i6, get(paramObject, l1));
                                        continue;
                                        if (get(paramObject, i6, i2))
                                        {
                                          paramZznf.get(i6, get(paramObject, l1));
                                          continue;
                                          if (get(paramObject, i6, i2))
                                          {
                                            paramZznf.a(i6, a(paramObject, l1));
                                            continue;
                                            if (get(paramObject, i6, i2))
                                            {
                                              paramZznf.a(i6, read(paramObject, l1));
                                              continue;
                                              put(paramZznf, i6, ((Unsafe)localObject).getObject(paramObject, l1), i2);
                                              continue;
                                              zzly.put(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, toString(i2));
                                              continue;
                                              zzly.visitMethodInsn(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, true);
                                              continue;
                                              zzly.add(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, true);
                                              continue;
                                              zzly.put(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, true);
                                              continue;
                                              zzly.write(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, true);
                                              continue;
                                              zzly.toString(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, true);
                                              continue;
                                              zzly.finish(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, true);
                                              continue;
                                              zzly.indexOf(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, true);
                                              continue;
                                              zzly.a(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, true);
                                              continue;
                                              zzly.setProgress(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, true);
                                              continue;
                                              zzly.get(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, true);
                                              continue;
                                              zzly.connect(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, true);
                                              continue;
                                              zzly.b(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, true);
                                              continue;
                                              zzly.set(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, true);
                                              continue;
                                              zzly.append(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, true);
                                              continue;
                                              zzly.visitMethodInsn(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, false);
                                              break label1821;
                                              zzly.add(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, false);
                                              break label1821;
                                              zzly.put(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, false);
                                              break label1821;
                                              zzly.write(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, false);
                                              break label1821;
                                              zzly.toString(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, false);
                                              break label1821;
                                              zzly.finish(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, false);
                                              label1821:
                                              break;
                                              zzly.a(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf);
                                              continue;
                                              zzly.a(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, toString(i2));
                                              continue;
                                              zzly.b(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf);
                                              continue;
                                              zzly.indexOf(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, false);
                                              break;
                                              zzly.a(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, false);
                                              break;
                                              zzly.setProgress(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, false);
                                              break;
                                              zzly.get(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, false);
                                              break;
                                              zzly.connect(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, false);
                                              break;
                                              zzly.b(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, false);
                                              break;
                                              zzly.set(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, false);
                                              break;
                                              zzly.append(i[i2], (List)((Unsafe)localObject).getObject(paramObject, l1), paramZznf, false);
                                              break;
                                              if ((m & i1) != 0)
                                              {
                                                paramZznf.put(i6, ((Unsafe)localObject).getObject(paramObject, l1), toString(i2));
                                                break;
                                                if ((m & i1) != 0)
                                                {
                                                  paramZznf.a(i6, ((Unsafe)localObject).getLong(paramObject, l1));
                                                  break;
                                                  if ((m & i1) != 0)
                                                  {
                                                    paramZznf.a(i6, ((Unsafe)localObject).getInt(paramObject, l1));
                                                    break;
                                                    if ((m & i1) != 0)
                                                    {
                                                      paramZznf.append(i6, ((Unsafe)localObject).getLong(paramObject, l1));
                                                      break;
                                                      if ((m & i1) != 0)
                                                      {
                                                        paramZznf.b(i6, ((Unsafe)localObject).getInt(paramObject, l1));
                                                        break;
                                                        if ((m & i1) != 0)
                                                        {
                                                          paramZznf.get(i6, ((Unsafe)localObject).getInt(paramObject, l1));
                                                          break;
                                                          if ((m & i1) != 0)
                                                          {
                                                            paramZznf.setProgress(i6, ((Unsafe)localObject).getInt(paramObject, l1));
                                                            break;
                                                            if ((m & i1) != 0)
                                                            {
                                                              paramZznf.put(i6, (zzjd)((Unsafe)localObject).getObject(paramObject, l1));
                                                              break;
                                                              if ((m & i1) != 0)
                                                              {
                                                                paramZznf.b(i6, ((Unsafe)localObject).getObject(paramObject, l1), toString(i2));
                                                                break;
                                                                if ((m & i1) != 0)
                                                                {
                                                                  put(i6, ((Unsafe)localObject).getObject(paramObject, l1), paramZznf);
                                                                  break;
                                                                  if ((m & i1) != 0)
                                                                  {
                                                                    paramZznf.b(i6, zzmx.c(paramObject, l1));
                                                                    break;
                                                                    if ((m & i1) != 0)
                                                                    {
                                                                      paramZznf.put(i6, ((Unsafe)localObject).getInt(paramObject, l1));
                                                                      break;
                                                                      if ((m & i1) != 0)
                                                                      {
                                                                        paramZznf.put(i6, ((Unsafe)localObject).getLong(paramObject, l1));
                                                                        break;
                                                                        if ((m & i1) != 0)
                                                                        {
                                                                          paramZznf.append(i6, ((Unsafe)localObject).getInt(paramObject, l1));
                                                                          break;
                                                                          if ((m & i1) != 0)
                                                                          {
                                                                            paramZznf.b(i6, ((Unsafe)localObject).getLong(paramObject, l1));
                                                                            break;
                                                                            if ((m & i1) != 0)
                                                                            {
                                                                              paramZznf.get(i6, ((Unsafe)localObject).getLong(paramObject, l1));
                                                                              break;
                                                                              if ((m & i1) != 0)
                                                                              {
                                                                                paramZznf.a(i6, zzmx.e(paramObject, l1));
                                                                                break;
                                                                                if ((m & i1) != 0) {
                                                                                  paramZznf.a(i6, zzmx.d(paramObject, l1));
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
        i2 += 3;
      }
      localObject = x;
      ((zzmn)localObject).subtract(((zzmn)localObject).getValue(paramObject), paramZznf);
      return;
    }
    b.invoke(paramObject);
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  private final zzlw toString(int paramInt)
  {
    paramInt /= 3;
    paramInt += paramInt;
    zzlw localZzlw = (zzlw)a[paramInt];
    if (localZzlw != null) {
      return localZzlw;
    }
    localZzlw = zzlt.decorated().get((Class)a[(paramInt + 1)]);
    a[paramInt] = localZzlw;
    return localZzlw;
  }
  
  private static boolean toString(Object paramObject, long paramLong)
  {
    return ((Boolean)zzmx.getValue(paramObject, paramLong)).booleanValue();
  }
  
  private final void visit(Object paramObject1, Object paramObject2, int paramInt)
  {
    long l1 = charAt(paramInt) & 0xFFFFF;
    if (!a(paramObject2, paramInt)) {
      return;
    }
    Object localObject = zzmx.getValue(paramObject1, l1);
    paramObject2 = zzmx.getValue(paramObject2, l1);
    if ((localObject != null) && (paramObject2 != null))
    {
      zzmx.add(paramObject1, l1, zzkm.valueOf(localObject, paramObject2));
      b(paramObject1, paramInt);
      return;
    }
    if (paramObject2 != null)
    {
      zzmx.add(paramObject1, l1, paramObject2);
      b(paramObject1, paramInt);
    }
  }
  
  private final int write(Object paramObject)
  {
    Object localObject1 = r;
    int m = 1048575;
    int i3 = 0;
    int i2 = 0;
    int i5 = 0;
    while (i3 < i.length)
    {
      int i8 = charAt(i3);
      Object localObject2 = i;
      int i7 = localObject2[i3];
      int i9 = b(i8);
      int i1;
      int i6;
      int i4;
      if (i9 <= 17)
      {
        i1 = localObject2[(i3 + 2)];
        j = i1 & 0xFFFFF;
        i6 = 1 << (i1 >>> 20);
        i4 = m;
        i1 = i6;
        if (j != m)
        {
          i5 = ((Unsafe)localObject1).getInt(paramObject, j);
          i4 = j;
          i1 = i6;
        }
      }
      else
      {
        i1 = 0;
        i4 = m;
      }
      long l1 = i8 & 0xFFFFF;
      switch (i9)
      {
      default: 
        j = i2;
        break;
      case 68: 
        j = i2;
        if (get(paramObject, i7, i3)) {
          j = zzjl.b(i7, (zzll)((Unsafe)localObject1).getObject(paramObject, l1), toString(i3));
        }
        break;
      case 67: 
        j = i2;
        if (get(paramObject, i7, i3))
        {
          l1 = get(paramObject, l1);
          j = i2 + (zzjl.append(i7 << 3) + zzjl.get(l1 >> 63 ^ l1 + l1));
        }
        break;
      case 66: 
        j = i2;
        if (get(paramObject, i7, i3))
        {
          m = getValue(paramObject, l1);
          j = zzjl.append(i7 << 3);
          m = zzjl.append(m >> 31 ^ m + m);
        }
        break;
      case 65: 
        j = i2;
        if (get(paramObject, i7, i3)) {
          j = zzjl.append(i7 << 3);
        }
        break;
      case 64: 
        j = i2;
        if (get(paramObject, i7, i3)) {
          j = zzjl.append(i7 << 3);
        }
        break;
      case 63: 
        j = i2;
        if (get(paramObject, i7, i3))
        {
          m = getValue(paramObject, l1);
          j = zzjl.append(i7 << 3);
          m = zzjl.get(m);
        }
        break;
      case 62: 
        j = i2;
        if (get(paramObject, i7, i3))
        {
          m = getValue(paramObject, l1);
          j = zzjl.append(i7 << 3);
          m = zzjl.append(m);
        }
        break;
      case 61: 
        j = i2;
        if (get(paramObject, i7, i3))
        {
          localObject2 = (zzjd)((Unsafe)localObject1).getObject(paramObject, l1);
          m = zzjl.append(i7 << 3);
          i1 = ((zzjd)localObject2).size();
          j = i1;
        }
      case 60: 
      case 59: 
        for (i1 = zzjl.append(i1);; i1 = zzjl.append(i1))
        {
          j = m + (i1 + j);
          break label2128;
          j = i2;
          if (!get(paramObject, i7, i3)) {
            break label2335;
          }
          j = zzly.a(i7, ((Unsafe)localObject1).getObject(paramObject, l1), toString(i3));
          break label2330;
          j = i2;
          if (!get(paramObject, i7, i3)) {
            break label2335;
          }
          localObject2 = ((Unsafe)localObject1).getObject(paramObject, l1);
          if (!(localObject2 instanceof zzjd)) {
            break;
          }
          localObject2 = (zzjd)localObject2;
          m = zzjl.append(i7 << 3);
          i1 = ((zzjd)localObject2).size();
          j = i1;
        }
        localObject2 = (String)localObject2;
        j = zzjl.append(i7 << 3);
        m = zzjl.a((String)localObject2);
        break;
      case 58: 
        j = i2;
        if (get(paramObject, i7, i3)) {
          j = zzjl.append(i7 << 3) + 1;
        }
        break;
      case 57: 
        j = i2;
        if (get(paramObject, i7, i3)) {
          j = zzjl.append(i7 << 3);
        }
        break;
      case 56: 
        j = i2;
        if (get(paramObject, i7, i3)) {
          j = zzjl.append(i7 << 3);
        }
        break;
      case 55: 
        j = i2;
        if (get(paramObject, i7, i3))
        {
          m = getValue(paramObject, l1);
          j = zzjl.append(i7 << 3);
          m = zzjl.get(m);
        }
        break;
      case 54: 
        j = i2;
        if (get(paramObject, i7, i3))
        {
          l1 = get(paramObject, l1);
          j = zzjl.append(i7 << 3);
          m = zzjl.get(l1);
        }
        break;
      case 53: 
        j = i2;
        if (get(paramObject, i7, i3))
        {
          l1 = get(paramObject, l1);
          j = zzjl.append(i7 << 3);
          m = zzjl.get(l1);
          j = i2 + (j + m);
        }
        break;
      case 52: 
        j = i2;
        if (get(paramObject, i7, i3))
        {
          j = zzjl.append(i7 << 3);
          j += 4;
        }
        break;
      case 51: 
        j = i2;
        if (get(paramObject, i7, i3))
        {
          j = zzjl.append(i7 << 3);
          j += 8;
        }
        break;
      case 50: 
        zzlg.remove(i7, ((Unsafe)localObject1).getObject(paramObject, l1), get(i3));
        j = i2;
        break;
      case 49: 
        j = zzly.b(i7, (List)((Unsafe)localObject1).getObject(paramObject, l1), toString(i3));
        break;
      case 48: 
        m = zzly.a((List)((Unsafe)localObject1).getObject(paramObject, l1));
        i6 = m;
        j = i2;
        if (m > 0)
        {
          j = zzjl.getValue(i7);
          i1 = zzjl.append(m);
          m = j;
          j = i6;
        }
        break;
      case 47: 
        m = zzly.read((List)((Unsafe)localObject1).getObject(paramObject, l1));
        i6 = m;
        j = i2;
        if (m > 0)
        {
          j = zzjl.getValue(i7);
          i1 = zzjl.append(m);
          m = j;
          j = i6;
        }
        break;
      case 46: 
        m = zzly.getStep((List)((Unsafe)localObject1).getObject(paramObject, l1));
        i6 = m;
        j = i2;
        if (m > 0)
        {
          j = zzjl.getValue(i7);
          i1 = zzjl.append(m);
          m = j;
          j = i6;
        }
        break;
      case 45: 
        m = zzly.sendChar((List)((Unsafe)localObject1).getObject(paramObject, l1));
        i6 = m;
        j = i2;
        if (m > 0)
        {
          j = zzjl.getValue(i7);
          i1 = zzjl.append(m);
          m = j;
          j = i6;
        }
        break;
      case 44: 
        m = zzly.replace((List)((Unsafe)localObject1).getObject(paramObject, l1));
        i6 = m;
        j = i2;
        if (m > 0)
        {
          j = zzjl.getValue(i7);
          i1 = zzjl.append(m);
          m = j;
          j = i6;
        }
        break;
      case 43: 
        m = zzly.encode((List)((Unsafe)localObject1).getObject(paramObject, l1));
        i6 = m;
        j = i2;
        if (m > 0)
        {
          j = zzjl.getValue(i7);
          i1 = zzjl.append(m);
          m = j;
          j = i6;
        }
        break;
      case 42: 
        m = zzly.getAttributeCount((List)((Unsafe)localObject1).getObject(paramObject, l1));
        i6 = m;
        j = i2;
        if (m > 0)
        {
          j = zzjl.getValue(i7);
          i1 = zzjl.append(m);
          m = j;
          j = i6;
        }
        break;
      case 41: 
        m = zzly.sendChar((List)((Unsafe)localObject1).getObject(paramObject, l1));
        i6 = m;
        j = i2;
        if (m > 0)
        {
          j = zzjl.getValue(i7);
          i1 = zzjl.append(m);
          m = j;
          j = i6;
        }
        break;
      case 40: 
        m = zzly.getStep((List)((Unsafe)localObject1).getObject(paramObject, l1));
        i6 = m;
        j = i2;
        if (m > 0)
        {
          j = zzjl.getValue(i7);
          i1 = zzjl.append(m);
          m = j;
          j = i6;
        }
        break;
      case 39: 
        m = zzly.add((List)((Unsafe)localObject1).getObject(paramObject, l1));
        i6 = m;
        j = i2;
        if (m > 0)
        {
          j = zzjl.getValue(i7);
          i1 = zzjl.append(m);
          m = j;
          j = i6;
        }
        break;
      case 38: 
        m = zzly.get((List)((Unsafe)localObject1).getObject(paramObject, l1));
        i6 = m;
        j = i2;
        if (m > 0)
        {
          j = zzjl.getValue(i7);
          i1 = zzjl.append(m);
          m = j;
          j = i6;
        }
        break;
      case 37: 
        m = zzly.getValue((List)((Unsafe)localObject1).getObject(paramObject, l1));
        i6 = m;
        j = i2;
        if (m > 0)
        {
          j = zzjl.getValue(i7);
          i1 = zzjl.append(m);
          m = j;
          j = i6;
        }
        break;
      case 36: 
        m = zzly.sendChar((List)((Unsafe)localObject1).getObject(paramObject, l1));
        i6 = m;
        j = i2;
        if (m > 0)
        {
          j = zzjl.getValue(i7);
          i1 = zzjl.append(m);
          m = j;
          j = i6;
        }
        break;
      case 35: 
        i1 = zzly.getStep((List)((Unsafe)localObject1).getObject(paramObject, l1));
        m = i1;
        j = i2;
        if (i1 > 0)
        {
          i6 = zzjl.getValue(i7);
          i1 = zzjl.append(i1);
          j = m;
          m = i6;
          i1 = m + i1;
          m = j;
          j = i1;
          j += m;
          j = i2 + j;
        }
        break;
      case 34: 
        j = zzly.b(i7, (List)((Unsafe)localObject1).getObject(paramObject, l1), false);
        break;
      case 33: 
        j = zzly.a(i7, (List)((Unsafe)localObject1).getObject(paramObject, l1), false);
        break;
      case 32: 
        j = zzly.set(i7, (List)((Unsafe)localObject1).getObject(paramObject, l1), false);
        break;
      case 31: 
        j = zzly.append(i7, (List)((Unsafe)localObject1).getObject(paramObject, l1), false);
        break;
      case 30: 
        j = zzly.put(i7, (List)((Unsafe)localObject1).getObject(paramObject, l1), false);
        j = i2 + j;
        break;
      case 29: 
        j = zzly.valueOf(i7, (List)((Unsafe)localObject1).getObject(paramObject, l1), false);
        break;
      case 28: 
        j = zzly.a(i7, (List)((Unsafe)localObject1).getObject(paramObject, l1));
        break;
      case 27: 
        j = zzly.a(i7, (List)((Unsafe)localObject1).getObject(paramObject, l1), toString(i3));
        break;
      case 26: 
        j = zzly.b(i7, (List)((Unsafe)localObject1).getObject(paramObject, l1));
        j = i2 + j;
        break;
      case 25: 
        j = zzly.toString(i7, (List)((Unsafe)localObject1).getObject(paramObject, l1), false);
        break;
      case 24: 
        j = zzly.append(i7, (List)((Unsafe)localObject1).getObject(paramObject, l1), false);
        break;
      case 23: 
        j = zzly.set(i7, (List)((Unsafe)localObject1).getObject(paramObject, l1), false);
        break;
      case 22: 
        j = zzly.get(i7, (List)((Unsafe)localObject1).getObject(paramObject, l1), false);
        break;
      case 21: 
        j = zzly.elementAt(i7, (List)((Unsafe)localObject1).getObject(paramObject, l1), false);
        break;
      case 20: 
        j = zzly.indexOf(i7, (List)((Unsafe)localObject1).getObject(paramObject, l1), false);
        break;
      case 19: 
        j = zzly.append(i7, (List)((Unsafe)localObject1).getObject(paramObject, l1), false);
        break;
      case 18: 
        label2128:
        label2330:
        label2335:
        j = zzly.set(i7, (List)((Unsafe)localObject1).getObject(paramObject, l1), false);
      }
      for (;;)
      {
        j = i2 + j;
        break;
        j = i2;
        if ((i5 & i1) == 0) {
          break;
        }
        j = zzjl.b(i7, (zzll)((Unsafe)localObject1).getObject(paramObject, l1), toString(i3));
        continue;
        j = i2;
        if ((i1 & i5) == 0) {
          break;
        }
        l1 = ((Unsafe)localObject1).getLong(paramObject, l1);
        j = i2 + (zzjl.append(i7 << 3) + zzjl.get(l1 >> 63 ^ l1 + l1));
        break;
        j = i2;
        if ((i5 & i1) == 0) {
          break;
        }
        m = ((Unsafe)localObject1).getInt(paramObject, l1);
        j = zzjl.append(i7 << 3);
        m = zzjl.append(m >> 31 ^ m + m);
        break label3039;
        j = i2;
        if ((i5 & i1) == 0) {
          break;
        }
        j = zzjl.append(i7 << 3);
        break label3179;
        j = i2;
        if ((i5 & i1) == 0) {
          break;
        }
        j = zzjl.append(i7 << 3);
        break label3153;
        j = i2;
        if ((i5 & i1) == 0) {
          break;
        }
        m = ((Unsafe)localObject1).getInt(paramObject, l1);
        j = zzjl.append(i7 << 3);
        m = zzjl.get(m);
        break label3039;
        j = i2;
        if ((i5 & i1) == 0) {
          break;
        }
        m = ((Unsafe)localObject1).getInt(paramObject, l1);
        j = zzjl.append(i7 << 3);
        m = zzjl.append(m);
        break label3039;
        j = i2;
        if ((i5 & i1) == 0) {
          break;
        }
        localObject2 = (zzjd)((Unsafe)localObject1).getObject(paramObject, l1);
        m = zzjl.append(i7 << 3);
        i1 = ((zzjd)localObject2).size();
        j = i1;
        for (i1 = zzjl.append(i1);; i1 = zzjl.append(i1))
        {
          j = m + (i1 + j);
          break label3043;
          j = i2;
          if ((i5 & i1) == 0) {
            break label3187;
          }
          j = zzly.a(i7, ((Unsafe)localObject1).getObject(paramObject, l1), toString(i3));
          break;
          j = i2;
          if ((i5 & i1) == 0) {
            break label3187;
          }
          localObject2 = ((Unsafe)localObject1).getObject(paramObject, l1);
          if (!(localObject2 instanceof zzjd)) {
            break label2914;
          }
          localObject2 = (zzjd)localObject2;
          m = zzjl.append(i7 << 3);
          i1 = ((zzjd)localObject2).size();
          j = i1;
        }
        label2914:
        localObject2 = (String)localObject2;
        j = zzjl.append(i7 << 3);
        m = zzjl.a((String)localObject2);
        break label3039;
        j = i2;
        if ((i5 & i1) == 0) {
          break;
        }
        j = zzjl.append(i7 << 3) + 1;
        continue;
        j = i2;
        if ((i5 & i1) == 0) {
          break;
        }
        j = zzjl.append(i7 << 3);
        break label3153;
        j = i2;
        if ((i5 & i1) == 0) {
          break;
        }
        j = zzjl.append(i7 << 3);
        break label3179;
        j = i2;
        if ((i5 & i1) == 0) {
          break;
        }
        m = ((Unsafe)localObject1).getInt(paramObject, l1);
        j = zzjl.append(i7 << 3);
        m = zzjl.get(m);
        label3039:
        j += m;
        label3043:
        j = i2 + j;
        break;
        j = i2;
        if ((i5 & i1) == 0) {
          break;
        }
        l1 = ((Unsafe)localObject1).getLong(paramObject, l1);
        j = zzjl.append(i7 << 3);
        m = zzjl.get(l1);
        break label3124;
        j = i2;
        if ((i5 & i1) == 0) {
          break;
        }
        l1 = ((Unsafe)localObject1).getLong(paramObject, l1);
        j = zzjl.append(i7 << 3);
        m = zzjl.get(l1);
        label3124:
        j = i2 + (j + m);
        break;
        j = i2;
        if ((i5 & i1) == 0) {
          break;
        }
        j = zzjl.append(i7 << 3);
        label3153:
        j += 4;
        continue;
        j = i2;
        if ((i5 & i1) == 0) {
          break;
        }
        j = zzjl.append(i7 << 3);
        label3179:
        j += 8;
      }
      label3187:
      i3 += 3;
      m = i4;
      i2 = j;
    }
    localObject1 = x;
    int j = ((zzmn)localObject1).get(((zzmn)localObject1).getValue(paramObject));
    if (!c) {
      return i2 + j;
    }
    b.invoke(paramObject);
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  final int a(Object paramObject, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, zziq paramZziq)
    throws IOException
  {
    Object localObject1 = paramArrayOfByte;
    int m = paramInt3;
    Unsafe localUnsafe = r;
    int j = 0;
    int i4 = 0;
    int i2 = 0;
    int i5 = -1;
    int i3 = 1048575;
    Object localObject3;
    Object localObject2;
    int i1;
    for (;;)
    {
      Object localObject4 = paramZziq;
      localObject3 = paramObject;
      int i7 = paramInt2;
      localObject2 = this;
      if (paramInt1 >= i7) {
        break;
      }
      j = paramInt1 + 1;
      i1 = localObject1[paramInt1];
      if (i1 < 0)
      {
        j = zzir.a(i1, (byte[])localObject1, j, (zziq)localObject4);
        i1 = a;
      }
      int i6 = i1 >>> 3;
      int i8 = i1 & 0x7;
      if (i6 > i5) {
        paramInt1 = ((zzlo)localObject2).b(i6, i4 / 3);
      } else {
        paramInt1 = ((zzlo)localObject2).d(i6);
      }
      if (paramInt1 == -1)
      {
        paramInt1 = m;
        i4 = 0;
        m = j;
        j = i1;
      }
      else
      {
        int[] arrayOfInt = i;
        int i9 = arrayOfInt[(paramInt1 + 1)];
        int i10 = b(i9);
        m = j;
        long l1 = i9 & 0xFFFFF;
        if (i10 <= 17)
        {
          i4 = arrayOfInt[(paramInt1 + 2)];
          boolean bool = true;
          i5 = 1 << (i4 >>> 20);
          i4 &= 0xFFFFF;
          if (i4 != i3)
          {
            if (i3 != 1048575) {
              localUnsafe.putInt(localObject3, i3, i2);
            }
            i2 = localUnsafe.getInt(localObject3, i4);
            i3 = i4;
          }
          switch (i10)
          {
          default: 
            if (i8 == 3)
            {
              j = zzir.a(((zzlo)localObject2).toString(paramInt1), paramArrayOfByte, m, paramInt2, i6 << 3 | 0x4, paramZziq);
              if ((i2 & i5) != 0) {
                break label1119;
              }
              localUnsafe.putObject(localObject3, l1, c);
            }
            break;
          case 16: 
            if (i8 == 0)
            {
              j = zzir.read((byte[])localObject1, m, (zziq)localObject4);
              localUnsafe.putLong(paramObject, l1, zzjh.readLong(d));
              i2 |= i5;
            }
            else
            {
              j = m;
            }
            break;
          case 15: 
            if (i8 == 0)
            {
              j = zzir.a((byte[])localObject1, m, (zziq)localObject4);
              localUnsafe.putInt(localObject3, l1, zzjh.a(a));
            }
            break;
          case 12: 
            if (i8 == 0)
            {
              j = zzir.a((byte[])localObject1, m, (zziq)localObject4);
              m = a;
              localObject2 = ((zzlo)localObject2).a(paramInt1);
              if ((localObject2 != null) && (!((zzki)localObject2).b(m))) {
                f(paramObject).add(i1, Long.valueOf(m));
              } else {
                localUnsafe.putInt(localObject3, l1, m);
              }
            }
            break;
          case 10: 
            if (i8 == 2)
            {
              j = zzir.b((byte[])localObject1, m, (zziq)localObject4);
              localUnsafe.putObject(localObject3, l1, c);
            }
          case 9: 
            for (;;)
            {
              i2 |= i5;
              i4 = paramInt1;
              paramInt1 = j;
              break label909;
              if (i8 != 2) {
                break;
              }
              j = zzir.a(((zzlo)localObject2).toString(paramInt1), (byte[])localObject1, m, i7, (zziq)localObject4);
              if ((i2 & i5) == 0) {
                localUnsafe.putObject(localObject3, l1, c);
              } else {
                localUnsafe.putObject(localObject3, l1, zzkm.valueOf(localUnsafe.getObject(localObject3, l1), c));
              }
            }
            break;
          case 8: 
            if (i8 == 2)
            {
              if ((0x20000000 & i9) == 0) {
                j = zzir.d((byte[])localObject1, m, (zziq)localObject4);
              } else {
                j = zzir.c((byte[])localObject1, m, (zziq)localObject4);
              }
              localUnsafe.putObject(localObject3, l1, c);
            }
            break;
          case 7: 
            if (i8 == 0)
            {
              j = zzir.read((byte[])localObject1, m, (zziq)localObject4);
              if (d == 0L) {
                bool = false;
              }
              zzmx.a(localObject3, l1, bool);
            }
            break;
          case 6: 
          case 13: 
            if (i8 == 5)
            {
              localUnsafe.putInt(localObject3, l1, zzir.readInt((byte[])localObject1, m));
              j = m + 4;
              i2 |= i5;
              i4 = paramInt1;
              paramInt1 = j;
              i5 = i6;
              m = paramInt3;
              j = i1;
              continue;
            }
            break;
          case 5: 
          case 14: 
            if (i8 == 1) {
              localUnsafe.putLong(paramObject, l1, zzir.readLong((byte[])localObject1, m));
            } else {
              j = m;
            }
            break;
          case 4: 
          case 11: 
            if (i8 == 0)
            {
              j = zzir.a((byte[])localObject1, m, (zziq)localObject4);
              localUnsafe.putInt(localObject3, l1, a);
            }
            break;
          case 2: 
          case 3: 
            if (i8 == 0)
            {
              j = zzir.read((byte[])localObject1, m, (zziq)localObject4);
              localUnsafe.putLong(paramObject, l1, d);
              m = i2 | i5;
            }
            break;
          case 1: 
            if (i8 == 5)
            {
              zzmx.a(localObject3, l1, Float.intBitsToFloat(zzir.readInt((byte[])localObject1, m)));
              j = m + 4;
            }
            break;
          case 0: 
            label909:
            if (i8 == 1)
            {
              zzmx.a(localObject3, l1, Double.longBitsToDouble(zzir.readLong((byte[])localObject1, m)));
              j += 8;
              m = i2 | i5;
            }
            for (;;)
            {
              i4 = paramInt1;
              paramInt1 = j;
              j = i1;
              i2 = m;
              break label1313;
              break;
              label1119:
              localUnsafe.putObject(localObject3, l1, zzkm.valueOf(localUnsafe.getObject(localObject3, l1), c));
              m = i2 | i5;
              localObject1 = paramArrayOfByte;
            }
            i5 = paramInt3;
            m = j;
            j = i1;
            i4 = paramInt1;
            paramInt1 = i5;
            break;
          }
        }
        if (i10 == 27)
        {
          if (i8 == 2)
          {
            localObject4 = (zzkl)localUnsafe.getObject(localObject3, l1);
            localObject1 = localObject4;
            if (!((zzkl)localObject4).get())
            {
              j = ((List)localObject4).size();
              if (j == 0) {
                j = 10;
              } else {
                j += j;
              }
              localObject4 = ((zzkl)localObject4).trim(j);
              localObject1 = localObject4;
              localUnsafe.putObject(localObject3, l1, localObject4);
            }
            localObject2 = ((zzlo)localObject2).toString(paramInt1);
            j = i1;
            m = zzir.a((zzlw)localObject2, i1, paramArrayOfByte, m, paramInt2, (zzkl)localObject1, paramZziq);
            localObject1 = paramArrayOfByte;
            i4 = paramInt1;
            paramInt1 = m;
            label1313:
            i5 = i6;
            m = paramInt3;
            continue;
          }
        }
        else if (i10 <= 49)
        {
          i5 = a(paramObject, paramArrayOfByte, j, paramInt2, i1, i6, i8, paramInt1, i9, i10, l1, paramZziq);
          i4 = i5;
          m = i4;
          if (i5 != j) {
            j = i4;
          }
        }
        for (;;)
        {
          i5 = i6;
          i4 = paramInt1;
          localObject1 = paramArrayOfByte;
          m = paramInt3;
          paramInt1 = j;
          j = i1;
          break;
          label1464:
          label1481:
          do
          {
            for (;;)
            {
              break label1464;
              if (i10 != 50) {
                break label1481;
              }
              if (i8 == 2)
              {
                i5 = a(paramObject, paramArrayOfByte, j, paramInt2, paramInt1, l1, paramZziq);
                i4 = i5;
                m = i4;
                if (i5 == j) {
                  continue;
                }
                j = i4;
                break;
              }
              m = j;
            }
            i5 = paramInt3;
            j = i1;
            i4 = paramInt1;
            paramInt1 = i5;
            break label1530;
            i5 = a(paramObject, paramArrayOfByte, j, paramInt2, i1, i6, i8, i9, i10, l1, paramInt1, paramZziq);
            i4 = i5;
            m = i4;
          } while (i5 == j);
          j = i4;
        }
      }
      label1530:
      i5 = i6;
      if ((j == paramInt1) && (paramInt1 != 0))
      {
        paramInt3 = paramInt1;
        paramArrayOfByte = this;
        break label1671;
      }
      if (c)
      {
        localObject1 = o;
        if (localObject1 != zzjq.o)
        {
          if (((zzjq)localObject1).a(l, i5) == null)
          {
            i1 = zzir.a(j, paramArrayOfByte, m, paramInt2, f(paramObject), paramZziq);
            break label1646;
          }
          paramObject = (zzkb)paramObject;
          throw new NullPointerException("Null throw statement replaced by Soot");
        }
      }
      i1 = zzir.a(j, paramArrayOfByte, m, paramInt2, f(paramObject), paramZziq);
      label1646:
      localObject1 = paramArrayOfByte;
      m = paramInt1;
      paramInt1 = i1;
    }
    paramInt3 = m;
    paramObject = localObject3;
    paramArrayOfByte = (byte[])localObject2;
    m = paramInt1;
    label1671:
    if (i3 != 1048575) {
      localUnsafe.putInt(paramObject, i3, i2);
    }
    paramInt1 = size;
    while (paramInt1 < type)
    {
      i1 = p[paramInt1];
      i2 = i[i1];
      paramZziq = zzmx.getValue(paramObject, paramArrayOfByte.charAt(i1) & 0xFFFFF);
      if ((paramZziq == null) || (paramArrayOfByte.a(i1) == null))
      {
        paramInt1 += 1;
      }
      else
      {
        paramObject = (zzlf)paramZziq;
        paramObject = (zzle)paramArrayOfByte.get(i1);
        throw new NullPointerException("Null throw statement replaced by Soot");
      }
    }
    if (paramInt3 == 0)
    {
      if (m == paramInt2) {
        return m;
      }
      throw zzko.getSort();
    }
    if ((m <= paramInt2) && (j == paramInt3)) {
      return m;
    }
    throw zzko.getSort();
  }
  
  public final void a(Object paramObject, zznf paramZznf)
    throws IOException
  {
    if (d)
    {
      if (!c)
      {
        int m = i.length;
        int j = 0;
        while (j < m)
        {
          int i1 = charAt(j);
          int i2 = i[j];
          switch (b(i1))
          {
          default: 
            break;
          case 68: 
            if (get(paramObject, i2, j)) {
              paramZznf.put(i2, zzmx.getValue(paramObject, i1 & 0xFFFFF), toString(j));
            }
            break;
          case 67: 
            if (get(paramObject, i2, j)) {
              paramZznf.a(i2, get(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 66: 
            if (get(paramObject, i2, j)) {
              paramZznf.a(i2, getValue(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 65: 
            if (get(paramObject, i2, j)) {
              paramZznf.append(i2, get(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 64: 
            if (get(paramObject, i2, j)) {
              paramZznf.b(i2, getValue(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 63: 
            if (get(paramObject, i2, j)) {
              paramZznf.get(i2, getValue(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 62: 
            if (get(paramObject, i2, j)) {
              paramZznf.setProgress(i2, getValue(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 61: 
            if (get(paramObject, i2, j)) {
              paramZznf.put(i2, (zzjd)zzmx.getValue(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 60: 
            if (get(paramObject, i2, j)) {
              paramZznf.b(i2, zzmx.getValue(paramObject, i1 & 0xFFFFF), toString(j));
            }
            break;
          case 59: 
            if (get(paramObject, i2, j)) {
              put(i2, zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf);
            }
            break;
          case 58: 
            if (get(paramObject, i2, j)) {
              paramZznf.b(i2, toString(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 57: 
            if (get(paramObject, i2, j)) {
              paramZznf.put(i2, getValue(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 56: 
            if (get(paramObject, i2, j)) {
              paramZznf.put(i2, get(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 55: 
            if (get(paramObject, i2, j)) {
              paramZznf.append(i2, getValue(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 54: 
            if (get(paramObject, i2, j)) {
              paramZznf.b(i2, get(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 53: 
            if (get(paramObject, i2, j)) {
              paramZznf.get(i2, get(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 52: 
            if (get(paramObject, i2, j)) {
              paramZznf.a(i2, a(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 51: 
            if (get(paramObject, i2, j)) {
              paramZznf.a(i2, read(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 50: 
            put(paramZznf, i2, zzmx.getValue(paramObject, i1 & 0xFFFFF), j);
            break;
          case 49: 
            zzly.put(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, toString(j));
            break;
          case 48: 
            zzly.visitMethodInsn(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, true);
            break;
          case 47: 
            zzly.add(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, true);
            break;
          case 46: 
            zzly.put(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, true);
            break;
          case 45: 
            zzly.write(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, true);
            break;
          case 44: 
            zzly.toString(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, true);
            break;
          case 43: 
            zzly.finish(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, true);
            break;
          case 42: 
            zzly.indexOf(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, true);
            break;
          case 41: 
            zzly.a(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, true);
            break;
          case 40: 
            zzly.setProgress(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, true);
            break;
          case 39: 
            zzly.get(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, true);
            break;
          case 38: 
            zzly.connect(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, true);
            break;
          case 37: 
            zzly.b(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, true);
            break;
          case 36: 
            zzly.set(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, true);
            break;
          case 35: 
            zzly.append(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, true);
            break;
          case 34: 
            zzly.visitMethodInsn(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, false);
            break;
          case 33: 
            zzly.add(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, false);
            break;
          case 32: 
            zzly.put(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, false);
            break;
          case 31: 
            zzly.write(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, false);
            break;
          case 30: 
            zzly.toString(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, false);
            break;
          case 29: 
            zzly.finish(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, false);
            break;
          case 28: 
            zzly.a(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf);
            break;
          case 27: 
            zzly.a(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, toString(j));
            break;
          case 26: 
            zzly.b(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf);
            break;
          case 25: 
            zzly.indexOf(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, false);
            break;
          case 24: 
            zzly.a(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, false);
            break;
          case 23: 
            zzly.setProgress(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, false);
            break;
          case 22: 
            zzly.get(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, false);
            break;
          case 21: 
            zzly.connect(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, false);
            break;
          case 20: 
            zzly.b(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, false);
            break;
          case 19: 
            zzly.set(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, false);
            break;
          case 18: 
            zzly.append(i2, (List)zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf, false);
            break;
          case 17: 
            if (a(paramObject, j)) {
              paramZznf.put(i2, zzmx.getValue(paramObject, i1 & 0xFFFFF), toString(j));
            }
            break;
          case 16: 
            if (a(paramObject, j)) {
              paramZznf.a(i2, zzmx.toString(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 15: 
            if (a(paramObject, j)) {
              paramZznf.a(i2, zzmx.readInt(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 14: 
            if (a(paramObject, j)) {
              paramZznf.append(i2, zzmx.toString(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 13: 
            if (a(paramObject, j)) {
              paramZznf.b(i2, zzmx.readInt(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 12: 
            if (a(paramObject, j)) {
              paramZznf.get(i2, zzmx.readInt(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 11: 
            if (a(paramObject, j)) {
              paramZznf.setProgress(i2, zzmx.readInt(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 10: 
            if (a(paramObject, j)) {
              paramZznf.put(i2, (zzjd)zzmx.getValue(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 9: 
            if (a(paramObject, j)) {
              paramZznf.b(i2, zzmx.getValue(paramObject, i1 & 0xFFFFF), toString(j));
            }
            break;
          case 8: 
            if (a(paramObject, j)) {
              put(i2, zzmx.getValue(paramObject, i1 & 0xFFFFF), paramZznf);
            }
            break;
          case 7: 
            if (a(paramObject, j)) {
              paramZznf.b(i2, zzmx.c(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 6: 
            if (a(paramObject, j)) {
              paramZznf.put(i2, zzmx.readInt(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 5: 
            if (a(paramObject, j)) {
              paramZznf.put(i2, zzmx.toString(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 4: 
            if (a(paramObject, j)) {
              paramZznf.append(i2, zzmx.readInt(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 3: 
            if (a(paramObject, j)) {
              paramZznf.b(i2, zzmx.toString(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 2: 
            if (a(paramObject, j)) {
              paramZznf.get(i2, zzmx.toString(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 1: 
            if (a(paramObject, j)) {
              paramZznf.a(i2, zzmx.e(paramObject, i1 & 0xFFFFF));
            }
            break;
          case 0: 
            if (a(paramObject, j)) {
              paramZznf.a(i2, zzmx.d(paramObject, i1 & 0xFFFFF));
            }
            break;
          }
          j += 3;
        }
        zzmn localZzmn = x;
        localZzmn.subtract(localZzmn.getValue(paramObject), paramZznf);
        return;
      }
      b.invoke(paramObject);
      throw new NullPointerException("Null throw statement replaced by Soot");
    }
    run(paramObject, paramZznf);
  }
  
  public final void a(Object paramObject1, Object paramObject2)
  {
    Objects.requireNonNull(paramObject2);
    int j = 0;
    while (j < i.length)
    {
      int m = charAt(j);
      long l1 = 0xFFFFF & m;
      int i1 = i[j];
      switch (b(m))
      {
      default: 
        break;
      case 68: 
        a(paramObject1, paramObject2, j);
        break;
      case 61: 
      case 62: 
      case 63: 
      case 64: 
      case 65: 
      case 66: 
      case 67: 
        if (get(paramObject2, i1, j))
        {
          zzmx.add(paramObject1, l1, zzmx.getValue(paramObject2, l1));
          a(paramObject1, i1, j);
        }
        break;
      case 60: 
        a(paramObject1, paramObject2, j);
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
        if (get(paramObject2, i1, j))
        {
          zzmx.add(paramObject1, l1, zzmx.getValue(paramObject2, l1));
          a(paramObject1, i1, j);
        }
        break;
      case 50: 
        zzly.zzaa(n, paramObject1, paramObject2, l1);
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
        y.get(paramObject1, paramObject2, l1);
        break;
      case 17: 
        visit(paramObject1, paramObject2, j);
        break;
      case 16: 
        if (a(paramObject2, j))
        {
          zzmx.a(paramObject1, l1, zzmx.toString(paramObject2, l1));
          b(paramObject1, j);
        }
        break;
      case 15: 
        if (a(paramObject2, j))
        {
          zzmx.a(paramObject1, l1, zzmx.readInt(paramObject2, l1));
          b(paramObject1, j);
        }
        break;
      case 14: 
        if (a(paramObject2, j))
        {
          zzmx.a(paramObject1, l1, zzmx.toString(paramObject2, l1));
          b(paramObject1, j);
        }
        break;
      case 13: 
        if (a(paramObject2, j))
        {
          zzmx.a(paramObject1, l1, zzmx.readInt(paramObject2, l1));
          b(paramObject1, j);
        }
        break;
      case 12: 
        if (a(paramObject2, j))
        {
          zzmx.a(paramObject1, l1, zzmx.readInt(paramObject2, l1));
          b(paramObject1, j);
        }
        break;
      case 11: 
        if (a(paramObject2, j))
        {
          zzmx.a(paramObject1, l1, zzmx.readInt(paramObject2, l1));
          b(paramObject1, j);
        }
        break;
      case 10: 
        if (a(paramObject2, j))
        {
          zzmx.add(paramObject1, l1, zzmx.getValue(paramObject2, l1));
          b(paramObject1, j);
        }
        break;
      case 9: 
        visit(paramObject1, paramObject2, j);
        break;
      case 8: 
        if (a(paramObject2, j))
        {
          zzmx.add(paramObject1, l1, zzmx.getValue(paramObject2, l1));
          b(paramObject1, j);
        }
        break;
      case 7: 
        if (a(paramObject2, j))
        {
          zzmx.a(paramObject1, l1, zzmx.c(paramObject2, l1));
          b(paramObject1, j);
        }
        break;
      case 6: 
        if (a(paramObject2, j))
        {
          zzmx.a(paramObject1, l1, zzmx.readInt(paramObject2, l1));
          b(paramObject1, j);
        }
        break;
      case 5: 
        if (a(paramObject2, j))
        {
          zzmx.a(paramObject1, l1, zzmx.toString(paramObject2, l1));
          b(paramObject1, j);
        }
        break;
      case 4: 
        if (a(paramObject2, j))
        {
          zzmx.a(paramObject1, l1, zzmx.readInt(paramObject2, l1));
          b(paramObject1, j);
        }
        break;
      case 3: 
        if (a(paramObject2, j))
        {
          zzmx.a(paramObject1, l1, zzmx.toString(paramObject2, l1));
          b(paramObject1, j);
        }
        break;
      case 2: 
        if (a(paramObject2, j))
        {
          zzmx.a(paramObject1, l1, zzmx.toString(paramObject2, l1));
          b(paramObject1, j);
        }
        break;
      case 1: 
        if (a(paramObject2, j))
        {
          zzmx.a(paramObject1, l1, zzmx.e(paramObject2, l1));
          b(paramObject1, j);
        }
        break;
      case 0: 
        if (a(paramObject2, j))
        {
          zzmx.a(paramObject1, l1, zzmx.d(paramObject2, l1));
          b(paramObject1, j);
        }
        break;
      }
      j += 3;
    }
    zzly.operate(x, paramObject1, paramObject2);
    if (c) {
      zzly.invoke(b, paramObject1, paramObject2);
    }
  }
  
  public final void add(Object paramObject)
  {
    int j = size;
    int m;
    for (;;)
    {
      m = type;
      if (j >= m) {
        break;
      }
      long l1 = charAt(p[j]) & 0xFFFFF;
      Object localObject = zzmx.getValue(paramObject, l1);
      if (localObject != null)
      {
        ((zzlf)localObject).grow();
        zzmx.add(paramObject, l1, localObject);
      }
      j += 1;
    }
    int i1 = p.length;
    j = m;
    while (j < i1)
    {
      y.add(paramObject, p[j]);
      j += 1;
    }
    x.subtract(paramObject);
    if (c) {
      b.addLast(paramObject);
    }
  }
  
  public final int b(Object paramObject)
  {
    if (d) {
      return a(paramObject);
    }
    return write(paramObject);
  }
  
  public final void b(Object paramObject, byte[] paramArrayOfByte, int paramInt1, int paramInt2, zziq paramZziq)
    throws IOException
  {
    if (d)
    {
      a(paramObject, paramArrayOfByte, paramInt1, paramInt2, paramZziq);
      return;
    }
    a(paramObject, paramArrayOfByte, paramInt1, paramInt2, 0, paramZziq);
  }
  
  public final boolean b(Object paramObject1, Object paramObject2)
  {
    int m = i.length;
    int j = 0;
    while (j < m)
    {
      int i1 = charAt(j);
      long l1 = i1 & 0xFFFFF;
      boolean bool;
      switch (b(i1))
      {
      default: 
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
      case 60: 
      case 61: 
      case 62: 
      case 63: 
      case 64: 
      case 65: 
      case 66: 
      case 67: 
      case 68: 
        long l2 = c(j) & 0xFFFFF;
        if (zzmx.readInt(paramObject1, l2) != zzmx.readInt(paramObject2, l2)) {
          break label1226;
        }
        if (zzly.equals(zzmx.getValue(paramObject1, l1), zzmx.getValue(paramObject2, l1))) {
          break label1228;
        }
        return false;
      case 50: 
        bool = zzly.equals(zzmx.getValue(paramObject1, l1), zzmx.getValue(paramObject2, l1));
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
        bool = zzly.equals(zzmx.getValue(paramObject1, l1), zzmx.getValue(paramObject2, l1));
        if (bool) {
          break label1228;
        }
        return false;
      case 17: 
        if ((!f(paramObject1, paramObject2, j)) || (!zzly.equals(zzmx.getValue(paramObject1, l1), zzmx.getValue(paramObject2, l1)))) {
          break label1297;
        }
        break;
      case 16: 
        if ((!f(paramObject1, paramObject2, j)) || (zzmx.toString(paramObject1, l1) != zzmx.toString(paramObject2, l1))) {
          break label1297;
        }
        break;
      case 15: 
        if ((!f(paramObject1, paramObject2, j)) || (zzmx.readInt(paramObject1, l1) != zzmx.readInt(paramObject2, l1))) {
          break label1297;
        }
        break;
      case 14: 
        if ((!f(paramObject1, paramObject2, j)) || (zzmx.toString(paramObject1, l1) != zzmx.toString(paramObject2, l1))) {
          break label1297;
        }
        break;
      case 13: 
        if ((!f(paramObject1, paramObject2, j)) || (zzmx.readInt(paramObject1, l1) != zzmx.readInt(paramObject2, l1))) {
          break label1297;
        }
        break;
      case 12: 
        if ((!f(paramObject1, paramObject2, j)) || (zzmx.readInt(paramObject1, l1) != zzmx.readInt(paramObject2, l1))) {
          break label1297;
        }
        break;
      case 11: 
        if ((!f(paramObject1, paramObject2, j)) || (zzmx.readInt(paramObject1, l1) != zzmx.readInt(paramObject2, l1))) {
          break label1297;
        }
        break;
      case 10: 
        if ((!f(paramObject1, paramObject2, j)) || (!zzly.equals(zzmx.getValue(paramObject1, l1), zzmx.getValue(paramObject2, l1)))) {
          break label1297;
        }
        break;
      case 9: 
        if ((!f(paramObject1, paramObject2, j)) || (!zzly.equals(zzmx.getValue(paramObject1, l1), zzmx.getValue(paramObject2, l1)))) {
          break label1297;
        }
        break;
      case 8: 
        if ((!f(paramObject1, paramObject2, j)) || (!zzly.equals(zzmx.getValue(paramObject1, l1), zzmx.getValue(paramObject2, l1)))) {
          break label1297;
        }
        break;
      case 7: 
        if ((!f(paramObject1, paramObject2, j)) || (zzmx.c(paramObject1, l1) != zzmx.c(paramObject2, l1))) {
          break label1297;
        }
        break;
      case 6: 
        if ((!f(paramObject1, paramObject2, j)) || (zzmx.readInt(paramObject1, l1) != zzmx.readInt(paramObject2, l1))) {
          break label1297;
        }
        break;
      case 5: 
        if ((!f(paramObject1, paramObject2, j)) || (zzmx.toString(paramObject1, l1) != zzmx.toString(paramObject2, l1))) {
          break label1297;
        }
        break;
      case 4: 
        if ((!f(paramObject1, paramObject2, j)) || (zzmx.readInt(paramObject1, l1) != zzmx.readInt(paramObject2, l1))) {
          break label1297;
        }
        break;
      case 3: 
        if ((!f(paramObject1, paramObject2, j)) || (zzmx.toString(paramObject1, l1) != zzmx.toString(paramObject2, l1))) {
          break label1297;
        }
        break;
      case 2: 
        if ((!f(paramObject1, paramObject2, j)) || (zzmx.toString(paramObject1, l1) != zzmx.toString(paramObject2, l1))) {
          break label1297;
        }
        break;
      case 1: 
        if ((!f(paramObject1, paramObject2, j)) || (Float.floatToIntBits(zzmx.e(paramObject1, l1)) != Float.floatToIntBits(zzmx.e(paramObject2, l1)))) {
          break label1297;
        }
        break;
      }
      if ((!f(paramObject1, paramObject2, j)) || (Double.doubleToLongBits(zzmx.d(paramObject1, l1)) != Double.doubleToLongBits(zzmx.d(paramObject2, l1)))) {
        break label1297;
      }
      break label1228;
      label1226:
      return false;
      label1228:
      j += 3;
    }
    if (!x.getValue(paramObject1).equals(x.getValue(paramObject2))) {
      return false;
    }
    if (!c) {
      return true;
    }
    b.invoke(paramObject1);
    b.invoke(paramObject2);
    throw new NullPointerException("Null throw statement replaced by Soot");
    label1297:
    return false;
  }
  
  public final Object c()
  {
    return ((zzke)l).Decode(4, null, null);
  }
  
  public final int doInBackground(Object paramObject)
  {
    int i2 = i.length;
    int i1 = 0;
    for (int m = 0; i1 < i2; m = j)
    {
      j = charAt(i1);
      int i3 = i[i1];
      long l1 = 0xFFFFF & j;
      int i4 = b(j);
      j = 37;
      Object localObject;
      switch (i4)
      {
      default: 
        j = m;
        break;
      case 68: 
        j = m;
        if (!get(paramObject, i3, i1)) {
          break label1552;
        }
        j = m * 53;
        m = zzmx.getValue(paramObject, l1).hashCode();
        break;
      case 67: 
        j = m;
        if (!get(paramObject, i3, i1)) {
          break label1552;
        }
        j = m * 53;
        m = zzkm.hash(get(paramObject, l1));
        break;
      case 66: 
        j = m;
        if (!get(paramObject, i3, i1)) {
          break label1552;
        }
        j = m * 53;
        m = getValue(paramObject, l1);
        break;
      case 65: 
        j = m;
        if (!get(paramObject, i3, i1)) {
          break label1552;
        }
        j = m * 53;
        m = zzkm.hash(get(paramObject, l1));
        break;
      case 64: 
        j = m;
        if (!get(paramObject, i3, i1)) {
          break label1552;
        }
        j = m * 53;
        m = getValue(paramObject, l1);
        break;
      case 63: 
        j = m;
        if (!get(paramObject, i3, i1)) {
          break label1552;
        }
        j = m * 53;
        m = getValue(paramObject, l1);
        break;
      case 62: 
        j = m;
        if (!get(paramObject, i3, i1)) {
          break label1552;
        }
        j = m * 53;
        m = getValue(paramObject, l1);
        break;
      case 61: 
        j = m;
        if (!get(paramObject, i3, i1)) {
          break label1552;
        }
        j = m * 53;
        m = zzmx.getValue(paramObject, l1).hashCode();
        break;
      case 60: 
        j = m;
        if (!get(paramObject, i3, i1)) {
          break label1552;
        }
        j = m * 53;
        m = zzmx.getValue(paramObject, l1).hashCode();
        break;
      case 59: 
        j = m;
        if (!get(paramObject, i3, i1)) {
          break label1552;
        }
        j = m * 53;
        m = ((String)zzmx.getValue(paramObject, l1)).hashCode();
        break;
      case 58: 
        j = m;
        if (!get(paramObject, i3, i1)) {
          break label1552;
        }
        j = m * 53;
        m = zzkm.hashCode(toString(paramObject, l1));
        break;
      case 57: 
        j = m;
        if (!get(paramObject, i3, i1)) {
          break label1552;
        }
        j = m * 53;
        m = getValue(paramObject, l1);
        break;
      case 56: 
        j = m;
        if (!get(paramObject, i3, i1)) {
          break label1552;
        }
        j = m * 53;
        m = zzkm.hash(get(paramObject, l1));
        break;
      case 55: 
        j = m;
        if (!get(paramObject, i3, i1)) {
          break label1552;
        }
        j = m * 53;
        m = getValue(paramObject, l1);
        break;
      case 54: 
        j = m;
        if (!get(paramObject, i3, i1)) {
          break label1552;
        }
        j = m * 53;
        m = zzkm.hash(get(paramObject, l1));
        break;
      case 53: 
        j = m;
        if (!get(paramObject, i3, i1)) {
          break label1552;
        }
        j = m * 53;
        m = zzkm.hash(get(paramObject, l1));
        break;
      case 52: 
        j = m;
        if (!get(paramObject, i3, i1)) {
          break label1552;
        }
        j = m * 53;
        m = Float.floatToIntBits(a(paramObject, l1));
        break;
      case 51: 
        j = m;
        if (!get(paramObject, i3, i1)) {
          break label1552;
        }
        j = m * 53;
        m = zzkm.hash(Double.doubleToLongBits(read(paramObject, l1)));
        break;
      case 50: 
        j = m * 53;
        m = zzmx.getValue(paramObject, l1).hashCode();
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
        j = m * 53;
        m = zzmx.getValue(paramObject, l1).hashCode();
        break;
      case 17: 
        localObject = zzmx.getValue(paramObject, l1);
        if (localObject != null) {
          j = localObject.hashCode();
        }
        break;
      case 16: 
        j = m * 53;
        m = zzkm.hash(zzmx.toString(paramObject, l1));
        break;
      case 15: 
        j = m * 53;
        m = zzmx.readInt(paramObject, l1);
        break;
      case 14: 
        j = m * 53;
        m = zzkm.hash(zzmx.toString(paramObject, l1));
        break;
      case 13: 
        j = m * 53;
        m = zzmx.readInt(paramObject, l1);
        break;
      case 12: 
        j = m * 53;
        m = zzmx.readInt(paramObject, l1);
        break;
      case 11: 
        j = m * 53;
        m = zzmx.readInt(paramObject, l1);
        break;
      case 10: 
        j = m * 53;
        m = zzmx.getValue(paramObject, l1).hashCode();
        break;
      case 9: 
        localObject = zzmx.getValue(paramObject, l1);
        if (localObject != null) {
          j = localObject.hashCode();
        }
        j = m * 53 + j;
        break;
      case 8: 
        j = m * 53;
        m = ((String)zzmx.getValue(paramObject, l1)).hashCode();
        break;
      case 7: 
        j = m * 53;
        m = zzkm.hashCode(zzmx.c(paramObject, l1));
        break;
      case 6: 
        j = m * 53;
        m = zzmx.readInt(paramObject, l1);
        break;
      case 5: 
        j = m * 53;
        m = zzkm.hash(zzmx.toString(paramObject, l1));
        break;
      case 4: 
        j = m * 53;
        m = zzmx.readInt(paramObject, l1);
        break;
      case 3: 
        j = m * 53;
        m = zzkm.hash(zzmx.toString(paramObject, l1));
        break;
      case 2: 
        j = m * 53;
        m = zzkm.hash(zzmx.toString(paramObject, l1));
        break;
      case 1: 
        j = m * 53;
        m = Float.floatToIntBits(zzmx.e(paramObject, l1));
        break;
      }
      j = m * 53;
      m = zzkm.hash(Double.doubleToLongBits(zzmx.d(paramObject, l1)));
      j += m;
      label1552:
      i1 += 3;
    }
    int j = x.getValue(paramObject).hashCode();
    if (!c) {
      return m * 53 + j;
    }
    b.invoke(paramObject);
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final boolean parse(Object paramObject)
  {
    int i3 = 1048575;
    int j = 0;
    int m = 0;
    while (m < size)
    {
      int i5 = p[m];
      int i6 = i[i5];
      int i7 = charAt(i5);
      int i1 = i[(i5 + 2)];
      int i4 = i1 & 0xFFFFF;
      int i8 = 1 << (i1 >>> 20);
      i1 = i3;
      int i2 = j;
      if (i4 != i3)
      {
        if (i4 != 1048575) {
          j = r.getInt(paramObject, i4);
        }
        i1 = i4;
        i2 = j;
      }
      if (((0x10000000 & i7) != 0) && (!add(paramObject, i5, i1, i2, i8))) {
        return false;
      }
      j = b(i7);
      List localList;
      zzlw localZzlw;
      if ((j != 9) && (j != 17))
      {
        if (j != 27) {
          if ((j != 60) && (j != 68))
          {
            if (j != 49)
            {
              if ((j != 50) || (((zzlf)zzmx.getValue(paramObject, i7 & 0xFFFFF)).isEmpty())) {
                break label371;
              }
              paramObject = (zzle)get(i5);
              throw new NullPointerException("Null throw statement replaced by Soot");
            }
          }
          else
          {
            if ((!get(paramObject, i6, i5)) || (parse(paramObject, i7, toString(i5)))) {
              break label371;
            }
            return false;
          }
        }
        localList = (List)zzmx.getValue(paramObject, i7 & 0xFFFFF);
        if (!localList.isEmpty())
        {
          localZzlw = toString(i5);
          j = 0;
        }
      }
      else
      {
        while (j < localList.size())
        {
          if (!localZzlw.parse(localList.get(j))) {
            return false;
          }
          j += 1;
          continue;
          if ((add(paramObject, i5, i1, i2, i8)) && (!parse(paramObject, i7, toString(i5)))) {
            return false;
          }
        }
      }
      label371:
      m += 1;
      i3 = i1;
      j = i2;
    }
    if (!c) {
      return true;
    }
    b.invoke(paramObject);
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
}
