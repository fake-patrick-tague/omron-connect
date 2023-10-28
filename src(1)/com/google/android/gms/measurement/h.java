package com.google.android.gms.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.measurement.internal.Frame;
import com.google.android.gms.measurement.internal.zzfy;
import com.google.android.gms.measurement.internal.zzgy;
import com.google.android.gms.measurement.internal.zzgz;
import com.google.android.gms.measurement.internal.zzid;
import com.google.android.gms.measurement.internal.zzlc;
import com.google.android.gms.measurement.internal.zzlh;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import v7.util.ArrayMap;

final class h
  extends Directory
{
  private final zzid b;
  private final zzfy m;
  
  public h(zzfy paramZzfy)
  {
    super(null);
    Preconditions.checkNotNull(paramZzfy);
    m = paramZzfy;
    b = paramZzfy.add();
  }
  
  public final Object a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return b.remove();
          }
          return b.getIdentifier();
        }
        return b.getValue();
      }
      return b.read();
    }
    return b.getString();
  }
  
  public final String a()
  {
    return b.b();
  }
  
  public final Map a(boolean paramBoolean)
  {
    Object localObject1 = b.remove(paramBoolean);
    ArrayMap localArrayMap = new ArrayMap(((List)localObject1).size());
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      zzlc localZzlc = (zzlc)((Iterator)localObject1).next();
      Object localObject2 = localZzlc.get();
      if (localObject2 != null) {
        localArrayMap.put(type, localObject2);
      }
    }
    return localArrayMap;
  }
  
  public final int b(String paramString)
  {
    b.multiply(paramString);
    return 25;
  }
  
  public final String b()
  {
    return b.c();
  }
  
  public final List b(String paramString1, String paramString2)
  {
    return b.get(paramString1, paramString2);
  }
  
  public final Map b(String paramString1, String paramString2, boolean paramBoolean)
  {
    return b.a(paramString1, paramString2, paramBoolean);
  }
  
  public final void b(Bundle paramBundle)
  {
    b.f(paramBundle);
  }
  
  public final void b(zzgy paramZzgy)
  {
    b.f(paramZzgy);
  }
  
  public final void b(zzgz paramZzgz)
  {
    b.clear(paramZzgz);
  }
  
  public final void b(String paramString1, String paramString2, Bundle paramBundle)
  {
    b.get(paramString1, paramString2, paramBundle);
  }
  
  public final String c()
  {
    return b.a();
  }
  
  public final String d()
  {
    return b.a();
  }
  
  public final void d(String paramString)
  {
    m.a().b(paramString, m.zzav().elapsedRealtime());
  }
  
  public final Boolean e()
  {
    return b.remove();
  }
  
  public final void e(String paramString)
  {
    m.a().c(paramString, m.zzav().elapsedRealtime());
  }
  
  public final long f()
  {
    return m.get().next();
  }
  
  public final void f(zzgz paramZzgz)
  {
    b.multiply(paramZzgz);
  }
  
  public final void f(String paramString1, String paramString2, Bundle paramBundle)
  {
    m.add().set(paramString1, paramString2, paramBundle);
  }
  
  public final void f(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    b.add(paramString1, paramString2, paramBundle, true, false, paramLong);
  }
  
  public final Integer getItemId()
  {
    return b.getIdentifier();
  }
  
  public final String getOrder()
  {
    return b.getString();
  }
  
  public final Double getTitle()
  {
    return b.getValue();
  }
  
  public final Long setIcon()
  {
    return b.read();
  }
}
