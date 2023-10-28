package androidx.core.content.diff;

import android.content.pm.PackageInfo;
import android.os.Build.VERSION;

public final class ClassReader
{
  public static long a(PackageInfo paramPackageInfo)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return a.read(paramPackageInfo);
    }
    return versionCode;
  }
}
