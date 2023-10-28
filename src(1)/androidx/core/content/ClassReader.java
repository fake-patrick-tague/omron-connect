package androidx.core.content;

import android.content.Context;
import java.io.File;

class ClassReader
{
  static File a(Context paramContext)
  {
    return paramContext.getDataDir();
  }
  
  static boolean accept(Context paramContext)
  {
    return paramContext.isDeviceProtectedStorage();
  }
  
  static Context b(Context paramContext)
  {
    return paramContext.createDeviceProtectedStorageContext();
  }
}
