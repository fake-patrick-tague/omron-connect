package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzbn;
import com.google.android.gms.internal.measurement.zzbo;

public abstract class zzed
  extends zzbn
  implements zzee
{
  public zzed()
  {
    super("com.google.android.gms.measurement.internal.IMeasurementService");
  }
  
  protected final boolean getFromLocationName(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    Object localObject3;
    boolean bool;
    switch (paramInt1)
    {
    default: 
      break;
    case 3: 
    case 8: 
      return false;
    case 20: 
      localObject1 = (Item)zzbo.get(paramParcel1, Item.CREATOR);
      zzbo.writeString(paramParcel1);
      execute((Item)localObject1);
      paramParcel2.writeNoException();
      break;
    case 19: 
      localObject1 = (Bundle)zzbo.get(paramParcel1, Bundle.CREATOR);
      localObject2 = (Item)zzbo.get(paramParcel1, Item.CREATOR);
      zzbo.writeString(paramParcel1);
      add((Bundle)localObject1, (Item)localObject2);
      paramParcel2.writeNoException();
      break;
    case 18: 
      localObject1 = (Item)zzbo.get(paramParcel1, Item.CREATOR);
      zzbo.writeString(paramParcel1);
      put((Item)localObject1);
      paramParcel2.writeNoException();
      break;
    case 17: 
      localObject1 = paramParcel1.readString();
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      zzbo.writeString(paramParcel1);
      paramParcel1 = get((String)localObject1, (String)localObject2, (String)localObject3);
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(paramParcel1);
      break;
    case 16: 
      localObject1 = paramParcel1.readString();
      localObject2 = paramParcel1.readString();
      localObject3 = (Item)zzbo.get(paramParcel1, Item.CREATOR);
      zzbo.writeString(paramParcel1);
      paramParcel1 = get((String)localObject1, (String)localObject2, (Item)localObject3);
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(paramParcel1);
      break;
    case 15: 
      localObject1 = paramParcel1.readString();
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      bool = zzbo.a(paramParcel1);
      zzbo.writeString(paramParcel1);
      paramParcel1 = get((String)localObject1, (String)localObject2, (String)localObject3, bool);
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(paramParcel1);
      break;
    case 14: 
      localObject1 = paramParcel1.readString();
      localObject2 = paramParcel1.readString();
      bool = zzbo.a(paramParcel1);
      localObject3 = (Item)zzbo.get(paramParcel1, Item.CREATOR);
      zzbo.writeString(paramParcel1);
      paramParcel1 = get((String)localObject1, (String)localObject2, bool, (Item)localObject3);
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(paramParcel1);
      break;
    case 13: 
      localObject1 = (zzac)zzbo.get(paramParcel1, zzac.CREATOR);
      zzbo.writeString(paramParcel1);
      append((zzac)localObject1);
      paramParcel2.writeNoException();
      break;
    case 12: 
      localObject1 = (zzac)zzbo.get(paramParcel1, zzac.CREATOR);
      localObject2 = (Item)zzbo.get(paramParcel1, Item.CREATOR);
      zzbo.writeString(paramParcel1);
      put((zzac)localObject1, (Item)localObject2);
      paramParcel2.writeNoException();
      break;
    case 11: 
      localObject1 = (Item)zzbo.get(paramParcel1, Item.CREATOR);
      zzbo.writeString(paramParcel1);
      paramParcel1 = get((Item)localObject1);
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      break;
    case 10: 
      long l = paramParcel1.readLong();
      localObject1 = paramParcel1.readString();
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      zzbo.writeString(paramParcel1);
      get(l, (String)localObject1, (String)localObject2, (String)localObject3);
      paramParcel2.writeNoException();
      break;
    case 9: 
      localObject1 = (zzaw)zzbo.get(paramParcel1, zzaw.CREATOR);
      localObject2 = paramParcel1.readString();
      zzbo.writeString(paramParcel1);
      paramParcel1 = get((zzaw)localObject1, (String)localObject2);
      paramParcel2.writeNoException();
      paramParcel2.writeByteArray(paramParcel1);
      break;
    case 7: 
      localObject1 = (Item)zzbo.get(paramParcel1, Item.CREATOR);
      bool = zzbo.a(paramParcel1);
      zzbo.writeString(paramParcel1);
      paramParcel1 = get((Item)localObject1, bool);
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(paramParcel1);
      break;
    case 6: 
      localObject1 = (Item)zzbo.get(paramParcel1, Item.CREATOR);
      zzbo.writeString(paramParcel1);
      add((Item)localObject1);
      paramParcel2.writeNoException();
      break;
    case 5: 
      localObject1 = (zzaw)zzbo.get(paramParcel1, zzaw.CREATOR);
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      zzbo.writeString(paramParcel1);
      add((zzaw)localObject1, (String)localObject2, (String)localObject3);
      paramParcel2.writeNoException();
      break;
    case 4: 
      localObject1 = (Item)zzbo.get(paramParcel1, Item.CREATOR);
      zzbo.writeString(paramParcel1);
      insertItem((Item)localObject1);
      paramParcel2.writeNoException();
      break;
    case 2: 
      localObject1 = (zzlc)zzbo.get(paramParcel1, zzlc.CREATOR);
      localObject2 = (Item)zzbo.get(paramParcel1, Item.CREATOR);
      zzbo.writeString(paramParcel1);
      add((zzlc)localObject1, (Item)localObject2);
      paramParcel2.writeNoException();
      break;
    }
    Object localObject1 = (zzaw)zzbo.get(paramParcel1, zzaw.CREATOR);
    Object localObject2 = (Item)zzbo.get(paramParcel1, Item.CREATOR);
    zzbo.writeString(paramParcel1);
    url((zzaw)localObject1, (Item)localObject2);
    paramParcel2.writeNoException();
    return true;
  }
}
