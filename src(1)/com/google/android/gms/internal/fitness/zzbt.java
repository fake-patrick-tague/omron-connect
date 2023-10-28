package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.Artist;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.Language;

public final class zzbt
  extends Logger
  implements zzbq
{
  zzbt(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
  }
  
  public final void close(Artist paramArtist)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramArtist);
    write(2, localParcel);
  }
  
  public final void close(DataTypeCreateRequest paramDataTypeCreateRequest)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramDataTypeCreateRequest);
    write(1, localParcel);
  }
  
  public final void execute(Language paramLanguage)
    throws RemoteException
  {
    Parcel localParcel = getVersion();
    Log.close(localParcel, paramLanguage);
    write(22, localParcel);
  }
}
