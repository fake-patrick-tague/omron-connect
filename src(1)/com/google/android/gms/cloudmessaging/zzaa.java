package com.google.android.gms.cloudmessaging;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.cloudmessaging.Launcher.17;

final class zzaa
  extends Launcher.17
{
  zzaa(Task paramTask, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    Task.doInBackground(this$0, paramMessage);
  }
}
