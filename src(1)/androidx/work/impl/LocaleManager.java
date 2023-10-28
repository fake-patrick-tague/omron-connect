package androidx.work.impl;

import androidx.room.asm.Item;
import v7.td.data.Context;

class LocaleManager
  extends Item
{
  LocaleManager(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public void initialize(Context paramContext)
  {
    paramContext.execSQL("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
  }
}
