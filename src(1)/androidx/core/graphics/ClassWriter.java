package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.asm.NavigationMenuPresenter;
import androidx.core.content.asm.d;
import v7.util.LruCache;
import v7.v7.asm.ClassReader;
import v7.v7.asm.Label;

public class ClassWriter
{
  private static final h a;
  private static final c.e.e<String, Typeface> c = new LruCache(16);
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 29) {
      a = new c();
    } else if (i >= 28) {
      a = new SequentialMapValueImpl();
    } else if (i >= 26) {
      a = new m();
    } else if ((i >= 24) && (Type.a())) {
      a = new Type();
    } else if (i >= 21) {
      a = new i();
    } else {
      a = new h();
    }
  }
  
  public static Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    paramContext = a.a(paramContext, paramResources, paramInt1, paramString, paramInt3);
    if (paramContext != null)
    {
      paramResources = a(paramResources, paramInt1, paramString, paramInt2, paramInt3);
      c.put(paramResources, paramContext);
    }
    return paramContext;
  }
  
  private static Typeface a(Context paramContext, Typeface paramTypeface, int paramInt)
  {
    h localH = a;
    paramTypeface = localH.a(paramTypeface);
    if (paramTypeface == null) {
      return null;
    }
    return localH.a(paramContext, paramTypeface, paramContext.getResources(), paramInt);
  }
  
  public static Typeface a(Context paramContext, CancellationSignal paramCancellationSignal, Label[] paramArrayOfLabel, int paramInt)
  {
    return a.a(paramContext, paramCancellationSignal, paramArrayOfLabel, paramInt);
  }
  
  public static Typeface a(Context paramContext, androidx.core.content.asm.Object paramObject, Resources paramResources, int paramInt1, String paramString, int paramInt2, int paramInt3, d paramD, Handler paramHandler, boolean paramBoolean)
  {
    Typeface localTypeface;
    if ((paramObject instanceof NavigationMenuPresenter))
    {
      paramObject = (NavigationMenuPresenter)paramObject;
      localTypeface = get(paramObject.c());
      if (localTypeface != null)
      {
        paramObject = localTypeface;
        if (paramD == null) {
          return paramObject;
        }
        paramD.a(localTypeface, paramHandler);
        return localTypeface;
      }
      boolean bool;
      if (paramBoolean ? paramObject.i() == 0 : paramD == null) {
        bool = true;
      } else {
        bool = false;
      }
      int i;
      if (paramBoolean) {
        i = paramObject.f();
      } else {
        i = -1;
      }
      paramHandler = d.a(paramHandler);
      paramD = new e(paramD);
      paramContext = ClassReader.a(paramContext, paramObject.a(), paramInt3, bool, i, paramHandler, paramD);
    }
    else
    {
      localTypeface = a.a(paramContext, (androidx.core.content.asm.i)paramObject, paramResources, paramInt3);
      paramObject = localTypeface;
      paramContext = paramObject;
      if (paramD != null) {
        if (localTypeface != null)
        {
          paramD.a(localTypeface, paramHandler);
          paramContext = paramObject;
        }
        else
        {
          paramD.a(-3, paramHandler);
          paramContext = paramObject;
        }
      }
    }
    paramObject = paramContext;
    if (paramContext != null)
    {
      c.put(a(paramResources, paramInt1, paramString, paramInt2, paramInt3), paramContext);
      paramObject = paramContext;
    }
    return paramObject;
  }
  
  private static String a(Resources paramResources, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    paramResources = new StringBuilder(paramResources.getResourcePackageName(paramInt1));
    paramResources.append('-');
    paramResources.append(paramString);
    paramResources.append('-');
    paramResources.append(paramInt2);
    paramResources.append('-');
    paramResources.append(paramInt1);
    paramResources.append('-');
    paramResources.append(paramInt3);
    return paramResources.toString();
  }
  
  public static Typeface b(Resources paramResources, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    return (Typeface)c.get(a(paramResources, paramInt1, paramString, paramInt2, paramInt3));
  }
  
  public static Typeface get(Context paramContext, Typeface paramTypeface, int paramInt)
  {
    if (paramContext != null)
    {
      if (Build.VERSION.SDK_INT < 21)
      {
        paramContext = a(paramContext, paramTypeface, paramInt);
        if (paramContext != null) {
          return paramContext;
        }
      }
      return Typeface.create(paramTypeface, paramInt);
    }
    throw new IllegalArgumentException("Context cannot be null");
  }
  
  private static Typeface get(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.isEmpty()) {
        return null;
      }
      paramString = Typeface.create(paramString, 0);
      Typeface localTypeface = Typeface.create(Typeface.DEFAULT, 0);
      if ((paramString != null) && (!paramString.equals(localTypeface))) {
        return paramString;
      }
    }
    return null;
  }
}
