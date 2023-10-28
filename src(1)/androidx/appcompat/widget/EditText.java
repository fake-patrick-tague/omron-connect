package androidx.appcompat.widget;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import java.util.Locale;

class EditText
{
  static Drawable[] getCompoundDrawablesRelative(TextView paramTextView)
  {
    return paramTextView.getCompoundDrawablesRelative();
  }
  
  static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView paramTextView, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    paramTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  static void setText(TextView paramTextView, Locale paramLocale)
  {
    paramTextView.setTextLocale(paramLocale);
  }
}
