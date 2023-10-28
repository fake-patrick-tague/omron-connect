package androidx.appcompat.widget;

import android.widget.TextView;

class Log
{
  static int d(TextView paramTextView)
  {
    return paramTextView.getAutoSizeStepGranularity();
  }
  
  static void set(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramTextView.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  static void setText(TextView paramTextView, int[] paramArrayOfInt, int paramInt)
  {
    paramTextView.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
  }
  
  static boolean setText(TextView paramTextView, String paramString)
  {
    return paramTextView.setFontVariationSettings(paramString);
  }
}
