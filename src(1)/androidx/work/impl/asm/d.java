package androidx.work.impl.asm;

import androidx.room.Attribute;
import androidx.room.RoomDatabase;
import androidx.room.b;
import androidx.work.impl.n.a;
import v7.td.data.Item;
import v7.td.data.Object;

class d
  extends b<a>
{
  d(g paramG, RoomDatabase paramRoomDatabase)
  {
    super(paramRoomDatabase);
  }
  
  public void a(Item paramItem, x paramX)
  {
    String str = a;
    if (str == null) {
      paramItem.bindNull(1);
    } else {
      paramItem.bindString(1, str);
    }
    paramX = b;
    if (paramX == null)
    {
      paramItem.bindNull(2);
      return;
    }
    paramItem.bindString(2, paramX);
  }
  
  public String getSize()
  {
    return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
  }
}
