package androidx.appcompat.app;

import android.view.View;
import v7.v7.package_13.Channel;

class NativeWith
  implements Channel
{
  NativeWith(WindowDecorActionBar paramWindowDecorActionBar) {}
  
  public void init(View paramView)
  {
    ((View)mContextView.mContainerView.getParent()).invalidate();
  }
}
