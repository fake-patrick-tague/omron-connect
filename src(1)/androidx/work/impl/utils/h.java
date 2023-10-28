package androidx.work.impl.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.asm.Type;
import androidx.work.impl.asm.k;

public class h
{
  private final WorkDatabase i;
  
  public h(WorkDatabase paramWorkDatabase)
  {
    i = paramWorkDatabase;
  }
  
  public static void delete(android.content.Context paramContext, v7.td.data.Context paramContext1)
  {
    paramContext = paramContext.getSharedPreferences("androidx.work.util.preferences", 0);
    if ((paramContext.contains("reschedule_needed")) || (paramContext.contains("last_cancel_all_time_ms")))
    {
      long l1 = 0L;
      long l2 = paramContext.getLong("last_cancel_all_time_ms", 0L);
      if (paramContext.getBoolean("reschedule_needed", false)) {
        l1 = 1L;
      }
      paramContext1.beginTransaction();
      try
      {
        paramContext1.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[] { "last_cancel_all_time_ms", Long.valueOf(l2) });
        paramContext1.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[] { "reschedule_needed", Long.valueOf(l1) });
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
  
  public void a(boolean paramBoolean)
  {
    Type localType = new Type("reschedule_needed", paramBoolean);
    i.get().a(localType);
  }
  
  public boolean a()
  {
    Long localLong = i.get().getId("reschedule_needed");
    return (localLong != null) && (localLong.longValue() == 1L);
  }
}
