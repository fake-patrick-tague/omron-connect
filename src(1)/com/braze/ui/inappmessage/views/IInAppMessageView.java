package com.braze.ui.inappmessage.views;

import android.view.View;
import v7.v7.package_13.f;

public abstract interface IInAppMessageView
{
  public abstract void applyWindowInsets(f paramF);
  
  public abstract boolean getHasAppliedWindowInsets();
  
  public abstract View getMessageClickableView();
}
