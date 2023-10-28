package com.google.android.gms.internal.measurement;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

final class zzln
{
  static final void add(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject)
  {
    if ((paramObject instanceof List))
    {
      paramObject = ((List)paramObject).iterator();
      while (paramObject.hasNext()) {
        add(paramStringBuilder, paramInt, paramString, paramObject.next());
      }
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramObject = ((Map)paramObject).entrySet().iterator();
      while (paramObject.hasNext()) {
        add(paramStringBuilder, paramInt, paramString, (Map.Entry)paramObject.next());
      }
      return;
    }
    paramStringBuilder.append('\n');
    int j = 0;
    int k = 0;
    int i = 0;
    while (i < paramInt)
    {
      paramStringBuilder.append(' ');
      i += 1;
    }
    paramStringBuilder.append(paramString);
    if ((paramObject instanceof String))
    {
      paramStringBuilder.append(": \"");
      paramStringBuilder.append(zzml.toString(zzjd.encodeUTF8((String)paramObject)));
      paramStringBuilder.append('"');
      return;
    }
    if ((paramObject instanceof zzjd))
    {
      paramStringBuilder.append(": \"");
      paramStringBuilder.append(zzml.toString((zzjd)paramObject));
      paramStringBuilder.append('"');
      return;
    }
    if ((paramObject instanceof zzke))
    {
      paramStringBuilder.append(" {");
      doInBackground((zzke)paramObject, paramStringBuilder, paramInt + 2);
      paramStringBuilder.append("\n");
      i = k;
      while (i < paramInt)
      {
        paramStringBuilder.append(' ');
        i += 1;
      }
      paramStringBuilder.append("}");
      return;
    }
    if ((paramObject instanceof Map.Entry))
    {
      paramStringBuilder.append(" {");
      paramString = (Map.Entry)paramObject;
      i = paramInt + 2;
      add(paramStringBuilder, i, "key", paramString.getKey());
      add(paramStringBuilder, i, "value", paramString.getValue());
      paramStringBuilder.append("\n");
      i = j;
      while (i < paramInt)
      {
        paramStringBuilder.append(' ');
        i += 1;
      }
      paramStringBuilder.append("}");
      return;
    }
    paramStringBuilder.append(": ");
    paramStringBuilder.append(paramObject);
  }
  
  private static void doInBackground(zzll paramZzll, StringBuilder paramStringBuilder, int paramInt)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    Object localObject1 = new TreeSet();
    Object localObject2 = paramZzll.getClass().getDeclaredMethods();
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      localObject3 = localObject2[i];
      localHashMap2.put(((Method)localObject3).getName(), localObject3);
      if (((Method)localObject3).getParameterTypes().length == 0)
      {
        localHashMap1.put(((Method)localObject3).getName(), localObject3);
        if (((Method)localObject3).getName().startsWith("get")) {
          ((Set)localObject1).add(((Method)localObject3).getName());
        }
      }
      i += 1;
    }
    Object localObject3 = ((Set)localObject1).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (String)((Iterator)localObject3).next();
      if (((String)localObject2).startsWith("get")) {
        localObject1 = ((String)localObject2).substring(3);
      } else {
        localObject1 = localObject2;
      }
      Object localObject4;
      if ((((String)localObject1).endsWith("List")) && (!((String)localObject1).endsWith("OrBuilderList")) && (!((String)localObject1).equals("List")))
      {
        localObject4 = String.valueOf(((String)localObject1).substring(0, 1).toLowerCase()).concat(String.valueOf(((String)localObject1).substring(1, ((String)localObject1).length() - 4)));
        Method localMethod = (Method)localHashMap1.get(localObject2);
        if ((localMethod != null) && (localMethod.getReturnType().equals(List.class)))
        {
          add(paramStringBuilder, paramInt, toLowerCase((String)localObject4), zzke.zzbH(localMethod, paramZzll, new Object[0]));
          continue;
        }
      }
      if ((((String)localObject1).endsWith("Map")) && (!((String)localObject1).equals("Map")))
      {
        localObject4 = String.valueOf(((String)localObject1).substring(0, 1).toLowerCase()).concat(String.valueOf(((String)localObject1).substring(1, ((String)localObject1).length() - 3)));
        localObject2 = (Method)localHashMap1.get(localObject2);
        if ((localObject2 != null) && (((Method)localObject2).getReturnType().equals(Map.class)) && (!((Method)localObject2).isAnnotationPresent(Deprecated.class)) && (Modifier.isPublic(((Method)localObject2).getModifiers())))
        {
          add(paramStringBuilder, paramInt, toLowerCase((String)localObject4), zzke.zzbH((Method)localObject2, paramZzll, new Object[0]));
          continue;
        }
      }
      if (((Method)localHashMap2.get("set".concat((String)localObject1)) != null) && ((!((String)localObject1).endsWith("Bytes")) || (!localHashMap1.containsKey("get".concat(String.valueOf(((String)localObject1).substring(0, ((String)localObject1).length() - 5)))))))
      {
        localObject2 = String.valueOf(((String)localObject1).substring(0, 1).toLowerCase()).concat(String.valueOf(((String)localObject1).substring(1)));
        localObject4 = (Method)localHashMap1.get("get".concat((String)localObject1));
        localObject1 = (Method)localHashMap1.get("has".concat((String)localObject1));
        if (localObject4 != null)
        {
          localObject4 = zzke.zzbH((Method)localObject4, paramZzll, new Object[0]);
          if (localObject1 == null)
          {
            if ((localObject4 instanceof Boolean))
            {
              if (!((Boolean)localObject4).booleanValue()) {
                continue;
              }
            }
            else if ((localObject4 instanceof Integer))
            {
              if (((Integer)localObject4).intValue() == 0) {
                continue;
              }
            }
            else if ((localObject4 instanceof Float))
            {
              if (Float.floatToRawIntBits(((Float)localObject4).floatValue()) == 0) {
                continue;
              }
            }
            else if ((localObject4 instanceof Double))
            {
              if (Double.doubleToRawLongBits(((Double)localObject4).doubleValue()) == 0L) {
                continue;
              }
            }
            else
            {
              boolean bool;
              if ((localObject4 instanceof String))
              {
                bool = localObject4.equals("");
              }
              else
              {
                if (!(localObject4 instanceof zzjd)) {
                  break label722;
                }
                bool = localObject4.equals(zzjd.a);
              }
              if (bool) {
                continue;
              }
              break label789;
              label722:
              if ((localObject4 instanceof zzll)) {
                if (localObject4 == ((zzll)localObject4).zzbO()) {
                  continue;
                }
              } else if ((localObject4 instanceof Enum)) {
                if (((Enum)localObject4).ordinal() == 0) {
                  continue;
                }
              }
            }
          }
          else {
            if (!((Boolean)zzke.zzbH((Method)localObject1, paramZzll, new Object[0])).booleanValue()) {
              continue;
            }
          }
          label789:
          add(paramStringBuilder, paramInt, toLowerCase((String)localObject2), localObject4);
        }
      }
    }
    if (!(paramZzll instanceof zzkb))
    {
      paramZzll = f;
      if (paramZzll != null) {
        paramZzll.write(paramStringBuilder, paramInt);
      }
    }
    else
    {
      paramZzll = (zzkb)paramZzll;
      throw new NullPointerException("Null throw statement replaced by Soot");
    }
  }
  
  static String getName(zzll paramZzll, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("# ");
    localStringBuilder.append(paramString);
    doInBackground(paramZzll, localStringBuilder, 0);
    return localStringBuilder.toString();
  }
  
  private static final String toLowerCase(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (Character.isUpperCase(c)) {
        localStringBuilder.append("_");
      }
      localStringBuilder.append(Character.toLowerCase(c));
      i += 1;
    }
    return localStringBuilder.toString();
  }
}
