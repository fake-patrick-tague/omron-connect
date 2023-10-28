package com.google.android.gms.cloudmessaging;

import android.os.Build.VERSION;
import android.util.Log;

public final class Loader
  extends ClassLoader
{
  public Loader() {}
  
  protected final Class loadClass(String paramString, boolean paramBoolean)
    throws ClassNotFoundException
  {
    if ("com.google.android.gms.iid.MessengerCompat".equals(paramString))
    {
      if ((Log.isLoggable("CloudMessengerCompat", 3)) || ((Build.VERSION.SDK_INT == 23) && (Log.isLoggable("CloudMessengerCompat", 3)))) {
        Log.d("CloudMessengerCompat", "Using renamed FirebaseIidMessengerCompat class");
      }
      return zzd.class;
    }
    return super.loadClass(paramString, paramBoolean);
  }
}
