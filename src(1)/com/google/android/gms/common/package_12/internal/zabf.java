package com.google.android.gms.common.package_12.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.package_12.Attribute;

public abstract interface zabf
{
  public abstract BaseImplementation.ApiMethodImpl add(BaseImplementation.ApiMethodImpl paramApiMethodImpl);
  
  public abstract void add(int paramInt);
  
  public abstract boolean add();
  
  public abstract void execute();
  
  public abstract BaseImplementation.ApiMethodImpl pollQueue(BaseImplementation.ApiMethodImpl paramApiMethodImpl);
  
  public abstract void refreshAdapter();
  
  public abstract void update(Bundle paramBundle);
  
  public abstract void write(ConnectionResult paramConnectionResult, Attribute paramAttribute, boolean paramBoolean);
}
