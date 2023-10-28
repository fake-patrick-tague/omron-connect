package com.google.android.gms.internal.auth-api-phone;

import android.os.RemoteException;

final class GitOperation
  extends Session
{
  GitOperation(Application paramApplication)
  {
    super(null);
  }
  
  protected final void execute(HttpHost paramHttpHost)
    throws RemoteException
  {
    paramHttpHost.init(new CommonConfigurationImpl.1(this));
  }
}
