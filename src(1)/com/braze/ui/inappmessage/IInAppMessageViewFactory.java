package com.braze.ui.inappmessage;

import android.app.Activity;
import android.view.View;
import com.braze.models.inappmessage.IInAppMessage;

public abstract interface IInAppMessageViewFactory
{
  public abstract View createInAppMessageView(Activity paramActivity, IInAppMessage paramIInAppMessage);
}
