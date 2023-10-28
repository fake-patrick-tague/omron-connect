package com.google.android.gms.analytics.licenses;

import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

public abstract interface Entry
  extends IInterface
{
  public abstract String getContact(String paramString)
    throws RemoteException;
  
  public abstract String getName(String paramString)
    throws RemoteException;
  
  public abstract String getValue(String paramString)
    throws RemoteException;
  
  public abstract List getValue(List paramList)
    throws RemoteException;
}
