package com.google.android.gms.drm.identifier;

import android.util.Log;
import com.google.android.gms.internal.ads_identifier.IfHeader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class Money
{
  public static final void parse(String paramString)
  {
    try
    {
      try
      {
        IfHeader.logIllegalState(263);
        Object localObject = new URL(paramString).openConnection();
        localObject = (HttpURLConnection)localObject;
        try
        {
          i = ((HttpURLConnection)localObject).getResponseCode();
          if ((i < 200) || (i >= 300))
          {
            j = String.valueOf(paramString).length();
            StringBuilder localStringBuilder1 = new StringBuilder(j + 65);
            localStringBuilder1.append("Received non-success response code ");
            localStringBuilder1.append(i);
            localStringBuilder1.append(" from pinging URL: ");
            localStringBuilder1.append(paramString);
            Log.w("HttpUrlPinger", localStringBuilder1.toString());
          }
          ((HttpURLConnection)localObject).disconnect();
          IfHeader.logIllegalState();
          return;
        }
        catch (Throwable localThrowable)
        {
          ((HttpURLConnection)localObject).disconnect();
          throw localThrowable;
        }
        str = ((Exception)localIOException).getMessage();
      }
      catch (Throwable paramString)
      {
        break label307;
      }
      catch (RuntimeException localRuntimeException) {}catch (IOException localIOException) {}
      i = String.valueOf(paramString).length();
      j = String.valueOf(str).length();
      localStringBuilder2 = new StringBuilder(i + 27 + j);
      localStringBuilder2.append("Error while pinging URL: ");
      localStringBuilder2.append(paramString);
      localStringBuilder2.append(". ");
      localStringBuilder2.append(str);
      Log.w("HttpUrlPinger", localStringBuilder2.toString(), (Throwable)localIOException);
      IfHeader.logIllegalState();
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      String str = localIndexOutOfBoundsException.getMessage();
      int i = String.valueOf(paramString).length();
      int j = String.valueOf(str).length();
      StringBuilder localStringBuilder2 = new StringBuilder(i + 32 + j);
      localStringBuilder2.append("Error while parsing ping URL: ");
      localStringBuilder2.append(paramString);
      localStringBuilder2.append(". ");
      localStringBuilder2.append(str);
      Log.w("HttpUrlPinger", localStringBuilder2.toString(), localIndexOutOfBoundsException);
      IfHeader.logIllegalState();
      return;
    }
    label307:
    IfHeader.logIllegalState();
    throw paramString;
  }
}
