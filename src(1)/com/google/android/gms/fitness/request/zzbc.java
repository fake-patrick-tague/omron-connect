package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcn;

@ShowFirstParty
@SafeParcelable.Class(creator="SessionUnregistrationRequestCreator")
@SafeParcelable.Reserved({3, 1000})
public final class zzbc
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzbc> CREATOR = new zzbe();
  @SafeParcelable.Field(getter="getCallbackBinder", id=2, type="android.os.IBinder")
  private final zzcn zzql;
  @SafeParcelable.Field(getter="getIntent", id=1)
  private final PendingIntent zzrk;
  
  zzbc(PendingIntent paramPendingIntent, IBinder paramIBinder)
  {
    zzrk = paramPendingIntent;
    if (paramIBinder == null) {
      paramPendingIntent = null;
    } else {
      paramPendingIntent = zzcm.next(paramIBinder);
    }
    zzql = paramPendingIntent;
  }
  
  public zzbc(PendingIntent paramPendingIntent, zzcn paramZzcn)
  {
    zzrk = paramPendingIntent;
    zzql = paramZzcn;
  }
  
  public final boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof zzbc)) && (Objects.equal(zzrk, zzrk)));
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { zzrk });
  }
  
  public final String toString()
  {
    return Objects.toStringHelper(this).name("pendingIntent", zzrk).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, zzrk, paramInt, false);
    Object localObject = zzql;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((IInterface)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 2, (IBinder)localObject, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
