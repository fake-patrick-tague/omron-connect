package com.google.android.datatransport.api.internal;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.io.Reader;

public abstract class Matrix
{
  public Matrix() {}
  
  public static Matrix read(Reader paramReader)
    throws IOException
  {
    paramReader = new JsonReader(paramReader);
    try
    {
      paramReader.beginObject();
      for (;;)
      {
        boolean bool = paramReader.hasNext();
        if (!bool) {
          break;
        }
        bool = paramReader.nextName().equals("nextRequestWaitMillis");
        if (bool)
        {
          Object localObject = paramReader.peek();
          JsonToken localJsonToken = JsonToken.STRING;
          if (localObject == localJsonToken)
          {
            localObject = toString(Long.parseLong(paramReader.nextString()));
            paramReader.close();
            return localObject;
          }
          localObject = toString(paramReader.nextLong());
          paramReader.close();
          return localObject;
        }
        paramReader.skipValue();
      }
      throw new IOException("Response is missing nextRequestWaitMillis field.");
    }
    catch (Throwable localThrowable)
    {
      paramReader.close();
      throw localThrowable;
    }
  }
  
  static Matrix toString(long paramLong)
  {
    return new GF2Matrix(paramLong);
  }
  
  public abstract long length();
}
