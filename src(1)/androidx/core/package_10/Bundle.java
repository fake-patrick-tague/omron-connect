package androidx.core.package_10;

import android.os.Build.VERSION;
import android.os.IBinder;

public final class Bundle
{
  public static IBinder getBinder(android.os.Bundle paramBundle, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return BundleCompatJellybeanMR2.getBinder(paramBundle, paramString);
    }
    return BundleCompatDonut.getBinder(paramBundle, paramString);
  }
  
  public static void putBinder(android.os.Bundle paramBundle, String paramString, IBinder paramIBinder)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      BundleCompatJellybeanMR2.putBinder(paramBundle, paramString, paramIBinder);
      return;
    }
    BundleCompatDonut.putBinder(paramBundle, paramString, paramIBinder);
  }
}
