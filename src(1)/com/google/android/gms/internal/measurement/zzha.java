package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.UserManager;
import android.util.Log;

public final class zzha
{
  private static volatile boolean active = hasExternalCacheDir() ^ true;
  private static UserManager current;
  
  private zzha() {}
  
  public static boolean hasExternalCacheDir()
  {
    return Build.VERSION.SDK_INT >= 24;
  }
  
  public static boolean send(Context paramContext)
  {
    if (hasExternalCacheDir()) {
      if (active) {
        return false;
      }
    }
    for (;;)
    {
      try
      {
        if (active) {
          return false;
        }
        i = 1;
        if (i > 2) {
          break label156;
        }
        if (current == null) {
          current = (UserManager)paramContext.getSystemService(UserManager.class);
        }
        UserManager localUserManager = current;
        int j;
        if (localUserManager == null)
        {
          j = 1;
        }
        else
        {
          try
          {
            boolean bool = localUserManager.isUserUnlocked();
            if (!bool)
            {
              bool = localUserManager.isUserRunning(Process.myUserHandle());
              if (bool) {
                break label156;
              }
            }
            i = 1;
          }
          catch (NullPointerException localNullPointerException)
          {
            Log.w("DirectBootUtils", "Failed to check if user is unlocked.", localNullPointerException);
            current = null;
            i += 1;
          }
          continue;
          j = i;
          if (i != 0)
          {
            current = null;
            j = i;
          }
        }
        if (j != 0) {
          active = true;
        }
        if (j == 0) {
          return true;
        }
      }
      catch (Throwable paramContext)
      {
        throw paramContext;
      }
      return false;
      label156:
      int i = 0;
    }
  }
}
