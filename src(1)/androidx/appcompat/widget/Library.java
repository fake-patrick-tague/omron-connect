package androidx.appcompat.widget;

import java.util.Locale;

class Library
{
  static Locale getCountry(String paramString)
  {
    return Locale.forLanguageTag(paramString);
  }
}
