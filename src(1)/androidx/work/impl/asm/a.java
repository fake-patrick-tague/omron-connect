package androidx.work.impl.asm;

import androidx.room.ByteVector;
import androidx.room.RoomDatabase;

class a
  extends ByteVector
{
  a(o paramO, RoomDatabase paramRoomDatabase)
  {
    super(paramRoomDatabase);
  }
  
  public String getSize()
  {
    return "DELETE from WorkProgress where work_spec_id=?";
  }
}
