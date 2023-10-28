package com.google.android.gms.internal.fitness;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;

public abstract class zzeu
  extends IExtensionHost.Stub
  implements zzev
{
  public zzeu()
  {
    super("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
  }
  
  protected final boolean getFromLocation(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3) {
          return false;
        }
        addUrls((zzet)Log.unmarshall(paramParcel1, zzet.CREATOR), zzcm.next(paramParcel1.readStrongBinder()));
        return true;
      }
      addUrls((FitnessSensorServiceRequest)Log.unmarshall(paramParcel1, FitnessSensorServiceRequest.CREATOR), zzcm.next(paramParcel1.readStrongBinder()));
      return true;
    }
    cd((zzer)Log.unmarshall(paramParcel1, zzer.CREATOR), zzbg.asInterface(paramParcel1.readStrongBinder()));
    return true;
  }
}
