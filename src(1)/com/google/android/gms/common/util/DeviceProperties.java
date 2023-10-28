package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class DeviceProperties
{
  private static Boolean a;
  private static Boolean commit;
  private static Boolean firstStart;
  private static Boolean in_map;
  private static Boolean isFlashOn;
  private static Boolean isTablet;
  private static Boolean lockscreen;
  private static Boolean mAutoStart;
  private static Boolean mIs24HourMode;
  private static Boolean mSortAscending;
  private static Boolean show_soft_keyboard_now_showing;
  private static Boolean stop_me;
  
  private DeviceProperties() {}
  
  public static boolean init(Resources paramResources)
  {
    boolean bool2 = false;
    if (paramResources == null) {
      return false;
    }
    if (a == null)
    {
      paramResources = paramResources.getConfiguration();
      boolean bool1 = bool2;
      if ((screenLayout & 0xF) <= 3)
      {
        bool1 = bool2;
        if (smallestScreenWidthDp >= 600) {
          bool1 = true;
        }
      }
      a = Boolean.valueOf(bool1);
    }
    return a.booleanValue();
  }
  
  public static boolean isAuto(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    if (stop_me == null)
    {
      boolean bool3 = PlatformVersion.isAtLeastO();
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (paramContext.hasSystemFeature("android.hardware.type.automotive")) {
          bool1 = true;
        }
      }
      stop_me = Boolean.valueOf(bool1);
    }
    return stop_me.booleanValue();
  }
  
  public static boolean isBstar(Context paramContext)
  {
    if (mIs24HourMode == null)
    {
      boolean bool3 = PlatformVersion.isAtLeastR();
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (paramContext.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE")) {
          bool1 = true;
        }
      }
      mIs24HourMode = Boolean.valueOf(bool1);
    }
    return mIs24HourMode.booleanValue();
  }
  
  public static boolean isEnabled(Context paramContext)
  {
    if (lockscreen == null)
    {
      boolean bool3 = paramContext.getPackageManager().hasSystemFeature("android.hardware.type.iot");
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (!bool3) {
        if (paramContext.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      lockscreen = Boolean.valueOf(bool1);
    }
    return lockscreen.booleanValue();
  }
  
  public static boolean isLatchsky(Context paramContext)
  {
    if (isFlashOn == null)
    {
      paramContext = paramContext.getPackageManager();
      boolean bool3 = paramContext.hasSystemFeature("com.google.android.feature.services_updater");
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (paramContext.hasSystemFeature("cn.google.services")) {
          bool1 = true;
        }
      }
      isFlashOn = Boolean.valueOf(bool1);
    }
    return isFlashOn.booleanValue();
  }
  
  public static boolean isPhone(Context paramContext)
  {
    if (show_soft_keyboard_now_showing == null)
    {
      boolean bool3 = isTablet(paramContext);
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (!bool3)
      {
        bool1 = bool2;
        if (!isWearable(paramContext))
        {
          bool1 = bool2;
          if (!isEnabled(paramContext))
          {
            if (firstStart == null) {
              firstStart = Boolean.valueOf(paramContext.getPackageManager().hasSystemFeature("org.chromium.arc"));
            }
            bool1 = bool2;
            if (!firstStart.booleanValue())
            {
              bool1 = bool2;
              if (!isAuto(paramContext))
              {
                bool1 = bool2;
                if (!isTv(paramContext))
                {
                  if (in_map == null) {
                    in_map = Boolean.valueOf(paramContext.getPackageManager().hasSystemFeature("com.google.android.feature.AMATI_EXPERIENCE"));
                  }
                  bool1 = bool2;
                  if (!in_map.booleanValue())
                  {
                    bool1 = bool2;
                    if (!isBstar(paramContext)) {
                      bool1 = true;
                    }
                  }
                }
              }
            }
          }
        }
      }
      show_soft_keyboard_now_showing = Boolean.valueOf(bool1);
    }
    return show_soft_keyboard_now_showing.booleanValue();
  }
  
  public static boolean isSevenInchTablet(Context paramContext)
  {
    return init(paramContext.getResources());
  }
  
  public static boolean isSidewinder(Context paramContext)
  {
    return onCreateView(paramContext);
  }
  
  public static boolean isTablet(Context paramContext)
  {
    return isTablet(paramContext.getResources());
  }
  
  public static boolean isTablet(Resources paramResources)
  {
    boolean bool = false;
    if (paramResources == null) {
      return false;
    }
    if (isTablet == null)
    {
      if ((getConfigurationscreenLayout & 0xF) > 3) {}
      while (init(paramResources))
      {
        bool = true;
        break;
      }
      isTablet = Boolean.valueOf(bool);
    }
    return isTablet.booleanValue();
  }
  
  public static boolean isTv(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    if (commit == null)
    {
      boolean bool3 = paramContext.hasSystemFeature("com.google.android.tv");
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (!bool3)
      {
        bool1 = bool2;
        if (!paramContext.hasSystemFeature("android.hardware.type.television")) {
          if (paramContext.hasSystemFeature("android.software.leanback")) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
      }
      commit = Boolean.valueOf(bool1);
    }
    return commit.booleanValue();
  }
  
  public static boolean isUserBuild()
  {
    int i = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    return "user".equals(Build.TYPE);
  }
  
  public static boolean isWearable(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    if (mSortAscending == null)
    {
      boolean bool3 = PlatformVersion.isAtLeastKitKatWatch();
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (paramContext.hasSystemFeature("android.hardware.type.watch")) {
          bool1 = true;
        }
      }
      mSortAscending = Boolean.valueOf(bool1);
    }
    return mSortAscending.booleanValue();
  }
  
  public static boolean isWearableWithoutPlayStore(Context paramContext)
  {
    return ((isWearable(paramContext)) && (!PlatformVersion.isAtLeastN())) || ((onCreateView(paramContext)) && ((!PlatformVersion.isAtLeastO()) || (PlatformVersion.isAtLeastR())));
  }
  
  public static boolean onCreateView(Context paramContext)
  {
    if (mAutoStart == null)
    {
      boolean bool3 = PlatformVersion.isAtLeastLollipop();
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (paramContext.getPackageManager().hasSystemFeature("cn.google")) {
          bool1 = true;
        }
      }
      mAutoStart = Boolean.valueOf(bool1);
    }
    return mAutoStart.booleanValue();
  }
}
