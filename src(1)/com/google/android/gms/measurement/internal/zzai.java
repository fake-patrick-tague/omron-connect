package com.google.android.gms.measurement.internal;

import android.os.BaseBundle;
import android.os.Bundle;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Set;

public final class zzai
{
  public static final zzai values = new zzai(null, null);
  private final EnumMap this$0;
  
  public zzai(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    EnumMap localEnumMap = new EnumMap(zzah.class);
    this$0 = localEnumMap;
    localEnumMap.put(zzah.count, paramBoolean1);
    localEnumMap.put(zzah.name, paramBoolean2);
  }
  
  public zzai(EnumMap paramEnumMap)
  {
    EnumMap localEnumMap = new EnumMap(zzah.class);
    this$0 = localEnumMap;
    localEnumMap.putAll(paramEnumMap);
  }
  
  public static String equals(Bundle paramBundle)
  {
    zzah[] arrayOfZzah = zzah.values();
    int j = arrayOfZzah.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfZzah[i];
      if (paramBundle.containsKey(key))
      {
        localObject = paramBundle.getString(key);
        if ((localObject != null) && (get((String)localObject) == null)) {
          return localObject;
        }
      }
      i += 1;
    }
    return null;
  }
  
  private static Boolean get(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.equals("granted")) {
      return Boolean.TRUE;
    }
    if (paramString.equals("denied")) {
      return Boolean.FALSE;
    }
    return null;
  }
  
  static final int getFieldType(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return 0;
    }
    if (paramBoolean.booleanValue()) {
      return 1;
    }
    return 2;
  }
  
  public static zzai getValue(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return values;
    }
    EnumMap localEnumMap = new EnumMap(zzah.class);
    zzah[] arrayOfZzah = zzah.values();
    int j = arrayOfZzah.length;
    int i = 0;
    while (i < j)
    {
      zzah localZzah = arrayOfZzah[i];
      localEnumMap.put(localZzah, get(paramBundle.getString(key)));
      i += 1;
    }
    return new zzai(localEnumMap);
  }
  
  public static zzai parse(String paramString)
  {
    EnumMap localEnumMap = new EnumMap(zzah.class);
    if (paramString != null)
    {
      int i = 0;
      for (;;)
      {
        Object localObject1 = zzah.text;
        if (i >= 2) {
          break;
        }
        Enum localEnum = localObject1[i];
        int j = i + 2;
        if (j < paramString.length())
        {
          j = paramString.charAt(j);
          Object localObject2 = null;
          localObject1 = localObject2;
          if (j != 45) {
            if (j != 48)
            {
              if (j != 49) {
                localObject1 = localObject2;
              } else {
                localObject1 = Boolean.TRUE;
              }
            }
            else {
              localObject1 = Boolean.FALSE;
            }
          }
          localEnumMap.put(localEnum, localObject1);
        }
        i += 1;
      }
    }
    return new zzai(localEnumMap);
  }
  
  public static boolean set(int paramInt1, int paramInt2)
  {
    return paramInt1 <= paramInt2;
  }
  
  public final String encode()
  {
    StringBuilder localStringBuilder = new StringBuilder("G1");
    zzah[] arrayOfZzah = zzah.text;
    int i = 0;
    while (i < 2)
    {
      Object localObject = arrayOfZzah[i];
      localObject = (Boolean)this$0.get(localObject);
      char c;
      if (localObject == null) {
        c = '-';
      } else if (((Boolean)localObject).booleanValue()) {
        c = '1';
      } else {
        c = '0';
      }
      localStringBuilder.append(c);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzai)) {
      return false;
    }
    paramObject = (zzai)paramObject;
    zzah[] arrayOfZzah = zzah.values();
    int j = arrayOfZzah.length;
    int i = 0;
    while (i < j)
    {
      zzah localZzah = arrayOfZzah[i];
      if (getFieldType((Boolean)this$0.get(localZzah)) != getFieldType((Boolean)this$0.get(localZzah))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public final boolean execute(zzai paramZzai, zzah... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramVarArgs[i];
      Boolean localBoolean1 = (Boolean)this$0.get(localObject);
      localObject = (Boolean)this$0.get(localObject);
      Boolean localBoolean2 = Boolean.FALSE;
      if ((localBoolean1 == localBoolean2) && (localObject != localBoolean2)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public final boolean get(zzah paramZzah)
  {
    paramZzah = (Boolean)this$0.get(paramZzah);
    return (paramZzah == null) || (paramZzah.booleanValue());
  }
  
  public final boolean get(zzai paramZzai)
  {
    return execute(paramZzai, (zzah[])this$0.keySet().toArray(new zzah[0]));
  }
  
  public final zzai getString(zzai paramZzai)
  {
    EnumMap localEnumMap = new EnumMap(zzah.class);
    zzah[] arrayOfZzah = zzah.values();
    int j = arrayOfZzah.length;
    int i = 0;
    while (i < j)
    {
      zzah localZzah = arrayOfZzah[i];
      Boolean localBoolean2 = (Boolean)this$0.get(localZzah);
      Boolean localBoolean1 = localBoolean2;
      if (localBoolean2 == null) {
        localBoolean1 = (Boolean)this$0.get(localZzah);
      }
      localEnumMap.put(localZzah, localBoolean1);
      i += 1;
    }
    return new zzai(localEnumMap);
  }
  
  public final Boolean getValue()
  {
    return (Boolean)this$0.get(zzah.count);
  }
  
  public final int hashCode()
  {
    Iterator localIterator = this$0.values().iterator();
    for (int i = 17; localIterator.hasNext(); i = i * 31 + getFieldType((Boolean)localIterator.next())) {}
    return i;
  }
  
  public final Boolean isEmpty()
  {
    return (Boolean)this$0.get(zzah.name);
  }
  
  public final zzai load(zzai paramZzai)
  {
    EnumMap localEnumMap = new EnumMap(zzah.class);
    zzah[] arrayOfZzah = zzah.values();
    int j = arrayOfZzah.length;
    int i = 0;
    while (i < j)
    {
      zzah localZzah = arrayOfZzah[i];
      Boolean localBoolean2 = (Boolean)this$0.get(localZzah);
      Boolean localBoolean3 = (Boolean)this$0.get(localZzah);
      Boolean localBoolean1;
      if (localBoolean2 == null)
      {
        localBoolean1 = localBoolean3;
      }
      else
      {
        localBoolean1 = localBoolean2;
        if (localBoolean3 != null)
        {
          boolean bool;
          if ((localBoolean2.booleanValue()) && (localBoolean3.booleanValue())) {
            bool = true;
          } else {
            bool = false;
          }
          localBoolean1 = Boolean.valueOf(bool);
        }
      }
      localEnumMap.put(localZzah, localBoolean1);
      i += 1;
    }
    return new zzai(localEnumMap);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("settings: ");
    zzah[] arrayOfZzah = zzah.values();
    int j = arrayOfZzah.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfZzah[i];
      if (i != 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(((Enum)localObject).name());
      localStringBuilder.append("=");
      localObject = (Boolean)this$0.get(localObject);
      if (localObject == null)
      {
        localStringBuilder.append("uninitialized");
      }
      else
      {
        if (true != ((Boolean)localObject).booleanValue()) {
          localObject = "denied";
        } else {
          localObject = "granted";
        }
        localStringBuilder.append((String)localObject);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
}
