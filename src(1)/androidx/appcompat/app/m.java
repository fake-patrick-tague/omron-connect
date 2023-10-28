package androidx.appcompat.app;

import android.app.LocaleManager;
import android.os.LocaleList;

class m
{
  static void a(Object paramObject, LocaleList paramLocaleList)
  {
    ((LocaleManager)paramObject).setApplicationLocales(paramLocaleList);
  }
  
  static LocaleList d(Object paramObject)
  {
    return ((LocaleManager)paramObject).getApplicationLocales();
  }
}
