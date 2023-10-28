package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
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
import com.google.android.gms.fitness.data.IDeathCallback_0_8;
import com.google.android.gms.fitness.data.IDeathCallback_0_8.Stub;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcn;

@ShowFirstParty
@SafeParcelable.Class(creator="SensorUnregistrationRequestCreator")
@SafeParcelable.Reserved({4, 1000})
public final class zzar
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzar> CREATOR = new zzas();
  @SafeParcelable.Field(getter="getCallbackBinder", id=3, type="android.os.IBinder")
  private final zzcn zzql;
  @SafeParcelable.Field(getter="getIntent", id=2)
  private final PendingIntent zzrk;
  @SafeParcelable.Field(getter="getListenerBinder", id=1, type="android.os.IBinder")
  private final IDeathCallback_0_8 zzrt;
  
  zzar(IBinder paramIBinder1, PendingIntent paramPendingIntent, IBinder paramIBinder2)
  {
    Object localObject = null;
    if (paramIBinder1 == null) {
      paramIBinder1 = null;
    } else {
      paramIBinder1 = IDeathCallback_0_8.Stub.asInterface(paramIBinder1);
    }
    zzrt = paramIBinder1;
    zzrk = paramPendingIntent;
    if (paramIBinder2 == null) {
      paramIBinder1 = localObject;
    } else {
      paramIBinder1 = zzcm.next(paramIBinder2);
    }
    zzql = paramIBinder1;
  }
  
  public zzar(IDeathCallback_0_8 paramIDeathCallback_0_8, PendingIntent paramPendingIntent, zzcn paramZzcn)
  {
    zzrt = paramIDeathCallback_0_8;
    zzrk = paramPendingIntent;
    zzql = paramZzcn;
  }
  
  public final String toString()
  {
    return String.format("SensorUnregistrationRequest{%s}", new Object[] { zzrt });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    Object localObject1 = zzrt;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((IInterface)localObject1).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 1, (IBinder)localObject1, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, zzrk, paramInt, false);
    localObject1 = zzql;
    if (localObject1 == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = ((IInterface)localObject1).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 3, (IBinder)localObject1, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
