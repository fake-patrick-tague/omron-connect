package androidx.work.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import androidx.room.asm.Item;

public class ConcatFilter
  extends Item
{
  final android.content.Context c;
  
  public ConcatFilter(android.content.Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    c = paramContext;
  }
  
  public void initialize(v7.td.data.Context paramContext)
  {
    if (b >= 10)
    {
      paramContext.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[] { "reschedule_needed", Integer.valueOf(1) });
      return;
    }
    c.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
  }
}
