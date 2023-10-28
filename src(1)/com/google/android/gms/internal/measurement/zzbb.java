package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class zzbb
{
  private static zzae parse(zzae paramZzae, Headers paramHeaders, zzai paramZzai, Boolean paramBoolean1, Boolean paramBoolean2)
  {
    zzae localZzae = new zzae();
    Iterator localIterator = paramZzae.getValues();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if (paramZzae.remove(i))
      {
        zzap localZzap = paramZzai.get(paramHeaders, Arrays.asList(new zzap[] { paramZzae.get(i), new zzah(Double.valueOf(i)), paramZzae }));
        if (localZzap.value().equals(paramBoolean1)) {
          return localZzae;
        }
        if ((paramBoolean2 == null) || (localZzap.value().equals(paramBoolean2))) {
          localZzae.add(i, localZzap);
        }
      }
    }
    return localZzae;
  }
  
  private static zzap parse(zzae paramZzae, Headers paramHeaders, List paramList, boolean paramBoolean)
  {
    ByteVector.add("reduce", 1, paramList);
    ByteVector.put("reduce", 2, paramList);
    Object localObject2 = paramHeaders.get((zzap)paramList.get(0));
    if ((localObject2 instanceof zzai))
    {
      if (paramList.size() == 2)
      {
        localObject1 = paramHeaders.get((zzap)paramList.get(1));
        paramList = (List)localObject1;
        if ((localObject1 instanceof zzag)) {
          throw new IllegalArgumentException("Failed to parse initial value");
        }
      }
      else
      {
        if (paramZzae.next() == 0) {
          break label329;
        }
        paramList = null;
      }
      localObject2 = (zzai)localObject2;
      int j = paramZzae.next();
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = j - 1;
      }
      int k = -1;
      if (paramBoolean) {
        j -= 1;
      } else {
        j = 0;
      }
      if (true == paramBoolean) {
        k = 1;
      }
      int m = i;
      Object localObject1 = paramList;
      int n = j;
      int i1 = k;
      if (paramList == null) {
        paramList = paramZzae.get(i);
      }
      while ((n - m) * i1 >= 0)
      {
        i = m;
        paramList = (List)localObject1;
        j = n;
        k = i1;
        if (paramZzae.remove(m))
        {
          localObject1 = ((zzai)localObject2).get(paramHeaders, Arrays.asList(new zzap[] { localObject1, paramZzae.get(m), new zzah(Double.valueOf(m)), paramZzae }));
          paramList = (List)localObject1;
          if (!(localObject1 instanceof zzag))
          {
            i = m;
            j = n;
            k = i1;
          }
          else
          {
            throw new IllegalStateException("Reduce operation failed");
          }
        }
        m = i + k;
        localObject1 = paramList;
        n = j;
        i1 = k;
      }
      return localObject1;
      label329:
      throw new IllegalStateException("Empty array with no initial value error");
    }
    throw new IllegalArgumentException("Callback should be a method");
  }
  
  public static zzap parse(String paramString, zzae paramZzae, Headers paramHeaders, List paramList)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    }
    for (;;)
    {
      break;
      if (paramString.equals("indexOf"))
      {
        i = 4;
        if (paramString.equals("reverse"))
        {
          i = 12;
          if (paramString.equals("reduceRight"))
          {
            i = 11;
            if (paramString.equals("slice"))
            {
              i = 14;
              if (paramString.equals("shift"))
              {
                i = 13;
                if (paramString.equals("every"))
                {
                  i = 1;
                  break label499;
                  if (paramString.equals("sort"))
                  {
                    i = 16;
                    if (paramString.equals("some"))
                    {
                      i = 15;
                      if (paramString.equals("push"))
                      {
                        i = 9;
                        if (paramString.equals("join"))
                        {
                          i = 5;
                          if (paramString.equals("pop"))
                          {
                            i = 8;
                            if (paramString.equals("map"))
                            {
                              i = 7;
                              if (paramString.equals("unshift"))
                              {
                                i = 19;
                                if (paramString.equals("lastIndexOf"))
                                {
                                  i = 6;
                                  if (paramString.equals("forEach"))
                                  {
                                    i = 3;
                                    if (paramString.equals("splice"))
                                    {
                                      i = 17;
                                      if (paramString.equals("reduce"))
                                      {
                                        i = 10;
                                        break label499;
                                        if (paramString.equals("filter"))
                                        {
                                          i = 2;
                                          break label499;
                                          if (paramString.equals("concat"))
                                          {
                                            i = 0;
                                            break label499;
                                            if (paramString.equals("toString"))
                                            {
                                              i = 18;
                                              break label499;
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
    int i = -1;
    label499:
    double d1 = 0.0D;
    Object localObject;
    int j;
    int k;
    label1226:
    double d2;
    switch (i)
    {
    default: 
      throw new IllegalArgumentException("Command not supported");
    case 19: 
      if (!paramList.isEmpty())
      {
        paramString = new zzae();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = paramHeaders.get((zzap)paramList.next());
          if (!(localObject instanceof zzag)) {
            paramString.add(paramString.next(), (zzap)localObject);
          } else {
            throw new IllegalStateException("Argument evaluation failed");
          }
        }
        i = paramString.next();
        paramHeaders = paramZzae.getValues();
        while (paramHeaders.hasNext())
        {
          paramList = (Integer)paramHeaders.next();
          paramString.add(paramList.intValue() + i, paramZzae.get(paramList.intValue()));
        }
        paramZzae.seek();
        paramHeaders = paramString.getValues();
        while (paramHeaders.hasNext())
        {
          paramList = (Integer)paramHeaders.next();
          paramZzae.add(paramList.intValue(), paramString.get(paramList.intValue()));
        }
      }
      return new zzah(Double.valueOf(paramZzae.next()));
    case 18: 
      ByteVector.set("toString", 0, paramList);
      return new zzat(paramZzae.format(","));
    case 17: 
      if (paramList.isEmpty()) {
        return new zzae();
      }
      j = (int)ByteVector.pow(paramHeaders.get((zzap)paramList.get(0)).get().doubleValue());
      if (j < 0)
      {
        i = Math.max(0, j + paramZzae.next());
      }
      else
      {
        i = j;
        if (j > paramZzae.next()) {
          i = paramZzae.next();
        }
      }
      k = paramZzae.next();
      paramString = new zzae();
      j = i;
      if (paramList.size() > 1)
      {
        int m = Math.max(0, (int)ByteVector.pow(paramHeaders.get((zzap)paramList.get(1)).get().doubleValue()));
        if (m > 0)
        {
          j = i;
          while (j < Math.min(k, i + m))
          {
            localObject = paramZzae.get(i);
            paramString.add(paramString.next(), (zzap)localObject);
            paramZzae.add(i);
            j += 1;
          }
        }
        if (paramList.size() > 2)
        {
          j = 2;
          for (;;)
          {
            if (j >= paramList.size()) {
              break label1226;
            }
            localObject = paramHeaders.get((zzap)paramList.get(j));
            if ((localObject instanceof zzag)) {
              break;
            }
            paramZzae.build(i + j - 2, (zzap)localObject);
            j += 1;
          }
          throw new IllegalArgumentException("Failed to parse elements to add");
        }
      }
      else
      {
        while (j < k)
        {
          paramHeaders = paramZzae.get(j);
          paramString.add(paramString.next(), paramHeaders);
          paramZzae.add(j, null);
          j += 1;
        }
      }
      return paramString;
    case 16: 
      ByteVector.put("sort", 1, paramList);
      if (paramZzae.next() < 2) {
        return paramZzae;
      }
      localObject = paramZzae.getList();
      if (!paramList.isEmpty())
      {
        paramString = paramHeaders.get((zzap)paramList.get(0));
        if ((paramString instanceof zzai)) {
          paramString = (zzai)paramString;
        } else {
          throw new IllegalArgumentException("Comparator should be a method");
        }
      }
      else
      {
        paramString = null;
      }
      Collections.sort((List)localObject, new zzba(paramString, paramHeaders));
      paramZzae.seek();
      paramString = ((List)localObject).iterator();
      i = 0;
      while (paramString.hasNext())
      {
        paramZzae.add(i, (zzap)paramString.next());
        i += 1;
      }
      return paramZzae;
    case 15: 
      ByteVector.set("some", 1, paramList);
      paramString = paramHeaders.get((zzap)paramList.get(0));
      if ((paramString instanceof zzai))
      {
        if (paramZzae.next() == 0) {
          return zzap.FALSE;
        }
        paramString = (zzai)paramString;
        paramList = paramZzae.getValues();
        while (paramList.hasNext())
        {
          i = ((Integer)paramList.next()).intValue();
          if (paramZzae.remove(i)) {
            if (paramString.get(paramHeaders, Arrays.asList(new zzap[] { paramZzae.get(i), new zzah(Double.valueOf(i)), paramZzae })).value().booleanValue()) {
              return zzap.TRUE;
            }
          }
        }
        return zzap.FALSE;
      }
      throw new IllegalArgumentException("Callback should be a method");
    case 14: 
      ByteVector.put("slice", 2, paramList);
      if (paramList.isEmpty()) {
        return paramZzae.multiply();
      }
      double d3 = paramZzae.next();
      d1 = ByteVector.pow(paramHeaders.get((zzap)paramList.get(0)).get().doubleValue());
      if (d1 < 0.0D) {
        d2 = Math.max(d1 + d3, 0.0D);
      } else {
        d2 = Math.min(d1, d3);
      }
      d1 = d3;
      if (paramList.size() == 2)
      {
        d1 = ByteVector.pow(paramHeaders.get((zzap)paramList.get(1)).get().doubleValue());
        if (d1 < 0.0D) {
          d1 = Math.max(d3 + d1, 0.0D);
        } else {
          d1 = Math.min(d3, d1);
        }
      }
      paramString = new zzae();
      i = (int)d2;
      while (i < d1)
      {
        paramHeaders = paramZzae.get(i);
        paramString.add(paramString.next(), paramHeaders);
        i += 1;
      }
      return paramString;
    case 13: 
      ByteVector.set("shift", 0, paramList);
      if (paramZzae.next() == 0) {
        return zzap.this$0;
      }
      paramString = paramZzae.get(0);
      paramZzae.add(0);
      return paramString;
    case 12: 
      ByteVector.set("reverse", 0, paramList);
      j = paramZzae.next();
      if (j != 0)
      {
        i = 0;
        while (i < j / 2)
        {
          if (paramZzae.remove(i))
          {
            paramString = paramZzae.get(i);
            paramZzae.add(i, null);
            k = j - 1 - i;
            if (paramZzae.remove(k)) {
              paramZzae.add(i, paramZzae.get(k));
            }
            paramZzae.add(k, paramString);
          }
          i += 1;
        }
      }
      return paramZzae;
    case 11: 
      return parse(paramZzae, paramHeaders, paramList, false);
    case 10: 
      return parse(paramZzae, paramHeaders, paramList, true);
    case 9: 
      if (!paramList.isEmpty())
      {
        paramString = paramList.iterator();
        while (paramString.hasNext())
        {
          paramList = paramHeaders.get((zzap)paramString.next());
          paramZzae.add(paramZzae.next(), paramList);
        }
      }
      return new zzah(Double.valueOf(paramZzae.next()));
    case 8: 
      ByteVector.set("pop", 0, paramList);
      i = paramZzae.next();
      if (i == 0) {
        return zzap.this$0;
      }
      i -= 1;
      paramString = paramZzae.get(i);
      paramZzae.add(i);
      return paramString;
    case 7: 
      ByteVector.set("map", 1, paramList);
      paramString = paramHeaders.get((zzap)paramList.get(0));
      if ((paramString instanceof zzao))
      {
        if (paramZzae.next() == 0) {
          return new zzae();
        }
        return parse(paramZzae, paramHeaders, (zzao)paramString, null, null);
      }
      throw new IllegalArgumentException("Callback should be a method");
    case 6: 
      ByteVector.put("lastIndexOf", 2, paramList);
      paramString = zzap.this$0;
      if (!paramList.isEmpty()) {
        paramString = paramHeaders.get((zzap)paramList.get(0));
      }
      d2 = paramZzae.next() - 1;
      if (paramList.size() > 1)
      {
        paramHeaders = paramHeaders.get((zzap)paramList.get(1));
        if (Double.isNaN(paramHeaders.get().doubleValue())) {
          d1 = paramZzae.next() - 1;
        } else {
          d1 = ByteVector.pow(paramHeaders.get().doubleValue());
        }
        d2 = d1;
        if (d1 < 0.0D) {
          d2 = d1 + paramZzae.next();
        }
      }
      if (d2 < 0.0D) {
        return new zzah(Double.valueOf(-1.0D));
      }
      i = (int)Math.min(paramZzae.next(), d2);
      while (i >= 0)
      {
        if ((paramZzae.remove(i)) && (ByteVector.add(paramZzae.get(i), paramString))) {
          return new zzah(Double.valueOf(i));
        }
        i -= 1;
      }
      return new zzah(Double.valueOf(-1.0D));
    case 5: 
      ByteVector.put("join", 1, paramList);
      if (paramZzae.next() == 0) {
        return zzap.list;
      }
      if (!paramList.isEmpty())
      {
        paramString = paramHeaders.get((zzap)paramList.get(0));
        if ((!(paramString instanceof zzan)) && (!(paramString instanceof zzau))) {
          paramString = paramString.getValue();
        } else {
          paramString = "";
        }
      }
      else
      {
        paramString = ",";
      }
      return new zzat(paramZzae.format(paramString));
    case 4: 
      ByteVector.put("indexOf", 2, paramList);
      paramString = zzap.this$0;
      if (!paramList.isEmpty()) {
        paramString = paramHeaders.get((zzap)paramList.get(0));
      }
      if (paramList.size() > 1)
      {
        d2 = ByteVector.pow(paramHeaders.get((zzap)paramList.get(1)).get().doubleValue());
        if (d2 >= paramZzae.next()) {
          return new zzah(Double.valueOf(-1.0D));
        }
        d1 = d2;
        if (d2 < 0.0D) {
          d1 = paramZzae.next() + d2;
        }
      }
      paramHeaders = paramZzae.getValues();
      while (paramHeaders.hasNext())
      {
        i = ((Integer)paramHeaders.next()).intValue();
        d2 = i;
        if ((d2 >= d1) && (ByteVector.add(paramZzae.get(i), paramString))) {
          return new zzah(Double.valueOf(d2));
        }
      }
      return new zzah(Double.valueOf(-1.0D));
    case 3: 
      ByteVector.set("forEach", 1, paramList);
      paramString = paramHeaders.get((zzap)paramList.get(0));
      if ((paramString instanceof zzao))
      {
        if (paramZzae.remove() == 0) {
          return zzap.this$0;
        }
        parse(paramZzae, paramHeaders, (zzao)paramString, null, null);
        return zzap.this$0;
      }
      throw new IllegalArgumentException("Callback should be a method");
    case 2: 
      ByteVector.set("filter", 1, paramList);
      paramList = paramHeaders.get((zzap)paramList.get(0));
      if ((paramList instanceof zzao))
      {
        if (paramZzae.remove() == 0) {
          return new zzae();
        }
        paramString = paramZzae.multiply();
        paramHeaders = parse(paramZzae, paramHeaders, (zzao)paramList, null, Boolean.TRUE);
        paramZzae = new zzae();
        paramHeaders = paramHeaders.getValues();
        while (paramHeaders.hasNext())
        {
          i = ((Integer)paramHeaders.next()).intValue();
          paramList = ((zzae)paramString).get(i);
          paramZzae.add(paramZzae.next(), paramList);
        }
        return paramZzae;
      }
      throw new IllegalArgumentException("Callback should be a method");
    case 1: 
      ByteVector.set("every", 1, paramList);
      paramString = paramHeaders.get((zzap)paramList.get(0));
      if ((paramString instanceof zzao))
      {
        if (paramZzae.next() == 0) {
          return zzap.TRUE;
        }
        if (parse(paramZzae, paramHeaders, (zzao)paramString, Boolean.FALSE, Boolean.TRUE).next() != paramZzae.next()) {
          return zzap.FALSE;
        }
        return zzap.TRUE;
      }
      throw new IllegalArgumentException("Callback should be a method");
    }
    paramString = paramZzae.multiply();
    if (!paramList.isEmpty())
    {
      paramZzae = paramList.iterator();
      for (;;)
      {
        if (!paramZzae.hasNext()) {
          return paramString;
        }
        localObject = paramHeaders.get((zzap)paramZzae.next());
        if ((localObject instanceof zzag)) {
          break;
        }
        paramList = (zzae)paramString;
        i = paramList.next();
        if ((localObject instanceof zzae))
        {
          localObject = (zzae)localObject;
          Iterator localIterator = ((zzae)localObject).getValues();
          while (localIterator.hasNext())
          {
            Integer localInteger = (Integer)localIterator.next();
            paramList.add(localInteger.intValue() + i, ((zzae)localObject).get(localInteger.intValue()));
          }
        }
        else
        {
          paramList.add(i, (zzap)localObject);
        }
      }
      throw new IllegalStateException("Failed evaluation of arguments");
      return paramZzae;
    }
    return paramString;
  }
}
