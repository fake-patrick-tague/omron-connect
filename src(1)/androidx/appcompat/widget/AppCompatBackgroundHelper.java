package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import v7.internal.R.styleable;

class AppCompatBackgroundHelper
{
  private TintInfo mBackgroundTint;
  private TintInfo mInternalBackgroundTint;
  private int mOldLayerType = -1;
  private final ViewCompat mTintManager;
  private TintInfo mTmpInfo;
  private final View mView;
  
  AppCompatBackgroundHelper(View paramView)
  {
    mView = paramView;
    mTintManager = ViewCompat.get();
  }
  
  private boolean compatTintDrawableUsingFrameworkTint(android.graphics.drawable.Drawable paramDrawable)
  {
    if (mTmpInfo == null) {
      mTmpInfo = new TintInfo();
    }
    TintInfo localTintInfo = mTmpInfo;
    localTintInfo.clear();
    Object localObject = v7.v7.package_13.ViewCompat.getBackgroundTintList(mView);
    if (localObject != null)
    {
      mHasTintList = true;
      mTintList = ((ColorStateList)localObject);
    }
    localObject = v7.v7.package_13.ViewCompat.getBackgroundTintMode(mView);
    if (localObject != null)
    {
      mHasTintMode = true;
      mTintMode = ((PorterDuff.Mode)localObject);
    }
    if ((!mHasTintList) && (!mHasTintMode)) {
      return false;
    }
    ViewCompat.tintDrawable(paramDrawable, localTintInfo, mView.getDrawableState());
    return true;
  }
  
  private boolean shouldCompatTintUsingFrameworkTint()
  {
    int i = Build.VERSION.SDK_INT;
    if (i > 21) {
      return mInternalBackgroundTint != null;
    }
    return i == 21;
  }
  
  void applySupportBackgroundTint()
  {
    android.graphics.drawable.Drawable localDrawable = mView.getBackground();
    if (localDrawable != null)
    {
      if ((shouldCompatTintUsingFrameworkTint()) && (compatTintDrawableUsingFrameworkTint(localDrawable))) {
        return;
      }
      TintInfo localTintInfo = mBackgroundTint;
      if (localTintInfo != null)
      {
        ViewCompat.tintDrawable(localDrawable, localTintInfo, mView.getDrawableState());
        return;
      }
      localTintInfo = mInternalBackgroundTint;
      if (localTintInfo != null) {
        ViewCompat.tintDrawable(localDrawable, localTintInfo, mView.getDrawableState());
      }
    }
  }
  
  ColorStateList getSupportBackgroundTintList()
  {
    TintInfo localTintInfo = mBackgroundTint;
    if (localTintInfo != null) {
      return mTintList;
    }
    return null;
  }
  
  PorterDuff.Mode getSupportBackgroundTintMode()
  {
    TintInfo localTintInfo = mBackgroundTint;
    if (localTintInfo != null) {
      return mTintMode;
    }
    return null;
  }
  
  void loadFromAttributes(int paramInt)
  {
    mOldLayerType = paramInt;
    Object localObject = mTintManager;
    if (localObject != null) {
      localObject = ((ViewCompat)localObject).getTintList(mView.getContext(), paramInt);
    } else {
      localObject = null;
    }
    setInternalBackgroundTint((ColorStateList)localObject);
    applySupportBackgroundTint();
  }
  
  void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    Object localObject = mView.getContext();
    int[] arrayOfInt = R.styleable.ViewBackgroundHelper;
    localObject = TintTypedArray.obtainStyledAttributes((Context)localObject, paramAttributeSet, arrayOfInt, paramInt, 0);
    View localView = mView;
    v7.v7.package_13.ViewCompat.obtainStyledAttributes(localView, localView.getContext(), arrayOfInt, paramAttributeSet, ((TintTypedArray)localObject).getResourceId(), paramInt, 0);
    try
    {
      paramInt = R.styleable.ViewBackgroundHelper_android_background;
      boolean bool = ((TintTypedArray)localObject).hasValue(paramInt);
      if (bool)
      {
        mOldLayerType = ((TintTypedArray)localObject).getResourceId(paramInt, -1);
        paramAttributeSet = mTintManager.getTintList(mView.getContext(), mOldLayerType);
        if (paramAttributeSet != null) {
          setInternalBackgroundTint(paramAttributeSet);
        }
      }
      paramInt = R.styleable.CompoundButton_buttonTint;
      bool = ((TintTypedArray)localObject).hasValue(paramInt);
      if (bool) {
        v7.v7.package_13.ViewCompat.setBackgroundTintList(mView, ((TintTypedArray)localObject).getColor(paramInt));
      }
      paramInt = R.styleable.ViewBackgroundHelper_backgroundTintMode;
      bool = ((TintTypedArray)localObject).hasValue(paramInt);
      if (bool) {
        v7.v7.package_13.ViewCompat.setBackgroundTintMode(mView, Drawable.parseTintMode(((TintTypedArray)localObject).getInt(paramInt, -1), null));
      }
      ((TintTypedArray)localObject).recycle();
      return;
    }
    catch (Throwable paramAttributeSet)
    {
      ((TintTypedArray)localObject).recycle();
      throw paramAttributeSet;
    }
  }
  
  void onSetBackgroundDrawable(android.graphics.drawable.Drawable paramDrawable)
  {
    mOldLayerType = -1;
    setInternalBackgroundTint(null);
    applySupportBackgroundTint();
  }
  
  void setInternalBackgroundTint(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (mInternalBackgroundTint == null) {
        mInternalBackgroundTint = new TintInfo();
      }
      TintInfo localTintInfo = mInternalBackgroundTint;
      mTintList = paramColorStateList;
      mHasTintList = true;
    }
    else
    {
      mInternalBackgroundTint = null;
    }
    applySupportBackgroundTint();
  }
  
  void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (mBackgroundTint == null) {
      mBackgroundTint = new TintInfo();
    }
    TintInfo localTintInfo = mBackgroundTint;
    mTintList = paramColorStateList;
    mHasTintList = true;
    applySupportBackgroundTint();
  }
  
  void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (mBackgroundTint == null) {
      mBackgroundTint = new TintInfo();
    }
    TintInfo localTintInfo = mBackgroundTint;
    mTintMode = paramMode;
    mHasTintMode = true;
    applySupportBackgroundTint();
  }
}
