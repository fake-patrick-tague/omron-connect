package androidx.appcompat.widget;

import android.graphics.drawable.LayerDrawable;

class StateListAnimator
{
  public static void addState(LayerDrawable paramLayerDrawable1, LayerDrawable paramLayerDrawable2, int paramInt)
  {
    paramLayerDrawable2.setLayerGravity(paramInt, paramLayerDrawable1.getLayerGravity(paramInt));
    paramLayerDrawable2.setLayerWidth(paramInt, paramLayerDrawable1.getLayerWidth(paramInt));
    paramLayerDrawable2.setLayerHeight(paramInt, paramLayerDrawable1.getLayerHeight(paramInt));
    paramLayerDrawable2.setLayerInsetLeft(paramInt, paramLayerDrawable1.getLayerInsetLeft(paramInt));
    paramLayerDrawable2.setLayerInsetRight(paramInt, paramLayerDrawable1.getLayerInsetRight(paramInt));
    paramLayerDrawable2.setLayerInsetTop(paramInt, paramLayerDrawable1.getLayerInsetTop(paramInt));
    paramLayerDrawable2.setLayerInsetBottom(paramInt, paramLayerDrawable1.getLayerInsetBottom(paramInt));
    paramLayerDrawable2.setLayerInsetStart(paramInt, paramLayerDrawable1.getLayerInsetStart(paramInt));
    paramLayerDrawable2.setLayerInsetEnd(paramInt, paramLayerDrawable1.getLayerInsetEnd(paramInt));
  }
}
