package com.google.android.gms.common.data;

public final class DaoSession
  extends RuntimeException
{
  public DaoSession(String paramString)
  {
    super("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
  }
}
