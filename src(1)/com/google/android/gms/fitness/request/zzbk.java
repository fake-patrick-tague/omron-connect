package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcn;

@ShowFirstParty
@SafeParcelable.Class(creator="UnclaimBleDeviceRequestCreator")
@SafeParcelable.Reserved({1, 4, 1000})
public final class zzbk
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzbk> CREATOR = new zzbn();
  @SafeParcelable.Field(getter="getDeviceAddress", id=2)
  private final String deviceAddress;
  @SafeParcelable.Field(getter="getCallbackBinder", id=3, type="android.os.IBinder")
  private final zzcn zzql;
  
  zzbk(String paramString, IBinder paramIBinder)
  {
    deviceAddress = paramString;
    if (paramIBinder == null) {
      paramString = null;
    } else {
      paramString = zzcm.next(paramIBinder);
    }
    zzql = paramString;
  }
  
  public zzbk(String paramString, zzcn paramZzcn)
  {
    deviceAddress = paramString;
    zzql = paramZzcn;
  }
  
  public final String toString()
  {
    return String.format("UnclaimBleDeviceRequest{%s}", new Object[] { deviceAddress });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, deviceAddress, false);
    Object localObject = zzql;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((IInterface)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 3, (IBinder)localObject, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
