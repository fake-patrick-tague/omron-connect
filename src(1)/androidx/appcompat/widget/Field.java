package androidx.appcompat.widget;

import android.os.LocaleList;
import android.widget.TextView;

class Field
{
  static LocaleList getMessage(String paramString)
  {
    return LocaleList.forLanguageTags(paramString);
  }
  
  static void setProperty(TextView paramTextView, LocaleList paramLocaleList)
  {
    paramTextView.setTextLocales(paramLocaleList);
  }
}
