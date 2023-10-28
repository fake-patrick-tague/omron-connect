package com.google.android.gms.common.internal;

import android.content.Intent;
import androidx.fragment.package_11.Fragment;

final class IntegerPreference
  extends Preference
{
  IntegerPreference(Intent paramIntent, Fragment paramFragment, int paramInt) {}
  
  public final void onClick()
  {
    Intent localIntent = intent;
    if (localIntent != null) {
      context.startActivityForResult(localIntent, value);
    }
  }
}
