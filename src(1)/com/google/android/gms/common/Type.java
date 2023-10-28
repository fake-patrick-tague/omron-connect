package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.INotificationSideChannel.Stub;
import com.google.android.gms.common.internal.Network;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class Type
  extends INotificationSideChannel.Stub
{
  private final int position;
  
  protected Type(byte[] paramArrayOfByte)
  {
    boolean bool;
    if (paramArrayOfByte.length == 25) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    position = Arrays.hashCode(paramArrayOfByte);
  }
  
  protected static byte[] encode(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("ISO-8859-1");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof Network)) {
        return false;
      }
      paramObject = (Network)paramObject;
      try
      {
        int i = paramObject.getPosition();
        if (i != position) {
          return false;
        }
        paramObject = paramObject.get();
        if (paramObject == null) {
          return false;
        }
        paramObject = ObjectWrapper.unwrap(paramObject);
        paramObject = (byte[])paramObject;
        boolean bool = Arrays.equals(getValue(), paramObject);
        return bool;
      }
      catch (RemoteException paramObject)
      {
        Log.e("GoogleCertificates", "Failed to get Google certificates from remote", paramObject);
      }
    }
    return false;
  }
  
  public final IObjectWrapper get()
  {
    return ObjectWrapper.wrap(getValue());
  }
  
  public final int getPosition()
  {
    return position;
  }
  
  abstract byte[] getValue();
  
  public final int hashCode()
  {
    return position;
  }
}
