package com.google.android.gms.internal.auth-api;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;

public final class zbay
{
  public static final int sound;
  
  static
  {
    int j = Build.VERSION.SDK_INT;
    int i = 33554432;
    if (j < 31) {
      if (j >= 30)
      {
        String str = Build.VERSION.CODENAME;
        if ((str.length() == 1) && (str.charAt(0) >= 'S') && (str.charAt(0) <= 'Z')) {}
      }
      else
      {
        i = 0;
      }
    }
    sound = i;
  }
  
  public static PendingIntent notify(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2)
  {
    return PendingIntent.getActivity(paramContext, 2000, paramIntent, paramInt2);
  }
}
