package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import v7.nonstiff.b;
import v7.nonstiff.c;

class RoundRectDrawableWithShadow
  extends Drawable
{
  private static final double COS_45 = Math.cos(Math.toRadians(45.0D));
  static RoundRectHelper sRoundRectHelper;
  private boolean mAddPaddingForCorners = true;
  private ColorStateList mBorderColor;
  private final RectF mCardBounds;
  private float mCornerRadius;
  private Paint mCornerShadowPaint;
  private Path mCornerShadowPath;
  private boolean mDirty = true;
  private Paint mEdgeShadowPaint;
  private final int mInsetShadow;
  private Paint mPaint;
  private boolean mPrintedShadowClipWarning = false;
  private float mRawMaxShadowSize;
  private float mRawShadowSize;
  private final int mShadowEndColor;
  private float mShadowSize;
  private final int mShadowStartColor;
  
  RoundRectDrawableWithShadow(Resources paramResources, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    mShadowStartColor = paramResources.getColor(b.k);
    mShadowEndColor = paramResources.getColor(b.c);
    mInsetShadow = paramResources.getDimensionPixelSize(c.f);
    mPaint = new Paint(5);
    setColor(paramColorStateList);
    paramResources = new Paint(5);
    mCornerShadowPaint = paramResources;
    paramResources.setStyle(Paint.Style.FILL);
    mCornerRadius = ((int)(paramFloat1 + 0.5F));
    mCardBounds = new RectF();
    paramResources = new Paint(mCornerShadowPaint);
    mEdgeShadowPaint = paramResources;
    paramResources.setAntiAlias(false);
    setShadowSize(paramFloat2, paramFloat3);
  }
  
  private void buildComponents(Rect paramRect)
  {
    float f1 = mRawMaxShadowSize;
    float f2 = 1.5F * f1;
    mCardBounds.set(left + f1, top + f2, right - f1, bottom - f2);
    buildShadowCorners();
  }
  
  private void buildShadowCorners()
  {
    float f1 = mCornerRadius;
    Object localObject1 = new RectF(-f1, -f1, f1, f1);
    Object localObject2 = new RectF((RectF)localObject1);
    f1 = mShadowSize;
    ((RectF)localObject2).inset(-f1, -f1);
    Path localPath = mCornerShadowPath;
    if (localPath == null) {
      mCornerShadowPath = new Path();
    } else {
      localPath.reset();
    }
    mCornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
    mCornerShadowPath.moveTo(-mCornerRadius, 0.0F);
    mCornerShadowPath.rLineTo(-mShadowSize, 0.0F);
    mCornerShadowPath.arcTo((RectF)localObject2, 180.0F, 90.0F, false);
    mCornerShadowPath.arcTo((RectF)localObject1, 270.0F, -90.0F, false);
    mCornerShadowPath.close();
    f1 = mCornerRadius;
    f1 /= (mShadowSize + f1);
    localObject1 = mCornerShadowPaint;
    float f2 = mCornerRadius;
    float f3 = mShadowSize;
    int i = mShadowStartColor;
    int j = mShadowEndColor;
    localObject2 = Shader.TileMode.CLAMP;
    ((Paint)localObject1).setShader(new RadialGradient(0.0F, 0.0F, f2 + f3, new int[] { i, i, j }, new float[] { 0.0F, f1, 1.0F }, (Shader.TileMode)localObject2));
    localObject1 = mEdgeShadowPaint;
    f3 = mCornerRadius;
    f1 = -f3;
    f2 = mShadowSize;
    f3 = -f3;
    i = mShadowStartColor;
    j = mShadowEndColor;
    localObject2 = Shader.TileMode.CLAMP;
    ((Paint)localObject1).setShader(new LinearGradient(0.0F, f1 + f2, 0.0F, f3 - f2, new int[] { i, i, j }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject2));
    mEdgeShadowPaint.setAntiAlias(false);
  }
  
  static float calculateHorizontalPadding(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f = paramFloat1;
    if (paramBoolean) {
      f = (float)(paramFloat1 + (1.0D - COS_45) * paramFloat2);
    }
    return f;
  }
  
  static float calculateVerticalPadding(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (float)(paramFloat1 * 1.5F + (1.0D - COS_45) * paramFloat2);
    }
    return paramFloat1 * 1.5F;
  }
  
  private void drawShadow(Canvas paramCanvas)
  {
    float f2 = mCornerRadius;
    float f1 = -f2 - mShadowSize;
    f2 = f2 + mInsetShadow + mRawShadowSize / 2.0F;
    float f3 = mCardBounds.width();
    float f4 = f2 * 2.0F;
    if (f3 - f4 > 0.0F) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (mCardBounds.height() - f4 > 0.0F) {
      j = 1;
    } else {
      j = 0;
    }
    int k = paramCanvas.save();
    RectF localRectF = mCardBounds;
    paramCanvas.translate(left + f2, top + f2);
    paramCanvas.drawPath(mCornerShadowPath, mCornerShadowPaint);
    if (i != 0) {
      paramCanvas.drawRect(0.0F, f1, mCardBounds.width() - f4, -mCornerRadius, mEdgeShadowPaint);
    }
    paramCanvas.restoreToCount(k);
    k = paramCanvas.save();
    localRectF = mCardBounds;
    paramCanvas.translate(right - f2, bottom - f2);
    paramCanvas.rotate(180.0F);
    paramCanvas.drawPath(mCornerShadowPath, mCornerShadowPaint);
    if (i != 0) {
      paramCanvas.drawRect(0.0F, f1, mCardBounds.width() - f4, -mCornerRadius + mShadowSize, mEdgeShadowPaint);
    }
    paramCanvas.restoreToCount(k);
    int i = paramCanvas.save();
    localRectF = mCardBounds;
    paramCanvas.translate(left + f2, bottom - f2);
    paramCanvas.rotate(270.0F);
    paramCanvas.drawPath(mCornerShadowPath, mCornerShadowPaint);
    if (j != 0) {
      paramCanvas.drawRect(0.0F, f1, mCardBounds.height() - f4, -mCornerRadius, mEdgeShadowPaint);
    }
    paramCanvas.restoreToCount(i);
    i = paramCanvas.save();
    localRectF = mCardBounds;
    paramCanvas.translate(right - f2, top + f2);
    paramCanvas.rotate(90.0F);
    paramCanvas.drawPath(mCornerShadowPath, mCornerShadowPaint);
    if (j != 0) {
      paramCanvas.drawRect(0.0F, f1, mCardBounds.height() - f4, -mCornerRadius, mEdgeShadowPaint);
    }
    paramCanvas.restoreToCount(i);
  }
  
  private void setColor(ColorStateList paramColorStateList)
  {
    ColorStateList localColorStateList = paramColorStateList;
    if (paramColorStateList == null) {
      localColorStateList = ColorStateList.valueOf(0);
    }
    mBorderColor = localColorStateList;
    mPaint.setColor(localColorStateList.getColorForState(getState(), mBorderColor.getDefaultColor()));
  }
  
  private void setShadowSize(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 >= 0.0F)
    {
      if (paramFloat2 >= 0.0F)
      {
        float f = toEven(paramFloat1);
        paramFloat2 = toEven(paramFloat2);
        paramFloat1 = f;
        if (f > paramFloat2)
        {
          if (!mPrintedShadowClipWarning) {
            mPrintedShadowClipWarning = true;
          }
          paramFloat1 = paramFloat2;
        }
        if ((mRawShadowSize == paramFloat1) && (mRawMaxShadowSize == paramFloat2)) {
          return;
        }
        mRawShadowSize = paramFloat1;
        mRawMaxShadowSize = paramFloat2;
        mShadowSize = ((int)(paramFloat1 * 1.5F + mInsetShadow + 0.5F));
        mDirty = true;
        invalidateSelf();
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid max shadow size ");
      localStringBuilder.append(paramFloat2);
      localStringBuilder.append(". Must be >= 0");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid shadow size ");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append(". Must be >= 0");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private int toEven(float paramFloat)
  {
    int j = (int)(paramFloat + 0.5F);
    int i = j;
    if (j % 2 == 1) {
      i = j - 1;
    }
    return i;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (mDirty)
    {
      buildComponents(getBounds());
      mDirty = false;
    }
    paramCanvas.translate(0.0F, mRawShadowSize / 2.0F);
    drawShadow(paramCanvas);
    paramCanvas.translate(0.0F, -mRawShadowSize / 2.0F);
    sRoundRectHelper.drawRoundRect(paramCanvas, mCardBounds, mCornerRadius, mPaint);
  }
  
  float getCornerRadius()
  {
    return mCornerRadius;
  }
  
  void getMaxShadowAndCornerPadding(Rect paramRect)
  {
    getPadding(paramRect);
  }
  
  float getMaxShadowSize()
  {
    return mRawMaxShadowSize;
  }
  
  float getMinHeight()
  {
    float f = mRawMaxShadowSize;
    return Math.max(f, mCornerRadius + mInsetShadow + f * 1.5F / 2.0F) * 2.0F + (mRawMaxShadowSize * 1.5F + mInsetShadow) * 2.0F;
  }
  
  float getMinWidth()
  {
    float f = mRawMaxShadowSize;
    return Math.max(f, mCornerRadius + mInsetShadow + f / 2.0F) * 2.0F + (mRawMaxShadowSize + mInsetShadow) * 2.0F;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    int i = (int)Math.ceil(calculateVerticalPadding(mRawMaxShadowSize, mCornerRadius, mAddPaddingForCorners));
    int j = (int)Math.ceil(calculateHorizontalPadding(mRawMaxShadowSize, mCornerRadius, mAddPaddingForCorners));
    paramRect.set(j, i, j, i);
    return true;
  }
  
  float getShadowSize()
  {
    return mRawShadowSize;
  }
  
  public boolean isStateful()
  {
    ColorStateList localColorStateList = mBorderColor;
    return ((localColorStateList != null) && (localColorStateList.isStateful())) || (super.isStateful());
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    mDirty = true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    ColorStateList localColorStateList = mBorderColor;
    int i = localColorStateList.getColorForState(paramArrayOfInt, localColorStateList.getDefaultColor());
    if (mPaint.getColor() == i) {
      return false;
    }
    mPaint.setColor(i);
    mDirty = true;
    invalidateSelf();
    return true;
  }
  
  void setAddPaddingForCorners(boolean paramBoolean)
  {
    mAddPaddingForCorners = paramBoolean;
    invalidateSelf();
  }
  
  public void setAlpha(int paramInt)
  {
    mPaint.setAlpha(paramInt);
    mCornerShadowPaint.setAlpha(paramInt);
    mEdgeShadowPaint.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    mPaint.setColorFilter(paramColorFilter);
  }
  
  ColorStateList setCornerRadius()
  {
    return mBorderColor;
  }
  
  void setCornerRadius(float paramFloat)
  {
    if (paramFloat >= 0.0F)
    {
      paramFloat = (int)(paramFloat + 0.5F);
      if (mCornerRadius == paramFloat) {
        return;
      }
      mCornerRadius = paramFloat;
      mDirty = true;
      invalidateSelf();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid radius ");
    localStringBuilder.append(paramFloat);
    localStringBuilder.append(". Must be >= 0");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  void setMaxShadowSize(float paramFloat)
  {
    setShadowSize(mRawShadowSize, paramFloat);
  }
  
  void setShadowSize(float paramFloat)
  {
    setShadowSize(paramFloat, mRawMaxShadowSize);
  }
  
  void setShadowSize(ColorStateList paramColorStateList)
  {
    setColor(paramColorStateList);
    invalidateSelf();
  }
  
  abstract interface RoundRectHelper
  {
    public abstract void drawRoundRect(Canvas paramCanvas, RectF paramRectF, float paramFloat, Paint paramPaint);
  }
}
