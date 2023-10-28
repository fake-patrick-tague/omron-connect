package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.view.View;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.List;
import org.org.org.ui.Plot;
import org.org.org.ui.asm.f;
import org.org.org.ui.asm.m;
import org.org.org.ui.widget.ShadowViewDelegate;

class FloatingActionButtonEclairMr1
  extends FloatingActionButtonImpl
{
  FloatingActionButtonEclairMr1(FloatingActionButton paramFloatingActionButton, ShadowViewDelegate paramShadowViewDelegate)
  {
    super(paramFloatingActionButton, paramShadowViewDelegate);
  }
  
  private Animator show(float paramFloat1, float paramFloat2)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(ObjectAnimator.ofFloat(this$0, "elevation", new float[] { paramFloat1 }).setDuration(0L)).with(ObjectAnimator.ofFloat(this$0, View.TRANSLATION_Z, new float[] { paramFloat2 }).setDuration(100L));
    localAnimatorSet.setInterpolator(FloatingActionButtonImpl.handler);
    return localAnimatorSet;
  }
  
  CircularBorderDrawable a(int paramInt, ColorStateList paramColorStateList)
  {
    Context localContext = this$0.getContext();
    CircularBorderDrawable localCircularBorderDrawable = new CircularBorderDrawable((m)v7.v7.util.Log.valueOf(x));
    localCircularBorderDrawable.setGradientColors(ContextCompat.getColor(localContext, Plot.n), ContextCompat.getColor(localContext, Plot.o), ContextCompat.getColor(localContext, Plot.f), ContextCompat.getColor(localContext, Plot.d));
    localCircularBorderDrawable.setBorderWidth(paramInt);
    localCircularBorderDrawable.setBorderTint(paramColorStateList);
    return localCircularBorderDrawable;
  }
  
  f a()
  {
    return new e((m)v7.v7.util.Log.valueOf(x));
  }
  
  void draw() {}
  
  public float getElevation()
  {
    return this$0.getElevation();
  }
  
  void jumpDrawableToCurrentState() {}
  
  void onCompatShadowChanged()
  {
    updatePadding();
  }
  
  void onPostExecute(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    int i = Build.VERSION.SDK_INT;
    if (i == 21)
    {
      this$0.refreshDrawableState();
    }
    else
    {
      StateListAnimator localStateListAnimator = new StateListAnimator();
      localStateListAnimator.addState(FloatingActionButtonImpl.params, show(paramFloat1, paramFloat3));
      localStateListAnimator.addState(FloatingActionButtonImpl.f, show(paramFloat1, paramFloat2));
      localStateListAnimator.addState(FloatingActionButtonImpl.e, show(paramFloat1, paramFloat2));
      localStateListAnimator.addState(FloatingActionButtonImpl.c, show(paramFloat1, paramFloat2));
      AnimatorSet localAnimatorSet = new AnimatorSet();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(ObjectAnimator.ofFloat(this$0, "elevation", new float[] { paramFloat1 }).setDuration(0L));
      if ((i >= 22) && (i <= 24))
      {
        FloatingActionButton localFloatingActionButton = this$0;
        localArrayList.add(ObjectAnimator.ofFloat(localFloatingActionButton, View.TRANSLATION_Z, new float[] { localFloatingActionButton.getTranslationZ() }).setDuration(100L));
      }
      localArrayList.add(ObjectAnimator.ofFloat(this$0, View.TRANSLATION_Z, new float[] { 0.0F }).setDuration(100L));
      localAnimatorSet.playSequentially((Animator[])localArrayList.toArray(new Animator[0]));
      localAnimatorSet.setInterpolator(FloatingActionButtonImpl.handler);
      localStateListAnimator.addState(FloatingActionButtonImpl.b, localAnimatorSet);
      localStateListAnimator.addState(FloatingActionButtonImpl.base, show(0.0F, 0.0F));
      this$0.setStateListAnimator(localStateListAnimator);
    }
    if (setBackgroundDrawable()) {
      updatePadding();
    }
  }
  
  boolean requirePreDrawListener()
  {
    return false;
  }
  
  void setBackgroundDrawable(ColorStateList paramColorStateList1, PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a7 = a6\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  boolean setBackgroundDrawable()
  {
    return (mShadowViewDelegate.setBackgroundDrawable()) || (!load());
  }
  
  void setRippleColor(ColorStateList paramColorStateList)
  {
    Drawable localDrawable = j;
    if ((localDrawable instanceof RippleDrawable))
    {
      ((RippleDrawable)localDrawable).setColor(org.org.org.ui.compound.Log.getColor(paramColorStateList));
      return;
    }
    super.setRippleColor(paramColorStateList);
  }
  
  void show(Rect paramRect)
  {
    if (mShadowViewDelegate.setBackgroundDrawable())
    {
      super.show(paramRect);
      return;
    }
    if (!load())
    {
      int i = (left - this$0.getSizeDimension()) / 2;
      paramRect.set(i, i, i, i);
      return;
    }
    paramRect.set(0, 0, 0, 0);
  }
  
  void show(int[] paramArrayOfInt)
  {
    if (Build.VERSION.SDK_INT == 21)
    {
      if (this$0.isEnabled())
      {
        this$0.setElevation(mElevation);
        if (this$0.isPressed())
        {
          this$0.setTranslationZ(mShadowDrawable);
          return;
        }
        if ((!this$0.isFocused()) && (!this$0.isHovered()))
        {
          this$0.setTranslationZ(0.0F);
          return;
        }
        this$0.setTranslationZ(mPressedTranslationZ);
        return;
      }
      this$0.setElevation(0.0F);
      this$0.setTranslationZ(0.0F);
    }
  }
}
