package androidx.fragment.package_11;

import android.content.Context;

class XYPlot
  extends h
{
  private c d;
  private boolean r = false;
  private boolean w;
  
  XYPlot(SpecialEffectsController.Operation paramOperation, v7.v7.menu.h paramH, boolean paramBoolean)
  {
    super(paramOperation, paramH);
    w = paramBoolean;
  }
  
  c a(Context paramContext)
  {
    if (r) {
      return d;
    }
    Fragment localFragment = a().next();
    boolean bool;
    if (a().get() == SpecialEffectsController.Operation.State.b) {
      bool = true;
    } else {
      bool = false;
    }
    paramContext = g.show(paramContext, localFragment, bool, w);
    d = paramContext;
    r = true;
    return paramContext;
  }
}
