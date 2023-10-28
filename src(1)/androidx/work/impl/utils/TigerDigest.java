package androidx.work.impl.utils;

import androidx.work.ExtendedDigest;
import androidx.work.Log;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.asm.f;

public class TigerDigest
  implements ExtendedDigest
{
  static final String a = Log.getInstance("WorkProgressUpdater");
  final f b;
  final WorkDatabase c;
  
  public TigerDigest(WorkDatabase paramWorkDatabase, f paramF)
  {
    c = paramWorkDatabase;
    b = paramF;
  }
}
