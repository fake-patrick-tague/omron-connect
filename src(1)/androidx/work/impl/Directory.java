package androidx.work.impl;

import androidx.room.asm.Item;
import v7.td.data.Context;

class Directory
  extends Item
{
  Directory(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public void initialize(Context paramContext)
  {
    paramContext.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
    paramContext.execSQL("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
    paramContext.execSQL("DROP TABLE IF EXISTS alarmInfo");
    paramContext.execSQL("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
  }
}
