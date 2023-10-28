package androidx.work.impl;

import androidx.room.asm.Item;
import androidx.work.impl.utils.ByteVector;
import androidx.work.impl.utils.h;

public class EmulatorView
  extends Item
{
  final android.content.Context mContext;
  
  public EmulatorView(android.content.Context paramContext)
  {
    super(9, 10);
    mContext = paramContext;
  }
  
  public void initialize(v7.td.data.Context paramContext)
  {
    paramContext.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
    h.delete(mContext, paramContext);
    ByteVector.delete(mContext, paramContext);
  }
}
