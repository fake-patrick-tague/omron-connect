package com.google.android.gms.measurement.internal;

import android.os.BaseBundle;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public final class zzej
{
  protected static final AtomicReference activity = new AtomicReference();
  protected static final AtomicReference error;
  protected static final AtomicReference result = new AtomicReference();
  private final zzei name;
  
  static
  {
    error = new AtomicReference();
  }
  
  public zzej(zzei paramZzei)
  {
    name = paramZzei;
  }
  
  private static final String get(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, AtomicReference paramAtomicReference)
  {
    Preconditions.checkNotNull(paramArrayOfString1);
    Preconditions.checkNotNull(paramArrayOfString2);
    Preconditions.checkNotNull(paramAtomicReference);
    int j = paramArrayOfString1.length;
    int k = paramArrayOfString2.length;
    int i = 0;
    boolean bool;
    if (j == k) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    while (i < paramArrayOfString1.length)
    {
      Object localObject1 = paramArrayOfString1[i];
      if ((paramString != localObject1) && (!paramString.equals(localObject1))) {
        i += 1;
      } else {
        try
        {
          localObject1 = (String[])paramAtomicReference.get();
          paramString = (String)localObject1;
          if (localObject1 == null)
          {
            paramString = new String[paramArrayOfString2.length];
            paramAtomicReference.set(paramString);
          }
          Object localObject2 = paramString[i];
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramArrayOfString2[i]);
            ((StringBuilder)localObject1).append("(");
            ((StringBuilder)localObject1).append(paramArrayOfString1[i]);
            ((StringBuilder)localObject1).append(")");
            paramArrayOfString1 = ((StringBuilder)localObject1).toString();
            localObject1 = paramArrayOfString1;
            paramString[i] = paramArrayOfString1;
          }
          return localObject1;
        }
        catch (Throwable paramString)
        {
          throw paramString;
        }
      }
    }
    return paramString;
  }
  
  protected final String get(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (!name.get()) {
      return paramString;
    }
    if (paramString.startsWith("_exp_"))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("experiment_id(");
      localStringBuilder.append(paramString);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
    return get(paramString, zzgx.GIVEN, zzgx.name, activity);
  }
  
  protected final String getData(zzaw paramZzaw)
  {
    if (!name.get()) {
      return paramZzaw.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("origin=");
    localStringBuilder.append(name);
    localStringBuilder.append(",name=");
    localStringBuilder.append(toString(type));
    localStringBuilder.append(",params=");
    paramZzaw = this$0;
    if (paramZzaw == null) {
      paramZzaw = null;
    } else if (!name.get()) {
      paramZzaw = paramZzaw.toString();
    } else {
      paramZzaw = getValue(paramZzaw.get());
    }
    localStringBuilder.append(paramZzaw);
    return localStringBuilder.toString();
  }
  
  protected final String getValue(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    if (!name.get()) {
      return paramBundle.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bundle[{");
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (localStringBuilder.length() != 8) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(next((String)localObject));
      localStringBuilder.append("=");
      localObject = paramBundle.get((String)localObject);
      if ((localObject instanceof Bundle)) {
        localObject = toString(new Object[] { localObject });
      } else if ((localObject instanceof Object[])) {
        localObject = toString((Object[])localObject);
      } else if ((localObject instanceof ArrayList)) {
        localObject = toString(((ArrayList)localObject).toArray());
      } else {
        localObject = String.valueOf(localObject);
      }
      localStringBuilder.append((String)localObject);
    }
    localStringBuilder.append("}]");
    return localStringBuilder.toString();
  }
  
  protected final String next(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (!name.get()) {
      return paramString;
    }
    return get(paramString, zzgw.text, zzgw.type, error);
  }
  
  protected final String toString(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (!name.get()) {
      return paramString;
    }
    return get(paramString, zzgv.file, zzgv.source, result);
  }
  
  protected final String toString(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      return "[]";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayOfObject[i];
      if ((localObject instanceof Bundle)) {
        localObject = getValue((Bundle)localObject);
      } else {
        localObject = String.valueOf(localObject);
      }
      if (localObject != null)
      {
        if (localStringBuilder.length() != 1) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append((String)localObject);
      }
      i += 1;
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}
