package androidx.appcompat.widget;

import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.widget.TextView;

class LimitedQueue
  extends LinkedList
{
  LimitedQueue() {}
  
  void add(StaticLayout.Builder paramBuilder, TextView paramTextView)
  {
    paramBuilder.setTextDirection((TextDirectionHeuristic)f.add(paramTextView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
  }
}
