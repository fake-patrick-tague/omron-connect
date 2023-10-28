package androidx.work.impl.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import androidx.room.RoomDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.asm.Type;
import androidx.work.impl.asm.k;

public class ByteVector
{
  private final WorkDatabase n;
  
  public ByteVector(WorkDatabase paramWorkDatabase)
  {
    n = paramWorkDatabase;
  }
  
  private int a(String paramString)
  {
    n.add();
    try
    {
      Long localLong = n.get().getId(paramString);
      int j = 0;
      int i;
      if (localLong != null) {
        i = localLong.intValue();
      } else {
        i = 0;
      }
      if (i != Integer.MAX_VALUE) {
        j = i + 1;
      }
      a(paramString, j);
      n.remove();
      n.clear();
      return i;
    }
    catch (Throwable paramString)
    {
      n.clear();
      throw paramString;
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    n.get().a(new Type(paramString, paramInt));
  }
  
  public static void delete(android.content.Context paramContext, v7.td.data.Context paramContext1)
  {
    paramContext = paramContext.getSharedPreferences("androidx.work.util.id", 0);
    if ((paramContext.contains("next_job_scheduler_id")) || (paramContext.contains("next_job_scheduler_id")))
    {
      int i = paramContext.getInt("next_job_scheduler_id", 0);
      int j = paramContext.getInt("next_alarm_manager_id", 0);
      paramContext1.beginTransaction();
      try
      {
        paramContext1.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[] { "next_job_scheduler_id", Integer.valueOf(i) });
        paramContext1.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[] { "next_alarm_manager_id", Integer.valueOf(j) });
        paramContext.edit().clear().apply();
        paramContext1.setTransactionSuccessful();
        paramContext1.endTransaction();
        return;
      }
      catch (Throwable paramContext)
      {
        paramContext1.endTransaction();
        throw paramContext;
      }
    }
  }
  
  public int a()
  {
    try
    {
      int i = a("next_alarm_manager_id");
      return i;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int i;
      try
      {
        i = a("next_job_scheduler_id");
        if (i >= paramInt1) {
          if (i <= paramInt2) {
            break label45;
          }
        }
        a("next_job_scheduler_id", paramInt1 + 1);
        return paramInt1;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      label45:
      paramInt1 = i;
    }
  }
}
