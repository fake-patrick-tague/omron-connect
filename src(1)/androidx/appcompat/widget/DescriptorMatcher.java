package androidx.appcompat.widget;

import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextPaint;
import android.util.Log;
import android.widget.TextView;

final class DescriptorMatcher
{
  static StaticLayout create(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt1, int paramInt2, TextView paramTextView, TextPaint paramTextPaint, LinkedList paramLinkedList)
  {
    paramCharSequence = StaticLayout.Builder.obtain(paramCharSequence, 0, paramCharSequence.length(), paramTextPaint, paramInt1);
    paramAlignment = paramCharSequence.setAlignment(paramAlignment).setLineSpacing(paramTextView.getLineSpacingExtra(), paramTextView.getLineSpacingMultiplier()).setIncludePad(paramTextView.getIncludeFontPadding()).setBreakStrategy(paramTextView.getBreakStrategy()).setHyphenationFrequency(paramTextView.getHyphenationFrequency());
    paramInt1 = paramInt2;
    if (paramInt2 == -1) {
      paramInt1 = Integer.MAX_VALUE;
    }
    paramAlignment.setMaxLines(paramInt1);
    try
    {
      paramLinkedList.add(paramCharSequence, paramTextView);
    }
    catch (ClassCastException paramAlignment)
    {
      for (;;) {}
    }
    Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
    return paramCharSequence.build();
  }
}
