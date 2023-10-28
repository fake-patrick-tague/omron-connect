package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.zzaw;
import com.google.android.gms.fitness.request.zzay;
import com.google.android.gms.fitness.request.zzba;
import com.google.android.gms.fitness.request.zzbc;

public final class zzcd
  extends Logger
  implements zzca
{
  zzcd(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
  }
  
  public final void close(SessionInsertRequest paramSessionInsertRequest)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramSessionInsertRequest);
    write(3, localParcel);
  }
  
  public final void close(SessionReadRequest paramSessionReadRequest)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramSessionReadRequest);
    write(4, localParcel);
  }
  
  public final void close(zzay paramZzay)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramZzay);
    write(1, localParcel);
  }
  
  public final void close(zzba paramZzba)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramZzba);
    write(2, localParcel);
  }
  
  public final void close(zzbc paramZzbc)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramZzbc);
    write(6, localParcel);
  }
  
  public final void execute(zzaw paramZzaw)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramZzaw);
    write(5, localParcel);
  }
}
