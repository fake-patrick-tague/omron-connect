package com.google.android.material.floatingactionbutton;

class GeoLocation
  extends ViewPropertyAnimatorPreHC.AnimatorEventListener
{
  GeoLocation(FloatingActionButtonImpl paramFloatingActionButtonImpl)
  {
    super(paramFloatingActionButtonImpl, null);
  }
  
  protected float getElevation()
  {
    FloatingActionButtonImpl localFloatingActionButtonImpl = this$0;
    return mElevation + mShadowDrawable;
  }
}
