package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.Command;
import com.google.android.gms.common.ModuleInformation;
import com.google.android.gms.common.Task;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.JSONObject;
import com.google.android.gms.internal.common.Log;

public final class zzad
  extends Log
  implements zzaf
{
  zzad(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
  }
  
  public final Task execute(ModuleInformation paramModuleInformation)
    throws RemoteException
  {
    Object localObject = next();
    JSONObject.write((Parcel)localObject, paramModuleInformation);
    paramModuleInformation = get(6, (Parcel)localObject);
    localObject = (Task)JSONObject.get(paramModuleInformation, Task.CREATOR);
    paramModuleInformation.recycle();
    return localObject;
  }
  
  public final boolean execute()
    throws RemoteException
  {
    Parcel localParcel = get(9, next());
    boolean bool = JSONObject.get(localParcel);
    localParcel.recycle();
    return bool;
  }
  
  public final boolean execute(Command paramCommand, IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = next();
    JSONObject.write(localParcel, paramCommand);
    JSONObject.get(localParcel, paramIObjectWrapper);
    paramCommand = get(5, localParcel);
    boolean bool = JSONObject.get(paramCommand);
    paramCommand.recycle();
    return bool;
  }
  
  public final boolean init()
    throws RemoteException
  {
    Parcel localParcel = get(7, next());
    boolean bool = JSONObject.get(localParcel);
    localParcel.recycle();
    return bool;
  }
  
  public final Task update(ModuleInformation paramModuleInformation)
    throws RemoteException
  {
    Object localObject = next();
    JSONObject.write((Parcel)localObject, paramModuleInformation);
    paramModuleInformation = get(8, (Parcel)localObject);
    localObject = (Task)JSONObject.get(paramModuleInformation, Task.CREATOR);
    paramModuleInformation.recycle();
    return localObject;
  }
}
