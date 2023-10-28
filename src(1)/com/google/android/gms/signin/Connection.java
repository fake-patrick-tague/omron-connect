package com.google.android.gms.signin;

import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.package_12.Api.Client;
import com.google.android.gms.signin.internal.Logger;

public abstract interface Connection
  extends Api.Client
{
  public abstract void add();
  
  public abstract void add(IAccountAccessor paramIAccountAccessor, boolean paramBoolean);
  
  public abstract void add(Logger paramLogger);
  
  public abstract void connect();
}
