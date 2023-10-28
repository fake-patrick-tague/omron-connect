package androidx.appcompat.app;

import android.content.res.Configuration;
import android.os.LocaleList;
import v7.v7.menu.Label;

class Context
{
  static Label a(Configuration paramConfiguration)
  {
    return Label.a(paramConfiguration.getLocales().toLanguageTags());
  }
  
  static void setLocale(Configuration paramConfiguration1, Configuration paramConfiguration2, Configuration paramConfiguration3)
  {
    paramConfiguration1 = paramConfiguration1.getLocales();
    LocaleList localLocaleList = paramConfiguration2.getLocales();
    if (!paramConfiguration1.equals(localLocaleList))
    {
      paramConfiguration3.setLocales(localLocaleList);
      locale = locale;
    }
  }
  
  static void setLocale(Configuration paramConfiguration, Label paramLabel)
  {
    paramConfiguration.setLocales(LocaleList.forLanguageTags(paramLabel.put()));
  }
  
  public static void visitLabel(Label paramLabel)
  {
    LocaleList.setDefault(LocaleList.forLanguageTags(paramLabel.put()));
  }
}
