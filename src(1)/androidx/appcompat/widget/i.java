package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.widget.NavigationMenuPresenter;
import v7.internal.R.styleable;

public class i
{
  private final ImageView a;
  private TintInfo c;
  private int d = 0;
  private TintInfo k;
  private TintInfo mBackgroundTint;
  
  public i(ImageView paramImageView)
  {
    a = paramImageView;
  }
  
  private boolean a(android.graphics.drawable.Drawable paramDrawable)
  {
    if (k == null) {
      k = new TintInfo();
    }
    TintInfo localTintInfo = k;
    localTintInfo.clear();
    Object localObject = NavigationMenuPresenter.b(a);
    if (localObject != null)
    {
      mHasTintList = true;
      mTintList = ((ColorStateList)localObject);
    }
    localObject = NavigationMenuPresenter.a(a);
    if (localObject != null)
    {
      mHasTintMode = true;
      mTintMode = ((PorterDuff.Mode)localObject);
    }
    if ((!mHasTintList) && (!mHasTintMode)) {
      return false;
    }
    ViewCompat.tintDrawable(paramDrawable, localTintInfo, a.getDrawableState());
    return true;
  }
  
  private boolean c()
  {
    int i = Build.VERSION.SDK_INT;
    if (i > 21) {
      return c != null;
    }
    return i == 21;
  }
  
  void a()
  {
    if (a.getDrawable() != null) {
      a.getDrawable().setLevel(d);
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 0)
    {
      android.graphics.drawable.Drawable localDrawable = v7.internal.transition.util.View.getDrawable(a.getContext(), paramInt);
      if (localDrawable != null) {
        Drawable.a(localDrawable);
      }
      a.setImageDrawable(localDrawable);
    }
    else
    {
      a.setImageDrawable(null);
    }
    b();
  }
  
  public void a(AttributeSet paramAttributeSet, int paramInt)
  {
    Object localObject2 = a.getContext();
    Object localObject1 = R.styleable.ButtonBarLayout;
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes((Context)localObject2, paramAttributeSet, (int[])localObject1, paramInt, 0);
    localObject2 = a;
    v7.v7.package_13.ViewCompat.obtainStyledAttributes((android.view.View)localObject2, ((android.view.View)localObject2).getContext(), (int[])localObject1, paramAttributeSet, localTintTypedArray.getResourceId(), paramInt, 0);
    try
    {
      localObject2 = a.getDrawable();
      localObject1 = localObject2;
      paramAttributeSet = (AttributeSet)localObject1;
      if (localObject2 == null)
      {
        paramInt = localTintTypedArray.getResourceId(R.styleable.k, -1);
        paramAttributeSet = (AttributeSet)localObject1;
        if (paramInt != -1)
        {
          localObject2 = v7.internal.transition.util.View.getDrawable(a.getContext(), paramInt);
          localObject1 = localObject2;
          paramAttributeSet = (AttributeSet)localObject1;
          if (localObject2 != null)
          {
            a.setImageDrawable((android.graphics.drawable.Drawable)localObject2);
            paramAttributeSet = (AttributeSet)localObject1;
          }
        }
      }
      if (paramAttributeSet != null) {
        Drawable.a(paramAttributeSet);
      }
      paramInt = R.styleable.ABSOLUTE;
      boolean bool = localTintTypedArray.hasValue(paramInt);
      if (bool) {
        NavigationMenuPresenter.a(a, localTintTypedArray.getColor(paramInt));
      }
      paramInt = R.styleable.Preference_defaultValue;
      bool = localTintTypedArray.hasValue(paramInt);
      if (bool) {
        NavigationMenuPresenter.a(a, Drawable.parseTintMode(localTintTypedArray.getInt(paramInt, -1), null));
      }
      localTintTypedArray.recycle();
      return;
    }
    catch (Throwable paramAttributeSet)
    {
      localTintTypedArray.recycle();
      throw paramAttributeSet;
    }
  }
  
  boolean add()
  {
    android.graphics.drawable.Drawable localDrawable = a.getBackground();
    return (Build.VERSION.SDK_INT < 21) || (!(localDrawable instanceof RippleDrawable));
  }
  
  void b()
  {
    android.graphics.drawable.Drawable localDrawable = a.getDrawable();
    if (localDrawable != null) {
      Drawable.a(localDrawable);
    }
    if (localDrawable != null)
    {
      if ((c()) && (a(localDrawable))) {
        return;
      }
      TintInfo localTintInfo = mBackgroundTint;
      if (localTintInfo != null)
      {
        ViewCompat.tintDrawable(localDrawable, localTintInfo, a.getDrawableState());
        return;
      }
      localTintInfo = c;
      if (localTintInfo != null) {
        ViewCompat.tintDrawable(localDrawable, localTintInfo, a.getDrawableState());
      }
    }
  }
  
  void b(android.graphics.drawable.Drawable paramDrawable)
  {
    d = paramDrawable.getLevel();
  }
  
  void clear(ColorStateList paramColorStateList)
  {
    if (mBackgroundTint == null) {
      mBackgroundTint = new TintInfo();
    }
    TintInfo localTintInfo = mBackgroundTint;
    mTintList = paramColorStateList;
    mHasTintList = true;
    b();
  }
  
  void clear(PorterDuff.Mode paramMode)
  {
    if (mBackgroundTint == null) {
      mBackgroundTint = new TintInfo();
    }
    TintInfo localTintInfo = mBackgroundTint;
    mTintMode = paramMode;
    mHasTintMode = true;
    b();
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
}
