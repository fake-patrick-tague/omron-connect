package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EdgeEffect;

class LayoutManager
{
  public static EdgeEffect a(Context paramContext, AttributeSet paramAttributeSet)
  {
    try
    {
      paramAttributeSet = new EdgeEffect(paramContext, paramAttributeSet);
      return paramAttributeSet;
    }
    catch (Throwable paramAttributeSet)
    {
      for (;;) {}
    }
    return new EdgeEffect(paramContext);
  }
  
  public static float draw(EdgeEffect paramEdgeEffect)
  {
    try
    {
      float f = paramEdgeEffect.getDistance();
      return f;
    }
    catch (Throwable paramEdgeEffect)
    {
      for (;;) {}
    }
    return 0.0F;
  }
  
  public static float draw(EdgeEffect paramEdgeEffect, float paramFloat1, float paramFloat2)
  {
    try
    {
      float f = paramEdgeEffect.onPullDistance(paramFloat1, paramFloat2);
      return f;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    paramEdgeEffect.onPull(paramFloat1, paramFloat2);
    return 0.0F;
  }
}
