package com.google.android.gms.common;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.base.R.styleable;
import com.google.android.gms.common.internal.Line;
import com.google.android.gms.common.internal.zaaa;
import com.google.android.gms.common.package_12.Scope;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SignInButton
  extends FrameLayout
  implements View.OnClickListener
{
  public static final int COLOR_AUTO = 2;
  public static final int COLOR_DARK = 0;
  public static final int COLOR_LIGHT = 1;
  public static final int SIZE_ICON_ONLY = 2;
  public static final int SIZE_STANDARD = 0;
  public static final int SIZE_WIDE = 1;
  private View a;
  private int color;
  private View.OnClickListener mClickListener = null;
  private int size;
  
  public SignInButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SignInButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SignInButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.SignInButton, 0, 0);
    try
    {
      color = paramContext.getInt(R.styleable.SignInButton_buttonSize, 0);
      size = paramContext.getInt(R.styleable.SignInButton_colorScheme, 2);
      paramContext.recycle();
      setStyle(color, size);
      return;
    }
    catch (Throwable paramAttributeSet)
    {
      paramContext.recycle();
      throw paramAttributeSet;
    }
  }
  
  private final void init(Context paramContext)
  {
    Object localObject = a;
    if (localObject != null) {
      removeView((View)localObject);
    }
    int i = color;
    int j = size;
    try
    {
      localObject = Line.get(paramContext, i, j);
      a = ((View)localObject);
    }
    catch (RemoteCreator.RemoteCreatorException localRemoteCreatorException)
    {
      for (;;) {}
    }
    Log.w("SignInButton", "Sign in button not found, using placeholder instead");
    i = color;
    j = size;
    localObject = new zaaa(paramContext, null);
    ((zaaa)localObject).init(paramContext.getResources(), i, j);
    a = ((View)localObject);
    addView(a);
    a.setEnabled(isEnabled());
    a.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    View.OnClickListener localOnClickListener = mClickListener;
    if ((localOnClickListener != null) && (paramView == a)) {
      localOnClickListener.onClick(this);
    }
  }
  
  public void setColorScheme(int paramInt)
  {
    setStyle(color, paramInt);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    a.setEnabled(paramBoolean);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    mClickListener = paramOnClickListener;
    paramOnClickListener = a;
    if (paramOnClickListener != null) {
      paramOnClickListener.setOnClickListener(this);
    }
  }
  
  public void setScopes(Scope[] paramArrayOfScope)
  {
    setStyle(color, size);
  }
  
  public void setSize(int paramInt)
  {
    setStyle(paramInt, size);
  }
  
  public void setStyle(int paramInt1, int paramInt2)
  {
    color = paramInt1;
    size = paramInt2;
    init(getContext());
  }
  
  public void setStyle(int paramInt1, int paramInt2, Scope[] paramArrayOfScope)
  {
    setStyle(paramInt1, paramInt2);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ButtonSize {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ColorScheme {}
}
