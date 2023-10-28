package com.google.android.gms.internal.fitness;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

final class zzil
{
  private static final String parse(String paramString)
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
  
  private static void parse(zzik paramZzik, StringBuilder paramStringBuilder, int paramInt)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    Object localObject1 = new TreeSet();
    Object localObject2 = paramZzik.getClass().getDeclaredMethods();
    int j = localObject2.length;
    int i = 0;
    Object localObject3;
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
    Iterator localIterator = ((Set)localObject1).iterator();
    while (localIterator.hasNext())
    {
      localObject3 = (String)localIterator.next();
      if (((String)localObject3).startsWith("get")) {
        localObject1 = ((String)localObject3).substring(3);
      } else {
        localObject1 = localObject3;
      }
      boolean bool1 = ((String)localObject1).endsWith("List");
      boolean bool2 = true;
      Object localObject4;
      if ((bool1) && (!((String)localObject1).endsWith("OrBuilderList")) && (!((String)localObject1).equals("List")))
      {
        localObject2 = String.valueOf(((String)localObject1).substring(0, 1).toLowerCase());
        localObject4 = String.valueOf(((String)localObject1).substring(1, ((String)localObject1).length() - 4));
        if (((String)localObject4).length() != 0) {
          localObject2 = ((String)localObject2).concat((String)localObject4);
        } else {
          localObject2 = new String((String)localObject2);
        }
        localObject4 = (Method)localHashMap1.get(localObject3);
        if ((localObject4 != null) && (((Method)localObject4).getReturnType().equals(List.class)))
        {
          write(paramStringBuilder, paramInt, parse((String)localObject2), zzgy.get((Method)localObject4, paramZzik, new Object[0]));
          continue;
        }
      }
      if ((((String)localObject1).endsWith("Map")) && (!((String)localObject1).equals("Map")))
      {
        localObject2 = String.valueOf(((String)localObject1).substring(0, 1).toLowerCase());
        localObject4 = String.valueOf(((String)localObject1).substring(1, ((String)localObject1).length() - 3));
        if (((String)localObject4).length() != 0) {
          localObject2 = ((String)localObject2).concat((String)localObject4);
        } else {
          localObject2 = new String((String)localObject2);
        }
        localObject3 = (Method)localHashMap1.get(localObject3);
        if ((localObject3 != null) && (((Method)localObject3).getReturnType().equals(Map.class)) && (!((Method)localObject3).isAnnotationPresent(Deprecated.class)) && (Modifier.isPublic(((Method)localObject3).getModifiers())))
        {
          write(paramStringBuilder, paramInt, parse((String)localObject2), zzgy.get((Method)localObject3, paramZzik, new Object[0]));
          continue;
        }
      }
      if (((String)localObject1).length() != 0) {
        localObject2 = "set".concat((String)localObject1);
      } else {
        localObject2 = new String("set");
      }
      if ((Method)localHashMap2.get(localObject2) != null) {
        if (((String)localObject1).endsWith("Bytes"))
        {
          localObject2 = String.valueOf(((String)localObject1).substring(0, ((String)localObject1).length() - 5));
          if (((String)localObject2).length() != 0) {
            localObject2 = "get".concat((String)localObject2);
          } else {
            localObject2 = new String("get");
          }
          if (localHashMap1.containsKey(localObject2)) {}
        }
        else
        {
          localObject2 = String.valueOf(((String)localObject1).substring(0, 1).toLowerCase());
          localObject3 = String.valueOf(((String)localObject1).substring(1));
          if (((String)localObject3).length() != 0) {
            localObject2 = ((String)localObject2).concat((String)localObject3);
          } else {
            localObject2 = new String((String)localObject2);
          }
          if (((String)localObject1).length() != 0) {
            localObject3 = "get".concat((String)localObject1);
          } else {
            localObject3 = new String("get");
          }
          localObject3 = (Method)localHashMap1.get(localObject3);
          if (((String)localObject1).length() != 0) {
            localObject1 = "has".concat((String)localObject1);
          } else {
            localObject1 = new String("has");
          }
          localObject1 = (Method)localHashMap1.get(localObject1);
          if (localObject3 != null)
          {
            localObject3 = zzgy.get((Method)localObject3, paramZzik, new Object[0]);
            if (localObject1 == null)
            {
              if ((localObject3 instanceof Boolean)) {
                if (((Boolean)localObject3).booleanValue()) {}
              }
              for (;;)
              {
                bool1 = true;
                break;
                label862:
                label886:
                label953:
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          bool1 = false;
                          break label975;
                          if (!(localObject3 instanceof Integer)) {
                            break;
                          }
                        } while (((Integer)localObject3).intValue() != 0);
                        break;
                        if (!(localObject3 instanceof Float)) {
                          break label862;
                        }
                      } while (((Float)localObject3).floatValue() != 0.0F);
                      break;
                      if (!(localObject3 instanceof Double)) {
                        break label886;
                      }
                    } while (((Double)localObject3).doubleValue() != 0.0D);
                    break;
                    if ((localObject3 instanceof String))
                    {
                      bool1 = localObject3.equals("");
                      break label975;
                    }
                    if ((localObject3 instanceof zzfx))
                    {
                      bool1 = localObject3.equals(zzfx.zzub);
                      break label975;
                    }
                    if (!(localObject3 instanceof zzik)) {
                      break label953;
                    }
                  } while (localObject3 != ((zzik)localObject3).zzbu());
                  break;
                } while ((!(localObject3 instanceof Enum)) || (((Enum)localObject3).ordinal() != 0));
              }
              label975:
              if (!bool1) {
                bool1 = bool2;
              } else {
                bool1 = false;
              }
            }
            else
            {
              bool1 = ((Boolean)zzgy.get((Method)localObject1, paramZzik, new Object[0])).booleanValue();
            }
            if (bool1) {
              write(paramStringBuilder, paramInt, parse((String)localObject2), localObject3);
            }
          }
        }
      }
    }
    if ((paramZzik instanceof zzgy.zzd))
    {
      localObject1 = zzya.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        paramZzik = (zzgy.zzc)((Map.Entry)((Iterator)localObject1).next()).getKey();
        throw new NoSuchMethodError();
      }
    }
    paramZzik = zzxt;
    if (paramZzik != null) {
      paramZzik.index(paramStringBuilder, paramInt);
    }
  }
  
  static String safeString(zzik paramZzik, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("# ");
    localStringBuilder.append(paramString);
    parse(paramZzik, localStringBuilder, 0);
    return localStringBuilder.toString();
  }
  
  static final void write(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject)
  {
    if ((paramObject instanceof List))
    {
      paramObject = ((List)paramObject).iterator();
      while (paramObject.hasNext()) {
        write(paramStringBuilder, paramInt, paramString, paramObject.next());
      }
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramObject = ((Map)paramObject).entrySet().iterator();
      while (paramObject.hasNext()) {
        write(paramStringBuilder, paramInt, paramString, (Map.Entry)paramObject.next());
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
      paramStringBuilder.append(zzjo.toString(zzfx.setInput((String)paramObject)));
      paramStringBuilder.append('"');
      return;
    }
    if ((paramObject instanceof zzfx))
    {
      paramStringBuilder.append(": \"");
      paramStringBuilder.append(zzjo.toString((zzfx)paramObject));
      paramStringBuilder.append('"');
      return;
    }
    if ((paramObject instanceof zzgy))
    {
      paramStringBuilder.append(" {");
      parse((zzgy)paramObject, paramStringBuilder, paramInt + 2);
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
      write(paramStringBuilder, i, "key", paramString.getKey());
      write(paramStringBuilder, i, "value", paramString.getValue());
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
    paramStringBuilder.append(paramObject.toString());
  }
}
