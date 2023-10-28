package com.google.android.gms.common.package_12.internal;

import android.os.Bundle;

final class b
  implements Runnable
{
  b(Main paramMain, LifecycleCallback paramLifecycleCallback, String paramString) {}
  
  public final void run()
  {
    Object localObject = this$0;
    if (Main.access$getState((Main)localObject) > 0)
    {
      LifecycleCallback localLifecycleCallback = mCallback;
      if (Main.access$getCursor((Main)localObject) != null) {
        localObject = Main.access$getCursor((Main)localObject).getBundle(mMenu);
      } else {
        localObject = null;
      }
      localLifecycleCallback.onCreate((Bundle)localObject);
    }
    if (Main.access$getState(this$0) >= 2) {
      mCallback.onStart();
    }
    if (Main.access$getState(this$0) >= 3) {
      mCallback.onResume();
    }
    if (Main.access$getState(this$0) >= 4) {
      mCallback.onStop();
    }
    if (Main.access$getState(this$0) >= 5) {
      mCallback.onDestroy();
    }
  }
}
