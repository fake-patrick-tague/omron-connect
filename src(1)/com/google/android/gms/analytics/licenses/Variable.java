package com.google.android.gms.analytics.licenses;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.oss_licenses.GameController;
import com.google.android.gms.internal.oss_licenses.Version;
import java.util.List;

public final class Variable
  extends Version
  implements Entry
{
  Variable(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.oss.licenses.IOSSLicenseService");
  }
  
  public final String getContact(String paramString)
    throws RemoteException
  {
    Object localObject = get();
    ((Parcel)localObject).writeString(paramString);
    paramString = get(4, (Parcel)localObject);
    localObject = paramString.readString();
    paramString.recycle();
    return localObject;
  }
  
  public final String getName(String paramString)
    throws RemoteException
  {
    Object localObject = get();
    ((Parcel)localObject).writeString(paramString);
    paramString = get(3, (Parcel)localObject);
    localObject = paramString.readString();
    paramString.recycle();
    return localObject;
  }
  
  public final String getValue(String paramString)
    throws RemoteException
  {
    Object localObject = get();
    ((Parcel)localObject).writeString(paramString);
    paramString = get(2, (Parcel)localObject);
    localObject = paramString.readString();
    paramString.recycle();
    return localObject;
  }
  
  public final List getValue(List paramList)
    throws RemoteException
  {
    Object localObject = get();
    ((Parcel)localObject).writeList(paramList);
    paramList = get(5, (Parcel)localObject);
    localObject = GameController.get(paramList);
    paramList.recycle();
    return localObject;
  }
}
