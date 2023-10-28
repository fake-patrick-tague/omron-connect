package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;

public class LayoutManager
{
  public static String a(View paramView)
  {
    try
    {
      paramView = paramView.getContext().getResources().getResourceEntryName(paramView.getId());
      return paramView;
    }
    catch (Exception paramView)
    {
      for (;;) {}
    }
    return "UNKNOWN";
  }
}
