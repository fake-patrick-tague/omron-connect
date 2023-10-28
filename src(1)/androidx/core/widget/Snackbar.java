package androidx.core.widget;

import android.content.ClipData.Item;
import android.content.Context;
import android.text.Spanned;

final class Snackbar
{
  static CharSequence getText(Context paramContext, ClipData.Item paramItem, int paramInt)
  {
    paramContext = paramItem.coerceToText(paramContext);
    if (((paramInt & 0x1) != 0) && ((paramContext instanceof Spanned))) {
      return paramContext.toString();
    }
    return paramContext;
  }
}
