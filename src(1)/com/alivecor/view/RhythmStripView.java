package com.alivecor.view;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.alivecor.alivecorkitlite.R.styleable;
import com.alivecor.mapsforge.record.EcgStripView;
import com.alivecor.upgrade.AliveCorEcg;
import com.alivecor.upgrade.EcgEvaluation;
import com.alivecor.upgrade.FilterType;

public class RhythmStripView
  extends FrameLayout
{
  private DisplayMode displayMode = DisplayMode.FULL;
  private boolean forceSingleLead;
  private EcgStripView wrappedView;
  
  public RhythmStripView(Context paramContext)
  {
    super(paramContext);
    initAttributes(paramContext, null, 0, 0);
  }
  
  public RhythmStripView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initAttributes(paramContext, paramAttributeSet, 0, 0);
  }
  
  public RhythmStripView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initAttributes(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public RhythmStripView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    initAttributes(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  private void configureAsFull()
  {
    wrappedView.setHorizontalScrollBarEnabled(true);
    wrappedView.setTouchEnabled(true);
    wrappedView.setNeedToBeInCenter(false);
    wrappedView.setNeedDrawAnnotations(true);
    wrappedView.setForceSingleLead(forceSingleLead);
    wrappedView.setDrawEdgeEffect(true);
  }
  
  private void configureAsPreview()
  {
    wrappedView.setHorizontalScrollBarEnabled(false);
    wrappedView.setTouchEnabled(false);
    wrappedView.setNeedDrawAnnotations(false);
    wrappedView.setDrawEdgeEffect(false);
    wrappedView.setForceSingleLead(true);
    wrappedView.setNeedToBeInCenter(true);
  }
  
  private EcgStripView createEcgStripView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    Object localObject = generateDefaultLayoutParams();
    EcgStripView localEcgStripView = new EcgStripView(paramContext);
    localEcgStripView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (paramAttributeSet != null)
    {
      localObject = null;
      try
      {
        paramAttributeSet = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.RhythmStripView, paramInt1, paramInt2);
        paramContext = paramAttributeSet;
        localObject = paramContext;
        paramInt1 = R.styleable.RhythmStripView_traceStrokeWidth;
        localObject = paramContext;
        boolean bool = paramAttributeSet.hasValue(paramInt1);
        if (bool)
        {
          localObject = paramContext;
          localEcgStripView.setTraceThickness(paramAttributeSet.getDimension(paramInt1, 0.0F));
        }
        localObject = paramContext;
        paramInt1 = R.styleable.RhythmStripView_traceStrokeColor;
        localObject = paramContext;
        bool = paramAttributeSet.hasValue(paramInt1);
        if (bool)
        {
          localObject = paramContext;
          localEcgStripView.setTraceColor(paramAttributeSet.getColor(paramInt1, -16777216));
        }
        localObject = paramContext;
        paramInt1 = R.styleable.RhythmStripView_majorColorGrid;
        localObject = paramContext;
        bool = paramAttributeSet.hasValue(paramInt1);
        if (bool)
        {
          localObject = paramContext;
          localEcgStripView.setMajorGridColor(paramAttributeSet.getColor(paramInt1, -7829368));
        }
        localObject = paramContext;
        bool = paramAttributeSet.hasValue(R.styleable.RhythmStripView_minorColorGrid);
        if (bool)
        {
          localObject = paramContext;
          localEcgStripView.setMinorGridColor(paramAttributeSet.getColor(paramInt1, -7829368));
        }
        localObject = paramContext;
        paramInt1 = R.styleable.RhythmStripView_graphScale;
        localObject = paramContext;
        bool = paramAttributeSet.hasValue(paramInt1);
        if (bool)
        {
          localObject = paramContext;
          localEcgStripView.setScale(paramAttributeSet.getFloat(paramInt1, 1.0F));
        }
        paramAttributeSet.recycle();
        return localEcgStripView;
      }
      catch (Throwable paramContext)
      {
        if (localObject != null) {
          ((TypedArray)localObject).recycle();
        }
        throw paramContext;
      }
    }
    return localEcgStripView;
  }
  
  private void initAttributes(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    Object localObject = createEcgStripView(paramContext, paramAttributeSet, paramInt1, paramInt2);
    wrappedView = ((EcgStripView)localObject);
    addView((View)localObject, generateDefaultLayoutParams());
    if (paramAttributeSet != null)
    {
      localObject = null;
      try
      {
        paramAttributeSet = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.RhythmStripView, paramInt1, paramInt2);
        paramContext = paramAttributeSet;
        localObject = paramContext;
        paramInt1 = paramAttributeSet.getInt(R.styleable.RhythmStripView_displayMode, DisplayMode.FULL.ordinal());
        localObject = paramContext;
        displayMode = DisplayMode.values()[paramInt1];
        localObject = paramContext;
        forceSingleLead = paramAttributeSet.getBoolean(R.styleable.RhythmStripView_alwaysSingleLead, false);
        paramAttributeSet.recycle();
      }
      catch (Throwable paramContext)
      {
        if (localObject != null) {
          ((TypedArray)localObject).recycle();
        }
        throw paramContext;
      }
    }
    setAlwaysSingleLead(forceSingleLead);
    setDisplayMode(displayMode);
  }
  
  public void setAlwaysSingleLead(boolean paramBoolean)
  {
    forceSingleLead = paramBoolean;
    wrappedView.setForceSingleLead(paramBoolean);
    invalidate();
  }
  
  public void setDisplayMode(DisplayMode paramDisplayMode)
  {
    displayMode = paramDisplayMode;
    if (paramDisplayMode == DisplayMode.FULL) {
      configureAsFull();
    } else {
      configureAsPreview();
    }
    invalidate();
  }
  
  public void setEcgRecord(AliveCorEcg paramAliveCorEcg)
  {
    EcgEvaluation localEcgEvaluation = paramAliveCorEcg.getEcgEvaluation();
    boolean bool;
    if ((localEcgEvaluation != null) && (localEcgEvaluation.isInverted())) {
      bool = true;
    } else {
      bool = false;
    }
    wrappedView.setEcgRecord(paramAliveCorEcg.getUuid(), bool, AsyncTask.THREAD_POOL_EXECUTOR);
  }
  
  public void setFilterType(FilterType paramFilterType)
  {
    EcgStripView localEcgStripView = wrappedView;
    boolean bool;
    if (paramFilterType == FilterType.ENHANCED) {
      bool = true;
    } else {
      bool = false;
    }
    localEcgStripView.setEnhancedFilter(bool, AsyncTask.THREAD_POOL_EXECUTOR);
  }
  
  public void setGraphScale(float paramFloat)
  {
    wrappedView.setScale(paramFloat);
  }
  
  public void setInverted(boolean paramBoolean)
  {
    wrappedView.setInvertedECG(paramBoolean);
    invalidate();
  }
  
  public static enum DisplayMode
  {
    static
    {
      DisplayMode localDisplayMode1 = new DisplayMode("PREVIEW", 0);
      PREVIEW = localDisplayMode1;
      DisplayMode localDisplayMode2 = new DisplayMode("FULL", 1);
      FULL = localDisplayMode2;
      $VALUES = new DisplayMode[] { localDisplayMode1, localDisplayMode2 };
    }
  }
}
