package com.google.android.gms.common.data;

import android.content.ContentValues;
import java.util.HashMap;

final class Coordinates
  extends DataHolder.Builder
{
  Coordinates(String[] paramArrayOfString, String paramString)
  {
    super(paramArrayOfString, null, null);
  }
  
  public final DataHolder.Builder setList(HashMap paramHashMap)
  {
    throw new UnsupportedOperationException("Cannot add data to empty builder");
  }
  
  public final DataHolder.Builder withRow(ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException("Cannot add data to empty builder");
  }
}
