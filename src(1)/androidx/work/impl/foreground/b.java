package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.work.Handle;
import androidx.work.Log;
import androidx.work.e;
import androidx.work.impl.ClassWriter;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.asm.h;
import androidx.work.impl.n.p;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public class b
  implements androidx.work.impl.ui.a, androidx.work.impl.Object
{
  static final String g = Log.getInstance("SystemFgDispatcher");
  String a;
  private androidx.work.impl.f b;
  final Map<String, e> c;
  private final androidx.work.impl.utils.asm.f d;
  final Object e;
  private Context i;
  final Set<p> j;
  final androidx.work.impl.ui.f k;
  private ByteVector l;
  final Map<String, p> m;
  
  b(Context paramContext)
  {
    i = paramContext;
    e = new Object();
    paramContext = androidx.work.impl.f.a(i);
    b = paramContext;
    paramContext = paramContext.i();
    d = paramContext;
    a = null;
    c = new LinkedHashMap();
    j = new HashSet();
    m = new HashMap();
    k = new androidx.work.impl.ui.f(i, paramContext, this);
    b.get().a(this);
  }
  
  public static Intent a(Context paramContext)
  {
    paramContext = new Intent(paramContext, SystemForegroundService.class);
    paramContext.setAction("ACTION_STOP_FOREGROUND");
    return paramContext;
  }
  
  public static Intent a(Context paramContext, String paramString, Handle paramHandle)
  {
    paramContext = new Intent(paramContext, SystemForegroundService.class);
    paramContext.setAction("ACTION_START_FOREGROUND");
    paramContext.putExtra("KEY_WORKSPEC_ID", paramString);
    paramContext.putExtra("KEY_NOTIFICATION_ID", paramHandle.getValue());
    paramContext.putExtra("KEY_FOREGROUND_SERVICE_TYPE", paramHandle.getName());
    paramContext.putExtra("KEY_NOTIFICATION", paramHandle.a());
    paramContext.putExtra("KEY_WORKSPEC_ID", paramString);
    return paramContext;
  }
  
  private void a(Intent paramIntent)
  {
    int n = 0;
    int i1 = paramIntent.getIntExtra("KEY_NOTIFICATION_ID", 0);
    int i2 = paramIntent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
    String str = paramIntent.getStringExtra("KEY_WORKSPEC_ID");
    paramIntent = (Notification)paramIntent.getParcelableExtra("KEY_NOTIFICATION");
    Log.get().append(g, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", new Object[] { Integer.valueOf(i1), str, Integer.valueOf(i2) }), new Throwable[0]);
    if ((paramIntent != null) && (l != null))
    {
      Handle localHandle = new Handle(i1, paramIntent, i2);
      c.put(str, localHandle);
      if (TextUtils.isEmpty(a))
      {
        a = str;
        l.a(i1, i2, paramIntent);
        return;
      }
      l.a(i1, paramIntent);
      if ((i2 != 0) && (Build.VERSION.SDK_INT >= 29))
      {
        paramIntent = c.entrySet().iterator();
        while (paramIntent.hasNext()) {
          n |= ((Handle)((Map.Entry)paramIntent.next()).getValue()).getName();
        }
        paramIntent = (Handle)c.get(a);
        if (paramIntent != null) {
          l.a(paramIntent.getValue(), n, paramIntent.a());
        }
      }
    }
  }
  
  private void b(Intent paramIntent)
  {
    Log.get().a(g, String.format("Started foreground service %s", new Object[] { paramIntent }), new Throwable[0]);
    paramIntent = paramIntent.getStringExtra("KEY_WORKSPEC_ID");
    WorkDatabase localWorkDatabase = b.a();
    d.get(new a(this, localWorkDatabase, paramIntent));
  }
  
  public static Intent set(Context paramContext, String paramString, Handle paramHandle)
  {
    paramContext = new Intent(paramContext, SystemForegroundService.class);
    paramContext.setAction("ACTION_NOTIFY");
    paramContext.putExtra("KEY_NOTIFICATION_ID", paramHandle.getValue());
    paramContext.putExtra("KEY_FOREGROUND_SERVICE_TYPE", paramHandle.getName());
    paramContext.putExtra("KEY_NOTIFICATION", paramHandle.a());
    paramContext.putExtra("KEY_WORKSPEC_ID", paramString);
    return paramContext;
  }
  
  private void write(Intent paramIntent)
  {
    Log.get().a(g, String.format("Stopping foreground work for %s", new Object[] { paramIntent }), new Throwable[0]);
    paramIntent = paramIntent.getStringExtra("KEY_WORKSPEC_ID");
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent))) {
      b.a(UUID.fromString(paramIntent));
    }
  }
  
  void a()
  {
    l = null;
    Object localObject = e;
    try
    {
      k.a();
      b.get().get(this);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  void a(ByteVector paramByteVector)
  {
    if (l != null)
    {
      Log.get().get(g, "A callback already exists.", new Throwable[0]);
      return;
    }
    l = paramByteVector;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject1 = e;
    for (;;)
    {
      try
      {
        Object localObject2 = (h)m.remove(paramString);
        if (localObject2 == null) {
          break label293;
        }
        paramBoolean = j.remove(localObject2);
        if (paramBoolean) {
          k.a(j);
        }
        localObject2 = (Handle)c.remove(paramString);
        if ((paramString.equals(a)) && (c.size() > 0))
        {
          Iterator localIterator = c.entrySet().iterator();
          localObject1 = (Map.Entry)localIterator.next();
          if (localIterator.hasNext())
          {
            localObject1 = (Map.Entry)localIterator.next();
            continue;
          }
          a = ((String)((Map.Entry)localObject1).getKey());
          if (l != null)
          {
            localObject1 = (Handle)((Map.Entry)localObject1).getValue();
            l.a(((Handle)localObject1).getValue(), ((Handle)localObject1).getName(), ((Handle)localObject1).a());
            l.a(((Handle)localObject1).getValue());
          }
        }
        localObject1 = l;
        if ((localObject2 != null) && (localObject1 != null))
        {
          Log.get().append(g, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", new Object[] { Integer.valueOf(((Handle)localObject2).getValue()), paramString, Integer.valueOf(((Handle)localObject2).getName()) }), new Throwable[0]);
          ((ByteVector)localObject1).a(((Handle)localObject2).getValue());
          return;
        }
      }
      catch (Throwable paramString)
      {
        throw paramString;
      }
      return;
      label293:
      paramBoolean = false;
    }
  }
  
  public void a(List paramList) {}
  
  public void b(List paramList)
  {
    if (!paramList.isEmpty())
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        Log.get().append(g, String.format("Constraints unmet for WorkSpec %s", new Object[] { str }), new Throwable[0]);
        b.e(str);
      }
    }
  }
  
  void c(Intent paramIntent)
  {
    Log.get().a(g, "Stopping foreground service", new Throwable[0]);
    paramIntent = l;
    if (paramIntent != null) {
      paramIntent.stop();
    }
  }
  
  void close(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ("ACTION_START_FOREGROUND".equals(str))
    {
      b(paramIntent);
      a(paramIntent);
      return;
    }
    if ("ACTION_NOTIFY".equals(str))
    {
      a(paramIntent);
      return;
    }
    if ("ACTION_CANCEL_WORK".equals(str))
    {
      write(paramIntent);
      return;
    }
    if ("ACTION_STOP_FOREGROUND".equals(str)) {
      c(paramIntent);
    }
  }
}
