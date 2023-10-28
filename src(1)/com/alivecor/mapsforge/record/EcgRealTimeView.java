package com.alivecor.mapsforge.record;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.WindowManager;
import l.a.a;

public class EcgRealTimeView
  extends View
{
  private static final String PAGE_KEY = "EcgRealTimeView";
  private final int SWEEPBAR_WIDTH = 4;
  private short[] ecgTempBuf = new short[1];
  private CirIntBuffer mAnnotationBuffer;
  private float mAnnotationMarkerHeightPixels = TypedValue.applyDimension(1, 5.0F, getResources().getDisplayMetrics());
  private DisplayMetrics mDisplayMetrics;
  private CirShortBuffer mEcgBuffer;
  private int mHeight;
  private boolean mInitalized = false;
  private Paint mPaintAnn = new Paint();
  private Paint mPaintEcg = new Paint();
  private Path mPath;
  private int mSamplesPerWidth;
  private float mScaleFactor = 1.0F;
  private int mWidth;
  IOnWinFocusChangeListener mWinFocusChangeListener;
  private float mXScale;
  private float mXppcm;
  private float mYOffset;
  private float mYScale;
  private float mYppcm;
  
  public EcgRealTimeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    float f = TypedValue.applyDimension(1, 1.0F, getResources().getDisplayMetrics());
    int i = Color.rgb(102, 102, 102);
    mPaintEcg.setColor(i);
    mPaintEcg.setStrokeWidth(f);
    mPaintEcg.setAntiAlias(true);
    mPaintEcg.setStrokeCap(Paint.Cap.ROUND);
    mPaintEcg.setStrokeJoin(Paint.Join.ROUND);
    mPaintEcg.setStyle(Paint.Style.STROKE);
    mPaintAnn.setColor(i);
    mPaintAnn.setStrokeWidth(f);
    mPaintAnn.setAntiAlias(true);
    mPaintAnn.setStrokeCap(Paint.Cap.ROUND);
    mPaintAnn.setStrokeJoin(Paint.Join.ROUND);
    mPaintAnn.setStyle(Paint.Style.STROKE);
    mDisplayMetrics = new DisplayMetrics();
  }
  
  private void rescale(int paramInt1, int paramInt2)
  {
    DisplayMetrics localDisplayMetrics = mDisplayMetrics;
    float f2 = xdpi / 2.54F;
    float f1 = mScaleFactor;
    f2 *= f1;
    mXppcm = f2;
    mYppcm = (ydpi / 2.54F * f1);
    mYppcm = f2;
    f1 = 2.5F * f2 / 300.0F;
    mXScale = f1;
    mYScale = (f2 / 2000.0F);
    mYOffset = (paramInt2 * 0.5F);
    mWidth = paramInt1;
    mHeight = paramInt2;
    paramInt1 = (int)(paramInt1 / f1);
    mSamplesPerWidth = paramInt1;
    if (mInitalized)
    {
      paramInt1 += 12;
      mEcgBuffer.resize(paramInt1);
      mAnnotationBuffer.resize(paramInt1 * 300 / 18000);
    }
  }
  
  public void addAnnotation(int paramInt)
  {
    CirIntBuffer localCirIntBuffer = mAnnotationBuffer;
    if (localCirIntBuffer != null)
    {
      CirShortBuffer localCirShortBuffer = mEcgBuffer;
      if (localCirShortBuffer != null)
      {
        localCirIntBuffer.add(localCirShortBuffer.getCount() - paramInt);
        invalidate();
      }
    }
  }
  
  public int getAnnotationCount()
  {
    if (!mInitalized) {
      return 0;
    }
    return mAnnotationBuffer.getCount();
  }
  
  public int getEcgSampleCount()
  {
    if (!mInitalized) {
      return 0;
    }
    return mEcgBuffer.getCount();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!mInitalized) {
      return;
    }
    mPath.rewind();
    int k = mEcgBuffer.getCount() - 1;
    int j = mSamplesPerWidth - 48;
    if (k >= j)
    {
      i = k - j;
      k = j + i;
    }
    else
    {
      i = 0;
    }
    float f1 = 0.0F;
    int m = i;
    j = 0;
    float f2;
    while (m < k)
    {
      f2 = m * mXScale % mWidth;
      float f3 = mYOffset - mEcgBuffer.get(m) * mYScale;
      if ((m != i) && (f2 >= f1)) {
        mPath.lineTo(f2, f3);
      } else {
        mPath.moveTo(f2, f3);
      }
      int n = j + 1;
      j = n;
      if (n == 200)
      {
        paramCanvas.drawPath(mPath, mPaintEcg);
        mPath.rewind();
        mPath.moveTo(f2, f3);
        j = 0;
      }
      m += 1;
      f1 = f2;
    }
    if (j > 1) {
      paramCanvas.drawPath(mPath, mPaintEcg);
    }
    int i = mAnnotationBuffer.getCount();
    while (i > 0)
    {
      j = i - 1;
      k = mAnnotationBuffer.get(j);
      if (k < mEcgBuffer.getCount() - mSamplesPerWidth - 48) {
        return;
      }
      i = j;
      if (k < mEcgBuffer.getCount())
      {
        f1 = (int)((k - 1) * mXScale) % mWidth;
        f2 = mHeight;
        paramCanvas.drawLine(f1, f2, f1, f2 - mAnnotationMarkerHeightPixels, mPaintAnn);
        i = j;
      }
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    int j = 0;
    a.g("onRestoreInstanceState: %s", new Object[] { paramParcelable });
    if ((paramParcelable instanceof SavedState))
    {
      Object localObject = (SavedState)paramParcelable;
      int[] arrayOfInt = ecgSamples;
      int k;
      int i;
      if ((arrayOfInt != null) && (arrayOfInt.length > 0))
      {
        k = arrayOfInt.length;
        i = 0;
        while (i < k)
        {
          pushEcgSample((short)arrayOfInt[i]);
          i += 1;
        }
      }
      localObject = annotations;
      if ((localObject != null) && (localObject.length > 0))
      {
        k = localObject.length;
        i = j;
        while (i < k)
        {
          addAnnotation(localObject[i]);
          i += 1;
        }
      }
    }
    else
    {
      a.h("onRestoreInstanceState: Restored with %s, not a SavedState", new Object[] { paramParcelable });
    }
    super.onRestoreInstanceState(paramParcelable);
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    Object localObject = mAnnotationBuffer;
    int j = 0;
    int i;
    if (localObject != null)
    {
      annotations = new int[((CirIntBuffer)localObject).getCount()];
      i = 0;
      while (i < mAnnotationBuffer.getCount())
      {
        annotations[i] = mAnnotationBuffer.get(i);
        i += 1;
      }
    }
    localObject = mEcgBuffer;
    if (localObject != null)
    {
      ecgSamples = new int[((CirShortBuffer)localObject).getCount()];
      i = j;
      while (i < mEcgBuffer.getCount())
      {
        ecgSamples[i] = mEcgBuffer.get(i);
        i += 1;
      }
    }
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getMetrics(mDisplayMetrics);
    rescale(paramInt1, paramInt2);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    IOnWinFocusChangeListener localIOnWinFocusChangeListener = mWinFocusChangeListener;
    if (localIOnWinFocusChangeListener != null) {
      localIOnWinFocusChangeListener.onWinFocusChange(paramBoolean);
    }
  }
  
  public void pushEcgSample(short paramShort)
  {
    short[] arrayOfShort = ecgTempBuf;
    arrayOfShort[0] = paramShort;
    updateECG(arrayOfShort, 0, arrayOfShort.length);
  }
  
  public void resetECG()
  {
    if (mInitalized)
    {
      mEcgBuffer.reset();
      mAnnotationBuffer.reset();
    }
    invalidate();
  }
  
  public void setOnWinFocusChangeListener(IOnWinFocusChangeListener paramIOnWinFocusChangeListener)
  {
    mWinFocusChangeListener = paramIOnWinFocusChangeListener;
  }
  
  public void setSignalScale(float paramFloat)
  {
    mScaleFactor = paramFloat;
    rescale(getWidth(), getHeight());
    postInvalidate();
  }
  
  public void updateECG(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    if (!mInitalized)
    {
      int i = mSamplesPerWidth + 12;
      Path localPath = new Path();
      mPath = localPath;
      localPath.incReserve(i);
      mEcgBuffer = new CirShortBuffer(i);
      mAnnotationBuffer = new CirIntBuffer(i * 300 / 18000);
      mInitalized = true;
    }
    mEcgBuffer.read(paramArrayOfShort, paramInt1, paramInt2);
    invalidate();
  }
  
  public abstract interface IOnWinFocusChangeListener
  {
    public abstract void onWinFocusChange(boolean paramBoolean);
  }
  
  class SavedState
    extends View.BaseSavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<com.alivecor.ecg.record.EcgRealTimeView.SavedState> CREATOR = new Parcelable.Creator()
    {
      public EcgRealTimeView.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new EcgRealTimeView.SavedState(paramAnonymousParcel);
      }
      
      public EcgRealTimeView.SavedState[] newArray(int paramAnonymousInt)
      {
        return new EcgRealTimeView.SavedState[paramAnonymousInt];
      }
    };
    public int[] annotations;
    public int[] ecgSamples;
    
    protected SavedState()
    {
      super();
      ecgSamples = this$1.createIntArray();
      annotations = this$1.createIntArray();
    }
    
    public SavedState(ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
    }
    
    public SavedState()
    {
      super();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeIntArray(ecgSamples);
      paramParcel.writeIntArray(annotations);
    }
  }
}
