package androidx.work.impl;

import androidx.room.asm.Item;
import v7.td.data.Context;

class TrustedAuthorities
  extends Item
{
  TrustedAuthorities(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public void initialize(Context paramContext)
  {
    paramContext.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
    paramContext.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
  }
}
