package com.google.android.material.floatingactionbutton;

class WindowDecorActionBar
  extends ViewPropertyAnimatorPreHC.AnimatorEventListener
{
  WindowDecorActionBar(FloatingActionButtonImpl paramFloatingActionButtonImpl)
  {
    super(paramFloatingActionButtonImpl, null);
  }
  
  protected float getElevation()
  {
    FloatingActionButtonImpl localFloatingActionButtonImpl = this$0;
    return mElevation + mPressedTranslationZ;
  }
}
