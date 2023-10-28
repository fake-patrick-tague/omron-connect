package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.Frame;
import v7.internal.R.styleable;
import v7.v7.package_13.ViewCompat;

class ClassWriter
{
  private final CheckedTextView a;
  private boolean e;
  private ColorStateList mButtonTintList = null;
  private PorterDuff.Mode mButtonTintMode = null;
  private boolean mHasButtonTint = false;
  private boolean mHasButtonTintMode = false;
  
  ClassWriter(CheckedTextView paramCheckedTextView)
  {
    a = paramCheckedTextView;
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt)
  {
    localObject = a.getContext();
    int[] arrayOfInt = R.styleable.LinePageIndicator;
    localObject = TintTypedArray.obtainStyledAttributes((Context)localObject, paramAttributeSet, arrayOfInt, paramInt, 0);
    CheckedTextView localCheckedTextView = a;
    ViewCompat.obtainStyledAttributes(localCheckedTextView, localCheckedTextView.getContext(), arrayOfInt, paramAttributeSet, ((TintTypedArray)localObject).getResourceId(), paramInt, 0);
    for (;;)
    {
      try
      {
        paramInt = R.styleable.AppBarLayout_LayoutParams_layout_scrollInterpolator;
        bool = ((TintTypedArray)localObject).hasValue(paramInt);
        if (bool)
        {
          paramInt = ((TintTypedArray)localObject).getResourceId(paramInt, 0);
          if (paramInt != 0) {
            paramAttributeSet = a;
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
        paramAttributeSet.setCheckMarkDrawable(v7.internal.transition.util.View.getDrawable(paramAttributeSet.getContext(), paramInt));
        paramInt = 1;
      }
      catch (Resources.NotFoundException paramAttributeSet) {}
    }
    paramInt = 0;
    if (paramInt == 0)
    {
      paramInt = R.styleable.d;
      bool = ((TintTypedArray)localObject).hasValue(paramInt);
      if (bool)
      {
        paramInt = ((TintTypedArray)localObject).getResourceId(paramInt, 0);
        if (paramInt != 0)
        {
          paramAttributeSet = a;
          paramAttributeSet.setCheckMarkDrawable(v7.internal.transition.util.View.getDrawable(paramAttributeSet.getContext(), paramInt));
        }
      }
    }
    paramInt = R.styleable.b;
    bool = ((TintTypedArray)localObject).hasValue(paramInt);
    if (bool) {
      Frame.a(a, ((TintTypedArray)localObject).getColor(paramInt));
    }
    paramInt = R.styleable.e;
    bool = ((TintTypedArray)localObject).hasValue(paramInt);
    if (bool) {
      Frame.a(a, Drawable.parseTintMode(((TintTypedArray)localObject).getInt(paramInt, -1), null));
    }
    ((TintTypedArray)localObject).recycle();
  }
  
  void applyButtonTint()
  {
    android.graphics.drawable.Drawable localDrawable = Frame.get(a);
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
        localDrawable.setState(a.getDrawableState());
      }
      a.setCheckMarkDrawable(localDrawable);
    }
  }
  
  void b()
  {
    if (e)
    {
      e = false;
      return;
    }
    e = true;
    applyButtonTint();
  }
  
  ColorStateList c()
  {
    return mButtonTintList;
  }
  
  PorterDuff.Mode getSupportButtonTintMode()
  {
    return mButtonTintMode;
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
