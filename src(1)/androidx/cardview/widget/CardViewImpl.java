package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;

abstract interface CardViewImpl
{
  public abstract float getElevation(CardViewDelegate paramCardViewDelegate);
  
  public abstract float getMaxElevation(CardViewDelegate paramCardViewDelegate);
  
  public abstract float getMinHeight(CardViewDelegate paramCardViewDelegate);
  
  public abstract float getMinWidth(CardViewDelegate paramCardViewDelegate);
  
  public abstract float getRadius(CardViewDelegate paramCardViewDelegate);
  
  public abstract void initStatic();
  
  public abstract void initialize(CardViewDelegate paramCardViewDelegate, Context paramContext, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void onCompatPaddingChanged(CardViewDelegate paramCardViewDelegate);
  
  public abstract void onPreventCornerOverlapChanged(CardViewDelegate paramCardViewDelegate);
  
  public abstract void setBackgroundColor(CardViewDelegate paramCardViewDelegate, ColorStateList paramColorStateList);
  
  public abstract void setElevation(CardViewDelegate paramCardViewDelegate, float paramFloat);
  
  public abstract void setMaxElevation(CardViewDelegate paramCardViewDelegate, float paramFloat);
  
  public abstract ColorStateList setRadius(CardViewDelegate paramCardViewDelegate);
  
  public abstract void setRadius(CardViewDelegate paramCardViewDelegate, float paramFloat);
}
