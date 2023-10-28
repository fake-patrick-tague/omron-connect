package com.google.android.gms.internal.base;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;

public final class f
{
  public static final int c;
  
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
    c = i;
  }
  
  public static PendingIntent a(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2)
  {
    return PendingIntent.getActivity(paramContext, paramInt1, paramIntent, paramInt2);
  }
}
