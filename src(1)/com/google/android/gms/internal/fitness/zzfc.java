package com.google.android.gms.internal.fitness;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public abstract class zzfc<E>
  extends zzfd<E>
  implements List<E>, RandomAccess
{
  private static final zzfp<Object> zztf = new zzff(zzfi.zztm, 0);
  
  zzfc() {}
  
  static zzfc add(Object[] paramArrayOfObject, int paramInt)
  {
    if (paramInt == 0) {
      return zzfi.zztm;
    }
    return new zzfi(paramArrayOfObject, paramInt);
  }
  
  public static zzfc addRange(Object paramObject)
  {
    paramObject = zzfj.add(new Object[] { paramObject }, 1);
    return add(paramObject, paramObject.length);
  }
  
  public static zzfc getNames(Collection paramCollection)
  {
    if ((paramCollection instanceof zzfd))
    {
      zzfc localZzfc = ((zzfd)paramCollection).zzaf();
      paramCollection = localZzfc;
      if (localZzfc.zzaj())
      {
        paramCollection = localZzfc.toArray();
        return add(paramCollection, paramCollection.length);
      }
    }
    else
    {
      paramCollection = paramCollection.toArray();
      paramCollection = zzfj.add(paramCollection, paramCollection.length);
      paramCollection = add(paramCollection, paramCollection.length);
    }
    return paramCollection;
  }
  
  static zzfc structured(Object[] paramArrayOfObject)
  {
    return add(paramArrayOfObject, paramArrayOfObject.length);
  }
  
  public static zzfc zzad()
  {
    return zzfi.zztm;
  }
  
  public final void add(int paramInt, Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean addAll(int paramInt, Collection paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean contains(Object paramObject)
  {
    return indexOf(paramObject) >= 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == zzez.checkNotNull(this)) {
      return true;
    }
    if ((paramObject instanceof List))
    {
      paramObject = (List)paramObject;
      int j = size();
      if (j == paramObject.size())
      {
        if ((paramObject instanceof RandomAccess))
        {
          i = 0;
          while (i < j)
          {
            if (!zzew.equal(get(i), paramObject.get(i))) {
              break label151;
            }
            i += 1;
          }
          return true;
        }
        j = size();
        paramObject = paramObject.iterator();
        int i = 0;
        while (i < j)
        {
          if (!paramObject.hasNext()) {
            break label151;
          }
          Object localObject = get(i);
          i += 1;
          if (!zzew.equal(localObject, paramObject.next())) {
            break label151;
          }
        }
        if (!paramObject.hasNext()) {
          return true;
        }
      }
    }
    label151:
    return false;
  }
  
  int get(Object[] paramArrayOfObject, int paramInt)
  {
    int i = size();
    paramInt = 0;
    while (paramInt < i)
    {
      paramArrayOfObject[paramInt] = get(paramInt);
      paramInt += 1;
    }
    return i;
  }
  
  public int hashCode()
  {
    int k = size();
    int j = 1;
    int i = 0;
    while (i < k)
    {
      j = j * 31 + get(i).hashCode();
      i += 1;
    }
    return j;
  }
  
  public int indexOf(Object paramObject)
  {
    if (paramObject == null) {
      return -1;
    }
    int j = size();
    int i = 0;
    while (i < j)
    {
      if (paramObject.equals(get(i))) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public int lastIndexOf(Object paramObject)
  {
    if (paramObject == null) {
      return -1;
    }
    int i = size() - 1;
    while (i >= 0)
    {
      if (paramObject.equals(get(i))) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  public final Object remove(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public final Object set(int paramInt, Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public zzfc slice(int paramInt1, int paramInt2)
  {
    zzez.checkPositionIndexes(paramInt1, paramInt2, size());
    paramInt2 -= paramInt1;
    if (paramInt2 == size()) {
      return this;
    }
    if (paramInt2 == 0) {
      return zzfi.zztm;
    }
    return new zzfe(this, paramInt1, paramInt2);
  }
  
  public final zzfm zzae()
  {
    return (zzfp)listIterator();
  }
  
  public final zzfc zzaf()
  {
    return this;
  }
}
