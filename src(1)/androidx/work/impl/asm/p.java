package androidx.work.impl.asm;

import androidx.room.RoomDatabase;
import androidx.room.b;
import androidx.work.impl.n.g;
import v7.td.data.Item;
import v7.td.data.Object;

class p
  extends b<g>
{
  p(ClassWriter paramClassWriter, RoomDatabase paramRoomDatabase)
  {
    super(paramRoomDatabase);
  }
  
  public String getSize()
  {
    return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
  }
  
  public void write(Item paramItem, Attribute paramAttribute)
  {
    String str = b;
    if (str == null) {
      paramItem.bindNull(1);
    } else {
      paramItem.bindString(1, str);
    }
    paramItem.bindLong(2, a);
  }
}
