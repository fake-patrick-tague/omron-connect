package com.google.android.material.floatingactionbutton;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import androidx.core.graphics.ColorUtils;
import org.org.org.ui.asm.Context;
import org.org.org.ui.asm.l;
import org.org.org.ui.asm.m;

class CircularBorderDrawable
  extends Drawable
{
  private m left;
  private ColorStateList mBorderTint;
  float mBorderWidth;
  private int mBottomInnerStrokeColor;
  private int mBottomOuterStrokeColor;
  private final Rect mBounds = new Rect();
  private int mCurrentBorderTintColor;
  private boolean mInvalidateShader = true;
  private final Paint mPaint;
  private final Path mPath = new Path();
  private final RectF mRect = new RectF();
  private final RectF mRectF = new RectF();
  private final DrawableWrapperDonut.DrawableWrapperState mState = new DrawableWrapperDonut.DrawableWrapperState(this, null);
  private int mTopInnerStrokeColor;
  private int mTopOuterStrokeColor;
  private final l this$0 = l.access$getDecoder();
  
  CircularBorderDrawable(m paramM)
  {
    left = paramM;
    paramM = new Paint(1);
    mPaint = paramM;
    paramM.setStyle(Paint.Style.STROKE);
  }
  
  private Shader createGradientShader()
  {
    Object localObject = mBounds;
    copyBounds((Rect)localObject);
    float f1 = mBorderWidth / ((Rect)localObject).height();
    int i = ColorUtils.compositeColors(mBottomOuterStrokeColor, mCurrentBorderTintColor);
    int j = ColorUtils.compositeColors(mBottomInnerStrokeColor, mCurrentBorderTintColor);
    int k = ColorUtils.compositeColors(ColorUtils.setAlphaComponent(mBottomInnerStrokeColor, 0), mCurrentBorderTintColor);
    int m = ColorUtils.compositeColors(ColorUtils.setAlphaComponent(mTopInnerStrokeColor, 0), mCurrentBorderTintColor);
    int n = ColorUtils.compositeColors(mTopInnerStrokeColor, mCurrentBorderTintColor);
    int i1 = ColorUtils.compositeColors(mTopOuterStrokeColor, mCurrentBorderTintColor);
    float f2 = top;
    float f3 = bottom;
    localObject = Shader.TileMode.CLAMP;
    return new LinearGradient(0.0F, f2, 0.0F, f3, new int[] { i, j, k, m, n, i1 }, new float[] { 0.0F, f1, 0.5F, 0.5F, 1.0F - f1, 1.0F }, (Shader.TileMode)localObject);
  }
  
  protected RectF draw()
  {
    mRectF.set(getBounds());
    return mRectF;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (mInvalidateShader)
    {
      mPaint.setShader(createGradientShader());
      mInvalidateShader = false;
    }
    float f1 = mPaint.getStrokeWidth() / 2.0F;
    copyBounds(mBounds);
    mRect.set(mBounds);
    float f2 = Math.min(left.c().a(draw()), mRect.width() / 2.0F);
    if (left.a(draw()))
    {
      mRect.inset(f1, f1);
      paramCanvas.drawRoundRect(mRect, f2, f2, mPaint);
    }
  }
  
  public void draw(m paramM)
  {
    left = paramM;
    invalidateSelf();
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return mState;
  }
  
  public int getOpacity()
  {
    if (mBorderWidth > 0.0F) {
      return -3;
    }
    return -2;
  }
  
  public void getOutline(Outline paramOutline)
  {
    if (left.a(draw()))
    {
      float f = left.c().a(draw());
      paramOutline.setRoundRect(getBounds(), f);
      return;
    }
    copyBounds(mBounds);
    mRect.set(mBounds);
    this$0.a(left, 1.0F, mRect, mPath);
    if (mPath.isConvex()) {
      paramOutline.setConvexPath(mPath);
    }
  }
  
  public boolean getPadding(Rect paramRect)
  {
    if (left.a(draw()))
    {
      int i = Math.round(mBorderWidth);
      paramRect.set(i, i, i, i);
    }
    return true;
  }
  
  public boolean isStateful()
  {
    ColorStateList localColorStateList = mBorderTint;
    return ((localColorStateList != null) && (localColorStateList.isStateful())) || (super.isStateful());
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    mInvalidateShader = true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    ColorStateList localColorStateList = mBorderTint;
    if (localColorStateList != null)
    {
      int i = localColorStateList.getColorForState(paramArrayOfInt, mCurrentBorderTintColor);
      if (i != mCurrentBorderTintColor)
      {
        mInvalidateShader = true;
        mCurrentBorderTintColor = i;
      }
    }
    if (mInvalidateShader) {
      invalidateSelf();
    }
    return mInvalidateShader;
  }
  
  public void setAlpha(int paramInt)
  {
    mPaint.setAlpha(paramInt);
    invalidateSelf();
  }
  
  void setBorderTint(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null) {
      mCurrentBorderTintColor = paramColorStateList.getColorForState(getState(), mCurrentBorderTintColor);
    }
    mBorderTint = paramColorStateList;
    mInvalidateShader = true;
    invalidateSelf();
  }
  
  public void setBorderWidth(float paramFloat)
  {
    if (mBorderWidth != paramFloat)
    {
      mBorderWidth = paramFloat;
      mPaint.setStrokeWidth(paramFloat * 1.3333F);
      mInvalidateShader = true;
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    mPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  void setGradientColors(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    mBottomOuterStrokeColor = paramInt1;
    mBottomInnerStrokeColor = paramInt2;
    mTopOuterStrokeColor = paramInt3;
    mTopInnerStrokeColor = paramInt4;
  }
}
