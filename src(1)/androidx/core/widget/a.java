package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.widget.CheckedTextView;

class a
{
  static void setChecked(CheckedTextView paramCheckedTextView, ColorStateList paramColorStateList)
  {
    paramCheckedTextView.setCheckMarkTintList(paramColorStateList);
  }
  
  static void setChecked(CheckedTextView paramCheckedTextView, PorterDuff.Mode paramMode)
  {
    paramCheckedTextView.setCheckMarkTintMode(paramMode);
  }
}
