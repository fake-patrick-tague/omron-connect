package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public final class zzae
  implements Iterable, zzap, zzal
{
  final Map members = new TreeMap();
  final SortedMap this$0 = new TreeMap();
  
  public zzae() {}
  
  public zzae(List paramList)
  {
    this();
    if (paramList != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        add(i, (zzap)paramList.get(i));
        i += 1;
      }
    }
  }
  
  public final void add(int paramInt)
  {
    int j = ((Integer)this$0.lastKey()).intValue();
    if (paramInt <= j)
    {
      if (paramInt < 0) {
        return;
      }
      this$0.remove(Integer.valueOf(paramInt));
      int i = paramInt;
      Object localObject1;
      Object localObject2;
      if (paramInt == j)
      {
        localObject1 = this$0;
        paramInt -= 1;
        localObject2 = Integer.valueOf(paramInt);
        if ((!((SortedMap)localObject1).containsKey(localObject2)) && (paramInt >= 0)) {
          this$0.put(localObject2, zzap.this$0);
        }
      }
      else
      {
        for (;;)
        {
          paramInt = i + 1;
          if (paramInt > ((Integer)this$0.lastKey()).intValue()) {
            break;
          }
          localObject2 = this$0;
          localObject1 = Integer.valueOf(paramInt);
          localObject2 = (zzap)((SortedMap)localObject2).get(localObject1);
          i = paramInt;
          if (localObject2 != null)
          {
            this$0.put(Integer.valueOf(paramInt - 1), localObject2);
            this$0.remove(localObject1);
            i = paramInt;
          }
        }
      }
    }
  }
  
  public final void add(int paramInt, zzap paramZzap)
  {
    if (paramInt <= 32468)
    {
      if (paramInt >= 0)
      {
        if (paramZzap == null)
        {
          this$0.remove(Integer.valueOf(paramInt));
          return;
        }
        this$0.put(Integer.valueOf(paramInt), paramZzap);
        return;
      }
      paramZzap = new StringBuilder();
      paramZzap.append("Out of bounds index: ");
      paramZzap.append(paramInt);
      throw new IndexOutOfBoundsException(paramZzap.toString());
    }
    throw new IllegalStateException("Array too large");
  }
  
  public final void add(String paramString, zzap paramZzap)
  {
    if (paramZzap == null)
    {
      members.remove(paramString);
      return;
    }
    members.put(paramString, paramZzap);
  }
  
  public final void build(int paramInt, zzap paramZzap)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= next())
      {
        add(paramInt, paramZzap);
        return;
      }
      int i = ((Integer)this$0.lastKey()).intValue();
      while (i >= paramInt)
      {
        Object localObject = this$0;
        Integer localInteger = Integer.valueOf(i);
        localObject = (zzap)((SortedMap)localObject).get(localInteger);
        if (localObject != null)
        {
          add(i + 1, (zzap)localObject);
          this$0.remove(localInteger);
        }
        i -= 1;
      }
      add(paramInt, paramZzap);
      return;
    }
    paramZzap = new StringBuilder();
    paramZzap.append("Invalid value index: ");
    paramZzap.append(paramInt);
    throw new IllegalArgumentException(paramZzap.toString());
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzae)) {
      return false;
    }
    paramObject = (zzae)paramObject;
    if (next() != paramObject.next()) {
      return false;
    }
    if (this$0.isEmpty()) {
      return this$0.isEmpty();
    }
    int i = ((Integer)this$0.firstKey()).intValue();
    while (i <= ((Integer)this$0.lastKey()).intValue())
    {
      if (!get(i).equals(paramObject.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public final String format(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new StringBuilder();
    if (!this$0.isEmpty())
    {
      int i = 0;
      while (i < next())
      {
        zzap localZzap = get(i);
        paramString.append(str);
        if ((!(localZzap instanceof zzau)) && (!(localZzap instanceof zzan))) {
          paramString.append(localZzap.getValue());
        }
        i += 1;
      }
      paramString.delete(0, str.length());
    }
    return paramString.toString();
  }
  
  public final zzap get(int paramInt)
  {
    if (paramInt < next())
    {
      if (remove(paramInt))
      {
        zzap localZzap = (zzap)this$0.get(Integer.valueOf(paramInt));
        if (localZzap != null) {
          return localZzap;
        }
      }
      return zzap.this$0;
    }
    throw new IndexOutOfBoundsException("Attempting to get element outside of current array");
  }
  
  public final zzap get(String paramString)
  {
    if ("length".equals(paramString)) {
      return new zzah(Double.valueOf(next()));
    }
    if (has(paramString))
    {
      paramString = (zzap)members.get(paramString);
      if (paramString != null) {
        return paramString;
      }
    }
    return zzap.this$0;
  }
  
  public final Double get()
  {
    if (this$0.size() == 1) {
      return get(0).get();
    }
    if (this$0.size() <= 0) {
      return Double.valueOf(0.0D);
    }
    return Double.valueOf(NaN.0D);
  }
  
  public final List getList()
  {
    ArrayList localArrayList = new ArrayList(next());
    int i = 0;
    while (i < next())
    {
      localArrayList.add(get(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public final String getValue()
  {
    return format(",");
  }
  
  public final Iterator getValues()
  {
    return this$0.keySet().iterator();
  }
  
  public final boolean has(String paramString)
  {
    return ("length".equals(paramString)) || (members.containsKey(paramString));
  }
  
  public final int hashCode()
  {
    return this$0.hashCode() * 31;
  }
  
  public final Iterator iterator()
  {
    return new zzad(this);
  }
  
  public final zzap multiply()
  {
    zzae localZzae = new zzae();
    Iterator localIterator = this$0.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry.getValue() instanceof zzal)) {
        this$0.put((Integer)localEntry.getKey(), (zzap)localEntry.getValue());
      } else {
        this$0.put((Integer)localEntry.getKey(), ((zzap)localEntry.getValue()).multiply());
      }
    }
    return localZzae;
  }
  
  public final int next()
  {
    if (this$0.isEmpty()) {
      return 0;
    }
    return ((Integer)this$0.lastKey()).intValue() + 1;
  }
  
  public final int remove()
  {
    return this$0.size();
  }
  
  public final boolean remove(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= ((Integer)this$0.lastKey()).intValue())) {
      return this$0.containsKey(Integer.valueOf(paramInt));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Out of bounds index: ");
    localStringBuilder.append(paramInt);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public final void seek()
  {
    this$0.clear();
  }
  
  public final String toString()
  {
    return format(",");
  }
  
  public final Iterator toXml()
  {
    return new zzac(this, this$0.keySet().iterator(), members.keySet().iterator());
  }
  
  public final Boolean value()
  {
    return Boolean.TRUE;
  }
  
  public final zzap zzbN(String paramString, Headers paramHeaders, List paramList)
  {
    if ((!"concat".equals(paramString)) && (!"every".equals(paramString)) && (!"filter".equals(paramString)) && (!"forEach".equals(paramString)) && (!"indexOf".equals(paramString)) && (!"join".equals(paramString)) && (!"lastIndexOf".equals(paramString)) && (!"map".equals(paramString)) && (!"pop".equals(paramString)) && (!"push".equals(paramString)) && (!"reduce".equals(paramString)) && (!"reduceRight".equals(paramString)) && (!"reverse".equals(paramString)) && (!"shift".equals(paramString)) && (!"slice".equals(paramString)) && (!"some".equals(paramString)) && (!"sort".equals(paramString)) && (!"splice".equals(paramString)) && (!"toString".equals(paramString)) && (!"unshift".equals(paramString))) {
      return zzaj.parse(this, new zzat(paramString), paramHeaders, paramList);
    }
    return zzbb.parse(paramString, this, paramHeaders, paramList);
  }
}
