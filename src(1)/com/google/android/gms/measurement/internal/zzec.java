package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzbm;
import com.google.android.gms.internal.measurement.zzbo;
import java.util.List;

public final class zzec
  extends zzbm
  implements zzee
{
  zzec(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
  }
  
  public final void add(Bundle paramBundle, Item paramItem)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.get(localParcel, paramBundle);
    zzbo.get(localParcel, paramItem);
    add(19, localParcel);
  }
  
  public final void add(Item paramItem)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.get(localParcel, paramItem);
    add(6, localParcel);
  }
  
  public final void add(zzaw paramZzaw, String paramString1, String paramString2)
    throws RemoteException
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void add(zzlc paramZzlc, Item paramItem)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.get(localParcel, paramZzlc);
    zzbo.get(localParcel, paramItem);
    add(2, localParcel);
  }
  
  public final void append(zzac paramZzac)
    throws RemoteException
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void execute(Item paramItem)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.get(localParcel, paramItem);
    add(20, localParcel);
  }
  
  public final String get(Item paramItem)
    throws RemoteException
  {
    Object localObject = next();
    zzbo.get((Parcel)localObject, paramItem);
    paramItem = get(11, (Parcel)localObject);
    localObject = paramItem.readString();
    paramItem.recycle();
    return localObject;
  }
  
  public final List get(Item paramItem, boolean paramBoolean)
    throws RemoteException
  {
    Object localObject = next();
    zzbo.get((Parcel)localObject, paramItem);
    zzbo.append((Parcel)localObject, paramBoolean);
    paramItem = get(7, (Parcel)localObject);
    localObject = paramItem.createTypedArrayList(zzlc.CREATOR);
    paramItem.recycle();
    return localObject;
  }
  
  public final List get(String paramString1, String paramString2, Item paramItem)
    throws RemoteException
  {
    Parcel localParcel = next();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzbo.get(localParcel, paramItem);
    paramString1 = get(16, localParcel);
    paramString2 = paramString1.createTypedArrayList(zzac.CREATOR);
    paramString1.recycle();
    return paramString2;
  }
  
  public final List get(String paramString1, String paramString2, String paramString3)
    throws RemoteException
  {
    paramString1 = next();
    paramString1.writeString(null);
    paramString1.writeString(paramString2);
    paramString1.writeString(paramString3);
    paramString1 = get(17, paramString1);
    paramString2 = paramString1.createTypedArrayList(zzac.CREATOR);
    paramString1.recycle();
    return paramString2;
  }
  
  public final List get(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    throws RemoteException
  {
    paramString1 = next();
    paramString1.writeString(null);
    paramString1.writeString(paramString2);
    paramString1.writeString(paramString3);
    zzbo.append(paramString1, paramBoolean);
    paramString1 = get(15, paramString1);
    paramString2 = paramString1.createTypedArrayList(zzlc.CREATOR);
    paramString1.recycle();
    return paramString2;
  }
  
  public final List get(String paramString1, String paramString2, boolean paramBoolean, Item paramItem)
    throws RemoteException
  {
    Parcel localParcel = next();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzbo.append(localParcel, paramBoolean);
    zzbo.get(localParcel, paramItem);
    paramString1 = get(14, localParcel);
    paramString2 = paramString1.createTypedArrayList(zzlc.CREATOR);
    paramString1.recycle();
    return paramString2;
  }
  
  public final void get(long paramLong, String paramString1, String paramString2, String paramString3)
    throws RemoteException
  {
    Parcel localParcel = next();
    localParcel.writeLong(paramLong);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    localParcel.writeString(paramString3);
    add(10, localParcel);
  }
  
  public final byte[] get(zzaw paramZzaw, String paramString)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.get(localParcel, paramZzaw);
    localParcel.writeString(paramString);
    paramZzaw = get(9, localParcel);
    paramString = paramZzaw.createByteArray();
    paramZzaw.recycle();
    return paramString;
  }
  
  public final void insertItem(Item paramItem)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.get(localParcel, paramItem);
    add(4, localParcel);
  }
  
  public final void put(Item paramItem)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.get(localParcel, paramItem);
    add(18, localParcel);
  }
  
  public final void put(zzac paramZzac, Item paramItem)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.get(localParcel, paramZzac);
    zzbo.get(localParcel, paramItem);
    add(12, localParcel);
  }
  
  public final void url(zzaw paramZzaw, Item paramItem)
    throws RemoteException
  {
    Parcel localParcel = next();
    zzbo.get(localParcel, paramZzaw);
    zzbo.get(localParcel, paramItem);
    add(1, localParcel);
  }
}
