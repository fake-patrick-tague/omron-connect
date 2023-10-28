package com.google.android.gms.internal.base;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;

public final class DrawableWrapperDonut
  extends Drawable
  implements Drawable.Callback
{
  private int mAlpha = 0;
  private boolean mColorFilterSet;
  private boolean mCurrentMode;
  private Drawable mDelegateDrawable;
  private Drawable mDrawable;
  private int mDuration;
  private boolean mFlat = true;
  private boolean mHaveOpacity;
  private LayerDrawable.LayerState mLayerState;
  private boolean mMutated;
  private int mOpacity;
  private long mStartTimeMillis;
  private int mState = 255;
  private int mTo;
  private int mTransitionState = 0;
  
  public DrawableWrapperDonut(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this(null);
    Object localObject = paramDrawable1;
    if (paramDrawable1 == null) {
      localObject = VectorDrawableCompat.create();
    }
    mDelegateDrawable = ((Drawable)localObject);
    ((Drawable)localObject).setCallback(this);
    paramDrawable1 = mLayerState;
    int i = mChildrenChangingConfigurations;
    mChildrenChangingConfigurations = (((Drawable)localObject).getChangingConfigurations() | i);
    paramDrawable1 = paramDrawable2;
    if (paramDrawable2 == null) {
      paramDrawable1 = VectorDrawableCompat.create();
    }
    mDrawable = paramDrawable1;
    paramDrawable1.setCallback(this);
    paramDrawable2 = mLayerState;
    i = mChildrenChangingConfigurations;
    mChildrenChangingConfigurations = (paramDrawable1.getChangingConfigurations() | i);
  }
  
  DrawableWrapperDonut(LayerDrawable.LayerState paramLayerState)
  {
    mLayerState = new LayerDrawable.LayerState(paramLayerState);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    int m = mTransitionState;
    int k = 0;
    int i = 1;
    int j = 1;
    if (m != 1)
    {
      if ((m == 2) && (mStartTimeMillis >= 0L))
      {
        float f = (float)(SystemClock.uptimeMillis() - mStartTimeMillis) / mDuration;
        if (f >= 1.0F) {
          i = j;
        } else {
          i = 0;
        }
        if (i != 0) {
          mTransitionState = 0;
        }
        f = Math.min(f, 1.0F);
        mAlpha = ((int)(mTo * f + 0.0F));
      }
    }
    else
    {
      mStartTimeMillis = SystemClock.uptimeMillis();
      mTransitionState = 2;
      i = 0;
    }
    j = mAlpha;
    boolean bool = mFlat;
    Drawable localDrawable1 = mDelegateDrawable;
    Drawable localDrawable2 = mDrawable;
    if (i != 0)
    {
      if (bool)
      {
        i = j;
        if (j != 0) {
          break label170;
        }
        i = k;
      }
      else
      {
        i = j;
      }
      localDrawable1.draw(paramCanvas);
      label170:
      j = mState;
      if (i == j)
      {
        localDrawable2.setAlpha(j);
        localDrawable2.draw(paramCanvas);
      }
    }
    else
    {
      if (bool) {
        localDrawable1.setAlpha(mState - j);
      }
      localDrawable1.draw(paramCanvas);
      if (bool) {
        localDrawable1.setAlpha(mState);
      }
      if (j > 0)
      {
        localDrawable2.setAlpha(j);
        localDrawable2.draw(paramCanvas);
        localDrawable2.setAlpha(mState);
      }
      invalidateSelf();
    }
  }
  
  public final int getChangingConfigurations()
  {
    int i = super.getChangingConfigurations();
    LayerDrawable.LayerState localLayerState = mLayerState;
    return i | mChangingConfigurations | mChildrenChangingConfigurations;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if (updateTint())
    {
      mLayerState.mChangingConfigurations = getChangingConfigurations();
      return mLayerState;
    }
    return null;
  }
  
  public final int getIntrinsicHeight()
  {
    return Math.max(mDelegateDrawable.getIntrinsicHeight(), mDrawable.getIntrinsicHeight());
  }
  
  public final int getIntrinsicWidth()
  {
    return Math.max(mDelegateDrawable.getIntrinsicWidth(), mDrawable.getIntrinsicWidth());
  }
  
  public final int getOpacity()
  {
    if (!mHaveOpacity)
    {
      mOpacity = Drawable.resolveOpacity(mDelegateDrawable.getOpacity(), mDrawable.getOpacity());
      mHaveOpacity = true;
    }
    return mOpacity;
  }
  
  public final Drawable getWrappedDrawable()
  {
    return mDrawable;
  }
  
  public final void invalidateDrawable(Drawable paramDrawable)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.invalidateDrawable(this);
    }
  }
  
  public final Drawable mutate()
  {
    if ((!mMutated) && (super.mutate() == this))
    {
      if (updateTint())
      {
        mDelegateDrawable.mutate();
        mDrawable.mutate();
        mMutated = true;
        return this;
      }
      throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
    }
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    mDelegateDrawable.setBounds(paramRect);
    mDrawable.setBounds(paramRect);
  }
  
  public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  public final void setAlpha(int paramInt)
  {
    if (mAlpha == mState) {
      mAlpha = paramInt;
    }
    mState = paramInt;
    invalidateSelf();
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    mDelegateDrawable.setColorFilter(paramColorFilter);
    mDrawable.setColorFilter(paramColorFilter);
  }
  
  public final void startTransition(int paramInt)
  {
    mTo = mState;
    mAlpha = 0;
    mDuration = 250;
    mTransitionState = 1;
    invalidateSelf();
  }
  
  public final void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.unscheduleDrawable(this, paramRunnable);
    }
  }
  
  public final boolean updateTint()
  {
    if (!mColorFilterSet)
    {
      Drawable.ConstantState localConstantState = mDelegateDrawable.getConstantState();
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (localConstantState != null)
      {
        bool1 = bool2;
        if (mDrawable.getConstantState() != null) {
          bool1 = true;
        }
      }
      mCurrentMode = bool1;
      mColorFilterSet = true;
    }
    return mCurrentMode;
  }
}
