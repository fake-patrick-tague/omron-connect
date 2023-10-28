package androidx.appcompat.widget;

import android.app.Activity;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import v7.v7.package_13.Type;
import v7.v7.package_13.ViewCompat;

final class ClassReader
{
  static boolean a(DragEvent paramDragEvent, TextView paramTextView, Activity paramActivity)
  {
    paramActivity.requestDragAndDropPermissions(paramDragEvent);
    int i = paramTextView.getOffsetForPosition(paramDragEvent.getX(), paramDragEvent.getY());
    paramTextView.beginBatchEdit();
    try
    {
      Selection.setSelection((Spannable)paramTextView.getText(), i);
      ViewCompat.a(paramTextView, new Type(paramDragEvent.getClipData(), 3).a());
      paramTextView.endBatchEdit();
      return true;
    }
    catch (Throwable paramDragEvent)
    {
      paramTextView.endBatchEdit();
      throw paramDragEvent;
    }
  }
  
  static boolean b(DragEvent paramDragEvent, View paramView, Activity paramActivity)
  {
    paramActivity.requestDragAndDropPermissions(paramDragEvent);
    ViewCompat.a(paramView, new Type(paramDragEvent.getClipData(), 3).a());
    return true;
  }
}
