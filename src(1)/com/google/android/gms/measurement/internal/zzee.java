package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

public abstract interface zzee
  extends IInterface
{
  public abstract void add(Bundle paramBundle, Item paramItem)
    throws RemoteException;
  
  public abstract void add(Item paramItem)
    throws RemoteException;
  
  public abstract void add(zzaw paramZzaw, String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract void add(zzlc paramZzlc, Item paramItem)
    throws RemoteException;
  
  public abstract void append(zzac paramZzac)
    throws RemoteException;
  
  public abstract void execute(Item paramItem)
    throws RemoteException;
  
  public abstract String get(Item paramItem)
    throws RemoteException;
  
  public abstract List get(Item paramItem, boolean paramBoolean)
    throws RemoteException;
  
  public abstract List get(String paramString1, String paramString2, Item paramItem)
    throws RemoteException;
  
  public abstract List get(String paramString1, String paramString2, String paramString3)
    throws RemoteException;
  
  public abstract List get(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    throws RemoteException;
  
  public abstract List get(String paramString1, String paramString2, boolean paramBoolean, Item paramItem)
    throws RemoteException;
  
  public abstract void get(long paramLong, String paramString1, String paramString2, String paramString3)
    throws RemoteException;
  
  public abstract byte[] get(zzaw paramZzaw, String paramString)
    throws RemoteException;
  
  public abstract void insertItem(Item paramItem)
    throws RemoteException;
  
  public abstract void put(Item paramItem)
    throws RemoteException;
  
  public abstract void put(zzac paramZzac, Item paramItem)
    throws RemoteException;
  
  public abstract void url(zzaw paramZzaw, Item paramItem)
    throws RemoteException;
}
