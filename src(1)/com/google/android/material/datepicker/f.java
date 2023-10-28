package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.widget.TextView;
import org.org.org.ui.R.styleable;
import org.org.org.ui.asm.Item;
import org.org.org.ui.asm.m;
import org.org.org.ui.menu.ClassWriter;
import v7.v7.package_13.ViewCompat;
import v7.v7.util.Log;

final class f
{
  private final int b;
  private final ColorStateList c;
  private final m e;
  private final ColorStateList l;
  private final ColorStateList m;
  private final Rect r;
  
  private f(ColorStateList paramColorStateList1, ColorStateList paramColorStateList2, ColorStateList paramColorStateList3, int paramInt, m paramM, Rect paramRect)
  {
    Log.set(left);
    Log.set(top);
    Log.set(right);
    Log.set(bottom);
    r = paramRect;
    c = paramColorStateList2;
    m = paramColorStateList1;
    l = paramColorStateList3;
    b = paramInt;
    e = paramM;
  }
  
  static f a(Context paramContext, int paramInt)
  {
    boolean bool;
    if (paramInt != 0) {
      bool = true;
    } else {
      bool = false;
    }
    Log.setText(bool, "Cannot create a CalendarItemStyle with a styleResId of 0");
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramInt, R.styleable.Spinner);
    Rect localRect = new Rect(localTypedArray.getDimensionPixelOffset(R.styleable.Spinner_android_dropDownWidth, 0), localTypedArray.getDimensionPixelOffset(R.styleable.Spinner_android_popupBackground, 0), localTypedArray.getDimensionPixelOffset(R.styleable.Spinner_android_dropDownVerticalOffset, 0), localTypedArray.getDimensionPixelOffset(R.styleable.Spinner_android_dropDownHorizontalOffset, 0));
    ColorStateList localColorStateList1 = ClassWriter.getString(paramContext, localTypedArray, R.styleable.Theme_windowActionModeOverlay);
    ColorStateList localColorStateList2 = ClassWriter.getString(paramContext, localTypedArray, R.styleable.Theme_android_windowIsFloating);
    ColorStateList localColorStateList3 = ClassWriter.getString(paramContext, localTypedArray, R.styleable.DOUBLE);
    paramInt = localTypedArray.getDimensionPixelSize(R.styleable.LONG, 0);
    paramContext = m.b(paramContext, localTypedArray.getResourceId(R.styleable.BetterPickersDialogFragment_bpButtonBackground, 0), localTypedArray.getResourceId(R.styleable.FloatingActionButton_fab_hideAnimation, 0)).a();
    localTypedArray.recycle();
    return new f(localColorStateList1, localColorStateList2, localColorStateList3, paramInt, paramContext, localRect);
  }
  
  int a()
  {
    return r.bottom;
  }
  
  void a(TextView paramTextView)
  {
    Object localObject1 = new org.org.org.ui.asm.f();
    Object localObject2 = new org.org.org.ui.asm.f();
    ((org.org.org.ui.asm.f)localObject1).setShapeAppearanceModel(e);
    ((org.org.org.ui.asm.f)localObject2).setShapeAppearanceModel(e);
    ((org.org.org.ui.asm.f)localObject1).setColor(m);
    ((org.org.org.ui.asm.f)localObject1).a(b, l);
    paramTextView.setTextColor(c);
    if (Build.VERSION.SDK_INT >= 21) {
      localObject1 = new RippleDrawable(c.withAlpha(30), (Drawable)localObject1, (Drawable)localObject2);
    }
    localObject2 = r;
    ViewCompat.setBackgroundDrawable(paramTextView, new InsetDrawable((Drawable)localObject1, left, top, right, bottom));
  }
  
  int size()
  {
    return r.top;
  }
}
