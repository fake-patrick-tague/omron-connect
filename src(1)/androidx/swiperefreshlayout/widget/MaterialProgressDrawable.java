package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import v7.text.view.menu.FastOutLinearInInterpolator;
import v7.v7.util.Log;

public class MaterialProgressDrawable
  extends Drawable
  implements Animatable
{
  private static final int[] COLORS = { -16777216 };
  private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
  private static final Interpolator sInterpolator = new FastOutLinearInInterpolator();
  private Animator mAnimator;
  boolean mFinishing;
  private Resources mResources;
  private final Ring mRing;
  private float mRotation;
  float y;
  
  public MaterialProgressDrawable(Context paramContext)
  {
    mResources = ((Context)Log.valueOf(paramContext)).getResources();
    paramContext = new Ring();
    mRing = paramContext;
    paramContext.setColors(COLORS);
    start(2.5F);
    startAnimation();
  }
  
  private void applyFinishTranslation(float paramFloat, Ring paramRing)
  {
    updateRingColor(paramFloat, paramRing);
    float f = (float)(Math.floor(paramRing.getStartingRotation() / 0.8F) + 1.0D);
    paramRing.setStartTrim(paramRing.getStartingStartTrim() + (paramRing.getStartingEndTrim() - 0.01F - paramRing.getStartingStartTrim()) * paramFloat);
    paramRing.setEndTrim(paramRing.getStartingEndTrim());
    paramRing.setRotation(paramRing.getStartingRotation() + (f - paramRing.getStartingRotation()) * paramFloat);
  }
  
  private int evaluateColorChange(float paramFloat, int paramInt1, int paramInt2)
  {
    int i = paramInt1 >> 24 & 0xFF;
    int j = paramInt1 >> 16 & 0xFF;
    int k = paramInt1 >> 8 & 0xFF;
    paramInt1 &= 0xFF;
    return i + (int)(((paramInt2 >> 24 & 0xFF) - i) * paramFloat) << 24 | j + (int)(((paramInt2 >> 16 & 0xFF) - j) * paramFloat) << 16 | k + (int)(((paramInt2 >> 8 & 0xFF) - k) * paramFloat) << 8 | paramInt1 + (int)(paramFloat * ((paramInt2 & 0xFF) - paramInt1));
  }
  
  private void setRotation(float paramFloat)
  {
    mRotation = paramFloat;
  }
  
  private void setSizeParameters(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Ring localRing = mRing;
    float f = mResources.getDisplayMetrics().density;
    localRing.setStrokeWidth(paramFloat2 * f);
    localRing.setArrowDimensions(paramFloat1 * f);
    localRing.setColorIndex(0);
    localRing.setArrowDimensions(paramFloat3 * f, paramFloat4 * f);
  }
  
  private void startAnimation()
  {
    Ring localRing = mRing;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new HoneycombMr1AnimatorCompatProvider.HoneycombValueAnimatorCompat.1(this, localRing));
    localValueAnimator.setRepeatCount(-1);
    localValueAnimator.setRepeatMode(1);
    localValueAnimator.setInterpolator(LINEAR_INTERPOLATOR);
    localValueAnimator.addListener(new ScrollingTabContainerView.VisibilityAnimListener(this, localRing));
    mAnimator = localValueAnimator;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    paramCanvas.save();
    paramCanvas.rotate(mRotation, localRect.exactCenterX(), localRect.exactCenterY());
    mRing.draw(paramCanvas, localRect);
    paramCanvas.restore();
  }
  
  public int getAlpha()
  {
    return mRing.getAlpha();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isRunning()
  {
    return mAnimator.isRunning();
  }
  
  public void setAlpha(int paramInt)
  {
    mRing.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setArrowScale(float paramFloat)
  {
    mRing.setArrowScale(paramFloat);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    mRing.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setColorSchemeColors(int... paramVarArgs)
  {
    mRing.setColors(paramVarArgs);
    mRing.setColorIndex(0);
    invalidateSelf();
  }
  
  public void setProgressRotation(float paramFloat)
  {
    mRing.setRotation(paramFloat);
    invalidateSelf();
  }
  
  public void setStartEndTrim(float paramFloat1, float paramFloat2)
  {
    mRing.setStartTrim(paramFloat1);
    mRing.setEndTrim(paramFloat2);
    invalidateSelf();
  }
  
  public void showArrow(boolean paramBoolean)
  {
    mRing.setShowArrow(paramBoolean);
    invalidateSelf();
  }
  
  public void start()
  {
    mAnimator.cancel();
    mRing.storeOriginals();
    if (mRing.getEndTrim() != mRing.getStartTrim())
    {
      mFinishing = true;
      mAnimator.setDuration(666L);
      mAnimator.start();
      return;
    }
    mRing.setColorIndex(0);
    mRing.resetOriginals();
    mAnimator.setDuration(1332L);
    mAnimator.start();
  }
  
  public void start(float paramFloat)
  {
    mRing.setStrokeWidth(paramFloat);
    invalidateSelf();
  }
  
  public void stop()
  {
    mAnimator.cancel();
    setRotation(0.0F);
    mRing.setShowArrow(false);
    mRing.setColorIndex(0);
    mRing.resetOriginals();
    invalidateSelf();
  }
  
  void update(float paramFloat, Ring paramRing, boolean paramBoolean)
  {
    if (mFinishing)
    {
      applyFinishTranslation(paramFloat, paramRing);
      return;
    }
    if ((paramFloat != 1.0F) || (paramBoolean))
    {
      float f3 = paramRing.getStartingRotation();
      float f2;
      float f1;
      if (paramFloat < 0.5F)
      {
        f4 = paramFloat / 0.5F;
        f2 = paramRing.getStartingStartTrim();
        f1 = f2;
        f2 = sInterpolator.getInterpolation(f4) * 0.79F + 0.01F + f2;
      }
      else
      {
        f1 = (paramFloat - 0.5F) / 0.5F;
        f2 = paramRing.getStartingStartTrim() + 0.79F;
        f1 = f2 - ((1.0F - sInterpolator.getInterpolation(f1)) * 0.79F + 0.01F);
      }
      float f4 = y;
      paramRing.setStartTrim(f1);
      paramRing.setEndTrim(f2);
      paramRing.setRotation(f3 + 0.20999998F * paramFloat);
      setRotation((paramFloat + f4) * 216.0F);
    }
  }
  
  void updateRingColor(float paramFloat, Ring paramRing)
  {
    if (paramFloat > 0.75F)
    {
      paramRing.setColor(evaluateColorChange((paramFloat - 0.75F) / 0.25F, paramRing.getStartingColor(), paramRing.getNextColor()));
      return;
    }
    paramRing.setColor(paramRing.getStartingColor());
  }
  
  public void updateSizes(int paramInt)
  {
    if (paramInt == 0) {
      setSizeParameters(11.0F, 3.0F, 12.0F, 6.0F);
    } else {
      setSizeParameters(7.5F, 2.5F, 10.0F, 5.0F);
    }
    invalidateSelf();
  }
  
  class Ring
  {
    int mAlpha;
    Path mArrow;
    int mArrowHeight;
    final Paint mArrowPaint;
    float mArrowScale;
    int mArrowWidth;
    final Paint mCirclePaint;
    int mColorIndex;
    int[] mColors;
    int mCurrentColor;
    float mEndTrim;
    final Paint mPaint;
    final RectF mRect = new RectF();
    float mRotation;
    boolean mShowArrow;
    float mStartTrim;
    float mStartingEndTrim;
    float mStartingRotation;
    float mStartingStartTrim;
    float width;
    float x;
    
    Ring()
    {
      this$1 = new Paint();
      mPaint = this$1;
      Paint localPaint1 = new Paint();
      mArrowPaint = localPaint1;
      Paint localPaint2 = new Paint();
      mCirclePaint = localPaint2;
      mStartTrim = 0.0F;
      mEndTrim = 0.0F;
      mRotation = 0.0F;
      x = 5.0F;
      mArrowScale = 1.0F;
      mAlpha = 255;
      this$1.setStrokeCap(Paint.Cap.SQUARE);
      this$1.setAntiAlias(true);
      this$1.setStyle(Paint.Style.STROKE);
      localPaint1.setStyle(Paint.Style.FILL);
      localPaint1.setAntiAlias(true);
      localPaint2.setColor(0);
    }
    
    void draw(Canvas paramCanvas, Rect paramRect)
    {
      RectF localRectF = mRect;
      float f2 = width;
      float f1 = x / 2.0F + f2;
      if (f2 <= 0.0F) {
        f1 = Math.min(paramRect.width(), paramRect.height()) / 2.0F - Math.max(mArrowWidth * mArrowScale / 2.0F, x / 2.0F);
      }
      localRectF.set(paramRect.centerX() - f1, paramRect.centerY() - f1, paramRect.centerX() + f1, paramRect.centerY() + f1);
      f1 = mStartTrim;
      f2 = mRotation;
      f1 = (f1 + f2) * 360.0F;
      f2 = (mEndTrim + f2) * 360.0F - f1;
      mPaint.setColor(mCurrentColor);
      mPaint.setAlpha(mAlpha);
      float f3 = x / 2.0F;
      localRectF.inset(f3, f3);
      paramCanvas.drawCircle(localRectF.centerX(), localRectF.centerY(), localRectF.width() / 2.0F, mCirclePaint);
      f3 = -f3;
      localRectF.inset(f3, f3);
      paramCanvas.drawArc(localRectF, f1, f2, false, mPaint);
      drawTriangle(paramCanvas, f1, f2, localRectF);
    }
    
    void drawTriangle(Canvas paramCanvas, float paramFloat1, float paramFloat2, RectF paramRectF)
    {
      if (mShowArrow)
      {
        Path localPath = mArrow;
        if (localPath == null)
        {
          localPath = new Path();
          mArrow = localPath;
          localPath.setFillType(Path.FillType.EVEN_ODD);
        }
        else
        {
          localPath.reset();
        }
        float f1 = Math.min(paramRectF.width(), paramRectF.height()) / 2.0F;
        float f2 = mArrowWidth * mArrowScale / 2.0F;
        mArrow.moveTo(0.0F, 0.0F);
        mArrow.lineTo(mArrowWidth * mArrowScale, 0.0F);
        localPath = mArrow;
        float f3 = mArrowWidth;
        float f4 = mArrowScale;
        localPath.lineTo(f3 * f4 / 2.0F, mArrowHeight * f4);
        mArrow.offset(f1 + paramRectF.centerX() - f2, paramRectF.centerY() + x / 2.0F);
        mArrow.close();
        mArrowPaint.setColor(mCurrentColor);
        mArrowPaint.setAlpha(mAlpha);
        paramCanvas.save();
        paramCanvas.rotate(paramFloat1 + paramFloat2, paramRectF.centerX(), paramRectF.centerY());
        paramCanvas.drawPath(mArrow, mArrowPaint);
        paramCanvas.restore();
      }
    }
    
    int getAlpha()
    {
      return mAlpha;
    }
    
    float getEndTrim()
    {
      return mEndTrim;
    }
    
    int getNextColor()
    {
      return mColors[getNextColorIndex()];
    }
    
    int getNextColorIndex()
    {
      return (mColorIndex + 1) % mColors.length;
    }
    
    float getStartTrim()
    {
      return mStartTrim;
    }
    
    int getStartingColor()
    {
      return mColors[mColorIndex];
    }
    
    float getStartingEndTrim()
    {
      return mStartingEndTrim;
    }
    
    float getStartingRotation()
    {
      return mStartingRotation;
    }
    
    float getStartingStartTrim()
    {
      return mStartingStartTrim;
    }
    
    void goToNextColor()
    {
      setColorIndex(getNextColorIndex());
    }
    
    void resetOriginals()
    {
      mStartingStartTrim = 0.0F;
      mStartingEndTrim = 0.0F;
      mStartingRotation = 0.0F;
      setStartTrim(0.0F);
      setEndTrim(0.0F);
      setRotation(0.0F);
    }
    
    void setAlpha(int paramInt)
    {
      mAlpha = paramInt;
    }
    
    void setArrowDimensions(float paramFloat)
    {
      width = paramFloat;
    }
    
    void setArrowDimensions(float paramFloat1, float paramFloat2)
    {
      mArrowWidth = ((int)paramFloat1);
      mArrowHeight = ((int)paramFloat2);
    }
    
    void setArrowScale(float paramFloat)
    {
      if (paramFloat != mArrowScale) {
        mArrowScale = paramFloat;
      }
    }
    
    void setColor(int paramInt)
    {
      mCurrentColor = paramInt;
    }
    
    void setColorFilter(ColorFilter paramColorFilter)
    {
      mPaint.setColorFilter(paramColorFilter);
    }
    
    void setColorIndex(int paramInt)
    {
      mColorIndex = paramInt;
      mCurrentColor = mColors[paramInt];
    }
    
    void setColors(int[] paramArrayOfInt)
    {
      mColors = paramArrayOfInt;
      setColorIndex(0);
    }
    
    void setEndTrim(float paramFloat)
    {
      mEndTrim = paramFloat;
    }
    
    void setRotation(float paramFloat)
    {
      mRotation = paramFloat;
    }
    
    void setShowArrow(boolean paramBoolean)
    {
      if (mShowArrow != paramBoolean) {
        mShowArrow = paramBoolean;
      }
    }
    
    void setStartTrim(float paramFloat)
    {
      mStartTrim = paramFloat;
    }
    
    void setStrokeWidth(float paramFloat)
    {
      x = paramFloat;
      mPaint.setStrokeWidth(paramFloat);
    }
    
    void storeOriginals()
    {
      mStartingStartTrim = mStartTrim;
      mStartingEndTrim = mEndTrim;
      mStartingRotation = mRotation;
    }
  }
}
