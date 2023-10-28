package androidx.core.widget;

import android.widget.EdgeEffect;

class CollapsingTextHelper
{
  static void draw(EdgeEffect paramEdgeEffect, float paramFloat1, float paramFloat2)
  {
    paramEdgeEffect.onPull(paramFloat1, paramFloat2);
  }
}
