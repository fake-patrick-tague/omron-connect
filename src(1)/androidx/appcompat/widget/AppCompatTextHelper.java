package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsSeekBar;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import androidx.core.graphics.drawable.DrawableCompat;
import v7.internal.R.styleable;
import v7.v7.package_13.ViewCompat;

class AppCompatTextHelper
  extends AppCompatProgressBarHelper
{
  private ColorStateList mButtonTintList = null;
  private PorterDuff.Mode mButtonTintMode = null;
  private android.graphics.drawable.Drawable mDrawable;
  private boolean mHasButtonTint = false;
  private boolean mHasButtonTintMode = false;
  private final SeekBar mView;
  
  AppCompatTextHelper(SeekBar paramSeekBar)
  {
    super(paramSeekBar);
    mView = paramSeekBar;
  }
  
  private void applyButtonTint()
  {
    android.graphics.drawable.Drawable localDrawable = mDrawable;
    if ((localDrawable != null) && ((mHasButtonTint) || (mHasButtonTintMode)))
    {
      localDrawable = DrawableCompat.getDrawable(localDrawable.mutate());
      mDrawable = localDrawable;
      if (mHasButtonTint) {
        DrawableCompat.append(localDrawable, mButtonTintList);
      }
      if (mHasButtonTintMode) {
        DrawableCompat.setTintMode(mDrawable, mButtonTintMode);
      }
      if (mDrawable.isStateful()) {
        mDrawable.setState(mView.getDrawableState());
      }
    }
  }
  
  void draw(Canvas paramCanvas)
  {
    if (mDrawable != null)
    {
      int k = mView.getMax();
      int j = 1;
      if (k > 1)
      {
        int i = mDrawable.getIntrinsicWidth();
        int m = mDrawable.getIntrinsicHeight();
        if (i >= 0) {
          i /= 2;
        } else {
          i = 1;
        }
        if (m >= 0) {
          j = m / 2;
        }
        mDrawable.setBounds(-i, -j, i, j);
        float f = (mView.getWidth() - mView.getPaddingLeft() - mView.getPaddingRight()) / k;
        j = paramCanvas.save();
        paramCanvas.translate(mView.getPaddingLeft(), mView.getHeight() / 2);
        i = 0;
        while (i <= k)
        {
          mDrawable.draw(paramCanvas);
          paramCanvas.translate(f, 0.0F);
          i += 1;
        }
        paramCanvas.restoreToCount(j);
      }
    }
  }
  
  void jumpToCurrentState()
  {
    android.graphics.drawable.Drawable localDrawable = mDrawable;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
  }
  
  void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    super.loadFromAttributes(paramAttributeSet, paramInt);
    Object localObject = mView.getContext();
    int[] arrayOfInt = R.styleable.CompoundButton;
    localObject = TintTypedArray.obtainStyledAttributes((Context)localObject, paramAttributeSet, arrayOfInt, paramInt, 0);
    SeekBar localSeekBar = mView;
    ViewCompat.obtainStyledAttributes(localSeekBar, localSeekBar.getContext(), arrayOfInt, paramAttributeSet, ((TintTypedArray)localObject).getResourceId(), paramInt, 0);
    paramAttributeSet = ((TintTypedArray)localObject).getDrawableIfKnown(R.styleable.AppCompatImageView_android_src);
    if (paramAttributeSet != null) {
      mView.setThumb(paramAttributeSet);
    }
    setStatusBarBackground(((TintTypedArray)localObject).getDrawable(R.styleable.AppCompatImageView_srcCompat));
    paramInt = R.styleable.NavigationView_elevation;
    if (((TintTypedArray)localObject).hasValue(paramInt))
    {
      mButtonTintMode = Drawable.parseTintMode(((TintTypedArray)localObject).getInt(paramInt, -1), mButtonTintMode);
      mHasButtonTintMode = true;
    }
    paramInt = R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart;
    if (((TintTypedArray)localObject).hasValue(paramInt))
    {
      mButtonTintList = ((TintTypedArray)localObject).getColor(paramInt);
      mHasButtonTint = true;
    }
    ((TintTypedArray)localObject).recycle();
    applyButtonTint();
  }
  
  void setState()
  {
    android.graphics.drawable.Drawable localDrawable = mDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful()) && (localDrawable.setState(mView.getDrawableState()))) {
      mView.invalidateDrawable(localDrawable);
    }
  }
  
  void setStatusBarBackground(android.graphics.drawable.Drawable paramDrawable)
  {
    android.graphics.drawable.Drawable localDrawable = mDrawable;
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
    mDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(mView);
      DrawableCompat.a(paramDrawable, ViewCompat.getLayoutDirection(mView));
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(mView.getDrawableState());
      }
      applyButtonTint();
    }
    mView.invalidate();
  }
}
