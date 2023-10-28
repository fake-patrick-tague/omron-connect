package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcn;

@SafeParcelable.Class(creator="DataUpdateListenerUnregistrationRequestCreator")
@SafeParcelable.Reserved({1000})
public final class Site
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzv> CREATOR = new DiscreteSeekBar.CustomState.1();
  @SafeParcelable.Field(getter="getCallbackBinder", id=2, type="android.os.IBinder")
  private final zzcn zzql;
  @SafeParcelable.Field(getter="getIntent", id=1)
  private final PendingIntent zzrk;
  
  public Site(PendingIntent paramPendingIntent, IBinder paramIBinder)
  {
    zzrk = paramPendingIntent;
    if (paramIBinder == null) {
      paramPendingIntent = null;
    } else {
      paramPendingIntent = zzcm.next(paramIBinder);
    }
    zzql = paramPendingIntent;
  }
  
  public final boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof Site)) && (Objects.equal(zzrk, zzrk)));
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { zzrk });
  }
  
  public final String toString()
  {
    return "DataUpdateListenerUnregistrationRequest";
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
