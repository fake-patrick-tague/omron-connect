package androidx.fragment.package_11;

import android.util.Log;
import java.io.Writer;

final class LogWriter
  extends Writer
{
  private StringBuilder a = new StringBuilder(128);
  private final String x;
  
  LogWriter(String paramString)
  {
    x = paramString;
  }
  
  private void write()
  {
    if (a.length() > 0)
    {
      Log.d(x, a.toString());
      StringBuilder localStringBuilder = a;
      localStringBuilder.delete(0, localStringBuilder.length());
    }
  }
  
  public void close()
  {
    write();
  }
  
  public void flush()
  {
    write();
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      char c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '\n') {
        write();
      } else {
        a.append(c);
      }
      i += 1;
    }
  }
}
