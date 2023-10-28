package androidx.appcompat.app;

import android.view.View;

abstract interface WindowCallback
{
  public abstract View onCreatePanelView(int paramInt);
  
  public abstract boolean onPreparePanel(int paramInt);
}
