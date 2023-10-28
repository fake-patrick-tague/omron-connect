package androidx.core.package_10;

import android.app.Notification.BubbleMetadata;
import android.os.Build.VERSION;

public final class MethodInfo
{
  public static Notification.BubbleMetadata read(MethodInfo paramMethodInfo)
  {
    if (paramMethodInfo == null) {
      return null;
    }
    int i = Build.VERSION.SDK_INT;
    if (i >= 30) {
      return m.d.b.invoke(paramMethodInfo);
    }
    if (i == 29) {
      return m.d.a.invoke(paramMethodInfo);
    }
    return null;
  }
}
