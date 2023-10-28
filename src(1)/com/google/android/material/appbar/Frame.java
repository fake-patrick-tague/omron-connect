package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.internal.Label;
import org.org.org.ui.ClassWriter;
import org.org.org.ui.R.layout;

class Frame
{
  private static final int[] a = { 16843848 };
  
  static void a(View paramView, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    Context localContext = paramView.getContext();
    paramAttributeSet = Label.obtainStyledAttributes(localContext, paramAttributeSet, a, paramInt1, paramInt2, new int[0]);
    try
    {
      boolean bool = paramAttributeSet.hasValue(0);
      if (bool) {
        paramView.setStateListAnimator(AnimatorInflater.loadStateListAnimator(localContext, paramAttributeSet.getResourceId(0, 0)));
      }
      paramAttributeSet.recycle();
      return;
    }
    catch (Throwable paramView)
    {
      paramAttributeSet.recycle();
      throw paramView;
    }
  }
  
  static void init(View paramView, float paramFloat)
  {
    int i = paramView.getResources().getInteger(R.layout.x);
    StateListAnimator localStateListAnimator = new StateListAnimator();
    int j = ClassWriter.t;
    int k = -ClassWriter.N;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "elevation", new float[] { 0.0F });
    long l = i;
    localObjectAnimator = localObjectAnimator.setDuration(l);
    localStateListAnimator.addState(new int[] { 16842766, j, k }, localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(paramView, "elevation", new float[] { paramFloat }).setDuration(l);
    localStateListAnimator.addState(new int[] { 16842766 }, localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(paramView, "elevation", new float[] { 0.0F }).setDuration(0L);
    localStateListAnimator.addState(new int[0], localObjectAnimator);
    paramView.setStateListAnimator(localStateListAnimator);
  }
  
  static void setBoundsViewOutlineProvider(View paramView)
  {
    paramView.setOutlineProvider(ViewOutlineProvider.BOUNDS);
  }
}
