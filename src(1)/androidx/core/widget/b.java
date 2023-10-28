package androidx.core.widget;

import android.icu.text.DecimalFormatSymbols;
import android.text.PrecomputedText.Params;
import android.widget.TextView;

class b
{
  static void d(TextView paramTextView, int paramInt)
  {
    paramTextView.setFirstBaselineToTopHeight(paramInt);
  }
  
  static PrecomputedText.Params e(TextView paramTextView)
  {
    return paramTextView.getTextMetricsParams();
  }
  
  static String[] toString(DecimalFormatSymbols paramDecimalFormatSymbols)
  {
    return paramDecimalFormatSymbols.getDigitStrings();
  }
}
