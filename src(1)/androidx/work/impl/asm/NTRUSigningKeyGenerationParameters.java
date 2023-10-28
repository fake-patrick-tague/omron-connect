package androidx.work.impl.asm;

import androidx.room.ByteVector;
import androidx.room.RoomDatabase;

class NTRUSigningKeyGenerationParameters
  extends ByteVector
{
  NTRUSigningKeyGenerationParameters(f paramF, RoomDatabase paramRoomDatabase)
  {
    super(paramRoomDatabase);
  }
  
  public String getSize()
  {
    return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
  }
}
