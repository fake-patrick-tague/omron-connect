package androidx.appcompat.widget;

import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.TextView;

final class Type
{
  static StaticLayout a(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt, TextView paramTextView, TextPaint paramTextPaint)
  {
    return new StaticLayout(paramCharSequence, paramTextPaint, paramInt, paramAlignment, paramTextView.getLineSpacingMultiplier(), paramTextView.getLineSpacingExtra(), paramTextView.getIncludeFontPadding());
  }
  
  static int create(TextView paramTextView)
  {
    return paramTextView.getMaxLines();
  }
}
