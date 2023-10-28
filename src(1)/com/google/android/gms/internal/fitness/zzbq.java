package com.google.android.gms.internal.fitness;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.Artist;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.Language;

public abstract interface zzbq
  extends IInterface
{
  public abstract void close(Artist paramArtist)
    throws RemoteException;
  
  public abstract void close(DataTypeCreateRequest paramDataTypeCreateRequest)
    throws RemoteException;
  
  public abstract void execute(Language paramLanguage)
    throws RemoteException;
}
