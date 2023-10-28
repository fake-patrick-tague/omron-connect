package androidx.core.package_10;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class BundleCompatDonut
{
  private static Method sGetIBinderMethod;
  private static boolean sGetIBinderMethodFetched;
  private static Method sPutIBinderMethod;
  private static boolean sPutIBinderMethodFetched;
  
  public static IBinder getBinder(Bundle paramBundle, String paramString)
  {
    if (!sGetIBinderMethodFetched)
    {
      try
      {
        Method localMethod1 = Bundle.class.getMethod("getIBinder", new Class[] { String.class });
        sGetIBinderMethod = localMethod1;
        localMethod1.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.i("BundleCompatBaseImpl", "Failed to retrieve getIBinder method", localNoSuchMethodException);
      }
      sGetIBinderMethodFetched = true;
    }
    Method localMethod2 = sGetIBinderMethod;
    if (localMethod2 != null)
    {
      try
      {
        paramBundle = localMethod2.invoke(paramBundle, new Object[] { paramString });
        return (IBinder)paramBundle;
      }
      catch (IllegalArgumentException paramBundle) {}catch (IllegalAccessException paramBundle) {}catch (InvocationTargetException paramBundle) {}
      Log.i("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", paramBundle);
      sGetIBinderMethod = null;
    }
    return null;
  }
  
  public static void putBinder(Bundle paramBundle, String paramString, IBinder paramIBinder)
  {
    if (!sPutIBinderMethodFetched)
    {
      try
      {
        Method localMethod1 = Bundle.class.getMethod("putIBinder", new Class[] { String.class, IBinder.class });
        sPutIBinderMethod = localMethod1;
        localMethod1.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.i("BundleCompatBaseImpl", "Failed to retrieve putIBinder method", localNoSuchMethodException);
      }
      sPutIBinderMethodFetched = true;
    }
    Method localMethod2 = sPutIBinderMethod;
    if (localMethod2 != null)
    {
      try
      {
        localMethod2.invoke(paramBundle, new Object[] { paramString, paramIBinder });
        return;
      }
      catch (IllegalArgumentException paramBundle) {}catch (IllegalAccessException paramBundle) {}catch (InvocationTargetException paramBundle) {}
      Log.i("BundleCompatBaseImpl", "Failed to invoke putIBinder via reflection", paramBundle);
      sPutIBinderMethod = null;
    }
  }
}
