package com.google.android.gms.common.sqlite;

import android.database.AbstractCursor;
import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class CursorWrapper
  extends android.database.CursorWrapper
  implements CrossProcessCursor
{
  private AbstractWindowedCursor mCursor;
  
  public CursorWrapper(Cursor paramCursor)
  {
    super(paramCursor);
    int i = 0;
    while ((i < 10) && ((paramCursor instanceof android.database.CursorWrapper)))
    {
      paramCursor = ((android.database.CursorWrapper)paramCursor).getWrappedCursor();
      i += 1;
    }
    if ((paramCursor instanceof AbstractWindowedCursor))
    {
      mCursor = ((AbstractWindowedCursor)paramCursor);
      return;
    }
    throw new IllegalArgumentException("Unknown type: ".concat(paramCursor.getClass().getName()));
  }
  
  public void fillWindow(int paramInt, CursorWindow paramCursorWindow)
  {
    mCursor.fillWindow(paramInt, paramCursorWindow);
  }
  
  public CursorWindow getWindow()
  {
    return mCursor.getWindow();
  }
  
  public final boolean onMove(int paramInt1, int paramInt2)
  {
    return mCursor.onMove(paramInt1, paramInt2);
  }
  
  public void setWindow(CursorWindow paramCursorWindow)
  {
    mCursor.setWindow(paramCursorWindow);
  }
}
