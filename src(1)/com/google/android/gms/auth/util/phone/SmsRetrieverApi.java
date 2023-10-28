package com.google.android.gms.auth.util.phone;

import com.google.android.gms.tasks.Task;

public abstract interface SmsRetrieverApi
{
  public abstract Task startSmsRetriever();
}
