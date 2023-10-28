package androidx.core.content.asm;

import android.content.res.Resources.Theme;
import android.os.Build.VERSION;

public final class k
{
  public static void onItemClick(Resources.Theme paramTheme)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 29)
    {
      j.g.b.create(paramTheme);
      return;
    }
    if (i >= 23) {
      j.g.a.a(paramTheme);
    }
  }
}
