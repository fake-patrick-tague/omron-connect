package androidx.appcompat.app;

import android.view.View;
import v7.v7.package_13.MethodVisitor;
import v7.v7.package_13.ViewCompat;
import v7.v7.package_13.f;

class x
  implements MethodVisitor
{
  x(AppCompatDelegateImplV7 paramAppCompatDelegateImplV7) {}
  
  public f a(View paramView, f paramF)
  {
    int i = paramF.getSystemWindowInsetTop();
    int j = a.access$300(paramF, null);
    f localF = paramF;
    if (i != j) {
      localF = paramF.add(paramF.getHeight(), j, paramF.getWidth(), paramF.size());
    }
    return ViewCompat.a(paramView, localF);
  }
}
