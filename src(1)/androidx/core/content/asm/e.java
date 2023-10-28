package androidx.core.content.asm;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;

class e
{
  final Configuration a;
  final ColorStateList c;
  final int f;
  
  e(ColorStateList paramColorStateList, Configuration paramConfiguration, Resources.Theme paramTheme)
  {
    c = paramColorStateList;
    a = paramConfiguration;
    int i;
    if (paramTheme == null) {
      i = 0;
    } else {
      i = paramTheme.hashCode();
    }
    f = i;
  }
}
