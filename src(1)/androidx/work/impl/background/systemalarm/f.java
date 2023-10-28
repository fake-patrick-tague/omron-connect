package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import androidx.work.Log;
import androidx.work.impl.ClassWriter;
import androidx.work.impl.utils.Collection;
import androidx.work.impl.utils.HttpConnection;
import androidx.work.impl.utils.Settings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class f
  implements androidx.work.impl.Object
{
  static final String p = Log.getInstance("SystemAlarmDispatcher");
  final List<Intent> a;
  private final androidx.work.impl.f b;
  final b c;
  private final Handler h;
  final Context j;
  private Item k;
  private final androidx.work.impl.utils.asm.f l;
  private final ClassWriter n;
  private final Settings s;
  Intent x;
  
  f(Context paramContext)
  {
    this(paramContext, null, null);
  }
  
  f(Context paramContext, ClassWriter paramClassWriter, androidx.work.impl.f paramF)
  {
    Context localContext = paramContext.getApplicationContext();
    j = localContext;
    c = new b(localContext);
    s = new Settings();
    if (paramF == null) {
      paramF = androidx.work.impl.f.a(paramContext);
    }
    b = paramF;
    if (paramClassWriter == null) {
      paramClassWriter = paramF.get();
    }
    n = paramClassWriter;
    l = paramF.i();
    paramClassWriter.a(this);
    a = new ArrayList();
    x = null;
    h = new Handler(Looper.getMainLooper());
  }
  
  private boolean a(String paramString)
  {
    close();
    List localList = a;
    try
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext()) {
        if (paramString.equals(((Intent)localIterator.next()).getAction())) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  private void clear()
  {
    close();
    PowerManager.WakeLock localWakeLock = Collection.add(j, "ProcessCommand");
    try
    {
      localWakeLock.acquire();
      b.i().get(new NotificationUtil.1(this));
      localWakeLock.release();
      return;
    }
    catch (Throwable localThrowable)
    {
      localWakeLock.release();
      throw localThrowable;
    }
  }
  
  private void close()
  {
    if (h.getLooper().getThread() == Thread.currentThread()) {
      return;
    }
    throw new IllegalStateException("Needs to be invoked on the main thread.");
  }
  
  void a()
  {
    Object localObject1 = Log.get();
    Object localObject2 = p;
    ((Log)localObject1).append((String)localObject2, "Checking if commands are complete.", new Throwable[0]);
    close();
    localObject1 = a;
    try
    {
      if (x != null)
      {
        Log.get().append((String)localObject2, String.format("Removing command %s", new Object[] { x }), new Throwable[0]);
        if (((Intent)a.remove(0)).equals(x)) {
          x = null;
        } else {
          throw new IllegalStateException("Dequeue-d command is not the first.");
        }
      }
      HttpConnection localHttpConnection = l.a();
      if ((!c.a()) && (a.isEmpty()) && (!localHttpConnection.get()))
      {
        Log.get().append((String)localObject2, "No more commands & intents.", new Throwable[0]);
        localObject2 = k;
        if (localObject2 != null) {
          ((Item)localObject2).updateNotification();
        }
      }
      else if (!a.isEmpty())
      {
        clear();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  void a(Runnable paramRunnable)
  {
    h.post(paramRunnable);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    a(new Widget(this, b.a(j, paramString, paramBoolean), 0));
  }
  
  public boolean a(Intent paramIntent, int paramInt)
  {
    Object localObject2 = Log.get();
    Object localObject1 = p;
    int i = 0;
    ((Log)localObject2).append((String)localObject1, String.format("Adding command %s (%s)", new Object[] { paramIntent, Integer.valueOf(paramInt) }), new Throwable[0]);
    close();
    localObject2 = paramIntent.getAction();
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      Log.get().add((String)localObject1, "Unknown command. Ignoring", new Throwable[0]);
      return false;
    }
    if (("ACTION_CONSTRAINTS_CHANGED".equals(localObject2)) && (a("ACTION_CONSTRAINTS_CHANGED"))) {
      return false;
    }
    paramIntent.putExtra("KEY_START_ID", paramInt);
    localObject1 = a;
    paramInt = i;
    try
    {
      if (!a.isEmpty()) {
        paramInt = 1;
      }
      a.add(paramIntent);
      if (paramInt == 0) {
        clear();
      }
      return true;
    }
    catch (Throwable paramIntent)
    {
      throw paramIntent;
    }
  }
  
  androidx.work.impl.f b()
  {
    return b;
  }
  
  void c(Item paramItem)
  {
    if (k != null)
    {
      Log.get().get(p, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
      return;
    }
    k = paramItem;
  }
  
  Settings d()
  {
    return s;
  }
  
  void e()
  {
    Log.get().append(p, "Destroying SystemAlarmDispatcher", new Throwable[0]);
    n.get(this);
    s.onDestroy();
    k = null;
  }
  
  androidx.work.impl.utils.asm.f i()
  {
    return l;
  }
  
  ClassWriter j()
  {
    return n;
  }
}
