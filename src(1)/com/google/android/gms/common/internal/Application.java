package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

abstract class Application
  extends Connection
{
  public final Bundle context;
  public final int name;
  
  protected Application(BaseGmsClient paramBaseGmsClient, int paramInt, Bundle paramBundle)
  {
    super(paramBaseGmsClient, Boolean.TRUE);
    name = paramInt;
    context = paramBundle;
  }
  
  protected abstract boolean execute();
  
  protected abstract void expired(ConnectionResult paramConnectionResult);
  
  protected final void log() {}
}
