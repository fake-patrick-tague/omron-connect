package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.widget.TextView;

class h
{
  static int b(TextView paramTextView)
  {
    return paramTextView.getBreakStrategy();
  }
  
  static void d(TextView paramTextView, int paramInt)
  {
    paramTextView.setBreakStrategy(paramInt);
  }
  
  static int f(TextView paramTextView)
  {
    return paramTextView.getHyphenationFrequency();
  }
  
  static ColorStateList getTextColor(TextView paramTextView)
  {
    return paramTextView.getCompoundDrawableTintList();
  }
  
  static void setChecked(TextView paramTextView, int paramInt)
  {
    paramTextView.setHyphenationFrequency(paramInt);
  }
  
  static void setColor(TextView paramTextView, ColorStateList paramColorStateList)
  {
    paramTextView.setCompoundDrawableTintList(paramColorStateList);
  }
  
  static PorterDuff.Mode setEnabled(TextView paramTextView)
  {
    return paramTextView.getCompoundDrawableTintMode();
  }
  
  static void setEnabled(TextView paramTextView, PorterDuff.Mode paramMode)
  {
    paramTextView.setCompoundDrawableTintMode(paramMode);
  }
}
