package com.google.android.material.floatingactionbutton;

class ScrollerCompat
  extends ViewPropertyAnimatorPreHC.AnimatorEventListener
{
  ScrollerCompat(FloatingActionButtonImpl paramFloatingActionButtonImpl)
  {
    super(paramFloatingActionButtonImpl, null);
  }
  
  protected float getElevation()
  {
    return 0.0F;
  }
}
