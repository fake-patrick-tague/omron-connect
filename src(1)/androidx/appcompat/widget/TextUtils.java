package androidx.appcompat.widget;

import android.os.Build.VERSION;
import android.view.View;

public class TextUtils
{
  public static void setText(View paramView, CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      p0.a.showText(paramView, paramCharSequence);
      return;
    }
    ExpandableListView.init(paramView, paramCharSequence);
  }
}
