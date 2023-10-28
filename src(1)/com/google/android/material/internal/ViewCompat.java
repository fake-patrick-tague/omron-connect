package com.google.android.material.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;

public class ViewCompat
{
  public static void a(View paramView, c paramC)
  {
    v7.v7.package_13.ViewCompat.b(paramView, new l(paramC, new i(v7.v7.package_13.ViewCompat.add(paramView), paramView.getPaddingTop(), v7.v7.package_13.ViewCompat.format(paramView), paramView.getPaddingBottom())));
    b(paramView);
  }
  
  public static boolean a(View paramView)
  {
    return v7.v7.package_13.ViewCompat.getLayoutDirection(paramView) == 1;
  }
  
  public static void b(View paramView)
  {
    if (v7.v7.package_13.ViewCompat.d(paramView))
    {
      v7.v7.package_13.ViewCompat.requestApplyInsets(paramView);
      return;
    }
    paramView.addOnAttachStateChangeListener(new __View_OnAttachStateChangeListener());
  }
  
  public static float dpToPx(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources();
    return TypedValue.applyDimension(1, paramInt, paramContext.getDisplayMetrics());
  }
  
  public static float getElevation(View paramView)
  {
    paramView = paramView.getParent();
    float f = 0.0F;
    while ((paramView instanceof View))
    {
      f += v7.v7.package_13.ViewCompat.getElevation((View)paramView);
      paramView = paramView.getParent();
    }
    return f;
  }
  
  public static PorterDuff.Mode parseTintMode(int paramInt, PorterDuff.Mode paramMode)
  {
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt != 9)
        {
          switch (paramInt)
          {
          default: 
            return paramMode;
          case 16: 
            return PorterDuff.Mode.ADD;
          case 15: 
            return PorterDuff.Mode.SCREEN;
          }
          return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_ATOP;
      }
      return PorterDuff.Mode.SRC_IN;
    }
    return PorterDuff.Mode.SRC_OVER;
  }
}
