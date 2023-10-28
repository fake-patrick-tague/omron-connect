package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

class d
  implements c
{
  private final ViewOverlay w;
  
  d(View paramView)
  {
    w = paramView.getOverlay();
  }
  
  public void a(Drawable paramDrawable)
  {
    w.add(paramDrawable);
  }
  
  public void b(Drawable paramDrawable)
  {
    w.remove(paramDrawable);
  }
}
