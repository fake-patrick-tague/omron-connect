package androidx.activity;

import android.view.View;
import kotlin.x.d.i;

public final class k
{
  public static final void a(View paramView, Point paramPoint)
  {
    i.e(paramView, "<this>");
    i.e(paramPoint, "onBackPressedDispatcherOwner");
    paramView.setTag(Type.NULL, paramPoint);
  }
}
