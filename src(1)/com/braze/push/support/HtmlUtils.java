package com.braze.push.support;

import android.os.Build.VERSION;
import android.text.Html;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.support.BrazeLogger;
import kotlin.text.g;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;

public final class HtmlUtils
{
  private static final String PLAYING = BrazeLogger.INSTANCE.getBrazeLogTag("HtmlUtils");
  
  public static final CharSequence getHtmlSpannedTextIfEnabled(String paramString, BrazeConfigurationProvider paramBrazeConfigurationProvider)
  {
    i.e(paramString, "<this>");
    i.e(paramBrazeConfigurationProvider, "configurationProvider");
    if (g.o(paramString))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, PLAYING, null, null, getHtmlSpannedTextIfEnabled.1.INSTANCE, 6, null);
      return paramString;
    }
    if (paramBrazeConfigurationProvider.isPushNotificationHtmlRenderingEnabled())
    {
      if (Build.VERSION.SDK_INT >= 24) {
        paramString = Html.fromHtml(paramString, 0);
      } else {
        paramString = Html.fromHtml(paramString);
      }
      i.d(paramString, "{\n        if (Build.VERS?tml(this)\n        }\n    }");
      return paramString;
    }
    return paramString;
  }
}
