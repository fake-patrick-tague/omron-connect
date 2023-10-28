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
import com.google.android.gms.internal.fitness.zzem;
import com.google.android.gms.internal.fitness.zzep;

@Deprecated
@ShowFirstParty
@SafeParcelable.Class(creator="ListClaimedBleDevicesRequestCreator")
@SafeParcelable.Reserved({2, 1000})
public final class zzai
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzai> CREATOR = new zzah();
  @SafeParcelable.Field(getter="getCallbackBinder", id=1, type="android.os.IBinder")
  private final zzem zzrn;
  
  zzai(IBinder paramIBinder)
  {
    zzrn = zzep.asInterface(paramIBinder);
  }
  
  public zzai(zzem paramZzem)
  {
    zzrn = paramZzem;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeIBinder(paramParcel, 1, zzrn.asBinder(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
