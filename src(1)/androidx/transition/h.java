package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.ViewOverlay;

class h
  implements MenuItem
{
  private final ViewGroupOverlay w;
  
  h(ViewGroup paramViewGroup)
  {
    w = paramViewGroup.getOverlay();
  }
  
  public void a(Drawable paramDrawable)
  {
    w.add(paramDrawable);
  }
  
  public void b(Drawable paramDrawable)
  {
    w.remove(paramDrawable);
  }
  
  public void b(View paramView)
  {
    w.add(paramView);
  }
  
  public void c(View paramView)
  {
    w.remove(paramView);
  }
}
