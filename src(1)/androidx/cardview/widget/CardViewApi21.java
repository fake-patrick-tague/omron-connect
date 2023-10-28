package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

class CardViewApi21
  implements CardViewImpl
{
  CardViewApi21() {}
  
  private RoundRectDrawable getShadowBackground(CardViewDelegate paramCardViewDelegate)
  {
    return (RoundRectDrawable)paramCardViewDelegate.getBackground();
  }
  
  public float getElevation(CardViewDelegate paramCardViewDelegate)
  {
    return paramCardViewDelegate.get().getElevation();
  }
  
  public float getMaxElevation(CardViewDelegate paramCardViewDelegate)
  {
    return getShadowBackground(paramCardViewDelegate).getPadding();
  }
  
  public float getMinHeight(CardViewDelegate paramCardViewDelegate)
  {
    return getRadius(paramCardViewDelegate) * 2.0F;
  }
  
  public float getMinWidth(CardViewDelegate paramCardViewDelegate)
  {
    return getRadius(paramCardViewDelegate) * 2.0F;
  }
  
  public float getRadius(CardViewDelegate paramCardViewDelegate)
  {
    return getShadowBackground(paramCardViewDelegate).getRadius();
  }
  
  public void initStatic() {}
  
  public void initialize(CardViewDelegate paramCardViewDelegate, Context paramContext, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramCardViewDelegate.setBackgroundDrawable(new RoundRectDrawable(paramColorStateList, paramFloat1));
    paramContext = paramCardViewDelegate.get();
    paramContext.setClipToOutline(true);
    paramContext.setElevation(paramFloat2);
    setMaxElevation(paramCardViewDelegate, paramFloat3);
  }
  
  public void onCompatPaddingChanged(CardViewDelegate paramCardViewDelegate)
  {
    setMaxElevation(paramCardViewDelegate, getMaxElevation(paramCardViewDelegate));
  }
  
  public void onPreventCornerOverlapChanged(CardViewDelegate paramCardViewDelegate)
  {
    setMaxElevation(paramCardViewDelegate, getMaxElevation(paramCardViewDelegate));
  }
  
  public void setBackgroundColor(CardViewDelegate paramCardViewDelegate, ColorStateList paramColorStateList)
  {
    getShadowBackground(paramCardViewDelegate).setColor(paramColorStateList);
  }
  
  public void setElevation(CardViewDelegate paramCardViewDelegate, float paramFloat)
  {
    paramCardViewDelegate.get().setElevation(paramFloat);
  }
  
  public void setMaxElevation(CardViewDelegate paramCardViewDelegate, float paramFloat)
  {
    getShadowBackground(paramCardViewDelegate).setPadding(paramFloat, paramCardViewDelegate.getUseCompatPadding(), paramCardViewDelegate.getPreventCornerOverlap());
    updatePadding(paramCardViewDelegate);
  }
  
  public ColorStateList setRadius(CardViewDelegate paramCardViewDelegate)
  {
    return getShadowBackground(paramCardViewDelegate).setColor();
  }
  
  public void setRadius(CardViewDelegate paramCardViewDelegate, float paramFloat)
  {
    getShadowBackground(paramCardViewDelegate).setRadius(paramFloat);
  }
  
  public void updatePadding(CardViewDelegate paramCardViewDelegate)
  {
    if (!paramCardViewDelegate.getUseCompatPadding())
    {
      paramCardViewDelegate.setShadowPadding(0, 0, 0, 0);
      return;
    }
    float f1 = getMaxElevation(paramCardViewDelegate);
    float f2 = getRadius(paramCardViewDelegate);
    int i = (int)Math.ceil(RoundRectDrawableWithShadow.calculateHorizontalPadding(f1, f2, paramCardViewDelegate.getPreventCornerOverlap()));
    int j = (int)Math.ceil(RoundRectDrawableWithShadow.calculateVerticalPadding(f1, f2, paramCardViewDelegate.getPreventCornerOverlap()));
    paramCardViewDelegate.setShadowPadding(i, j, i, j);
  }
}
