package androidx.core.widget;

import android.icu.text.DecimalFormatSymbols;
import java.util.Locale;

class NativeWith
{
  static DecimalFormatSymbols get(Locale paramLocale)
  {
    return DecimalFormatSymbols.getInstance(paramLocale);
  }
}
