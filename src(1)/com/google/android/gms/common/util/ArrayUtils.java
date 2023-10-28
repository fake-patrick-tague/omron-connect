package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

@KeepForSdk
@VisibleForTesting
public final class ArrayUtils
{
  private ArrayUtils() {}
  
  public static Object[] concat(Object[]... paramVarArgs)
  {
    if (paramVarArgs.length != 0)
    {
      int i = 0;
      int j = 0;
      while (i < paramVarArgs.length)
      {
        j += paramVarArgs[i].length;
        i += 1;
      }
      Object[] arrayOfObject1 = Arrays.copyOf(paramVarArgs[0], j);
      j = paramVarArgs[0].length;
      i = 1;
      while (i < paramVarArgs.length)
      {
        Object[] arrayOfObject2 = paramVarArgs[i];
        int k = arrayOfObject2.length;
        System.arraycopy(arrayOfObject2, 0, arrayOfObject1, j, k);
        j += k;
        i += 1;
      }
      return arrayOfObject1;
    }
    return (Object[])Array.newInstance(paramVarArgs.getClass(), 0);
  }
  
  public static byte[] concatByteArrays(byte[]... paramVarArgs)
  {
    if (paramVarArgs.length != 0)
    {
      int i = 0;
      int j = 0;
      while (i < paramVarArgs.length)
      {
        j += paramVarArgs[i].length;
        i += 1;
      }
      byte[] arrayOfByte1 = Arrays.copyOf(paramVarArgs[0], j);
      j = paramVarArgs[0].length;
      i = 1;
      while (i < paramVarArgs.length)
      {
        byte[] arrayOfByte2 = paramVarArgs[i];
        int k = arrayOfByte2.length;
        System.arraycopy(arrayOfByte2, 0, arrayOfByte1, j, k);
        j += k;
        i += 1;
      }
      return arrayOfByte1;
    }
    return new byte[0];
  }
  
  public static boolean contains(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {
      return false;
    }
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean contains(Object[] paramArrayOfObject, Object paramObject)
  {
    int i;
    if (paramArrayOfObject != null) {
      i = paramArrayOfObject.length;
    } else {
      i = 0;
    }
    int j = 0;
    while (j < i)
    {
      if (Objects.equal(paramArrayOfObject[j], paramObject))
      {
        if (j < 0) {
          break;
        }
        return true;
      }
      j += 1;
    }
    return false;
  }
  
  public static ArrayList newArrayList()
  {
    return new ArrayList();
  }
  
  public static Object[] removeAll(Object[] paramArrayOfObject1, Object... paramVarArgs)
  {
    if (paramArrayOfObject1 == null) {
      return null;
    }
    if (paramVarArgs != null)
    {
      int i = paramVarArgs.length;
      if (i != 0)
      {
        Object localObject1 = paramVarArgs.getClass().getComponentType();
        int m = paramArrayOfObject1.length;
        localObject1 = (Object[])Array.newInstance((Class)localObject1, m);
        int j = 0;
        Object localObject2;
        if (i == 1)
        {
          j = 0;
          for (i = 0;; i = k)
          {
            k = i;
            if (j >= m) {
              break;
            }
            localObject2 = paramArrayOfObject1[j];
            k = i;
            if (!Objects.equal(paramVarArgs[0], localObject2))
            {
              localObject1[i] = localObject2;
              k = i + 1;
            }
            j += 1;
          }
        }
        for (i = 0; j < m; i = k)
        {
          localObject2 = paramArrayOfObject1[j];
          k = i;
          if (!contains(paramVarArgs, localObject2))
          {
            localObject1[i] = localObject2;
            k = i + 1;
          }
          j += 1;
        }
        int k = i;
        if (localObject1 == null) {
          return null;
        }
        if (k == localObject1.length) {
          return localObject1;
        }
        return Arrays.copyOf((Object[])localObject1, k);
      }
    }
    return Arrays.copyOf(paramArrayOfObject1, paramArrayOfObject1.length);
  }
  
  public static ArrayList toArrayList(Object[] paramArrayOfObject)
  {
    int j = paramArrayOfObject.length;
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfObject[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  public static int[] toPrimitiveArray(Collection paramCollection)
  {
    int i = 0;
    if ((paramCollection != null) && (!paramCollection.isEmpty()))
    {
      int[] arrayOfInt = new int[paramCollection.size()];
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        arrayOfInt[i] = ((Integer)paramCollection.next()).intValue();
        i += 1;
      }
      return arrayOfInt;
    }
    return new int[0];
  }
  
  public static Integer[] toWrapperArray(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return null;
    }
    int j = paramArrayOfInt.length;
    Integer[] arrayOfInteger = new Integer[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInteger[i] = Integer.valueOf(paramArrayOfInt[i]);
      i += 1;
    }
    return arrayOfInteger;
  }
  
  public static void writeArray(StringBuilder paramStringBuilder, double[] paramArrayOfDouble)
  {
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Double.toString(paramArrayOfDouble[i]));
      i += 1;
    }
  }
  
  public static void writeArray(StringBuilder paramStringBuilder, float[] paramArrayOfFloat)
  {
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Float.toString(paramArrayOfFloat[i]));
      i += 1;
    }
  }
  
  public static void writeArray(StringBuilder paramStringBuilder, int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Integer.toString(paramArrayOfInt[i]));
      i += 1;
    }
  }
  
  public static void writeArray(StringBuilder paramStringBuilder, long[] paramArrayOfLong)
  {
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Long.toString(paramArrayOfLong[i]));
      i += 1;
    }
  }
  
  public static void writeArray(StringBuilder paramStringBuilder, Object[] paramArrayOfObject)
  {
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(paramArrayOfObject[i]);
      i += 1;
    }
  }
  
  public static void writeArray(StringBuilder paramStringBuilder, boolean[] paramArrayOfBoolean)
  {
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Boolean.toString(paramArrayOfBoolean[i]));
      i += 1;
    }
  }
  
  public static void writeStringArray(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append("\"");
      paramStringBuilder.append(paramArrayOfString[i]);
      paramStringBuilder.append("\"");
      i += 1;
    }
  }
}
