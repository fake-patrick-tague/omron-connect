package androidx.core.widget;

import android.content.ClipData.Item;
import android.content.Context;
import android.text.Spanned;

final class SizeMetrics
{
  static CharSequence getText(Context paramContext, ClipData.Item paramItem, int paramInt)
  {
    if ((paramInt & 0x1) != 0)
    {
      paramItem = paramItem.coerceToText(paramContext);
      paramContext = paramItem;
      if ((paramItem instanceof Spanned)) {
        return paramItem.toString();
      }
    }
    else
    {
      paramContext = paramItem.coerceToStyledText(paramContext);
    }
    return paramContext;
  }
}
