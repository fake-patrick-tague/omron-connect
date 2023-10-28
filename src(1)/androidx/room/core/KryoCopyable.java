package androidx.room.core;

import android.os.Build.VERSION;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class KryoCopyable
{
  public static void copy(ReadableByteChannel paramReadableByteChannel, FileChannel paramFileChannel)
    throws IOException
  {
    try
    {
      int i = Build.VERSION.SDK_INT;
      if (i > 23)
      {
        paramFileChannel.transferFrom(paramReadableByteChannel, 0L, Long.MAX_VALUE);
      }
      else
      {
        InputStream localInputStream = Channels.newInputStream(paramReadableByteChannel);
        OutputStream localOutputStream = Channels.newOutputStream(paramFileChannel);
        byte[] arrayOfByte = new byte['?'];
        for (;;)
        {
          i = localInputStream.read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          localOutputStream.write(arrayOfByte, 0, i);
        }
      }
      paramFileChannel.force(false);
      paramReadableByteChannel.close();
      paramFileChannel.close();
      return;
    }
    catch (Throwable localThrowable)
    {
      paramReadableByteChannel.close();
      paramFileChannel.close();
      throw localThrowable;
    }
  }
}
