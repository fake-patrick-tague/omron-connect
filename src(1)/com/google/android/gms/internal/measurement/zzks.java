package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzks
  extends zzio
  implements RandomAccess, zzkt
{
  public static final zzkt contextField;
  private static final zzks replacementOffsetField;
  private final List data;
  
  static
  {
    zzks localZzks = new zzks(10);
    replacementOffsetField = localZzks;
    localZzks.inc();
    contextField = localZzks;
  }
  
  public zzks()
  {
    this(10);
  }
  
  public zzks(int paramInt)
  {
    data = localArrayList;
  }
  
  private zzks(ArrayList paramArrayList)
  {
    data = paramArrayList;
  }
  
  private static String get(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if ((paramObject instanceof zzjd)) {
      return ((zzjd)paramObject).format(zzkm.a);
    }
    return zzkm.getValue((byte[])paramObject);
  }
  
  public final zzkt a()
  {
    if (get()) {
      return new zzms(this);
    }
    return this;
  }
  
  public final String a(int paramInt)
  {
    Object localObject1 = data.get(paramInt);
    if ((localObject1 instanceof String)) {
      return (String)localObject1;
    }
    Object localObject2;
    String str;
    if ((localObject1 instanceof zzjd))
    {
      localObject2 = (zzjd)localObject1;
      str = ((zzjd)localObject2).format(zzkm.a);
      localObject1 = str;
      if (((zzjd)localObject2).b())
      {
        data.set(paramInt, str);
        return str;
      }
    }
    else
    {
      localObject2 = (byte[])localObject1;
      str = zzkm.getValue((byte[])localObject2);
      localObject1 = str;
      if (zzkm.a((byte[])localObject2))
      {
        data.set(paramInt, str);
        localObject1 = str;
      }
    }
    return localObject1;
  }
  
  public final boolean addAll(int paramInt, Collection paramCollection)
  {
    zzbP();
    Object localObject = paramCollection;
    if ((paramCollection instanceof zzkt)) {
      localObject = ((zzkt)paramCollection).getFileList();
    }
    boolean bool = data.addAll(paramInt, (Collection)localObject);
    modCount += 1;
    return bool;
  }
  
  public final boolean addAll(Collection paramCollection)
  {
    return addAll(size(), paramCollection);
  }
  
  public final void clear()
  {
    zzbP();
    data.clear();
    modCount += 1;
  }
  
  public final List getFileList()
  {
    return Collections.unmodifiableList(data);
  }
  
  public final Object getKey(int paramInt)
  {
    return data.get(paramInt);
  }
  
  public final void removeAt(zzjd paramZzjd)
  {
    zzbP();
    data.add(paramZzjd);
    modCount += 1;
  }
  
  public final int size()
  {
    return data.size();
  }
}
