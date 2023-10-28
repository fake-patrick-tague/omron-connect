package androidx.appcompat.app;

import android.content.res.Configuration;

class SupraCommand
{
  static void register(Configuration paramConfiguration1, Configuration paramConfiguration2, Configuration paramConfiguration3)
  {
    int i = colorMode;
    int j = colorMode;
    if ((i & 0x3) != (j & 0x3)) {
      colorMode |= j & 0x3;
    }
    i = colorMode;
    j = colorMode;
    if ((i & 0xC) != (j & 0xC)) {
      colorMode |= j & 0xC;
    }
  }
}
