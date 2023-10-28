package androidx.emoji2.text;

import android.os.Handler;
import android.os.Looper;

class DefinitionsHelper
{
  public static Handler init(Looper paramLooper)
  {
    return Handler.createAsync(paramLooper);
  }
}
