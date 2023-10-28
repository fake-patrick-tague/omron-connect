package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import v7.v7.package_13.Type;
import v7.v7.package_13.ViewCompat;

final class SignatureReader
{
  static Activity a(View paramView)
  {
    for (paramView = paramView.getContext(); (paramView instanceof ContextWrapper); paramView = ((ContextWrapper)paramView).getBaseContext()) {
      if ((paramView instanceof Activity)) {
        return (Activity)paramView;
      }
    }
    return null;
  }
  
  static boolean a(View paramView, DragEvent paramDragEvent)
  {
    int i = Build.VERSION.SDK_INT;
    if ((i < 31) && (i >= 24) && (paramDragEvent.getLocalState() == null))
    {
      if (ViewCompat.create(paramView) == null) {
        return false;
      }
      Activity localActivity = a(paramView);
      if (localActivity == null)
      {
        paramDragEvent = new StringBuilder();
        paramDragEvent.append("Can't handle drop: no activity: view=");
        paramDragEvent.append(paramView);
        Log.i("ReceiveContent", paramDragEvent.toString());
        return false;
      }
      if (paramDragEvent.getAction() == 1) {
        return paramView instanceof TextView ^ true;
      }
      if (paramDragEvent.getAction() == 3)
      {
        if ((paramView instanceof TextView)) {
          return ClassReader.a(paramDragEvent, (TextView)paramView, localActivity);
        }
        return ClassReader.b(paramDragEvent, paramView, localActivity);
      }
    }
    return false;
  }
  
  static boolean a(TextView paramTextView, int paramInt)
  {
    int j = Build.VERSION.SDK_INT;
    int i = 0;
    if ((j < 31) && (ViewCompat.create(paramTextView) != null))
    {
      if ((paramInt != 16908322) && (paramInt != 16908337)) {
        return false;
      }
      Object localObject = (ClipboardManager)paramTextView.getContext().getSystemService("clipboard");
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((ClipboardManager)localObject).getPrimaryClip();
      }
      if ((localObject != null) && (((ClipData)localObject).getItemCount() > 0))
      {
        localObject = new Type((ClipData)localObject, 1);
        if (paramInt == 16908322) {
          paramInt = i;
        } else {
          paramInt = 1;
        }
        ViewCompat.a(paramTextView, ((Type)localObject).a(paramInt).a());
        return true;
      }
    }
    else
    {
      return false;
    }
    return true;
  }
}
