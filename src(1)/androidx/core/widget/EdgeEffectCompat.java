package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.EdgeEffect;

public final class EdgeEffectCompat
{
  private final EdgeEffect IMPL;
  
  public EdgeEffectCompat(Context paramContext)
  {
    IMPL = new EdgeEffect(paramContext);
  }
  
  public static EdgeEffect a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 31) {
      return LayoutManager.a(paramContext, paramAttributeSet);
    }
    return new EdgeEffect(paramContext);
  }
  
  public static float add(EdgeEffect paramEdgeEffect, float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 31) {
      return LayoutManager.draw(paramEdgeEffect, paramFloat1, paramFloat2);
    }
    draw(paramEdgeEffect, paramFloat1, paramFloat2);
    return paramFloat1;
  }
  
  public static float draw(EdgeEffect paramEdgeEffect)
  {
    if (Build.VERSION.SDK_INT >= 31) {
      return LayoutManager.draw(paramEdgeEffect);
    }
    return 0.0F;
  }
  
  public static void draw(EdgeEffect paramEdgeEffect, float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      CollapsingTextHelper.draw(paramEdgeEffect, paramFloat1, paramFloat2);
      return;
    }
    paramEdgeEffect.onPull(paramFloat1);
  }
  
  public void draw(int paramInt1, int paramInt2)
  {
    IMPL.setSize(paramInt1, paramInt2);
  }
  
  public boolean draw(Canvas paramCanvas)
  {
    return IMPL.draw(paramCanvas);
  }
  
  public boolean isFinished()
  {
    return IMPL.isFinished();
  }
  
  public boolean onAbsorb(int paramInt)
  {
    IMPL.onAbsorb(paramInt);
    return true;
  }
  
  public boolean onPull(float paramFloat)
  {
    IMPL.onPull(paramFloat);
    return true;
  }
  
  public boolean onRelease()
  {
    IMPL.onRelease();
    return IMPL.isFinished();
  }
}
