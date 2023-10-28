package com.google.android.gms.internal.stats;

import java.io.Closeable;

public final class FinalizableReferenceQueue
  implements Closeable
{
  private static final FinalizableReferenceQueue queue = new FinalizableReferenceQueue(false, null);
  
  private FinalizableReferenceQueue(boolean paramBoolean, DatabaseHelper paramDatabaseHelper) {}
  
  public static FinalizableReferenceQueue toString(boolean paramBoolean, Collection paramCollection)
  {
    return queue;
  }
  
  public final void close() {}
}
