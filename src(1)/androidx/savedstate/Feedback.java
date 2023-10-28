package androidx.savedstate;

import android.view.View;
import kotlin.x.d.i;

public final class Feedback
{
  public static final void set(View paramView, Label paramLabel)
  {
    i.e(paramView, "<this>");
    paramView.setTag(Frame.NULL, paramLabel);
  }
}
