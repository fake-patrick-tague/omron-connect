package com.alivecor.mapsforge.record;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

class EcgGridView
  extends View
{
  private Path mBorderPath;
  private int mHeight;
  private Paint mMajorGridPaint;
  private Path mMajorGridPath;
  private float mMajorGridlineStrokeWidthPixels = TypedValue.applyDimension(1, 1.0F, getResources().getDisplayMetrics());
  private Paint mMinorGridPaint;
  private Path mMinorGridPath;
  private float mScale;
  private int mWidth;
  private float mXppcm;
  private float mYppcm;
  
  public EcgGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new Paint();
    mMajorGridPaint = paramContext;
    paramContext.setAntiAlias(true);
    mMajorGridPaint.setStrokeWidth(mMajorGridlineStrokeWidthPixels);
    mMajorGridPaint.setColor(Color.rgb(232, 232, 232));
    mMajorGridPaint.setStyle(Paint.Style.STROKE);
    paramContext = new Paint();
    mMinorGridPaint = paramContext;
    paramContext.setAntiAlias(true);
    mMinorGridPaint.setStrokeWidth(mMajorGridlineStrokeWidthPixels * 0.5F);
    mMinorGridPaint.setColor(Color.rgb(232, 232, 232));
    mMinorGridPaint.setStyle(Paint.Style.STROKE);
    setBackgroundColor(-1);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawPath(mMinorGridPath, mMinorGridPaint);
    paramCanvas.drawPath(mMajorGridPath, mMajorGridPaint);
    paramCanvas.drawPath(mBorderPath, mMajorGridPaint);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    rescale(paramInt1, paramInt2);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  void rescale(int paramInt1, int paramInt2)
  {
    WindowManager localWindowManager = (WindowManager)getContext().getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    float f2 = xdpi / 2.54F;
    float f1 = mScale;
    f2 *= f1;
    mXppcm = f2;
    mYppcm = (ydpi / 2.54F * f1);
    mYppcm = f2;
    mWidth = paramInt1;
    mHeight = paramInt2;
    setupGridPaths();
  }
  
  void setScale(float paramFloat)
  {
    mScale = paramFloat;
    rescale(getWidth(), getHeight());
    postInvalidate();
  }
  
  void setupGridPaths()
  {
    if (mMinorGridPath == null)
    {
      mMinorGridPath = new Path();
      mMajorGridPath = new Path();
      mBorderPath = new Path();
    }
    mMinorGridPath.rewind();
    mMajorGridPath.rewind();
    mBorderPath.rewind();
    int m = (int)(mWidth / (mXppcm / 10.0F));
    int j = 1;
    int k = 0;
    int i = 0;
    float f1 = 0.0F;
    while (i < m + 1)
    {
      if (i % 5 != 0)
      {
        mMinorGridPath.moveTo(f1, 0.0F);
        mMinorGridPath.lineTo(f1, mHeight);
      }
      f1 += mXppcm / 10.0F;
      i += 1;
    }
    m = (int)(mHeight / (mYppcm / 10.0F));
    i = 0;
    f1 = 0.0F;
    while (i < (m + 1) / 2)
    {
      if (i % 5 != 0)
      {
        mMinorGridPath.moveTo(0.0F, mHeight / 2 + f1);
        mMinorGridPath.lineTo(mWidth, mHeight / 2 + f1);
        mMinorGridPath.moveTo(0.0F, mHeight / 2 - f1);
        mMinorGridPath.lineTo(mWidth, mHeight / 2 - f1);
      }
      f1 += mYppcm / 10.0F;
      i += 1;
    }
    m = (int)(mWidth * 2 / mXppcm);
    f1 = 0.0F;
    i = k;
    while (i < m + 1)
    {
      mMajorGridPath.moveTo(f1, 0.0F);
      mMajorGridPath.lineTo(f1, mHeight);
      f1 += mXppcm / 2.0F;
      i += 1;
    }
    mMajorGridPath.moveTo(0.0F, mHeight / 2);
    mMajorGridPath.lineTo(mWidth, mHeight / 2);
    f1 = mHeight * 2;
    float f2 = mYppcm;
    k = (int)(f1 / f2);
    f1 = f2 / 2.0F;
    i = j;
    while (i < (k + 2) / 2)
    {
      mMajorGridPath.moveTo(0.0F, mHeight / 2 + f1);
      mMajorGridPath.lineTo(mWidth, mHeight / 2 + f1);
      mMajorGridPath.moveTo(0.0F, mHeight / 2 - f1);
      mMajorGridPath.lineTo(mWidth, mHeight / 2 - f1);
      f1 += mYppcm / 2.0F;
      i += 1;
    }
    mBorderPath.moveTo(0.0F, 0.0F);
    mBorderPath.lineTo(mWidth, 0.0F);
    mBorderPath.lineTo(mWidth, mHeight);
    mBorderPath.lineTo(0.0F, mHeight);
    mBorderPath.lineTo(0.0F, 0.0F);
  }
}
