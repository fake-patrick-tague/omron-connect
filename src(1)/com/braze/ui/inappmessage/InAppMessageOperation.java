package com.braze.ui.inappmessage;

import androidx.annotation.Keep;
import java.util.Locale;
import kotlin.x.d.i;

public enum InAppMessageOperation
{
  public static final Companion Companion = new Companion(null);
  
  static
  {
    DISPLAY_LATER = new InAppMessageOperation("DISPLAY_LATER", 1);
    DISCARD = new InAppMessageOperation("DISCARD", 2);
  }
  
  @Keep
  public static final class Companion
  {
    private Companion() {}
    
    public final InAppMessageOperation fromValue(String paramString)
    {
      InAppMessageOperation[] arrayOfInAppMessageOperation = InAppMessageOperation.values();
      int j = arrayOfInAppMessageOperation.length;
      int i = 0;
      Object localObject;
      InAppMessageOperation localInAppMessageOperation;
      String str2;
      do
      {
        localObject = null;
        if (i >= j) {
          break;
        }
        localInAppMessageOperation = arrayOfInAppMessageOperation[i];
        i += 1;
        str2 = localInAppMessageOperation.name();
        if (paramString != null)
        {
          localObject = Locale.US;
          i.d(localObject, "US");
          String str1 = paramString.toUpperCase((Locale)localObject);
          localObject = str1;
          i.d(str1, "this as java.lang.String).toUpperCase(locale)");
        }
      } while (!i.a(str2, localObject));
      return localInAppMessageOperation;
      return null;
    }
  }
}
