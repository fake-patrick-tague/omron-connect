package androidx.transition;

import android.view.View;
import java.util.ArrayList;

class MethodWriter
  implements Transition.f
{
  MethodWriter(FragmentTransitionCompat21 paramFragmentTransitionCompat21, View paramView, ArrayList paramArrayList) {}
  
  public void b(Transition paramTransition) {}
  
  public void c(Transition paramTransition)
  {
    paramTransition.recycle(this);
    g.setVisibility(8);
    int j = n.size();
    int i = 0;
    while (i < j)
    {
      ((View)n.get(i)).setVisibility(0);
      i += 1;
    }
  }
  
  public void d(Transition paramTransition) {}
  
  public void e(Transition paramTransition) {}
  
  public void onPreDraw(Transition paramTransition) {}
}
