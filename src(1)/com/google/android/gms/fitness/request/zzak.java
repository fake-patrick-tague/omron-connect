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
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzcc;
import com.google.android.gms.internal.fitness.zzcf;

@ShowFirstParty
@SafeParcelable.Class(creator="ListSubscriptionsRequestCreator")
@SafeParcelable.Reserved({3, 1000})
public final class zzak
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzak> CREATOR = new zzaj();
  @SafeParcelable.Field(getter="getDataType", id=1)
  private final DataType zzkp;
  @SafeParcelable.Field(getter="getCallbackBinder", id=2, type="android.os.IBinder")
  private final zzcc zzro;
  
  zzak(DataType paramDataType, IBinder paramIBinder)
  {
    zzkp = paramDataType;
    if (paramIBinder == null) {
      paramDataType = null;
    } else {
      paramDataType = zzcf.asInterface(paramIBinder);
    }
    zzro = paramDataType;
  }
  
  public zzak(DataType paramDataType, zzcc paramZzcc)
  {
    zzkp = paramDataType;
    zzro = paramZzcc;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, zzkp, paramInt, false);
    Object localObject = zzro;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((IInterface)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 2, (IBinder)localObject, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
