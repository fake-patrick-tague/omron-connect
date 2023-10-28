package androidx.fragment.package_11;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import v7.v7.menu.e;

class ClassWriter
  implements e
{
  ClassWriter(k paramK, View paramView, ViewGroup paramViewGroup, XYPlot paramXYPlot, SpecialEffectsController.Operation paramOperation) {}
  
  public void a()
  {
    r.clearAnimation();
    s.endViewTransition(r);
    a.e();
    if (FragmentManager.get(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Animation from operation ");
      localStringBuilder.append(i);
      localStringBuilder.append(" has been cancelled.");
      Log.v("FragmentManager", localStringBuilder.toString());
    }
  }
}
