package com.google.android.gms.common.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.Command;
import com.google.android.gms.common.ModuleInformation;
import com.google.android.gms.common.Task;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract interface zzaf
  extends IInterface
{
  public abstract Task execute(ModuleInformation paramModuleInformation)
    throws RemoteException;
  
  public abstract boolean execute()
    throws RemoteException;
  
  public abstract boolean execute(Command paramCommand, IObjectWrapper paramIObjectWrapper)
    throws RemoteException;
  
  public abstract boolean init()
    throws RemoteException;
  
  public abstract Task update(ModuleInformation paramModuleInformation)
    throws RemoteException;
}
