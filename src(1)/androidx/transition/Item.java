package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;

class Item
{
  private static final a a;
  static final android.util.Property<View, Rect> b = new NativeUint8Array(Rect.class, "clipBounds");
  static final android.util.Property<View, Float> c;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 29) {
      a = new FlurryAdSize();
    } else if (i >= 23) {
      a = new b();
    } else if (i >= 22) {
      a = new Plot();
    } else if (i >= 21) {
      a = new PagerSlidingTabStrip();
    } else if (i >= 19) {
      a = new Frame();
    } else {
      a = new a();
    }
    c = new Property(Float.class, "translationAlpha");
  }
  
  static c a(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return new d(paramView);
    }
    return e.a(paramView);
  }
  
  static void a(View paramView, Matrix paramMatrix)
  {
    a.draw(paramView, paramMatrix);
  }
  
  static void b(View paramView)
  {
    a.b(paramView);
  }
  
  static float d(View paramView)
  {
    return a.a(paramView);
  }
  
  static Node next(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return new Tag(paramView);
    }
    return new Attribute(paramView.getWindowToken());
  }
  
  static void set(View paramView)
  {
    a.set(paramView);
  }
  
  static void set(View paramView, float paramFloat)
  {
    a.a(paramView, paramFloat);
  }
  
  static void set(View paramView, int paramInt)
  {
    a.a(paramView, paramInt);
  }
  
  static void set(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  static void set(View paramView, Matrix paramMatrix)
  {
    a.a(paramView, paramMatrix);
  }
}
