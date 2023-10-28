package androidx.core.content;

import android.content.Context;
import java.io.File;

class ContextCompatKitKat
{
  static File[] getExternalCacheDirs(Context paramContext)
  {
    return paramContext.getExternalCacheDirs();
  }
  
  static File[] getExternalFilesDirs(Context paramContext, String paramString)
  {
    return paramContext.getExternalFilesDirs(paramString);
  }
  
  static File[] getObbDirs(Context paramContext)
  {
    return paramContext.getObbDirs();
  }
}
