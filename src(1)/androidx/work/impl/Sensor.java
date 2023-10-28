package androidx.work.impl;

import android.os.Build.VERSION;
import androidx.room.asm.Item;
import v7.td.data.Context;

class Sensor
  extends Item
{
  Sensor(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public void initialize(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      paramContext.execSQL("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
    }
  }
}
