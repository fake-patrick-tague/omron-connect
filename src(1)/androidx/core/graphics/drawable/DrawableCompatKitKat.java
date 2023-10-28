package androidx.core.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.DrawableWrapper;
import android.graphics.drawable.InsetDrawable;

class DrawableCompatKitKat
{
  static int getAlpha(Drawable paramDrawable)
  {
    return paramDrawable.getAlpha();
  }
  
  static Drawable getIcon(InsetDrawable paramInsetDrawable)
  {
    return paramInsetDrawable.getDrawable();
  }
  
  static Drawable getItem(DrawableContainer.DrawableContainerState paramDrawableContainerState, int paramInt)
  {
    return paramDrawableContainerState.getChild(paramInt);
  }
  
  static boolean isAutoMirrored(Drawable paramDrawable)
  {
    return paramDrawable.isAutoMirrored();
  }
  
  static void setAutoMirrored(Drawable paramDrawable, boolean paramBoolean)
  {
    paramDrawable.setAutoMirrored(paramBoolean);
  }
}
