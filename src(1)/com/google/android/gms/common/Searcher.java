package com.google.android.gms.common;

final class Searcher
{
  static int search(int paramInt)
  {
    int i = 0;
    while (i < 3)
    {
      int j = new int[] { 1, 2, 3 }[i];
      if (j != 0)
      {
        if (j - 1 == paramInt) {
          return j;
        }
        i += 1;
      }
      else
      {
        throw new NullPointerException("Null throw statement replaced by Soot");
      }
    }
    return 1;
  }
}
