package com.google.android.gms.internal.auth;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.util.accounttransfer.DeviceMetaData;
import com.google.android.gms.auth.util.accounttransfer.MapPack;
import com.google.android.gms.auth.util.accounttransfer.VideoItem;
import com.google.android.gms.common.package_12.Status;

public abstract interface Detail
  extends IInterface
{
  public abstract void close(DeviceMetaData paramDeviceMetaData)
    throws RemoteException;
  
  public abstract void generateKey(byte[] paramArrayOfByte)
    throws RemoteException;
  
  public abstract void onFailure(Status paramStatus)
    throws RemoteException;
  
  public abstract void setContent(Status paramStatus)
    throws RemoteException;
  
  public abstract void setContent(Status paramStatus, MapPack paramMapPack)
    throws RemoteException;
  
  public abstract void setContent(Status paramStatus, VideoItem paramVideoItem)
    throws RemoteException;
  
  public abstract void setId()
    throws RemoteException;
}
