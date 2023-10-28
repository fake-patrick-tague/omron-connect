package com.google.android.material.internal;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import v7.v7.package_13.ViewCompat;

final class __View_OnAttachStateChangeListener
  implements View.OnAttachStateChangeListener
{
  __View_OnAttachStateChangeListener() {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    paramView.removeOnAttachStateChangeListener(this);
    ViewCompat.requestApplyInsets(paramView);
  }
  
  public void onViewDetachedFromWindow(View paramView) {}
}
