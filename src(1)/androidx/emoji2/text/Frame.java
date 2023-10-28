package androidx.emoji2.text;

import java.util.stream.IntStream;

class Frame
{
  static IntStream b(CharSequence paramCharSequence)
  {
    return paramCharSequence.chars();
  }
  
  static IntStream d(CharSequence paramCharSequence)
  {
    return paramCharSequence.codePoints();
  }
}
