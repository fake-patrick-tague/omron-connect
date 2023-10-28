package androidx.emoji2.text;

import android.os.Build.VERSION;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class Handler
{
  static ThreadPoolExecutor create(String paramString)
  {
    paramString = new ModernAsyncTask.1(paramString);
    paramString = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), paramString);
    paramString.allowCoreThreadTimeOut(true);
    return paramString;
  }
  
  static android.os.Handler init()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return DefinitionsHelper.init(Looper.getMainLooper());
    }
    return new android.os.Handler(Looper.getMainLooper());
  }
}
