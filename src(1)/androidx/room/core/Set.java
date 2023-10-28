package androidx.room.core;

import android.database.Cursor;
import android.database.MatrixCursor;

public class Set
{
  public static int getCount(Cursor paramCursor, String paramString)
  {
    int i = paramCursor.getColumnIndex(paramString);
    if (i >= 0) {
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("`");
    localStringBuilder.append(paramString);
    localStringBuilder.append("`");
    return paramCursor.getColumnIndex(localStringBuilder.toString());
  }
  
  public static int getValue(Cursor paramCursor, String paramString)
  {
    int i = paramCursor.getColumnIndex(paramString);
    if (i >= 0) {
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("`");
    localStringBuilder.append(paramString);
    localStringBuilder.append("`");
    return paramCursor.getColumnIndexOrThrow(localStringBuilder.toString());
  }
  
  public static Cursor onLoadFinished(Cursor paramCursor)
  {
    try
    {
      MatrixCursor localMatrixCursor = new MatrixCursor(paramCursor.getColumnNames(), paramCursor.getCount());
      for (;;)
      {
        boolean bool = paramCursor.moveToNext();
        if (!bool) {
          break;
        }
        Object[] arrayOfObject = new Object[paramCursor.getColumnCount()];
        int i = 0;
        for (;;)
        {
          int j = paramCursor.getColumnCount();
          if (i >= j) {
            break;
          }
          j = paramCursor.getType(i);
          if (j != 0)
          {
            if (j != 1)
            {
              if (j != 2)
              {
                if (j != 3)
                {
                  if (j == 4) {
                    arrayOfObject[i] = paramCursor.getBlob(i);
                  } else {
                    throw new IllegalStateException();
                  }
                }
                else {
                  arrayOfObject[i] = paramCursor.getString(i);
                }
              }
              else {
                arrayOfObject[i] = Double.valueOf(paramCursor.getDouble(i));
              }
            }
            else {
              arrayOfObject[i] = Long.valueOf(paramCursor.getLong(i));
            }
          }
          else {
            arrayOfObject[i] = null;
          }
          i += 1;
        }
        localMatrixCursor.addRow(arrayOfObject);
      }
      paramCursor.close();
      return localMatrixCursor;
    }
    catch (Throwable localThrowable)
    {
      paramCursor.close();
      throw localThrowable;
    }
  }
}
