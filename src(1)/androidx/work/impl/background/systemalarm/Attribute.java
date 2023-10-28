package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import androidx.work.Log;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.asm.Frame;
import androidx.work.impl.f;
import androidx.work.impl.utils.ByteVector;

class Attribute
{
  private static final String b = Log.getInstance("Alarms");
  
  public static void a(Context paramContext, f paramF, String paramString)
  {
    paramF = paramF.a().read();
    androidx.work.impl.asm.Attribute localAttribute = paramF.get(paramString);
    if (localAttribute != null)
    {
      a(paramContext, paramString, a);
      Log.get().append(b, String.format("Removing SystemIdInfo for workSpecId (%s)", new Object[] { paramString }), new Throwable[0]);
      paramF.a(paramString);
    }
  }
  
  public static void a(Context paramContext, f paramF, String paramString, long paramLong)
  {
    paramF = paramF.a();
    Frame localFrame = paramF.read();
    androidx.work.impl.asm.Attribute localAttribute = localFrame.get(paramString);
    if (localAttribute != null)
    {
      a(paramContext, paramString, a);
      setAlarm(paramContext, paramString, a, paramLong);
      return;
    }
    int i = new ByteVector(paramF).a();
    localFrame.a(new androidx.work.impl.asm.Attribute(paramString, i));
    setAlarm(paramContext, paramString, i, paramLong);
  }
  
  private static void a(Context paramContext, String paramString, int paramInt)
  {
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    Intent localIntent = b.e(paramContext, paramString);
    int i;
    if (Build.VERSION.SDK_INT >= 23) {
      i = 603979776;
    } else {
      i = 536870912;
    }
    paramContext = PendingIntent.getService(paramContext, paramInt, localIntent, i);
    if ((paramContext != null) && (localAlarmManager != null))
    {
      Log.get().append(b, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", new Object[] { paramString, Integer.valueOf(paramInt) }), new Throwable[0]);
      localAlarmManager.cancel(paramContext);
    }
  }
  
  private static void setAlarm(Context paramContext, String paramString, int paramInt, long paramLong)
  {
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    int j = Build.VERSION.SDK_INT;
    int i;
    if (j >= 23) {
      i = 201326592;
    } else {
      i = 134217728;
    }
    paramContext = PendingIntent.getService(paramContext, paramInt, b.e(paramContext, paramString), i);
    if (localAlarmManager != null)
    {
      if (j >= 19)
      {
        localAlarmManager.setExact(0, paramLong, paramContext);
        return;
      }
      localAlarmManager.set(0, paramLong, paramContext);
    }
  }
}
