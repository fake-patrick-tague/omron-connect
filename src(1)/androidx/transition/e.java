package androidx.transition;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

class e
  implements c
{
  protected f d = new f(paramContext, paramViewGroup, paramView, this);
  
  e(Context paramContext, ViewGroup paramViewGroup, View paramView) {}
  
  static e a(View paramView)
  {
    ViewGroup localViewGroup = findSuitableParent(paramView);
    if (localViewGroup != null)
    {
      int j = localViewGroup.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = localViewGroup.getChildAt(i);
        if ((localView instanceof f)) {
          return k;
        }
        i += 1;
      }
      return new o(localViewGroup.getContext(), localViewGroup, paramView);
    }
    return null;
  }
  
  static ViewGroup findSuitableParent(View paramView)
  {
    while (paramView != null)
    {
      if ((paramView.getId() == 16908290) && ((paramView instanceof ViewGroup))) {
        return (ViewGroup)paramView;
      }
      if ((paramView.getParent() instanceof ViewGroup)) {
        paramView = (ViewGroup)paramView.getParent();
      }
    }
    return null;
  }
  
  public void a(Drawable paramDrawable)
  {
    d.a(paramDrawable);
  }
  
  public void b(Drawable paramDrawable)
  {
    d.b(paramDrawable);
  }
}
