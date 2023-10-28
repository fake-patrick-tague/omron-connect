package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.CheckedTextView;

public final class Frame
{
  public static void a(CheckedTextView paramCheckedTextView, ColorStateList paramColorStateList)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      a.setChecked(paramCheckedTextView, paramColorStateList);
      return;
    }
    if ((paramCheckedTextView instanceof c)) {
      ((c)paramCheckedTextView).setSupportCheckMarkTintList(paramColorStateList);
    }
  }
  
  public static void a(CheckedTextView paramCheckedTextView, PorterDuff.Mode paramMode)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      a.setChecked(paramCheckedTextView, paramMode);
      return;
    }
    if ((paramCheckedTextView instanceof c)) {
      ((c)paramCheckedTextView).setSupportCheckMarkTintMode(paramMode);
    }
  }
  
  public static Drawable get(CheckedTextView paramCheckedTextView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return UnboundedFifoByteBuffer.get(paramCheckedTextView);
    }
    return CompoundButtonCompatDonut.getButtonDrawable(paramCheckedTextView);
  }
}
