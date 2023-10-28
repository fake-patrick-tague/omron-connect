package com.google.android.gms.internal.common;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;
import org.jspecify.nullness.NullMarked;

@NullMarked
public abstract class zzag
  extends zzac
  implements List, RandomAccess
{
  private static final zzak mMap = new zzae(zzai.INSTANCE, 0);
  
  zzag() {}
  
  public static zzag create(Object paramObject)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramObject;
    zzah.add(arrayOfObject, 1);
    return of(arrayOfObject, 1);
  }
  
  public static zzag create(Collection paramCollection)
  {
    if ((paramCollection instanceof zzac))
    {
      zzag localZzag = ((zzac)paramCollection).invoke();
      paramCollection = localZzag;
      if (localZzag.checkEmpty())
      {
        paramCollection = localZzag.toArray();
        return of(paramCollection, paramCollection.length);
      }
    }
    else
    {
      paramCollection = paramCollection.toArray();
      int i = paramCollection.length;
      zzah.add(paramCollection, i);
      paramCollection = of(paramCollection, i);
    }
    return paramCollection;
  }
  
  public static zzag empty()
  {
    return zzai.INSTANCE;
  }
  
  public static zzag get(Iterable paramIterable)
  {
    Objects.requireNonNull(paramIterable);
    if ((paramIterable instanceof Collection)) {
      return create((Collection)paramIterable);
    }
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext()) {
      return zzai.INSTANCE;
    }
    Object localObject = paramIterable.next();
    if (!paramIterable.hasNext()) {
      return create(localObject);
    }
    zzad localZzad = new zzad(4);
    localZzad.append(localObject);
    localZzad.transform(paramIterable);
    header = true;
    return of(data, modCount);
  }
  
  public static zzag of(Object paramObject1, Object paramObject2)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramObject1;
    arrayOfObject[1] = paramObject2;
    zzah.add(arrayOfObject, 2);
    return of(arrayOfObject, 2);
  }
  
  static zzag of(Object[] paramArrayOfObject, int paramInt)
  {
    if (paramInt == 0) {
      return zzai.INSTANCE;
    }
    return new zzai(paramArrayOfObject, paramInt);
  }
  
  public final void add(int paramInt, Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean addAll(int paramInt, Collection paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public final zzak build(int paramInt)
  {
    Preconditions.checkPositionIndex(paramInt, size(), "index");
    if (isEmpty()) {
      return mMap;
    }
    return new zzae(this, paramInt);
  }
  
  public final boolean contains(Object paramObject)
  {
    return indexOf(paramObject) >= 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof List)) {}
    Object localObject;
    label149:
    do
    {
      for (;;)
      {
        return false;
        localObject = (List)paramObject;
        int j = size();
        if (j == ((List)localObject).size())
        {
          if ((localObject instanceof RandomAccess))
          {
            int i = 0;
            for (;;)
            {
              if (i >= j) {
                break label159;
              }
              if (!Workout.equals(get(i), ((List)localObject).get(i))) {
                break;
              }
              i += 1;
            }
          }
          paramObject = iterator();
          localObject = ((List)localObject).iterator();
          do
          {
            if (!paramObject.hasNext()) {
              break label149;
            }
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          } while (Workout.equals(paramObject.next(), ((Iterator)localObject).next()));
        }
      }
    } while (((Iterator)localObject).hasNext());
    label159:
    return true;
  }
  
  public zzag get(int paramInt1, int paramInt2)
  {
    Preconditions.checkPositionIndexes(paramInt1, paramInt2, size());
    paramInt2 -= paramInt1;
    if (paramInt2 == size()) {
      return this;
    }
    if (paramInt2 == 0) {
      return zzai.INSTANCE;
    }
    return new zzaf(this, paramInt1, paramInt2);
  }
  
  public final int hashCode()
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
  
  public final int indexOf(Object paramObject)
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
  
  public final zzag invoke()
  {
    return this;
  }
  
  public final int lastIndexOf(Object paramObject)
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
  
  int remove(Object[] paramArrayOfObject, int paramInt)
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
  
  public final Object remove(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public final Object set(int paramInt, Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public final zzaj transform()
  {
    return build(0);
  }
}
