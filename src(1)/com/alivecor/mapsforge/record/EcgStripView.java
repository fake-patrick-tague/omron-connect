package com.alivecor.mapsforge.record;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import android.view.WindowManager;
import android.widget.OverScroller;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.EdgeEffectCompat;
import com.alivecor.alivecorkitlite.R.color;
import com.alivecor.alivecorkitlite.R.id;
import com.alivecor.alivecorkitlite.R.string;
import com.alivecor.alivecorkitlite.R.styleable;
import com.alivecor.asm.Database;
import com.alivecor.mapsforge.core.EcgFile;
import com.alivecor.mapsforge.core.EcgFile.Lead;
import com.alivecor.mapsforge.core.asm.b;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.Executor;
import l.a.a;
import v7.v7.package_13.GestureDetectorCompat;
import v7.v7.package_13.ViewCompat;

public class EcgStripView
  extends View
{
  public static final boolean BUILD_GALAXY_GEAR = false;
  private static final String CLASS_TAG = com.alivecor.ecg.record.EcgStripView.class.getSimpleName();
  private static final float DEFAULT_AMPLITUDE_RESOLUTION_cm = 2000.0F;
  private static final float DEFAULT_TIME_RESOLUTION_sec = 300.0F;
  private static final float DEFAULT_TRACE_THICKNESS_DP = 1.0F;
  private static final float DUAL_LEAD_OFFSET_DP = 30.0F;
  public static final float GALAXY_GEAR_SCALE_FACTOR = 4.0F;
  private static final float LEAD_CONTENT_SIZE_DP = 140.0F;
  private static final int LEAD_LABEL_COLOR_RESID = R.color.medium_jungle_green;
  private static final float LEAD_LABEL_HORIZ_OFFSET_DP = 8.0F;
  private static final float LEAD_LABEL_TEXT_SIZE_DP = 14.0F;
  private static final float LEAD_LABEL_VERT_OFFSET_DP = 8.0F;
  private static final float SCALE_MAX = 4.0F;
  private static final float ZOOM_AMOUNT = 0.5F;
  private static final boolean debug = false;
  private int contentWidthPx;
  private boolean drawEdgeGlowEffect = true;
  private Activity mActivity;
  private int[] mAnnArray;
  private Paint mAnnPaint;
  private final Path mAnnPath = new Path();
  private float mAnnotationMarkerHeightPixels;
  private float mAtcUnitsPerCm = 2000.0F;
  private final Rect mContentRect = new Rect();
  private final RectF mCurrentViewport = new RectF();
  private boolean mDirty;
  private boolean mDrawEnabled;
  private boolean mDrawReady = false;
  private float mDualLeadOffset;
  private Paint mECGTracePaint;
  private File mEcgDir;
  private final Path mEcgPath = new Path();
  private ReadEcgFileTask mEcgReadTask;
  private final EdgeEffectCompat mEdgeEffectBottom;
  private boolean mEdgeEffectBottomActive;
  private final EdgeEffectCompat mEdgeEffectLeft;
  private boolean mEdgeEffectLeftActive;
  private final EdgeEffectCompat mEdgeEffectRight;
  private boolean mEdgeEffectRightActive;
  private final EdgeEffectCompat mEdgeEffectTop;
  private boolean mEdgeEffectTopActive;
  private boolean mForceSingleLead;
  private final GestureDetectorCompat mGestureDetector;
  private final GestureDetector.SimpleOnGestureListener mGestureListener;
  private boolean mInitialized;
  private boolean mInvertedECG = false;
  private boolean mIsEnhancedFilter = true;
  private boolean mIsMuscleFilter = true;
  private float mLabelHorizOffsetPx;
  private TextPaint mLabelPaint;
  private float mLabelVertOffsetPx;
  private short[] mLead1;
  private CharSequence mLead1Label;
  private short[] mLead2;
  private CharSequence mLead2Label;
  private short[] mLead3;
  private CharSequence mLead3Label;
  private short[] mLead4;
  private CharSequence mLead4Label;
  private short[] mLead5;
  private CharSequence mLead5Label;
  private short[] mLead6;
  private CharSequence mLead6Label;
  private final Object mLock = new Object();
  private int mMajorGridColor;
  private final Path mMajorGridLinesPath = new Path();
  private Paint mMajorGridPaint;
  private float mMaxX;
  private float mMaxY;
  private float mMinX;
  private float mMinY;
  private int mMinorGridColor;
  private final Path mMinorGridLinesPath = new Path();
  private Paint mMinorGridPaint;
  private boolean mNeedDrawAnnotations = true;
  private boolean mNeedToBeInCenter;
  private final Path mOneSecGridLinesPath = new Path();
  @Deprecated
  private boolean mPreview = false;
  private float mScale = 1.0F;
  private final ScaleGestureDetector mScaleGestureDetector;
  private final ScaleGestureDetector.OnScaleGestureListener mScaleGestureListener;
  private final OverScroller mScroller;
  private final RectF mScrollerStartViewport = new RectF();
  private final Point mSurfaceSizeBuffer = new Point();
  private float mTimeUnitsPerSec = 300.0F;
  private int mTotalEcgSamples = 0;
  private boolean mTouchEnabled = true;
  private int mTraceColor;
  private float mTraceThicknessPixels;
  private String mUUID;
  private float mXppcm;
  private float mYppcm;
  private final PointF mZoomFocalPoint = new PointF();
  private final Zoomer mZoomer;
  private int traceHeightPx;
  
  public EcgStripView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public EcgStripView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EcgStripView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = new ScaleGestureDetector.SimpleOnScaleGestureListener()
    {
      private float lastSpanX;
      private float lastSpanY;
      private final PointF viewportFocus = new PointF();
      
      public boolean onScale(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        float f1 = paramAnonymousScaleGestureDetector.getCurrentSpanX();
        float f2 = paramAnonymousScaleGestureDetector.getCurrentSpanY();
        float f3 = lastSpanX;
        float f4 = lastSpanY;
        f4 = (float)Math.sqrt(f3 * f3 + f4 * f4) / (float)Math.sqrt(f1 * f1 + f2 * f2);
        f3 = mCurrentViewport.width() * f4;
        f4 *= mCurrentViewport.height();
        float f5 = paramAnonymousScaleGestureDetector.getFocusX();
        float f6 = paramAnonymousScaleGestureDetector.getFocusY();
        EcgStripView.this.hitTest(f5, f6, viewportFocus);
        mCurrentViewport.set(viewportFocus.x - (f5 - mContentRect.left) * f3 / mContentRect.width(), viewportFocus.y - (mContentRect.bottom - f6) * f4 / mContentRect.height(), 0.0F, 0.0F);
        mCurrentViewport.right = (mCurrentViewport.left + f3);
        mCurrentViewport.bottom = (mCurrentViewport.top + f4);
        EcgStripView.this.constrainViewport();
        ViewCompat.postInvalidateOnAnimation(EcgStripView.this);
        lastSpanX = f1;
        lastSpanY = f2;
        return true;
      }
      
      public boolean onScaleBegin(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        lastSpanX = paramAnonymousScaleGestureDetector.getCurrentSpanX();
        lastSpanY = paramAnonymousScaleGestureDetector.getCurrentSpanY();
        return true;
      }
    };
    mScaleGestureListener = ((ScaleGestureDetector.OnScaleGestureListener)localObject);
    GestureDetector.SimpleOnGestureListener local2 = new GestureDetector.SimpleOnGestureListener()
    {
      public boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        mZoomer.forceFinished(true);
        if (EcgStripView.this.hitTest(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY(), mZoomFocalPoint)) {
          mZoomer.startZoom(0.5F);
        }
        ViewCompat.postInvalidateOnAnimation(EcgStripView.this);
        return true;
      }
      
      public boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        EcgStripView.this.releaseEdgeEffects();
        mScrollerStartViewport.set(mCurrentViewport);
        mScroller.forceFinished(true);
        ViewCompat.postInvalidateOnAnimation(EcgStripView.this);
        return true;
      }
      
      public boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        EcgStripView.this.fling((int)-paramAnonymousFloat1, (int)-paramAnonymousFloat2);
        return true;
      }
      
      public boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        paramAnonymousFloat1 = paramAnonymousFloat1 * mCurrentViewport.width() / mContentRect.width();
        paramAnonymousFloat2 = -paramAnonymousFloat2 * mCurrentViewport.height() / mContentRect.height();
        paramAnonymousMotionEvent1 = EcgStripView.this;
        paramAnonymousMotionEvent1.computeScrollSurfaceSize(mSurfaceSizeBuffer);
        int j = (int)(mSurfaceSizeBuffer.x * (mCurrentViewport.left + paramAnonymousFloat1 - mMinX) / (mMaxX - mMinX));
        int i = mSurfaceSizeBuffer.y;
        float f = mCurrentViewport.bottom;
        if ((mCurrentViewport.left <= mMinX) && (mCurrentViewport.right >= mMaxX)) {
          i = 0;
        } else {
          i = 1;
        }
        paramAnonymousMotionEvent1 = EcgStripView.this;
        paramAnonymousMotionEvent1.setViewportBottomLeft(mCurrentViewport.left + paramAnonymousFloat1, mCurrentViewport.bottom + paramAnonymousFloat2);
        if ((i != 0) && (j < 0))
        {
          mEdgeEffectLeft.onPull(j / mContentRect.width());
          EcgStripView.access$1702(EcgStripView.this, true);
        }
        if ((i != 0) && (j > mSurfaceSizeBuffer.x - mContentRect.width()))
        {
          mEdgeEffectRight.onPull((j - mSurfaceSizeBuffer.x + mContentRect.width()) / mContentRect.width());
          EcgStripView.access$2102(EcgStripView.this, true);
        }
        return true;
      }
    };
    mGestureListener = local2;
    if ((paramContext instanceof Activity)) {
      mActivity = ((Activity)paramContext);
    }
    traceHeightPx = ((int)Util.dp2px(140.0F, paramContext));
    contentWidthPx = ((int)Util.dp2px(140.0F, paramContext));
    paramInt = R.color.ecg_grid_color;
    mMajorGridColor = ContextCompat.getColor(paramContext, paramInt);
    mMinorGridColor = ContextCompat.getColor(paramContext, paramInt);
    mTraceColor = ContextCompat.getColor(paramContext, R.color.ecg_trace_color);
    mTraceThicknessPixels = TypedValue.applyDimension(1, 1.0F, getResources().getDisplayMetrics());
    mAnnotationMarkerHeightPixels = TypedValue.applyDimension(1, 5.0F, getResources().getDisplayMetrics());
    mScaleGestureDetector = new ScaleGestureDetector(paramContext, (ScaleGestureDetector.OnScaleGestureListener)localObject);
    mGestureDetector = new GestureDetectorCompat(paramContext, local2);
    mScroller = new OverScroller(paramContext);
    mZoomer = new Zoomer(paramContext);
    mEdgeEffectLeft = new EdgeEffectCompat(paramContext);
    mEdgeEffectTop = new EdgeEffectCompat(paramContext);
    mEdgeEffectRight = new EdgeEffectCompat(paramContext);
    mEdgeEffectBottom = new EdgeEffectCompat(paramContext);
    localObject = new TextPaint();
    mLabelPaint = ((TextPaint)localObject);
    ((Paint)localObject).setTextSize(Util.dp2px(14.0F, paramContext));
    mLabelPaint.setColor(paramContext.getResources().getColor(LEAD_LABEL_COLOR_RESID));
    mLabelPaint.setFakeBoldText(true);
    mLabelPaint.setTypeface(Typeface.MONOSPACE);
    mLead1Label = paramContext.getString(R.string.ecg_realtime_lead_i);
    mLead2Label = paramContext.getString(R.string.ecg_realtime_lead_ii);
    mLead3Label = paramContext.getString(R.string.ecg_realtime_lead_iii);
    mLead4Label = paramContext.getString(R.string.ecg_realtime_lead_avr);
    mLead5Label = paramContext.getString(R.string.ecg_realtime_lead_avl);
    mLead6Label = paramContext.getString(R.string.ecg_realtime_lead_avf);
    mLabelHorizOffsetPx = Util.dp2px(8.0F, paramContext);
    mLabelVertOffsetPx = Util.dp2px(8.0F, paramContext);
    mDualLeadOffset = Util.dp2px(30.0F, paramContext);
    setHorizontalScrollBarEnabled(true);
    if (!isInEditMode())
    {
      paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.EcgStripView, 0, 0);
      try
      {
        mForceSingleLead = paramContext.getBoolean(R.styleable.EcgStripView_onlySingleLead, false);
        paramInt = R.styleable.EcgStripView_majorGridColor;
        mMajorGridColor = paramContext.getColor(paramInt, mMajorGridColor);
        mMinorGridColor = paramContext.getColor(paramInt, mMinorGridColor);
        mTraceColor = paramContext.getColor(R.styleable.EcgStripView_traceColor, mTraceColor);
        mTraceThicknessPixels = paramContext.getDimension(R.styleable.EcgStripView_traceThickness, mTraceThicknessPixels);
        paramContext.recycle();
      }
      catch (Throwable paramAttributeSet)
      {
        paramContext.recycle();
        throw paramAttributeSet;
      }
    }
    initPaints();
    mInitialized = true;
    mDirty = false;
  }
  
  private void computeScrollSurfaceSize(Point paramPoint)
  {
    paramPoint.set((int)(mContentRect.width() * (mMaxX - mMinX) / mCurrentViewport.width()), (int)(mContentRect.height() * (mMaxY - mMinY) / mCurrentViewport.height()));
  }
  
  private void constrainViewport()
  {
    if (Float.isNaN(mCurrentViewport.left))
    {
      mScale = 1.0F;
      localRectF = mCurrentViewport;
      left = 0.0F;
      right = (getWidth() * 400 / mXppcm / mScale);
    }
    else
    {
      mScale = ((mMaxY - mMinY) / mCurrentViewport.height());
    }
    RectF localRectF = mCurrentViewport;
    left = Math.max(mMinX, left);
    localRectF = mCurrentViewport;
    right = Math.max(Math.nextUp(left), Math.min(mMaxX, mCurrentViewport.right));
    if (mScale < 1.0F) {
      mScale = 1.0F;
    }
    if (mScale > 4.0F) {
      mScale = 4.0F;
    }
    localRectF = mCurrentViewport;
    float f1 = (mMaxY - mMinY) / 2.0F;
    float f2 = f1 / mScale;
    top = (f1 - f2);
    bottom = (f1 + f2);
    f1 = getWidth() * 400 / mXppcm / mScale;
    localRectF = mCurrentViewport;
    left = Math.max(mMinX, left + localRectF.width() / 2.0F - f1 / 2.0F);
    localRectF = mCurrentViewport;
    right = (left + f1);
  }
  
  private void drawECG(Canvas paramCanvas, short[] paramArrayOfShort, int paramInt, CharSequence paramCharSequence, float paramFloat)
  {
    if (!mDrawReady) {
      return;
    }
    int k = (int)(Math.floor(mCurrentViewport.left) / 1000.0D * 300.0D);
    long l1 = (mContentRect.width() * mMaxX / mCurrentViewport.width());
    float f2 = k * 1000 / 300.0F;
    int m = 0;
    mEcgPath.rewind();
    float f1 = f2;
    int j = k;
    int i = m;
    if (paramCharSequence != null)
    {
      paramCanvas.drawText(paramCharSequence, 0, paramCharSequence.length(), mLabelHorizOffsetPx + getScrollX(), mLabelVertOffsetPx + paramFloat, mLabelPaint);
      i = m;
      j = k;
    }
    for (f1 = f2; (j < paramArrayOfShort.length) && (f1 < mCurrentViewport.right); f1 = j * 1000 / 300.0F)
    {
      f2 = (float)l1 * f1 / mMaxX;
      f1 = paramArrayOfShort[j] * mContentRect.height() / mCurrentViewport.height() + paramInt;
      paramFloat = f1;
      if (mInvertedECG) {
        paramFloat = -f1;
      }
      paramCharSequence = mEcgPath;
      Rect localRect = mContentRect;
      f1 = top + localRect.height() / 2 - paramFloat;
      if (i == 0) {
        paramCharSequence.moveTo(f2, f1);
      } else {
        paramCharSequence.lineTo(f2, f1);
      }
      k = i + 1;
      i = k;
      if (k == 200)
      {
        paramCanvas.drawPath(mEcgPath, mECGTracePaint);
        mEcgPath.rewind();
        paramCharSequence = mEcgPath;
        localRect = mContentRect;
        paramCharSequence.moveTo(f2, top + localRect.height() / 2 - paramFloat);
        i = 1;
      }
      j += 1;
    }
    if (i > 1) {
      paramCanvas.drawPath(mEcgPath, mECGTracePaint);
    }
    if (mNeedDrawAnnotations)
    {
      paramArrayOfShort = mAnnArray;
      if ((paramArrayOfShort != null) && (paramArrayOfShort.length > 0))
      {
        mAnnPath.rewind();
        paramInt = mAnnArray.length;
        while (paramInt > 0)
        {
          i = paramInt - 1;
          long l2 = mAnnArray[i] * 1000L / 300L;
          paramFloat = (float)l2;
          paramArrayOfShort = mCurrentViewport;
          paramInt = i;
          if (paramFloat <= right)
          {
            if (paramFloat < left) {
              break;
            }
            paramFloat = (float)(l2 * l1) / mMaxX;
            mAnnPath.moveTo(paramFloat, mContentRect.bottom);
            mAnnPath.lineTo(paramFloat, mContentRect.bottom - mAnnotationMarkerHeightPixels);
            paramInt = i;
          }
        }
        if (!mAnnPath.isEmpty()) {
          paramCanvas.drawPath(mAnnPath, mAnnPaint);
        }
      }
    }
  }
  
  private void drawEdgeEffectsUnclipped(Canvas paramCanvas)
  {
    int i;
    Rect localRect;
    if (!mEdgeEffectTop.isFinished())
    {
      i = paramCanvas.save();
      localRect = mContentRect;
      paramCanvas.translate(left, top);
      mEdgeEffectTop.draw(mContentRect.width(), mContentRect.height());
      bool2 = mEdgeEffectTop.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
    }
    else
    {
      bool2 = false;
    }
    boolean bool4 = mEdgeEffectBottom.isFinished();
    boolean bool3 = true;
    boolean bool1 = bool2;
    if (!bool4)
    {
      i = paramCanvas.save();
      localRect = mContentRect;
      paramCanvas.translate(left * 2 - right, bottom);
      paramCanvas.rotate(180.0F, mContentRect.width(), 0.0F);
      mEdgeEffectBottom.draw(mContentRect.width(), mContentRect.height());
      bool1 = bool2;
      if (mEdgeEffectBottom.draw(paramCanvas)) {
        bool1 = true;
      }
      paramCanvas.restoreToCount(i);
    }
    boolean bool2 = bool1;
    if (!mEdgeEffectLeft.isFinished())
    {
      i = paramCanvas.save();
      localRect = mContentRect;
      paramCanvas.translate(left, bottom);
      paramCanvas.rotate(-90.0F, 0.0F, 0.0F);
      mEdgeEffectLeft.draw(mContentRect.height(), mContentRect.width());
      if (mEdgeEffectLeft.draw(paramCanvas)) {
        bool1 = true;
      }
      paramCanvas.restoreToCount(i);
      bool2 = bool1;
    }
    bool1 = bool2;
    if (!mEdgeEffectRight.isFinished())
    {
      i = paramCanvas.save();
      int j = getScrollX();
      localRect = mContentRect;
      paramCanvas.translate(j + right, top);
      paramCanvas.rotate(90.0F, 0.0F, 0.0F);
      mEdgeEffectRight.draw(mContentRect.height(), mContentRect.width());
      if (mEdgeEffectRight.draw(paramCanvas)) {
        bool1 = bool3;
      } else {
        bool1 = bool2;
      }
      paramCanvas.restoreToCount(i);
    }
    if (bool1) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  private void drawGridlinesUnclipped(Canvas paramCanvas)
  {
    if ((int)mCurrentViewport.width() != 0)
    {
      if ((int)mCurrentViewport.height() == 0) {
        return;
      }
      mMinorGridLinesPath.rewind();
      mMajorGridLinesPath.rewind();
      long l1 = 0L;
      long l2 = 0L;
      float f;
      Path localPath;
      while ((float)l1 <= mCurrentViewport.height() / 2.0F)
      {
        f = (float)(mContentRect.height() * l1) / mCurrentViewport.height();
        if (l1 == l2)
        {
          l2 += 1000L;
          localPath = mMajorGridLinesPath;
          i = getScrollX();
          localRect = mContentRect;
          localPath.moveTo(i + left, top + localRect.height() / 2 + f);
          localPath = mMajorGridLinesPath;
          i = getScrollX();
          localRect = mContentRect;
          localPath.lineTo(i + right, top + localRect.height() / 2 + f);
          localPath = mMajorGridLinesPath;
          i = getScrollX();
          localRect = mContentRect;
          localPath.moveTo(i + left, top + localRect.height() / 2 - f);
          localPath = mMajorGridLinesPath;
        }
        else
        {
          localPath = mMinorGridLinesPath;
          i = getScrollX();
          localRect = mContentRect;
          localPath.moveTo(i + left, top + localRect.height() / 2 + f);
          localPath = mMinorGridLinesPath;
          i = getScrollX();
          localRect = mContentRect;
          localPath.lineTo(i + right, top + localRect.height() / 2 + f);
          localPath = mMinorGridLinesPath;
          i = getScrollX();
          localRect = mContentRect;
          localPath.moveTo(i + left, top + localRect.height() / 2 - f);
          localPath = mMinorGridLinesPath;
        }
        int i = getScrollX();
        Rect localRect = mContentRect;
        localPath.lineTo(i + right, top + localRect.height() / 2 - f);
        l1 += 200L;
      }
      paramCanvas.drawPath(mMinorGridLinesPath, mMinorGridPaint);
      paramCanvas.drawPath(mMajorGridLinesPath, mMajorGridPaint);
      mMinorGridLinesPath.rewind();
      mMajorGridLinesPath.rewind();
      mOneSecGridLinesPath.rewind();
      l1 = Math.floor(mCurrentViewport.left) * 40L / 40L;
      l1 -= l1 % 40L;
      l2 = (mContentRect.width() * mMaxX / mCurrentViewport.width());
      while ((float)l1 < mCurrentViewport.right)
      {
        f = (float)(l2 * l1) / mMaxX;
        if (f >= 0.0F)
        {
          if (l1 % 1000L == 0L)
          {
            mOneSecGridLinesPath.moveTo(f, mContentRect.top);
            localPath = mOneSecGridLinesPath;
          }
          for (;;)
          {
            localPath.lineTo(f, mContentRect.bottom);
            break;
            if (l1 % 200L == 0L)
            {
              mMajorGridLinesPath.moveTo(f, mContentRect.top);
              localPath = mMajorGridLinesPath;
            }
            else
            {
              if (l1 % 40L != 0L) {
                break;
              }
              mMinorGridLinesPath.moveTo(f, mContentRect.top);
              localPath = mMinorGridLinesPath;
            }
          }
        }
        l1 += 40L;
      }
      paramCanvas.drawPath(mOneSecGridLinesPath, mMajorGridPaint);
      paramCanvas.drawPath(mMinorGridLinesPath, mMinorGridPaint);
      paramCanvas.drawPath(mMajorGridLinesPath, mMajorGridPaint);
    }
  }
  
  private void fling(int paramInt1, int paramInt2)
  {
    releaseEdgeEffects();
    computeScrollSurfaceSize(mSurfaceSizeBuffer);
    mScrollerStartViewport.set(mCurrentViewport);
    Point localPoint = mSurfaceSizeBuffer;
    float f1 = x;
    RectF localRectF = mScrollerStartViewport;
    float f2 = left;
    float f3 = mMinX;
    int i = (int)(f1 * (f2 - f3) / (mMaxX - f3));
    f1 = y;
    f2 = mMaxY;
    int j = (int)(f1 * (f2 - bottom) / (f2 - mMinY));
    mScroller.forceFinished(true);
    mScroller.fling(i, j, paramInt1, paramInt2, 0, mSurfaceSizeBuffer.x - mContentRect.width(), 0, mSurfaceSizeBuffer.y - mContentRect.height(), mContentRect.width() / 2, mContentRect.height() / 2);
    ViewCompat.postInvalidateOnAnimation(this);
  }
  
  private boolean hitTest(float paramFloat1, float paramFloat2, PointF paramPointF)
  {
    if (!mContentRect.contains((int)paramFloat1, (int)paramFloat2)) {
      return false;
    }
    Object localObject = mCurrentViewport;
    float f1 = left;
    float f2 = ((RectF)localObject).width();
    localObject = mContentRect;
    paramFloat1 = f2 * (paramFloat1 - left) / ((Rect)localObject).width();
    localObject = mCurrentViewport;
    f2 = top;
    float f3 = ((RectF)localObject).height();
    localObject = mContentRect;
    paramPointF.set(f1 + paramFloat1, f2 + f3 * (paramFloat2 - bottom) / -((Rect)localObject).height());
    return true;
  }
  
  private void initPaints()
  {
    Paint localPaint = new Paint();
    mECGTracePaint = localPaint;
    localPaint.setAntiAlias(true);
    mECGTracePaint.setStrokeWidth(mTraceThicknessPixels);
    mECGTracePaint.setColor(mTraceColor);
    mECGTracePaint.setStrokeCap(Paint.Cap.ROUND);
    mECGTracePaint.setStrokeJoin(Paint.Join.ROUND);
    mECGTracePaint.setStyle(Paint.Style.STROKE);
    localPaint = new Paint();
    mAnnPaint = localPaint;
    localPaint.setColor(mTraceColor);
    mAnnPaint.setStrokeWidth(mTraceThicknessPixels);
    mAnnPaint.setAntiAlias(true);
    mAnnPaint.setStrokeCap(Paint.Cap.ROUND);
    mAnnPaint.setStrokeJoin(Paint.Join.ROUND);
    mAnnPaint.setStyle(Paint.Style.STROKE);
    localPaint = new Paint();
    mMinorGridPaint = localPaint;
    localPaint.setAntiAlias(true);
    mMinorGridPaint.setStrokeWidth(mTraceThicknessPixels * 0.5F);
    mMinorGridPaint.setColor(mMinorGridColor);
    mMinorGridPaint.setStyle(Paint.Style.STROKE);
    localPaint = new Paint();
    mMajorGridPaint = localPaint;
    localPaint.setAntiAlias(true);
    mMajorGridPaint.setStrokeWidth(mTraceThicknessPixels);
    mMajorGridPaint.setColor(mMajorGridColor);
    mMajorGridPaint.setStyle(Paint.Style.STROKE);
  }
  
  private int labelPos(int paramInt)
  {
    int i = mContentRect.height() / 6;
    return paramInt * i - i / 2;
  }
  
  private int leadPos(int paramInt)
  {
    paramInt = -paramInt;
    int i = mContentRect.height() / 7;
    return (paramInt + 3) * i + i / 3;
  }
  
  private void moveToCenter()
  {
    float f = (int)(mMaxX / 2.0F) * mCurrentViewport.width() / mContentRect.width();
    if (mCurrentViewport.left != f)
    {
      computeScrollSurfaceSize(mSurfaceSizeBuffer);
      RectF localRectF = mCurrentViewport;
      setViewportBottomLeft(left + f, bottom + 0.0F);
    }
  }
  
  private void recomputeScroll()
  {
    scrollTo(0, 0);
    setEcgViewLimits();
    float f1 = mCurrentViewport.width();
    RectF localRectF = mCurrentViewport;
    float f2 = left;
    float f3 = mMaxX - f1;
    if (f2 > f3)
    {
      left = f3;
      right = (f3 + f1);
    }
    constrainViewport();
    invalidate();
  }
  
  private void releaseEdgeEffects()
  {
    mEdgeEffectBottomActive = false;
    mEdgeEffectRightActive = false;
    mEdgeEffectTopActive = false;
    mEdgeEffectLeftActive = false;
    mEdgeEffectLeft.onRelease();
    mEdgeEffectTop.onRelease();
    mEdgeEffectRight.onRelease();
    mEdgeEffectBottom.onRelease();
  }
  
  private void setEcgViewLimits()
  {
    float f = mAtcUnitsPerCm * (getHeight() / mXppcm) / 2.0F;
    mMaxY = f;
    mMinY = (-f);
    mMinX = 0.0F;
    int i = mTotalEcgSamples;
    if (i == 0) {
      f = 100000.0F;
    } else {
      f = i * 1000.0F / mTimeUnitsPerSec;
    }
    mMaxX = f;
  }
  
  private void setViewportBottomLeft(float paramFloat1, float paramFloat2)
  {
    float f1 = mCurrentViewport.width();
    float f2 = mCurrentViewport.height();
    paramFloat1 = Math.max(mMinX, Math.min(paramFloat1, mMaxX - f1));
    paramFloat2 = Math.max(mMinY + f2, Math.min(paramFloat2, mMaxY));
    mCurrentViewport.set(paramFloat1, paramFloat2 - f2, f1 + paramFloat1, paramFloat2);
    ViewCompat.postInvalidateOnAnimation(this);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return super.canScrollHorizontally(paramInt);
  }
  
  protected int computeHorizontalScrollExtent()
  {
    return super.computeHorizontalScrollExtent();
  }
  
  protected int computeHorizontalScrollOffset()
  {
    return super.computeHorizontalScrollOffset();
  }
  
  protected int computeHorizontalScrollRange()
  {
    if (mCurrentViewport.width() == 0.0F) {
      return 0;
    }
    return (int)(mContentRect.width() * (mMaxX - mMinX) / mCurrentViewport.width());
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if (!mDrawReady) {
      return;
    }
    boolean bool = mScroller.computeScrollOffset();
    int j = 1;
    Object localObject;
    int i;
    label222:
    float f1;
    float f2;
    float f3;
    if (bool)
    {
      computeScrollSurfaceSize(mSurfaceSizeBuffer);
      int k = mScroller.getCurrX();
      int m = mScroller.getCurrY();
      localObject = mCurrentViewport;
      if ((left <= mMinX) && (right >= mMaxX)) {
        i = 0;
      } else {
        i = 1;
      }
      if ((i != 0) && (k < 0) && (mEdgeEffectLeft.isFinished()) && (!mEdgeEffectLeftActive))
      {
        mEdgeEffectLeft.onAbsorb((int)mScroller.getCurrVelocity());
        mEdgeEffectLeftActive = true;
      }
      for (;;)
      {
        i = 1;
        break label222;
        if ((i == 0) || (k <= mSurfaceSizeBuffer.x - mContentRect.width()) || (!mEdgeEffectRight.isFinished()) || (mEdgeEffectRightActive)) {
          break;
        }
        mEdgeEffectRight.onAbsorb((int)mScroller.getCurrVelocity());
        mEdgeEffectRightActive = true;
      }
      i = 0;
      f1 = mMinX;
      f2 = mMaxX;
      f3 = k;
      localObject = mSurfaceSizeBuffer;
      f2 = (f2 - f1) * f3 / x;
      f3 = mMaxY;
      setViewportBottomLeft(f1 + f2, f3 - (f3 - mMinY) * m / y);
    }
    else
    {
      i = 0;
    }
    if (mZoomer.computeZoom())
    {
      f1 = (1.0F - mZoomer.getCurrZoom()) * mScrollerStartViewport.width();
      f2 = (1.0F - mZoomer.getCurrZoom()) * mScrollerStartViewport.height();
      f3 = mZoomFocalPoint.x;
      localObject = mScrollerStartViewport;
      f3 = (f3 - left) / ((RectF)localObject).width();
      float f4 = mZoomFocalPoint.y;
      localObject = mScrollerStartViewport;
      f4 = (f4 - top) / ((RectF)localObject).height();
      localObject = mCurrentViewport;
      PointF localPointF = mZoomFocalPoint;
      float f5 = x;
      float f6 = y;
      ((RectF)localObject).set(f5 - f1 * f3, f6 - f2 * f4, f5 + f1 * (1.0F - f3), f6 + f2 * (1.0F - f4));
      i = j;
    }
    constrainViewport();
    computeScrollSurfaceSize(mSurfaceSizeBuffer);
    scrollTo((int)(mSurfaceSizeBuffer.x * mCurrentViewport.left / (mMaxX - mMinX)), 0);
    if (i != 0) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public RectF getCurrentViewport()
  {
    return new RectF(mCurrentViewport);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    drawGridlinesUnclipped(paramCanvas);
    if (mDrawReady)
    {
      Object localObject = mLock;
      try
      {
        short[] arrayOfShort = mLead1;
        if (arrayOfShort == null) {
          return;
        }
        if ((mLead2 != null) && (!mForceSingleLead))
        {
          if (mLead3 != null)
          {
            drawECG(paramCanvas, arrayOfShort, leadPos(1), mLead1Label, labelPos(1));
            drawECG(paramCanvas, mLead2, leadPos(2), mLead2Label, labelPos(2));
            drawECG(paramCanvas, mLead3, leadPos(3), mLead3Label, labelPos(3));
            drawECG(paramCanvas, mLead4, leadPos(4), mLead4Label, labelPos(4));
            drawECG(paramCanvas, mLead5, leadPos(5), mLead5Label, labelPos(5));
            drawECG(paramCanvas, mLead6, leadPos(6), mLead6Label, labelPos(6));
          }
          else
          {
            drawECG(paramCanvas, arrayOfShort, (int)-mDualLeadOffset, null, 0.0F);
            drawECG(paramCanvas, mLead2, (int)mDualLeadOffset, null, 0.0F);
          }
        }
        else {
          drawECG(paramCanvas, arrayOfShort, 0, null, 0.0F);
        }
      }
      catch (Throwable paramCanvas)
      {
        throw paramCanvas;
      }
    }
    if (drawEdgeGlowEffect) {
      drawEdgeEffectsUnclipped(paramCanvas);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(View.resolveSize(Math.max(getSuggestedMinimumWidth(), contentWidthPx + getPaddingLeft() + getPaddingRight()), paramInt1), View.resolveSize(Math.max(getSuggestedMinimumHeight(), traceHeightPx * 6 + getPaddingTop() + getPaddingBottom()), paramInt2));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = (WindowManager)getContext().getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    if (!isInEditMode()) {
      ((WindowManager)localObject).getDefaultDisplay().getMetrics(localDisplayMetrics);
    }
    float f1 = xdpi / 2.54F * 1.0F;
    mXppcm = f1;
    mYppcm = (ydpi / 2.54F * 1.0F);
    mYppcm = f1;
    setEcgViewLimits();
    mContentRect.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
    if (mScale < 1.0F) {
      mScale = 1.0F;
    }
    if (mScale > 4.0F) {
      mScale = 4.0F;
    }
    localObject = mCurrentViewport;
    f1 = (mMaxY - mMinY) / 2.0F;
    float f2 = f1 / mScale;
    top = (f1 - f2);
    bottom = (f1 + f2);
    f1 = getWidth() * 400 / mXppcm / mScale;
    localObject = mCurrentViewport;
    left = Math.max(mMinX, left + ((RectF)localObject).width() / 2.0F - f1 / 2.0F);
    localObject = mCurrentViewport;
    right = (left + f1);
    constrainViewport();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (mTouchEnabled)
    {
      boolean bool = mScaleGestureDetector.onTouchEvent(paramMotionEvent);
      int i;
      if ((!mGestureDetector.onTouchEvent(paramMotionEvent)) && (!bool)) {
        i = 0;
      } else {
        i = 1;
      }
      if ((i != 0) || (super.onTouchEvent(paramMotionEvent))) {
        return true;
      }
    }
    else
    {
      return super.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public void resetEcg()
  {
    mTotalEcgSamples = 0;
    ReadEcgFileTask localReadEcgFileTask = mEcgReadTask;
    if ((localReadEcgFileTask != null) && (!localReadEcgFileTask.isCancelled()))
    {
      mEcgReadTask.cancel(false);
      a.h("mEcgReadTask cancelled", new Object[0]);
      mEcgReadTask = null;
    }
    postInvalidate();
  }
  
  public void setActivity(Activity paramActivity)
  {
    mActivity = paramActivity;
  }
  
  public void setDrawEdgeEffect(boolean paramBoolean)
  {
    drawEdgeGlowEffect = paramBoolean;
  }
  
  public void setDrawEnabled(boolean paramBoolean)
  {
    mDrawEnabled = paramBoolean;
  }
  
  public boolean setEcgRecord(String paramString, File paramFile, boolean paramBoolean, Executor paramExecutor)
  {
    a.g("setEcgRecord", new Object[0]);
    setInvertedECG(paramBoolean);
    Object localObject = mUUID;
    if ((localObject != null) && (((String)localObject).equals(paramString)) && (mTotalEcgSamples > 0) && (!mDirty))
    {
      a.a("setEcg ignored", new Object[0]);
      return false;
    }
    resetEcg();
    localObject = mEcgReadTask;
    if ((localObject != null) && (!((AsyncTask)localObject).isCancelled()))
    {
      mEcgReadTask.cancel(false);
      a.h("mEcgReadTask cancelled", new Object[0]);
      mEcgReadTask = null;
    }
    localObject = mLock;
    try
    {
      a.d("setEcgRecord file:%s", new Object[] { paramString });
      mUUID = paramString;
      mEcgDir = paramFile;
      mDrawReady = false;
      if (mInitialized)
      {
        mScroller.abortAnimation();
        paramString = mUUID;
        if ((paramString != null) && (paramString.length() > 0))
        {
          paramString = new ReadEcgFileTask(mActivity, paramFile);
          mEcgReadTask = paramString;
          paramString.executeOnExecutor(paramExecutor, new Void[0]);
          a.d("mEcgReadTask executed", new Object[0]);
        }
        else
        {
          postInvalidate();
        }
      }
      return true;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public boolean setEcgRecord(String paramString, boolean paramBoolean, Executor paramExecutor)
  {
    return setEcgRecord(paramString, b.write(), paramBoolean, paramExecutor);
  }
  
  public void setEnhancedFilter(boolean paramBoolean, Executor paramExecutor)
  {
    if (mIsEnhancedFilter != paramBoolean)
    {
      mIsEnhancedFilter = paramBoolean;
      mDirty = true;
    }
    String str = mUUID;
    if (str != null) {
      setEcgRecord(str, mEcgDir, mInvertedECG, paramExecutor);
    }
  }
  
  public void setForceSingleLead(boolean paramBoolean)
  {
    mForceSingleLead = paramBoolean;
    traceHeightPx = ((int)Util.dp2px(140.0F, getContext()));
    invalidate();
  }
  
  public void setInvertedECG(boolean paramBoolean)
  {
    if (mInvertedECG != paramBoolean)
    {
      mInvertedECG = paramBoolean;
      postInvalidate();
    }
  }
  
  public void setLead1(short[] paramArrayOfShort)
  {
    mLead1 = paramArrayOfShort;
    mDrawReady = true;
    mTotalEcgSamples = paramArrayOfShort.length;
    recomputeScroll();
  }
  
  public void setLead2(short[] paramArrayOfShort)
  {
    mLead2 = paramArrayOfShort;
    mDrawReady = true;
    if (mTotalEcgSamples <= 0) {
      mTotalEcgSamples = paramArrayOfShort.length;
    }
    recomputeScroll();
  }
  
  public void setMajorGridColor(int paramInt)
  {
    mMajorGridColor = paramInt;
    mMajorGridPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setMinorGridColor(int paramInt)
  {
    mMinorGridColor = paramInt;
    mMinorGridPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setMuscleFilter(boolean paramBoolean)
  {
    if (mIsMuscleFilter != paramBoolean)
    {
      mIsMuscleFilter = paramBoolean;
      mDirty = true;
    }
  }
  
  public void setNeedDrawAnnotations(boolean paramBoolean)
  {
    mNeedDrawAnnotations = paramBoolean;
  }
  
  public void setNeedToBeInCenter(boolean paramBoolean)
  {
    mNeedToBeInCenter = paramBoolean;
    invalidate();
  }
  
  public void setScale(float paramFloat)
  {
    RectF localRectF = mCurrentViewport;
    bottom = (mMaxY / paramFloat);
    top = (mMinY / paramFloat);
    constrainViewport();
    ViewCompat.postInvalidateOnAnimation(this);
  }
  
  public void setTimeResolutionSeconds(float paramFloat)
  {
    mTimeUnitsPerSec = paramFloat;
  }
  
  public void setTouchEnabled(boolean paramBoolean)
  {
    mTouchEnabled = paramBoolean;
  }
  
  public void setTraceColor(int paramInt)
  {
    mTraceColor = paramInt;
    mECGTracePaint.setColor(paramInt);
    invalidate();
  }
  
  public void setTraceResolutionPerCm(float paramFloat)
  {
    mAtcUnitsPerCm = paramFloat;
  }
  
  public void setTraceThickness(float paramFloat)
  {
    mTraceThicknessPixels = paramFloat;
    mECGTracePaint.setStrokeWidth(paramFloat);
    invalidate();
  }
  
  class ReadEcgFileTask
    extends AsyncTask<Void, String, Void>
  {
    private final WeakReference<Activity> activityWeakRef;
    private File ecgDir;
    private short[] mEnhancedBuffer;
    
    public ReadEcgFileTask(Activity paramActivity, File paramFile)
    {
      if (paramActivity != null) {
        this$1 = new WeakReference(paramActivity);
      } else {
        this$1 = null;
      }
      activityWeakRef = EcgStripView.this;
      ecgDir = paramFile;
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      if (isCancelled()) {
        return null;
      }
      Object localObject3 = mLock;
      try
      {
        if (isCancelled())
        {
          EcgStripView.access$2602(EcgStripView.this, 0);
          return null;
        }
        Object localObject2 = mUUID;
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("ReadEcgFileTask. file UUID:");
        paramVarArgs.append((String)localObject2);
        a.d(paramVarArgs.toString(), new Object[0]);
        Object localObject1 = b.a(ecgDir, (String)localObject2);
        paramVarArgs = (Void[])localObject1;
        localObject2 = b.d(ecgDir, (String)localObject2);
        if (isCancelled()) {
          return null;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Ensuring RAW ecg file: ");
        ((StringBuilder)localObject3).append(localObject1);
        a.a(((StringBuilder)localObject3).toString(), new Object[0]);
        if (isCancelled())
        {
          EcgStripView.access$2602(EcgStripView.this, 0);
          return null;
        }
        if (isCancelled())
        {
          EcgStripView.access$2602(EcgStripView.this, 0);
          return null;
        }
        if (mIsEnhancedFilter) {
          paramVarArgs = (Void[])localObject2;
        }
        localObject1 = new EcgFile();
        a.a("Loading file %s", new Object[] { localObject1 });
        try
        {
          boolean bool = ((EcgFile)localObject1).open(paramVarArgs);
          if (bool)
          {
            i = ((EcgFile)localObject1).getTotalLead1Samples();
            if (i >= 2)
            {
              paramVarArgs = EcgStripView.this;
              paramVarArgs = mLock;
              try
              {
                EcgStripView.access$2902(EcgStripView.this, false);
                localObject2 = EcgStripView.this;
                if (mPreview) {
                  i = (int)(mCurrentViewport.width() / 3.0F);
                } else {
                  i = ((EcgFile)localObject1).getTotalLead1Samples();
                }
                EcgStripView.access$2602((EcgStripView)localObject2, i);
                if ((mLead1 != null) && (mLead1.length != mTotalEcgSamples)) {
                  EcgStripView.access$3102(EcgStripView.this, null);
                }
                if (mLead1 == null)
                {
                  localObject2 = EcgStripView.this;
                  EcgStripView.access$3102((EcgStripView)localObject2, new short[mTotalEcgSamples]);
                }
                i = ((EcgFile)localObject1).getAnnotationCount();
                if ((mAnnArray != null) && (mAnnArray.length != i)) {
                  EcgStripView.access$3202(EcgStripView.this, null);
                }
                if (i > 0)
                {
                  if (mAnnArray == null) {
                    EcgStripView.access$3202(EcgStripView.this, new int[i]);
                  }
                  System.arraycopy(((EcgFile)localObject1).getAnnotations(), 0, mAnnArray, 0, i);
                  Arrays.sort(mAnnArray);
                  i = 0;
                  while ((i < mAnnArray.length) && (mAnnArray[i] < 0)) {
                    i += 1;
                  }
                }
                if (isCancelled())
                {
                  EcgStripView.access$2602(EcgStripView.this, 0);
                  ((EcgFile)localObject1).close();
                  return null;
                }
                localObject2 = EcgFile.Lead.LEAD_1;
                if (((EcgFile)localObject1).samplesForLead((EcgFile.Lead)localObject2) > 0L)
                {
                  a.d("Reading lead %s with %s samples", new Object[] { localObject2, Long.valueOf(((EcgFile)localObject1).samplesForLead((EcgFile.Lead)localObject2)) });
                  EcgStripView.access$3102(EcgStripView.this, ((EcgFile)localObject1).readEcgSamples((EcgFile.Lead)localObject2));
                }
                localObject2 = EcgFile.Lead.LEAD_2;
                if (((EcgFile)localObject1).samplesForLead((EcgFile.Lead)localObject2) > 0L)
                {
                  a.d("Reading lead %s with %s samples", new Object[] { localObject2, Long.valueOf(((EcgFile)localObject1).samplesForLead((EcgFile.Lead)localObject2)) });
                  EcgStripView.access$3302(EcgStripView.this, ((EcgFile)localObject1).readEcgSamples((EcgFile.Lead)localObject2));
                }
                localObject2 = EcgFile.Lead.LEAD_3;
                if (((EcgFile)localObject1).samplesForLead((EcgFile.Lead)localObject2) > 0L)
                {
                  a.d("Reading lead %s with %s samples", new Object[] { localObject2, Long.valueOf(((EcgFile)localObject1).samplesForLead((EcgFile.Lead)localObject2)) });
                  EcgStripView.access$3402(EcgStripView.this, ((EcgFile)localObject1).readEcgSamples((EcgFile.Lead)localObject2));
                }
                localObject2 = EcgFile.Lead.LEAD_4;
                if (((EcgFile)localObject1).samplesForLead((EcgFile.Lead)localObject2) > 0L)
                {
                  a.d("Reading lead %s with %s samples", new Object[] { localObject2, Long.valueOf(((EcgFile)localObject1).samplesForLead((EcgFile.Lead)localObject2)) });
                  EcgStripView.access$3502(EcgStripView.this, ((EcgFile)localObject1).readEcgSamples((EcgFile.Lead)localObject2));
                }
                localObject2 = EcgFile.Lead.LEAD_5;
                if (((EcgFile)localObject1).samplesForLead((EcgFile.Lead)localObject2) > 0L)
                {
                  a.d("Reading lead %s with %s samples", new Object[] { localObject2, Long.valueOf(((EcgFile)localObject1).samplesForLead((EcgFile.Lead)localObject2)) });
                  EcgStripView.access$3602(EcgStripView.this, ((EcgFile)localObject1).readEcgSamples((EcgFile.Lead)localObject2));
                }
                localObject2 = EcgFile.Lead.LEAD_6;
                if (((EcgFile)localObject1).samplesForLead((EcgFile.Lead)localObject2) > 0L)
                {
                  a.d("Reading lead %s with %s samples", new Object[] { localObject2, Long.valueOf(((EcgFile)localObject1).samplesForLead((EcgFile.Lead)localObject2)) });
                  EcgStripView.access$3702(EcgStripView.this, ((EcgFile)localObject1).readEcgSamples((EcgFile.Lead)localObject2));
                }
                i = ((EcgFile)localObject1).getMainsFreq();
                if (!mIsEnhancedFilter)
                {
                  if (mLead1 != null)
                  {
                    localObject2 = EcgStripView.this;
                    EcgStripView.access$3102((EcgStripView)localObject2, Database.getManga(mLead1, i));
                  }
                  if (mLead2 != null)
                  {
                    localObject2 = EcgStripView.this;
                    EcgStripView.access$3302((EcgStripView)localObject2, Database.getManga(mLead2, i));
                  }
                  if (mLead3 != null)
                  {
                    localObject2 = EcgStripView.this;
                    EcgStripView.access$3402((EcgStripView)localObject2, Database.getManga(mLead3, i));
                  }
                  if (mLead4 != null)
                  {
                    localObject2 = EcgStripView.this;
                    EcgStripView.access$3502((EcgStripView)localObject2, Database.getManga(mLead4, i));
                  }
                  if (mLead5 != null)
                  {
                    localObject2 = EcgStripView.this;
                    EcgStripView.access$3602((EcgStripView)localObject2, Database.getManga(mLead5, i));
                  }
                  if (mLead6 != null)
                  {
                    localObject2 = EcgStripView.this;
                    EcgStripView.access$3702((EcgStripView)localObject2, Database.getManga(mLead6, i));
                  }
                }
                bool = isCancelled();
                if (!bool) {
                  a.a("readEcgFileTask completed", new Object[0]);
                } else {
                  a.a("readEcgFileTask completed but cancelled", new Object[0]);
                }
              }
              catch (Throwable localThrowable)
              {
                throw localThrowable;
              }
            }
          }
          int i = ((EcgFile)localObject1).getTotalLead1Samples();
          a.b("Failed to open ECG file %s or sample count %d was too low", new Object[] { paramVarArgs, Integer.valueOf(i) });
          paramVarArgs = EcgStripView.this;
          EcgStripView.access$2602(paramVarArgs, 0);
          ((EcgFile)localObject1).close();
          return null;
        }
        catch (Throwable paramVarArgs) {}catch (IOException paramVarArgs)
        {
          a.c(paramVarArgs, "readEcgFileTask Failed to read-in ECG samples", new Object[0]);
          ((EcgFile)localObject1).close();
          a.d("readEcgFileTask complete", new Object[0]);
          return null;
        }
        ((EcgFile)localObject1).close();
        throw paramVarArgs;
      }
      catch (Throwable paramVarArgs)
      {
        throw paramVarArgs;
      }
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      a.a("onPostExecute", new Object[0]);
      try
      {
        boolean bool = isCancelled();
        if (!bool)
        {
          paramVoid = activityWeakRef;
          if (paramVoid != null)
          {
            paramVoid = paramVoid.get();
            if (paramVoid != null)
            {
              paramVoid = activityWeakRef;
              paramVoid = paramVoid.get();
              paramVoid = (Activity)paramVoid;
              bool = paramVoid.isFinishing();
              if (!bool)
              {
                a.d("readEcgFileTask onPostExecute", new Object[0]);
                paramVoid = EcgStripView.this;
                EcgStripView.access$3802(paramVoid, true);
                paramVoid = EcgStripView.this;
                paramVoid.scrollTo(0, 0);
                paramVoid = EcgStripView.this;
                paramVoid.setEcgViewLimits();
                paramVoid = EcgStripView.this;
                float f1 = mCurrentViewport.width();
                paramVoid = EcgStripView.this;
                paramVoid = mCurrentViewport;
                float f2 = left;
                paramVoid = EcgStripView.this;
                float f3 = mMaxX;
                if (f2 > f3 - f1)
                {
                  paramVoid = EcgStripView.this;
                  paramVoid = mCurrentViewport;
                  Object localObject = EcgStripView.this;
                  f2 = mMaxX;
                  left = (f2 - f1);
                  paramVoid = EcgStripView.this;
                  paramVoid = mCurrentViewport;
                  localObject = EcgStripView.this;
                  localObject = mCurrentViewport;
                  right = (left + f1);
                }
                paramVoid = EcgStripView.this;
                paramVoid.constrainViewport();
                paramVoid = EcgStripView.this;
                ViewCompat.postInvalidateOnAnimation(paramVoid);
              }
            }
          }
        }
        paramVoid = EcgStripView.this;
        paramVoid = paramVoid.getRootView();
        int i = R.id.textProgress;
        paramVoid = paramVoid.findViewById(i);
        paramVoid = (TextView)paramVoid;
        if (paramVoid != null) {
          paramVoid.setVisibility(8);
        }
        paramVoid = EcgStripView.this;
        bool = mNeedToBeInCenter;
        if (bool)
        {
          paramVoid = EcgStripView.this;
          paramVoid.moveToCenter();
          return;
        }
      }
      catch (Exception paramVoid)
      {
        a.c(paramVoid, " failed to execute ecg loading task", new Object[0]);
      }
    }
    
    protected void onProgressUpdate(String... paramVarArgs)
    {
      TextView localTextView = (TextView)getRootView().findViewById(R.id.textProgress);
      if (localTextView != null)
      {
        localTextView.setText(paramVarArgs[0]);
        localTextView.setVisibility(0);
      }
    }
  }
}
