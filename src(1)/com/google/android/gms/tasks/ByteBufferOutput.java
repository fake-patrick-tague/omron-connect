package com.google.android.gms.tasks;

import java.util.ArrayDeque;
import java.util.Queue;

final class ByteBufferOutput
{
  private Queue buffer;
  private final java.lang.Object bufferSize = new java.lang.Object();
  private boolean filled;
  
  ByteBufferOutput() {}
  
  public final void flush(Task paramTask)
  {
    java.lang.Object localObject = bufferSize;
    try
    {
      if ((buffer != null) && (!filled))
      {
        filled = true;
        for (;;)
        {
          localObject = bufferSize;
          try
          {
            Object localObject1 = (Object)buffer.poll();
            if (localObject1 == null)
            {
              filled = false;
              return;
            }
            localObject1.run(paramTask);
          }
          catch (Throwable paramTask)
          {
            throw paramTask;
          }
        }
      }
      return;
    }
    catch (Throwable paramTask)
    {
      throw paramTask;
    }
  }
  
  public final void reserve(Object paramObject)
  {
    java.lang.Object localObject = bufferSize;
    try
    {
      if (buffer == null) {
        buffer = new ArrayDeque();
      }
      buffer.add(paramObject);
      return;
    }
    catch (Throwable paramObject)
    {
      throw paramObject;
    }
  }
}
