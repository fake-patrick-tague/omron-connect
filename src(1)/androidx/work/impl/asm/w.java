package androidx.work.impl.asm;

import androidx.room.Attribute;
import androidx.room.RoomDatabase;
import androidx.room.b;
import androidx.work.impl.n.s;
import v7.td.data.Item;
import v7.td.data.Object;

class w
  extends b<s>
{
  w(DocumentBody paramDocumentBody, RoomDatabase paramRoomDatabase)
  {
    super(paramRoomDatabase);
  }
  
  public String getSize()
  {
    return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
  }
  
  public void write(Item paramItem, Segment paramSegment)
  {
    String str = a;
    if (str == null) {
      paramItem.bindNull(1);
    } else {
      paramItem.bindString(1, str);
    }
    paramSegment = b;
    if (paramSegment == null)
    {
      paramItem.bindNull(2);
      return;
    }
    paramItem.bindString(2, paramSegment);
  }
}
