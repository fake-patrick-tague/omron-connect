package androidx.fragment.package_11;

import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import v7.app.b;

class g
{
  private static int a(Context paramContext, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(16973825, new int[] { paramInt });
    paramInt = paramContext.getResourceId(0, -1);
    paramContext.recycle();
    return paramInt;
  }
  
  private static int b(Context paramContext, int paramInt, boolean paramBoolean)
  {
    if (paramInt != 4097)
    {
      if (paramInt != 8194)
      {
        if (paramInt != 8197)
        {
          if (paramInt != 4099)
          {
            if (paramInt != 4100) {
              return -1;
            }
            if (paramBoolean) {
              return a(paramContext, 16842936);
            }
            return a(paramContext, 16842937);
          }
          if (paramBoolean) {
            return b.b;
          }
          return b.d;
        }
        if (paramBoolean) {
          return a(paramContext, 16842938);
        }
        return a(paramContext, 16842939);
      }
      if (paramBoolean) {
        return b.e;
      }
      return b.c;
    }
    if (paramBoolean) {
      return b.j;
    }
    return b.g;
  }
  
  private static int getSettings(Fragment paramFragment, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      if (paramBoolean1) {
        return paramFragment.getPopEnterAnim();
      }
      return paramFragment.getPopExitAnim();
    }
    if (paramBoolean1) {
      return paramFragment.getEnterAnim();
    }
    return paramFragment.getExitAnim();
  }
  
  static c show(Context paramContext, Fragment paramFragment, boolean paramBoolean1, boolean paramBoolean2)
  {
    int n = paramFragment.getNextTransition();
    int m = getSettings(paramFragment, paramBoolean1, paramBoolean2);
    int j = m;
    int k = 0;
    paramFragment.setAnimations(0, 0, 0, 0);
    Object localObject = mContainer;
    if (localObject != null)
    {
      i = v7.app.Fragment.mContainerId;
      if (((View)localObject).getTag(i) != null) {
        mContainer.setTag(i, null);
      }
    }
    localObject = mContainer;
    if ((localObject != null) && (((ViewGroup)localObject).getLayoutTransition() != null)) {
      return null;
    }
    localObject = paramFragment.onCreateAnimation(n, paramBoolean1, m);
    if (localObject != null) {
      return new c((Animation)localObject);
    }
    paramFragment = paramFragment.onCreateAnimator(n, paramBoolean1, m);
    if (paramFragment != null) {
      return new c(paramFragment);
    }
    int i = j;
    if (m == 0)
    {
      i = j;
      if (n != 0) {
        i = b(paramContext, n, paramBoolean1);
      }
    }
    if (i != 0)
    {
      paramBoolean1 = "anim".equals(paramContext.getResources().getResourceTypeName(i));
      j = k;
      if (paramBoolean1) {}
      try
      {
        try
        {
          paramFragment = AnimationUtils.loadAnimation(paramContext, i);
          if (paramFragment != null)
          {
            paramFragment = new c(paramFragment);
            return paramFragment;
          }
          j = 1;
        }
        catch (Resources.NotFoundException paramContext)
        {
          throw paramContext;
        }
      }
      catch (RuntimeException paramFragment)
      {
        for (;;)
        {
          j = k;
        }
      }
      if (j == 0) {
        try
        {
          paramFragment = AnimatorInflater.loadAnimator(paramContext, i);
          if (paramFragment != null)
          {
            paramFragment = new c(paramFragment);
            return paramFragment;
          }
        }
        catch (RuntimeException paramFragment)
        {
          if (!paramBoolean1)
          {
            paramContext = AnimationUtils.loadAnimation(paramContext, i);
            if (paramContext != null) {
              return new c(paramContext);
            }
          }
          else
          {
            throw paramFragment;
          }
        }
      }
    }
    return null;
  }
}
