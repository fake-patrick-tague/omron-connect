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
import com.google.android.gms.internal.fitness.zzcn;

@Deprecated
@ShowFirstParty
@SafeParcelable.Class(creator="StopBleScanRequestCreator")
@SafeParcelable.Reserved({3, 1000})
public final class zzbg
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzbg> CREATOR = new zzbj();
  @SafeParcelable.Field(getter="getCallbackBinder", id=2, type="android.os.IBinder")
  private final zzcn zzql;
  @SafeParcelable.Field(getter="getBleScanCallbackBinder", id=1, type="android.os.IBinder")
  private final zzad zzsn;
  
  zzbg(IBinder paramIBinder1, IBinder paramIBinder2) {}
  
  public zzbg(zzad paramZzad, zzcn paramZzcn)
  {
    zzsn = paramZzad;
    zzql = paramZzcn;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeIBinder(paramParcel, 1, zzsn.asBinder(), false);
    Object localObject = zzql;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((IInterface)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 2, (IBinder)localObject, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
