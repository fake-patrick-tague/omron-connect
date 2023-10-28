package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

final class Item
  extends Preference
{
  Item(Intent paramIntent, Activity paramActivity, int paramInt) {}
  
  public final void onClick()
  {
    Intent localIntent = i;
    if (localIntent != null) {
      activity.startActivityForResult(localIntent, requestCode);
    }
  }
}
