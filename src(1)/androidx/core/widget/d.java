package androidx.core.widget;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

class d
{
  static int a(View paramView)
  {
    return paramView.getLayoutDirection();
  }
  
  static Drawable[] a(TextView paramTextView)
  {
    return paramTextView.getCompoundDrawablesRelative();
  }
  
  static int c(View paramView)
  {
    return paramView.getTextDirection();
  }
  
  static void c(View paramView, int paramInt)
  {
    paramView.setTextDirection(paramInt);
  }
  
  static Locale d(TextView paramTextView)
  {
    return paramTextView.getTextLocale();
  }
  
  static void setCompoundDrawablesRelative(TextView paramTextView, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    paramTextView.setCompoundDrawablesRelative(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView paramTextView, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    paramTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
}
