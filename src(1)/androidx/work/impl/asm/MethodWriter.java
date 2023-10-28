package androidx.work.impl.asm;

import androidx.room.Attribute;
import androidx.room.RoomDatabase;
import androidx.room.b;
import androidx.work.Label;
import v7.td.data.Item;
import v7.td.data.Object;

class MethodWriter
  extends b<androidx.work.impl.n.m>
{
  MethodWriter(o paramO, RoomDatabase paramRoomDatabase)
  {
    super(paramRoomDatabase);
  }
  
  public void a(Item paramItem, m paramM)
  {
    String str = i;
    if (str == null) {
      paramItem.bindNull(1);
    } else {
      paramItem.bindString(1, str);
    }
    paramM = Label.write(b);
    if (paramM == null)
    {
      paramItem.bindNull(2);
      return;
    }
    paramItem.bindBlob(2, paramM);
  }
  
  public String getSize()
  {
    return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
  }
}
