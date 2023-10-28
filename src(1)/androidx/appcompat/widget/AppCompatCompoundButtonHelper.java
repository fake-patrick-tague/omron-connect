package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;
import v7.internal.R.styleable;
import v7.v7.package_13.ViewCompat;

class AppCompatCompoundButtonHelper
{
  private ColorStateList mButtonTintList = null;
  private PorterDuff.Mode mButtonTintMode = null;
  private boolean mHasButtonTint = false;
  private boolean mHasButtonTintMode = false;
  private boolean mSkipNextApply;
  private final CompoundButton mView;
  
  AppCompatCompoundButtonHelper(CompoundButton paramCompoundButton)
  {
    mView = paramCompoundButton;
  }
  
  void applyButtonTint()
  {
    android.graphics.drawable.Drawable localDrawable = CompoundButtonCompat.getButtonDrawable(mView);
    if ((localDrawable != null) && ((mHasButtonTint) || (mHasButtonTintMode)))
    {
      localDrawable = DrawableCompat.getDrawable(localDrawable).mutate();
      if (mHasButtonTint) {
        DrawableCompat.append(localDrawable, mButtonTintList);
      }
      if (mHasButtonTintMode) {
        DrawableCompat.setTintMode(localDrawable, mButtonTintMode);
      }
      if (localDrawable.isStateful()) {
        localDrawable.setState(mView.getDrawableState());
      }
      mView.setButtonDrawable(localDrawable);
    }
  }
  
  int getCompoundPaddingLeft(int paramInt)
  {
    int i = paramInt;
    if (Build.VERSION.SDK_INT < 17)
    {
      android.graphics.drawable.Drawable localDrawable = CompoundButtonCompat.getButtonDrawable(mView);
      i = paramInt;
      if (localDrawable != null) {
        i = paramInt + localDrawable.getIntrinsicWidth();
      }
    }
    return i;
  }
  
  ColorStateList getSupportButtonTintList()
  {
    return mButtonTintList;
  }
  
  PorterDuff.Mode getSupportButtonTintMode()
  {
    return mButtonTintMode;
  }
  
  void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    localObject = mView.getContext();
    int[] arrayOfInt = R.styleable.VIEW_ATTRS;
    localObject = TintTypedArray.obtainStyledAttributes((Context)localObject, paramAttributeSet, arrayOfInt, paramInt, 0);
    CompoundButton localCompoundButton = mView;
    ViewCompat.obtainStyledAttributes(localCompoundButton, localCompoundButton.getContext(), arrayOfInt, paramAttributeSet, ((TintTypedArray)localObject).getResourceId(), paramInt, 0);
    for (;;)
    {
      try
      {
        paramInt = R.styleable.ViewBackgroundHelper_backgroundTint;
        bool = ((TintTypedArray)localObject).hasValue(paramInt);
        if (bool)
        {
          paramInt = ((TintTypedArray)localObject).getResourceId(paramInt, 0);
          if (paramInt != 0) {
            paramAttributeSet = mView;
          }
        }
      }
      catch (Throwable paramAttributeSet)
      {
        boolean bool;
        ((TintTypedArray)localObject).recycle();
        throw paramAttributeSet;
      }
      try
      {
        paramAttributeSet.setButtonDrawable(v7.internal.transition.util.View.getDrawable(paramAttributeSet.getContext(), paramInt));
        paramInt = 1;
      }
      catch (Resources.NotFoundException paramAttributeSet) {}
    }
    paramInt = 0;
    if (paramInt == 0)
    {
      paramInt = R.styleable.CompoundButton_android_button;
      bool = ((TintTypedArray)localObject).hasValue(paramInt);
      if (bool)
      {
        paramInt = ((TintTypedArray)localObject).getResourceId(paramInt, 0);
        if (paramInt != 0)
        {
          paramAttributeSet = mView;
          paramAttributeSet.setButtonDrawable(v7.internal.transition.util.View.getDrawable(paramAttributeSet.getContext(), paramInt));
        }
      }
    }
    paramInt = R.styleable.CompoundButton_buttonTintMode;
    bool = ((TintTypedArray)localObject).hasValue(paramInt);
    if (bool) {
      CompoundButtonCompat.b(mView, ((TintTypedArray)localObject).getColor(paramInt));
    }
    paramInt = R.styleable.RobotoTextView_typeface;
    bool = ((TintTypedArray)localObject).hasValue(paramInt);
    if (bool) {
      CompoundButtonCompat.setButtonTintMode(mView, Drawable.parseTintMode(((TintTypedArray)localObject).getInt(paramInt, -1), null));
    }
    ((TintTypedArray)localObject).recycle();
  }
  
  void onSetButtonDrawable()
  {
    if (mSkipNextApply)
    {
      mSkipNextApply = false;
      return;
    }
    mSkipNextApply = true;
    applyButtonTint();
  }
  
  void setSupportButtonTintList(ColorStateList paramColorStateList)
  {
    mButtonTintList = paramColorStateList;
    mHasButtonTint = true;
    applyButtonTint();
  }
  
  void setSupportButtonTintMode(PorterDuff.Mode paramMode)
  {
    mButtonTintMode = paramMode;
    mHasButtonTintMode = true;
    applyButtonTint();
  }
}
