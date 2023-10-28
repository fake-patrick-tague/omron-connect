package com.google.android.gms.common;

final class OwnCloudVersion
{
  static int compare(int paramInt)
  {
    int i = 0;
    while (i < 6)
    {
      int j = new int[] { 1, 2, 3, 4, 5, 6 }[i];
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
