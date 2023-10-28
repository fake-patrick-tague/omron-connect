package com.braze.ui.inappmessage;

import android.view.animation.Animation;
import com.braze.models.inappmessage.IInAppMessage;

public abstract interface IInAppMessageAnimationFactory
{
  public abstract Animation getClosingAnimation(IInAppMessage paramIInAppMessage);
  
  public abstract Animation getOpeningAnimation(IInAppMessage paramIInAppMessage);
}
