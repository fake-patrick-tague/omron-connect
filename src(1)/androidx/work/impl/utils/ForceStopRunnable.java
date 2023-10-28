package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.room.RoomDatabase;
import androidx.work.WorkInfo.State;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.asm.i;
import androidx.work.impl.asm.n;
import androidx.work.impl.background.systemjob.b;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ForceStopRunnable
  implements Runnable
{
  private static final long id = TimeUnit.DAYS.toMillis(3650L);
  private static final String p = androidx.work.Log.getInstance("ForceStopRunnable");
  private final android.content.Context a;
  private int c;
  private final androidx.work.impl.f d;
  
  public ForceStopRunnable(android.content.Context paramContext, androidx.work.impl.f paramF)
  {
    a = paramContext.getApplicationContext();
    d = paramF;
    c = 0;
  }
  
  private static PendingIntent createPendingIntent(android.content.Context paramContext, int paramInt)
  {
    return PendingIntent.getBroadcast(paramContext, -1, getAlarmIntent(paramContext), paramInt);
  }
  
  static Intent getAlarmIntent(android.content.Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(paramContext, BroadcastReceiver.class));
    localIntent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
    return localIntent;
  }
  
  static void setAlarm(android.content.Context paramContext)
  {
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    int i;
    if (v7.v7.menu.Context.getType()) {
      i = 167772160;
    } else {
      i = 134217728;
    }
    paramContext = createPendingIntent(paramContext, i);
    long l = System.currentTimeMillis() + id;
    if (localAlarmManager != null)
    {
      if (Build.VERSION.SDK_INT >= 19)
      {
        localAlarmManager.setExact(0, l, paramContext);
        return;
      }
      localAlarmManager.set(0, l, paramContext);
    }
  }
  
  public boolean a()
  {
    boolean bool1;
    if (Build.VERSION.SDK_INT >= 23) {
      bool1 = b.a(a, d);
    } else {
      bool1 = false;
    }
    WorkDatabase localWorkDatabase = d.a();
    i localI = localWorkDatabase.a();
    n localN = localWorkDatabase.c();
    localWorkDatabase.add();
    try
    {
      Object localObject = localI.run();
      boolean bool2;
      if (localObject != null)
      {
        bool2 = ((List)localObject).isEmpty();
        if (!bool2)
        {
          i = 1;
          break label86;
        }
      }
      int i = 0;
      label86:
      if (i != 0)
      {
        localObject = ((List)localObject).iterator();
        for (;;)
        {
          bool2 = ((Iterator)localObject).hasNext();
          if (!bool2) {
            break;
          }
          androidx.work.impl.asm.h localH = (androidx.work.impl.asm.h)((Iterator)localObject).next();
          localI.a(WorkInfo.State.a, new String[] { a });
          localI.add(a, -1L);
        }
      }
      localN.a();
      localWorkDatabase.remove();
      localWorkDatabase.clear();
      if ((i != 0) || (bool1)) {
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      localWorkDatabase.clear();
      throw localThrowable;
    }
    return false;
  }
  
  boolean b()
  {
    return d.c().a();
  }
  
  public void c()
  {
    boolean bool = a();
    if (b())
    {
      androidx.work.Log.get().append(p, "Rescheduling Workers.", new Throwable[0]);
      d.onConfigurationChanged();
      d.c().a(false);
      return;
    }
    if (update())
    {
      androidx.work.Log.get().append(p, "Application was force-stopped, rescheduling.", new Throwable[0]);
      d.onConfigurationChanged();
      return;
    }
    if (bool)
    {
      androidx.work.Log.get().append(p, "Found unfinished work, scheduling it.", new Throwable[0]);
      androidx.work.impl.Log.a(d.b(), d.a(), d.d());
    }
  }
  
  public void copyBytes(long paramLong)
  {
    try
    {
      Thread.sleep(paramLong);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  public boolean d()
  {
    androidx.work.f localF = d.b();
    if (TextUtils.isEmpty(localF.c()))
    {
      androidx.work.Log.get().append(p, "The default process name was not specified.", new Throwable[0]);
      return true;
    }
    boolean bool = Frame.a(a, localF);
    androidx.work.Log.get().append(p, String.format("Is default app process = %s", new Object[] { Boolean.valueOf(bool) }), new Throwable[0]);
    return bool;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 304	androidx/work/impl/utils/ForceStopRunnable:d	()Z
    //   4: istore_2
    //   5: iload_2
    //   6: ifne +11 -> 17
    //   9: aload_0
    //   10: getfield 60	androidx/work/impl/utils/ForceStopRunnable:d	Landroidx/work/impl/f;
    //   13: invokevirtual 305	androidx/work/impl/f:clear	()V
    //   16: return
    //   17: aload_0
    //   18: getfield 58	androidx/work/impl/utils/ForceStopRunnable:a	Landroid/content/Context;
    //   21: invokestatic 309	androidx/work/impl/Type:a	(Landroid/content/Context;)V
    //   24: invokestatic 223	androidx/work/Log:get	()Landroidx/work/Log;
    //   27: getstatic 31	androidx/work/impl/utils/ForceStopRunnable:p	Ljava/lang/String;
    //   30: ldc_w 311
    //   33: iconst_0
    //   34: anewarray 132	java/lang/Throwable
    //   37: invokevirtual 229	androidx/work/Log:append	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Throwable;)V
    //   40: aload_0
    //   41: invokevirtual 313	androidx/work/impl/utils/ForceStopRunnable:c	()V
    //   44: goto +147 -> 191
    //   47: astore 5
    //   49: goto +25 -> 74
    //   52: astore 5
    //   54: goto +20 -> 74
    //   57: astore 5
    //   59: goto +15 -> 74
    //   62: astore 5
    //   64: goto +10 -> 74
    //   67: astore 5
    //   69: goto +5 -> 74
    //   72: astore 5
    //   74: aload_0
    //   75: getfield 62	androidx/work/impl/utils/ForceStopRunnable:c	I
    //   78: istore_1
    //   79: iload_1
    //   80: iconst_1
    //   81: iadd
    //   82: istore_1
    //   83: aload_0
    //   84: iload_1
    //   85: putfield 62	androidx/work/impl/utils/ForceStopRunnable:c	I
    //   88: iload_1
    //   89: iconst_3
    //   90: if_icmplt +112 -> 202
    //   93: invokestatic 223	androidx/work/Log:get	()Landroidx/work/Log;
    //   96: astore 7
    //   98: getstatic 31	androidx/work/impl/utils/ForceStopRunnable:p	Ljava/lang/String;
    //   101: astore 6
    //   103: aload 7
    //   105: aload 6
    //   107: ldc_w 315
    //   110: iconst_1
    //   111: anewarray 132	java/lang/Throwable
    //   114: dup
    //   115: iconst_0
    //   116: aload 5
    //   118: aastore
    //   119: checkcast 317	[Ljava/lang/Throwable;
    //   122: invokevirtual 319	androidx/work/Log:get	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Throwable;)V
    //   125: new 321	java/lang/IllegalStateException
    //   128: dup
    //   129: ldc_w 315
    //   132: aload 5
    //   134: checkcast 132	java/lang/Throwable
    //   137: invokespecial 324	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   140: astore 5
    //   142: aload_0
    //   143: getfield 60	androidx/work/impl/utils/ForceStopRunnable:d	Landroidx/work/impl/f;
    //   146: invokevirtual 245	androidx/work/impl/f:b	()Landroidx/work/f;
    //   149: invokevirtual 328	androidx/work/f:i	()Landroidx/work/Logger;
    //   152: astore 7
    //   154: aload 7
    //   156: ifnull +43 -> 199
    //   159: invokestatic 223	androidx/work/Log:get	()Landroidx/work/Log;
    //   162: aload 6
    //   164: ldc_w 330
    //   167: iconst_1
    //   168: anewarray 132	java/lang/Throwable
    //   171: dup
    //   172: iconst_0
    //   173: aload 5
    //   175: aastore
    //   176: checkcast 317	[Ljava/lang/Throwable;
    //   179: invokevirtual 229	androidx/work/Log:append	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Throwable;)V
    //   182: aload 7
    //   184: aload 5
    //   186: invokeinterface 336 2 0
    //   191: aload_0
    //   192: getfield 60	androidx/work/impl/utils/ForceStopRunnable:d	Landroidx/work/impl/f;
    //   195: invokevirtual 305	androidx/work/impl/f:clear	()V
    //   198: return
    //   199: aload 5
    //   201: athrow
    //   202: iload_1
    //   203: i2l
    //   204: lstore_3
    //   205: invokestatic 223	androidx/work/Log:get	()Landroidx/work/Log;
    //   208: getstatic 31	androidx/work/impl/utils/ForceStopRunnable:p	Ljava/lang/String;
    //   211: ldc_w 338
    //   214: iconst_1
    //   215: anewarray 4	java/lang/Object
    //   218: dup
    //   219: iconst_0
    //   220: lload_3
    //   221: ldc2_w 339
    //   224: lmul
    //   225: invokestatic 345	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   228: aastore
    //   229: invokestatic 290	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   232: iconst_1
    //   233: anewarray 132	java/lang/Throwable
    //   236: dup
    //   237: iconst_0
    //   238: aload 5
    //   240: aastore
    //   241: checkcast 317	[Ljava/lang/Throwable;
    //   244: invokevirtual 229	androidx/work/Log:append	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Throwable;)V
    //   247: aload_0
    //   248: getfield 62	androidx/work/impl/utils/ForceStopRunnable:c	I
    //   251: i2l
    //   252: lstore_3
    //   253: aload_0
    //   254: lload_3
    //   255: ldc2_w 339
    //   258: lmul
    //   259: invokevirtual 347	androidx/work/impl/utils/ForceStopRunnable:copyBytes	(J)V
    //   262: goto -245 -> 17
    //   265: astore 5
    //   267: aload_0
    //   268: getfield 60	androidx/work/impl/utils/ForceStopRunnable:d	Landroidx/work/impl/f;
    //   271: invokevirtual 305	androidx/work/impl/f:clear	()V
    //   274: aload 5
    //   276: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	this	ForceStopRunnable
    //   78	125	1	i	int
    //   4	2	2	bool	boolean
    //   204	51	3	l	long
    //   47	1	5	localSQLiteAccessPermException	android.database.sqlite.SQLiteAccessPermException
    //   52	1	5	localSQLiteConstraintException	android.database.sqlite.SQLiteConstraintException
    //   57	1	5	localSQLiteTableLockedException	android.database.sqlite.SQLiteTableLockedException
    //   62	1	5	localSQLiteDatabaseLockedException	android.database.sqlite.SQLiteDatabaseLockedException
    //   67	1	5	localSQLiteDatabaseCorruptException	android.database.sqlite.SQLiteDatabaseCorruptException
    //   72	61	5	localSQLiteCantOpenDatabaseException	android.database.sqlite.SQLiteCantOpenDatabaseException
    //   140	99	5	localIllegalStateException	IllegalStateException
    //   265	10	5	localThrowable	Throwable
    //   101	62	6	str	String
    //   96	87	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   40	44	47	android/database/sqlite/SQLiteAccessPermException
    //   40	44	52	android/database/sqlite/SQLiteConstraintException
    //   40	44	57	android/database/sqlite/SQLiteTableLockedException
    //   40	44	62	android/database/sqlite/SQLiteDatabaseLockedException
    //   40	44	67	android/database/sqlite/SQLiteDatabaseCorruptException
    //   40	44	72	android/database/sqlite/SQLiteCantOpenDatabaseException
    //   0	5	265	java/lang/Throwable
    //   17	40	265	java/lang/Throwable
    //   40	44	265	java/lang/Throwable
    //   74	79	265	java/lang/Throwable
    //   83	88	265	java/lang/Throwable
    //   93	125	265	java/lang/Throwable
    //   125	154	265	java/lang/Throwable
    //   159	191	265	java/lang/Throwable
    //   199	202	265	java/lang/Throwable
    //   205	253	265	java/lang/Throwable
    //   253	262	265	java/lang/Throwable
  }
  
  public boolean update()
  {
    int i = 536870912;
    try
    {
      boolean bool = v7.v7.menu.Context.getType();
      if (bool) {
        i = 570425344;
      }
      Object localObject1 = a;
      localObject1 = createPendingIntent((android.content.Context)localObject1, i);
      if (Build.VERSION.SDK_INT >= 30)
      {
        if (localObject1 != null) {
          ((PendingIntent)localObject1).cancel();
        }
        localObject1 = a;
        localObject1 = ((android.content.Context)localObject1).getSystemService("activity");
        localObject1 = (ActivityManager)localObject1;
        localObject1 = ((ActivityManager)localObject1).getHistoricalProcessExitReasons(null, 0, 0);
        if (localObject1 != null)
        {
          bool = ((List)localObject1).isEmpty();
          if (bool) {
            break label201;
          }
          i = 0;
          for (;;)
          {
            int j = ((List)localObject1).size();
            if (i >= j) {
              break;
            }
            Object localObject2 = ((List)localObject1).get(i);
            localObject2 = (ApplicationExitInfo)localObject2;
            j = ((ApplicationExitInfo)localObject2).getReason();
            if (j == 10) {
              return true;
            }
            i += 1;
          }
        }
      }
      else
      {
        if (localObject1 != null) {
          break label201;
        }
        localObject1 = a;
        setAlarm((android.content.Context)localObject1);
        return true;
      }
      return false;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}catch (SecurityException localSecurityException) {}
    androidx.work.Log.get().add(p, "Ignoring exception", new Throwable[] { localSecurityException });
    return true;
    label201:
    return false;
  }
  
  public static class BroadcastReceiver
    extends BroadcastReceiver
  {
    private static final String a = androidx.work.Log.getInstance("ForceStopRunnable$Rcvr");
    
    public BroadcastReceiver() {}
    
    public void onReceive(android.content.Context paramContext, Intent paramIntent)
    {
      if ((paramIntent != null) && ("ACTION_FORCE_STOP_RESCHEDULE".equals(paramIntent.getAction())))
      {
        androidx.work.Log.get().set(a, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
        ForceStopRunnable.setAlarm(paramContext);
      }
    }
  }
}
