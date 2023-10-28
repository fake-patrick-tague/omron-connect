package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.material.internal.Label;
import com.google.android.material.theme.utils.Effect;
import org.org.org.ui.ClassWriter;
import org.org.org.ui.R.string;
import org.org.org.ui.R.styleable;
import org.org.org.ui.asm.ByteVector;
import org.org.org.ui.asm.f;
import v7.v7.package_13.ViewCompat;

public class MaterialToolbar
  extends Toolbar
{
  private static final int a = R.string.angle;
  private Integer mAccentColor;
  
  public MaterialToolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, ClassWriter.w);
  }
  
  public MaterialToolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(Effect.a(paramContext, paramAttributeSet, paramInt, i), paramAttributeSet, paramInt);
    paramContext = getContext();
    paramAttributeSet = Label.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.View, paramInt, i, new int[0]);
    paramInt = R.styleable.CardView_cardBackgroundColor;
    if (paramAttributeSet.hasValue(paramInt)) {
      setNavigationIconTint(paramAttributeSet.getColor(paramInt, -1));
    }
    paramAttributeSet.recycle();
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    Drawable localDrawable = getBackground();
    if ((localDrawable != null) && (!(localDrawable instanceof ColorDrawable))) {
      return;
    }
    f localF = new f();
    int i;
    if (localDrawable != null) {
      i = ((ColorDrawable)localDrawable).getColor();
    } else {
      i = 0;
    }
    localF.setColor(ColorStateList.valueOf(i));
    localF.d(paramContext);
    localF.add(ViewCompat.getElevation(this));
    ViewCompat.setBackgroundDrawable(this, localF);
  }
  
  private Drawable tintDrawable(Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      localDrawable = paramDrawable;
      if (mAccentColor != null)
      {
        localDrawable = DrawableCompat.getDrawable(paramDrawable);
        DrawableCompat.setTint(localDrawable, mAccentColor.intValue());
      }
    }
    return localDrawable;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ByteVector.a(this);
  }
  
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    ByteVector.a(this, paramFloat);
  }
  
  public void setNavigationIcon(Drawable paramDrawable)
  {
    super.setNavigationIcon(tintDrawable(paramDrawable));
  }
  
  public void setNavigationIconTint(int paramInt)
  {
    mAccentColor = Integer.valueOf(paramInt);
    Drawable localDrawable = getNavigationIcon();
    if (localDrawable != null) {
      setNavigationIcon(localDrawable);
    }
  }
}
