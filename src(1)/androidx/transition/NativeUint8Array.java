package androidx.transition;

import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import v7.v7.package_13.ViewCompat;

final class NativeUint8Array
  extends Property<View, Rect>
{
  NativeUint8Array(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Rect get(View paramView)
  {
    return ViewCompat.obtain(paramView);
  }
  
  public void init(View paramView, Rect paramRect)
  {
    ViewCompat.setElevation(paramView, paramRect);
  }
}
