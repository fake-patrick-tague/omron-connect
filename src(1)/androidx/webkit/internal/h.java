package androidx.webkit.internal;

import android.os.Build.VERSION;
import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.a.a;

public class h
{
  static e a()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return new ClassWriter();
    }
    try
    {
      InvocationHandler localInvocationHandler = b();
      return new Scope((WebViewProviderFactoryBoundaryInterface)a.a(WebViewProviderFactoryBoundaryInterface.class, localInvocationHandler));
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new RuntimeException(localNoSuchMethodException);
      return new ClassWriter();
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new RuntimeException(localInvocationTargetException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException(localIllegalAccessException);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
  }
  
  private static InvocationHandler b()
    throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException
  {
    return (InvocationHandler)Class.forName("org.chromium.support_lib_glue.SupportLibReflectionUtil", false, load()).getDeclaredMethod("createWebViewProviderFactory", new Class[0]).invoke(null, new Object[0]);
  }
  
  public static c c()
  {
    return g.c;
  }
  
  private static Object get()
  {
    try
    {
      Object localObject = WebView.class.getDeclaredMethod("getFactory", new Class[0]);
      ((Method)localObject).setAccessible(true);
      localObject = ((Method)localObject).invoke(null, new Object[0]);
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new RuntimeException(localInvocationTargetException);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new RuntimeException(localNoSuchMethodException);
    }
  }
  
  public static e i()
  {
    return f.k;
  }
  
  public static ClassLoader load()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return WebView.getWebViewClassLoader();
    }
    return get().getClass().getClassLoader();
  }
}
