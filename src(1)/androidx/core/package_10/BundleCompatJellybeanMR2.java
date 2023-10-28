package androidx.core.package_10;

import android.os.Bundle;
import android.os.IBinder;

class BundleCompatJellybeanMR2
{
  static IBinder getBinder(Bundle paramBundle, String paramString)
  {
    return paramBundle.getBinder(paramString);
  }
  
  static void putBinder(Bundle paramBundle, String paramString, IBinder paramIBinder)
  {
    paramBundle.putBinder(paramString, paramIBinder);
  }
}
