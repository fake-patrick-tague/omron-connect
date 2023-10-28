package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzke<MessageType extends zzke<MessageType, BuilderType>, BuilderType extends zzka<MessageType, BuilderType>>
  extends zzin<MessageType, BuilderType>
{
  private static final Map TYPE_NAMES = new ConcurrentHashMap();
  protected zzmo f = zzmo.e();
  protected int j = -1;
  
  public zzke() {}
  
  protected static zzkj zzbA()
  {
    return zzkf.getEventQueue();
  }
  
  protected static zzkk zzbB()
  {
    return zzla.getEventQueue();
  }
  
  protected static zzkk zzbC(zzkk paramZzkk)
  {
    int i = paramZzkk.size();
    if (i == 0) {
      i = 10;
    } else {
      i += i;
    }
    return paramZzkk.substring(i);
  }
  
  protected static zzkl zzbD()
  {
    return zzlu.getEventQueue();
  }
  
  protected static zzkl zzbE(zzkl paramZzkl)
  {
    int i = paramZzkl.size();
    if (i == 0) {
      i = 10;
    } else {
      i += i;
    }
    return paramZzkl.trim(i);
  }
  
  static Object zzbH(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    try
    {
      paramMethod = paramMethod.invoke(paramObject, paramVarArgs);
      return paramMethod;
    }
    catch (InvocationTargetException paramMethod)
    {
      paramMethod = paramMethod.getCause();
      if (!(paramMethod instanceof RuntimeException))
      {
        if ((paramMethod instanceof Error)) {
          throw ((Error)paramMethod);
        }
        throw new RuntimeException("Unexpected exception thrown by generated accessor method.", paramMethod);
      }
      throw ((RuntimeException)paramMethod);
    }
    catch (IllegalAccessException paramMethod)
    {
      throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", paramMethod);
    }
  }
  
  protected static Object zzbI(zzll paramZzll, String paramString, Object[] paramArrayOfObject)
  {
    return new zzlv(paramZzll, paramString, paramArrayOfObject);
  }
  
  protected static void zzbJ(Class paramClass, zzke paramZzke)
  {
    TYPE_NAMES.put(paramClass, paramZzke);
  }
  
  static zzke zzbz(Class paramClass)
  {
    Map localMap = TYPE_NAMES;
    zzke localZzke2 = (zzke)localMap.get(paramClass);
    zzke localZzke1 = localZzke2;
    if (localZzke2 == null) {
      try
      {
        Class.forName(paramClass.getName(), true, paramClass.getClassLoader());
        localZzke1 = (zzke)localMap.get(paramClass);
      }
      catch (ClassNotFoundException paramClass)
      {
        throw new IllegalStateException("Class initialization cannot fail.", paramClass);
      }
    }
    if (localZzke1 == null)
    {
      localZzke1 = (zzke)((zzke)zzmx.getField(paramClass)).Decode(6, null, null);
      if (localZzke1 != null)
      {
        localMap.put(paramClass, localZzke1);
        return localZzke1;
      }
      throw new IllegalStateException();
    }
    return localZzke1;
  }
  
  protected abstract Object Decode(int paramInt, Object paramObject1, Object paramObject2);
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    return zzlt.decorated().get(getClass()).b(this, (zzke)paramObject);
  }
  
  public final int hashCode()
  {
    int i = hashcode;
    if (i != 0) {
      return i;
    }
    i = zzlt.decorated().get(getClass()).doInBackground(this);
    hashcode = i;
    return i;
  }
  
  public final String toString()
  {
    return zzln.getName(this, super.toString());
  }
  
  public final void zzbK(zzjl paramZzjl)
    throws IOException
  {
    zzlt.decorated().get(getClass()).a(this, zzjm.a(paramZzjl));
  }
  
  final int zzbr()
  {
    return j;
  }
  
  final void zzbu(int paramInt)
  {
    j = paramInt;
  }
  
  public final int zzbw()
  {
    int k = j;
    int i = k;
    if (k == -1)
    {
      i = zzlt.decorated().get(getClass()).b(this);
      j = i;
    }
    return i;
  }
  
  protected final zzka zzbx()
  {
    return (zzka)Decode(5, null, null);
  }
  
  public final zzka zzby()
  {
    zzka localZzka = (zzka)Decode(5, null, null);
    localZzka.zzaC(this);
    return localZzka;
  }
}
