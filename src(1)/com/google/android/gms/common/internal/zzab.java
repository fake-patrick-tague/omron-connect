package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.IExtensionHost.Stub;
import com.google.android.gms.internal.common.JSONObject;

public abstract class zzab
  extends IExtensionHost.Stub
  implements IGmsCallbacks
{
  public zzab()
  {
    super("com.google.android.gms.common.internal.IGmsCallbacks");
  }
  
  protected final boolean execute(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    Object localObject1;
    Object localObject2;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3) {
          return false;
        }
        paramInt1 = paramParcel1.readInt();
        localObject1 = paramParcel1.readStrongBinder();
        localObject2 = (MediaDescriptionCompat)JSONObject.get(paramParcel1, MediaDescriptionCompat.CREATOR);
        JSONObject.writeValue(paramParcel1);
        read(paramInt1, (IBinder)localObject1, (MediaDescriptionCompat)localObject2);
      }
      else
      {
        paramInt1 = paramParcel1.readInt();
        localObject1 = (Bundle)JSONObject.get(paramParcel1, Bundle.CREATOR);
        JSONObject.writeValue(paramParcel1);
        init(paramInt1, (Bundle)localObject1);
      }
    }
    else
    {
      paramInt1 = paramParcel1.readInt();
      localObject1 = paramParcel1.readStrongBinder();
      localObject2 = (Bundle)JSONObject.get(paramParcel1, Bundle.CREATOR);
      JSONObject.writeValue(paramParcel1);
      onPostInitComplete(paramInt1, (IBinder)localObject1, (Bundle)localObject2);
    }
    paramParcel2.writeNoException();
    return true;
  }
}
