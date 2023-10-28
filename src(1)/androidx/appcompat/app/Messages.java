package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import java.util.Locale;

class Messages
{
  static void create(Configuration paramConfiguration, Locale paramLocale)
  {
    paramConfiguration.setLayoutDirection(paramLocale);
  }
  
  static Context f(Context paramContext, Configuration paramConfiguration)
  {
    return paramContext.createConfigurationContext(paramConfiguration);
  }
  
  static void onCreate(Configuration paramConfiguration1, Configuration paramConfiguration2, Configuration paramConfiguration3)
  {
    int i = densityDpi;
    int j = densityDpi;
    if (i != j) {
      densityDpi = j;
    }
  }
  
  static void setLocale(Configuration paramConfiguration, Locale paramLocale)
  {
    paramConfiguration.setLocale(paramLocale);
  }
}
