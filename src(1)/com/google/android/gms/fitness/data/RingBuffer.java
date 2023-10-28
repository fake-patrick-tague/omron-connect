package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DeviceProperties;

public final class RingBuffer
{
  private static String zzmw;
  private static int zzmx;
  
  public static int add(Context paramContext)
  {
    if (zzmx == -1) {
      if (DeviceProperties.isWearable(paramContext))
      {
        zzmx = 3;
      }
      else
      {
        boolean bool = DeviceProperties.isTv(paramContext);
        int j = 0;
        if ((!bool) && (!DeviceProperties.isAuto(paramContext)))
        {
          int i;
          if ((DeviceProperties.isTablet(paramContext.getResources())) && (!start(paramContext))) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0)
          {
            zzmx = 2;
          }
          else
          {
            paramContext = Build.PRODUCT;
            i = j;
            if (!TextUtils.isEmpty(paramContext))
            {
              i = j;
              if (paramContext.startsWith("glass_")) {
                i = 1;
              }
            }
            if (i != 0) {
              zzmx = 6;
            } else {
              zzmx = 1;
            }
          }
        }
        else
        {
          zzmx = 0;
        }
      }
    }
    return zzmx;
  }
  
  public static String get(Context paramContext)
  {
    String str = zzmw;
    if (str != null) {
      return str;
    }
    paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    zzmw = paramContext;
    return paramContext;
  }
  
  private static boolean start(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSystemService("phone");
      paramContext = (TelephonyManager)paramContext;
      paramContext = Preconditions.checkNotNull(paramContext);
      paramContext = (TelephonyManager)paramContext;
      int i = paramContext.getPhoneType();
      return i != 0;
    }
    catch (Resources.NotFoundException paramContext)
    {
      Log.e("Fitness", "Unable to determine type of device, assuming phone.", paramContext);
    }
    return true;
  }
}
