package com.google.android.gms.internal.fitness;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public abstract class zzfh<E>
  extends zzfd<E>
  implements Set<E>
{
  private transient zzfc<E> zztl;
  
  zzfh() {}
  
  private static int chooseTableSize(int paramInt)
  {
    int i = Math.max(paramInt, 2);
    paramInt = 1;
    if (i < 751619276)
    {
      paramInt = Integer.highestOneBit(i - 1) << 1;
      while (paramInt * 0.7D < i) {
        paramInt <<= 1;
      }
      return paramInt;
    }
    if (i >= 1073741824) {
      paramInt = 0;
    }
    if (paramInt != 0) {
      return 1073741824;
    }
    throw new IllegalArgumentException("collection too large");
  }
  
  public static zzfh create(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    int j = 5;
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = paramObject1;
    arrayOfObject[1] = paramObject2;
    arrayOfObject[2] = paramObject3;
    arrayOfObject[3] = paramObject4;
    arrayOfObject[4] = paramObject5;
    while (j != 0) {
      if (j != 1)
      {
        int i3 = chooseTableSize(j);
        paramObject2 = new Object[i3];
        int i4 = i3 - 1;
        int k = 0;
        int m = 0;
        int i2;
        for (int i = 0; k < j; i = i2)
        {
          paramObject1 = zzfj.checkElementNotNull(arrayOfObject[k], k);
          int i5 = paramObject1.hashCode();
          int i1 = zzfa.smear(i5);
          int n;
          for (;;)
          {
            n = i1 & i4;
            paramObject3 = paramObject2[n];
            if (paramObject3 == null)
            {
              arrayOfObject[i] = paramObject1;
              paramObject2[n] = paramObject1;
              n = m + i5;
              i2 = i + 1;
              break;
            }
            n = m;
            i2 = i;
            if (paramObject3.equals(paramObject1)) {
              break;
            }
            i1 += 1;
          }
          k += 1;
          m = n;
        }
        Arrays.fill(arrayOfObject, i, j, null);
        if (i == 1) {
          return new zzfn(arrayOfObject[0], m);
        }
        if (chooseTableSize(i) < i3 / 2)
        {
          j = i;
        }
        else
        {
          paramObject1 = arrayOfObject;
          if (i < 3) {
            paramObject1 = Arrays.copyOf(arrayOfObject, i);
          }
          return new zzfl(paramObject1, m, paramObject2, i4, i);
        }
      }
      else
      {
        return new zzfn(arrayOfObject[0]);
      }
    }
    return zzfl.zzto;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (((paramObject instanceof zzfh)) && (zzak()) && (((zzfh)paramObject).zzak()) && (hashCode() != paramObject.hashCode())) {
      return false;
    }
    return zzfk.equalsSetHelper(this, paramObject);
  }
  
  public int hashCode()
  {
    Iterator localIterator = iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      int j;
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
      i += j;
    }
    return i;
  }
  
  public final zzfc zzaf()
  {
    zzfc localZzfc2 = zztl;
    zzfc localZzfc1 = localZzfc2;
    if (localZzfc2 == null)
    {
      localZzfc1 = zzal();
      zztl = localZzfc1;
    }
    return localZzfc1;
  }
  
  boolean zzak()
  {
    return false;
  }
  
  zzfc zzal()
  {
    return zzfc.structured(toArray());
  }
}
