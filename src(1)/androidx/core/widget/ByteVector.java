package androidx.core.widget;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Selection;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import v7.v7.package_13.Item;
import v7.v7.package_13.b;

public final class ByteVector
  implements Item
{
  public ByteVector() {}
  
  private static CharSequence a(Context paramContext, ClipData.Item paramItem, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return SizeMetrics.getText(paramContext, paramItem, paramInt);
    }
    return Snackbar.getText(paramContext, paramItem, paramInt);
  }
  
  private static void append(Editable paramEditable, CharSequence paramCharSequence)
  {
    int j = Selection.getSelectionStart(paramEditable);
    int k = Selection.getSelectionEnd(paramEditable);
    int i = Math.max(0, Math.min(j, k));
    j = Math.max(0, Math.max(j, k));
    Selection.setSelection(paramEditable, j);
    paramEditable.replace(i, j, paramCharSequence);
  }
  
  public b a(View paramView, b paramB)
  {
    if (Log.isLoggable("ReceiveContent", 3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive: ");
      ((StringBuilder)localObject).append(paramB);
      Log.d("ReceiveContent", ((StringBuilder)localObject).toString());
    }
    if (paramB.b() == 2) {
      return paramB;
    }
    Object localObject = paramB.a();
    int m = paramB.e();
    paramB = (TextView)paramView;
    paramView = (Editable)paramB.getText();
    paramB = paramB.getContext();
    int i = 0;
    int k;
    for (int j = 0; i < ((ClipData)localObject).getItemCount(); j = k)
    {
      CharSequence localCharSequence = a(paramB, ((ClipData)localObject).getItemAt(i), m);
      k = j;
      if (localCharSequence != null) {
        if (j == 0)
        {
          append(paramView, localCharSequence);
          k = 1;
        }
        else
        {
          paramView.insert(Selection.getSelectionEnd(paramView), "\n");
          paramView.insert(Selection.getSelectionEnd(paramView), localCharSequence);
          k = j;
        }
      }
      i += 1;
    }
    return null;
  }
}
