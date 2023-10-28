package com.google.android.gms.internal.auth;

import android.os.RemoteException;
import com.google.android.gms.auth.util.accounttransfer.DeviceMetaData;
import com.google.android.gms.auth.util.accounttransfer.MapPack;
import com.google.android.gms.auth.util.accounttransfer.VideoItem;
import com.google.android.gms.common.package_12.Status;

public class Section
  extends GeocoderBackend.Stub
{
  public Section() {}
  
  public void close(DeviceMetaData paramDeviceMetaData)
  {
    throw new UnsupportedOperationException();
  }
  
  public void generateKey(byte[] paramArrayOfByte)
  {
    throw new UnsupportedOperationException();
  }
  
  public void onFailure(Status paramStatus)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void setContent(Status paramStatus)
    throws RemoteException
  {
    throw new UnsupportedOperationException();
  }
  
  public final void setContent(Status paramStatus, MapPack paramMapPack)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void setContent(Status paramStatus, VideoItem paramVideoItem)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setId()
  {
    throw new UnsupportedOperationException();
  }
}
