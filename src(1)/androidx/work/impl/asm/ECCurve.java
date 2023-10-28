package androidx.work.impl.asm;

import androidx.room.ByteVector;
import androidx.room.RoomDatabase;

class ECCurve
  extends ByteVector
{
  ECCurve(f paramF, RoomDatabase paramRoomDatabase)
  {
    super(paramRoomDatabase);
  }
  
  public String getSize()
  {
    return "DELETE FROM workspec WHERE id=?";
  }
}
