package androidx.work.impl.asm;

import androidx.room.ByteVector;
import androidx.room.RoomDatabase;

class TigerDigest
  extends ByteVector
{
  TigerDigest(f paramF, RoomDatabase paramRoomDatabase)
  {
    super(paramRoomDatabase);
  }
  
  public String getSize()
  {
    return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
  }
}
