package androidx.work.impl.asm;

import androidx.room.Attribute;
import androidx.room.RoomDatabase;
import v7.td.data.Item;
import v7.td.data.Object;

class AnnotationWriter
  extends androidx.room.b<androidx.work.impl.n.j>
{
  AnnotationWriter(b paramB, RoomDatabase paramRoomDatabase)
  {
    super(paramRoomDatabase);
  }
  
  public void a(Item paramItem, j paramJ)
  {
    String str = a;
    if (str == null) {
      paramItem.bindNull(1);
    } else {
      paramItem.bindString(1, str);
    }
    paramJ = n;
    if (paramJ == null)
    {
      paramItem.bindNull(2);
      return;
    }
    paramItem.bindString(2, paramJ);
  }
  
  public String getSize()
  {
    return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
  }
}
