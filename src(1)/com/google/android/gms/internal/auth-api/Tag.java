package com.google.android.gms.internal.auth-api;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.util.identity.SaveAccountLinkingTokenRequest;
import com.google.android.gms.auth.util.identity.SavePasswordRequest;

public final class Tag
  extends Attribute
  implements IInterface
{
  Tag(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.auth.api.identity.internal.ICredentialSavingService");
  }
  
  public final void setAttribute(zbad paramZbad, SaveAccountLinkingTokenRequest paramSaveAccountLinkingTokenRequest)
    throws RemoteException
  {
    Parcel localParcel = getName();
    Cache.get(localParcel, paramZbad);
    Cache.remove(localParcel, paramSaveAccountLinkingTokenRequest);
    setValue(1, localParcel);
  }
  
  public final void setAttribute(zbaf paramZbaf, SavePasswordRequest paramSavePasswordRequest)
    throws RemoteException
  {
    Parcel localParcel = getName();
    Cache.get(localParcel, paramZbaf);
    Cache.remove(localParcel, paramSavePasswordRequest);
    setValue(2, localParcel);
  }
}
