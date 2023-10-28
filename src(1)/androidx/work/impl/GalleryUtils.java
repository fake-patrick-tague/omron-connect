package androidx.work.impl;

import androidx.room.asm.Item;
import v7.td.data.Context;

class GalleryUtils
  extends Item
{
  GalleryUtils(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public void initialize(Context paramContext)
  {
    paramContext.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
  }
}
