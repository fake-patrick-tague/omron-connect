package androidx.core.content.asm;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;

class ContextCompat
{
  static int getColor(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    return paramResources.getColor(paramInt, paramTheme);
  }
  
  static ColorStateList getColorStateList(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    return paramResources.getColorStateList(paramInt, paramTheme);
  }
}
