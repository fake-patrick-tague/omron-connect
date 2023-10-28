package androidx.fragment.package_11;

import android.animation.Animator;
import android.util.Log;
import v7.v7.menu.e;

class l
  implements e
{
  l(k paramK, Animator paramAnimator, SpecialEffectsController.Operation paramOperation) {}
  
  public void a()
  {
    a.end();
    if (FragmentManager.get(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Animator from operation ");
      localStringBuilder.append(i);
      localStringBuilder.append(" has been canceled.");
      Log.v("FragmentManager", localStringBuilder.toString());
    }
  }
}
