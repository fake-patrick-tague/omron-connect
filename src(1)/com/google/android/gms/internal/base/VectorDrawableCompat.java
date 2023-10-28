package com.google.android.gms.internal.base;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class VectorDrawableCompat
  extends Drawable
{
  private static final VectorDrawableCompat OK = new VectorDrawableCompat();
  private static final VectorDrawableCompat.VectorDrawableCompatState mVectorState = new VectorDrawableCompat.VectorDrawableCompatState(null);
  
  private VectorDrawableCompat() {}
  
  public final void draw(Canvas paramCanvas) {}
  
  public final Drawable.ConstantState getConstantState()
  {
    return mVectorState;
  }
  
  public final int getOpacity()
  {
    return -2;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}
