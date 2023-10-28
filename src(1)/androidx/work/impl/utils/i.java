package androidx.work.impl.utils;

import androidx.work.LayoutManager;
import androidx.work.ListenableWorker;
import androidx.work.Log;
import androidx.work.impl.asm.h;
import androidx.work.impl.utils.asm.f;
import androidx.work.impl.utils.futures.AbstractFuture;
import androidx.work.impl.utils.futures.b;
import java.util.concurrent.Executor;

public class i
  implements Runnable
{
  static final String b = Log.getInstance("WorkForegroundRunnable");
  final ListenableWorker a;
  final b<Void> c = androidx.work.impl.utils.futures.Context.getInstance();
  final LayoutManager h;
  final f j;
  final android.content.Context r;
  final h x;
  
  public i(android.content.Context paramContext, h paramH, ListenableWorker paramListenableWorker, LayoutManager paramLayoutManager, f paramF)
  {
    r = paramContext;
    x = paramH;
    a = paramListenableWorker;
    h = paramLayoutManager;
    j = paramF;
  }
  
  public com.google.common.util.concurrent.Object p()
  {
    return c;
  }
  
  public void run()
  {
    if ((x.h) && (!v7.v7.menu.Context.getType()))
    {
      androidx.work.impl.utils.futures.Context localContext = androidx.work.impl.utils.futures.Context.getInstance();
      j.get().execute(new SplashScreen.5.1(this, localContext));
      localContext.addListener(new NumberPicker.BeginSoftInputOnLongPressCommand(this, localContext), j.get());
      return;
    }
    c.get(null);
  }
}
