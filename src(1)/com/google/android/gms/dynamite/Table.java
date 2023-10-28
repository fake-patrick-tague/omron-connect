package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.common.JSONObject;
import com.google.android.gms.internal.common.Log;

public final class Table
  extends Log
  implements IInterface
{
  Table(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
  }
  
  public final IObjectWrapper execute(IObjectWrapper paramIObjectWrapper, String paramString, int paramInt)
    throws RemoteException
  {
    Parcel localParcel = next();
    JSONObject.get(localParcel, paramIObjectWrapper);
    localParcel.writeString(paramString);
    localParcel.writeInt(paramInt);
    paramIObjectWrapper = get(2, localParcel);
    paramString = IObjectWrapper.Stub.asInterface(paramIObjectWrapper.readStrongBinder());
    paramIObjectWrapper.recycle();
    return paramString;
  }
  
  public final int get(IObjectWrapper paramIObjectWrapper, String paramString, boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = next();
    JSONObject.get(localParcel, paramIObjectWrapper);
    localParcel.writeString(paramString);
    JSONObject.append(localParcel, paramBoolean);
    paramIObjectWrapper = get(5, localParcel);
    int i = paramIObjectWrapper.readInt();
    paramIObjectWrapper.recycle();
    return i;
  }
  
  public final IObjectWrapper get(IObjectWrapper paramIObjectWrapper, String paramString, int paramInt)
    throws RemoteException
  {
    Parcel localParcel = next();
    JSONObject.get(localParcel, paramIObjectWrapper);
    localParcel.writeString(paramString);
    localParcel.writeInt(paramInt);
    paramIObjectWrapper = get(4, localParcel);
    paramString = IObjectWrapper.Stub.asInterface(paramIObjectWrapper.readStrongBinder());
    paramIObjectWrapper.recycle();
    return paramString;
  }
  
  public final IObjectWrapper get(IObjectWrapper paramIObjectWrapper1, String paramString, int paramInt, IObjectWrapper paramIObjectWrapper2)
    throws RemoteException
  {
    Parcel localParcel = next();
    JSONObject.get(localParcel, paramIObjectWrapper1);
    localParcel.writeString(paramString);
    localParcel.writeInt(paramInt);
    JSONObject.get(localParcel, paramIObjectWrapper2);
    paramIObjectWrapper1 = get(8, localParcel);
    paramString = IObjectWrapper.Stub.asInterface(paramIObjectWrapper1.readStrongBinder());
    paramIObjectWrapper1.recycle();
    return paramString;
  }
  
  public final IObjectWrapper get(IObjectWrapper paramIObjectWrapper, String paramString, boolean paramBoolean, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = next();
    JSONObject.get(localParcel, paramIObjectWrapper);
    localParcel.writeString(paramString);
    JSONObject.append(localParcel, paramBoolean);
    localParcel.writeLong(paramLong);
    paramIObjectWrapper = get(7, localParcel);
    paramString = IObjectWrapper.Stub.asInterface(paramIObjectWrapper.readStrongBinder());
    paramIObjectWrapper.recycle();
    return paramString;
  }
  
  public final int register()
    throws RemoteException
  {
    Parcel localParcel = get(6, next());
    int i = localParcel.readInt();
    localParcel.recycle();
    return i;
  }
  
  public final int register(IObjectWrapper paramIObjectWrapper, String paramString, boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = next();
    JSONObject.get(localParcel, paramIObjectWrapper);
    localParcel.writeString(paramString);
    JSONObject.append(localParcel, paramBoolean);
    paramIObjectWrapper = get(3, localParcel);
    int i = paramIObjectWrapper.readInt();
    paramIObjectWrapper.recycle();
    return i;
  }
}
