package com.alivecor.mapsforge.record;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build.VERSION;
import androidx.core.content.ContextCompat;
import androidx.core.package_10.ActivityCompat;
import androidx.fragment.package_11.Fragment;
import androidx.fragment.package_11.FragmentActivity;
import com.alivecor.mapsforge.core.model.c;

public class PermissionsUtil
{
  public static final int REQUEST_CODE_FINE_LOCATION_PERMISSION = 89;
  public static final int REQUEST_CODE_RECORD_AUDIO_PERMISSION = 88;
  public static final int REQUEST_CODE_RECORD_PERMISSION = 89;
  
  public PermissionsUtil() {}
  
  public static void askForFineLocation(Fragment paramFragment)
  {
    paramFragment.requestPermissions(new String[] { "android.permission.ACCESS_FINE_LOCATION" }, 89);
  }
  
  public static void askForRecordAudio(Fragment paramFragment)
  {
    paramFragment.requestPermissions(new String[] { "android.permission.RECORD_AUDIO" }, 88);
  }
  
  public static void askForRecordAudio(FragmentActivity paramFragmentActivity)
  {
    ActivityCompat.execute(paramFragmentActivity, new String[] { "android.permission.RECORD_AUDIO" }, 88);
  }
  
  public static int[] checkSelfPermissionBulk(Context paramContext, String[] paramArrayOfString)
  {
    int[] arrayOfInt = new int[paramArrayOfString.length];
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      arrayOfInt[i] = ContextCompat.checkSelfPermission(paramContext, paramArrayOfString[i]);
      i += 1;
    }
    return arrayOfInt;
  }
  
  public static boolean hasCoarseLocation(Context paramContext)
  {
    return ContextCompat.checkSelfPermission(paramContext, "android.permission.ACCESS_COARSE_LOCATION") == 0;
  }
  
  public static boolean hasFineLocation(Context paramContext)
  {
    return ContextCompat.checkSelfPermission(paramContext, "android.permission.ACCESS_FINE_LOCATION") == 0;
  }
  
  public static boolean hasRecordAudio(Context paramContext)
  {
    return ContextCompat.checkSelfPermission(paramContext, "android.permission.RECORD_AUDIO") == 0;
  }
  
  public static boolean hasRecordPermissions(Context paramContext, c paramC)
  {
    if (paramC != c.deviceList) {
      return hasRecordAudio(paramContext);
    }
    return true;
  }
  
  public static Boolean isBleEnabled(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 31)
    {
      boolean bool;
      if ((ContextCompat.checkSelfPermission(paramContext, "android.permission.BLUETOOTH_CONNECT") == 0) && (ContextCompat.checkSelfPermission(paramContext, "android.permission.BLUETOOTH_SCAN") == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      return Boolean.valueOf(bool);
    }
    return Boolean.valueOf(((BluetoothManager)paramContext.getSystemService("bluetooth")).getAdapter().isEnabled());
  }
  
  public static void requestRecordEkgPermissions(Fragment paramFragment, c paramC)
  {
    if (paramC == c.deviceList)
    {
      paramC = new String[2];
      paramC[0] = "android.permission.RECORD_AUDIO";
      paramC[1] = "android.permission.ACCESS_FINE_LOCATION";
    }
    else
    {
      paramC = new String[1];
      paramC[0] = "android.permission.RECORD_AUDIO";
    }
    paramFragment.requestPermissions(paramC, 89);
  }
}
