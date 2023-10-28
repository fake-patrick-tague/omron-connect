package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.BaseBundle;
import android.os.Bundle;
import androidx.room.RoomDatabase;
import androidx.work.Log;
import androidx.work.WorkInfo.State;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.asm.h;
import androidx.work.impl.asm.i;
import java.util.HashMap;
import java.util.Map;

public class b
  implements androidx.work.impl.Object
{
  private static final String a = Log.getInstance("CommandHandler");
  private final Object b;
  private final Map<String, androidx.work.impl.b> c;
  private final Context l;
  
  b(Context paramContext)
  {
    l = paramContext;
    c = new HashMap();
    b = new Object();
  }
  
  static Intent a(Context paramContext)
  {
    paramContext = new Intent(paramContext, SystemAlarmService.class);
    paramContext.setAction("ACTION_CONSTRAINTS_CHANGED");
    return paramContext;
  }
  
  static Intent a(Context paramContext, String paramString)
  {
    paramContext = new Intent(paramContext, SystemAlarmService.class);
    paramContext.setAction("ACTION_SCHEDULE_WORK");
    paramContext.putExtra("KEY_WORKSPEC_ID", paramString);
    return paramContext;
  }
  
  static Intent a(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = new Intent(paramContext, SystemAlarmService.class);
    paramContext.setAction("ACTION_EXECUTION_COMPLETED");
    paramContext.putExtra("KEY_WORKSPEC_ID", paramString);
    paramContext.putExtra("KEY_NEEDS_RESCHEDULE", paramBoolean);
    return paramContext;
  }
  
  private void a(Intent paramIntent, int paramInt)
  {
    Bundle localBundle = paramIntent.getExtras();
    String str = localBundle.getString("KEY_WORKSPEC_ID");
    boolean bool = localBundle.getBoolean("KEY_NEEDS_RESCHEDULE");
    Log.get().append(a, String.format("Handling onExecutionCompleted %s, %s", new Object[] { paramIntent, Integer.valueOf(paramInt) }), new Throwable[0]);
    a(str, bool);
  }
  
  private void a(Intent paramIntent, int paramInt, f paramF)
  {
    paramIntent = paramIntent.getExtras().getString("KEY_WORKSPEC_ID");
    Object localObject1 = Log.get();
    String str = a;
    ((Log)localObject1).append(str, String.format("Handling schedule work for %s", new Object[] { paramIntent }), new Throwable[0]);
    localObject1 = paramF.b().a();
    ((RoomDatabase)localObject1).add();
    try
    {
      Object localObject2 = ((WorkDatabase)localObject1).a().a(paramIntent);
      if (localObject2 == null)
      {
        paramF = Log.get();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Skipping scheduling ");
        ((StringBuilder)localObject2).append(paramIntent);
        ((StringBuilder)localObject2).append(" because it's no longer in the DB");
        paramF.add(str, ((StringBuilder)localObject2).toString(), new Throwable[0]);
        ((RoomDatabase)localObject1).clear();
        return;
      }
      boolean bool = p.next();
      if (bool)
      {
        paramF = Log.get();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Skipping scheduling ");
        ((StringBuilder)localObject2).append(paramIntent);
        ((StringBuilder)localObject2).append("because it is finished.");
        paramF.add(str, ((StringBuilder)localObject2).toString(), new Throwable[0]);
        ((RoomDatabase)localObject1).clear();
        return;
      }
      long l1 = ((h)localObject2).a();
      bool = ((h)localObject2).b();
      if (!bool)
      {
        Log.get().append(str, String.format("Setting up Alarms for %s at %s", new Object[] { paramIntent, Long.valueOf(l1) }), new Throwable[0]);
        Attribute.a(l, paramF.b(), paramIntent, l1);
      }
      else
      {
        Log.get().append(str, String.format("Opportunistically setting an alarm for %s at %s", new Object[] { paramIntent, Long.valueOf(l1) }), new Throwable[0]);
        Attribute.a(l, paramF.b(), paramIntent, l1);
        paramF.a(new Widget(paramF, a(l), paramInt));
      }
      ((RoomDatabase)localObject1).remove();
      ((RoomDatabase)localObject1).clear();
      return;
    }
    catch (Throwable paramIntent)
    {
      ((RoomDatabase)localObject1).clear();
      throw paramIntent;
    }
  }
  
  private void a(Intent paramIntent, f paramF)
  {
    paramIntent = paramIntent.getExtras().getString("KEY_WORKSPEC_ID");
    Log.get().append(a, String.format("Handing stopWork work for %s", new Object[] { paramIntent }), new Throwable[0]);
    paramF.b().c(paramIntent);
    Attribute.a(l, paramF.b(), paramIntent);
    paramF.a(paramIntent, false);
  }
  
  private static boolean a(Bundle paramBundle, String... paramVarArgs)
  {
    if (paramBundle != null)
    {
      if (paramBundle.isEmpty()) {
        return false;
      }
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        if (paramBundle.get(paramVarArgs[i]) == null) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  private void b(Intent paramIntent, int paramInt, f paramF)
  {
    Log.get().append(a, String.format("Handling reschedule %s, %s", new Object[] { paramIntent, Integer.valueOf(paramInt) }), new Throwable[0]);
    paramF.b().onConfigurationChanged();
  }
  
  private void d(Intent paramIntent, int paramInt, f paramF)
  {
    Log.get().append(a, String.format("Handling constraints changed %s", new Object[] { paramIntent }), new Throwable[0]);
    new Frame(l, paramInt, paramF).a();
  }
  
  static Intent e(Context paramContext, String paramString)
  {
    paramContext = new Intent(paramContext, SystemAlarmService.class);
    paramContext.setAction("ACTION_DELAY_MET");
    paramContext.putExtra("KEY_WORKSPEC_ID", paramString);
    return paramContext;
  }
  
  static Intent makeInitIntent(Context paramContext)
  {
    paramContext = new Intent(paramContext, SystemAlarmService.class);
    paramContext.setAction("ACTION_RESCHEDULE");
    return paramContext;
  }
  
  static Intent set(Context paramContext, String paramString)
  {
    paramContext = new Intent(paramContext, SystemAlarmService.class);
    paramContext.setAction("ACTION_STOP_WORK");
    paramContext.putExtra("KEY_WORKSPEC_ID", paramString);
    return paramContext;
  }
  
  private void write(Intent paramIntent, int paramInt, f paramF)
  {
    Object localObject = paramIntent.getExtras();
    paramIntent = b;
    try
    {
      localObject = ((BaseBundle)localObject).getString("KEY_WORKSPEC_ID");
      Log localLog = Log.get();
      String str = a;
      localLog.append(str, String.format("Handing delay met for %s", new Object[] { localObject }), new Throwable[0]);
      if (!c.containsKey(localObject))
      {
        paramF = new Label(l, paramInt, (String)localObject, paramF);
        c.put(localObject, paramF);
        paramF.b();
      }
      else
      {
        Log.get().append(str, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", new Object[] { localObject }), new Throwable[0]);
      }
      return;
    }
    catch (Throwable paramF)
    {
      throw paramF;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject = b;
    try
    {
      androidx.work.impl.Object localObject1 = (androidx.work.impl.Object)c.remove(paramString);
      if (localObject1 != null) {
        localObject1.a(paramString, paramBoolean);
      }
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  boolean a()
  {
    Object localObject = b;
    for (;;)
    {
      try
      {
        if (!c.isEmpty())
        {
          bool = true;
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      boolean bool = false;
    }
  }
  
  void close(Intent paramIntent, int paramInt, f paramF)
  {
    String str = paramIntent.getAction();
    if ("ACTION_CONSTRAINTS_CHANGED".equals(str))
    {
      d(paramIntent, paramInt, paramF);
      return;
    }
    if ("ACTION_RESCHEDULE".equals(str))
    {
      b(paramIntent, paramInt, paramF);
      return;
    }
    if (!a(paramIntent.getExtras(), new String[] { "KEY_WORKSPEC_ID" }))
    {
      Log.get().get(a, String.format("Invalid request for %s, requires %s.", new Object[] { str, "KEY_WORKSPEC_ID" }), new Throwable[0]);
      return;
    }
    if ("ACTION_SCHEDULE_WORK".equals(str))
    {
      a(paramIntent, paramInt, paramF);
      return;
    }
    if ("ACTION_DELAY_MET".equals(str))
    {
      write(paramIntent, paramInt, paramF);
      return;
    }
    if ("ACTION_STOP_WORK".equals(str))
    {
      a(paramIntent, paramF);
      return;
    }
    if ("ACTION_EXECUTION_COMPLETED".equals(str))
    {
      a(paramIntent, paramInt);
      return;
    }
    Log.get().add(a, String.format("Ignoring intent %s", new Object[] { paramIntent }), new Throwable[0]);
  }
}
