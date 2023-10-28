package com.google.android.gms.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzgy;
import com.google.android.gms.measurement.internal.zzgz;
import com.google.android.gms.measurement.internal.zzie;
import java.util.List;
import java.util.Map;

final class m
  extends Directory
{
  private final zzie b;
  
  public m(zzie paramZzie)
  {
    super(null);
    Preconditions.checkNotNull(paramZzie);
    b = paramZzie;
  }
  
  public final Object a(int paramInt)
  {
    return b.a(paramInt);
  }
  
  public final String a()
  {
    return b.a();
  }
  
  public final Map a(boolean paramBoolean)
  {
    return b.b(null, null, paramBoolean);
  }
  
  public final int b(String paramString)
  {
    return b.b(paramString);
  }
  
  public final String b()
  {
    return b.b();
  }
  
  public final List b(String paramString1, String paramString2)
  {
    return b.b(paramString1, paramString2);
  }
  
  public final Map b(String paramString1, String paramString2, boolean paramBoolean)
  {
    return b.b(paramString1, paramString2, paramBoolean);
  }
  
  public final void b(Bundle paramBundle)
  {
    b.b(paramBundle);
  }
  
  public final void b(zzgy paramZzgy)
  {
    b.b(paramZzgy);
  }
  
  public final void b(zzgz paramZzgz)
  {
    b.b(paramZzgz);
  }
  
  public final void b(String paramString1, String paramString2, Bundle paramBundle)
  {
    b.b(paramString1, paramString2, paramBundle);
  }
  
  public final String c()
  {
    return b.c();
  }
  
  public final String d()
  {
    return b.d();
  }
  
  public final void d(String paramString)
  {
    b.d(paramString);
  }
  
  public final Boolean e()
  {
    return (Boolean)b.a(4);
  }
  
  public final void e(String paramString)
  {
    b.e(paramString);
  }
  
  public final long f()
  {
    return b.f();
  }
  
  public final void f(zzgz paramZzgz)
  {
    b.f(paramZzgz);
  }
  
  public final void f(String paramString1, String paramString2, Bundle paramBundle)
  {
    b.f(paramString1, paramString2, paramBundle);
  }
  
  public final void f(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    b.f(paramString1, paramString2, paramBundle, paramLong);
  }
  
  public final Integer getItemId()
  {
    return (Integer)b.a(3);
  }
  
  public final String getOrder()
  {
    return (String)b.a(0);
  }
  
  public final Double getTitle()
  {
    return (Double)b.a(2);
  }
  
  public final Long setIcon()
  {
    return (Long)b.a(1);
  }
}
