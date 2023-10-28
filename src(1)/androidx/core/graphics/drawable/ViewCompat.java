package androidx.core.graphics.drawable;

import android.graphics.drawable.Drawable;

class ViewCompat
{
  static boolean a(Drawable paramDrawable, int paramInt)
  {
    return paramDrawable.setLayoutDirection(paramInt);
  }
  
  static int getLayoutDirection(Drawable paramDrawable)
  {
    return paramDrawable.getLayoutDirection();
  }
}
