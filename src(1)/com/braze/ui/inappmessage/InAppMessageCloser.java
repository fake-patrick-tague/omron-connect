package com.braze.ui.inappmessage;

import com.braze.models.inappmessage.IInAppMessage;

@Deprecated
public class InAppMessageCloser
{
  private final IInAppMessageViewWrapper mInAppMessageViewWrapper;
  
  public InAppMessageCloser(IInAppMessageViewWrapper paramIInAppMessageViewWrapper)
  {
    mInAppMessageViewWrapper = paramIInAppMessageViewWrapper;
  }
  
  public void close(boolean paramBoolean)
  {
    mInAppMessageViewWrapper.getInAppMessage().setAnimateOut(paramBoolean);
    mInAppMessageViewWrapper.close();
  }
}
