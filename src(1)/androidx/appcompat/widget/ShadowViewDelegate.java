package androidx.appcompat.widget;

import android.graphics.Outline;
import android.graphics.drawable.Drawable;

class ShadowViewDelegate
{
  public static void setBackgroundDrawable(Drawable paramDrawable, Outline paramOutline)
  {
    paramDrawable.getOutline(paramOutline);
  }
}
