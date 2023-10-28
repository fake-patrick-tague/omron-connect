package com.braze.ui.inappmessage.views;

import android.view.View;
import java.util.List;

public abstract interface IInAppMessageImmersiveView
  extends IInAppMessageView
{
  public abstract List getMessageButtonViews(int paramInt);
  
  public abstract View getMessageCloseButtonView();
}
