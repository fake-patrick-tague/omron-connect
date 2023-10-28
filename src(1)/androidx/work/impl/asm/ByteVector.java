package androidx.work.impl.asm;

import androidx.room.Attribute;
import androidx.room.RoomDatabase;
import androidx.room.b;
import androidx.work.impl.n.d;
import v7.td.data.Item;
import v7.td.data.Object;

class ByteVector
  extends b<d>
{
  ByteVector(e paramE, RoomDatabase paramRoomDatabase)
  {
    super(paramRoomDatabase);
  }
  
  public String getSize()
  {
    return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
  }
  
  public void write(Item paramItem, Type paramType)
  {
    String str = a;
    if (str == null) {
      paramItem.bindNull(1);
    } else {
      paramItem.bindString(1, str);
    }
    paramType = b;
    if (paramType == null)
    {
      paramItem.bindNull(2);
      return;
    }
    paramItem.bindLong(2, paramType.longValue());
  }
}
