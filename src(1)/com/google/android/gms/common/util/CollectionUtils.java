package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import v7.util.ArrayMap;
import v7.util.TLongArrayList;

@KeepForSdk
public final class CollectionUtils
{
  private CollectionUtils() {}
  
  private static Set get(int paramInt, boolean paramBoolean)
  {
    float f;
    if (true != paramBoolean) {
      f = 1.0F;
    } else {
      f = 0.75F;
    }
    int i;
    if (true != paramBoolean) {
      i = 256;
    } else {
      i = 128;
    }
    if (paramInt <= i) {
      return new TLongArrayList(paramInt);
    }
    return new HashSet(paramInt, f);
  }
  
  public static boolean isEmpty(Collection paramCollection)
  {
    if (paramCollection == null) {
      return true;
    }
    return paramCollection.isEmpty();
  }
  
  public static List listOf()
  {
    return Collections.emptyList();
  }
  
  public static List listOf(Object paramObject)
  {
    return Collections.singletonList(paramObject);
  }
  
  public static List listOf(Object... paramVarArgs)
  {
    int i = paramVarArgs.length;
    if (i != 0)
    {
      if (i != 1) {
        return Collections.unmodifiableList(Arrays.asList(paramVarArgs));
      }
      return listOf(paramVarArgs[0]);
    }
    return listOf();
  }
  
  public static Map mapOf(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    Map localMap = put(3, false);
    localMap.put(paramObject1, paramObject2);
    localMap.put(paramObject3, paramObject4);
    localMap.put(paramObject5, paramObject6);
    return Collections.unmodifiableMap(localMap);
  }
  
  public static Map mapOf(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8, Object paramObject9, Object paramObject10, Object paramObject11, Object paramObject12)
  {
    Map localMap = put(6, false);
    localMap.put(paramObject1, paramObject2);
    localMap.put(paramObject3, paramObject4);
    localMap.put(paramObject5, paramObject6);
    localMap.put(paramObject7, paramObject8);
    localMap.put(paramObject9, paramObject10);
    localMap.put(paramObject11, paramObject12);
    return Collections.unmodifiableMap(localMap);
  }
  
  public static Map mapOfKeyValueArrays(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    int j = paramArrayOfObject1.length;
    int i = paramArrayOfObject2.length;
    if (j == i)
    {
      if (j != 0)
      {
        i = 0;
        if (j != 1)
        {
          Map localMap = put(j, false);
          while (i < paramArrayOfObject1.length)
          {
            localMap.put(paramArrayOfObject1[i], paramArrayOfObject2[i]);
            i += 1;
          }
          return Collections.unmodifiableMap(localMap);
        }
        return Collections.singletonMap(paramArrayOfObject1[0], paramArrayOfObject2[0]);
      }
      return Collections.emptyMap();
    }
    paramArrayOfObject1 = new StringBuilder();
    paramArrayOfObject1.append("Key and values array lengths not equal: ");
    paramArrayOfObject1.append(j);
    paramArrayOfObject1.append(" != ");
    paramArrayOfObject1.append(i);
    throw new IllegalArgumentException(paramArrayOfObject1.toString());
  }
  
  public static Set mutableSetOfWithSize(int paramInt)
  {
    if (paramInt == 0) {
      return new TLongArrayList();
    }
    return get(paramInt, true);
  }
  
  private static Map put(int paramInt, boolean paramBoolean)
  {
    if (paramInt <= 256) {
      return new ArrayMap(paramInt);
    }
    return new HashMap(paramInt, 1.0F);
  }
  
  public static Set setOf(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Set localSet = get(3, false);
    localSet.add(paramObject1);
    localSet.add(paramObject2);
    localSet.add(paramObject3);
    return Collections.unmodifiableSet(localSet);
  }
  
  public static Set setOf(Object... paramVarArgs)
  {
    int i = paramVarArgs.length;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              localObject1 = get(i, false);
              Collections.addAll((Collection)localObject1, paramVarArgs);
              return Collections.unmodifiableSet((Set)localObject1);
            }
            localObject1 = paramVarArgs[0];
            localObject2 = paramVarArgs[1];
            Object localObject3 = paramVarArgs[2];
            paramVarArgs = paramVarArgs[3];
            Set localSet = get(4, false);
            localSet.add(localObject1);
            localSet.add(localObject2);
            localSet.add(localObject3);
            localSet.add(paramVarArgs);
            return Collections.unmodifiableSet(localSet);
          }
          return setOf(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2]);
        }
        Object localObject1 = paramVarArgs[0];
        paramVarArgs = paramVarArgs[1];
        Object localObject2 = get(2, false);
        ((Set)localObject2).add(localObject1);
        ((Set)localObject2).add(paramVarArgs);
        return Collections.unmodifiableSet((Set)localObject2);
      }
      return Collections.singleton(paramVarArgs[0]);
    }
    return Collections.emptySet();
  }
}
