package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.fragment.package_11.Fragment;
import com.google.android.gms.common.package_12.internal.LifecycleFragment;

public abstract class Preference
  implements DialogInterface.OnClickListener
{
  public Preference() {}
  
  public static Preference inflate(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    return new Item(paramIntent, paramActivity, paramInt);
  }
  
  public static Preference inflate(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    return new IntegerPreference(paramIntent, paramFragment, paramInt);
  }
  
  public static Preference onResult(LifecycleFragment paramLifecycleFragment, Intent paramIntent, int paramInt)
  {
    return new MainActivity.9(paramIntent, paramLifecycleFragment, 2);
  }
  
  protected abstract void onClick();
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str;
    try
    {
      onClick();
      paramDialogInterface.dismiss();
      return;
    }
    catch (Throwable localThrowable) {}catch (ActivityNotFoundException localActivityNotFoundException)
    {
      str = "Failed to start resolution intent.";
      boolean bool = Build.FINGERPRINT.contains("generic");
      if (true == bool) {
        str = "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.";
      }
      Log.e("DialogRedirect", str, localActivityNotFoundException);
      paramDialogInterface.dismiss();
      return;
    }
    paramDialogInterface.dismiss();
    throw str;
  }
}
