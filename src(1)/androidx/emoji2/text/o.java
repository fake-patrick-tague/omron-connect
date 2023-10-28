package androidx.emoji2.text;

import android.text.PrecomputedText;
import v7.v7.text.StrBuilder;

class o
  extends e
{
  o() {}
  
  boolean b(CharSequence paramCharSequence)
  {
    return ((paramCharSequence instanceof PrecomputedText)) || ((paramCharSequence instanceof StrBuilder));
  }
}
