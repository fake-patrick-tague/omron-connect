package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.internal.base.Log;
import com.google.android.gms.internal.base.Transport;

public final class BitSet
  extends Transport
  implements IInterface
{
  BitSet(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.signin.internal.ISignInService");
  }
  
  public final void add(Entry paramEntry, Logger paramLogger)
    throws RemoteException
  {
    Parcel localParcel = next();
    Log.writeValue(localParcel, paramEntry);
    Log.get(localParcel, paramLogger);
    register(12, localParcel);
  }
  
  public final void remove(int paramInt)
    throws RemoteException
  {
    Parcel localParcel = next();
    localParcel.writeInt(paramInt);
    register(7, localParcel);
  }
  
  public final void remove(IAccountAccessor paramIAccountAccessor, int paramInt, boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = next();
    Log.get(localParcel, paramIAccountAccessor);
    localParcel.writeInt(paramInt);
    Log.writeFloat(localParcel, paramBoolean);
    register(9, localParcel);
  }
}
