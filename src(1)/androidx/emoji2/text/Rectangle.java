package androidx.emoji2.text;

final class Rectangle
{
  static int translate(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i = paramCharSequence.length();
    if (paramInt1 >= 0)
    {
      if (i < paramInt1) {
        return -1;
      }
      i = paramInt2;
      if (paramInt2 < 0) {
        return -1;
      }
      paramInt2 = 0;
      for (;;)
      {
        if (i == 0) {
          return paramInt1;
        }
        paramInt1 -= 1;
        if (paramInt1 < 0)
        {
          if (paramInt2 != 0) {
            return -1;
          }
          return 0;
        }
        char c = paramCharSequence.charAt(paramInt1);
        if (paramInt2 != 0)
        {
          if (!Character.isHighSurrogate(c)) {
            return -1;
          }
          i -= 1;
          break;
        }
        if (!Character.isSurrogate(c))
        {
          i -= 1;
        }
        else
        {
          if (Character.isHighSurrogate(c)) {
            return -1;
          }
          paramInt2 = 1;
        }
      }
    }
    return -1;
  }
  
  static int write(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int j = paramCharSequence.length();
    if (paramInt1 >= 0)
    {
      if (j < paramInt1) {
        return -1;
      }
      int i = paramInt2;
      if (paramInt2 < 0) {
        return -1;
      }
      paramInt2 = 0;
      for (;;)
      {
        if (i == 0) {
          return paramInt1;
        }
        if (paramInt1 >= j)
        {
          if (paramInt2 != 0) {
            return -1;
          }
          return j;
        }
        char c = paramCharSequence.charAt(paramInt1);
        if (paramInt2 != 0)
        {
          if (!Character.isLowSurrogate(c)) {
            return -1;
          }
          i -= 1;
          paramInt1 += 1;
          break;
        }
        if (!Character.isSurrogate(c))
        {
          i -= 1;
          paramInt1 += 1;
        }
        else
        {
          if (Character.isLowSurrogate(c)) {
            return -1;
          }
          paramInt1 += 1;
          paramInt2 = 1;
        }
      }
    }
    return -1;
  }
}
