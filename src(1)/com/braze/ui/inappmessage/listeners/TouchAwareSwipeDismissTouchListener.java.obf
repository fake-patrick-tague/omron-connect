package com.braze.ui.inappmessage.listeners;

import android.view.MotionEvent;
import android.view.View;
import kotlin.x.d.i;

public final class TouchAwareSwipeDismissTouchListener
  extends SwipeDismissTouchListener
{
  private ITouchListener touchListener;
  
  public TouchAwareSwipeDismissTouchListener(View paramView, SwipeDismissTouchListener.DismissCallbacks paramDismissCallbacks)
  {
    this(paramView, null, paramDismissCallbacks);
  }
  
  public TouchAwareSwipeDismissTouchListener(View paramView, Object paramObject, SwipeDismissTouchListener.DismissCallbacks paramDismissCallbacks)
  {
    super(paramView, paramObject, paramDismissCallbacks);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    i.e(paramView, "view");
    i.e(paramMotionEvent, "motionEvent");
    int i = paramMotionEvent.getAction();
    ITouchListener localITouchListener;
    if (i != 0)
    {
      if ((i == 1) || (i == 3))
      {
        localITouchListener = touchListener;
        if (localITouchListener != null) {
          localITouchListener.onTouchEnded();
        }
      }
    }
    else
    {
      localITouchListener = touchListener;
      if (localITouchListener != null) {
        localITouchListener.onTouchStartedOrContinued();
      }
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public final void setTouchListener(ITouchListener paramITouchListener)
  {
    i.e(paramITouchListener, "newTouchListener");
    touchListener = paramITouchListener;
  }
  
  public static abstract interface ITouchListener
  {
    public abstract void onTouchEnded();
    
    public abstract void onTouchStartedOrContinued();
  }
}
